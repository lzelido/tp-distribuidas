package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import service.ITipoDeCargaService;
import srv.TipoDeCargaSRV;
import dto.TipoCargaDTO;
import entities.TipoCarga;

public class TipoDeCargaController extends UnicastRemoteObject implements ITipoDeCargaService{
	private static final long serialVersionUID = 6965698246000875670L;

	public TipoDeCargaController() throws RemoteException {
		super();
	}
	
	@Override
	public List<TipoCargaDTO> obtenerTiposCargas() throws RemoteException {
		List<TipoCargaDTO> tiposCargas = new ArrayList<TipoCargaDTO>();
		for(TipoCarga t : new TipoDeCargaSRV().obtenerTiposCargas()){
			TipoCargaDTO tDTO = new TipoCargaDTO();
			tDTO.setCodigo(t.getCodigo());
			tDTO.setDescri(t.getDescri());
			tiposCargas.add(tDTO);
		}
		return tiposCargas;
	}
	
}
