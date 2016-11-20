package srv;

import dao.UsuarioDAO;
import dto.UsuarioDTO;
import entities.Usuario;

public class UsuarioSRV {
	private static UsuarioDAO dao;
	
	static {
	dao = UsuarioDAO.getInstancia();
	}
	
	public Usuario login (UsuarioDTO usuario){ 
		return dao.login (usuario);
	}
}
