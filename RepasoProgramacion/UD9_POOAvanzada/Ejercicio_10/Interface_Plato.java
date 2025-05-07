package Ejercicio_10;

import java.util.List;  

public interface Interface_Plato {  

    // Devuelve el nombre del Plato  
    public String getNombre();  

    // Devuelve el precio del Plato  
    public double getPrecio();  

    // Devuelve la lista de ingredientes del Plato  
    public List<Ingrediente> getIngredientes();  

    // Añadir un ingrediente a la lista  
    public void agregarIngrediente(Ingrediente ingrediente);  

    // Eliminar un ingrediente de la lista según su nombre  
    public void eliminarIngrediente(String nombreIngrediente);  

}

