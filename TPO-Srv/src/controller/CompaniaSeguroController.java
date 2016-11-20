package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.CompaniaSeguroDAO;
import dto.CompaniaSeguroDTO;
import entities.CompaniaSeguro;
import service.ICompaniaSeguroService;

public class CompaniaSeguroController extends UnicastRemoteObject implements ICompaniaSeguroService {

	private static final long serialVersionUID = 1L;

	public CompaniaSeguroController() throws RemoteException {
		super();
	}

	public CompaniaSeguroDTO buscarCompaniaSeguro(int codigo) throws RemoteException {
		try {
			CompaniaSeguro companiaSeguro = CompaniaSeguroDAO.getInstancia().buscarCompaniaSeguro(codigo);

			if (companiaSeguro != null) {
				CompaniaSeguroDTO companiaSeguroDTO = companiaSeguro.toDto();
				return companiaSeguroDTO;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalStateException("No se encontro la compania");
		}
	}

	// ALTAS
	@Override
	public int guardarCompaniaSeguro(CompaniaSeguroDTO companiaSeguroDTO) throws RemoteException {
		try {
			CompaniaSeguro companiaSeguro = CompaniaSeguroDAO.getInstancia()
					.buscarCompaniaSeguro(companiaSeguroDTO.getCodigo());
			if (companiaSeguro == null) {
				companiaSeguro = CompaniaSeguro.fromDto(companiaSeguroDTO);
				companiaSeguro.save();
				System.out.println("La Compania de Seguro se grab� con �xito");
				return 2;
			} else {
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
	public int bajaCompaniaSeguro(CompaniaSeguroDTO companiaSeguroDTO) throws RemoteException {
		try {
			CompaniaSeguro companiaSeguro = CompaniaSeguroDAO.getInstancia()
					.buscarCompaniaSeguro(companiaSeguroDTO.getCodigo());

			if (companiaSeguro != null) {
				companiaSeguro.remove();
				System.out.println("La Compania de Seguro se elimin� con �xito");
				return 2;
			} else {
				System.out.println("La Compania de Seguro no existe");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al eliminar la Compania de Seguro");
			return 0;
		}
	}

	// MODIFICAR
	public int modificarCompaniaSeguro(CompaniaSeguroDTO companiaSeguroDTO) throws RemoteException {
		try {
			CompaniaSeguro companiaSeguro = CompaniaSeguroDAO.getInstancia()
					.buscarCompaniaSeguro(companiaSeguroDTO.getCodigo());

			if (companiaSeguro != null) {
				companiaSeguro = CompaniaSeguro.fromDto(companiaSeguroDTO);
				companiaSeguro.save();
				System.out.println("La Compania de Seguro se grab� con �xito");
				return 2;
			} else {
				System.out.println("La Compania de Seguro no existe");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar la Compania de Seguro");
			return 0;
		}
	}

	@Override
	public List<CompaniaSeguroDTO> obtenerCompaniaSeguro() throws RemoteException {
		return CompaniaSeguro.toDtos(CompaniaSeguroDAO.getInstancia().getCompaniaSeguros());
	}
}