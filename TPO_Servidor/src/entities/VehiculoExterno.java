package entities;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import dto.MantenimientoDTO;
import dto.VehiculoExternoDTO;

@Entity
@Table (name = "vehiculo_externo")
@Inheritance (strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn (name = "matricula")
public class VehiculoExterno extends Vehiculo{
	@Transient
	private static final long serialVersionUID = -1554224249482832196L;
	
	@OneToOne
	@JoinColumn (name = "codigo_proveedor")
	public Proveedor proveedor;	
	
	public VehiculoExterno() throws RemoteException {
		super();
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public VehiculoExternoDTO getDTO(){
		VehiculoExternoDTO v = new VehiculoExternoDTO();
		v.setCondicionesTransp(getCondicionesTransp());
		v.setGarantiaHasta(getGarantiaHasta());
		
		List<MantenimientoDTO> mantenimientosDTO = new ArrayList<MantenimientoDTO>();
		
		for (Mantenimiento m : getMantenimientos()){
			mantenimientosDTO.add(m.getDTO());
		}
		
		v.setMantenimientos(mantenimientosDTO);
		v.setMatricula(getMatricula());
		v.setProveedor(proveedor.getDTO());
		v.setTara(getTara());
		v.setTipo(getTipo().getDTO());
		v.setUnidadTara(getUnidadTara().getDTO());
		v.setUnidadVol(getUnidadVol().getDTO());
		v.setVolumen(getVolumen());
		return v;
	}
}
