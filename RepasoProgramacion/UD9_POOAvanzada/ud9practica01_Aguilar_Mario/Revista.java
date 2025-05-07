package ud9practica01_Aguilar_Mario;

//Modificado, he quitado varias cosas visuales para que quede mejor en la consola

public class Revista extends Publicaciones{
	// Atributos
	private int numeroEdicion;
	
	public Revista(String titulo, String autor, int anioPublicacion, int numeroEdicion) {
		super(titulo, autor, anioPublicacion);
		this.numeroEdicion = numeroEdicion;
	}

	@Override
	public void mostrarInformacion() { // Metodo que imprime
		System.out.println("-------------------");
		System.out.println("Titulo: " + titulo);
		System.out.println("Autor: " + autor);
		System.out.println("Anyio de publicacion: " + anioPublicacion);
		System.out.println("Numero de paginas: " + numeroEdicion);
		System.out.println("Id: " + id);
	}

}
