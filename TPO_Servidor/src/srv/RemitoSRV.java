package srv;

import dao.RemitoDAO;
import entities.Remito;

public class RemitoSRV {
private static RemitoDAO dao;
	
	static {
	dao = RemitoDAO.getInstancia();
	}
	
	// ALTAS
	public void grabarRemito (Remito remito){
		dao.grabarRemito (remito);
	}
	
	// BUSCAR
	public Remito buscarRemito (int codigo){
		Remito remito = dao.buscarRemito(codigo);
		return remito;
	}
}
