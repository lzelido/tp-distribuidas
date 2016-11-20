package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import dto.VehiculoExternoDTO;
import dto.VehiculoPropioDTO;

public interface IVehiculoService extends Remote {

	public VehiculoPropioDTO obtenerVehiculoPropio(String matricula) throws RemoteException;
	
	public VehiculoExternoDTO obtenerVehiculoExterno(String matricula) throws RemoteException;
	
	public void guardarVehiculoPropio(VehiculoPropioDTO vehiculo)throws RemoteException;
	
	public void guardarVehiculoExterno(VehiculoExternoDTO vehiculo)throws RemoteException;
	
	public void eliminarVehiculoExterno(String matricula) throws RemoteException;
	
	public void eliminarVehiculoPropio(String matricula) throws RemoteException;
	 
	public List<VehiculoPropioDTO> obtenerVehiculosPropios()throws RemoteException;
	
	public List<VehiculoExternoDTO> obtenerVehiculosExternos()throws RemoteException;
	
	public void mandarAlTallerVehiculoPropio(String matricula) throws RemoteException;

	public List<VehiculoPropioDTO> obtenerVehiculosParaMantenimiento() throws RemoteException;
	

}
