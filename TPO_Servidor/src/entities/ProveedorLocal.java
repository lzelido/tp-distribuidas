package entities;

import java.rmi.RemoteException;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import dto.ProveedorLocalDTO;

@Entity
@Table (name = "proveedores_locales")
@Inheritance (strategy = InheritanceType.JOINED)
public class ProveedorLocal extends Proveedor{
	@Transient
	private static final long serialVersionUID = -5074347912033042188L;

	public ProveedorLocal() throws RemoteException{
		super();
	}
	
	@Override
	public ProveedorLocalDTO getDTO(){	
		ProveedorLocalDTO p = new ProveedorLocalDTO();
		p.setCodigo(getCodigo());
		p.setNombre(getNombre());
		p.setTelefono(getTelefono());
		return p;
	}
}