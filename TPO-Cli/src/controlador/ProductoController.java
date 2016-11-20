package controlador;

import java.rmi.RemoteException;
import java.util.Vector;

import businessDelegate.BusinessDelegate;
import dto.ProductoDTO;

public class ProductoController {
	private static ProductoController instance = null;

	public static ProductoController getInstance() {
		if (instance == null) {
			instance = new ProductoController();
		}
		return instance;
	}

	// BUSCAR
	public Vector<ProductoDTO> buscarProductos (int idCliente){
		return BusinessDelegate.getInstance().buscarProductos (idCliente);
	}
	
	// ALTAS
	public int agregarProducto (int idCliente, ProductoDTO productoDTO) throws RemoteException{
		return BusinessDelegate.getInstance().agregarProducto(idCliente, productoDTO);
	}
	
	// BAJAS
	public int eliminarProducto (int idCliente, ProductoDTO producto) throws RemoteException{
		return BusinessDelegate.getInstance().eliminarProducto(idCliente, producto);
	}

	// MODIFICACIONES
	public int modificarProducto (ProductoDTO productoDTO) throws RemoteException{
		return BusinessDelegate.getInstance().modificarProducto(productoDTO);
	}
}
