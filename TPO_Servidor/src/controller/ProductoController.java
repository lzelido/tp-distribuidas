package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Vector;
import dto.ProductoDTO;
import entities.Empresa;
import entities.Producto;
import service.IProductoService;
import srv.ClienteSRV;
import srv.ProductoSRV;

public class ProductoController extends UnicastRemoteObject implements IProductoService{
	private static final long serialVersionUID = -2324235189397051777L;
		
	public ProductoController() throws RemoteException {
		super();
	}

	/****************************************************************************************/
	/** METODOS                                                                            **/
	/****************************************************************************************/
	
	// BUSCAR
	public Vector<ProductoDTO> buscarProductos (int idCliente) throws RemoteException{
		try {
			List<Producto> productos = (new ClienteSRV()).buscarProductosByCliente (idCliente);
			Vector<ProductoDTO> productosDTO = new Vector<ProductoDTO>();
			if (productos != null){
				for(Producto producto : productos){
					ProductoDTO productoDTO = new ProductoDTO();
					productoDTO.setCodigo(producto.getCodigo());
					productoDTO.setDescrip(producto.getDescrip());
				
					productosDTO.add(productoDTO);
				}
			}
			return productosDTO;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
/*	
	// BUSCAR
	public ProductoDTO buscarProducto (String descri){
		try {
			for(Producto producto : productos){
				if(producto.getDescrip().equals(descri)){
					ProductoDTO productoDTO = new ProductoDTO();
					productoDTO.setCodigo(producto.getCodigo());
					productoDTO.setDescrip(producto.getDescrip());
					return productoDTO;
				}
			}
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ProductoDTO buscarProducto (int codigo){
		try {
			for(Producto producto : productos){
				if(producto.getCodigo() == codigo){
					ProductoDTO productoDTO = new ProductoDTO();
					productoDTO.setCodigo(producto.getCodigo());
					productoDTO.setDescrip(producto.getDescrip());
					return productoDTO;
				}
			}
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
*/	
	// ALTA
	public int agregarProducto (int idCliente, ProductoDTO productoDTO)throws RemoteException{
		try {
			Empresa empresa = (new ClienteSRV ()).buscarEmpresa(idCliente);
			List<Producto> productos = (new ClienteSRV()).buscarProductosByCliente (idCliente); 
			if(empresa != null){
				for (Producto producto : productos){
					if (producto.getDescrip().equals(productoDTO.getDescrip())){
						System.out.println("El producto ya existe para la empresa");
						return 2;
					}
				}
				Producto producto = new Producto();
				producto.setCodigo(productoDTO.getCodigo());
				producto.setDescrip(productoDTO.getDescrip());
				(new ProductoSRV()).grabarProducto(producto);
				
				productos.add(producto);
				empresa.setProductos(productos);
				(new ClienteSRV()).grabarCliente(empresa);
				
				System.out.println("Se dio de alta el producto");
				return 3;
			}else{
				System.out.println("La empresa no existe");
				return 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar el producto");
			return 0;
		}
	}

	// BAJA
	public int eliminarProducto (int idCliente, ProductoDTO productoDTO) throws RemoteException{
		try {
			Empresa empresa = (new ClienteSRV()).buscarEmpresa(idCliente);
			if (empresa != null){
				List <Producto> productos = (new ClienteSRV()).buscarProductosByCliente(idCliente);
				for(Producto producto : productos){
					if(producto.getCodigo() == productoDTO.getCodigo()){
						productos.remove(producto);
						empresa.setProductos(productos);
						
						(new ClienteSRV()).grabarCliente(empresa);
						
						(new ProductoSRV()).eliminarProducto(producto);;
						
						System.out.println("Se eliminó con éxito el producto");
						return 3;
					}
				}
				System.out.println("El producto no existe para la empresa");
				return 2;
			}else{
				System.out.println("La empresa no existe");
				return 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al eliminar el producto");
			return 0;
		}
	}
	
	// MODIFICACION
	public int modificarProducto (ProductoDTO productoDTO)throws RemoteException{
		try {
			Producto producto = (new ProductoSRV ()).buscarProducto (productoDTO.getCodigo());
			if(producto != null){
				producto.setCodigo(productoDTO.getCodigo());
				producto.setDescrip(productoDTO.getDescrip());
				(new ProductoSRV()).grabarProducto(producto);
				
				System.out.println("Se modificó el producto");
				return 2;
			}else{
				System.out.println("El producto no existe");
				return 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar el producto");
			return 0;
		}
	}
}
