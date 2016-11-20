package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import dto.ListaPreciosDTO;;

public interface IListaPreciosService extends Remote {
	
	// ALTAS
		public int guardarListaPrecios(ListaPreciosDTO ListaPrecios)throws RemoteException;
	
		
	// BUSCAR
		public ListaPreciosDTO buscarLista(int numero) throws RemoteException;

}
