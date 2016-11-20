package srv;

import java.util.ArrayList;
import java.util.List;

import dao.ClienteDAO;
import entities.Cliente;
import entities.Empresa;
import entities.Particular;
import entities.Producto;
import entities.Ubicacion;

public class ClienteSRV {
	private static ClienteDAO dao;

	static {
		dao = ClienteDAO.getInstancia();
	}

	// BUSCAR
	public Cliente buscarCliente(int codigo) {
		Cliente cliente = dao.buscarCliente(codigo);
		return cliente;
	}

	public Empresa buscarEmpresa(String tipoDoc, String nroDoc) {
		Empresa empresa = dao.buscarEmpresa(tipoDoc, nroDoc);
		return empresa;
	}

	public Empresa buscarEmpresa(int codigo) {
		Empresa empresa = dao.buscarEmpresa(codigo);
		return empresa;
	}

	public List<Empresa> buscarEmpresas() {
		return dao.buscarEmpresas();
	}

	public Particular buscarParticular(String tipoDoc, String nroDoc) {
		Particular particular = dao.buscarParticular(tipoDoc, nroDoc);
		return particular;
	}

	public Particular buscarParticular(int codigo) {
		Particular particular = dao.buscarParticular(codigo);
		return particular;
	}

	public List<Particular> buscarParticulares() {
		return dao.buscarParticulares();
	}

	public List<Producto> buscarProductosByCliente(int idCliente) {
		List<Producto> productos = dao.buscarProductosByCliente(idCliente);
		return productos;
	}

	public ArrayList<Ubicacion> buscarUbicacionesByCliente(int idCliente) {
		ArrayList<Ubicacion> destinos = dao.buscarUbicacionesByCliente(idCliente);
		return destinos;
	}

	// ALTAS
	public void grabarCliente(Cliente cliente) {
		dao.save(cliente);
	}
}
