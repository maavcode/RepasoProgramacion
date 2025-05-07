package ud8practica02_Aguilar_Mario;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        File xml = new File("Archivos\\biblioteca.xml");

        int contadorLibros = 0;
        double sumaNotas = 0;

        try (Scanner sc = new Scanner(xml)) {
            FileWriter fw = null;

            while (sc.hasNextLine()) {
                String linea = sc.nextLine().trim();

                if (linea.startsWith("<LIBRO>")) {
                    String titulo = "";
                    StringBuilder cuerpo = new StringBuilder();

                    while (sc.hasNextLine()) {
                        linea = sc.nextLine().trim();

                        if (linea.startsWith("<TITULO>")) {
                            titulo = eliminarEtiquetas(linea, "TITULO") + ".txt";
                            File archivoLibro = new File("Archivos\\" + titulo);

                            if (archivoLibro.createNewFile()) {
                                System.out.println("Archivo creado: " + archivoLibro.getPath());
                            } else {
                                System.out.println("Archivo ya existe, se sobrescribirá: " + archivoLibro.getPath());
                            }

                            fw = new FileWriter(archivoLibro, false);
                        }

                        else if (linea.startsWith("<NOTA>")) {
                            String notaStr = eliminarEtiquetas(linea, "NOTA").replace("\"", "");
                            sumaNotas += Double.parseDouble(notaStr);
                            cuerpo.append("NOTA: ").append(notaStr).append("\n");
                        }

                        else if (linea.startsWith("</LIBRO>")) {
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

            double media = contadorLibros > 0 ? sumaNotas / contadorLibros : 0;
            System.out.printf("Libros procesados: %d\nNota media: %.2f\n", contadorLibros, media);

        } catch (Exception e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }

    public static String eliminarEtiquetas(String linea, String etiqueta) {
        return linea.replace("<" + etiqueta + ">", "").replace("</" + etiqueta + ">", "").trim();
    }
}
