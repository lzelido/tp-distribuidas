package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name = "ItemFactura")
public class ItemFactura extends UnicastRemoteObject{
	@Transient
	private static final long serialVersionUID = -2186345924010962993L;
	
	@Id
	@Column (name = "IdItemFactura", nullable = false)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	
	@Column (name = "Cantidad")
	private int cantidad;
	
	@OneToOne
	@JoinColumn (name = "IdCarga")
	private Carga carga;
	
	@Column (name = "PrecioUnitario")
	private float precioUnitario;
	
	@Column (name = "SubTotal")
	private float subTotal;
	
	@ManyToOne
	@JoinColumn (name = "IdFactura")
	private Factura factura;

	// CONSTRUCTOR
	public ItemFactura() throws RemoteException{
		
	}

	// GETTERS y SETTERS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public Carga getCarga() {
		return carga;
	}

	public void setCarga(Carga carga) {
		this.carga = carga;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
	
	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	// METODOS
	public float calcularSubtotal (){
		return (this.cantidad*this.precioUnitario);
	}
}
