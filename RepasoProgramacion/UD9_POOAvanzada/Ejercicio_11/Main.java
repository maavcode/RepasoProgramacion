package Ejercicio_11;

import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner (System.in);
	
	public static void main(String [] args) {
		iniciar();
	}
	
	public static void iniciar() {
		Entrenador entrenador = new Entrenador("Zidane", 10);
		System.out.println(entrenador.getInfo());
		
		Velocista velocista1 = new Velocista("Usain Bolt", "Jamaica", 37.5);
		Velocista velocista2 = new Velocista("Yohan Blake", "Jamaica", 32.8);
		
		Gimnasta gimnasta = new Gimnasta("Simon Byles", "USA", "Barra fija", entrenador);
		
		System.out.println(velocista1.getInfo());
		System.out.println(velocista2.getInfo());
		
		System.out.println(gimnasta.getInfo());
	}

}
