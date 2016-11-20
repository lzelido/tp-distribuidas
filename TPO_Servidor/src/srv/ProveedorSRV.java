package srv;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dao.ProveedorDAO;
import dto.CarrierDTO;
import dto.ProveedorLocalDTO;
import entities.Carrier;
import entities.Proveedor;
import entities.ProveedorLocal;

public class ProveedorSRV {
	private static ProveedorDAO dao;
	static {
		dao = ProveedorDAO.getInstancia();
	}
	
	public void darDeAltaProveedorLocal(ProveedorLocal proveedor) throws RemoteException{
		dao.darDeAltaProveedorLocal(proveedor);
	}
	
	public void darDeAltaCarrier(Carrier proveedor) throws RemoteException{
		dao.darDeAltaCarrier(proveedor);
	}	
	
	public ProveedorLocalDTO buscarProveedorLocalDTO(int codigo) {
		return dao.buscarProveedorLocal(codigo).getDTO();
	}
	
	public ProveedorLocal buscarProveedorLocal(int codigo) {
		return dao.buscarProveedorLocal(codigo);
	}

	public CarrierDTO buscarCarrierDTO(int codigo) {
		return dao.buscarCarrier(codigo).getDTO();
	}
	
	public Carrier buscarCarrier(int codigo) {
		return dao.buscarCarrier(codigo);
	}

	public void bajaCarrier(int codigo) {
		Proveedor v = dao.buscarCarrier(codigo);
		if(v== null){
			v = dao.buscarProveedorLocal(codigo);
		}
		dao.bajaCarrier(v);
	}
	
	public List<Object> obtenerProveedores(){
		List<Object> proveedoresDTO = new ArrayList<Object>();
		for(Object proveedor : dao.obtenerProveedores()){
			if(proveedor instanceof Carrier){
				proveedoresDTO.add(((Carrier)proveedor).getDTO());
			}else{
				proveedoresDTO.add(((ProveedorLocal)proveedor).getDTO());
			}
		}
		return proveedoresDTO;
	}
}
