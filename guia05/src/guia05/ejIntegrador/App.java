package guia05.ejIntegrador;

import java.util.ArrayList;
import java.util.Date;

public class App {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws DistintoPaisException, CantMaxBienesException {

		Pais pais1 = new Pais("Argentina");
		Pais pais2 = new Pais("Chile");

		Provincia prov1 = new Provincia("Buenos Aires", pais1);
		Provincia prov2 = new Provincia("Santiago de Chile", pais2);
		Provincia prov3 = new Provincia("Entre Rios", pais1);

		Localidad l1 = new Localidad("Tigre", prov1);
		Localidad l2 = new Localidad("Palermo", prov1);
		Localidad l3 = new Localidad("Santiago", prov2);
		Localidad l4 = new Localidad("Parana", prov3);
		Localidad l5 = new Localidad("Concordia", prov3);

		Responsable r1 = new Responsable("Responsable 1", l1, "Oficina 1");
		Responsable r2 = new Responsable("Responsable 2", l2, "Oficina 2");
		Responsable r3 = new Responsable("Responsable 3", l3, "Oficina 3");

		ArrayList<Responsable> responsables = new ArrayList<>();
		responsables.add(r1);
		responsables.add(r2);
		responsables.add(r3);

		Bien b1 = new Bien("Bien 1", null, 505.5, r1);
		Bien b2 = new Bien("Bien 2", null, 1000.9, r2);
		Bien b3 = new Bien("Bien 3", null, 2500.4, r3);
		Bien b4 = new Bien("Bien 4", null, 400.4, r1);
		Bien b5 = new Bien("Bien 5", null, 4000.0, r2);
		Bien b6 = new Bien("Bien 6", null, 2000.8, r3);
		Bien b7 = new Bien("Bien 7", null, 3000.7, r1);
		Bien b8 = new Bien("Bien 8", null, 15500.1, r2);
		Bien b9 = new Bien("Bien 9", null, 1300.2, r3);
		Bien b10 = new Bien("Bien 10", null, 900.6, r1);
		Bien b11 = new Bien("Bien 11", null, 2100.6, r2);

		ArrayList<Bien> bienes = new ArrayList<>();
		ArrayList<Bien> bienes1 = new ArrayList<>();
		ArrayList<Bien> bienes2 = new ArrayList<>();
		bienes.add(b1);
		bienes.add(b2);
		bienes.add(b3);
		bienes.add(b4);
		bienes.add(b5);
		bienes.add(b6);
		bienes.add(b7);
		bienes.add(b8);
		bienes.add(b9);
		bienes.add(b10);
		bienes.add(b11);

		bienes1.add(b1);
		bienes1.add(b1);
		bienes1.add(b2);
		bienes1.add(b3);
		bienes1.add(b4);
		bienes1.add(b5);
		bienes1.add(b6);

		bienes2.add(b1);
		bienes2.add(b2);
		bienes2.add(b3);
		bienes2.add(b4);

		Proveedor p1 = new Proveedor("Proveedor 1", l1, bienes);
		Proveedor p2 = new Proveedor("Proveedor 2", l4, bienes1);
		Proveedor p3 = new Proveedor("Proveedor 3", l2, bienes2);
		Proveedor p4 = new Proveedor("Proveedor 4", l2, bienes);
		Proveedor p5 = new Proveedor("Proveedor 5", l3, bienes1);
		Proveedor p6 = new Proveedor("Proveedor 6", l3, bienes2);

		ArrayList<Proveedor> proveedores = new ArrayList<>();
		proveedores.add(p1);
		proveedores.add(p2);
		proveedores.add(p3);
		proveedores.add(p4);
		proveedores.add(p5);
		proveedores.add(p6);

		Date d1 = new Date(122, 1, 3); // fecha 03/02/2022
		Date d2 = new Date(122, 2, 6); // fecha 06/03/2022
		Date d3 = new Date(122, 1, 20); // fecha 20/02/2022

