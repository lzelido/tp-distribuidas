package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dto.TareaDTO;

@Entity
@Table (name = "tareas")
public class Tarea  {
	@Transient
	private static final long serialVersionUID = -4682851469202781285L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "id")
	private int codigo;
	private String descrip;
	private boolean esEspecifica;
	private int periodicidad;
	
	@ManyToOne
	@JoinColumn (name = "codigo")
	private Unidad unidadPeriodicidad;
	
	public Tarea() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public boolean isEsEspecifica() {
		return esEspecifica;
	}

	public void setEsEspecifica(boolean esEspecifica) {
		this.esEspecifica = esEspecifica;
	}

	public int getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(int periodicidad) {
		this.periodicidad = periodicidad;
	}

	public Unidad getUnidadPeriodicidad() {
		return unidadPeriodicidad;
	}

	public void setUnidadPeriodicidad(Unidad unidadPeriodicidad) {
		this.unidadPeriodicidad = unidadPeriodicidad;
	}
	
	public TareaDTO toDto(){
		TareaDTO t = new TareaDTO();
		t.setCodigo(codigo);
		t.setDescrip(descrip);
		t.setEsEspecifica(esEspecifica);
		t.setPeriodicidad(periodicidad);
		t.setUnidadPeriodicidad(unidadPeriodicidad.toDto());
		return t;
	}

	public static List<Tarea> fromDtos(List<TareaDTO> dtos) {
		List<Tarea> tareas = new ArrayList<Tarea>();
		for (TareaDTO dto : dtos) {
			tareas.add(fromDto(dto));
		}
		return tareas;
	}

	private static Tarea fromDto(TareaDTO dto) {
		Tarea tarea = new Tarea();
		tarea.setCodigo(dto.getCodigo());
		tarea.setDescrip(dto.getDescrip());
		tarea.setEsEspecifica(dto.isEsEspecifica());
		tarea.setPeriodicidad(dto.getPeriodicidad());
		tarea.setUnidadPeriodicidad(Unidad.fromDto(dto.getUnidadPeriodicidad()));
		return tarea;
	}
}

