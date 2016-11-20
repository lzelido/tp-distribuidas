package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ViajeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private Date fechaSalida;
	private SucursalDTO sucSalida;
	private Date fechaLlegada;
	private SucursalDTO sucDestino;
	private List<CargaDTO> cargas;
	private VehiculoDTO vehiculo;
	private GPSDTO ubicacionAct;
	private List<RemitoDTO> remitos;
	private boolean entregado;
	
	public ViajeDTO(){
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public SucursalDTO getSucSalida() {
		return sucSalida;
	}

	public void setSucSalida(SucursalDTO sucSalida) {
		this.sucSalida = sucSalida;
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public SucursalDTO getSucDestino() {
		return sucDestino;
	}

	public void setSucDestino(SucursalDTO sucDestino) {
		this.sucDestino = sucDestino;
	}

	public List<CargaDTO> getCargas() {
		return cargas;
	}

	public void setCargas(List<CargaDTO> cargas) {
		this.cargas = cargas;
	}

	public VehiculoDTO getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculoDTO vehiculo) {
		this.vehiculo = vehiculo;
	}

	public GPSDTO getUbicacionAct() {
		return ubicacionAct;
	}

	public void setUbicacionAct(GPSDTO ubicacionAct) {
		this.ubicacionAct = ubicacionAct;
	}

	public List<RemitoDTO> getRemitos() {
		return remitos;
	}

	public void setRemitos(List<RemitoDTO> remitos) {
		this.remitos = remitos;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}
}
