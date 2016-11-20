package controlador;

import java.rmi.RemoteException;
import java.util.List;

import businessDelegate.BusinessDelegate;
import dto.TipoVehiculoDTO;

public class TipoVehiculoController {

	private static TipoVehiculoController instance = null;

	public static TipoVehiculoController getInstance() {
		if (instance == null) {
			instance = new TipoVehiculoController();
		}
		return instance;
	}
	
	public String altaTipoVehiculo(TipoVehiculoDTO tipoVehiculo) throws RemoteException{
		return BusinessDelegate.getInstance().altaTipoVehiculo(tipoVehiculo);
	}
	
	public TipoVehiculoDTO buscarTipoVehiculo (int codigo)throws RemoteException{
		return BusinessDelegate.getInstance().buscarTipoVehiculo (codigo);
	}
	
	public String bajaTipoVehiculo (int codigo) throws RemoteException{
		return BusinessDelegate.getInstance().bajaTipoVehiculo (codigo);
	}
	
	public String modificarTipoVehiculo (TipoVehiculoDTO tipoVehiculo) throws RemoteException{
		return BusinessDelegate.getInstance().modificarTipoVehiculo (tipoVehiculo);
	}
	
	public List<TipoVehiculoDTO> buscarTiposVehiculos() throws RemoteException{
		return BusinessDelegate.getInstance().buscarTiposVehiculos();
	}
}