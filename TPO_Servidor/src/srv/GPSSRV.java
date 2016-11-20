package srv;

import java.util.List;

import dao.GPSDAO;
import entities.GPS;

public class GPSSRV {
	private static GPSDAO dao;
	
	static {
	dao = GPSDAO.getInstancia();
	}

	// ALTA
	public void grabarGPS (GPS gps){
		dao.grabarGPS (gps);
	}
	
	// BUSCAR
	public List<GPS> buscarGPS (){
		List<GPS> gpss = dao.buscarGPSs();
		return gpss;
	}
	
	// BAJA
	public void eliminarGPS (GPS gps){
		dao.eliminarGPS (gps);
	}
}
