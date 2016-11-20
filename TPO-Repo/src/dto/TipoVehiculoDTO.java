package dto;

import java.io.Serializable;

public class TipoVehiculoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String descri;
	private boolean tieneCondEspecial;
	private String condicion;
	
	public TipoVehiculoDTO(){
		
	}

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

	public boolean isTieneCondEspecial() {
		return tieneCondEspecial;
	}

	public void setTieneCondEspecial(boolean tieneCondEspecial) {
		this.tieneCondEspecial = tieneCondEspecial;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
	
	public String toString(){
		return descri;
	}
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    if (getClass() != obj.getClass()) {
	        return false;
	    }
	    final TipoVehiculoDTO other = (TipoVehiculoDTO) obj;
	    if ((this.codigo <0) ? (other.codigo >0) : !(this.codigo==other.codigo)) {
	        return false;
	    }
	    return true;
	}

	@Override
	public int hashCode() {
	    int hash = 3;
	    hash = 53 * hash + (this.codigo >0 ? Integer.valueOf(this.codigo).hashCode() : 0);
	    hash = 53 * hash + this.codigo;
	    return hash;
	}
}