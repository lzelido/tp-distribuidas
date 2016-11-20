package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
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

import dto.RemitoDTO;

@Entity
@Table (name = "Remito")
public class Remito {
	private static final long serialVersionUID = 966540003838885041L;

	@Id
	@Column (name = "IdRemito", nullable = false)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	
	@Column (name = "Manifiesto") //TODO: wtf? lo scaria a la mierda.
	private String manifiesto;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn (name = "IdUbicacionDestino")
	private Ubicacion destino; //TODO: no se si dejarlo o sacarlo, ya esta en el SolicitudEnvio esto.
	
	@Column (name = "Fecha")
	private Date fecha;
	
	@Column (name = "FechaMaxEntrega")
	private Date fechaMaxEntrega;
	
	@Column (name = "FechaEstEntrega") //TODO: lo sacaria a la mierda.
	private Date fechaEstEntrega;
	
	@Column (name = "ClienteHabRecepcion")
	private String clienteHabRecepcion;

	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn (name = "IdRemito")
	private List<ItemRemito> items;
	
	
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

	public static List<Remito> fromDtos(List<RemitoDTO> dtos) {
		List<Remito> remitos = new ArrayList<Remito>();
		for (RemitoDTO dto : dtos) {
			remitos.add(Remito.fromDto(dto));
		}
		return remitos;
	}

	public static Remito fromDto(RemitoDTO dto) {
		Remito remito = new Remito();
		remito.setClienteHabRecepcion(dto.getClienteHabRecepcion());
		remito.setCodigo(dto.getCodigo());
		remito.setDestino(Ubicacion.fromDto(dto.getDestino()));
		remito.setFecha(dto.getFecha());
		remito.setItems(ItemRemito.fromDtos(dto.getItems()));
		remito.setManifiesto(dto.getManifiesto());
		return remito;
	}
}
