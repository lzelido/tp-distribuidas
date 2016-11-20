package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name = "Factura")
public class Factura extends UnicastRemoteObject{
	@Transient
	private static final long serialVersionUID = 4483130853415656219L;
	
	@Id
	@Column (name = "IdFactura", nullable = false)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	
	@OneToOne
	@JoinColumn (name = "IdCliente")
	private Cliente cliente;
	
	@Column (name = "FechaEmision")
	private Date fechaEmision;
	
	@OneToOne
	@JoinColumn (name = "IdSucursal")
	private Sucursal sucursal;
	
	@OneToOne
	@JoinColumn (name = "IdEmpleado")
	private Empleado empleado;
	
	@Column (name = "Total")
	private float total;
	
	@Column (name = "Pago")
	private Boolean pago;

	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn (name = "IdFactura")
	private List<ItemFactura> items;
	
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn (name = "IdSolicitud")
	private SolicitudEnvio solicitudEnvio;
	
	
	// CONSTRUCTOR
	public Factura() throws RemoteException{
		
	}

	// GETTERS y SETTERS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}
	
	public Boolean isPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}
	
	// METODOS
	public float calcularTotal (){
		float total = 0F;
		
		for (ItemFactura item : this.items){
			total = total + item.calcularSubtotal();
		}
		
		return total;
	}

	public SolicitudEnvio getSolicitudEnvio() {
		return solicitudEnvio;
	}

	public void setSolicitudEnvio(SolicitudEnvio solicitudEnvio) {
		this.solicitudEnvio = solicitudEnvio;
	}
}
