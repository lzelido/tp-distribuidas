package dto;

import java.io.Serializable;

public class CategoriaFragilidadDTO implements Serializable{
	private static final long serialVersionUID = 8610284206268845658L;
	private int codigo;
	private String descri;
	
	public CategoriaFragilidadDTO(){
		
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
}
