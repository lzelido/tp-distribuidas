package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name = "Dimension")
public class Dimension extends UnicastRemoteObject{
	@Transient
	private static final long serialVersionUID = 2311616385070251882L;

	@Id
	@Column (name = "IdDimension", nullable = false)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	
	@Column (name = "CoordenadasX")
	private int coordX;
	
	@OneToOne
	@JoinColumn (name = "UnidadX")
	private Unidad unidadCoordX;
	
	@Column (name = "CoordenadasY")
	private int coordY;
	
	@OneToOne
	@JoinColumn (name = "UnidadY")
	private Unidad unidadCoordY;
	
	@Column (name = "CoordenadasZ")
	private int coordZ;
	
	@OneToOne
	@JoinColumn (name = "UnidadZ")
	private Unidad unidadZ;
	
	// CONTRUCTOR
	public Dimension() throws RemoteException{
		
	}

	// GETTERS Y SETTERS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public Unidad getUnidadCoordX() {
		return unidadCoordX;
	}

	public void setUnidadCoordX(Unidad unidadCoordX) {
		this.unidadCoordX = unidadCoordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	public Unidad getUnidadCoordY() {
		return unidadCoordY;
	}

	public void setUnidadCoordY(Unidad unidadCoordY) {
		this.unidadCoordY = unidadCoordY;
	}

	public int getCoordZ() {
		return coordZ;
	}

	public void setCoordZ(int coordZ) {
		this.coordZ = coordZ;
	}

	public Unidad getUnidadCoordZ() {
		return unidadZ;
	}

	public void setUnidadCoordZ(Unidad unidadZ) {
		this.unidadZ = unidadZ;
	}
}
