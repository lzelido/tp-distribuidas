package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.SucursalDTO;

public interface ISucursalService extends Remote {

	// BUSCAR
	public SucursalDTO buscarSucursal (int codigo) throws RemoteException;
//	public List<SucursalDTO> obtenerSucursal()throws RemoteException;
	 
	// ALTAS
	public int guardarSucursal(SucursalDTO sucursal)throws RemoteException;
	
	// BAJAS
	public int eliminarSucursal(SucursalDTO sucursalDTO) throws RemoteException;
	 
	//MODIFICACIONES
	public int ModificarSucursal(SucursalDTO sucursalDTO) throws RemoteException;
	
	public List<SucursalDTO> buscarSucursales() throws RemoteException;
}
