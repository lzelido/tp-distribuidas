package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.CarrierDTO;
import dto.ProveedorLocalDTO;

public interface IProveedorService extends Remote {
	public ProveedorLocalDTO buscarProveedorLocalDTO(int codigo) throws RemoteException;

	public CarrierDTO buscarCarrierDTO(int codigo) throws RemoteException;

	public void darDeAltaProveedorLocal(ProveedorLocalDTO proveedorLocal) throws RemoteException;

	public void darDeAltaCarrier(CarrierDTO carrier) throws RemoteException;

	public void bajaCarrier(int codigo) throws RemoteException;

	public void modificarProveedorLocal(ProveedorLocalDTO proveedorLocal) throws RemoteException;

	public void modificarCarrier(CarrierDTO carrier) throws RemoteException;

	List<Object> obtenerProveedores()throws RemoteException;
}
