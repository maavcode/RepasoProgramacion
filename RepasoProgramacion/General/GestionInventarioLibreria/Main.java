package GestionInventarioLibreria;

import java.io.*;
import java.util.*;

public class Main {

	public static File file = new File("Archivos\\datosLibreria.txt");

	public static ArrayList<Libro> listaLibros = new ArrayList<>();

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		cargarArrayList();

		// Declaracion de variables
		boolean encendido = true; // Esta en true ya que empieza el programa
		int programa = 0;
		// Menu interactivo
		while (encendido) {
			//
			try {
				// Preguntamos programa
				programa = preguntarPrograma(); // Muestra los programas y obliga al usuario a elegir uno
			} catch (InputMismatchException e) { // Tipo incorrecto
				System.err.println("Tipo insertado incorrectamente");
				sc.nextLine(); // Salto de linea
			} catch (Exception e) { // Programa inexistente
				System.err.println(e.getMessage());
			}
			switch (programa) {
			case 1:
				addLibro();
				break;
			case 2:
				eliminarLibro();
				break;
			case 3:
				listarLibros();
				break;
			case 4:
				encendido = false;
				guardarArrayList();
				break;
			default:
				break;
			}
		}
	}

	public static int preguntarPrograma() throws Exception { // Devuelve un programa
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
		String[] programas = { "---PROGRAMAS---", "1- Anyadir libro", "2- Eliminar libro", "3- Listar libros",
				"4- Salir" };
		// Muestro el Array que tiene los programas
		for (int i = 0; i < programas.length; i++) {
			System.out.println(programas[i]);
		}
		return programas.length - 1; // Devuelvo el numero de programas que hay
	}

	public static void addLibro() {
		// Crea el libro
		Libro libro = crearLibro();
		// Ingresa el libro a la lista
		listaLibros.add(libro);
	}

	public static Libro crearLibro() {
		// Pregunta los datos del libro
		System.out.println("Dime el titulo del libro");
		String titulo = sc.nextLine();
		System.out.println("Dime el autor del libro");
		String autor = sc.nextLine();
		System.out.println("Dime el precio del libro");
		double precio = sc.nextDouble();
		// Devuelve el libro
		return new Libro(titulo, autor, precio);
	}

	public static void eliminarLibro() {
		if (listaLibros.isEmpty()) {
			System.err.println("No hay libros en la lista");
		} else {
			// Pregunta el id
			System.out.println("Dime el id del libro");
			int id = sc.nextInt();
			// Busca el libro
			Libro libro = buscarLibro(id);
			// Elimina el libro
			listaLibros.remove(libro);
		}
	}

	public static void listarLibros() {
		if (listaLibros.isEmpty()) {
			System.err.println("No hay libros en la lista");
		} else {
			for (Libro libro : listaLibros) {
				libro.getInfo();
			}
		}
	}

	public static Libro buscarLibro(int id) {
		Libro libroBuscado = null;
		// Pregunta el id del libro
		for (Libro libro : listaLibros) {
			if (libro.getIdLibro() == id) {
				libroBuscado = libro;
			}
		}
		return libroBuscado;
	}

	public static void guardarArrayList() {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(listaLibros); // Rellena uno a uno los objetos
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	public static void cargarArrayList() {
		ObjectInputStream ois = null;
		try {
			// Verifica si el archivo existe
			if (file.exists()) {

			    // Crea un flujo de entrada para leer el archivo
			    FileInputStream fis = new FileInputStream(file);
			    
			    // Crea un ObjectInputStream que permite leer objetos serializados
			    ois = new ObjectInputStream(fis);
			    
			    // Lee y deserializa un objeto completo del flujo de entrada
			    Object obj = ois.readObject();

			    // Verifica si el objeto leído es un ArrayList
			    if (obj instanceof ArrayList<?>) {
			        
			        // Inicializa un arraylist de tipo desconocido y le da el valor del objeto, el cual contendra el arraylist guardado
			        ArrayList<?> lista = (ArrayList<?>) obj; 
			        
			        // Verifica dos condiciones:
			        // 1. Que la lista no esté vacía (!lista.isEmpty())
			        // 2. Que el primer elemento de la lista sea una instancia de Libro (Si se usa en otro sitio, hay que asegurarse de que sea del objeto deseado)
			        if (!lista.isEmpty() && lista.get(0) instanceof Libro) {
			            
			            // Hace un casting seguro a ArrayList<Libro> y lo asigna a la variable listaLibros
			            listaLibros = (ArrayList<Libro>) lista;
			            
			            // Mensaje de confirmación de carga exitosa
			            System.out.println("Datos de libros cargados correctamente.");
			            
			        } else {
			            // Lanza excepción si la lista está vacía o no contiene objetos Libro
			            throw new ClassNotFoundException("El archivo no contiene una lista de Libro.");
			        }
			    } else {
			        // Lanza excepción si el objeto leído no es un ArrayList
			        throw new ClassNotFoundException("El archivo no contiene una lista.");
			    }
			} else {
				file.createNewFile();
			}
		} catch (FileNotFoundException e) {
	        System.out.println("El archivo no existe. Se creará uno nuevo al guardar.");
	    } catch (EOFException e) {
	        System.out.println("El archivo está vacío. Se creará uno nuevo al guardar.");
	    } catch (IOException | ClassNotFoundException e) {
	        System.out.println("Error al cargar los datos.");
	        e.printStackTrace();
	    } finally {
	        if (ois != null) {
	            try {
	                ois.close();
	            } catch (IOException e) {
	                System.out.println("Error al cerrar el archivo.");
	                e.printStackTrace();
	            }
	        }
	    }
	}
}
