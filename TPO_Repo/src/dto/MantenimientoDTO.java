package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MantenimientoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private Date fecha;
	private int kilometraje;
	private List<TareaDTO> tareas;
	private TallerDTO taller;
	
	public MantenimientoDTO(){
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}

	public List<TareaDTO> getTareas() {
		return tareas;
	}

	public void setTareas(List<TareaDTO> tareas) {
		this.tareas = tareas;
	}

	public TallerDTO getTaller() {
		return taller;
	}

	public void setTaller(TallerDTO taller) {
		this.taller = taller;
	}
}
