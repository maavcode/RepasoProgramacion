package Ejercicio_10;

public interface Interface_Mesa {  

    // En el constructor de la clase se incrementará el numMesa con un contador estático.  
    // Además, se indicará el estado por defecto de una Mesa que es "LIBRE".  

    // Devuelve los datos de la Mesa (numMesa, numPersonas, ubicación y estado)  
    public String obtenerDatosMesa();  

    // Devuelve el atributo numMesa  
    public int getnumMesa();  

    // Pone el atributo estado de la Mesa a "LIBRE"  
    public void liberarMesa();  

    // Pone el atributo estado de la Mesa a "OCUPADA"  
    public void ocuparMesa();  

    // Añadir al ArrayList de Platos el plato p  
    public void pedirPlato(Plato p);  

    // Informar de todos los platos pedidos por la Mesa.  
    // Para ello, recorrer el ArrayList de Platos y llamar a getNombre() en cada uno.  
    public void detalle_platos();  

    // Calcular la factura de la Mesa  
    // Para ello, recorrer el ArrayList de Platos y llamar a getPrecio, acumulando el total.  
    public double calcular_factura();  

}

