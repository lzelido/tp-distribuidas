package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name = "TipoCarga")
public class TipoCarga extends UnicastRemoteObject{
	@Transient
	private static final long serialVersionUID = 4540823578403549839L;
	
	@Id
	@Column (name = "IdTipoCarga", nullable = false)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	
	@Column (name = "Descri")
	private String descri;
	
	// CONSTRUCTOR
	public TipoCarga() throws RemoteException{
		
	}

	// GETTERS Y SETTERS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescri() {
		return descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}
}
