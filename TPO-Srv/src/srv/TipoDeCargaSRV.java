package srv;

import java.util.List;

import dao.TipoCargaDAO;
import entities.TipoCarga;

public class TipoDeCargaSRV {
	private static TipoCargaDAO dao;
	
	static {
		dao = TipoCargaDAO.getInstancia();
	}

	public List<TipoCarga> obtenerTiposCargas() {
		return dao.buscarTiposCargas();
	}
}
