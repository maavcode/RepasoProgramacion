package Ejercicio_02;

public class Pez {
	// Atributos
	protected String nombre;
	private int numEscamas;
	protected int peso;
	protected int ID;
	static int numPeces = 0;
	
	public Pez(String nombre, int numEscamas, int peso) {
		this.nombre = nombre;
		this.numEscamas = numEscamas;
		this.peso = peso;
		this.ID = numPeces;
		numPeces++;
	}
	
	// Getters
	public String getNombre() {
		return nombre;
	}
	
	public int getNumEscamas() {
		return numEscamas;
	}
	
	public int getPeso() {
		return peso;
	}
	
	public int getID() {
		return ID;
	}
	
	// Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setNumEscamas(int numEscamas) {
		this.numEscamas = numEscamas;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	// Otros
	public String getTipo() {
		String tipo = "";
		if (peso > 0 & peso < 100) {
			tipo = "pequenyo";									
		}else if (peso > 100 & peso < 300) {
			tipo = "mediano";						
		}else if (peso > 300 & peso < 500) {
			tipo = "grande";			
		}else if (peso > 500){
			tipo = "cachalote";
		}
		return tipo;
	}
	
	public void mostrarCaracteristicas() {
		System.out.println(nombre+" con ID "+ID+"\nTipo: "+getTipo());
	}
}
