package dto;

import java.io.Serializable;

public class TareaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String descrip;
	private boolean esEspecifica;
	private int periodicidad;
	private UnidadDTO unidadPeriodicidad;
	
	public TareaDTO(){
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public boolean isEsEspecifica() {
		return esEspecifica;
	}

	public void setEsEspecifica(boolean esEspecifica) {
		this.esEspecifica = esEspecifica;
	}

	public int getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(int periodicidad) {
		this.periodicidad = periodicidad;
	}

	public UnidadDTO getUnidadPeriodicidad() {
		return unidadPeriodicidad;
	}

	public void setUnidadPeriodicidad(UnidadDTO unidadPeriodicidad) {
		this.unidadPeriodicidad = unidadPeriodicidad;
	}
}
