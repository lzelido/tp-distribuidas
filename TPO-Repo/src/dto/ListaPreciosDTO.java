package dto;

import java.io.Serializable;
import java.util.List;

public class ListaPreciosDTO implements Serializable {
		private static final long serialVersionUID = -3916034946012910911L;

	private int codigo;
	private String listaprecios;
	private float coordenadaX;
	private float coordenadaY;
	private float coordenadaZ;
	private String UnidadX;
	private String UnidadY;
	private String UnidadZ;
	private int dimension;
	private float precio;
	private float peso;
	
	public ListaPreciosDTO () {
		
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getListaprecios() {
		return listaprecios;
	}

	public void setListaprecios(String listaprecios) {
		this.listaprecios = listaprecios;
	}

	public float getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(float coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public float getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(float coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	public float getCoordenadaZ() {
		return coordenadaZ;
	}

	public void setCoordenadaZ(float coordenadaZ) {
		this.coordenadaZ = coordenadaZ;
	}

	public String getUnidadX() {
		return UnidadX;
	}

	public void setUnidadX(String unidadX) {
		UnidadX = unidadX;
	}

	public String getUnidadY() {
		return UnidadY;
	}

	public void setUnidadY(String unidadY) {
		UnidadY = unidadY;
	}

	public String getUnidadZ() {
		return UnidadZ;
	}

	public void setUnidadZ(String unidadZ) {
		UnidadZ = unidadZ;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
}
