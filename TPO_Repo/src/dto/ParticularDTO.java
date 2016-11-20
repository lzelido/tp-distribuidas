package dto;

public class ParticularDTO extends ClienteDTO{
	private static final long serialVersionUID = 1L;
	private boolean esPagoAdelantado;

	// CONSTRUCTOR	
	public ParticularDTO() {
		super();
	}

	// GETTERS Y SETTERS
	public boolean isEsPagoAdelantado() {
		return esPagoAdelantado;
	}
	
	public void setEsPagoAdelantado(boolean esPagoAdelantado) {
		this.esPagoAdelantado = esPagoAdelantado;
	}
}
