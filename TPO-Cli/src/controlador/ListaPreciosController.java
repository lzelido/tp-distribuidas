package controlador;

import java.rmi.RemoteException;

import businessDelegate.BusinessDelegate;
import dto.ListaPreciosDTO;;


public class ListaPreciosController {
	
	private static ListaPreciosController instance = null;

	public static ListaPreciosController getInstance() {
		if (instance == null) {
			instance = new ListaPreciosController();
		}
		return instance;
	}
	
	// ALTAS
	public int  darDeAltaListaPrecios(ListaPreciosDTO ListaPrecios) {
		return BusinessDelegate.getInstance().darDeAltaListaPrecios(ListaPrecios);
	
	}
	
	// BUSCAR
	

}
