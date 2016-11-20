package controlador;

import java.rmi.RemoteException;
import businessDelegate.BusinessDelegate;
import dto.TipoSeguroDTO;

public class TipoSeguroController {

	private static TipoSeguroController instance = null;

	public static TipoSeguroController getInstance() {
		if (instance == null) {
			instance = new TipoSeguroController();
		}
		return instance;
	}
	
	/****************************************************************************************/
	/** METODOS DE TIPO SEGURO							                                   **/
	/****************************************************************************************/
	
	// ALTAS
	public int  darDeAltaTipoSeguro(TipoSeguroDTO tipoSeguro) {
		return BusinessDelegate.getInstance().darDeAltaTipoSeguro(tipoSeguro);
	}
	
	// BUSCAR
	public TipoSeguroDTO buscarTipoSeguro (int codigo)throws RemoteException{
		return BusinessDelegate.getInstance().buscarTipoSeguro (codigo);
	}
	
	// BAJAS
	public int bajaTipoSeguro (TipoSeguroDTO tipoSeguro) throws RemoteException{
		return BusinessDelegate.getInstance().bajaTipoSeguro (tipoSeguro);
	}
	
	// MODIFICACIONES
	public int modificarTipoSeguro (TipoSeguroDTO tipoSeguro) throws RemoteException{
		return BusinessDelegate.getInstance().modificarTipoSeguro (tipoSeguro);
	}
}