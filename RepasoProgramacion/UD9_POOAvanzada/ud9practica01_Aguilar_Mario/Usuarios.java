package ud9practica01_Aguilar_Mario;

import java.util.ArrayList;

// Modificado, he quitado varias cosas visuales para que quede mejor en la consola
// He quitado el hiostorial de prestamos de mostrar informacion ya que me lo has dicho en clase

public class Usuarios {
	// Atributos
	private String dni;
	private String nombre;
	private String apellido;
	private String email;
	private ArrayList <Prestamo> historialPrestamos;
	
	public Usuarios(String dni, String nombre, String apellido, String email) {
		this.dni =dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.historialPrestamos = new ArrayList<>(); // Inicializo el ArrayList
	}
	
	// Metodos requeridos
	public void agregarPrestamo(Prestamo prestamo) { // Setter
		historialPrestamos.add(prestamo);
	}
	
	public String getDni() { // Getter
		return dni;
	}
	
	public void mostrarInformacion() { // Metodo que imprime
		System.out.println("--------------------");
		System.out.println("Nombre y apellidos: " + nombre + " " + apellido);
		System.out.println("Email: " + email);
		System.out.println("Historial de prestamos: ");
	}
	
	public void mostrarHistorialPrestamos() { // Metodo que imprime
		for (Prestamo prestamo : historialPrestamos) {
			prestamo.informacionPrestamo();
		}
	}

}
