package guia05.ejIntegrador;

public class Responsable extends Persona {

	private static int id;
	private String oficina;

	public Responsable(String nombre, Localidad localidad, String oficina) {
		super();
		this.nombre = nombre;
		this.localidad = localidad;
		this.oficina = oficina;
		id++;
	}
	
	public Responsable() {
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

	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	@Override
	public String toString() {
		return "Responsable [oficina=" + oficina + ", localidad=" + localidad + ", nombre=" + nombre + "]";
	}
	
	public boolean esDeLocalidad(Localidad l) {
		
		return(super.esDeLocalidad(l));
	}
}
