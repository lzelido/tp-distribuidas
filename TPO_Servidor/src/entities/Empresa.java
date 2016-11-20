package entities;

import java.rmi.RemoteException;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name = "Empresa")
@Inheritance (strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn (name = "IdCliente")
public class Empresa extends Cliente {
	@Transient
	private static final long serialVersionUID = 1098170089907829549L;
	
	@Column (name = "NroCuenta")
	private String nroCuenta;
	
	@Column (name = "CtaCte")
	private float ctaCte;
	
	@Column (name = "DepositoPrevio")
	private boolean esDepositoPrevio;
	
	@Column (name = "PagoMensual")
	private boolean esPagoMensual;
	
	@Column (name = "MontoMinAutoriz")
	private float montoMinAutoriz;
	
	@OneToMany
	@JoinColumn (name = "IdCliente")
	private List<Ubicacion> destinos;
	
	@OneToMany
	@JoinColumn (name = "IdCliente")
	private List<Producto> productos;
	
	// CONSTRUCTORES
	public Empresa() throws RemoteException{
		super();
	}
	
	// GETTERS Y SETTERS
	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	
	public float getCtaCte() {
		return ctaCte;
	}
	
	public void setCtaCte(float ctaCte) {
		this.ctaCte = ctaCte;
	}

	public boolean isEsDepositoPrevio() {
		return esDepositoPrevio;
	}
	
	public void setEsDepositoPrevio(boolean esDepositoPrevio) {
		this.esDepositoPrevio = esDepositoPrevio;
	}
	
	public boolean isEsPagoMensual() {
		return esPagoMensual;
	}
	
	public void setEsPagoMensual(boolean esPagoMensual) {
		this.esPagoMensual = esPagoMensual;
	}
	
	public float getMontoMinAutoriz() {
		return montoMinAutoriz;
	}
	
	public void setMontoMinAutoriz(float montoMinAutoriz) {
		this.montoMinAutoriz = montoMinAutoriz;
	}
	
	public List<Ubicacion> getDestinos() {
		return destinos;
	}
	
	public void setDestinos(List<Ubicacion> destinos) {
		this.destinos = destinos;
	}
	
	public List<Producto> getProductos() {
		return productos;
	}
	
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
