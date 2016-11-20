package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import dto.TipoMercaderiaDTO;

@Entity
@Table(name= "TipoMercaderia")
public class TipoMercaderia extends UnicastRemoteObject{
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idTipoMercaderia", nullable = false)
	//@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	
	/*@Id
	@Column (name="Codigo")
	private int codigo;*/

	
	@Column (name="Descripcion")
	private String descripcion;
	
	
	public TipoMercaderia() throws RemoteException {
		super();
		
	}
	
	public TipoMercaderia(TipoMercaderiaDTO tipo) throws RemoteException{
		this.codigo = tipo.getCodigo();
		this.descripcion = tipo.getDescripcion();
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
