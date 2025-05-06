package Ejercicio_02;

public class PezGlobo extends Pez {
	// Atributos
	private int toxinas;
	
	public PezGlobo(String nombre, int numEscamas, int peso, int toxinas) {
		super(nombre, numEscamas, peso);
		this.toxinas = toxinas;
	}
	
	// Getters
	public int getToxinas() {
		return toxinas;
	}
	
	// Setters
	public void setToxinas(int toxinas) {
		this.toxinas = toxinas;
	}
	
	// Otros
	public String rangoPeligrosidad() {
		String peligrosidad = "";
		if (toxinas<(0.1*(peso*10))) {
			peligrosidad = "inofensivo";
		}else if (toxinas > (0.1*(peso*10)) & toxinas < (0.2*(peso*10))) {
			peligrosidad = "riesgo moderado";
		}else if (toxinas > (0.2*(peso*10))) {
			peligrosidad = "yo no lo haria";
		}
		return peligrosidad;
	}
	
	
}
