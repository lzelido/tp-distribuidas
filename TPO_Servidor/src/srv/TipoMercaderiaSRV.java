package srv;

import java.util.List;
import dao.TipoMercaderiaDAO;
import entities.TipoMercaderia;

public class TipoMercaderiaSRV {
	
	private static TipoMercaderiaDAO dao;
	static {
		dao = TipoMercaderiaDAO.getInstancia();
	}
	
	// BUSCAR
	public TipoMercaderia buscarTipoMercaderia (int codigo){
		TipoMercaderia tipoMercaderia = dao.buscarTipoMercaderia (codigo);
		return tipoMercaderia;
	}
		
	public List<TipoMercaderia> buscarTipoMercaderias (){
		List<TipoMercaderia> tipoMercaderias = dao.getTipoMercaderias();
		return tipoMercaderias;
	}
		
	// ALTAS	
	public void grabarTipoMercaderia(TipoMercaderia tipoMercaderia){
		dao.grabarTipoMercaderia(tipoMercaderia);
		
	}
	
	//MODIFICAR
	public void ModificarTipoMercaderia(TipoMercaderia tipoMercaderia){
		dao.ModificarTipoMercaderia(tipoMercaderia);
	}
		
	//BAJA
	public void BajaTipoMercaderia(TipoMercaderia tipoMercaderia){
		dao.BajaTipoMercaderia(tipoMercaderia);
	}
}
