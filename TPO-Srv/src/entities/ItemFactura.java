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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dto.ItemFacturaDTO;

@Entity
@Table (name = "ItemFactura")
public class ItemFactura{
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
	
	public float calcularSubtotal(){
		this.subTotal = this.cantidad * this.precioUnitario;
		return this.subTotal;
	}

	public static List<ItemFactura> fromDtos(List<ItemFacturaDTO> dtos) {
		List<ItemFactura> items = new ArrayList<ItemFactura>();
		for (ItemFacturaDTO dto : dtos) {
			items.add(fromDto(dto));
		}
		return items;
	}

	private static ItemFactura fromDto(ItemFacturaDTO dto) {
		ItemFactura item = new ItemFactura();
		item.setCantidad(dto.getCantidad());
		item.setCarga(Carga.fromDto(dto.getCarga()));
		item.setCodigo(dto.getCodigo());
		item.setPrecioUnitario(dto.getPrecioUnitario());
		item.setSubTotal(dto.getSubTotal());
		return item;
	}
}
