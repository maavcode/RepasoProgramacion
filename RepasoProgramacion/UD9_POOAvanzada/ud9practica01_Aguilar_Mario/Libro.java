package ud9practica01_Aguilar_Mario;

//Modificado, he quitado varias cosas visuales para que quede mejor en la consola

public class Libro extends Publicaciones{
	// Atributos
	private int numeroPaginas;
	
	// Constructor
	public Libro(String titulo, String autor, int anioPublicacion, int numeroPaginas) {
		super(titulo, autor, anioPublicacion);
		this.numeroPaginas = numeroPaginas;
	}

	@Override
	public void mostrarInformacion() { // Metodo que imprime
		System.out.println("-------------------");
		System.out.println("Titulo: " + titulo);
		System.out.println("Autor: " + autor);
		System.out.println("Anyio de publicacion: " + anioPublicacion);
		System.out.println("Numero de paginas: " + numeroPaginas);
		System.out.println("Id: " + id);
	}

}
