package Ejercicio_04;

import java.util.*;

public class Main {

	public static ArrayList <Contenido> contenidos = new ArrayList<>();
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Menu interactivo
		boolean encendido = true;
		while (encendido) {
			// Preguntamos programa
			int programa = preguntarPrograma(); 
			switch (programa) {
			case 1:
				darAltaPelicula();
				break;
			case 2:
				darAltaSerie();
				break;
			case 3:
				verContenidoEspecifico();
				break;
			case 4:
				listarContenido();
				break;
			case 5:
				listarContenidoPendiente();
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
		mostrarProgramas();
		System.out.println("Que programa quieres realizar?");
		int programa = sc.nextInt();
		sc.nextLine(); // Elimino salto de linea
		return programa;
	}
	
	public static void mostrarProgramas() { // Muestra una lista de programas
		// Creo el Array que contiene los programas
		String [] programas = {
				"---PROGRAMAS---",
				"1-Dar de alta una pelicula",
				"2-Dar de alta una serie",
				"3-Ver un contenido",
				"4-Listar Contenido",
				"5-Listar contenido pendiente por ver",
				"6-Salir"
		};
		// Muestro el Array que tiene los programas
		for (int i = 0; i < programas.length; i++) {
			System.out.println(programas[i]);
		}
	}
	
	public static void darAltaPelicula() {
		Pelicula pelicula = preguntarPelicula();
		contenidos.add(pelicula);
	}
	
	public static Pelicula preguntarPelicula() {
		System.out.println("Titulo ");
		String titulo = sc.nextLine();
		System.out.println("Productora");
		String productora = sc.nextLine();
		System.out.println("Anyo publicacion");
		int anyoPublicacion = sc.nextInt();
		System.out.println("Numero nominaciones a los socar");
		int numNominaciones = sc.nextInt();
		System.out.println("Numero oscars ganados");
		int numGanados = sc.nextInt();
		Pelicula pelicula = new Pelicula(titulo, productora, anyoPublicacion, numNominaciones, numGanados);
		return pelicula;
	}
	
	public static void darAltaSerie() {
		Serie serie = preguntarSerie();
		contenidos.add(serie);
	}
	
	public static Serie preguntarSerie() {
		System.out.println("Titulo ");
		String titulo = sc.nextLine();
		System.out.println("Productora");
		String productora = sc.nextLine();
		System.out.println("Anyo publicacion");
		int anyoPublicacion = sc.nextInt();
		System.out.println("Num temporadas");
		int numTemporadas = sc.nextInt();
		System.out.println("Esta finalizado? (s/n)");
		boolean finalizado = false;
		if (sc.nextLine().toLowerCase().equals("s")) {
			finalizado = true;
		} else {
			System.out.println("Me lo tomare como un no");
			finalizado = false;
		}
		Serie serie = new Serie(titulo, productora, anyoPublicacion, numTemporadas, finalizado);
		return serie;
	}
	
	public static void verContenidoEspecifico() {
		mostrarContenidos();
		boolean encendido = true;
		while (encendido) {
			int ID = preguntarID();
			encendido = verificarID(ID);
			if (encendido) {
				System.out.println("Te equivocaste");
			}else { // Muestro el contenido
				Iterator <Contenido> iter = contenidos.iterator();
				while (iter.hasNext()) {
					Contenido contenido = iter.next();
					if (contenido.getID()==ID) {
						contenido.ver();
					}
				}				
			}
		}
	}
	
	public static int preguntarID() {
		System.out.println("Que ID quieres ver?");
		int ID = sc.nextInt();
		return ID;
	}
	
	public static boolean verificarID(int ID) {
		boolean encendido = false;
		Iterator <Contenido> iter = contenidos.iterator();
		while (iter.hasNext()) {
			Contenido contenido = iter.next();
			if (contenido.getID()==ID) {
				encendido = false;
				break; // sale del while
			}
		}
		return encendido;
	}
	
	public static void mostrarContenidos() {
		Iterator <Contenido> iter = contenidos.iterator();
		while (iter.hasNext()) {
			Contenido contenido = iter.next();
			contenido.mostrarContenido();
			System.out.println("----------------");
		}
	}
	
	public static void mostrarContenidosPendiente() {
		Iterator <Contenido> iter = contenidos.iterator();
		while (iter.hasNext()) {
			Contenido contenido = iter.next();
			if (!contenido.getVisto()) {
				contenido.mostrarContenido();
				System.out.println("----------------");
			}
		}
	}
	
	public static void listarContenido() {
		mostrarContenidos();
	}
	
	public static void listarContenidoPendiente() {
		mostrarContenidosPendiente();
	}

}
