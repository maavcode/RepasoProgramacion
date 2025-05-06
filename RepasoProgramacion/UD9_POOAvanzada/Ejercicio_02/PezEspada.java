package Ejercicio_02;

public class PezEspada extends Pez{
	// Atributos
	private String lugarPesca;
	public PezEspada(String nombre, int numEscamas, int peso, String lugarPesca) {
		super(nombre, numEscamas, peso);
		this.lugarPesca = lugarPesca;
	}
	
	// Getters
	public String getLugarPesca() {
		return lugarPesca;
	}
	
	// Setters
	public void setLugarPesca(String lugarPesca) {
		this.lugarPesca = lugarPesca;
	}
	
	// Otros
	public boolean getVeracidad() {
		boolean veracidad = true;
		switch (lugarPesca.toLowerCase()) {
		case "mediterraneo":
			veracidad = false;
			break;
		case "pacifico":
			veracidad = true;
			break;
		case "atlantico":
			veracidad = true;
			break;

		default:
			veracidad = false;
			break;
		}
		return veracidad;
	}
}
