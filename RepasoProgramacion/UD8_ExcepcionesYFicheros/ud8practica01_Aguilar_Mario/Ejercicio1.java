package ud8practica01_Aguilar_Mario;

import java.io.*;
import java.util.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            // Leer y ordenar entrada1.txt
            ArrayList<String> alumnos = leerYOrdenarArchivo("Archivos\\entrada1.txt", "NIA;NOMBRE;APELLIDO");
            escribirArchivo("Archivos\\salida1.txt", alumnos);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static ArrayList<String> leerYOrdenarArchivo(String nombreArchivo, String cabeceraEsperada) throws IOException {
        ArrayList<String> lineas = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(nombreArchivo))) {
            if (sc.hasNextInt()) {
                int numFilas = sc.nextInt();
                sc.nextLine(); // Consumir salto de línea
                
                // Verificar cabecera
                String cabecera = sc.nextLine();
                if (!cabecera.contains(cabeceraEsperada)) {
                    throw new IOException("Cabecera incorrecta en " + nombreArchivo);
                }
                
                // Leer datos
                for (int i = 0; i < numFilas && sc.hasNextLine(); i++) {
                    lineas.add(sc.nextLine());
                }
            }
        }
        
        // Ordenar por NIA (primer campo)
        Collections.sort(lineas);
        return lineas;
    }

    public static void escribirArchivo(String nombreArchivo, ArrayList<String> lineas) throws IOException {
        try (FileWriter fw = new FileWriter(nombreArchivo)) {
            for (String linea : lineas) {
                fw.write(linea);
            }
        }
    }   
}
