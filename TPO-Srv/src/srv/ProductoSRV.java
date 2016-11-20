package srv;

import java.util.List;

import dao.ProductoDAO;
import entities.Producto;

public class ProductoSRV {
	private static ProductoDAO dao;
	
	static {
	dao = ProductoDAO.getInstancia();
	}

	// ALTA
	public void grabarProducto(Producto producto){
		dao.grabarProducto(producto);
	}
	
	// BUSCAR
	public Producto buscarProducto (String descri){
		Producto producto = dao.buscarProducto (descri);
		return producto;
	}
	
	public Producto buscarProducto (int idProducto){
		Producto producto = dao.buscarProducto (idProducto);
		return producto;
	}
	
	public List<Producto> buscarProductos (){
		List<Producto> productos = dao.buscarProductos();
		return productos;
	}
	
	// BAJA
	public void eliminarProducto(Producto producto){
		dao.eliminarProducto(producto);
	}	
}
