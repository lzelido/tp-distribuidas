package dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1420057205161810891L;
	String id;
	String usuario;
	String password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
