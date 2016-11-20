package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.TipoVehiculoDTO;

public interface ITipoVehiculoService extends Remote{
	public TipoVehiculoDTO buscarTipoVehiculo (int codigo) throws RemoteException;
	
	public int guardarTipoVehiculo(TipoVehiculoDTO tipoVehiculo)throws RemoteException;
	
	public void bajaTipoVehiculo(int codigo) throws RemoteException;
	
	public int modificarTipoVehiculo(TipoVehiculoDTO tipoVehiculo) throws RemoteException; 
	
	public List<TipoVehiculoDTO> buscarTiposVehiculo() throws RemoteException;
}