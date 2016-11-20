package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.UnidadDTO;

public interface IUnidadService extends Remote{
	
	public UnidadDTO obtenerUnidad(int codigo) throws RemoteException;

	public void guardarUnidad(UnidadDTO unidad) throws RemoteException;

	public void eliminarUnidad(int i) throws RemoteException;

	public List<UnidadDTO> obtenerUnidades() throws RemoteException;
	public List<UnidadDTO> obtenerUnidadesVolumen() throws RemoteException;
	public List<UnidadDTO> obtenerUnidadesTara() throws RemoteException;

	public void modificarUnidad(UnidadDTO unidad) throws RemoteException;

	List<UnidadDTO> buscarUnidades(int idUnidad) throws RemoteException;

}