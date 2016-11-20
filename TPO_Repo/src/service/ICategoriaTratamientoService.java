package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.CategoriaTratamientoDTO;

public interface ICategoriaTratamientoService extends Remote {
	public List<CategoriaTratamientoDTO> obtenerCategoriasTratamiento()throws RemoteException;
}
