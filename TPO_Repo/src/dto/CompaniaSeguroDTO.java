package dto;

import java.io.Serializable;
import java.util.List;

public class CompaniaSeguroDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String descripcion;
	private List<TarifaDTO> tarifas;
	
	public CompaniaSeguroDTO(){
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<TarifaDTO> getTarifas() {
		return tarifas;
	}

	public void setTarifas(List<TarifaDTO> tarifas) {
		this.tarifas = tarifas;
	}
}
