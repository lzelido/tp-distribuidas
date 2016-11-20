package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dto.ProveedorDTO;

@Entity
@Table (name = "proveedores")
@Inheritance (strategy = InheritanceType.JOINED)
public class Proveedor extends UnicastRemoteObject{
	@Transient
	private static final long serialVersionUID = -9120338960143290416L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	private String nombre;
	private String telefono;
	
	@OneToOne
	@JoinColumn (name = "codigo_vehiculo_externo")
	private VehiculoExterno vehiculo;

	protected Proveedor() throws RemoteException {
		super();
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public VehiculoExterno getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculoExterno vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	protected ProveedorDTO getDTO(){	
		return null;
	}
}
