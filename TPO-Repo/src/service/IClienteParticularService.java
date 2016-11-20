package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.ParticularDTO;

public interface IClienteParticularService extends Remote {
	
	// BUSCAR
	public ParticularDTO buscarCliente (String tipoDoc, String nroDoc) throws RemoteException;
		
	public ParticularDTO buscarCliente (int codigo) throws RemoteException;
	
	public List<Object> buscarClientes() throws RemoteException;
		
	// ALTAS
	public int guardarCliente (ParticularDTO particular)throws RemoteException;
		
	// BAJAS
	public int bajaCliente (int codigo) throws RemoteException;
		
	// MODIFICACIONES
	public int modificarCliente (ParticularDTO particular) throws RemoteException;
		
}
