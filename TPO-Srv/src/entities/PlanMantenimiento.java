package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import dto.PlanMantenimientoDTO;

@Entity
@Table (name = "plan_mantenimiento")
public class PlanMantenimiento {
	protected PlanMantenimiento()  {
		super();
	}

	@Transient
	private static final long serialVersionUID = -5537103523134162192L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	
	private int kilometros;
	private Date fecha;

	
	@ManyToMany (cascade = CascadeType.ALL)  
    @JoinTable (name="planMantenimiento_tarea", joinColumns = @JoinColumn (name="codigo_mantenimiento"), inverseJoinColumns=@JoinColumn(name="codigo_tarea"))  
	private List<Tarea> tareasARealizar;


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


	public List<Tarea> getTareasARealizar() {
		return tareasARealizar;
	}


	public void setTareasARealizar(List<Tarea> tareasARealizar) {
		this.tareasARealizar = tareasARealizar;
	}	
	
	public boolean esKilometros(){
		if(kilometros>0){
			return true;
		}
		return false;
	}


	public static PlanMantenimiento fromDto(PlanMantenimientoDTO dto) {
		PlanMantenimiento plan = new PlanMantenimiento();
		plan.setCodigo(dto.getCodigo());
		plan.setFecha(dto.getFecha());
		plan.setKilometros(dto.getKilometros());
		plan.setTareasARealizar(Tarea.fromDtos(dto.getTareasARealizar()));
		return plan;
	}
}
