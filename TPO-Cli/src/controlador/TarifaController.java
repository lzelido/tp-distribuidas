package controlador;

import java.rmi.RemoteException;
import businessDelegate.BusinessDelegate;
import dto.TarifaDTO;

public class TarifaController {
	
	private static TarifaController instance = null;

	public static TarifaController getInstance() {
		if (instance == null) {
			instance = new TarifaController();
		}
		return instance;
	}
	
	/****************************************************************************************/
	/** METODOS DE TARIFA    							                                   **/
	/****************************************************************************************/
	
	// ALTAS
	public int  darDeAltaTarifa(TarifaDTO tarifa) {
		return BusinessDelegate.getInstance().darDeAltaTarifa(tarifa);
	}
		
	// BUSCAR
	public TarifaDTO buscarTarifa (int codigo)throws RemoteException{
		return BusinessDelegate.getInstance().buscarTarifa(codigo);
	}
	
	public TarifaDTO buscarTarifaid (int idTipoSeguro, int idTipoMercaderia)throws RemoteException{
		return BusinessDelegate.getInstance().buscarTarifaid(idTipoSeguro,idTipoMercaderia);
	}
			
	// BAJAS
	public int bajaTarifa (TarifaDTO tarifa) throws RemoteException{
		return BusinessDelegate.getInstance().bajaTarifa (tarifa);
	}
			
	// MODIFICACIONES
	public int modificarTarifa (TarifaDTO tarifa) throws RemoteException{
		return BusinessDelegate.getInstance().modificarTarifa (tarifa);
	}
}
