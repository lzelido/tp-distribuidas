package srv;

import java.util.List;

import dao.ItemFacturaDAO;
import entities.ItemFactura;

public class ItemFacturaSRV {
	private static ItemFacturaDAO dao;
	
	static {
	dao = ItemFacturaDAO.getInstancia();
	}
	
	// ALTAS
	public void grabarItemFactura (ItemFactura item){
		dao.grabarItemFactura (item);
	}
	
	public List<ItemFactura> obtenerItems (int codigo){
		return dao.obtenerItems (codigo);
	}
}
