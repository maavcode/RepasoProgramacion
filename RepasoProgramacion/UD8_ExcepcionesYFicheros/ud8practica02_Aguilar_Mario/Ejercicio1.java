package ud8practica02_Aguilar_Mario;

import java.io.*;
import java.util.*;

public class Ejercicio1 {

    public static void main(String[] args) {
        File xml = new File("Archivos\\biblioteca.xml");

        int contadorLibros = 0;
        double sumaNotas = 0;

        try (Scanner sc = new Scanner(xml)) {
            FileWriter fw = null;

            while (sc.hasNextLine()) {
                String linea = sc.nextLine().trim(); // Copia la linea en un string

                if (linea.contains("<LIBRO>")) {
                    String titulo = "";
                    StringBuilder cuerpo = new StringBuilder();

                    while (sc.hasNextLine()) {
                        linea = sc.nextLine().trim();

                        if (linea.contains("<TITULO>")) {
                            titulo = eliminarEtiquetas(linea, "TITULO") + ".txt";
                            File archivoLibro = new File("Archivos\\" + titulo);

                            if (archivoLibro.createNewFile()) {
                                System.out.println("Archivo creado: " + archivoLibro.getPath());
                            } else {
                                System.out.println("Archivo ya existe, se sobrescribirá: " + archivoLibro.getPath());
                            }

                            fw = new FileWriter(archivoLibro, false);
                        }

                        else if (linea.contains("<NOTA>")) {
                            String notaStr = eliminarEtiquetas(linea, "NOTA").replace("\"", "");
                            sumaNotas += Double.parseDouble(notaStr);
                            cuerpo.append("NOTA: ").append(notaStr).append("\n");
                        }

                        else if (linea.contains("</LIBRO>")) {
                            if (fw != null) {
                                fw.write(cuerpo.toString());
                                fw.close();
                                fw = null;
                            }
                            contadorLibros++;
                            break;
                        }

                        else {
                            if (!linea.isEmpty()) {
                                String etiqueta = linea.substring(1, linea.indexOf('>'));
                                String dato = eliminarEtiquetas(linea, etiqueta);
                                cuerpo.append(etiqueta).append(": ").append(dato).append("\n");
                            }
                        }
                    }
                }
            }

            double media = sumaNotas / contadorLibros;
            System.out.println("Libros procesados:" + contadorLibros);
            System.out.println(String.format("Nota media: %.2f", media));
        } catch (Exception e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }

    public static String eliminarEtiquetas(String linea, String etiqueta) {
        return linea.replace("<" + etiqueta + ">", "").replace("</" + etiqueta + ">", "").trim();
    }
}
