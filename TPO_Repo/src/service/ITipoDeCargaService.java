package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.TipoCargaDTO;

public interface ITipoDeCargaService extends Remote {
	public List<TipoCargaDTO> obtenerTiposCargas()throws RemoteException;
}
