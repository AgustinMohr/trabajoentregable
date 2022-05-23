package guia05.ejIntegrador;

import java.util.Comparator;

public class OrdenarPorFechaDesc implements Comparator<Factura> {

	@Override
	public int compare(Factura f1, Factura f2) {

		return (f1.compareTo(f2));
	}
}