package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import dto.UbicacionDTO;

public interface IUbicacionService extends Remote {

	// BUSCAR
	public Vector<UbicacionDTO> buscarUbicacionesCliente (int idCliente) throws RemoteException;
	
	// ALTAS
	public int agregarUbicacionCliente (int idCliente, UbicacionDTO ubicacionDTO) throws RemoteException;
	public int grabarUbicacionSucursal (int idSucursal, UbicacionDTO ubicacionDTO) throws RemoteException;
	
	// BAJAS
	public int eliminarUbicacionCliente (int idCliente, UbicacionDTO ubicacionDTO) throws RemoteException;
	
	// MODIFICACIONES
	public int modificarUbicacionCliente (int idCliente, UbicacionDTO ubicacionDTO) throws RemoteException;
}
