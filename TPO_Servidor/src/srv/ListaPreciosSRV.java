package srv;

import java.util.List;

import entities.ListaPrecios;
import dao.ListaPreciosDAO;
import dao.SucursalDAO;

public class ListaPreciosSRV {
	private static ListaPreciosDAO dao;
	static {
		dao = ListaPreciosDAO.getInstancia();
	}

	public void grabarListaPrecios(ListaPrecios listaPrecios) {
		dao.grabarListaPrecios(listaPrecios);
		
	}

	public ListaPrecios buscarListaPrecios(int codigo) {
		dao.buscarListaPrecios(codigo);
		return null;
	}
	
	public List<ListaPrecios> buscarListaPreciosPorDescripcion(String descripcion) {
		
		return dao.buscarListaPreciosPorDescripcion(descripcion);
	}

	public float calculoM3Item(ListaPrecios listaPrecios) {
		dao.calculoM3Item(listaPrecios);
		return 0;
	}
}
