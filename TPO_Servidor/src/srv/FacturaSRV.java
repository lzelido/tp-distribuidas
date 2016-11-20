package srv;

import java.util.List;

import dao.FacturaDAO;
import entities.Factura;

public class FacturaSRV {
	private static FacturaDAO dao;
	
	static {
	dao = FacturaDAO.getInstancia();
	}
	
	// ALTAS
	public void grabarFactura (Factura factura){
		dao.grabarFactura(factura);
	}
	
	// BUSCAR
	public Factura buscarFactura (int codigo) {
		Factura factura = dao.buscarFactura(codigo);
		return factura;
	}

	public List<Factura> buscarFacturasCliente(int codigoCliente) {
		return dao.buscarFacturas(codigoCliente);
	}
}
