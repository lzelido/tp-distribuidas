package entities;

import java.rmi.RemoteException;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import dto.CarrierDTO;

@Entity
@Table (name = "carriers")
@Inheritance (strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn (name = "codigo")
public class Carrier extends Proveedor {
	@Transient
	private static final long serialVersionUID = -6222229083159313284L;
	
	public Carrier() throws RemoteException{
		super();
	}
	
	@Override
	public CarrierDTO getDTO(){	
		CarrierDTO p = new CarrierDTO();
		p.setCodigo(getCodigo());
		p.setNombre(getNombre());
		p.setTelefono(getTelefono());
		return p;
	}
}