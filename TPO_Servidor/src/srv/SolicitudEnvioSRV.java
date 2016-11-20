package srv;

import dao.SolicitudEnvioDAO;
import entities.SolicitudEnvio;

public class SolicitudEnvioSRV {
	private static SolicitudEnvioDAO dao;
	
	static {
	dao = SolicitudEnvioDAO.getInstancia();
	}
	
	// ALTA
	public void grabarSolicitud (SolicitudEnvio solicitud){
		dao.grabarSolicitud(solicitud);
	}
	
	// BUSCAR
	public SolicitudEnvio buscarSolicitud (int codigo){
		SolicitudEnvio solicitud = dao.buscarSolicitud(codigo);
		return solicitud;
	}
}
