package ud8practica01_Aguilar_Mario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio3 {
	
	public static void main(String[] args) {
		// Realizar cruce
        try {
			cruzarArchivos("Archivos\\salida1.txt", "Archivos\\salida2.txt", "Archivos\\salida3.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void cruzarArchivos(String alumnosFile, String asignaturasFile, String salidaFile) throws IOException {
        try (Scanner scAlumnos = new Scanner(new File(alumnosFile));
             Scanner scAsignaturas = new Scanner(new File(asignaturasFile));
             FileWriter fw = new FileWriter(salidaFile)) {
            
            // Saltar cabeceras
            scAlumnos.nextLine();
            scAsignaturas.nextLine();
            
            // Escribir nueva cabecera
            fw.write("NIA;NOMBRE;APELLIDO;ASIGNATURA\n");
            
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
                    fw.write(alumno + ";" + datosAsignatura[1] + "\n");
                    
                    if (scAsignaturas.hasNextLine()) {
                        asignatura = scAsignaturas.nextLine();
                    } else {
                        asignatura = null;
                    }
                } 
                else if (niaAlumno < niaAsignatura) {
                    if (scAlumnos.hasNextLine()) {
                        alumno = scAlumnos.nextLine();
                    } else {
                        alumno = null;
                    }
                } 
                else {
                    if (scAsignaturas.hasNextLine()) {
                        asignatura = scAsignaturas.nextLine();
                    } else {
                        asignatura = null;
                    }
                }
            }
        }
    }
}
