package dto;

import java.io.Serializable;

public class CategoriaTratamientoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8944192916644756008L;
	private int codigo;
	private String descri;
	
	public CategoriaTratamientoDTO(){
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
