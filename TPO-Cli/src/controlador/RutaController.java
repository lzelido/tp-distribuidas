package controlador;

import java.rmi.RemoteException;
import businessDelegate.BusinessDelegate;
import dto.RutaDTO;

public class RutaController {
	private static RutaController instance = null;

	public static RutaController getInstance() {
		if (instance == null) {
			instance = new RutaController();
		}
		return instance;
	}

	// BUSCAR
	public RutaDTO buscarRuta (int ruta)throws RemoteException{
		return BusinessDelegate.getInstance().buscarRuta(ruta);
	}
	

	// ALTAS
	public int altaRuta (RutaDTO ruta) throws RemoteException{
		return BusinessDelegate.getInstance().altaRuta (ruta);
	}
	
	
	// BAJAS
	public int bajaRuta (int codigo) throws RemoteException{
		return BusinessDelegate.getInstance().bajaRuta (codigo);
	}

	
	// MODIFICACIONES
	
	public int modificarRuta (RutaDTO ruta) throws RemoteException{
		return BusinessDelegate.getInstance().modificarRuta (ruta);
	}
	
}
