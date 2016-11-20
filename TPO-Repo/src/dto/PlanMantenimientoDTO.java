package dto;

import java.sql.Date;
import java.util.List;

public class PlanMantenimientoDTO {
	
	private int codigo;
	
	private int kilometros;
	private Date fecha;
	private List<TareaDTO> tareasARealizar;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getKilometros() {
		return kilometros;
	}
	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public List<TareaDTO> getTareasARealizar() {
		return tareasARealizar;
	}
	public void setTareasARealizar(List<TareaDTO> tareasARealizar) {
		this.tareasARealizar = tareasARealizar;
	}
	
	

	
}
