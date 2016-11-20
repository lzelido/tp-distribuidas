package srv;

import java.util.List;
import dao.TipoSeguroDAO;
import entities.TipoSeguro;

public class TipoSeguroSRV {
	
	private static TipoSeguroDAO dao;
	static {
		dao = TipoSeguroDAO.getInstancia();
	}
	
	
	// BUSCAR
	public TipoSeguro buscarTipoSeguro (int codigo){
		TipoSeguro tipoSeguro = dao.buscarTipoSeguro (codigo);
		return tipoSeguro;
	}
	
	public List<TipoSeguro> buscarTipoSeguros (){
		List<TipoSeguro> tipoSeguros = dao.getTipoSeguros();
		return tipoSeguros;
	}
	
	// ALTAS
	public void grabarTipoSeguro(TipoSeguro tipoSeguro){
		dao.grabarTipoSeguro(tipoSeguro);
		
	}
	
	//MODIFICAR
	public void ModificarTipoSeguro(TipoSeguro tipoSeguro){
		dao.ModificarTipoSeguro(tipoSeguro);
		
	}
	
	//BAJA
	public void BajaTipoSeguro(TipoSeguro tipoSeguro){
		dao.BajaTipoSeguro(tipoSeguro);
		
	}
}
