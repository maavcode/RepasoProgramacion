package Ejercicio_10;

import java.util.ArrayList;  
import java.util.List;  

public class Mesa implements Interface_Mesa {  
	// Atributos
    private static int numMesas = 0;  
    private int numMesa;  
    private int numPersonas;  
    private String estado;  
    private String ubicacion;  
    private ArrayList<Plato> listaPlatos;  

    // Constructor  
    public Mesa(int numPersonas, String ubicacion) {  
    	numMesas++;
    	this.numMesa = numMesas;  
        this.numPersonas = numPersonas;  
        this.ubicacion = ubicacion;  
        this.estado = "LIBRE";  
        this.listaPlatos = new ArrayList<>();  
    }

	@Override
	public String obtenerDatosMesa() {
		String texto = "";
		texto = "Datos mesa " + numMesa + "\n";
		texto = "Ubicacion: " + ubicacion+ "\n";
		texto = "Numero personas: " + numPersonas+ "\n";
		texto = "Estado: " + estado+ "\n";
		return texto;
	}

	@Override
	public int getnumMesa() {
		return numMesa;
	}

	@Override
	public void liberarMesa() {
		this.estado = "LIBRE";
	}

	@Override
	public void ocuparMesa() {
		this.estado = "OCUPADA";
	}

	@Override
	public void pedirPlato(Plato p) {
		listaPlatos.add(p);
	}

	@Override
	public void detalle_platos() {
		System.out.println("Lista de platos");
		for (Plato plato : listaPlatos) {
			plato.getNombre();
		}
	}

	@Override
	public double calcular_factura() {
		double costeTotal = 0;
		for (Plato plato : listaPlatos) {
			costeTotal += plato.getPrecio();
		}
		return costeTotal;
	}  

}

