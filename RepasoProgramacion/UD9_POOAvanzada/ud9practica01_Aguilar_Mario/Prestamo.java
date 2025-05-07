  package ud9practica01_Aguilar_Mario;

  // He quitado ciertas cosas de mostrar informacion que me dijiste
  
public class Prestamo {
	// Atributos
	private int idPrestamo;
	private Usuarios usuario;
	private Publicaciones publicacion;
	private String fechaPrestamo;
	private String fechaDevolucion;
	private static int numPrestamos = 0;
	
	// Constructor
	public Prestamo(Usuarios usuario, Publicaciones publicacion, String fechaPrestamo) {
		numPrestamos++; // Incrementa para que el id de cada prestamo cambie
		this.idPrestamo = numPrestamos; // Se inicializa
		this.usuario = usuario;
		this.publicacion = publicacion;
		this.fechaPrestamo = fechaPrestamo;
	}
	
	// Metodos requeridos
	public int getIdPrestamo() { // Getter
		return idPrestamo;
	}
	
	public void informacionPrestamo() { // Metodo que imprime
		System.out.println("---Prestamo con id " + idPrestamo + "---");
		System.out.println("Fecha de prestamo: " + fechaPrestamo);
		System.out.println("Datos de la publicacion prestada: ");
	}
	
	public void devolverPrestamo(String fechaDevolucion) { // Metodo que imprime
		this.fechaDevolucion = fechaDevolucion;
		publicacion.marcarDisponible();
	}
}
