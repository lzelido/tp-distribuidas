package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao.ClienteDAO;
import dto.ParticularDTO;
import entities.Particular;
import service.IClienteParticularService;

public class ClienteParticularController extends UnicastRemoteObject implements IClienteParticularService {
	private static final long serialVersionUID = -9117118351167576127L;

	public ClienteParticularController() throws RemoteException {
		super();
	}

	// BUSCAR
	public ParticularDTO buscarCliente(String tipoDoc, String nroDoc) throws RemoteException {
		try {
			Particular particular = ClienteDAO.getInstancia().buscarParticular(tipoDoc, nroDoc);
			if (particular != null) {
				ParticularDTO particularDTO = particular.toDto();
				return particularDTO;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ParticularDTO buscarCliente(int codigo) throws RemoteException {
		try {
			Particular particular = ClienteDAO.getInstancia().buscarParticular(codigo);
			if (particular != null) {
				ParticularDTO particularDTO = particular.toDto();
				return particularDTO;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Object> buscarClientes() throws RemoteException {
		try {
			List<Object> particulares = new ArrayList<Object>();
			for (Particular particular : ClienteDAO.getInstancia().buscarParticulares()) {
				particulares.add(particular.toDto());
			}
			return particulares;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// ALTAS
	public int guardarCliente(ParticularDTO particularDTO) throws RemoteException {
		try {
			Particular particular = ClienteDAO.getInstancia().buscarParticular(particularDTO.getTipoDoc(),
					particularDTO.getNroDoc());
			if (particular == null) {
				particular = Particular.fromDto(particularDTO);
				particular.save();
				System.out.println("El particular se grabo con exito");
				return 2;
			} else {
				System.out.println("El particular ya existe");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar al particular");
			return 0;
		}
	}

	// BAJA
	public int bajaCliente(int codigo) throws RemoteException {
		try {
			Particular particular = ClienteDAO.getInstancia().buscarParticular(codigo);
			if (particular != null) {
				particular.remove();
				System.out.println("El particular se elimin� con �xito");
				return 2;
			} else {
				System.out.println("El particular no existe");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al eliminar al particular");
			return 0;
		}
	}

	// MODIFICAR
	public int modificarCliente(ParticularDTO particularDTO) throws RemoteException {
		try {
			Particular particular = ClienteDAO.getInstancia().buscarParticular(particularDTO.getCodigo());
			if (particular != null) {
				particular = Particular.fromDto(particularDTO);
				particular.save();
				System.out.println("El particular se grab� con �xito");
				return 2;
			} else {
				System.out.println("El particular no existe");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar al particular");
			return 0;
		}
	}
}
