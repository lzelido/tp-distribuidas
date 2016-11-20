package dto;

import java.util.List;

public class EmpresaDTO extends ClienteDTO{
	private static final long serialVersionUID = 1L;
	private String nroCuenta;
	private float ctaCte;
	private boolean esDepositoPrevio;
	private boolean esPagoMensual;
	private float montoMinAutoriz;
	private List<UbicacionDTO> destinos;
	private List<ProductoDTO> productos;
	
	// CONSTRUCTOR
	public EmpresaDTO(){
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
	
	public List<UbicacionDTO> getDestinos() {
		return destinos;
	}
	
	public void setDestinos(List<UbicacionDTO> destinos) {
		this.destinos = destinos;
	}
	
	public List<ProductoDTO> getProductos() {
		return productos;
	}
	
	public void setProductos(List<ProductoDTO> productos) {
		this.productos = productos;
	}
}
