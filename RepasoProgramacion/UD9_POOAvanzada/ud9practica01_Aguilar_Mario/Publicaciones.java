package ud9practica01_Aguilar_Mario;

// Modificado, he agregado la fila id en mostrar informacion de cada uno. Tambien hice id protected

public abstract class Publicaciones {
	// Atributos
	protected String id;
	protected String titulo;
	protected String autor;
	protected int anioPublicacion;
	private boolean disponible;
	
	public Publicaciones(String titulo, String autor, int anioPublicacion) {
		this.id = titulo + "#" + autor + "#" + anioPublicacion;
		this.titulo = titulo;
		this.autor = autor;
		this.anioPublicacion = anioPublicacion;
		this.disponible = true; // Inicializa en true
	}
	
	// Metodos requeridos
	public boolean estaDisponible() { // Getter
		return disponible;
	}
	
	public void marcarNoDisponible() { // Setter
		this.disponible = false;
	}
	
	public void marcarDisponible() { // Setter
		this.disponible = true;
	}
	
	public String getId() { // Getter
		return id;
	}
	
	public abstract void mostrarInformacion(); // Metodo abstracto
	
}
