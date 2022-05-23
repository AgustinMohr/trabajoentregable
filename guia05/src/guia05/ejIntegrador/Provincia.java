package guia05.ejIntegrador;

import java.util.Objects;

public class Provincia extends Ubicacion {
	private static int id;
	Pais pais;

	public Provincia(String nombre, Pais pais) {
		super();
		this.nombre = nombre;
		this.pais = pais;
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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Override
	public boolean equals(Object p) {

		return (this.nombre.equals(((Provincia) p).nombre) && this.pais.equals(((Provincia) p).pais));
	}

	public boolean igualPais(Object o) {

		return (this.pais.equals(((Provincia) o).pais));
	}

	@Override
	public int hashCode() { // ¿debo implementarlo cuando uso equals aunque no use una estructura hash?

		return Objects.hash(nombre, pais);
	}

	@Override
	public String toString() {
		return "Provincia [pais=" + pais + ", nombre=" + nombre + "]";
	}

}
