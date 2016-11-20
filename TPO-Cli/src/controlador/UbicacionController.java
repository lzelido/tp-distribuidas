package controlador;

import java.rmi.RemoteException;
import java.util.Vector;

import dto.UbicacionDTO;
import businessDelegate.BusinessDelegate;

public class UbicacionController {
	private static UbicacionController instance = null;
	
	public static UbicacionController getInstance() {
		if (instance == null) {
			instance = new UbicacionController();
		}
		return instance;
	}

	// BUSCAR
	public Vector<UbicacionDTO> buscarUbicacionesCliente (int idCliente) throws RemoteException{
		return BusinessDelegate.getInstance().buscarUbicacionesCliente(idCliente);
	}
	
	// ALTAS
	public int agregarUbicacionCliente (int idCliente, UbicacionDTO ubicacionDTO) throws RemoteException{
		return BusinessDelegate.getInstance().agregarUbicacionCliente (idCliente, ubicacionDTO);
	}
	
	public int grabarUbicacionSucursal (int idSucrsal, UbicacionDTO ubicacionDTO) throws RemoteException{
		return BusinessDelegate.getInstance().grabarUbicacionSucursal(idSucrsal, ubicacionDTO);
	}
	
	// BAJAS
	public int eliminarUbicacionCliente (int idCliente, UbicacionDTO destinoDTO) throws RemoteException{
		return BusinessDelegate.getInstance().eliminarUbicacionCliente(idCliente, destinoDTO);
	}

	// MODIFICACIONES
	public int modificarUbicacionCliente (int idCliente, UbicacionDTO ubicacionDTO) throws RemoteException{
		return BusinessDelegate.getInstance().modificarUbicacionCliente (idCliente, ubicacionDTO);
	}
}
