package dto;

import java.io.Serializable;

public class DimensionDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private int coordX;
	private UnidadDTO unidadCoordX;
	private int coordY;
	private UnidadDTO unidadCoordY;
	private int coordZ;
	private UnidadDTO unidadZ;
	
	// CONSTRUCTOR
	public DimensionDTO(){
		
	}

	// GETTERS y SETTERS
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

	public UnidadDTO getUnidadCoordX() {
		return unidadCoordX;
	}

	public void setUnidadCoordX(UnidadDTO unidadCoordX) {
		this.unidadCoordX = unidadCoordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	public UnidadDTO getUnidadCoordY() {
		return unidadCoordY;
	}

	public void setUnidadCoordY(UnidadDTO unidadCoordY) {
		this.unidadCoordY = unidadCoordY;
	}

	public int getCoordZ() {
		return coordZ;
	}

	public void setCoordZ(int coordZ) {
		this.coordZ = coordZ;
	}

	public UnidadDTO getUnidadCoordZ() {
		return unidadZ;
	}

	public void setUnidadCoordZ(UnidadDTO unidadZ) {
		this.unidadZ = unidadZ;
	}
}
