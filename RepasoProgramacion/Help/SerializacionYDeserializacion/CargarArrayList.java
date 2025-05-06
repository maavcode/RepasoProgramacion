package SerializacionYDeserializacion;

import java.io.*;
import java.util.*;



public class CargarArrayList {
	
	public static File file = new File("");
	public static ArrayList <?> nombreArrayList = new ArrayList<>();
	
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
			        if (!lista.isEmpty() && lista.get(0) instanceof TipoObjeto) {
			            
			            // Hace un casting seguro a ArrayList<Libro> y lo asigna a la variable nombreArrayList
			        	nombreArrayList = (ArrayList<TipoObjeto>) lista;
			            
			            // Mensaje de confirmación de carga exitosa
			            System.out.println("Datos de tipoObjetos cargados correctamente.");
			            
			        } else {
			            // Lanza excepción si la lista está vacía o no contiene objetos tipoObjeto
			            throw new ClassNotFoundException("El archivo no contiene una lista de tipoObjeto.");
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
