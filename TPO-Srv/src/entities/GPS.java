package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import dto.GPSDTO;

@Entity
@Table (name = "GPS")
public class GPS{
	@Transient
	private static final long serialVersionUID = -5836260780885276535L;
	
	@Id
	@Column(name = "IdGPS", nullable = false)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	
	@Column(name = "Latitud")
	private String latitud;
	
	@Column(name = "GradosLat")
	private int gradosLat;
	
	@Column(name = "MinutosLat")
	private int minutosLat;
	
	@Column(name = "SegundoLat")
	private int segundosLat;
	
	@Column(name = "Longitud")
	private String longitud;
	
	@Column(name = "GradosLon")
	private int gradosLon;
	
	@Column(name = "MinutosLon")
	private int minutosLon;
	
	@Column(name = "SegundosLon")
	private int segundosLon;
	
	public GPS() {
		
	}
	
	public GPS (GPSDTO gps) {
		this.latitud = gps.getLatitud();
		this.gradosLat = gps.getGradosLat();
		this.minutosLat = gps.getMinutosLat();
		this.segundosLat = gps.getSegundosLat();
		
		this.longitud = gps.getLongitud();
		this.gradosLon = gps.getGradosLon();
		this.minutosLon = gps.getMinutosLon();
		this.segundosLon = gps.getSegundosLon();
	}
	
	// GETTERS Y SETTERS
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
	
	public GPSDTO toDto() {
		GPSDTO g = new GPSDTO();
		g.setCodigo(codigo);
		g.setGradosLat(gradosLat);
		g.setGradosLon(gradosLon);
		g.setLatitud(latitud);
		g.setLongitud(longitud);
		g.setMinutosLat(minutosLat);
		g.setMinutosLon(minutosLon);
		g.setSegundosLat(segundosLat);
		g.setSegundosLon(segundosLon);
		return g;
	}

	public static GPS fromDto(GPSDTO dto) {
		GPS gps = new GPS();
		gps.latitud = dto.getLatitud();
		gps.gradosLat = dto.getGradosLat();
		gps.minutosLat = dto.getMinutosLat();
		gps.segundosLat = dto.getSegundosLat();
		
		gps.longitud = dto.getLongitud();
		gps.gradosLon = dto.getGradosLon();
		gps.minutosLon = dto.getMinutosLon();
		gps.segundosLon = dto.getSegundosLon();
		
		return gps;
	}
}