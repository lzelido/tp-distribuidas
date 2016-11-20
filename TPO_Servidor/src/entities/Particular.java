package entities;

import java.rmi.RemoteException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name = "Particular")
@Inheritance (strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn (name = "IdCliente")
public class Particular extends Cliente{
	@Transient
	private static final long serialVersionUID = -3413901829279331340L;
	
	@Column (name = "PagoAdelantado")
	private boolean esPagoAdelantado;

	public Particular() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// GETTERS Y SETTERS
	public boolean isEsPagoAdelantado() {
		return esPagoAdelantado;
	}
	
	public void setEsPagoAdelantado(boolean esPagoAdelantado) {
		this.esPagoAdelantado = esPagoAdelantado;
	}
}
