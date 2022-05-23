package guia05.ejIntegrador;

public abstract class Persona implements CriterioBusqueda<Localidad>, Comparable<Persona> {
	protected Localidad localidad;
	protected String nombre;

	public int comparar(Persona p) {
		/*
		 * devuelve: 1: misma localidad,provincia,pais. 2: misma provincia,pais. 3:
		 * mismo pais. 0: todo distinto.
		 */
		if (this.localidad.equals(p.localidad))
			return 1;
		if (this.localidad.igualProv(p.localidad))
			return 2;
		if (this.localidad.provincia.pais.equals(p.localidad.provincia.pais))
			return 3;

		return 0;
	}

	@Override
	public String toString() {
		return "Persona [localidad=" + localidad + ", nombre=" + nombre + "]";
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public boolean esDeLocalidad(Localidad l) {

		return (this.localidad.equals(l));
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

	public int compareTo(Persona p) {

		return this.getNombre().compareTo(p.getNombre());

	}

}
