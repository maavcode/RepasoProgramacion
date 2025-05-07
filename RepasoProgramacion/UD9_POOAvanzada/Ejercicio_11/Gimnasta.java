package Ejercicio_11;

public class Gimnasta extends Atleta{
	//Atributos
	private String especialidad;
	private Entrenador entrenador;
	
	// Constructor
	public Gimnasta(String nombre, String pais, String especialidad, Entrenador entrenador) {
		super(nombre, pais);
		this.especialidad = especialidad.toLowerCase();
		this.entrenador = entrenador;
	}

	// Funciones
	@Override
	public String getInfo() {
		String texto = pais + "(" + dorsal + "): " + nombre + ", cuya especialidad es " + especialidad + " y es entrenado por " + entrenador.getNombre();
		return texto;
	}
	
}
