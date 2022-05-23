package guia05.ejIntegrador;

import java.util.ArrayList;

public class Proveedor extends Persona{

	private static final Double PORC_DESC_MAYOR5 = 0.10;
	private static final Double PORC_DESC_MAYOR10 = 0.20;
	private static int id;
	private ArrayList<Bien> bienes;

	public Proveedor(String nombre, Localidad localidad, ArrayList<Bien> bienes) {
		super();
		this.nombre = nombre;
		this.localidad = localidad;
		this.bienes = bienes;
		id++;
	}
	
	public Proveedor() {
		super();
	}

	public static int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public ArrayList<Bien> getBienes() {
		return bienes;
	}

	public void setBienes(ArrayList<Bien> bienes) {
		this.bienes = bienes;
	}

	@Override
	public String toString() {
		return "Proveedor [bienes=" + bienes + "\n, localidad=" + localidad + "\n, nombre=" + nombre + "]\n";
	}

	public Double calcularDescuento(int cantBienes) {
		if (cantBienes > 5 && cantBienes < 10)
			return PORC_DESC_MAYOR5;
		if (cantBienes >= 10)
			return PORC_DESC_MAYOR10;
		return ((Double) 0.0);
	}
	

	@Override
	public boolean esDeLocalidad(Localidad localidad) {
		return(super.esDeLocalidad(localidad));
		
	}
	
}
