package Ejercicio_11;

public abstract class Atleta {
	// Atributos
	protected String nombre;
	protected String pais;
	protected int dorsal;
	static int numDorsales = 0;
	
	// Constructor
	public Atleta(String nombre, String pais) {
		numDorsales++;
		this.dorsal = numDorsales;
		this.nombre = nombre;
		this.pais = pais;
	}
	
	// Funciones
	public abstract String getInfo();
}
