package entities;

import java.util.List;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.*;

import dto.ListaPreciosDTO;
import dto.UbicacionDTO;

@Entity
@Table(name= "ListaPrecios")
public class ListaPrecios extends UnicastRemoteObject{
	@Id
	@Column (name="codigo")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	
	@Column(name="listaprecios")
	private String listaprecios;
	
	@Column(name="coordenadaX")
	private float coordenadaX;
	
	@Column(name="coordenadaY")
	private float coordenadaY;
	
	@Column(name="coordenadaZ")
	private float coordenadaZ;
	
	@Column(name="UnidadX")
	private String UnidadX;
	
	@Column(name="UnidadY")
	private String UnidadY;
	
	@Column(name="UnidadZ")
	private String UnidadZ;
	
	@Column(name="dimension")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int dimension;
	
	@Column(name="precio")
	private float precio;
	
	@Column(name="peso")
	private float peso;
	
	public ListaPrecios() throws RemoteException {
		super();
	}

	public ListaPrecios(ListaPreciosDTO listaPrecio) throws RemoteException{
		this.codigo = listaPrecio.getCodigo();
		this.listaprecios=listaPrecio.getListaprecios();
		this.coordenadaX = listaPrecio.getCoordenadaX();
		this.coordenadaY = listaPrecio.getCoordenadaY();
		this.coordenadaZ = listaPrecio.getCoordenadaZ();
		this.UnidadX = listaPrecio.getUnidadX();
		this.UnidadY = listaPrecio.getUnidadY();
		this.UnidadZ = listaPrecio.getUnidadZ();
		this.dimension = listaPrecio.getDimension();
		this.precio = listaPrecio.getPrecio();
		this.peso = listaPrecio.getPeso();
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

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public ListaPreciosDTO getDTO(){
		ListaPreciosDTO l = new ListaPreciosDTO();
		l.setCodigo(codigo);
		l.setListaprecios(listaprecios);
		l.setCoordenadaX(coordenadaX);
		l.setCoordenadaY(coordenadaY);
		l.setCoordenadaZ(coordenadaZ);
		l.setUnidadX(UnidadX);
		l.setUnidadY(UnidadY);
		l.setUnidadZ(UnidadZ);
		l.setDimension(dimension);
		l.setPrecio(precio);
		l.setPrecio(precio);
		
		return l;
	}
	
}
