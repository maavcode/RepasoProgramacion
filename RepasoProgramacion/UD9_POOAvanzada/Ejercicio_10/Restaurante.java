package Ejercicio_10;

import java.util.ArrayList;

public class Restaurante implements Interface_Restaurante{
	// Atributos
	private String nombre;
	private String telefono;
	private ArrayList <Mesa> listaMesas = new ArrayList<Mesa>();
	
	// Constructor
	public Restaurante(String nombre, String telefono) {
		
	}

	@Override
	public void montarMesa(Mesa mesa) {
		listaMesas.add(mesa);
	}

	@Override
	public void recogerMesa(Mesa m) {
		
	}

	@Override
	public void listarMesas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calcularCaja() {
		// TODO Auto-generated method stub
		return 0;
	}


}
