package Ejercicio_11;

public class Velocista extends Atleta{
	// Atributos
	private double velocidadMedia;
	
	public Velocista(String nombre, String pais, double velocidadMedia) {
		super(nombre, pais);
		this.velocidadMedia = velocidadMedia;
	}

	// Funciones
	@Override
	public String getInfo() {
		String texto = pais + "(" + dorsal + "): " + nombre + " que corre a " + velocidadMedia + "Km/h.";
		return texto;
	}
}
