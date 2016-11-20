package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FacturaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private ClienteDTO cliente;
	private Date fechaEmision;
	private SucursalDTO sucursal;
	private EmpleadoDTO empleado;
	private float total;
	private List<ItemFacturaDTO> items;
	
	public FacturaDTO(){
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public SucursalDTO getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalDTO sucursal) {
		this.sucursal = sucursal;
	}

	public EmpleadoDTO getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoDTO empleado) {
		this.empleado = empleado;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public List<ItemFacturaDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemFacturaDTO> items) {
		this.items = items;
	}
}
