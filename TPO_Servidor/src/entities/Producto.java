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

@Entity
@Table(name = "Producto")
public class Producto extends UnicastRemoteObject{
	@Transient
	private static final long serialVersionUID = -1356051695474367343L;
	
	@Id
	@Column (name = "IdProducto", nullable = false)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	
	@Column (name = "Descripcion")
	private String descrip;
	
	@ManyToOne
	@JoinColumn (name = "IdCliente")
	private Empresa empresa;
	
	// CONSTRUCTORES
	public Producto() throws RemoteException{
		
	}
	
	// GETTERS Y SETTERS
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getDescrip() {
		return descrip;
	}
	
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
}
