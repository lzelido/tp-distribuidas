package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Ruta")
public class Ruta extends UnicastRemoteObject{
	private static final long serialVersionUID = -3350788347912456239L;
	
	@Id
	@Column (name = "IdRuta", nullable = false)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	@JoinColumn (name = "IdSucOrigen")
	private Sucursal sucOrigen;
	
	@OneToOne
	@JoinColumn (name = "IdSucDestino")
	private Sucursal sucDestino;
	
	@Column (name = "Camino")
	private String camino;
	
	@Column (name = "Duracion")
	private float duracion;
	
	@Column (name = "Costo")
	private float costo;
	
	@Column (name = "Vigente")
	private boolean esVigente;
	
	public Ruta() throws RemoteException{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sucursal getSucursalOrigen() {
		return sucOrigen;
	}

	public void setSucursalOrigen(Sucursal sucursalOrigen) {
		this.sucOrigen = sucursalOrigen;
	}

	public Sucursal getSucursalDestino() {
		return sucDestino;
	}

	public void setSucursalDestino(Sucursal sucursalDestino) {
		this.sucDestino = sucursalDestino;
	}

	public String getCamino() {
		return camino;
	}

	public void setCamino(String camino) {
		this.camino = camino;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public boolean isEsVigente() {
		return esVigente;
	}

	public void setEsVigente(boolean esVigente) {
		this.esVigente = esVigente;
	}
	
	public float getDuracion(){
		return duracion;
	}
	
	public void setDuracion(float duracion){
		this.duracion = duracion;
	}
}
