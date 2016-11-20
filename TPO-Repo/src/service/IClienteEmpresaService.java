package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.EmpresaDTO;

public interface IClienteEmpresaService extends Remote {
	
	// BUSCAR
	public EmpresaDTO buscarCliente (String tipoDoc, String nroDoc) throws RemoteException;
	
	public EmpresaDTO buscarCliente (int codigo) throws RemoteException;
	
	// ALTAS
	public int guardarCliente(EmpresaDTO empresa)throws RemoteException;
	
	// BAJAS
	public int bajaCliente (int codigo) throws RemoteException;
	
	// MODIFICACIONES
	public int modificarCliente (EmpresaDTO empresa) throws RemoteException;

	public List<EmpresaDTO> buscarClientes() throws RemoteException;
	
}