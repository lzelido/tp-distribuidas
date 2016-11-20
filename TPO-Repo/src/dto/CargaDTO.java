package dto;

import java.io.Serializable;

import enums.Fragilidad;

public class CargaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String descri;
	private TipoCargaDTO tipoC;
	private float peso;
	private DimensionDTO dimensiones;
	private float volumen;
	private Fragilidad fragilidad;
	private CategoriaTratamientoDTO tratamiento;
	private boolean esApilable;
	private int cantApliable;
	private boolean esRefrigerada;
	private String condicionesViaje;
	private String condicionesManipulacion;
	private boolean estaEntregado;
	private ViajeDTO viaje;
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getVolumen() {
		return volumen;
	}

	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}

	public String getDescri() {
		return descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	public TipoCargaDTO getTipoC() {
		return tipoC;
	}

	public void setTipoC(TipoCargaDTO tipo) {
		this.tipoC = tipo;
	}
	
	public DimensionDTO getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(DimensionDTO dimensiones) {
		this.dimensiones = dimensiones;
	}

	public Fragilidad getFragilidad() {
		return fragilidad;
	}

	public void setFragilidad(Fragilidad fragilidad) {
		this.fragilidad = fragilidad;
	}

	public CategoriaTratamientoDTO getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(CategoriaTratamientoDTO tratamiento) {
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

	public ViajeDTO getViaje() {
		return this.viaje;
	}
}
