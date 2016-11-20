package dto;

import java.io.Serializable;
import java.rmi.RemoteException;

public class ItemRemitoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private CargaDTO carga;
	private RemitoDTO remito;
	
	// CONSTRUCTOR
	public ItemRemitoDTO() throws RemoteException {
		
	}

	// GETTERS y SETTERS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public CargaDTO getCarga() {
		return carga;
	}

	public void setCarga(CargaDTO carga) {
		this.carga = carga;
	}
	
	public RemitoDTO getRemito() {
		return remito;
	}

	public void setRemito(RemitoDTO remito) {
		this.remito = remito;
	}
}
