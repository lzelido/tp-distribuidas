package srv;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dao.VehiculoDAO;
import dto.UnidadDTO;
import dto.VehiculoExternoDTO;
import dto.VehiculoPropioDTO;
import entities.VehiculoExterno;
import entities.VehiculoPropio;

public class VehiculoSRV {
	private static VehiculoDAO dao;
	static {
		dao = VehiculoDAO.getInstancia();
	}
	
	public void grabarVehiculoExterno(VehiculoExterno vehiculo) throws RemoteException{
		dao.grabarVehiculo(vehiculo);
	}
	
	public void grabarVehiculoPropio(VehiculoPropio vehiculo) throws RemoteException{
		dao.grabarVehiculo(vehiculo);
	}
	
	public List<VehiculoExternoDTO> buscarVehiculosExternos (){
		List<VehiculoExterno> vehiculos = dao.buscarVehiculosExternos();
		List<VehiculoExternoDTO> vehiculosDTO = new ArrayList<VehiculoExternoDTO>();
		for(VehiculoExterno vehiculo : vehiculos){
			vehiculosDTO.add(vehiculo.getDTO());
		}
		return vehiculosDTO;
	}
	
	public List<VehiculoPropioDTO> buscarVehiculosPropios (){
		List<VehiculoPropio> vehiculos = dao.buscarVehiculosPropios();
		List<VehiculoPropioDTO> vehiculosDTO = new ArrayList<VehiculoPropioDTO>();
		for(VehiculoPropio vehiculo : vehiculos){
			vehiculosDTO.add(vehiculo.getDTO());
		}
		return vehiculosDTO;
	}
	
	public void eliminarVehiculoExterno(String matricula){
		VehiculoExterno v = dao.buscarVehiculoExterno(matricula);
		dao.eliminarVehiculo(v);
	}
	
	public void eliminarVehiculoPropio(String matricula){
		VehiculoPropio v = dao.buscarVehiculoPropio(matricula);
		dao.eliminarVehiculo(v);
	}
	
	public VehiculoPropioDTO buscarVehiculoPropio(String matricula){
		return dao.buscarVehiculoPropio(matricula).getDTO();
	}
	
	public VehiculoPropio buscarVehiculoPropioParaMantenimiento(String matricula){
		return dao.buscarVehiculoPropio(matricula);
	}
	
	public VehiculoExternoDTO buscarVehiculoExterno(String matricula){
		return dao.buscarVehiculoExterno(matricula).getDTO();
	}
	
	public void modificarVehiculoExterno(VehiculoExternoDTO vehiculo) throws RemoteException{
		
	}
	
	public void modificarVehiculoPropio(UnidadDTO unidad) throws RemoteException{
		
	}
	
	public List<VehiculoPropio> buscarVehiculosParaMantenimiento (){
		return dao.buscarVehiculosPropios();
	}

	public void mandarAlTallerVehiculoPropio(VehiculoPropio v) {
		dao.mandarAlTallerVehiculoPropio(v);
	}
}
