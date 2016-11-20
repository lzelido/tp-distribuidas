package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import dto.ProductoDTO;

public interface IProductoService extends Remote {

	// BUSCAR
	public Vector<ProductoDTO> buscarProductos (int idCliente) throws RemoteException;
	
//	public ProductoDTO buscarProducto (String descri);
	
//	public ProductoDTO buscarProducto (int codigo);
	
	// ALTA
	public int agregarProducto (int idCliente, ProductoDTO productoDTO)throws RemoteException;
	
	// BAJA
	public int eliminarProducto (int idCliente, ProductoDTO producto) throws RemoteException;
	
	// MODIFICACIÓN	
	public int modificarProducto (ProductoDTO productoDTO)throws RemoteException;
}
