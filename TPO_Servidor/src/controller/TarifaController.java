package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dto.TarifaDTO;
import dto.TipoMercaderiaDTO;
import dto.TipoSeguroDTO;
import entities.Tarifa;
import entities.TipoMercaderia;
import entities.TipoSeguro;
import service.ITarifaService;
import srv.TarifaSRV;
import srv.TipoMercaderiaSRV;
import srv.TipoSeguroSRV;

public class TarifaController extends UnicastRemoteObject implements ITarifaService {
	
	private static final long serialVersionUID = 1L;

	public TarifaController() throws RemoteException {
		super();
	}

	// BUSCAR
	@SuppressWarnings("unused")
	public TarifaDTO buscarTarifa (int codigo) throws RemoteException{
		try {
			
			Tarifa tarifa = (new TarifaSRV()).buscarTarifa(codigo);
			TipoSeguro tipoSeguro = (new TipoSeguroSRV()).buscarTipoSeguro(tarifa.getTipoSeguro().getCodigo());
			TipoMercaderia tipoMercaderia = (new TipoMercaderiaSRV()).buscarTipoMercaderia(tarifa.getTipoMercaderia().getCodigo());

			if (tarifa != null){
				TarifaDTO tarifaDTO = new TarifaDTO();
				TipoSeguroDTO tipoSeguroDTO = new TipoSeguroDTO();
				TipoMercaderiaDTO tipoMercaderiaDTO = new TipoMercaderiaDTO();
				tarifaDTO.setCodigo(tarifa.getCodigo());
				tipoSeguroDTO.setCodigo(tipoSeguro.getCodigo());
				tipoSeguroDTO.setDescripcion(tipoSeguro.getDescripcion());
				tarifaDTO.setTipoSeguro(tipoSeguroDTO);
				tipoMercaderiaDTO.setCodigo(tipoMercaderia.getCodigo());
				tipoMercaderiaDTO.setDescripcion(tipoMercaderia.getDescripcion());
				tarifaDTO.setTipoMercaderia(tipoMercaderiaDTO);
				tarifaDTO.setValor(tarifa.getValor());
				return tarifaDTO;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public TarifaDTO buscarTarifaid (int idTipoSeguro, int idTipoMercaderia) throws RemoteException{
		try {
			Tarifa tarifa = (new TarifaSRV()).buscarTarifaid(idTipoSeguro,idTipoMercaderia);
			TipoSeguro tipoSeguro = (new TipoSeguroSRV()).buscarTipoSeguro(idTipoSeguro);
			TipoMercaderia tipoMercaderia = (new TipoMercaderiaSRV()).buscarTipoMercaderia(idTipoSeguro);
			
			if (tarifa != null){
				TarifaDTO tarifaDTO = new TarifaDTO();
				TipoSeguroDTO tipoSeguroDTO = new TipoSeguroDTO();
				TipoMercaderiaDTO tipoMercaderiaDTO = new TipoMercaderiaDTO();
				tarifaDTO.setCodigo(tarifa.getCodigo());
				tipoSeguroDTO.setCodigo(tipoSeguro.getCodigo());
				tipoSeguroDTO.setDescripcion(tipoSeguro.getDescripcion());
				tarifaDTO.setTipoSeguro(tipoSeguroDTO);
				tipoMercaderiaDTO.setCodigo(tipoMercaderia.getCodigo());
				tipoMercaderiaDTO.setDescripcion(tipoMercaderia.getDescripcion());
				tarifaDTO.setTipoMercaderia(tipoMercaderiaDTO);
				tarifaDTO.setValor(tarifa.getValor());

				return tarifaDTO;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// ALTAS
	@Override
	public int guardarTarifa(TarifaDTO tarifaDTO) throws RemoteException {
		try {
			Tarifa tarifa = (new TarifaSRV()).buscarTarifa(tarifaDTO.getCodigo());
					
			if(tarifa == null){
				TipoSeguro tipoSeguro = (new TipoSeguroSRV()).buscarTipoSeguro(tarifaDTO.getTipoSeguro().getCodigo());
				TipoMercaderia tipoMercaderia = (new TipoMercaderiaSRV().buscarTipoMercaderia(tarifaDTO.getTipoMercaderia().getCodigo()));
				tarifa = new Tarifa();
				tarifa.setCodigo(tarifaDTO.getCodigo());
				tarifa.setTipoSeguro(tipoSeguro);
				tarifa.setTipoMercaderia(tipoMercaderia);
				tarifa.setValor(tarifaDTO.getValor());
				(new TarifaSRV()).grabarTarifa(tarifa);
				
				System.out.println("La Tarifa se grabó con éxito");
				return 2;
			}else{
				System.out.println("La Tarifa ya existe");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar la Tarifa");
			return 0;
		}
	}

	// BAJA
	public int bajaTarifa(TarifaDTO tarifaDTO) throws RemoteException{
		try {
			Tarifa tarifa = (new TarifaSRV()).buscarTarifa(tarifaDTO.getCodigo());

			if(tarifa != null){
				TipoSeguro tipoSeguro = (new TipoSeguroSRV()).buscarTipoSeguro(tarifaDTO.getTipoSeguro().getCodigo());
				TipoMercaderia tipoMercaderia = (new TipoMercaderiaSRV().buscarTipoMercaderia(tarifaDTO.getTipoMercaderia().getCodigo()));
				tarifa.setCodigo(tarifaDTO.getCodigo());
				tarifa.setTipoSeguro(tipoSeguro);
				tarifa.setTipoMercaderia(tipoMercaderia);
				tarifa.setValor(tarifaDTO.getValor());
				(new TarifaSRV()).BajaTarifa(tarifa);
				
				System.out.println("La Tarifa se eliminó con éxito");
				return 2;
			}else{
				System.out.println("La Tarifa no existe");
				return 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al eliminar la Tarifa");
			return 0;
		}
	}
	
	// MODIFICAR
	public int modificarTarifa(TarifaDTO tarifaDTO) throws RemoteException {
		try {
			Tarifa tarifa = (new TarifaSRV()).buscarTarifa(tarifaDTO.getCodigo());
					
			if(tarifa != null){
				TipoSeguro tipoSeguro = (new TipoSeguroSRV()).buscarTipoSeguro(tarifaDTO.getTipoSeguro().getCodigo());
				TipoMercaderia tipoMercaderia = (new TipoMercaderiaSRV().buscarTipoMercaderia(tarifaDTO.getTipoMercaderia().getCodigo()));	
				tarifa.setCodigo(tarifaDTO.getCodigo());
				tarifa.setTipoSeguro(tipoSeguro);
				tarifa.setTipoMercaderia(tipoMercaderia);
				tarifa.setValor(tarifaDTO.getValor());
				(new TarifaSRV()).ModificarTarifa(tarifa);

				System.out.println("La Tarifa se grabó con éxito");
				return 2;
			}else{
				System.out.println("La Tarifa no existe");
				return 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar la Tarifa");
			return 0;
		}
	}	

	@Override
	public List<TarifaDTO> obtenerTarifa() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
