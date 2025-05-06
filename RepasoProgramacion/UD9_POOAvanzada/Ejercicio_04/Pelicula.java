package Ejercicio_04;

public class Pelicula extends Contenido{
	// Atributos
	private int numNominaciones;
	private int numGanados;
	
	public Pelicula(String titulo, String productora, int anyoPublicacion, int numNominaciones, int numGanados) {
		super(titulo, productora, anyoPublicacion);
		this.numNominaciones = numNominaciones;
		this.numGanados = numGanados;
	}

}
