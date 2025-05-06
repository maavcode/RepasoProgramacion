package Ejercicio_02;

import java.util.*;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Pez> peces = new ArrayList<>();

	public static void main(String[] args) {
		iniciar();
	}

	public static void iniciar() {
		// Menu interactivo
		boolean encendido = true;
		while (encendido) {
			// Preguntamos programa
			int programa = preguntarPrograma();
			switch (programa) {
			case 1:
				crearPezGlobo();
				break;
			case 2:
				crearPezEspada();
				break;
			case 3:
				mostrarPeces();
				break;
			case 4:
				hacerMetodos();
				break;
			case 5:
				encendido = false;
				break;
			default:
				break;
			}
		}
	}

	public static int preguntarPrograma() { // Devuelve un programa
		mostrarProgramas(); // Muestro
		System.out.println("Que programa quieres realizar?");
		int programa = sc.nextInt();
		return programa; // Devuelvo
	}

	public static void mostrarProgramas() { // Muestra una lista de programas
		// Creo el Array que contiene los programas
		String[] programas = { "---PROGRAMAS---", "1-Crear pez globo", "2-Crear pez espada",
				"3-Mostrar peces y caracteristicas", "4-Hacer metodos", "5-Salir" };
		// Muestro el Array que tiene los programas
		for (int i = 0; i < programas.length; i++) {
			System.out.println(programas[i]);
		}
	}

	public static void crearPezGlobo() {
		PezGlobo pezGlobo = preguntarPezGlobo(); // Pregunto
		peces.add(pezGlobo); // Añado a la lista de peces
	}

	public static PezGlobo preguntarPezGlobo() {
		// Pregunto
		System.out.println("Escamas: ");
		int escamas = sc.nextInt();
		System.out.println("Peso: ");
		int peso = sc.nextInt();
		System.out.println("Toxinas: ");
		int toxinas = sc.nextInt();
		// Creo
		PezGlobo pezGlobo = new PezGlobo("pez globo", escamas, peso, toxinas);
		return pezGlobo;
	}

	public static void crearPezEspada() {
		PezEspada pezEspada = preguntarPezEspada(); // Pregunto
		peces.add(pezEspada); // Añado a la lista de peces
	}

	public static PezEspada preguntarPezEspada() {
		// Pregunto
		System.out.println("Escamas: ");
		int escamas = sc.nextInt();
		System.out.println("Peso: ");
		int peso = sc.nextInt();
		System.out.println("Lugar de pesca: ");
		String lugarPesca = sc.nextLine();
		// Creo
		PezEspada pezEspada = new PezEspada("pez espada", escamas, peso, lugarPesca);
		return pezEspada;
	}

	public static void mostrarPeces() {
		for (Pez pez : peces) {
			switch (pez.getNombre()) {
			case "pez globo":
				pez.mostrarCaracteristicas();
				System.out.println("Rango peligrosidad: ");
				break;
			case "pez espada":
				pez.mostrarCaracteristicas();
				System.out.println("Lugar de pesca: ");
				break;
			default:
				break;
			}
		}
	}

	public static int preguntarPez() {
		boolean encendido = true;
		boolean existe = false;
		int ID = -1;
		while (encendido) { // Me aseguro de que este bien el ID
			System.out.println("Que pez quieres elejir?");
			ID = sc.nextInt();
			for (Pez pez : peces) {
				if (ID == pez.getID()) {
					existe = true;
				}
			}
			if (existe) {
				encendido = false;
			} else {
				System.out.println("No existe, introduce uno que exista.");
			}
		}
		return ID; // Devuelvo el ID

	}

	public static void hacerMetodos() {
		mostrarMetodos();
		int metodo = preguntarPrograma();
		switch (metodo) {
		case 1:
			mostrarPeces();

			break;
		case 2:
			mostrarPeces();

			break;
		case 3:
			mostrarPeces();

			break;

		default:
			break;
		}
	}

	public static void mostrarMetodos() {
		// Creo el Array que contiene los programas
		String[] programas = { "---PROGRAMAS---", "1-Obtener tipo segun el peso",
				"2-Obtener rango de peligrosidad de un pez globo", "3-Obtener veracidad de un pez espada" };
		// Muestro el Array que tiene los programas
		for (int i = 0; i < programas.length; i++) {
			System.out.println(programas[i]);
		}
	}

}
