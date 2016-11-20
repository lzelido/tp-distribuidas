package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao.CategoriaTratamientoDAO;
import service.ICategoriaTratamientoService;
import dto.CategoriaTratamientoDTO;
import entities.CategoriaTratamiento;

public class CategoriaTratamientoController extends UnicastRemoteObject implements ICategoriaTratamientoService{
	private static final long serialVersionUID = 6965698246000875670L;

	public CategoriaTratamientoController() throws RemoteException {
		super();
	}

	@Override
	public List<CategoriaTratamientoDTO> obtenerCategoriasTratamiento() throws RemoteException {
		List<CategoriaTratamientoDTO> categoriasDTO = new ArrayList<CategoriaTratamientoDTO>();
		for(CategoriaTratamiento t : CategoriaTratamientoDAO.getInstancia().buscarTratamientos()){
			categoriasDTO.add(t.toDto());
		}
		return categoriasDTO;
	}
	
}
