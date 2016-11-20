package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RemitoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String manifiesto;
	private UbicacionDTO destino;
	private Date fecha;
	private Date fechaMaxEntrega;
	private Date fechaEstEntrega;
	private String clienteHabRecepcion;
	private List<ItemRemitoDTO> items;
	
	// CONSTRUCTOR
	public RemitoDTO(){
		
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
	
	public UbicacionDTO getDestino() {
		return destino;
	}
	
	public void setDestino(UbicacionDTO destino) {
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

	public List<ItemRemitoDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemRemitoDTO> items) {
		this.items = items;
	}

	public String getClienteHabRecepcion() {
		return clienteHabRecepcion;
	}

	public void setClienteHabRecepcion(String clienteHabRecepcion) {
		this.clienteHabRecepcion = clienteHabRecepcion;
	}
}
