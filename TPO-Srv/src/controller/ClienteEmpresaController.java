package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao.ClienteDAO;
import dto.EmpresaDTO;
import entities.Empresa;
import service.IClienteEmpresaService;

public class ClienteEmpresaController extends UnicastRemoteObject implements IClienteEmpresaService {
	private static final long serialVersionUID = -1120257989926196863L;

	public ClienteEmpresaController() throws RemoteException {
		super();
	}

	// BUSCAR
	public EmpresaDTO buscarCliente(String tipoDoc, String nroDoc) throws RemoteException {
		try {

			Empresa empresa = ClienteDAO.getInstancia().buscarEmpresa(tipoDoc, nroDoc);
			if (empresa != null) {
				EmpresaDTO empresaDTO = empresa.toDto();
				return empresaDTO;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalStateException("no se encontro el cliente");
		}
	}

	public EmpresaDTO buscarCliente(int codigo) throws RemoteException {
		try {
			Empresa empresa = ClienteDAO.getInstancia().buscarEmpresa(codigo);
			if (empresa != null) {
				return empresa.toDto();
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalStateException("no se encontro el cliente");
		}
	}

	public List<EmpresaDTO> buscarClientes() throws RemoteException {
		try {
			List<EmpresaDTO> empresas = new ArrayList<EmpresaDTO>();
			for (Empresa empresa : ClienteDAO.getInstancia().buscarEmpresas()) {
				empresas.add(empresa.toDto());
			}
			return empresas;
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalStateException("no se encontraron clientes");
		}
	}

	// ALTAS
	public int guardarCliente(EmpresaDTO empresaDTO) throws RemoteException {
		try {
			Empresa empresa = ClienteDAO.getInstancia().buscarEmpresa(empresaDTO.getTipoDoc(), empresaDTO.getNroDoc());
			if (empresa == null) {
				empresa = Empresa.fromDto(empresaDTO);
				empresa.save();
				System.out.println("La empresa se grabo con exito");
				return 2;
			} else {
				System.out.println("La empresa ya existe");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar la empresa");
			return 0;
		}
	}

	// BAJAS
	public int bajaCliente(int codigo) throws RemoteException {
		try {
			Empresa empresa = ClienteDAO.getInstancia().buscarEmpresa(codigo);
			if (empresa != null) {
				empresa.remove();
				System.out.println("La empresa se elimin� con �xito");
				return 2;
			} else {
				System.out.println("La empresa no existe");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al eliminar la empresa ");
			return 0;
		}
	}

	// MODIFICACIONES
	public int modificarCliente(EmpresaDTO empresaDTO) throws RemoteException {
		try {
			Empresa empresa = ClienteDAO.getInstancia().buscarEmpresa(empresaDTO.getCodigo());
			if (empresa != null) {
				empresa = Empresa.fromDto(empresaDTO);
				empresa.save();
				System.out.println("La empresa se grab� con �xito");
				return 2;
			} else {
				System.out.println("La empresa no existe");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar la empresa");
			return 0;
		}
	}
}