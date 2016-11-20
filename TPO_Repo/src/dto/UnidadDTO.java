package dto;

import java.io.Serializable;

public class UnidadDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String descri;
	private String tipo;

	public UnidadDTO(){
		
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
	
	public String toString(){
		return descri;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    if (getClass() != obj.getClass()) {
	        return false;
	    }
	    final UnidadDTO other = (UnidadDTO) obj;
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