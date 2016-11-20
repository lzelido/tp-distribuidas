package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dto.TarifaDTO;

@Entity
@Table(name= "Tarifa")
public class Tarifa extends UnicastRemoteObject {
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name = "IdTarifa", nullable = false)
//	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	
	@OneToOne
	@JoinColumn (name = "idTipoSeguro")
	private TipoSeguro tipoSeguro;
	
	@OneToOne
	@JoinColumn (name = "idTipoMercaderia")
	private TipoMercaderia tipoMercaderia;
	
	@Column (name="Valor")
	private float valor;
	
	@ManyToOne
	@JoinColumn (name = "idCompaniaSeguro")
	private CompaniaSeguro compania;
	
		
	public Tarifa() throws RemoteException{
		//super();
	}
	
	public Tarifa(TarifaDTO tarifa) throws RemoteException{
		this.codigo = tarifa.getCodigo();
		TipoMercaderia tipoMercaderia = new TipoMercaderia(tarifa.getTipoMercaderia());
		this.tipoMercaderia = tipoMercaderia;
		this.valor = tarifa.getValor();
		TipoSeguro tipoSeguro = new TipoSeguro(tarifa.getTipoSeguro());
		this.tipoSeguro = tipoSeguro;
	}
	
	public TipoSeguro getTipoSeguro() {
		return tipoSeguro;
	}


	public void setTipoSeguro(TipoSeguro tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/*public int getIdTipoSeguro() {
		return idTipoSeguro;
	}

	public void setIdTipoSeguro(int idTipoSeguro) {
		this.idTipoSeguro = idTipoSeguro;
	}*/

	/*public int getIdTipoMercaderia() {
		return idTipoMercaderia;
	}

	public void setIdTipoMercaderia(int idTipoMercaderia) {
		this.idTipoMercaderia = idTipoMercaderia;
	}*/

	public float getValor() {
		return valor;
	}

	public TipoMercaderia getTipoMercaderia() {
		return tipoMercaderia;
	}


	public void setTipoMercaderia(TipoMercaderia tipoMercaderia) {
		this.tipoMercaderia = tipoMercaderia;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}
	
	/*
	public ItemFactura getItemFactura() {
		return itemFactura;
	}

	public void setItemFactura(ItemFactura itemFactura) {
		this.itemFactura = itemFactura;
	}*/
}
