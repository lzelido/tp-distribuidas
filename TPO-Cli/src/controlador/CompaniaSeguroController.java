package controlador;

import java.rmi.RemoteException;
import businessDelegate.BusinessDelegate;
import dto.CompaniaSeguroDTO;

public class CompaniaSeguroController {
	
	private static CompaniaSeguroController instance = null;

	public static CompaniaSeguroController getInstance() {
		if (instance == null) {
			instance = new CompaniaSeguroController();
		}
		return instance;
	}
	
	/****************************************************************************************/
	/** METODOS DE COMPANIA SEGURO    							                                   **/
	/****************************************************************************************/
	
	// ALTAS
	public int  darDeAltaCompaniaSeguro(CompaniaSeguroDTO companiaSeguro) {
		return BusinessDelegate.getInstance().darDeAltaCompaniaSeguro(companiaSeguro);
	}
			
	// BUSCAR
	public CompaniaSeguroDTO buscarCompaniaSeguro (int codigo)throws RemoteException{
		return BusinessDelegate.getInstance().buscarCompaniaSeguro(codigo);
	}
				
	// BAJAS
	public int bajaCompaniaSeguro (CompaniaSeguroDTO companiaSeguro) throws RemoteException{
		return BusinessDelegate.getInstance().bajaCompaniaSeguro (companiaSeguro);
	}
				
	// MODIFICACIONES
	public int modificarCompaniaSeguro (CompaniaSeguroDTO companiaSeguro) throws RemoteException{
		return BusinessDelegate.getInstance().modificarCompaniaSeguro (companiaSeguro);
	}

}
