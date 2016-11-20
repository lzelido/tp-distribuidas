package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import service.IUnidadService;
import srv.UnidadSRV;
import dto.UnidadDTO;

public class UnidadController extends UnicastRemoteObject implements IUnidadService{
	private static final long serialVersionUID = -8927173698860853796L;

	public UnidadController() throws RemoteException {
		super();
	}

	public List<UnidadDTO> buscarUnidades (int idUnidad) throws RemoteException{
		return (new UnidadSRV()).buscarUnidades();
	}

	public UnidadDTO obtenerUnidad(int codigo) throws RemoteException {
		return new UnidadSRV().buscarUnidadDTO(codigo);
	}

	@Override
	public void guardarUnidad(UnidadDTO unidad) throws RemoteException {
		new UnidadSRV().grabarUnidad(unidad);
	}

	public void eliminarUnidad(int codigo) throws RemoteException {
		new UnidadSRV().eliminarUnidad(codigo);
	}

	@Override
	public List<UnidadDTO> obtenerUnidades() throws RemoteException {
		return new UnidadSRV().buscarUnidades();
	}
	
	public List<UnidadDTO> obtenerUnidadesVolumen() throws RemoteException {
		return new UnidadSRV().buscarUnidadesVolumen();
	}
	
	public List<UnidadDTO> obtenerUnidadesTara() throws RemoteException {
		return new UnidadSRV().buscarUnidadesTara();
	}

	@Override
	public void modificarUnidad(UnidadDTO unidad) throws RemoteException {
		new UnidadSRV().modificarUnidad(unidad);
	}
	
}
