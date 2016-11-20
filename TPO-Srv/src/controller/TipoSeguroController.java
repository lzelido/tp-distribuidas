package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import dto.TipoSeguroDTO;
import entities.TipoSeguro;
import service.ITipoSeguroService;
import srv.TipoSeguroSRV;


public class TipoSeguroController extends UnicastRemoteObject implements ITipoSeguroService{
	private static final long serialVersionUID = 1L;

	public TipoSeguroController() throws RemoteException {
		super();
	}
	
	// BUSCAR
	public TipoSeguroDTO buscarTipoSeguro (int codigo) throws RemoteException{
		try {
			TipoSeguro tipoSeguro = (new TipoSeguroSRV()).buscarTipoSeguro(codigo);
			if (tipoSeguro != null){
				TipoSeguroDTO tipoSeguroDTO = new TipoSeguroDTO();
				tipoSeguroDTO.setCodigo(tipoSeguro.getCodigo());
				tipoSeguroDTO.setDescripcion(tipoSeguro.getDescripcion());
				return tipoSeguroDTO;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// ALTAS
	@Override
	public int guardarTipoSeguro(TipoSeguroDTO tipoSeguroDTO) throws RemoteException {
		try {
			TipoSeguro tipoSeguro = (new TipoSeguroSRV()).buscarTipoSeguro(tipoSeguroDTO.getCodigo());
			
			if(tipoSeguro == null){
				tipoSeguro = new TipoSeguro();
				tipoSeguro.setCodigo(tipoSeguroDTO.getCodigo());
				tipoSeguro.setDescripcion(tipoSeguroDTO.getDescripcion());
				(new TipoSeguroSRV()).grabarTipoSeguro(tipoSeguro);
				System.out.println("El Tipo de Seguro se grabó con éxito");
				return 2;
			}else{
				System.out.println("El Tipo de Seguro ya existe");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar el Tipo de Seguro");
			return 0;
		}
	}

	// BAJA
	public int bajaTipoSeguro (TipoSeguroDTO tipoSeguroDTO) throws RemoteException{
		try {
			TipoSeguro tipoSeguro = (new TipoSeguroSRV()).buscarTipoSeguro (tipoSeguroDTO.getCodigo());
			if(tipoSeguro != null){
				tipoSeguro.setCodigo(tipoSeguroDTO.getCodigo());
				tipoSeguro.setDescripcion(tipoSeguroDTO.getDescripcion());
				(new TipoSeguroSRV()).BajaTipoSeguro(tipoSeguro); 
				System.out.println("El Tipo de Seguro se eliminó con éxito");
				return 2;
			}else{
				System.out.println("El Tipo de Seguro no existe");
				return 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al eliminar el Tipo de Seguro");
			return 0;
		}
	}
	
	// MODIFICAR
	public int modificarTipoSeguro(TipoSeguroDTO tipoSeguroDTO) throws RemoteException {
		try {
			TipoSeguro tipoSeguro = (new TipoSeguroSRV()).buscarTipoSeguro (tipoSeguroDTO.getCodigo());
			if(tipoSeguro != null){
				tipoSeguro.setCodigo(tipoSeguroDTO.getCodigo());
				tipoSeguro.setDescripcion(tipoSeguroDTO.getDescripcion());
				(new TipoSeguroSRV()).ModificarTipoSeguro(tipoSeguro);
				System.out.println("El Tipo de Seguro se grabó con éxito");
				return 2;
			}else{
				System.out.println("El Tipo de Seguro no existe");
				return 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar el Tipo de Seguro");
			return 0;
		}
	}	
	
	@Override
	public List<TipoSeguroDTO> obtenerTipoSeguro() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
