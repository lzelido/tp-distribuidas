package srv;

import java.util.List;

import dao.CategoriaTratamientoDAO;
import entities.CategoriaTratamiento;;

public class CategoriaTratamientoSRV {
	private static CategoriaTratamientoDAO dao;
	
	static {
	dao = CategoriaTratamientoDAO.getInstancia();
	}
	
	// BUSCAR
	public CategoriaTratamiento buscarTratamiento (int codigo){
		CategoriaTratamiento tratamiento = dao.buscarTratamiento(codigo);
		return tratamiento;
	}
	
	public List<CategoriaTratamiento> buscarTratamientos (){
		return dao.buscarTratamientos();
	}
}
