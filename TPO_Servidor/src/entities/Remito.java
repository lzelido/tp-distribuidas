package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Remito")
public class Remito extends UnicastRemoteObject{
	private static final long serialVersionUID = 966540003838885041L;

	@Id
	@Column (name = "IdRemito", nullable = false)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	
	@Column (name = "Manifiesto")
	private String manifiesto;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn (name = "IdUbicacionDestino")
	private Ubicacion destino;
	
	@Column (name = "Fecha")
	private Date fecha;
	
	@Column (name = "FechaMaxEntrega")
	private Date fechaMaxEntrega;
	
	@Column (name = "FechaEstEntrega")
	private Date fechaEstEntrega;
	
	@Column (name = "ClienteHabRecepcion")
	private String clienteHabRecepcion;

	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn (name = "IdRemito")
	private List<ItemRemito> items;
	
	// CONSTRUCTOR
	public Remito() throws RemoteException {
		
	}
	
	// GETTERS y SETTERS
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getManifiesto() {
		return manifiesto;
	}
	
	public void setManifiesto(String manifiesto) {
		this.manifiesto = manifiesto;
	}
	
	public Ubicacion getDestino() {
		return destino;
	}
	
	public void setDestino(Ubicacion destino) {
		this.destino = destino;
	}
	
	public Date getFechaMaxEntrega() {
		return fechaMaxEntrega;
	}
	
	public void setFechaMaxEntrega(Date fechaMaxEntrega) {
		this.fechaMaxEntrega = fechaMaxEntrega;
	}
	
	public Date getFechaEstEntrega() {
		return fechaEstEntrega;
	}
	
	public void setFechaEstEntrega(Date fechaEstEntrega) {
		this.fechaEstEntrega = fechaEstEntrega;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<ItemRemito> getItems() {
		return items;
	}

	public void setItems(List<ItemRemito> items) {
		this.items = items;
	}
	
	public String getClienteHabRecepcion() {
		return clienteHabRecepcion;
	}

	public void setClienteHabRecepcion(String clienteHabRecepcion) {
		this.clienteHabRecepcion = clienteHabRecepcion;
	}
}
