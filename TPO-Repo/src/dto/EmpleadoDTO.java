package dto;

import java.io.Serializable;

public class EmpleadoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int numero;
	private String nombre;
	private String apellido;
	private String puesto;
			
	public EmpleadoDTO(){
		super();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String toString(){
		return (this.numero+" - "+this.apellido+", "+this.nombre);
	}
}
