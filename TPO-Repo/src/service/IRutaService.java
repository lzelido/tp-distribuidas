package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import dto.RutaDTO;

public interface IRutaService extends Remote {
	
	// BUSCAR
	public RutaDTO buscarRuta (int id) throws RemoteException;
		
			
	// ALTAS
	public int guardarRuta (RutaDTO ruta)throws RemoteException;
		
	// BAJAS
	public int bajaRuta (int ruta) throws RemoteException;
		
	// MODIFICACIONES
	public int modificarRuta (RutaDTO ruta) throws RemoteException;
		
}
