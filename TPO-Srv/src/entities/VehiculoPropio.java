package entities;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import dto.MantenimientoDTO;
import dto.VehiculoPropioDTO;

@Entity
@Table (name = "vehiculo_propio")
@Inheritance (strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn (name = "matricula")
public class VehiculoPropio extends Vehiculo{
	@Transient
	private static final long serialVersionUID = 5121650106163667946L;
	private String informacionRegistro;
	private int kilometraje;
	private int vidaUtil;
	private boolean activo;
	private boolean enMantenimiento;
	
	public VehiculoPropio() throws RemoteException {
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
	
	public VehiculoPropioDTO getDTO(){
		VehiculoPropioDTO v = new VehiculoPropioDTO();
		v.setCondicionesTransp(getCondicionesTransp());
		v.setGarantiaHasta(getGarantiaHasta());
		
		List<MantenimientoDTO> mantenimientosDTO = new ArrayList<MantenimientoDTO>();
		
		for (Mantenimiento m : getMantenimientos()){
			mantenimientosDTO.add(m.toDto());
		}
		
		v.setMantenimientos(mantenimientosDTO);
		v.setMatricula(getMatricula());
		v.setTara(getTara());
		v.setTipo(getTipo().toDto());
		v.setUnidadTara(getUnidadTara().toDto());
		v.setUnidadVol(getUnidadVol().toDto());
		v.setVolumen(getVolumen());
		
		v.setInformacionRegistro(informacionRegistro);
		v.setKilometraje(kilometraje);
		v.setVidaUtil(vidaUtil);
		v.setActivo(activo);
		v.setEnMantenimiento(enMantenimiento);		
		
		return v;
	}
}
