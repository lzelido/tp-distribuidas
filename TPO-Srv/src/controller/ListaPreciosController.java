package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dto.EmpleadoDTO;
import dto.ListaPreciosDTO;
import dto.SucursalDTO;
import entities.Empleado;
import entities.ListaPrecios;
import service.IListaPreciosService;
import srv.EmpleadoSRV;
import srv.ListaPreciosSRV;


public class ListaPreciosController extends UnicastRemoteObject implements IListaPreciosService{
	private static final long serialVersionUID = 1L;
	
	public ListaPreciosController() throws RemoteException {
		super();
		
	}
	@Override
	public ListaPreciosDTO buscarLista(int numero) throws RemoteException {
		try {
			ListaPrecios listaPrecios = (new ListaPreciosSRV()).buscarListaPrecios(numero);
			if (listaPrecios!=null){
				//transformo la entidad en dto
				//TODO: yo esto lo haria asi: ListaPreciosDTO lpDTO = listraPrecios.toDTO();
				ListaPreciosDTO listaPreciosDTO = new ListaPreciosDTO();
				listaPrecios.setCodigo(listaPrecios.getCodigo());
				listaPrecios.setListaprecios(listaPrecios.getListaprecios());
				listaPrecios.setCoordenadaX(listaPrecios.getCoordenadaX());
				listaPrecios.setCoordenadaY(listaPrecios.getCoordenadaY());
				listaPrecios.setCoordenadaZ(listaPrecios.getCoordenadaZ());
				listaPrecios.setUnidadX(listaPrecios.getUnidadX());
				listaPrecios.setUnidadY(listaPrecios.getUnidadY());
				listaPrecios.setUnidadZ(listaPrecios.getUnidadZ());
				listaPrecios.setDimension(listaPrecios.getDimension());
				listaPrecios.setPrecio(listaPrecios.getPrecio());
				listaPrecios.setPeso(listaPrecios.getPeso());
				return listaPreciosDTO ;
			
			
			}else{
				System.out.println("La lista de Precios ya existe");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al buscar la lista de Precios");
			return null;
		}
	}

	@Override
	public int guardarListaPrecios(ListaPreciosDTO listaPreciosDTO) throws RemoteException {
			try {
				ListaPrecios listaPrecios = (new ListaPreciosSRV()).buscarListaPrecios(listaPreciosDTO.getCodigo());
				
				if(listaPrecios == null){
					listaPrecios = new ListaPrecios();
					//TODO: cambiaria por lo siguiente.
					//TODO: listaPrecios = ListaPrecios.toEntity(listaPreciosDTO);
					listaPrecios.setCodigo(listaPreciosDTO.getCodigo());
					listaPrecios.setListaprecios(listaPreciosDTO.getListaprecios());
					listaPrecios.setCoordenadaX(listaPreciosDTO.getCoordenadaX());
					listaPrecios.setCoordenadaY(listaPreciosDTO.getCoordenadaY());
					listaPrecios.setCoordenadaZ(listaPreciosDTO.getCoordenadaZ());
					listaPrecios.setUnidadX(listaPreciosDTO.getUnidadX());
					listaPrecios.setUnidadY(listaPreciosDTO.getUnidadY());
					listaPrecios.setUnidadZ(listaPreciosDTO.getUnidadZ());
					listaPrecios.setDimension(listaPreciosDTO.getDimension());
					listaPrecios.setPrecio(listaPreciosDTO.getPrecio());
					listaPrecios.setPeso(listaPreciosDTO.getPeso());
					
					(new ListaPreciosSRV()).grabarListaPrecios(listaPrecios);
					System.out.println("La lista de precios se grabó con éxito");
					return 2;
				}else{
					System.out.println("La lista de precios ya existe");
					return 1;
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error al grabar La lista de precios");
				return 0;
			}
		}
	
}
