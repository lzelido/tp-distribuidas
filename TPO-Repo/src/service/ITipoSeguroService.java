package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import dto.TipoSeguroDTO;

public interface ITipoSeguroService extends Remote{
	// BUSCAR
	public TipoSeguroDTO buscarTipoSeguro (int codigo) throws RemoteException;
	
	// ALTAS
	public int guardarTipoSeguro(TipoSeguroDTO tipoSeguro)throws RemoteException;
	
	// BAJAS
	public int bajaTipoSeguro (TipoSeguroDTO TipoSeguro) throws RemoteException;
	
	// MODIFICACIONES
	public int modificarTipoSeguro (TipoSeguroDTO TipoSeguro) throws RemoteException; 
	
	//LISTADOS
	public List<TipoSeguroDTO> obtenerTipoSeguro()throws RemoteException;
	
}