package Ejercicio_04;

public class Contenido {
	// Atributos
	private String titulo;
	private String productora;
	private int anyoPublicacion;
	protected boolean visto;
	static int numIDs=0;
	protected int ID;
	
	public Contenido(String titulo, String productora, int anyoPublicacion) {
		this.titulo = titulo;
		this.productora = productora;
		this.anyoPublicacion = anyoPublicacion;
		this.visto = false;
		this.ID = numIDs;
		numIDs++;
	}
	
	public void mostrarContenido() {
		System.out.println("Titulo: "+titulo+" con ID "+ID);
		System.out.println("Productora: "+productora);
		System.out.println("Anyo de publicacion: "+anyoPublicacion);
		if (visto) {
			System.out.println("Visto");			
		} else {
			System.out.println("No visto");
		}
	}
	
	public boolean getVisto() {
		return visto;
	}
	
	public int getID() {
		return ID;
	}
	
	public void ver() {
		this.visto = true;
	}

}
