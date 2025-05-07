package SegundaEvaluacion;

public class Pizza {
	private String tamanyo;
	private String tipo;
	private boolean estado;
	static int totalPedidas = 0;
	static int totalServidas = 0;

	public Pizza(String tamanyo, String tipo) {
		this.tamanyo = tamanyo.toLowerCase();
		this.tipo = tipo.toLowerCase();
		this.estado = true; // Pedida
		this.totalPedidas++;
	}
	// Getters
	public String getTamanyo() {
		return tamanyo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public boolean getEstado() {
		return estado;
	}
	
	public int getTotalPedidas() {
		return totalPedidas;
	}
	
	public int getTotalServidas() {
		return totalServidas;
	}

	// Funciones
	public void servir() {
		estado = false;
		totalServidas++;
		totalPedidas--;
	}
	
	public int calcularPrecio() {
		int precio = 0;
		switch (tamanyo) {
		case "mediana":
			precio = 8;
			break;
		case "familiar":
			precio = 12;
			break;
		default:
			break;
		}
		return precio;
	}
	
	
	

}
