package guia05.ejIntegrador;

import java.util.Objects;

public class Localidad extends Ubicacion{
	@SuppressWarnings("unused")
	private static int id;
	Provincia provincia;

	public Localidad(String nombre, Provincia provincia) {
		super();
		this.nombre = nombre;
		this.provincia = provincia;
		id++;
	}
	
	public Localidad() {
		super();
	}

	@Override
	public boolean equals(Object o) {
		return (this.provincia.equals(((Localidad) o).provincia) && this.nombre.equals(((Localidad) o).nombre));
	}

	public boolean igualProv(Object o) {
		return (this.provincia.equals(((Localidad) o).provincia));
	}

	@Override
	public int hashCode() { // ¿debo implementarlo cuando uso equals aunque no use una estructura hash?
		return Objects.hash(nombre, provincia);
	}

	@Override
	public String toString() {
		return "Localidad [provincia=" + provincia + ", nombre=" + nombre + "]";
	}
	
	

}
