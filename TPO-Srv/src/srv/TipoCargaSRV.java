package srv;

import dao.TipoCargaDAO;
import entities.TipoCarga;

public class TipoCargaSRV {
	private static TipoCargaDAO dao;
	static {
		dao = TipoCargaDAO.getInstancia();
	}
	
	// BUSCAR
	public TipoCarga buscarTipoCarga (int codigo){
		TipoCarga tipoC = dao.buscarTipoCarga(codigo);
		return tipoC;
	}
}
