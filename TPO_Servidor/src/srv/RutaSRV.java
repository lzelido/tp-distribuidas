package srv;

import dao.RutaDAO;
import entities.Ruta;

public class RutaSRV {
private static RutaDAO dao;
	
	static {
	dao = RutaDAO.getInstancia();
	}
	
	// BUSCAR
	public Ruta buscarRuta (int id){
		Ruta ruta = dao.buscarRuta (id);
		return ruta;
	}

	public Ruta buscarRutaVigente (int sucOrigen, int sucDestino){
		Ruta ruta = dao.buscarRutaVigenteBySucursales (sucOrigen, sucDestino);
		return ruta;
	}
	
	// ALTA
	public void grabarRuta (Ruta ruta){
		dao.grabarRuta(ruta);
	}
	
	// BAJA
	public void modificarRuta (Ruta ruta){
		dao.ModificarRuta(ruta);
	}
	
	// MODIFICACION
	public void eliminarRuta (Ruta ruta){
		dao.EliminarRuta(ruta);
	}
}
