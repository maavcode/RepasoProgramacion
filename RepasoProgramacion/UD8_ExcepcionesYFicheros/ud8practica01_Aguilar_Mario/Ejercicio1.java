package ud8practica01_Aguilar_Mario;

import java.io.*;
import java.util.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            // Leer y ordenar entrada1.txt
            ArrayList<String> alumnos = leerYOrdenarArchivo("Archivos\\entrada1.txt", "NIA;NOMBRE;APELLIDO");
            escribirArchivo("Archivos\\salida1.txt", alumnos);
            
            // Leer y ordenar entrada2.txt
            ArrayList<String> asignaturas = leerYOrdenarArchivo("Archivos\\entrada2.txt", "NIA;ASIGNATURA");
            escribirArchivo("Archivos\\salida2.txt", asignaturas);
            
            // Realizar cruce
            cruzarArchivos("Archivos\\salida1.txt", "Archivos\\salida2.txt", "Archivos\\salida3.txt");
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static ArrayList<String> leerYOrdenarArchivo(String nombreArchivo, String cabeceraEsperada) throws IOException {
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

    private static void escribirArchivo(String nombreArchivo, ArrayList<String> lineas) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (String linea : lineas) {
                pw.println(linea);
            }
        }
    }

    private static void cruzarArchivos(String alumnosFile, String asignaturasFile, String salidaFile) throws IOException {
        try (Scanner scAlumnos = new Scanner(new File(alumnosFile));
             Scanner scAsignaturas = new Scanner(new File(asignaturasFile));
             PrintWriter pw = new PrintWriter(new FileWriter(salidaFile))) {
            
            // Saltar cabeceras
            scAlumnos.nextLine();
            scAsignaturas.nextLine();
            
            // Escribir nueva cabecera
            pw.println("NIA;NOMBRE;APELLIDO;ASIGNATURA");
            
            // Leer primer registro de cada archivo
            String alumno = scAlumnos.hasNextLine() ? scAlumnos.nextLine() : null;
            String asignatura = scAsignaturas.hasNextLine() ? scAsignaturas.nextLine() : null;
            
            while (alumno != null && asignatura != null) {
                String[] datosAlumno = alumno.split(";");
                String[] datosAsignatura = asignatura.split(";");
                
                int niaAlumno = Integer.parseInt(datosAlumno[0]);
                int niaAsignatura = Integer.parseInt(datosAsignatura[0]);
                
                if (niaAlumno == niaAsignatura) {
                    // Escribir línea combinada
                    pw.printf("%s;%s%n", alumno, datosAsignatura[1]);
                    asignatura = scAsignaturas.hasNextLine() ? scAsignaturas.nextLine() : null;
                } else if (niaAlumno < niaAsignatura) {
                    alumno = scAlumnos.hasNextLine() ? scAlumnos.nextLine() : null;
                } else {
                    asignatura = scAsignaturas.hasNextLine() ? scAsignaturas.nextLine() : null;
                }
            }
        }
    }
}
