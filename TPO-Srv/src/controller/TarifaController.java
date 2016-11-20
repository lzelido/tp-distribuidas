package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dto.TarifaDTO;
import dto.TipoSeguroDTO;
import entities.Tarifa;
import entities.TipoSeguro;
import service.ITarifaService;
import srv.TarifaSRV;
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

			if (tarifa != null){
				TarifaDTO tarifaDTO = new TarifaDTO();
				TipoSeguroDTO tipoSeguroDTO = new TipoSeguroDTO();
				tarifaDTO.setCodigo(tarifa.getCodigo());
				tipoSeguroDTO.setCodigo(tipoSeguro.getCodigo());
				tipoSeguroDTO.setDescripcion(tipoSeguro.getDescripcion());
				tarifaDTO.setTipoSeguro(tipoSeguroDTO);
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
			
			if (tarifa != null){
				TarifaDTO tarifaDTO = new TarifaDTO();
				TipoSeguroDTO tipoSeguroDTO = new TipoSeguroDTO();
				tarifaDTO.setCodigo(tarifa.getCodigo());
				tipoSeguroDTO.setCodigo(tipoSeguro.getCodigo());
				tipoSeguroDTO.setDescripcion(tipoSeguro.getDescripcion());
				tarifaDTO.setTipoSeguro(tipoSeguroDTO);
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
				tarifa = new Tarifa();
				tarifa.setCodigo(tarifaDTO.getCodigo());
				tarifa.setTipoSeguro(tipoSeguro);
				tarifa.setValor(tarifaDTO.getValor());
				(new TarifaSRV()).grabarTarifa(tarifa);
				
				System.out.println("La Tarifa se grab� con �xito");
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
				tarifa.setCodigo(tarifaDTO.getCodigo());
				tarifa.setTipoSeguro(tipoSeguro);
				tarifa.setValor(tarifaDTO.getValor());
				(new TarifaSRV()).BajaTarifa(tarifa);
				
				System.out.println("La Tarifa se elimin� con �xito");
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
				tarifa.setCodigo(tarifaDTO.getCodigo());
				tarifa.setTipoSeguro(tipoSeguro);
				tarifa.setValor(tarifaDTO.getValor());
				(new TarifaSRV()).ModificarTarifa(tarifa);

				System.out.println("La Tarifa se grab� con �xito");
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
