package guia05.ejIntegrador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Empresa {

	ArrayList<Responsable> responsables;
	ArrayList<Proveedor> proveedores;
	ArrayList<Bien> bienes;
	ArrayList<Factura> facturas;

	public Empresa(ArrayList<Responsable> responsables, ArrayList<Proveedor> proveedores, ArrayList<Bien> bienes,
			ArrayList<Factura> facturas) {
		super();
		this.responsables = responsables;
		this.proveedores = proveedores;
		this.bienes = bienes;
		this.facturas = facturas;
	}

	public Empresa() {
		super();
	}

	public ArrayList<Responsable> getResponsables() {
		return responsables;
	}

	public void setResponsables(ArrayList<Responsable> responsables) {
		this.responsables = responsables;
	}

	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(ArrayList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public ArrayList<Bien> getBienes() {
		return bienes;
	}

	public void setBienes(ArrayList<Bien> bienes) {
		this.bienes = bienes;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}

	public void setMontoFacturas() {

		for (Factura fact : facturas)
			try {
				fact.setMonto_total();
			} catch (DistintoPaisException e) {

				e.printStackTrace();
			}

	}

	@Override
	public String toString() {
		return "Empresa [responsables=\n\u0009" + responsables.toString() + "\n\u0009, proveedores=\n\u0009"
				+ proveedores.toString() + "\n\u0009, bienes=\n\u0009" + bienes.toString()
				+ "\n\u0009, facturas=\n\u0009" + facturas.toString() + "]";
	}

	ArrayList<Factura> listarFacturaByProveedor(Proveedor p) {
		ArrayList<Factura> result = new ArrayList<>();
		for (Factura fact : facturas) {
			if ((fact.getProveedor()).equals(p)) {
				result.add(fact);

			}

		}
		System.out.println("Facturas del proveedor " + p.getNombre());
		return result;
	}

	ArrayList<Factura> listarFacturaByResponsable(Responsable r) {
		ArrayList<Factura> result = new ArrayList<>();
		for (Factura fact : facturas) {
			if ((fact.getResponsable()).equals(r)) {
				result.add(fact);

			}

		}
		System.out.println("Facturas del responsable " + r.getNombre());
		return result;

	}

	ArrayList<String> listarNombresProveedores(Localidad l) {
		return proveedores.stream().filter((p) -> p.esDeLocalidad(l))
				.sorted((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()))
				.map((p) -> p.getNombre())
				.collect(Collectors.toCollection(ArrayList::new));
	}

	ArrayList<Bien> listarBienesByLocalidad(Localidad l) {

		ArrayList<Bien> result = new ArrayList<>();
		for (Bien bien : bienes)
			if ((bien.getResponsable().getLocalidad().equals(l)))
				result.add(bien);
		return result;

	}

	ArrayList<Bien> listarBienesByPrecioMayor(Double precioMayor) {

		ArrayList<Bien> result = new ArrayList<>();
		for (Bien bien : bienes)
			if (bien.getValor() > precioMayor)
				result.add(bien);
		return result;

	}

	ArrayList<Factura> listarFacturasByMontoMayor(Double montoMayor) {

		ArrayList<Factura> result = new ArrayList<>();
		for (Factura fact : facturas)
			if (fact.getMonto_total() > montoMayor)
				result.add(fact);
		return result;

	}

	@SuppressWarnings("deprecation")
	ArrayList<String> listarFacturasPorProveedor(Proveedor p) {
		ArrayList<String> result = new ArrayList<>();
		ArrayList<Factura> facts = new ArrayList<>();
		for (Factura fact : facturas) {
			if (fact.getProveedor().equals(p)) {

				facts.add(fact);

			}
		}

		Collections.sort(facts);
		String fechaFormato = new String();
		for (Factura fact : facts) {
			fechaFormato = (String) ((fact.getFecha().getDate()) + "/" + (fact.getFecha().getMonth() + 1) + "/"
					+ (fact.getFecha().getYear() + 1900));
			result.add("En la fecha " + fechaFormato + " " + p.getNombre() + " facturó un total de $"
					+ fact.getMonto_total() + " con " + fact.getCantBienes() + " bienes.\n");
		}
		return result;
	}

}
