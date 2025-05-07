package Ejercicio_10;

public class Reserva {
	// Atributos
	private int fecha;
	private int hora;
	private int numPersonas;
	private Cliente cliente;
	private Mesa mesa;
	
	public Reserva(int fecha, int hora, int numPersonas,Cliente cliente, Mesa mesa) {
		this.fecha = fecha;
		this.hora = hora;
		this.numPersonas = numPersonas;
		this.cliente = cliente;
		this.mesa = mesa;
		mesa.ocuparMesa();
	}

}
