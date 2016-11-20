package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import service.ITipoVehiculoService;
import srv.TipoVehiculoSRV;
import dto.TipoVehiculoDTO;
import entities.TipoVehiculo;


public class TipoVehiculoController extends UnicastRemoteObject implements ITipoVehiculoService{
	private static final long serialVersionUID = 1L;

	public TipoVehiculoController() throws RemoteException {
		super();
	}
	
	@Override
	public TipoVehiculoDTO buscarTipoVehiculo(int codigo) throws RemoteException{
		try {
			TipoVehiculo tipoVehiculo = (new TipoVehiculoSRV()).buscarTipoVehiculo(codigo);
			if (tipoVehiculo != null){
				TipoVehiculoDTO tipoVehiculoDTO = new TipoVehiculoDTO();
				tipoVehiculoDTO.setCodigo(tipoVehiculo.getCodigo());
				tipoVehiculoDTO.setDescri(tipoVehiculo.getDescri());
				tipoVehiculoDTO.setCondicion(tipoVehiculo.getCondicion());
				tipoVehiculoDTO.setTieneCondEspecial(tipoVehiculo.isTieneCondEspecial());
				return tipoVehiculoDTO;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int guardarTipoVehiculo(TipoVehiculoDTO tipoVehiculoDTO) throws RemoteException {
		try {
			TipoVehiculo tipoVehiculo = (new TipoVehiculoSRV()).buscarTipoVehiculo(tipoVehiculoDTO.getCodigo());
			
			if(tipoVehiculo == null){
				tipoVehiculo = new TipoVehiculo();
				tipoVehiculo.setCodigo(tipoVehiculoDTO.getCodigo());
				tipoVehiculo.setDescri(tipoVehiculoDTO.getDescri());
				tipoVehiculo.setCondicion(tipoVehiculoDTO.getCondicion());
				tipoVehiculo.setTieneCondEspecial(tipoVehiculoDTO.isTieneCondEspecial());
				(new TipoVehiculoSRV()).grabarTipoVehiculo(tipoVehiculo);
				return 2;
			}else{
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public void bajaTipoVehiculo (int codigo) throws RemoteException{
		try {
			(new TipoVehiculoSRV()).bajaTipoVehiculo(codigo); 
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int modificarTipoVehiculo(TipoVehiculoDTO tipoVehiculoDTO) throws RemoteException {
		try {
			TipoVehiculo tipoVehiculo = (new TipoVehiculoSRV()).buscarTipoVehiculo (tipoVehiculoDTO.getCodigo());
			tipoVehiculo.setDescri(tipoVehiculoDTO.getDescri());
			tipoVehiculo.setCondicion(tipoVehiculoDTO.getCondicion());
			tipoVehiculo.setTieneCondEspecial(tipoVehiculoDTO.isTieneCondEspecial());
			(new TipoVehiculoSRV()).modificarTipoVehiculo(tipoVehiculo);
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<TipoVehiculoDTO> buscarTiposVehiculo() throws RemoteException {
		return (new TipoVehiculoSRV()).buscarTiposVehiculo();
	}	
}
