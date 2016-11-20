package dto;

import java.io.Serializable;

public class RutaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private SucursalDTO sucOrigen;
	private SucursalDTO sucDestino;
	private String camino;
	private float duracion;
	private float costo;
	private boolean esVigente;
	
	public RutaDTO(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SucursalDTO getSucursalOrigen() {
		return sucOrigen;
	}

	public void setSucursalOrigen(SucursalDTO sucursalOrigen) {
		this.sucOrigen = sucursalOrigen;
	}

	public SucursalDTO getSucursalDestino() {
		return sucDestino;
	}

	public void setSucursalDestino(SucursalDTO sucursalDestino) {
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
