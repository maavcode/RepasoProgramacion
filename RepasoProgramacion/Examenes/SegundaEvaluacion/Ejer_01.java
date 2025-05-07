package SegundaEvaluacion;

import java.util.*;

public class Ejer_01 {

	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Pizza> pizzas = new ArrayList<>();

	public static void main(String[] args) {
		// Menu interactivo
		boolean encendido = true;
		while (encendido) {
			// Preguntamos programa
			int programa = preguntarPrograma();
			switch (programa) {
			case 1:
				crearPizza();
				break;
			case 2:
				servirPizza();
				break;
			case 3:
				encendido = false;
				sc.close();
				break;
			default:
				break;
			}

		}
	}

	public static int preguntarPrograma() { // Devuelve un programa
		mostrarProgramas();
		System.out.println("Que programa quieres realizar?");
		int programa = sc.nextInt();
		return programa;
	}

	public static void mostrarProgramas() { // Muestra una lista de programas
		// Creo el Array que contiene los programas
		String[] programas = { "---PROGRAMAS---", "1-Crear pizza", "2-Servir pizza", "3-Salir" };
		// Muestro el Array que tiene los programas
		for (int i = 0; i < programas.length; i++) {
			System.out.println(programas[i]);
		}
	}

	public static void crearPizza() {
		Pizza pizza = preguntarPizza();
	}

	public static Pizza preguntarPizza() { // Devuelve una pizza
		sc.nextLine(); // Elimino el salto de linea
		// Pregunto las propiedades necesarias de la pizza
		String tamanyo = "";
		String tipo = "";
		boolean bien = false;
		while (!bien) { // Me aseguro de que el usuario lo ponga bien
			System.out.println("Que tamanyo quieres que tenga la pizza (mediana o familiar)");
			tamanyo = sc.nextLine();
			if (tamanyo.toLowerCase().equals("mediana") | tamanyo.toLowerCase().equals("familiar")) {

				bien = true;
			} else {
				System.out.println("Escribiste mas el tamanyo, debe ser mediana o familiar");
			}
		}
		bien = false;
		while (!bien) { // Me aseguro de que el usuario lo ponga bien
			System.out.println("De que tipo quieres que sea tu pizza (margarita, cuatro quesos o funghi)");
			tipo = sc.nextLine();
			if (tipo.toLowerCase().equals("margarita") | tipo.toLowerCase().equals("cuatro quesos")
					| tipo.toLowerCase().equals("funghi")) {

				bien = true;
			} else {
				System.out.println("Escribiste mas el tipo, debe ser margarita, cuatro quesos o funghi");
			}
		}
		Pizza pizza = new Pizza(tamanyo, tipo); // Creo la pizza con los valores otorgados
		pizzas.add(pizza);
		System.out.println("Pizza creada con exito!!");
		return pizza;
	}

	public static void servirPizza() {
		sc.nextLine(); // Elimino el salto de linea
		// Pregunto el tipo de la pizza que quiere servir
		System.out.println("Dime el tipo de la pizza quieres servir?");
		String tipo = sc.nextLine();
		for (Pizza pizza : pizzas) { // Itero el arrayList de pizzas para encontrar la pedida
			if (tipo.toLowerCase().equals(pizza.getTipo())) {
				pizza.servir(); // Sirve la pizza
				System.out.println("Pizza pedida con exito");
			}
		}
	}

}
