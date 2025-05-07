package Menus;

import java.util.*;

public class MenuSimple_v2 {

	public static Scanner sc = new Scanner(System.in);

	public static void main() {
		// Declaracion de variables
		boolean encendido = true; // Esta en true ya que empieza el programa
		int programa = 0;
		// Menu interactivo
		while (encendido) {
			//
			try {
				// Preguntamos programa
				programa = menu(); // Muestra los programas y obliga al usuario a elegir uno
			} catch (InputMismatchException e) { // Tipo incorrecto
				System.err.println("Tipo insertado incorrectamente");
				sc.nextLine(); // Salto de linea
			} catch (Exception e) { // Programa inexistente
				System.err.println(e.getMessage());
			}
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

	public static int menu() throws Exception { // Devuelve un programa
		// Muestra los programas y devuelve el numero de programas
		int programas = mostrarProgramas();
		// Pregunta programa
		System.out.println("Que programa quieres realizar?");
		int programa = sc.nextInt();
		sc.nextLine(); // Salto de linea
		if (programa <= 0 || programa > programas) { // Programas es igual al numero de programas que existen
			// Lanza la excepcion para cuando el programa no es correcto
			throw new Exception("Opcion no valida");
		}
		return programa; // Devuelve el programa
	}

	public static int mostrarProgramas() { // Muestra una lista de programas
		// Creo el Array que contiene los programas
		String[] programas = { "---PROGRAMAS---", "1-", "2-", "3-", "4-", "5-", "6-" };
		// Muestro el Array que tiene los programas
		for (int i = 0; i < programas.length; i++) {
			System.out.println(programas[i]);
		}
		return programas.length - 1; // Devuelvo el numero de programas que hay
	}

}
