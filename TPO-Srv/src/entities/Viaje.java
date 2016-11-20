package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dto.ViajeDTO;

@Entity
@Table (name = "Viaje")
public class Viaje{
	@Transient
	private static final long serialVersionUID = 1708164170804919255L;
	
	@Id
	@Column (name = "IdViaje", nullable = false)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;

	@Column (name = "FechaSalida")
	private Date fechaSalida;
	
	@OneToOne
	@JoinColumn (name = "IdSucSalida")
	private Sucursal sucSalida;
	
	@Column (name = "FechaLlegada")
	private Date fechaLlegada;
	
	@OneToOne
	@JoinColumn (name = "IdSucDestino")
	private Sucursal sucDestino;
	
	@OneToMany(cascade= CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn (name = "IdViaje")
	private List<Carga> cargas;
	
	@Transient
	private Vehiculo vehiculo;
	
	@Transient
	private GPS ubicacionAct;
	
	@Transient
//	@OneToMany
//	@JoinColumn (name = "IdRemito")
	private List<Remito> remitos;
	
	@Column (name = "Entregado")
	private boolean estaEntregado;
	
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

	public Sucursal getSucSalida() {
		return sucSalida;
	}

	public void setSucSalida(Sucursal sucSalida) {
		this.sucSalida = sucSalida;
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public Sucursal getSucDestino() {
		return sucDestino;
	}

	public void setSucDestino(Sucursal sucDestino) {
		this.sucDestino = sucDestino;
	}

	public List<Carga> getCargas() {
		return cargas;
	}

	public void setCargas(List<Carga> cargas) {
		this.cargas = cargas;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public GPS getUbicacionAct() {
		return ubicacionAct;
	}

	public void setUbicacionAct(GPS ubicacionAct) {
		this.ubicacionAct = ubicacionAct;
	}

	public List<Remito> getRemitos() {
		return remitos;
	}

	public void setRemitos(List<Remito> remitos) {
		this.remitos = remitos;
	}

	public boolean isEntregado() {
		return estaEntregado;
	}

	public void setEntregado(boolean entregado) {
		this.estaEntregado = entregado;
	}

	public static Viaje fromDto(ViajeDTO dto) {
		Viaje viaje = new Viaje();
		viaje.setCargas(Carga.fromDtos(dto.getCargas()));
		viaje.setCodigo(dto.getCodigo());
		viaje.setEntregado(dto.isEntregado());
		viaje.setFechaLlegada(dto.getFechaLlegada());
		viaje.setFechaSalida(dto.getFechaSalida());
		viaje.setRemitos(Remito.fromDtos(dto.getRemitos()));
		viaje.setSucDestino(Sucursal.fromDto(dto.getSucDestino()));
		viaje.setSucSalida(Sucursal.fromDto(dto.getSucSalida()));
		viaje.setUbicacionAct(GPS.fromDto(dto.getUbicacionAct()));
		viaje.setVehiculo(Vehiculo.fromDto(dto.getVehiculo()));
		return viaje;
	}
}
