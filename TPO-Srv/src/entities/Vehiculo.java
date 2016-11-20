package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dto.VehiculoDTO;

@Entity
@Table (name = "vehiculos")
@Inheritance (strategy = InheritanceType.JOINED)
public class Vehiculo{
	@Transient
	private static final long serialVersionUID = 9207757951245561912L;
	
	@Id
	private String matricula;
	
	@Column (name="volumen")
	private float volumen;
	
	@Column(name="tara")
	private float tara;
	
	@Column(name="condiciones_transporte")
	private String condicionesTransp;
	
	@Column(name="garantia_hasta")
	private Date garantiaHasta;

	@ManyToOne
	@JoinColumn (name = "codigo_tara")
	private Unidad unidadTara;
	
	@ManyToOne
	@JoinColumn (name = "codigo_volumen")
	private Unidad unidadVol;

	@ManyToOne
	@JoinColumn (name = "codigo_tipo_vehiculo")
	private TipoVehiculo tipo;
	
	@OneToOne
	@JoinColumn (name = "codigo")
	private PlanMantenimiento planMantenimiento;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn (name = "matricula")
	private List<Mantenimiento> mantenimientos;
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public TipoVehiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVehiculo tipo) {
		this.tipo = tipo;
	}

	public float getVolumen() {
		return volumen;
	}

	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}

	public Unidad getUnidadVol() {
		return unidadVol;
	}

	public void setUnidadVol(Unidad unidadVol) {
		this.unidadVol = unidadVol;
	}

	public float getTara() {
		return tara;
	}

	public void setTara(float tara) {
		this.tara = tara;
	}

	public Unidad getUnidadTara() {
		return unidadTara;
	}

	public void setUnidadTara(Unidad unidadTara) {
		this.unidadTara = unidadTara;
	}

	public String getCondicionesTransp() {
		return condicionesTransp;
	}

	public void setCondicionesTransp(String condicionesTransp) {
		this.condicionesTransp = condicionesTransp;
	}

	public List<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}

	public void setMantenimientos(List<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}

	public Date getGarantiaHasta() {
		return garantiaHasta;
	}

	public void setGarantiaHasta(Date garantiaHasta) {
		this.garantiaHasta = garantiaHasta;
	}

	public PlanMantenimiento getPlanMantenimiento() {
		return planMantenimiento;
	}

	public void setPlanMantenimiento(PlanMantenimiento planMantenimiento) {
		this.planMantenimiento = planMantenimiento;
	}

	public static Vehiculo fromDto(VehiculoDTO dto) {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setCondicionesTransp(dto.getCondicionesTransp());
		vehiculo.setGarantiaHasta(dto.getGarantiaHasta());
		vehiculo.setMantenimientos(Mantenimiento.fromDtos(dto.getMantenimientos()));
		vehiculo.setMatricula(dto.getMatricula());
		vehiculo.setPlanMantenimiento(PlanMantenimiento.fromDto(dto.getPlanMantenimiento()));
		vehiculo.setTara(dto.getTara());
		vehiculo.setTipo(TipoVehiculo.fromDto(dto.getTipo()));
		vehiculo.setUnidadTara(Unidad.fromDto(dto.getUnidadTara()));
		vehiculo.setUnidadVol(Unidad.fromDto(dto.getUnidadVol()));
		return vehiculo;
	}
}

