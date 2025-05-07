package Ejercicio_10;

public class Cliente implements Interface_Cliente {  
	// Atributos
    private String nombre;  
    private String telefono;  

    // Constructor  
    public Cliente(String nombre, String telefono) {  
        this.nombre = nombre;  
        this.telefono = telefono;  
    }

	@Override
	public String getNombre() {
		return nombre;
	}

}

