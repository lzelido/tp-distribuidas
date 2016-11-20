package entities;

import java.util.List;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dto.SucursalDTO;

@Entity
@Table(name= "Sucursal")
public class Sucursal{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name="Codigo")
	private int codigo;
	
	@Column (name="Nombre")
	private String nombre;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (name="Ubicacion")
	private Ubicacion ubicacion;
	
	@OneToOne
	@JoinColumn (name="Gerente")
	private Empleado gerente;
	
	@OneToOne
	@JoinColumn (name="EncargadoDeposito")
	private Empleado encargadoDeposito;
	
	@OneToOne
	@JoinColumn (name="EncargadoDespacho")
	private Empleado encargadoDespacho;
	
	@OneToOne
	@JoinColumn (name="EncargadoRecepcion")
	private Empleado encargadoRecepcion;
	
	@OneToMany
	private List<Empleado> empleados;
	
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

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Empleado getGerente() {
		return gerente;
	}

	public void setGerente(Empleado gerente) {
		this.gerente = gerente;
	}

	public Empleado getEncargadoDeposito() {
		return encargadoDeposito;
	}

	public void setEncargadoDeposito(Empleado encargadoDeposito) {
		this.encargadoDeposito = encargadoDeposito;
	}

	public Empleado getEncargadoDespacho() {
		return encargadoDespacho;
	}

	public void setEncargadoDespacho(Empleado encargadoDespacho) {
		this.encargadoDespacho = encargadoDespacho;
	}

	public Empleado getEncargadoRecepcion() {
		return encargadoRecepcion;
	}

	public void setEncargadoRecepcion(Empleado encargadoRecepcion) {
		this.encargadoRecepcion = encargadoRecepcion;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public static Sucursal fromDto(SucursalDTO dto) {
		Sucursal suc = new Sucursal();
		suc.setCodigo(dto.getCodigo());
		suc.setEmpleados(Empleado.fromDtos(dto.getEmpleados()));
		suc.setEncargadoDeposito(Empleado.fromDto(dto.getEncargadoDeposito()));
		suc.setEncargadoDespacho(Empleado.fromDto(dto.getEncargadoDespacho()));
		suc.setEncargadoRecepcion(Empleado.fromDto(dto.getEncargadoRecepcion()));
		suc.setGerente(Empleado.fromDto(dto.getGerente()));
		suc.setNombre(dto.getNombre());
		suc.setUbicacion(Ubicacion.fromDto(dto.getUbicacion()));
		return null;
	}

//	public Ruta getRuta() {
//		return ruta;
//	}
//
//	public void setRuta(Ruta ruta) {
//		this.ruta = ruta;
//	}
}
