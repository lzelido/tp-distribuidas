package dto;

import java.io.Serializable;

public class TallerDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nombre;
	private UbicacionDTO ubicacion;
	
	public TallerDTO(){
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public UbicacionDTO getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(UbicacionDTO ubicacion) {
		this.ubicacion = ubicacion;
	}
}
