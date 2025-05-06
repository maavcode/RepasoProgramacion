package Ejercicio_04;

public class Serie extends Contenido{
	// Atributos
	private int numTemporadas;
	private boolean finalizada;
	
	public Serie(String titulo, String productora, int anyoPublicacion, int numTemporadas, boolean finalizada) {
		super(titulo, productora, anyoPublicacion);
		this.numTemporadas = numTemporadas;
		this.finalizada = finalizada;
	}

}
