package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.CategoriaFragilidadDTO;

public interface ICategoriaFragilidadService extends Remote {
	public List<CategoriaFragilidadDTO> obtenerCategoriasFragilidad()throws RemoteException;
}
