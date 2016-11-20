package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dto.UsuarioDTO;

@Entity
@Table(name="usuarios")
public class Usuario extends UnicastRemoteObject{
	@Transient
	private static final long	serialVersionUID	= 5583127699069274332L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	
	@Column(name="usuario")
	private String usuario;

	@Column(name="password")
	private String password;
	
	@ManyToOne
	@JoinColumn (name = "Codigo")
	private Sucursal sucursal;
	
	
	public Usuario() throws RemoteException {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	public UsuarioDTO getDTO(){
		UsuarioDTO u = new UsuarioDTO();
		u.setUsuario(usuario);
		
		return u;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
}
