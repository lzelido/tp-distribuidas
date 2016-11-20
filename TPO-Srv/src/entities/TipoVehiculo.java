package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import dto.TipoVehiculoDTO;

@Entity
@Table(name="tipos_vehiculos")
public class TipoVehiculo {
	@Transient
	private static final long serialVersionUID = -7350922470086600779L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	private String descri;
	private boolean tieneCondEspecial;
	private String condicion;
	
	public TipoVehiculo(){
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescri() {
		return descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	public boolean isTieneCondEspecial() {
		return tieneCondEspecial;
	}

	public void setTieneCondEspecial(boolean tieneCondEspecial) {
		this.tieneCondEspecial = tieneCondEspecial;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
	
	public TipoVehiculoDTO toDto(){
		TipoVehiculoDTO t = new TipoVehiculoDTO();
		t.setCodigo(codigo);
		t.setCondicion(condicion);
		t.setDescri(descri);
		t.setTieneCondEspecial(tieneCondEspecial);
		return t;
	}

	public static TipoVehiculo fromDto(TipoVehiculoDTO dto) {
		TipoVehiculo tipoVehiculo = new TipoVehiculo();
		
		return null;
	}
}
