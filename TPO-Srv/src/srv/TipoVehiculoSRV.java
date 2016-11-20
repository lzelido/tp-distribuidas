package srv;

import java.util.ArrayList;
import java.util.List;

import dao.TipoVehiculoDAO;
import dto.TipoVehiculoDTO;
import entities.TipoVehiculo;

public class TipoVehiculoSRV {
	
	private static TipoVehiculoDAO dao;
	static {
		dao = TipoVehiculoDAO.getInstancia();
	}
	
	public TipoVehiculo buscarTipoVehiculo (int codigo){
		TipoVehiculo tipoVehiculo = dao.buscarTipoVehiculo (codigo);
		return tipoVehiculo;
	}
	
	public List<TipoVehiculoDTO> buscarTiposVehiculo (){
		List<TipoVehiculoDTO> tiposVehiculo = new ArrayList<TipoVehiculoDTO>();
		for(TipoVehiculo t : dao.getTipoVehiculo()){
			tiposVehiculo.add(t.toDto());
		}
		return tiposVehiculo;
	}
	
	public void grabarTipoVehiculo(TipoVehiculo tipoVehiculo){
		dao.grabarTipoVehiculo(tipoVehiculo);
	}
	
	public void modificarTipoVehiculo(TipoVehiculo tipoVehiculo){
		dao.modificarTipoVehiculo(tipoVehiculo);
		
	}
	
	public void bajaTipoVehiculo(int codigo){
		dao.bajaTipoVehiculo(codigo);
	}
}
