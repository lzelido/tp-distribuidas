package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import service.IUsuarioService;
import srv.UsuarioSRV;
import dto.UsuarioDTO;
import entities.Usuario;

public class UsuarioController extends UnicastRemoteObject implements IUsuarioService{
	private static final long serialVersionUID = -1120257989926196863L;
		
	public UsuarioController() throws RemoteException {
		super();
	}
	
	@Override
	public UsuarioDTO login (UsuarioDTO usuarioDTO) throws RemoteException{
		try {
			Usuario usuario = (new UsuarioSRV()).login(usuarioDTO);
			if(usuario != null)
				return usuario.getDTO();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}