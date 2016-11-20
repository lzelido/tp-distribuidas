package dto;

import java.io.Serializable;

public class TipoMercaderiaDTO implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String descripcion;
	 
	public TipoMercaderiaDTO(){
		super();
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
	@Override
	public String toString() {
		return "Mercaderia:\n\tCódigo:"+codigo+"\n\tDescripcion:"+descripcion+"\n";
	}
}
