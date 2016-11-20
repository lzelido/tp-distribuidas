package srv;

import java.util.List;

import dao.UbicacionDAO;
import entities.GPS;
import entities.Ubicacion;

public class UbicacionSRV {
	private static UbicacionDAO dao;
	
	static {
	dao = UbicacionDAO.getInstancia();
	}

	// ALTA
	public void grabarUbicacion (Ubicacion ubicacion){
		dao.grabarUbicacion (ubicacion);
	}
	
	// BUSCAR
	public List<Ubicacion> buscarUbicaciones (){
		List<Ubicacion> ubicaciones = dao.buscarUbicaciones();
		return ubicaciones;
	}
	
	public Ubicacion buscarUbicacion (int codigo){
		Ubicacion ubicacion = dao.buscarUbicacion(codigo);
		return ubicacion;
	}
	
	public GPS buscarGPS (int codigoUbicacion){
		GPS gps = dao.buscarGPS(codigoUbicacion);
		return gps;
	}
	
	// BAJA
	public void eliminarUbicacion (Ubicacion ubicacion){
		dao.eliminarUbicacion (ubicacion);
	}
}
