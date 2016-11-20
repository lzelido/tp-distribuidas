package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import dto.EmpleadoDTO;

@Entity
@Table(name= "Empleado")
public class Empleado {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name="Numero")
	private int numero;
	
	@Column (name="Nombre")
	private String nombre;
	
	@Column(name="Apellido")
	private String apellido;
	
	@Column(name="Puesto")
	private String puesto;
		
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public static List<Empleado> fromDtos(List<EmpleadoDTO> dtos) {
		List<Empleado> empleados = new ArrayList<Empleado>();
		for (EmpleadoDTO dto: dtos) {
			empleados.add(fromDto(dto));
		}
		return empleados;
	}

	public static Empleado fromDto(EmpleadoDTO dto) {
		Empleado emp = new Empleado();
		emp.setApellido(dto.getApellido());
		emp.setNombre(dto.getNombre());
		emp.setNumero(dto.getNumero());
		emp.setPuesto(dto.getPuesto());
		return null;
	}	
}