		Factura f1 = new Factura(bienes, r1, p2, d1); // mismo pais
		// Factura f2 = new Factura(bienes, r3, p3, d2); // distinto pais
		Factura f3 = new Factura(bienes1, r1, p4, d3); // mismo pais y provincia
		Factura f4 = new Factura(bienes2, r1, p2, d2); // mismo pais, provincia y localidad
		Factura f5 = new Factura(bienes2, r2, p1, d2); // mismo pais, provincia y localidad
		Factura f6 = new Factura(bienes2, r1, p1, d2); // mismo pais, provincia y localidad

		ArrayList<Factura> facturas = new ArrayList<>();
		facturas.add(f1);
		// facturas.add(f2);
		facturas.add(f3);
		facturas.add(f4);
		facturas.add(f5);
		facturas.add(f6);

		Empresa emp = new Empresa();

		emp.setProveedores(proveedores);
		emp.setResponsables(responsables);
		emp.setBienes(bienes);
		emp.setFacturas(facturas);
		emp.setMontoFacturas();

		System.out.println(p1.esDeLocalidad(l1)); // true
		System.out.println(p1.esDeLocalidad(l2) + "\n"); // false

		// f2.setMonto_total(); //DistintoPaisException

		System.out.println(emp.listarFacturaByProveedor(p1));
		System.out.println(emp.listarFacturaByProveedor(p2));
		System.out.println(emp.listarFacturaByProveedor(p3));
		System.out.println(emp.listarFacturaByProveedor(p4));
		System.out.println(emp.listarFacturaByProveedor(p5));
		System.out.println(emp.listarFacturaByProveedor(p6));

		System.out.println("\n\n" + emp.listarFacturaByResponsable(r1));
		System.out.println(emp.listarFacturaByResponsable(r2));
		System.out.println(emp.listarFacturaByResponsable(r3));

		System.out.println("Proveedores de la localidad " + l1.getNombre() + "\n" + emp.listarNombresProveedores(l1));
		System.out.println("Proveedores de la localidad " + l2.getNombre() + "\n" + emp.listarNombresProveedores(l2));
		System.out.println("Proveedores de la localidad " + l3.getNombre() + "\n" + emp.listarNombresProveedores(l3));
		System.out.println("Proveedores de la localidad " + l5.getNombre() + "\n" + emp.listarNombresProveedores(l5));

		System.out.println("Bienes solicitados por responsables de la localidad " + l1.getNombre() + "\n"
				+ emp.listarBienesByLocalidad(l1));
		System.out.println("Bienes solicitados por responsables de la localidad " + l2.getNombre() + "\n"
				+ emp.listarBienesByLocalidad(l2));
		System.out.println("Bienes solicitados por responsables de la localidad " + l3.getNombre() + "\n"
				+ emp.listarBienesByLocalidad(l3));
		System.out.println("Bienes solicitados por responsables de la localidad " + l5.getNombre() + "\n"
				+ emp.listarBienesByLocalidad(l5));

		double precioMayor;
		precioMayor = 2000;
		System.out.println(
				"Bienes con precio mayor a " + precioMayor + "\n" + emp.listarBienesByPrecioMayor(precioMayor));
		precioMayor = 0;
		System.out.println(
				"Bienes con precio mayor a " + precioMayor + "\n" + emp.listarBienesByPrecioMayor(precioMayor));
		precioMayor = 100000;
		System.out.println(
				"Bienes con precio mayor a " + precioMayor + "\n" + emp.listarBienesByPrecioMayor(precioMayor));

		double montoMayor;
		montoMayor = 10000;

		System.out.println(
				"Facturas con precio mayor a " + montoMayor + "\n" + emp.listarFacturasByMontoMayor(montoMayor));

		System.out.println(emp.listarFacturasPorProveedor(p1));
		System.out.println(emp.listarFacturasPorProveedor(p2));
		System.out.println(emp.listarFacturasPorProveedor(p3));
		System.out.println(emp.listarFacturasPorProveedor(p4));
		System.out.println(emp.listarFacturasPorProveedor(p5));
		System.out.println(emp.listarFacturasPorProveedor(p6));

	}
}
