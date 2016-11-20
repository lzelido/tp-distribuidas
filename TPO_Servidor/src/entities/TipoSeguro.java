package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import dto.TipoSeguroDTO;

@Entity
@Table(name= "TipoSeguro")
public class TipoSeguro extends UnicastRemoteObject {
	@Transient
	private static final long serialVersionUID = 1L;
	
	/*@Id
	@Column (name="Codigo")
	private int codigo;*/
	
	@Id
	@Column(name = "idTipoSeguro", nullable = false)
	//@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	
		
	@Column (name="Descripcion")
	private String descripcion;
	
	
	public TipoSeguro() throws RemoteException {
		//super();
		
	}
	
	public TipoSeguro (TipoSeguroDTO tipoSeguro) throws RemoteException{
		this.codigo = tipoSeguro.getCodigo();
		this.descripcion = tipoSeguro.getDescripcion();
	}
	
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
