package SistemaGestionEstudiantes;

public class EstudianteSecundaria extends Estudiante{
	// Atributos
	private String curso;
	
	public EstudianteSecundaria(String nombre, int edad, String curso) {
		super(nombre, edad);
		this.curso = curso;
	}

	@Override
	public void getInfo() {
		System.out.println("-----ID: " + idEstudiante + "-----");
		System.out.println("Nombre: " + nombre);
		System.out.println("Edad: " + edad);
		System.out.println("Curso: " + curso);
	}
}
