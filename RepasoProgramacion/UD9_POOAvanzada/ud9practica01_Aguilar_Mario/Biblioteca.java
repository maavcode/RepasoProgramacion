package ud9practica01_Aguilar_Mario;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
	public static ArrayList<Usuarios> listaUsuarios = new ArrayList<>();
	public static ArrayList<Publicaciones> listaPublicaciones = new ArrayList<>();
	public static ArrayList<Prestamo> listaPrestamos = new ArrayList<>();

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// Menu interactivo
		boolean encendido = true;
		while (encendido) {
			// Preguntamos programa
			int programa = preguntarPrograma(); // Muestra y pregunta el programa a realizar
			switch (programa) {
			case 1:
				registrarUsuario();
				break;
			case 2:
				agregarPublicacion();
				break;
			case 3:
				mostrarUsuarios();
				break;
			case 4:
				mostrarPublicaciones();
				break;
			case 5:
				realizarPrestamo();
				break;
			case 6:
				devolverPrestamo();
				break;
			case 7:
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
		sc.nextLine(); // Salto de linea
		return programa;
	}

	public static void mostrarProgramas() { // Muestra una lista de programas
		// Creo el Array que contiene los programas
		String[] programas = { "---PROGRAMAS---", "1- Registrar usuario", "2- Agregar publicacion",
				"3- Mostrar usuarios", "4- Mostrar publicaciones disponibles", "5- Realizar prestamo",
				"6- Devolver prestamo", "7- Salir" };
		// Muestro el Array que tiene los programas
		for (int i = 0; i < programas.length; i++) {
			System.out.println(programas[i]);
		}
	}

	public static void registrarUsuario() {
		Usuarios usuario = preguntarUsuario(); // Crea el usuario
		listaUsuarios.add(usuario); // Anyade el usuario a la lista de usuarios
	}

	public static Usuarios preguntarUsuario() { // Devuelve un usuario
		// Pregunto datos
		System.out.println("---Introduce los siguientes datos---");
		System.out.println("Nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Apellidos: ");
		String apellidos = sc.nextLine();
		System.out.println("DNI: ");
		String dni = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		return new Usuarios(dni, nombre, apellidos, email); // Devuelvo un usuario
	}

	public static void agregarPublicacion() {
		boolean bien = false;
		while (!bien) {
			System.out.println("Quieres agregar un libro o una revista?");
			String tipoPublicacion = sc.nextLine();
			if (tipoPublicacion.toLowerCase().equals("libro")) { // LIBRO
				Libro libro = preguntarLibro(); // Pregunto el libro
				listaPublicaciones.add(libro); // Anyado el libro creado a la lista de publicaciones
				bien = true;
			} else if (tipoPublicacion.toLowerCase().equals("revista")) { // REVISTA
				Revista revista = preguntarRevista(); // Pregunto la revista
				listaPublicaciones.add(revista); // Anyado la revista creada a la lista de publicaciones
				bien = true;
			} else {
				System.out.println("error");
			}	
		}
	}

	public static Libro preguntarLibro() { // Devuelve un Libro
		// Pregunto el libro
		System.out.println("Titulo:");
		String titulo = sc.nextLine();
		System.out.println("Autor:");
		String autor = sc.nextLine();
		System.out.println("Anyo de publicacion:");
		int anyoPublicacion = sc.nextInt();
		System.out.println("Numero de paginas:");
		int numeroPaginas = sc.nextInt();
		return new Libro(titulo, autor, anyoPublicacion, numeroPaginas); // Devuelvo el libro
	}

	public static Revista preguntarRevista() { // Devuelve una revista
		// Pregunto la revista
		System.out.println("Titulo:");
		String titulo = sc.nextLine();
		System.out.println("Autor:");
		String autor = sc.nextLine();
		System.out.println("Anyo de publicacion:");
		int anyoPublicacion = sc.nextInt();
		System.out.println("Numero de edicion:");
		int numeroEdicion = sc.nextInt();
		return new Revista(titulo, autor, anyoPublicacion, numeroEdicion); // Devuelvo la revista
	} 

	public static void mostrarUsuarios() {
		System.out.println("Usuarios registrados:");
		for (Usuarios usuario : listaUsuarios) {
			usuario.mostrarInformacion();
		}
	}
	
	public static void mostrarPublicaciones() {
		System.out.println("Publicaciones disponibles:");
		for (Publicaciones publicacion : listaPublicaciones) {
			publicacion.mostrarInformacion();
		}
	}

	public static void realizarPrestamo() {
		mostrarPublicaciones();
		System.out.println("De que publicacion quieres hacer un prestamo");
		String id = sc.nextLine();
		boolean disponible = verificarDisponibilidad(id); // Verifica que este disponible
		if (disponible) {
			for (Publicaciones publicacion : listaPublicaciones) {
				if (publicacion.getId().equals(id)) { // Busco la publicacion
					// Pregunto que usuario es
					Usuarios usu = null;
					System.out.println("Dime tu DNI:");
					String dni = sc.nextLine();
					for (Usuarios usuario : listaUsuarios) {
						if (usuario.getDni().equals(dni)) { // Compruebo el usuario
							usu=usuario;
						}
					}
					System.out.println("Dime la fecha de hoy:");
					String anyoPrestamo = sc.nextLine();
					// Creo el prestamo
					Prestamo prestamo = new Prestamo(usu, publicacion, anyoPrestamo);
					usu.agregarPrestamo(prestamo); // Agrego el prestamo al usuario
				}
			}
		} else {
			
		}
	}
	
	public static boolean verificarDisponibilidad(String id) {
		boolean disponible = false;
		for (Publicaciones publicacion : listaPublicaciones ) {
			if (publicacion.getId().equals(id)) {
				disponible = true;
				break;
			}
		}
		return disponible;
	}
	
	public static void devolverPrestamo() {
		// Pregunto el usuario
		Usuarios usu = null;
		System.out.println("Dime tu DNI:");
		String dni = sc.nextLine();
		for (Usuarios usuario : listaUsuarios) {
			if (usuario.getDni().equals(dni)) { // Compruebo el usuario
				usu=usuario;
			}
		}
		usu.mostrarHistorialPrestamos();
		System.out.println("Cual quieres devolver?");
		int idPrestamo = sc.nextInt();
		for (Prestamo prestamo : listaPrestamos) {
			if (prestamo.getIdPrestamo() == idPrestamo) {
				System.out.println("Dime el anyo de devolucion:");
				String fechaDevolucion = sc.nextLine();
				prestamo.devolverPrestamo(fechaDevolucion);
			}
		}
	}
}
