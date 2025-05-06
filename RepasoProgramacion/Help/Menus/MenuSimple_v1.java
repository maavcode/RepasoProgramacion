package Menus;

import java.util.*;

public class MenuSimple_v1 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Menu interactivo
		boolean encendido = true;
		while (encendido) {
			// Preguntamos programa
			int programa = preguntarPrograma(); // Muestra los programas y obliga al usuario a elegir uno 
			switch (programa) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				encendido = false;
				break;
			default:
				break;
			}
		}
	}
	
	public static int preguntarPrograma() { // Devuelve un programa
		// Muestra los programas
		mostrarProgramas();
		// Pregunta programa
		System.out.println("Que programa quieres realizar?");
		int programa = sc.nextInt();
		sc.nextLine(); // Salto de linea
		return programa;
	}
	
	public static void mostrarProgramas() { // Muestra una lista de programas
		// Creo el Array que contiene los programas
		String [] programas = {
				"---PROGRAMAS---",
				"1-",
				"2-",
				"3-",
				"4-",
				"5-",
				"6-"
		};
		// Muestro el Array que tiene los programas
		for (int i = 0; i < programas.length; i++) {
			System.out.println(programas[i]);
		}
	}
	
	
}
