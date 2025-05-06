package SistemaGestionEstudiantes;

import java.io.Serializable;

public abstract class Estudiante implements Serializable{
	// Atributos
	public String nombre;
	public int edad;
	public int idEstudiante;
	private static int numEstudiantes = 0;
	
	public Estudiante(String nombre, int edad) {
		numEstudiantes++;
		idEstudiante = numEstudiantes;
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public int getIdEstudiante() {
		return idEstudiante;
	}
	
	public abstract void getInfo();
}
