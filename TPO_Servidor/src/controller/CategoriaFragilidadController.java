package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import service.ICategoriaFragilidadService;
import srv.CategoriaFragilidadSRV;
import dto.CategoriaFragilidadDTO;
import entities.CategoriaFragilidad;

public class CategoriaFragilidadController extends UnicastRemoteObject implements ICategoriaFragilidadService{
	private static final long serialVersionUID = 6965698246000875670L;

	public CategoriaFragilidadController() throws RemoteException {
		super();
	}
	
	@Override
	public List<CategoriaFragilidadDTO> obtenerCategoriasFragilidad() throws RemoteException {
		List<CategoriaFragilidadDTO> categoriasDTO = new ArrayList<CategoriaFragilidadDTO>();
		for(CategoriaFragilidad t : new CategoriaFragilidadSRV().buscarCategoriasFragilidad()){
			CategoriaFragilidadDTO tDTO = new CategoriaFragilidadDTO();
			tDTO.setCodigo(t.getCodigo());
			tDTO.setDescri(t.getDescri());
			categoriasDTO.add(tDTO);
		}
		return categoriasDTO;
	}
	
}
