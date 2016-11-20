package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import dto.TipoMercaderiaDTO;
import entities.TipoMercaderia;
import service.ITipoMercaderiaService;
import srv.TipoMercaderiaSRV;

public class TipoMercaderiaController  extends UnicastRemoteObject implements ITipoMercaderiaService{
	private static final long serialVersionUID = 1L;

	public TipoMercaderiaController() throws RemoteException {
		super();
	}

	// BUSCAR
		public TipoMercaderiaDTO buscarTipoMercaderia (int codigo) throws RemoteException{
			try {
				TipoMercaderia tipoMercaderia = (new TipoMercaderiaSRV()).buscarTipoMercaderia(codigo);
				if (tipoMercaderia != null){
					TipoMercaderiaDTO tipoMercaderiaDTO = new TipoMercaderiaDTO();
					tipoMercaderiaDTO.setCodigo(tipoMercaderia.getCodigo());
					tipoMercaderiaDTO.setDescripcion(tipoMercaderia.getDescripcion());
					return tipoMercaderiaDTO;
				}
				return null;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		// ALTAS
	@Override
	public int guardarTipoMercaderia(TipoMercaderiaDTO tipoMercaderiaDTO) throws RemoteException {
		try {
			TipoMercaderia tipoMercaderia = (new TipoMercaderiaSRV()).buscarTipoMercaderia(tipoMercaderiaDTO.getCodigo());
			
			if(tipoMercaderia == null){
				tipoMercaderia = new TipoMercaderia();
				tipoMercaderia.setCodigo(tipoMercaderiaDTO.getCodigo());
				tipoMercaderia.setDescripcion(tipoMercaderiaDTO.getDescripcion());
				(new TipoMercaderiaSRV()).grabarTipoMercaderia(tipoMercaderia);
				System.out.println("El Tipo de Mercaderia se grabó con éxito");
				return 2;
			}else{
				System.out.println("El Tipo de Mercaderia ya existe");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar el Tipo de Mercaderia");
			return 0;
		}
	}

	// BAJA
		public int bajaTipoMercaderia (TipoMercaderiaDTO tipoMercaderiaDTO) throws RemoteException{
			try {
				TipoMercaderia tipoMercaderia = (new TipoMercaderiaSRV()).buscarTipoMercaderia (tipoMercaderiaDTO.getCodigo());
				if(tipoMercaderia != null){
					tipoMercaderia.setCodigo(tipoMercaderiaDTO.getCodigo());
					tipoMercaderia.setDescripcion(tipoMercaderiaDTO.getDescripcion());
					(new TipoMercaderiaSRV()).BajaTipoMercaderia(tipoMercaderia); 
					System.out.println("El Tipo de Mercaderia se eliminó con éxito");
					return 2;
				}else{
					System.out.println("El Tipo de Mercaderia no existe");
					return 1;
				}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error al eliminar el Tipo de Mercaderia");
				return 0;
			}
		}
		
		// MODIFICAR
		public int modificarTipoMercaderia(TipoMercaderiaDTO tipoMercaderiaDTO) throws RemoteException {
			try {
				TipoMercaderia tipoMercaderia = (new TipoMercaderiaSRV()).buscarTipoMercaderia (tipoMercaderiaDTO.getCodigo());
				if(tipoMercaderia != null){
					tipoMercaderia.setCodigo(tipoMercaderiaDTO.getCodigo());
					tipoMercaderia.setDescripcion(tipoMercaderiaDTO.getDescripcion());
					(new TipoMercaderiaSRV()).ModificarTipoMercaderia(tipoMercaderia);
					System.out.println("El Tipo de Mercaderia se grabó con éxito");
					return 2;
				}else{
					System.out.println("El Tipo de Mercaderia no existe");
					return 1;
				}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error al grabar el Tipo de Mercaderia");
				return 0;
			}
		}	

	@Override
	public List<TipoMercaderiaDTO> obtenerTipoMercaderia() throws RemoteException {
		try {
			List<TipoMercaderiaDTO> tiposMercaderias = new ArrayList<TipoMercaderiaDTO>();
			for (TipoMercaderia t : (new TipoMercaderiaSRV()).buscarTipoMercaderias()){
				TipoMercaderiaDTO tipoMercaderiaDTO = new TipoMercaderiaDTO();
				tipoMercaderiaDTO.setCodigo(t.getCodigo());
				tipoMercaderiaDTO.setDescripcion(t.getDescripcion());
				tiposMercaderias.add(tipoMercaderiaDTO);
			}
			return tiposMercaderias;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
