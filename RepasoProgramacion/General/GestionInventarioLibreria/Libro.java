package GestionInventarioLibreria;

import java.io.Serializable;

public class Libro implements Serializable{
	// Atributos
	private String titulo;
	private String autor;
	private double precio;
	private int idLibro;
	private static int numLibros = 0;
	
	public Libro(String titulo, String autor, double precio) {
		numLibros++; 
		this.idLibro = numLibros;
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
	}
	
	public int getIdLibro() {
		return idLibro;
	}
	
	public void getInfo() {
		System.out.println("-----ID: " + idLibro + "-----");
		System.out.println("Titulo: " + titulo);
		System.out.println("Autor: " + autor);
		System.out.println("Precio: " + precio + "€");
	}
}
