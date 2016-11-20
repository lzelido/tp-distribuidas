package srv;

import dao.DimensionDAO;
import entities.Dimension;

public class DimensionSRV {
	private static DimensionDAO dao;
	
	static {
	dao = DimensionDAO.getInstancia();
	}
	
	// ALTA
	public void grabarDimension (Dimension dimension) {
		dao.grabarDimension(dimension);
	}
	
	// BUSCAR
	public Dimension buscarDimension (int codigo){
		Dimension dimension = dao.buscarDimension(codigo);
		return dimension;
	}
}
