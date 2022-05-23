package guia05.ejIntegrador;

public class Bien {

	private static int id;
	private String alias;
	private String descripcion;
	Double valor;
	private Responsable responsable;

	public Bien(String alias, String descripcion, Double valor, Responsable responsable) {
		super();
		this.alias = alias;
		this.descripcion = descripcion;
		this.valor = valor;
		this.responsable = responsable;
		id++;
	}

	public Bien() {
		super();
	}

	public static int getId() {
		return id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	@Override
	public String toString() {
		return "\n\u0009Bien [alias=" + alias + "\n\u0009, descripcion=" + descripcion + "\n\u0009, valor=" + valor + "\n\u0009, responsable="
				+ responsable + "]\n\u0009";
	}

}
