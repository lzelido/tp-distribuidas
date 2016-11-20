package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import dto.CompaniaSeguroDTO;
import dto.TarifaDTO;
import dto.TipoMercaderiaDTO;
import dto.TipoSeguroDTO;
import entities.CompaniaSeguro;
import entities.Tarifa;
import entities.TipoMercaderia;
import entities.TipoSeguro;
import service.ICompaniaSeguroService;
import srv.CompaniaSeguroSRV;

public class CompaniaSeguroController extends UnicastRemoteObject implements ICompaniaSeguroService  {

	private static final long serialVersionUID = 1L;
	

	public CompaniaSeguroController() throws RemoteException {
		super();
	}

	// BUSCAR
		public CompaniaSeguroDTO buscarCompaniaSeguro (int codigo) throws RemoteException{
			try {
				CompaniaSeguro companiaSeguro = (new CompaniaSeguroSRV()).buscarCompaniaSeguro(codigo);

				if (companiaSeguro != null){
					CompaniaSeguroDTO companiaSeguroDTO = new CompaniaSeguroDTO();
					companiaSeguroDTO.setCodigo(companiaSeguro.getCodigo());
					companiaSeguroDTO.setDescripcion(companiaSeguro.getDescripcion());
					
					List<TarifaDTO> tarifasDTO = new ArrayList<TarifaDTO>();
					TarifaDTO tarifaDTO = new TarifaDTO();
					TipoSeguroDTO tipoSeguroDTO=new TipoSeguroDTO();
					TipoMercaderiaDTO tipoMercaderiaDTO=new TipoMercaderiaDTO();
					List<Tarifa> tarifas = companiaSeguro.getTarifas();
					for(int i=0;i<tarifasDTO.size();i++){
						tarifaDTO.setCodigo(tarifas.get(i).getCodigo());
						tipoSeguroDTO.setCodigo(tarifas.get(i).getTipoSeguro().getCodigo());
						tipoSeguroDTO.setDescripcion(tarifas.get(i).getTipoSeguro().getDescripcion());
						tarifaDTO.setTipoSeguro(tipoSeguroDTO);
						tipoMercaderiaDTO.setCodigo(tarifas.get(i).getTipoMercaderia().getCodigo());
						tipoMercaderiaDTO.setDescripcion(tarifas.get(i).getTipoMercaderia().getDescripcion());
						tarifaDTO.setTipoMercaderia(tipoMercaderiaDTO);
						tarifaDTO.setValor(tarifas.get(i).getValor());
					}
					
					companiaSeguroDTO.setTarifas(tarifasDTO);
					
					return companiaSeguroDTO;
				}
				return null;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		// ALTAS
		@Override
		public int guardarCompaniaSeguro(CompaniaSeguroDTO companiaSeguroDTO) throws RemoteException {
			try {
				CompaniaSeguro companiaSeguro = (new CompaniaSeguroSRV()).buscarCompaniaSeguro(companiaSeguroDTO.getCodigo());
			
				if(companiaSeguro == null){
					List<Tarifa> tarifas = new ArrayList<Tarifa>();
					Tarifa tarifa = new Tarifa();
					TipoSeguro tipoSeguro=new TipoSeguro();
					TipoMercaderia tipoMercaderia=new TipoMercaderia();
					List<TarifaDTO> tarifasDTO = companiaSeguroDTO.getTarifas();
					for(int i=0;i<tarifasDTO.size();i++){
						tarifa.setCodigo(tarifasDTO.get(i).getCodigo());
						tipoSeguro.setCodigo(tarifasDTO.get(i).getTipoSeguro().getCodigo());
						tipoSeguro.setDescripcion(tarifasDTO.get(i).getTipoSeguro().getDescripcion());
						tarifa.setTipoSeguro(tipoSeguro);
						tipoMercaderia.setCodigo(tarifasDTO.get(i).getTipoMercaderia().getCodigo());
						tipoMercaderia.setDescripcion(tarifasDTO.get(i).getTipoMercaderia().getDescripcion());
						tarifa.setTipoMercaderia(tipoMercaderia);
						tarifa.setValor(tarifasDTO.get(i).getValor());
						tarifas.add(tarifa);
					}
					companiaSeguro = new CompaniaSeguro();
					companiaSeguro.setCodigo(companiaSeguroDTO.getCodigo());
					companiaSeguro.setDescripcion(companiaSeguroDTO.getDescripcion());
					companiaSeguro.setTarifas(tarifas);
					(new CompaniaSeguroSRV()).grabarCompaniaSeguro(companiaSeguro);
					
					System.out.println("La Compania de Seguro se grabó con éxito");
					return 2;
				}else{
					System.out.println("La Compania de Seguro ya existe");
					return 1;
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error al grabar la Compania de Seguro");
				return 0;
			}
		}

		// BAJA
		public int bajaCompaniaSeguro(CompaniaSeguroDTO companiaSeguroDTO) throws RemoteException{
			try {
				CompaniaSeguro companiaSeguro = (new CompaniaSeguroSRV()).buscarCompaniaSeguro(companiaSeguroDTO.getCodigo());
			
				if(companiaSeguro == null){
					List<Tarifa> tarifas = new ArrayList<Tarifa>();
					Tarifa tarifa = new Tarifa();
					TipoSeguro tipoSeguro=new TipoSeguro();
					TipoMercaderia tipoMercaderia=new TipoMercaderia();
					List<TarifaDTO> tarifasDTO = companiaSeguroDTO.getTarifas();
					for(int i=0;i<tarifas.size();i++){
						tarifa.setCodigo(tarifasDTO.get(i).getCodigo());
						tipoSeguro.setCodigo(tarifasDTO.get(i).getTipoSeguro().getCodigo());
						tipoSeguro.setDescripcion(tarifasDTO.get(i).getTipoSeguro().getDescripcion());
						tarifa.setTipoSeguro(tipoSeguro);
						tipoMercaderia.setCodigo(tarifasDTO.get(i).getTipoMercaderia().getCodigo());
						tipoMercaderia.setDescripcion(tarifasDTO.get(i).getTipoMercaderia().getDescripcion());
						tarifa.setTipoMercaderia(tipoMercaderia);
						tarifa.setValor(tarifasDTO.get(i).getValor());
					}
					companiaSeguro = new CompaniaSeguro();
					companiaSeguro.setCodigo(companiaSeguroDTO.getCodigo());
					companiaSeguro.setDescripcion(companiaSeguroDTO.getDescripcion());
					companiaSeguro.setTarifas(tarifas);
					(new CompaniaSeguroSRV()).BajaCompaniaSeguro(companiaSeguro); 
					
					System.out.println("La Compania de Seguro se eliminó con éxito");
					return 2;
				}else{
					System.out.println("La Compania de Seguro no existe");
					return 1;
				}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error al eliminar la Compania de Seguro");
				return 0;
			}
		}
		
		// MODIFICAR
		public int modificarCompaniaSeguro(CompaniaSeguroDTO companiaSeguroDTO) throws RemoteException {
			try {
				CompaniaSeguro companiaSeguro = (new CompaniaSeguroSRV()).buscarCompaniaSeguro(companiaSeguroDTO.getCodigo());
			
				if(companiaSeguro == null){
					List<Tarifa> tarifas = new ArrayList<Tarifa>();
					Tarifa tarifa = new Tarifa();
					TipoSeguro tipoSeguro=new TipoSeguro();
					TipoMercaderia tipoMercaderia=new TipoMercaderia();
					List<TarifaDTO> tarifasDTO = companiaSeguroDTO.getTarifas();
					for(int i=0;i<tarifas.size();i++){
						tarifa.setCodigo(tarifasDTO.get(i).getCodigo());
						tipoSeguro.setCodigo(tarifasDTO.get(i).getTipoSeguro().getCodigo());
						tipoSeguro.setDescripcion(tarifasDTO.get(i).getTipoSeguro().getDescripcion());
						tarifa.setTipoSeguro(tipoSeguro);
						tipoMercaderia.setCodigo(tarifasDTO.get(i).getTipoMercaderia().getCodigo());
						tipoMercaderia.setDescripcion(tarifasDTO.get(i).getTipoMercaderia().getDescripcion());
						tarifa.setTipoMercaderia(tipoMercaderia);
						tarifa.setValor(tarifasDTO.get(i).getValor());
					}
					companiaSeguro = new CompaniaSeguro();
					companiaSeguro.setCodigo(companiaSeguroDTO.getCodigo());
					companiaSeguro.setDescripcion(companiaSeguroDTO.getDescripcion());
					companiaSeguro.setTarifas(tarifas);
					(new CompaniaSeguroSRV()).ModificarCompaniaSeguro(companiaSeguro);

					System.out.println("La Compania de Seguro se grabó con éxito");
					return 2;
				}else{
					System.out.println("La Compania de Seguro no existe");
					return 1;
				}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error al grabar la Compania de Seguro");
				return 0;
			}
		}	

		@Override
		public List<CompaniaSeguroDTO> obtenerCompaniaSeguro() throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
}