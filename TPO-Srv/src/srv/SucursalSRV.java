package srv;

import java.util.List;

import dao.SucursalDAO;
import entities.Sucursal;

public class SucursalSRV {
	private static SucursalDAO dao;
	static {
		dao = SucursalDAO.getInstancia();
	}
		
	public void grabarSucursal(Sucursal sucursal){
		dao.grabarSucursal(sucursal);	
	}
	
	public Sucursal buscarSucursal(int codigo){
		return  dao.buscarSucursal(codigo);		
	}
		
	public void ModificarSucursal(Sucursal sucursal){
		dao.ModificarSucursal(sucursal);		
	}

	public void EliminarSucursal(Sucursal sucursal){
		dao.EliminarSucursal(sucursal);		
	}
	
	public List<Sucursal> buscarSucursales(){
		return  dao.buscarSucursales();		
	}
}