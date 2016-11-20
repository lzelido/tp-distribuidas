package srv;

import java.util.List;

import dao.ViajeDAO;
import entities.Viaje;


public class ViajeSRV {
private static ViajeDAO dao;
	
	static {
	dao = ViajeDAO.getInstancia();
	}
	
	// BUSCAR
	public Viaje buscarViajeVigente (int sucursalO, int sucursalD){
		Viaje viaje = dao.buscarViajeVigente(sucursalO, sucursalD);
		return viaje;
	}
	
	public Viaje buscarViaje (int codigo){
		Viaje viaje = dao.buscarViaje(codigo);
		return viaje;
	}
	
	public Viaje buscarViajeByCarga (int codigo){
		Viaje viaje = dao.buscarViajeByCarga(codigo);
		return viaje;
	}
	
	public List<Viaje> buscarViajesNoEntregadosBySucursal (int codigo){
		List<Viaje> viajes = dao.buscarViajesNoEntregadosBySucursal(codigo);
		return viajes;
	}
	
	// ALTAS
	public void grabarViaje (Viaje viaje){
		dao.grabarViaje(viaje);;
	}
}
