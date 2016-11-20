package dto;

import java.io.Serializable;

public class UbicacionDTO implements Serializable{
	private static final long serialVersionUID = 3629123930076254716L;
	private int codigo;
	private String calle;
	private int numero;
	private int piso;
	private String depto;
	private String codPost;
	private String localidad;
	private String provincia;
	private GPSDTO gps;
	
	// CONSTRUCTOR
	public UbicacionDTO(){
		
	}
	
	// GETTERS Y SETTERS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getCalle() {
		return calle;
	}
	
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public String getCodPost() {
		return codPost;
	}
	
	public void setCodPost(String codPost) {
		this.codPost = codPost;
	}
	
	public String getLocalidad() {
		return localidad;
	}
	
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	public String getProvincia() {
		return provincia;
	}
	
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public GPSDTO getGps() {
		return gps;
	}
	
	public void setGps(GPSDTO gps) {
		this.gps = gps;
	}
	
	public String toString (){
		if (this.gps == null){
			if (this.piso == 0){
				if (this.depto.equals("")){// Casa
					return (this.codigo+" - "+this.calle+" "+this.numero+". "+this.localidad
							+" - "+this.provincia+" ("+this.codPost+")");
				}else{// Edificio de un piso y varios deptos
					return (this.codigo+" - "+this.calle+" "+this.numero+" depto "+this.depto	+". "+this.localidad
							+" - "+this.provincia+" ("+this.codPost+")");
				}
			}else{// Edificio
				if (this.depto.equals("")){// Un depto por piso
					return (this.codigo+" - "+this.calle+" "+this.numero+" piso "+this.piso+". "
							+this.localidad+" - "+this.provincia+" ("+this.codPost+")");
				}else{// Varios deptos por piso
					return (this.codigo+" - "+this.calle+" "+this.numero+" piso "+this.piso+" depto "+this.depto+". "
							+this.localidad+" - "+this.provincia+" ("+this.codPost+")");
				}
			}
		}else{
			if (this.piso == 0){
				if (this.depto.equals("")){// Casa
					return (this.codigo+" - "+this.calle+" "+this.numero+" depto "+this.depto	+". "+this.localidad
							+" - "+this.provincia+" ("+this.codPost+")"
							+". "+this.gps.getGradosLat()+"° "+this.gps.getMinutosLat()+"' "+this.gps.getSegundosLat()+"'' "+this.gps.getLatitud()+" "
							+this.gps.getGradosLon()+"° "+this.gps.getMinutosLon()+"' "+this.gps.getSegundosLon()+"'' "+this.gps.getLongitud());
				}else{// Edificio de un piso y varios deptos
					return (this.codigo+" - "+this.calle+" "+this.numero+" depto "+this.depto	+". "+this.localidad
							+" - "+this.provincia+" ("+this.codPost+")"
							+". "+this.gps.getGradosLat()+"° "+this.gps.getMinutosLat()+"' "+this.gps.getSegundosLat()+"'' "+this.gps.getLatitud()+" "
							+this.gps.getGradosLon()+"° "+this.gps.getMinutosLon()+"' "+this.gps.getSegundosLon()+"'' "+this.gps.getLongitud());
				}
			}else{// Edificio
				if (this.depto.equals("")){// Un depto por piso
					return (this.codigo+" - "+this.calle+" "+this.numero+" piso "+this.piso+". "
							+this.localidad+" - "+this.provincia+" ("+this.codPost+")"
							+". "+this.gps.getGradosLat()+"° "+this.gps.getMinutosLat()+"' "+this.gps.getSegundosLat()+"'' "+this.gps.getLatitud()+" "
							+this.gps.getGradosLon()+"° "+this.gps.getMinutosLon()+"' "+this.gps.getSegundosLon()+"'' "+this.gps.getLongitud());
				}else{// Varios deptos por piso
					return (this.codigo+" - "+this.calle+" "+this.numero+" piso "+this.piso+" depto "+this.depto+". "
							+this.localidad+" - "+this.provincia+" ("+this.codPost+")"
							+". "+this.gps.getGradosLat()+"° "+this.gps.getMinutosLat()+"' "+this.gps.getSegundosLat()+"'' "+this.gps.getLatitud()+" "
							+this.gps.getGradosLon()+"° "+this.gps.getMinutosLon()+"' "+this.gps.getSegundosLon()+"'' "+this.gps.getLongitud());
				}
			}
		}
	}
}
