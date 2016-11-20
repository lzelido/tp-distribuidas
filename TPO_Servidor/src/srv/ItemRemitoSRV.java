package srv;

import dao.ItemRemitoDAO;
import entities.ItemRemito;

public class ItemRemitoSRV {
private static ItemRemitoDAO dao;
	
	static {
	dao = ItemRemitoDAO.getInstancia();
	}
	
	// ALTAS
		public void grabarItemRemito (ItemRemito item){
			dao.grabarItemRemito (item);
		}
}
