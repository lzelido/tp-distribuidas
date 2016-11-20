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

import dto.UnidadDTO;

@Entity
@Table(name="unidades")
public class Unidad extends UnicastRemoteObject{
	@Transient
	private static final long	serialVersionUID	= 5583127699069274332L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	
	@Column (name = "descripcion")
	private String descri;
	
	@Column (name = "Tipo")
	private String tipo;

	public Unidad() throws RemoteException {
		super();
	}

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
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Unidad(UnidadDTO unidad) throws RemoteException{
		descri = unidad.getDescri();
	}
	
	public UnidadDTO getDTO(){
		UnidadDTO unidadDTO = new UnidadDTO();
		unidadDTO.setCodigo(codigo);
		unidadDTO.setDescri(descri);
		unidadDTO.setTipo(tipo);
		return unidadDTO;
	}
}
