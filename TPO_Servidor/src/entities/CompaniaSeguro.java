package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name= "CompaniaSeguro")

public class CompaniaSeguro extends UnicastRemoteObject{
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name="idCompaniaSeguro", nullable = false)
//	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	
	@Column (name="Descripcion")
	private String descripcion;
	
	@OneToMany
	@Column (name="idCompaniaSeguro")
	private List<Tarifa> tarifas;
	
	public CompaniaSeguro() throws RemoteException{
		
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

	public List<Tarifa> getTarifas() {
		return tarifas;
	}

	public void setTarifas(List<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}
}
