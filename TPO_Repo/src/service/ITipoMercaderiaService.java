package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import dto.TipoMercaderiaDTO;

public interface ITipoMercaderiaService extends Remote {
	
	// BUSCAR
	public TipoMercaderiaDTO buscarTipoMercaderia (int codigo) throws RemoteException;
	
	// ALTAS
	public int guardarTipoMercaderia(TipoMercaderiaDTO tipoMercaderia)throws RemoteException;
	
	// BAJAS
	public int bajaTipoMercaderia (TipoMercaderiaDTO TipoMercaderia) throws RemoteException;
	
	// MODIFICACIONES
	public int modificarTipoMercaderia (TipoMercaderiaDTO TipoMercaderia) throws RemoteException; 
	
	//LISTADOS
	public List<TipoMercaderiaDTO> obtenerTipoMercaderia()throws RemoteException;

}
