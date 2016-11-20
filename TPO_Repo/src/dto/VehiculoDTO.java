package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public abstract class VehiculoDTO implements Serializable{
	private static final long serialVersionUID = -865724686246199463L;
	private String matricula;
	private TipoVehiculoDTO tipo;
	private float volumen;
	private UnidadDTO unidadVol;
	private float tara;
	private UnidadDTO unidadTara;
	private String condicionesTransp;
	private List<MantenimientoDTO> mantenimientos;
	private Date garantiaHasta;
	
	public VehiculoDTO(){
		
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public TipoVehiculoDTO getTipo() {
		return tipo;
	}

	public void setTipo(TipoVehiculoDTO tipo) {
		this.tipo = tipo;
	}

	public float getVolumen() {
		return volumen;
	}

	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}

	public UnidadDTO getUnidadVol() {
		return unidadVol;
	}

	public void setUnidadVol(UnidadDTO unidadVol) {
		this.unidadVol = unidadVol;
	}

	public float getTara() {
		return tara;
	}

	public void setTara(float tara) {
		this.tara = tara;
	}

	public UnidadDTO getUnidadTara() {
		return unidadTara;
	}

	public void setUnidadTara(UnidadDTO unidadTara) {
		this.unidadTara = unidadTara;
	}

	public String getCondicionesTransp() {
		return condicionesTransp;
	}

	public void setCondicionesTransp(String condicionesTransp) {
		this.condicionesTransp = condicionesTransp;
	}

	public List<MantenimientoDTO> getMantenimientos() {
		return mantenimientos;
	}

	public void setMantenimientos(List<MantenimientoDTO> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}

	public Date getGarantiaHasta() {
		return garantiaHasta;
	}

	public void setGarantiaHasta(Date garantiaHasta) {
		this.garantiaHasta = garantiaHasta;
	}
	
	public String toString(){
		return matricula;
	}
}
