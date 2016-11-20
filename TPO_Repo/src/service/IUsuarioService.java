package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dto.UsuarioDTO;

public interface IUsuarioService extends Remote {
	public UsuarioDTO login (UsuarioDTO usuario) throws RemoteException;
}
