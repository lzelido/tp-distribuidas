package dto;

import java.io.Serializable;

public class GPSDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String latitud;
	private int gradosLat;
	private int minutosLat;
	private int segundosLat;
	private String longitud;
	private int gradosLon;
	private int minutosLon;
	private int segundosLon;
	
// 	CONSTRUCTOR
	public GPSDTO(){

	}
	
//	GETTERS Y SETTERS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getLatitud() {
		return latitud;
	}
	
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	
	public int getGradosLat() {
		return gradosLat;
	}
	
	public void setGradosLat(int gradosLat) {
		this.gradosLat = gradosLat;
	}
	
	public int getMinutosLat() {
		return minutosLat;
	}
	
	public void setMinutosLat(int minutosLat) {
		this.minutosLat = minutosLat;
	}
	
	public int getSegundosLat() {
		return segundosLat;
	}
	
	public void setSegundosLat(int segundosLat) {
		this.segundosLat = segundosLat;
	}
	
	public String getLongitud() {
		return longitud;
	}
	
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	
	public int getGradosLon() {
		return gradosLon;
	}
	
	public void setGradosLon(int gradosLon) {
		this.gradosLon = gradosLon;
	}
	
	public int getMinutosLon() {
		return minutosLon;
	}
	
	public void setMinutosLon(int minutosLon) {
		this.minutosLon = minutosLon;
	}
	
	public int getSegundosLon() {
		return segundosLon;
	}
	
	public void setSegundosLon(int segundosLon) {
		this.segundosLon = segundosLon;
	}
}
