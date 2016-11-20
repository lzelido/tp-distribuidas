package dto;

import java.io.Serializable;

public class ItemFacturaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private int cantidad;
	private CargaDTO carga;
	private float precioUnitario;
	private float subTotal;
	
	public ItemFacturaDTO(){
		
	}

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
	
	public CargaDTO getCarga() {
		return carga;
	}

	public void setCarga(CargaDTO carga) {
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
}
