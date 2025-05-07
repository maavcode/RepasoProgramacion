package ud8practica01_Aguilar_Mario;

import java.io.*;
import java.util.*;

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
		Scanner scAlumnos = new Scanner(new File(alumnosFile));
		Scanner scAsignaturas = new Scanner(new File(asignaturasFile));
		FileWriter fw = new FileWriter(salidaFile);
		try {
            
            // Saltar cabeceras
            scAlumnos.nextLine();
            scAsignaturas.nextLine();
            
            // Escribir nueva cabecera
            fw.write("NIA;NOMBRE;APELLIDO;ASIGNATURA\n");
            
            // Leer primer registro de cada archivo
            String alumno = scAlumnos.nextLine();
            String asignatura = scAsignaturas.nextLine();
            
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
		} finally {
	        // Cerrar el FileWriter
	        try {
	            fw.close();
	        } catch (IOException e) {
	            System.err.println("Error al cerrar el archivo");
	        }
	    }
    }
}
