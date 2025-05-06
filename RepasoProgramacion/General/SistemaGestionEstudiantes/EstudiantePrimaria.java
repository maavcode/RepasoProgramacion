package SistemaGestionEstudiantes;

public class EstudiantePrimaria extends Estudiante {
	
	public EstudiantePrimaria(String nombre, int edad) {
		super(nombre, edad);

	}

	@Override
	public void getInfo() {
		System.out.println("-----ID: " + idEstudiante + "-----");
		System.out.println("Nombre: " + nombre);
		System.out.println("Edad: " + edad);
	}
}
