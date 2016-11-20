package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dto.CargaDTO;
import enums.Fragilidad;

@Entity
@Table (name = "Carga")
public class Carga{
	@Transient
	private static final long serialVersionUID = -5990765293479687566L;
	
	@Id
	@Column (name = "IdCarga", nullable = false)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	
	@Column (name = "Descripcion")
	private String descri;
	
	@OneToOne
	@JoinColumn (name = "IdTipoCarga")
	private TipoCarga tipoC;
	
	@Column (name = "Peso")
	private float peso;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn (name = "IdDimension")
	private Dimension dimensiones;
	
	@Column (name = "VolumenM3")
	private float volumen;
	
	@Enumerated(EnumType.STRING)
	private Fragilidad fragilidad;
	
	@OneToOne
	@JoinColumn (name = "IdTratamiento")
	private CategoriaTratamiento tratamiento;
	
	@Column (name = "Apilable")
	private boolean esApilable;
	
	@Column (name = "CantApilable")
	private int cantApliable;
	
	@Column (name = "Refrigerado")
	private boolean esRefrigerada;
	
	@Column (name = "CondViaje")
	private String condicionesViaje;
	
	@Column (name = "CondManipulacion")
	private String condicionesManipulacion;
	
	@Column (name = "Entregado")
	private boolean estaEntregado;
	
	@ManyToOne
	@JoinColumn (name = "IdViaje")
	private Viaje viaje;
	
	

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

	public TipoCarga getTipoC() {
		return tipoC;
	}

	public void setTipoC(TipoCarga tipo) {
		this.tipoC = tipo;
	}
	
	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Dimension getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(Dimension dimensiones) {
		this.dimensiones = dimensiones;
	}

	public float getVolumen() {
		return volumen;
	}

	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}

	public Fragilidad getFragilidad() {
		return fragilidad;
	}

	public void setFragilidad(Fragilidad fragilidad) {
		this.fragilidad = fragilidad;
	}

	public CategoriaTratamiento getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(CategoriaTratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}

	public boolean isEsApilable() {
		return esApilable;
	}

	public void setEsApilable(boolean esApilable) {
		this.esApilable = esApilable;
	}

	public int getCantApliable() {
		return cantApliable;
	}

	public void setCantApliable(int cantApliable) {
		this.cantApliable = cantApliable;
	}

	public boolean isEsRefrigerada() {
		return esRefrigerada;
	}

	public void setEsRefrigerada(boolean esRefrigerada) {
		this.esRefrigerada = esRefrigerada;
	}

	public String getCondicionesViaje() {
		return condicionesViaje;
	}

	public void setCondicionesViaje(String condicionesViaje) {
		this.condicionesViaje = condicionesViaje;
	}

	public String getCondicionesManipulacion() {
		return condicionesManipulacion;
	}

	public void setCondicionesManipulacion(String condicionesManipulacion) {
		this.condicionesManipulacion = condicionesManipulacion;
	}

	public boolean isEntregado() {
		return estaEntregado;
	}

	public void setEntregado(boolean entregado) {
		this.estaEntregado = entregado;
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	public static List<Carga> fromDtos(List<CargaDTO> cargas) {
		List<Carga> cargasEnt = new ArrayList<Carga>();
		for (CargaDTO dto : cargas) {
			cargasEnt.add(fromDto(dto));
		}
		return cargasEnt;
	}

	public static Carga fromDto(CargaDTO dto) {
		Carga carga = new Carga();
		carga.setCantApliable(dto.getCantApliable());
		carga.setCodigo(dto.getCodigo());
		carga.setCondicionesManipulacion(dto.getCondicionesManipulacion());
		carga.setCondicionesViaje(dto.getCondicionesViaje());
		carga.setDescri(dto.getDescri());
		carga.setDimensiones(Dimension.fromDto(dto.getDimensiones()));
		carga.setEntregado(dto.isEntregado());
		carga.setEsApilable(dto.isEsApilable());
		carga.setEsRefrigerada(dto.isEsRefrigerada());
		carga.setFragilidad(dto.getFragilidad());
		carga.setPeso(dto.getPeso());
		carga.setTipoC(TipoCarga.fromDto(dto.getTipoC()));
		carga.setTratamiento(CategoriaTratamiento.fromDto(dto.getTratamiento()));
		carga.setViaje(Viaje.fromDto(dto.getViaje()));
		carga.setVolumen(dto.getVolumen());
		return carga;
	}
}
