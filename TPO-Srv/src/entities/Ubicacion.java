package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dto.UbicacionDTO;

@Entity
@Table (name = "Ubicacion")
public class Ubicacion{
	@Transient
	private static final long serialVersionUID = 102490840433472428L;

	@Id
	@Column(name = "IdUbicacion", nullable = false)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	
	@Column(name = "Calle")
	private String calle;
	
	@Column(name = "Numero")
	private int numero;
	
	@Column(name = "Piso")
	private int piso;
	
	@Column(name = "Depto")
	private String depto;
	
	@Column(name = "CodPos")
	private String codPost;
	
	@Column(name = "Localidad")
	private String localidad;
	
	@Column(name = "Provincia")
	private String provincia;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn (name = "IdGPS")
	private GPS gps;

	@ManyToOne
	@JoinColumn (name = "IdCliente")
	private Empresa empresa;
	
	// CONSTRUCTORES
	public Ubicacion(){
		
	}
	
	public Ubicacion(UbicacionDTO destino){
		this.calle = destino.getCalle();
		this.numero = destino.getNumero();
		this.piso = destino.getPiso();
		this.depto = destino.getDepto();
		this.codPost = destino.getCodPost();
		this.localidad = destino.getLocalidad();
		this.provincia = destino.getProvincia();
		
		GPS gps = new GPS(destino.getGps());
		this.gps = gps;
	}
	
	// GETTERS Y SETTERS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getCalle() {
		return calle;
	}
	
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public String getCodPost() {
		return codPost;
	}
	
	public void setCodPost(String codPost) {
		this.codPost = codPost;
	}
	
	public String getLocalidad() {
		return localidad;
	}
	
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	public String getProvincia() {
		return provincia;
	}
	
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public GPS getGps() {
		return gps;
	}
	
	public void setGps(GPS gps) {
		this.gps = gps;
	}
	
	// METODO
	public UbicacionDTO toDto(){
		UbicacionDTO u = new UbicacionDTO();
		u.setCalle(calle);
		u.setCodigo(codigo);
		u.setCodPost(codPost);
		u.setDepto(depto);
		u.setGps(gps.toDto());
		u.setLocalidad(localidad);
		u.setNumero(numero);
		u.setPiso(piso);
		u.setProvincia(provincia);
		return u;
	}

	public static Ubicacion fromDto(UbicacionDTO dto) {
		Ubicacion ubicacion = new Ubicacion();
		ubicacion.setCalle(dto.getCalle());
		ubicacion.setCodigo(dto.getCodigo());
		ubicacion.setCodPost(dto.getCodPost());
		ubicacion.setDepto(dto.getDepto());
		ubicacion.setGps(GPS.fromDto(dto.getGps()));
		ubicacion.setLocalidad(dto.getLocalidad());
		ubicacion.setNumero(dto.getNumero());
		ubicacion.setPiso(dto.getPiso());
		ubicacion.setProvincia(dto.getProvincia());
		return ubicacion;
	}

	public static List<Ubicacion> fromDtos(List<UbicacionDTO> destinos) {
		List<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();
		for (UbicacionDTO dto : destinos) {
			ubicaciones.add(fromDto(dto));
		}
		return ubicaciones;
	}
	
}