package dto;

public class VehiculoExternoDTO extends VehiculoDTO{
	private static final long serialVersionUID = -7731622015347469875L;
	public ProveedorDTO proveedor;
	
	public VehiculoExternoDTO(){
		super();
	}

	public ProveedorDTO getProveedor() {
		return proveedor;
	}

	public void setProveedor(Object proveedor) {
		this.proveedor = (ProveedorDTO) proveedor;
	}
}