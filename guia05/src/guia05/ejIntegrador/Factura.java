package guia05.ejIntegrador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Factura implements Comparable<Factura> {

	private final int CANT_MAX_BIENES = 20;
	private final Double PORC_ENVIO_LOC = 1.10;
	private final Double PORC_ENVIO_PROV = 1.30;
	private final Double PORC_ENVIO_PA = 1.70;
	private static int id = 1;
	private final int idF;
	private Double monto_total;
	private ArrayList<Bien> bienes;
	private Responsable responsable;
	private Proveedor proveedor;
	private Date fecha;

	public Factura(ArrayList<Bien> bienes, Responsable responsable, Proveedor proveedor, Date fecha) {
		super();
		this.bienes = bienes;
		this.responsable = responsable;
		this.proveedor = proveedor;
		this.fecha = fecha;
		this.idF = id;
		id++;
	}

	public int getIdF() {
		return idF;
	}

	public Factura() {
		super();
		this.idF = id;
		id++;
	}

	public static int getId() {
		return id;
	}

	public Double getMonto_total() {
		return monto_total;
	}

	public void setMonto_total() throws DistintoPaisException {
		int op = this.responsable.comparar(this.proveedor);
		Double suma = 0.0, montoTemp, descuento;
		/*
		 * for (Bien bien : bienes) suma = suma + bien.valor;
		 */

		suma = bienes.stream().mapToDouble((b) -> b.getValor()).sum();

		switch (op) {
		case 1:
			montoTemp = PORC_ENVIO_LOC * suma;
			break;
		case 2:
			montoTemp = PORC_ENVIO_PROV * suma;
			break;
		case 3:
			montoTemp = PORC_ENVIO_PA * suma;
			break;
		default:
			throw new DistintoPaisException("El responsable " + this.getResponsable().getNombre() + " y el proveedor "
					+ this.getProveedor().getNombre() + " son de distinto pais." + "\nId de factura: " + this.getIdF());
		}

		descuento = this.proveedor.calcularDescuento(this.bienes.size());

		this.monto_total = montoTemp - (descuento * montoTemp);
	}

	public ArrayList<Bien> getBienes() {
		return bienes;
	}

	public int getCantBienes() {
		return (this.bienes.size());
	}

	public void setBienes(ArrayList<Bien> bienes) throws CantMaxBienesException {
		if (bienes.size() < CANT_MAX_BIENES)
			this.bienes = bienes;
		else {
			throw new CantMaxBienesException("Solo pueden tenerse hasta " + CANT_MAX_BIENES + " bienes");
		}
	}

	public void agregarBien(Bien bien) throws CantMaxBienesException {
		if (bienes.size() < CANT_MAX_BIENES)
			this.bienes.add(bien);
		else {
			throw new CantMaxBienesException(
					"Se alcanzó la cantidad máxima de bienes para una factura (" + CANT_MAX_BIENES + ")");
		}
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "\nFactura [monto_total=" + monto_total + "\n\u0009, bienes=" + bienes + "\n, responsable=" + responsable
				+ "\n, proveedor=" + proveedor + "\n, fecha=" + fecha + "]\n";
	}

	@Override
	public int compareTo(Factura o) {
		if (this.getFecha().before(o.getFecha()))
			return 1;
		if (this.getFecha().after(o.getFecha()))
			return -1;
		return 0;
	}

	// Prueba ordenamiento por fecha descendente
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date d1 = new Date(122, 1, 3);
		Date d2 = new Date(122, 2, 3);
		Date d3 = new Date(122, 1, 20);

		Factura f1 = new Factura(null, null, null, d1);
		Factura f2 = new Factura(null, null, null, d2);
		Factura f3 = new Factura(null, null, null, d3);

		ArrayList<Factura> facts = new ArrayList<>();

		facts.add(f2);
		facts.add(f1);
		facts.add(f3);

		System.out.println(facts.toString()); // d2, d1, d3

		Collections.sort(facts);

		System.out.println(facts); // d2, d3, d1

	}

}
