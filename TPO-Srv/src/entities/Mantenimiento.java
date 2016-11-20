package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dto.MantenimientoDTO;
import dto.TareaDTO;

@Entity
@Table (name = "mantenimientos")
public class Mantenimiento {
	@Transient
	private static final long serialVersionUID = -5537103523134162192L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="codigo_mantenimiento")
	private int codigo;
	
	
	private Date fecha;
	
	
	private int kilometraje;
	
	@ManyToMany (cascade = CascadeType.ALL)  
    @JoinTable (name="mantenimiento_tarea", joinColumns = @JoinColumn (name="codigo_mantenimiento"), inverseJoinColumns=@JoinColumn(name="codigo_tarea"))  
	private List<Tarea> tareas;
	
	@ManyToOne
	@JoinColumn (name = "codigo")
	private Taller taller;
	
	@ManyToOne
	@JoinColumn (name = "matricula")
	private Vehiculo vehiculo;
	
	public Mantenimiento() {
		super();
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

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public Taller getTaller() {
		return taller;
	}

	public void setTaller(Taller taller) {
		this.taller = taller;
	}
	
	public MantenimientoDTO toDto(){
		MantenimientoDTO m = new MantenimientoDTO();
		m.setCodigo(codigo);
		m.setFecha(fecha);
		m.setKilometraje(kilometraje);
		m.setTaller(taller.toDto());
		
		List<TareaDTO> tareasDTO = new ArrayList<TareaDTO>();
		for (Tarea t : tareas){
			tareasDTO.add(t.toDto());
		}
		m.setTareas(tareasDTO);
		return m;
	}

	public static List<Mantenimiento> fromDtos(List<MantenimientoDTO> dtos) {
		List<Mantenimiento> mantenimientos = new ArrayList<Mantenimiento>();
		for (MantenimientoDTO dto : dtos) {
			mantenimientos.add(fromDto(dto));
		}
		return mantenimientos;
	}

	private static Mantenimiento fromDto(MantenimientoDTO dto) {
		Mantenimiento mantenimiento = new Mantenimiento();
		mantenimiento.setCodigo(dto.getCodigo());
		mantenimiento.setFecha(dto.getFecha());
		mantenimiento.setKilometraje(dto.getKilometraje());
		mantenimiento.setTaller(Taller.fromDto(dto.getTaller()));
		mantenimiento.setTareas(Tarea.fromDtos(dto.getTareas()));
		return mantenimiento;
	}
}
