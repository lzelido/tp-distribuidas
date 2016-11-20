package controlador;

import java.rmi.RemoteException;
import java.util.List;

import businessDelegate.BusinessDelegate;
import dto.CarrierDTO;
import dto.ProveedorLocalDTO;

public class ProveedorController {
	private static ProveedorController instance = null;

	public static ProveedorController getInstance() {
		if (instance == null) {
			instance = new ProveedorController();
		}
		return instance;
	}

	public ProveedorLocalDTO buscarProveedorLocal (int codigo)throws RemoteException{
		return BusinessDelegate.getInstance().buscarProveedorLocal (codigo);
	}
	
	public CarrierDTO buscarCarrier (int codigo)throws RemoteException{
		return BusinessDelegate.getInstance().buscarCarrier (codigo);
	}

	public String altaProveedorLocal (ProveedorLocalDTO proveedorLocal) throws RemoteException{
		return BusinessDelegate.getInstance().darDeAltaProveedorLocal(proveedorLocal);
	}
	
	public String altaCarrier (CarrierDTO carrier) throws RemoteException{
		return BusinessDelegate.getInstance().darDeAltaCarrier(carrier);
	}
	
	public String bajaProveedor (int codigo) throws RemoteException{
		return BusinessDelegate.getInstance().bajaCarrier(codigo);
	}
	
	public String modificarProveedorLocal (ProveedorLocalDTO proveedorLocal) throws RemoteException{
		return BusinessDelegate.getInstance().modificarProveedorLocal (proveedorLocal);
	}
	
	public String modificarCarrier (CarrierDTO carrier) throws RemoteException{
		return BusinessDelegate.getInstance().modificarCarrier (carrier);
	}
	
	public List<Object> buscarProveedores () throws RemoteException{
		return BusinessDelegate.getInstance().buscarProveedores();
	}

}
