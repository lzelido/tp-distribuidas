package dto;

import java.io.Serializable;
import java.util.List;

public class SucursalDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nombre;
	private UbicacionDTO ubicacion;
	private EmpleadoDTO gerente;
	private EmpleadoDTO encargadoDeposito;
	private EmpleadoDTO encargadoDespacho;
	private EmpleadoDTO encargadoRecepcion;
	private List<EmpleadoDTO> empleados;
	private RutaDTO ruta;
	
	public SucursalDTO(){
		
	}

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

	public UbicacionDTO getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(UbicacionDTO ubicacion) {
		this.ubicacion = ubicacion;
	}

	public EmpleadoDTO getGerente() {
		return gerente;
	}

	public void setGerente(EmpleadoDTO gerente) {
		this.gerente = gerente;
	}

	public EmpleadoDTO getEncargadoDeposito() {
		return encargadoDeposito;
	}

	public void setEncargadoDeposito(EmpleadoDTO encargadoDeposito) {
		this.encargadoDeposito = encargadoDeposito;
	}

	public EmpleadoDTO getEncargadoDespacho() {
		return encargadoDespacho;
	}

	public void setEncargadoDespacho(EmpleadoDTO encargadoDespacho) {
		this.encargadoDespacho = encargadoDespacho;
	}

	public EmpleadoDTO getEncargadoRecepcion() {
		return encargadoRecepcion;
	}

	public void setEncargadoRecepcion(EmpleadoDTO encargadoRecepcion) {
		this.encargadoRecepcion = encargadoRecepcion;
	}

	public List<EmpleadoDTO> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<EmpleadoDTO> empleados) {
		this.empleados = empleados;
	}

	public RutaDTO getRuta() {
		return ruta;
	}

	public void setRuta(RutaDTO ruta) {
		this.ruta = ruta;
	}
}
