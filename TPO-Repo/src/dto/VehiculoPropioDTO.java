package dto;

public class VehiculoPropioDTO extends VehiculoDTO{
	private static final long serialVersionUID = -8464612099601140095L;
	private String informacionRegistro;
	private int kilometraje;
	private int vidaUtil;
	private boolean activo;
	private boolean enMantenimiento;
	
	public VehiculoPropioDTO(){
		super();
	}

	public String getInformacionRegistro() {
		return informacionRegistro;
	}

	public void setInformacionRegistro(String informacionRegistro) {
		this.informacionRegistro = informacionRegistro;
	}

	public int getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}

	public int getVidaUtil() {
		return vidaUtil;
	}

	public void setVidaUtil(int vidaUtil) {
		this.vidaUtil = vidaUtil;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public boolean isEnMantenimiento() {
		return enMantenimiento;
	}

	public void setEnMantenimiento(boolean enMantenimiento) {
		this.enMantenimiento = enMantenimiento;
	}
	
	public boolean esKilometros(){
		if(kilometraje >= 0)
				return true;
		return false;
	}
	
	public boolean esTemporal(){
		if(vidaUtil > 0)
				return true;
		return false;
	}
}
