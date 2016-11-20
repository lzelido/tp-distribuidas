package dto;

import java.io.Serializable;

public class PersonaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int dni;
	private String nombre;
	 
	public PersonaDTO(int dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}
	
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Persona:\n\tDNI:"+dni+"\n\tNombre:"+nombre+"\n";
	}
	
}