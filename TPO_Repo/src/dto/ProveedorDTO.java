package dto;

import java.io.Serializable;

public abstract class ProveedorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nombre;
	private String telefono;
	private VehiculoExternoDTO vehiculo;
	
	public ProveedorDTO(){
		
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public VehiculoExternoDTO getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculoExternoDTO vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	public String toString(){
		return this.nombre;
	}
}