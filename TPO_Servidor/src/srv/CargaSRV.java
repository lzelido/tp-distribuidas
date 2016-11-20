package srv;

import dao.CargaDAO;
import entities.Carga;

public class CargaSRV {
private static CargaDAO dao;
	
	static {
	dao = CargaDAO.getInstancia();
	}

	// ALTA
	public void grabarCarga (Carga carga){
		dao.grabarCarga (carga);
	}
	
	public Carga buscarCarga (int codigo){
		Carga carga = dao.buscarCarga(codigo);
		return carga;
	}
}
