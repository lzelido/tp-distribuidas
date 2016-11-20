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

import dto.ProductoDTO;

@Entity
@Table(name = "Producto")
public class Producto{
	@Transient
	private static final long serialVersionUID = -1356051695474367343L;
	
	@Id
	@Column (name = "IdProducto", nullable = false)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	
	@Column (name = "Descripcion")
	private String descrip;
	
	@ManyToOne
	@JoinColumn (name = "IdCliente")
	private Empresa empresa;
	
	
	// GETTERS Y SETTERS
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

	public static List<Producto> fromDtos(List<ProductoDTO> dtos) {
		List<Producto> productos = new ArrayList<Producto>();
		for (ProductoDTO dto : dtos) {
			productos.add(fromDto(dto));
		}
		return productos;
	}

	private static Producto fromDto(ProductoDTO dto) {
		Producto producto = new Producto();
		producto.setCodigo(dto.getCodigo());
		producto.setDescrip(dto.getDescrip());
		return producto;
	}
}
