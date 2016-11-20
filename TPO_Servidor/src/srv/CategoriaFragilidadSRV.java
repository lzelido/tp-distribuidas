package srv;

import java.util.List;

import dao.CategoriaFragilidadDAO;
import entities.CategoriaFragilidad;

public class CategoriaFragilidadSRV {
	private static CategoriaFragilidadDAO dao;
	
	static {
	dao = CategoriaFragilidadDAO.getInstancia();
	}
	
	// BUSCAR
	public CategoriaFragilidad buscarFragilidad (int codigo){
		CategoriaFragilidad fragilidad = dao.buscarFragilidad(codigo);
		return fragilidad;
	}
	
	public List<CategoriaFragilidad> buscarCategoriasFragilidad (){
		return dao.buscarCategoriasFragilidad();
	}
}
