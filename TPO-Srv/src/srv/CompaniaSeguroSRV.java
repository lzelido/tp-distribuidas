package srv;

import java.util.List;
import dao.CompaniaSeguroDAO;
import entities.CompaniaSeguro;

public class CompaniaSeguroSRV {
	
	private static CompaniaSeguroDAO dao;
	static {
		dao = CompaniaSeguroDAO.getInstancia();
	}
	
	// BUSCAR
	public CompaniaSeguro buscarCompaniaSeguro (int codigo){
		CompaniaSeguro companiaSeguro = dao.buscarCompaniaSeguro (codigo);
		return companiaSeguro;
	}
			
	public List<CompaniaSeguro> buscarCompaniaSeguros (){
		List<CompaniaSeguro> companiaSeguros = dao.getCompaniaSeguros();
		return companiaSeguros;
	}
				
	// ALTAS
	public void grabarCompaniaSeguro(CompaniaSeguro companiaSeguro){
		dao.save(companiaSeguro);
	}
			
	//MODIFICAR
	public void ModificarCompaniaSeguro(CompaniaSeguro companiaSeguro){
		dao.ModificarCompaniaSeguro(companiaSeguro);
	}
				
	//BAJA
	public void BajaCompaniaSeguro(CompaniaSeguro companiaSeguro){
		dao.BajaCompaniaSeguro(companiaSeguro);
	}
}