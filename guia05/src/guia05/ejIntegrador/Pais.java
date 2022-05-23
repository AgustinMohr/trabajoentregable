package guia05.ejIntegrador;

import java.util.Objects;

public class Pais extends Ubicacion {
	private static int id;

	public Pais(String nombre) {
		super();
		this.nombre = nombre;
		id++;
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

	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + "]";
	}

	@Override
	public boolean equals(Object o) {

		return ((Pais) o).nombre.equals(this.nombre);
	}

	@Override
	public int hashCode() { // ¿debo implementarlo cuando uso equals aunque no use una estructura hash?

		return Objects.hash(nombre);
	}

}
