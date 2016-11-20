package srv;

import java.util.List;
import dao.TarifaDAO;
import entities.Tarifa;

public class TarifaSRV {
	
	private static TarifaDAO dao;
	static {
		dao = TarifaDAO.getInstancia();
	}
		
	
	// BUSCAR
	public Tarifa buscarTarifa (int codigo){
		Tarifa tarifa = dao.buscarTarifa (codigo);
		return tarifa;
	}
			
	public Tarifa buscarTarifaid (int idTipoSeguro, int idTipoMercaderia){
		Tarifa tarifa = dao.buscarTarifaid (idTipoSeguro,idTipoMercaderia);
		return tarifa;
	}
	
	public List<Tarifa> buscarTarifas (){
		List<Tarifa> tarifas = dao.getTarifas();
		return tarifas;
	}
			
	// ALTAS
	public void grabarTarifa(Tarifa tarifa){
		dao.grabarTarifa(tarifa);
		
	}
		
	//MODIFICAR
	public void ModificarTarifa(Tarifa tarifa){
		dao.ModificarTarifa(tarifa);
				
	}
			
	//BAJA
	public void BajaTarifa(Tarifa tarifa){
		dao.BajaTarifa(tarifa);
				
	}

}
