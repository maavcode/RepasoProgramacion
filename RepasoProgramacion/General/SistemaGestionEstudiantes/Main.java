package SistemaGestionEstudiantes;

import java.io.*;
import java.util.*;

public class Main {
	
	public static ArrayList <Estudiante> listadoEstudiantes = new ArrayList<>();
	
	public static Scanner sc = new Scanner(System.in);

	public static File file = new File("Archivos\\datosEstudiantes.txt");
	
	public static void main(String[] args) {
		cargarArrayList();
		menu();
	}
	
	public static void menu() {
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
				addEstudiante();
				break;
			case 2:
				eliminarEstudiante();
				break;
			case 3:
				listarEstudiantes();
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
		String[] programas = { "---PROGRAMAS---", "1- Anyadir estudiante", "2- Eliminar estudiante", "3- Listar estudiantes", "4- Salir"};
		// Muestro el Array que tiene los programas
		for (int i = 0; i < programas.length; i++) {
			System.out.println(programas[i]);
		}
		return programas.length - 1; // Devuelvo el numero de programas que hay
	}
	
	public static void guardarArrayList() {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(listadoEstudiantes); // Rellena uno a uno los objetos
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
			        if (!lista.isEmpty() && lista.get(0) instanceof Estudiante) {
			            
			            // Hace un casting seguro a ArrayList<Libro> y lo asigna a la variable nombreArrayList
			        	listadoEstudiantes = (ArrayList<Estudiante>) lista;
			            
			            // Mensaje de confirmación de carga exitosa
			            System.out.println("Datos de estudiantes cargados correctamente.");
			            
			        } else {
			            // Lanza excepción si la lista está vacía o no contiene objetos tipoObjeto
			            throw new ClassNotFoundException("El archivo no contiene una lista de estudiantes.");
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

	public static void addEstudiante() {
		boolean correcto = false;
		int tipoEstudiante = 0;
		while (!correcto) {
			System.out.println("1- Primaria\n2- Secundaria");
			tipoEstudiante = sc.nextInt();
			sc.nextLine();
			if (tipoEstudiante>0 & tipoEstudiante<=2) {
				correcto = true;
			}
		}
		Estudiante estudiante = crearEstudiante(tipoEstudiante);
		listadoEstudiantes.add(estudiante);
	}
	
	public static Estudiante crearEstudiante(int tipoEstudiante) {
		Estudiante estudiante = null;
		String nombre = "";
		int edad = 0;
		String curso = "";
		
		switch (tipoEstudiante) {
		case 1:
			System.out.println("Nombre: ");
			nombre = sc.nextLine();
			System.out.println("Edad: ");
			edad = sc.nextInt();
			estudiante = new EstudiantePrimaria(nombre, edad);
			break;
		case 2:
			System.out.println("Nombre: ");
			nombre = sc.nextLine();
			System.out.println("Edad: ");
			edad = sc.nextInt();
			sc.nextLine();
			System.out.println("Curso: ");
			curso = sc.nextLine();
			estudiante = new EstudianteSecundaria(nombre, edad, curso);
			break;
		default:
			break;
		}
		
		return estudiante;
	}
	
	public static void eliminarEstudiante() {
		if (listadoEstudiantes.isEmpty()) {
			System.err.println("No hay estudiantes en la lista");
		} else {
			// Pregunta el id
			System.out.println("Dime el id del estudiante");
			int id = sc.nextInt();
			// Busca el libro
			Estudiante estudiante = buscarEstudiante(id);
			// Elimina el libro
			listadoEstudiantes.remove(estudiante);
		}
	}

	public static Estudiante buscarEstudiante(int id) {
		Estudiante estudianteBuscado = null;
		// Pregunta el id del libro
		for (Estudiante estudiante : listadoEstudiantes) {
			if (estudiante.getIdEstudiante() == id) {
				estudianteBuscado = estudiante;
			}
		}
		return estudianteBuscado;
	}

	public static void listarEstudiantes() {
		if (listadoEstudiantes.isEmpty()) {
			System.err.println("No hay estudiantes en la lista");
		} else {
			for (Estudiante estudiante : listadoEstudiantes) {
				estudiante.getInfo();
			}
		}
	}
}
