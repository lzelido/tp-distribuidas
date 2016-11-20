package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import service.IProveedorService;
import srv.ProveedorSRV;
import dto.CarrierDTO;
import dto.ProveedorLocalDTO;
import entities.Carrier;
import entities.ProveedorLocal;

public class ProveedorController extends UnicastRemoteObject implements IProveedorService{

	private static final long serialVersionUID = 787351955386009590L;

	public ProveedorController() throws RemoteException{
		super();
	}
	
	@Override
	public ProveedorLocalDTO buscarProveedorLocalDTO(int codigo) throws RemoteException {
		return new ProveedorSRV().buscarProveedorLocalDTO(codigo);
	}
	
	@Override
	public CarrierDTO buscarCarrierDTO(int codigo) throws RemoteException {
		return new ProveedorSRV().buscarCarrierDTO(codigo);
	}
	
	@Override
	public void bajaCarrier(int codigo) throws RemoteException {
		new ProveedorSRV().bajaCarrier(codigo);
	}

	@Override
	public void darDeAltaProveedorLocal(ProveedorLocalDTO proveedorLocal) throws RemoteException {		
		ProveedorLocal v = new ProveedorLocal();
		v.setNombre(proveedorLocal.getNombre());
		v.setTelefono(proveedorLocal.getTelefono());		
		new ProveedorSRV().darDeAltaProveedorLocal(v);
	}
	
	@Override
	public void darDeAltaCarrier(CarrierDTO carrierDTO) throws RemoteException {		
		Carrier v = new Carrier();
		v.setNombre(carrierDTO.getNombre());
		v.setTelefono(carrierDTO.getTelefono());
		new ProveedorSRV().darDeAltaCarrier(v);
	}

	@Override
	public List<Object> obtenerProveedores() throws RemoteException {
		return new ProveedorSRV().obtenerProveedores();
	}

	@Override
	public void modificarProveedorLocal(ProveedorLocalDTO proveedorLocal)
			throws RemoteException {
		ProveedorLocal v = new ProveedorLocal();
		v.setCodigo(proveedorLocal.getCodigo());
		v.setNombre(proveedorLocal.getNombre());
		v.setTelefono(proveedorLocal.getTelefono());		
		new ProveedorSRV().darDeAltaProveedorLocal(v);
	}

	@Override
	public void modificarCarrier(CarrierDTO carrierDTO) throws RemoteException {
		Carrier v = new Carrier();
		v.setCodigo(carrierDTO.getCodigo());
		v.setNombre(carrierDTO.getNombre());
		v.setTelefono(carrierDTO.getTelefono());
		new ProveedorSRV().darDeAltaCarrier(v);		
	}
}

