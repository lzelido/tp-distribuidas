package dto;

import java.io.Serializable;

public class ProductoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String descrip;
	
	// CONSTRUCTOR
	public ProductoDTO(){
		
	}

	// GETTERS Y SETTERS
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
	
	public String toString(){
		return (this.codigo+" - "+this.descrip);
	}
}
