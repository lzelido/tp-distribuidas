package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import dto.CompaniaSeguroDTO;

public interface ICompaniaSeguroService extends Remote {
	
	// BUSCAR
	public CompaniaSeguroDTO buscarCompaniaSeguro(int codigo) throws RemoteException;
				
	// ALTAS
	public int guardarCompaniaSeguro(CompaniaSeguroDTO companiaSeguro)throws RemoteException;
				
	// BAJAS
	public int bajaCompaniaSeguro (CompaniaSeguroDTO CompaniaSeguro) throws RemoteException;
				
	// MODIFICACIONES
	public int modificarCompaniaSeguro(CompaniaSeguroDTO CompaniaSeguro) throws RemoteException; 
			
	//LISTADOS
	public List<CompaniaSeguroDTO> obtenerCompaniaSeguro()throws RemoteException;

}
