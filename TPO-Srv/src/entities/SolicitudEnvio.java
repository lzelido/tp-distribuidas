package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dto.ClienteDTO;
import dto.EmpresaDTO;
import dto.ParticularDTO;
import dto.SolicitudEnvioDTO;

@Entity
@Table(name = "SolicitudEnvio")
// TODO:
// TODO: Esto entiendo que lo que hace es la funcionalidad que nosotros teniamos
// en "Carga"
// TODO: solo que aca este tiene una coleccion de cargas.
// TODO:
public class SolicitudEnvio {
	@Transient
	private static final long serialVersionUID = -3046464426712262976L;

	@Id
	@Column(name = "IdSolicitud", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;

	@Column(name = "FechaEmision")
	private Date fechaEmision;

	@ManyToOne
	@JoinColumn(name = "IdCliente")
	private Cliente cliente;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "IdUbicacionEntrega")
	private Ubicacion domicilioEntrega;

	@Column(name = "FechaMaxEntrega")
	private Date fechaMaxEntrega;

	@Column(name = "FechaEstEntrega") // TODO: Hace falta persistir esto?
	private Date fechaEstEntrega; // TODO: Hace falta persistir esto?

	@Column(name = "ClienteHabRecepcion")
	private String clienteHabRecepcion;

	@Column(name = "esRetiroDomicilio")
	private boolean esRetiroDomicilio;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "IdUbicacionRetiro")
	private Ubicacion domicilioRetiro;

	@Column(name = "FechaRetiro")
	private Date fechaRetiro;

	@Column(name = "HoraRetiroMax")
	private String horaRetiroMax;

	@Column(name = "HoraRetiroMin")
	private String horaRetiroMin;

	@Column(name = "ClienteHabRetiro")
	private String clienteHabRetiro;

	@Column(name = "PathManifiesto")
	private String manifesto;
	/*
	 * private IDefinirTransporte adicTransporte;
	 */
	// TODO: esto no se que es, estaba asi, sino lo sacamos a la mierda.

	@OneToOne
	@JoinColumn(name = "IdFactura")
	private Factura factura;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "IdSolicitud")
	private List<Carga> cargas;

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechaMaxEntrega() {
		return fechaMaxEntrega;
	}

	public void setFechaMaxEntrega(Date fechaMaxEntrega) {
		this.fechaMaxEntrega = fechaMaxEntrega;
	}

	public Date getFechaEstEntrega() {
		return fechaEstEntrega;
	}

	public void setFechaEstEntrega(Date fechaEstEntrega) {
		this.fechaEstEntrega = fechaEstEntrega;
	}

	public Ubicacion getDomicilioEntrega() {
		return domicilioEntrega;
	}

	public void setDomicilioEntrega(Ubicacion domicilioEntrega) {
		this.domicilioEntrega = domicilioEntrega;
	}

	public boolean isEsRetiroDomicilio() {
		return esRetiroDomicilio;
	}

	public void setEsRetiroDomicilio(boolean esRetiroDomicilio) {
		this.esRetiroDomicilio = esRetiroDomicilio;
	}

	public Ubicacion getDomicilioRetiro() {
		return domicilioRetiro;
	}

	public void setDomicilioRetiro(Ubicacion domicilioRetiro) {
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

	/*
	 * public IDefinirTransporte getAdicTransporte() { return adicTransporte; }
	 * 
	 * public void setAdicTransporte(IDefinirTransporte adicTransporte) {
	 * this.adicTransporte = adicTransporte; }
	 */
	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public List<Carga> getCargas() {
		return cargas;
	}

	public void setCargas(List<Carga> cargas) {
		this.cargas = cargas;
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

	public float ejecutarDefinirTransporte() {
		return 0;
	}

	public static List<SolicitudEnvio> fromDtos(List<SolicitudEnvioDTO> dtos) {
		List<SolicitudEnvio> envios = new ArrayList<SolicitudEnvio>();
		for (SolicitudEnvioDTO dto : dtos) {
			envios.add(fromDto(dto));
		}
		return envios;
	}

	public static SolicitudEnvio fromDto(SolicitudEnvioDTO dto) {
		SolicitudEnvio envio = new SolicitudEnvio();
		envio.setCargas(Carga.fromDtos(dto.getCargas()));
		ClienteDTO cDto = dto.getCliente();
		if (cDto instanceof EmpresaDTO) {
			envio.setCliente(Empresa.fromDto(((EmpresaDTO) cDto)));
		} else {
			envio.setCliente(Particular.fromDto(((ParticularDTO) cDto)));
		}
		envio.setClienteHabRecepcion(dto.getClienteHabRecepcion());
		envio.setClienteHabRetiro(dto.getClienteHabRetiro());
		envio.setCodigo(dto.getCodigo());
		envio.setDomicilioEntrega(Ubicacion.fromDto(dto.getDomicilioEntrega()));
		envio.setDomicilioRetiro(Ubicacion.fromDto(dto.getDomicilioRetiro()));
		envio.setEsRetiroDomicilio(dto.isEsRetiroDomicilio());
		envio.setFactura(Factura.fromDto(dto.getFactura()));
		envio.setFechaEmision(dto.getFechaEmision());
		envio.setFechaEstEntrega(dto.getFechaEsEntrega());
		envio.setFechaMaxEntrega(dto.getFechaMaxEntrega());
		envio.setFechaRetiro(dto.getFechaRetiro());
		envio.setHoraRetiroMax(dto.getHoraRetiroMax());
		envio.setHoraRetiroMin(dto.getHoraRetiroMin());
		envio.setManifesto(dto.getManifesto());
		return envio;
	}
}
