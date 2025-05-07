package Ejercicio_11;

public class Entrenador {
	// Atributos
	private String nombre;
	private int anyosExp;
	
	public Entrenador(String nombre, int anyosExp) {
		this.nombre  = nombre;
		this.anyosExp = anyosExp;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getInfo() {
		String texto = nombre + ", que tiene " + anyosExp + " anyos de experiencia.";
		return texto;
	}
}
