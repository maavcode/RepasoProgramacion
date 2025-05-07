package SistemaReservasHotel;

public class Reserva {
	// Atributos
	private int idReserva;
	private String nombreCliente;
	private int numHabitacion;
	private String fechaReserva;
	private static int numReservas = 0;
	
	public Reserva(String nombreCliente, int numHabitacion, String fechaReserva) {
		numReservas++;
		this.idReserva = numReservas;
		this.nombreCliente = nombreCliente;
		this.numHabitacion = numHabitacion;
		this.fechaReserva = fechaReserva;
	}

}
