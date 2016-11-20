package controlador;

import java.rmi.RemoteException;
import businessDelegate.BusinessDelegate;
import dto.SucursalDTO;

public class SucursalController {
	
	private static SucursalController instance = null;

	public static SucursalController getInstance() {
		if (instance == null) {
			instance = new SucursalController();
		}
		return instance;
	}
	
	// ALTAS
	public int  darDeAltaSucursal(SucursalDTO sucursal) {
		return BusinessDelegate.getInstance().darDeAltaSucursal(sucursal);
	
	}
	
	// BUSCAR
	public SucursalDTO buscarSucursal (int numero)throws RemoteException{
		return BusinessDelegate.getInstance().buscarSucursal(numero);
	}
		
	// BAJAS
	public int eliminarSucursal (SucursalDTO sucursal) throws RemoteException{
		return BusinessDelegate.getInstance().darDeBajaSucursal(sucursal);
	}
		
	// MODIFICACIONES
	public int modificarSucursal (SucursalDTO sucursal) throws RemoteException{
		return BusinessDelegate.getInstance().ModificarSucursal(sucursal);
	}	
}