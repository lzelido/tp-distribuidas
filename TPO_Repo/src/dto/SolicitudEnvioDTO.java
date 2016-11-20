package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SolicitudEnvioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private Date fechaEmision;
	private ClienteDTO cliente;
	private UbicacionDTO domicilioEntrega;
	private Date fechaMaxEntrega;
	private Date fechaEsEntrega;
	private boolean esRetiroDomicilio;
	private UbicacionDTO domicilioRetiro;
	private Date fechaRetiro;
	private String horaRetiroMax;
	private String horaRetiroMin;
	private String manifesto;
	private FacturaDTO factura;
	private List<CargaDTO> cargas;
	private String clienteHabRecepcion;
	private String clienteHabRetiro;
	
	// CONSTRUCTOR
	public SolicitudEnvioDTO(){
		
	}

	// GETTERS y SETTERS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public Date getFechaMaxEntrega() {
		return fechaMaxEntrega;
	}

	public void setFechaMaxEntrega(Date fechaMaxEntrega) {
		this.fechaMaxEntrega = fechaMaxEntrega;
	}

	public Date getFechaEsEntrega() {
		return fechaEsEntrega;
	}

	public void setFechaEsEntrega(Date fechaEsEntrega) {
		this.fechaEsEntrega = fechaEsEntrega;
	}

	public boolean isEsRetiroDomicilio() {
		return esRetiroDomicilio;
	}

	public void setEsRetiroDomicilio(boolean esRetiroDomicilio) {
		this.esRetiroDomicilio = esRetiroDomicilio;
	}

	public UbicacionDTO getDomicilioRetiro() {
		return domicilioRetiro;
	}

	public void setDomicilioRetiro(UbicacionDTO domicilioRetiro) {
		this.domicilioRetiro = domicilioRetiro;
	}

	public Date getFechaRetiro() {
		return fechaRetiro;
	}

	public void setFechaRetiro(Date fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}

	public String getHoraRetiroMax() {
		return horaRetiroMax;
	}

	public void setHoraRetiroMax(String horaRetiroMax) {
		this.horaRetiroMax = horaRetiroMax;
	}

	public String getHoraRetiroMin() {
		return horaRetiroMin;
	}

	public void setHoraRetiroMin(String horaRetiroMin) {
		this.horaRetiroMin = horaRetiroMin;
	}

	public String getManifesto() {
		return manifesto;
	}

	public void setManifesto(String manifesto) {
		this.manifesto = manifesto;
	}
	
	public FacturaDTO getFactura() {
		return factura;
	}

	public void setFactura(FacturaDTO factura) {
		this.factura = factura;
	}

	public List<CargaDTO> getCargas() {
		return cargas;
	}

	public void setCargas(List<CargaDTO> cargas) {
		this.cargas = cargas;
	}

	public float ejecutarDefinirTransporte(){
		return 0;
	}
	
	public UbicacionDTO getDomicilioEntrega() {
		return domicilioEntrega;
	}

	public void setDomicilioEntrega(UbicacionDTO domicilioEntrega) {
		this.domicilioEntrega = domicilioEntrega;
	}

	public String getClienteHabRecepcion() {
		return clienteHabRecepcion;
	}

	public void setClienteHabRecepcion(String clienteHabRecepcion) {
		this.clienteHabRecepcion = clienteHabRecepcion;
	}

	public String getClienteHabRetiro() {
		return clienteHabRetiro;
	}

	public void setClienteHabRetiro(String clienteHabRetiro) {
		this.clienteHabRetiro = clienteHabRetiro;
	}
}
