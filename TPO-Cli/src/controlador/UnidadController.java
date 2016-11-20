package controlador;

import java.rmi.RemoteException;
import java.util.List;

import businessDelegate.BusinessDelegate;
import dto.UnidadDTO;

public class UnidadController {

	private static UnidadController instance = null;

	public static UnidadController getInstance() {
		if (instance == null) {
			instance = new UnidadController();
		}
		return instance;
	}
	
	public String altaUnidad(UnidadDTO unidad) throws RemoteException{
		return BusinessDelegate.getInstance().darDeAltaUnidad(unidad);
	}
	
	public UnidadDTO buscarUnidad (int codigo)throws RemoteException{
		return BusinessDelegate.getInstance().buscarUnidad(codigo);
	}
	
	public String bajaUnidad (int i) throws RemoteException{
		return BusinessDelegate.getInstance().darDeBajaUnidad(i);
	}
	
	public List<UnidadDTO> buscarUnidades() throws RemoteException{
		return BusinessDelegate.getInstance().buscarUnidades();
	}
	
	public List<UnidadDTO> buscarUnidadesVolumen() throws RemoteException{
		return BusinessDelegate.getInstance().buscarUnidadesVolumen();
	}
	
	public List<UnidadDTO> buscarUnidadesTara() throws RemoteException{
		return BusinessDelegate.getInstance().buscarUnidadesTara();
	}
}