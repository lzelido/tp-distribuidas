package dto;

import java.io.Serializable;
import java.util.List;

public abstract class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nombre;
	private String tipoDoc;
	private String nroDoc;
	private List<SolicitudEnvioDTO> solicitudes;
	private boolean reqManifiesto;
	private boolean activo;
	
	// CONSTRUCTOR
	public ClienteDTO(){
		
	}
	
	// GETTERS Y SETTERS
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
		
	public String getTipoDoc() {
		return tipoDoc;
	}
	
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	
	public String getNroDoc() {
		return nroDoc;
	}
	
	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}
		
	public List<SolicitudEnvioDTO> getSolicitudes() {
		return solicitudes;
	}
	
	public void setSolicitudes(List<SolicitudEnvioDTO> solicitudes) {
		this.solicitudes = solicitudes;
	}
	
	public boolean isReqManifiesto() {
		return reqManifiesto;
	}
		
	public void setReqManifiesto(boolean reqManifiesto) {
		this.reqManifiesto = reqManifiesto;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
