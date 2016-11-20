package entities;

import java.rmi.RemoteException;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import dao.ClienteDAO;
import dto.EmpresaDTO;

@Entity
@Table (name = "Empresa")
@Inheritance (strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn (name = "IdCliente")
public class Empresa extends Cliente {
	@Transient
	private static final long serialVersionUID = 1098170089907829549L;
	
	@Column (name = "NroCuenta")
	private String nroCuenta;
	
	@Column (name = "CtaCte")
	private float ctaCte;
	
	@Column (name = "DepositoPrevio")
	private boolean esDepositoPrevio;
	
	@Column (name = "PagoMensual")
	private boolean esPagoMensual;
	
	@Column (name = "MontoMinAutoriz")
	private float montoMinAutoriz;
	
	@OneToMany
	@JoinColumn (name = "IdCliente")
	private List<Ubicacion> destinos;
	
	@OneToMany
	@JoinColumn (name = "IdCliente")
	private List<Producto> productos;
	
	// CONSTRUCTORES
	public Empresa(){
		super();
	}
	
	// GETTERS Y SETTERS
	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	
	public float getCtaCte() {
		return ctaCte;
	}
	
	public void setCtaCte(float ctaCte) {
		this.ctaCte = ctaCte;
	}

	public boolean isEsDepositoPrevio() {
		return esDepositoPrevio;
	}
	
	public void setEsDepositoPrevio(boolean esDepositoPrevio) {
		this.esDepositoPrevio = esDepositoPrevio;
	}
	
	public boolean isEsPagoMensual() {
		return esPagoMensual;
	}
	
	public void setEsPagoMensual(boolean esPagoMensual) {
		this.esPagoMensual = esPagoMensual;
	}
	
	public float getMontoMinAutoriz() {
		return montoMinAutoriz;
	}
	
	public void setMontoMinAutoriz(float montoMinAutoriz) {
		this.montoMinAutoriz = montoMinAutoriz;
	}
	
	public List<Ubicacion> getDestinos() {
		return destinos;
	}
	
	public void setDestinos(List<Ubicacion> destinos) {
		this.destinos = destinos;
	}
	
	public List<Producto> getProductos() {
		return productos;
	}
	
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public EmpresaDTO toDto() {
		EmpresaDTO empresaDTO = new EmpresaDTO();
		empresaDTO.setCodigo(this.getCodigo());
		empresaDTO.setTipoDoc(this.getTipoDoc());
		empresaDTO.setNroDoc(this.getNroDoc());
		empresaDTO.setNombre(this.getNombre());
		empresaDTO.setNroCuenta(this.getNroCuenta());
		empresaDTO.setCtaCte(this.getCtaCte());
		empresaDTO.setMontoMinAutoriz(this.getMontoMinAutoriz());
		empresaDTO.setReqManifiesto(this.isReqManifiesto());
		empresaDTO.setEsDepositoPrevio(this.isEsDepositoPrevio());
		empresaDTO.setEsPagoMensual(this.isEsPagoMensual());
		return empresaDTO;
	}
	
	public static Empresa fromDto(EmpresaDTO dto) {
		Empresa empresa = new Empresa();
		empresa.setCodigo(dto.getCodigo());
		empresa.setCtaCte(dto.getCtaCte());
		empresa.setDestinos(Ubicacion.fromDtos(dto.getDestinos()));
		empresa.setEsDepositoPrevio(dto.isEsDepositoPrevio());
		empresa.setEsPagoMensual(dto.isEsPagoMensual());
		empresa.setMontoMinAutoriz(dto.getMontoMinAutoriz());
		empresa.setNombre(dto.getNombre());
		empresa.setNroDoc(dto.getNroDoc());
		empresa.setNroCuenta(dto.getNroCuenta());
		empresa.setProductos(Producto.fromDtos(dto.getProductos()));
		empresa.setReqManifiesto(dto.isReqManifiesto());
		empresa.setTipoDoc(dto.getTipoDoc());
		return empresa;
	}

	public void save() {
		ClienteDAO.getInstancia().save(this);
	}

	public void remove() {
		ClienteDAO.getInstancia().remove(this);
	}
}
