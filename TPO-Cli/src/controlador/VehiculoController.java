package controlador;

import java.rmi.RemoteException;
import java.util.List;

import businessDelegate.BusinessDelegate;
import dto.VehiculoExternoDTO;
import dto.VehiculoPropioDTO;

public class VehiculoController {
	private static VehiculoController instance = null;

	public static VehiculoController getInstance() {
		if (instance == null) {
			instance = new VehiculoController();
		}
		return instance;
	}

	public VehiculoPropioDTO buscarVehiculoPropio (String matricula)throws RemoteException{
		return BusinessDelegate.getInstance().buscarVehiculoPropio (matricula);
	}
	
	public List<VehiculoPropioDTO> buscarVehiculosPropio ()throws RemoteException{
		return BusinessDelegate.getInstance().buscarVehiculosPropio ();
	}
	
	public VehiculoExternoDTO buscarVehiculoExterno (String matricula)throws RemoteException{
		return BusinessDelegate.getInstance().buscarVehiculoExterno (matricula);
	}
	
	public List<VehiculoExternoDTO> buscarVehiculosExterno ()throws RemoteException{
		return BusinessDelegate.getInstance().buscarVehiculosExterno ();
	}

	public String altaVehiculoPropio (VehiculoPropioDTO vehiculoPropio) throws RemoteException{
		return BusinessDelegate.getInstance().darDeAltaVehiculoPropio(vehiculoPropio);
	}
	
	public String altaVehiculoExterno (VehiculoExternoDTO vehiculoExterno) throws RemoteException{
		return BusinessDelegate.getInstance().darDeAltaVehiculoExterno(vehiculoExterno);
	}
	
	public String bajaVehiculo (String matricula) throws RemoteException{
		return BusinessDelegate.getInstance().bajaVehiculo(matricula);
	}
	
	public String modificarVehiculoPropio (VehiculoPropioDTO vehiculoPropio) throws RemoteException{
		return BusinessDelegate.getInstance().modificarVehiculoPropio (vehiculoPropio);
	}
	
	public String modificarVehiculoExterno (VehiculoExternoDTO vehiculoExterno) throws RemoteException{
		return BusinessDelegate.getInstance().modificarVehiculoExterno (vehiculoExterno);
	}

}
