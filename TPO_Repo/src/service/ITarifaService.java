package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import dto.TarifaDTO;

public interface ITarifaService extends Remote  {
	
	// BUSCAR
	public TarifaDTO buscarTarifaid(int idTipoSeguro, int idTipoMercaderia) throws RemoteException;
	public TarifaDTO buscarTarifa(int codigo) throws RemoteException;
			
	// ALTAS
	public int guardarTarifa(TarifaDTO tarifa)throws RemoteException;
			
	// BAJAS
	public int bajaTarifa (TarifaDTO Tarifa) throws RemoteException;
			
	// MODIFICACIONES
	public int modificarTarifa(TarifaDTO Tarifa) throws RemoteException; 
			
	//LISTADOS
	public List<TarifaDTO> obtenerTarifa()throws RemoteException;

}
