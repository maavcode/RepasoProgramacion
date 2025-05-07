package Ejercicio_10;

import java.util.ArrayList;  
import java.util.List;  

public class Plato implements Interface_Plato {  
	// Atributos
    private String nombre;  
    private double precio;  
    private List<Ingrediente> ingredientes;  

    // Constructor  
    public Plato(String nombre, double precio) {  
        this.nombre = nombre;  
        this.precio = precio;  
        this.ingredientes = new ArrayList<>();  
    }

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getPrecio() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Ingrediente> getIngredientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarIngrediente(Ingrediente ingrediente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarIngrediente(String nombreIngrediente) {
		// TODO Auto-generated method stub
		
	}  

}

