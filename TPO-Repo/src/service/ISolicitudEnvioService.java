package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dto.SolicitudEnvioDTO;

public interface ISolicitudEnvioService extends Remote{
	//ALTA
	public int guardarSolicitudEnvio (SolicitudEnvioDTO solicitud) throws RemoteException;
}
