package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import dto.SolicitudEnvioDTO;

public interface IRemitoService extends Remote {
	// ALTA
	public int guardarRemito (SolicitudEnvioDTO solicitudDTO) throws RemoteException;
}
