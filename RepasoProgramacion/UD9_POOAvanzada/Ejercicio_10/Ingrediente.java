package Ejercicio_10;

public class Ingrediente implements Interface_Ingrediente {  
	// Atributos
    private String nombre;  
    private int cantidad;  

    // Constructor  
    public Ingrediente(String nombre, int cantidad) {  
        this.nombre = nombre;  
        this.cantidad = cantidad;  
    }

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCantidad() {
		// TODO Auto-generated method stub
		return 0;
	}  

}

