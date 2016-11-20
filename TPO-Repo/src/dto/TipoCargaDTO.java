package dto;

import java.io.Serializable;

public class TipoCargaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String descri;
	
	public TipoCargaDTO(){
		
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
