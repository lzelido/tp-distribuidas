package srv;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dao.UnidadDAO;
import dto.UnidadDTO;
import entities.Unidad;

public class UnidadSRV {
	private static UnidadDAO dao;
	static {
		dao = UnidadDAO.getInstancia();
	}
	
	public void grabarUnidad(UnidadDTO unidad) throws RemoteException{
		Unidad u = new Unidad();
		u.setCodigo(unidad.getCodigo());
		u.setDescri(unidad.getDescri());
		dao.grabarUnidad(u);
	}
	
	public List<UnidadDTO> buscarUnidades (){
		List<Unidad> unidades = dao.buscarUnidades();
		List<UnidadDTO> unidadesDTO = new ArrayList<UnidadDTO>();
		for(Unidad unidad : unidades){
			unidadesDTO.add(unidad.toDto());
		}
		return unidadesDTO;
	}
	
	public List<UnidadDTO> buscarUnidadesVolumen(){
		List<Unidad> unidades = dao.buscarUnidadesVolumen();
		List<UnidadDTO> unidadesDTO = new ArrayList<UnidadDTO>();
		for(Unidad unidad : unidades){
			unidadesDTO.add(unidad.toDto());
		}
		return unidadesDTO;
	}
	
	public List<UnidadDTO> buscarUnidadesTara(){
		List<Unidad> unidades = dao.buscarUnidadesTara();
		List<UnidadDTO> unidadesDTO = new ArrayList<UnidadDTO>();
		for(Unidad unidad : unidades){
			unidadesDTO.add(unidad.toDto());
		}
		return unidadesDTO;
	}
	
	public UnidadDTO buscarUnidadDTO (int codigoUnidad){
		Unidad unidad= dao.buscarUnidad(codigoUnidad);
		return unidad == null? new UnidadDTO() : unidad.toDto();
	}
	
	public Unidad buscarUnidad (int codigoUnidad){
		return dao.buscarUnidad(codigoUnidad);
	}
	
	public void eliminarUnidad(int codigo){
		Unidad u = dao.buscarUnidad(codigo);
		dao.eliminarUnidad(u);
	}
	
	public void modificarUnidad(UnidadDTO unidad) throws RemoteException{
		Unidad u = new Unidad();
		u.setCodigo(unidad.getCodigo());
		u.setDescri(unidad.getDescri());
		dao.modificarUnidad(u);
	}
}
