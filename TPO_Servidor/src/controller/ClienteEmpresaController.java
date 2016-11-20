package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dto.EmpresaDTO;
import entities.Empresa;
import service.IClienteEmpresaService;
import srv.ClienteSRV;

public class ClienteEmpresaController extends UnicastRemoteObject implements IClienteEmpresaService{
	private static final long serialVersionUID = -1120257989926196863L;
		
	public ClienteEmpresaController() throws RemoteException {
		super();
	}
	
	// BUSCAR
	public EmpresaDTO buscarCliente (String tipoDoc, String nroDoc) throws RemoteException{
		try {
			Empresa empresa = (new ClienteSRV()).buscarEmpresa(tipoDoc, nroDoc);
			if (empresa != null){
				EmpresaDTO empresaDTO = new EmpresaDTO();
				empresaDTO.setCodigo(empresa.getCodigo());
				empresaDTO.setTipoDoc(empresa.getTipoDoc());
				empresaDTO.setNroDoc(empresa.getNroDoc());
				empresaDTO.setNombre(empresa.getNombre());
				empresaDTO.setNroCuenta(empresa.getNroCuenta());
				empresaDTO.setCtaCte(empresa.getCtaCte());
				empresaDTO.setMontoMinAutoriz(empresa.getMontoMinAutoriz());
				empresaDTO.setReqManifiesto(empresa.isReqManifiesto());
				empresaDTO.setEsDepositoPrevio(empresa.isEsDepositoPrevio());
				empresaDTO.setEsPagoMensual(empresa.isEsPagoMensual());
				empresaDTO.setActivo(empresa.isActivo());
				
				return empresaDTO;
			}
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public EmpresaDTO buscarCliente (int codigo) throws RemoteException{
		try {
			Empresa empresa = (new ClienteSRV()).buscarEmpresa(codigo);
			if (empresa != null){
				EmpresaDTO empresaDTO = new EmpresaDTO();
				empresaDTO.setCodigo(empresa.getCodigo());
				empresaDTO.setTipoDoc(empresa.getTipoDoc());
				empresaDTO.setNroDoc(empresa.getNroDoc());
				empresaDTO.setNombre(empresa.getNombre());
				empresaDTO.setNroCuenta(empresa.getNroCuenta());
				empresaDTO.setCtaCte(empresa.getCtaCte());
				empresaDTO.setMontoMinAutoriz(empresa.getMontoMinAutoriz());
				empresaDTO.setReqManifiesto(empresa.isReqManifiesto());
				empresaDTO.setEsDepositoPrevio(empresa.isEsDepositoPrevio());
				empresaDTO.setEsPagoMensual(empresa.isEsPagoMensual());
				empresaDTO.setActivo(empresa.isActivo());
				
				return empresaDTO;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Object> buscarClientes () throws RemoteException{
		try {
			List<Object> empresas = new ArrayList<Object>();
			for(Empresa empresa : (new ClienteSRV()).buscarEmpresas()){
					EmpresaDTO empresaDTO = new EmpresaDTO();
					empresaDTO.setCodigo(empresa.getCodigo());
					empresaDTO.setTipoDoc(empresa.getTipoDoc());
					empresaDTO.setNroDoc(empresa.getNroDoc());
					empresaDTO.setNombre(empresa.getNombre());
					empresaDTO.setNroCuenta(empresa.getNroCuenta());
					empresaDTO.setCtaCte(empresa.getCtaCte());
					empresaDTO.setMontoMinAutoriz(empresa.getMontoMinAutoriz());
					empresaDTO.setReqManifiesto(empresa.isReqManifiesto());
					empresaDTO.setEsDepositoPrevio(empresa.isEsDepositoPrevio());
					empresaDTO.setEsPagoMensual(empresa.isEsPagoMensual());
					empresaDTO.setActivo(empresa.isActivo());
					empresas.add(empresaDTO);
			}
			return empresas;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// ALTAS
	public int guardarCliente(EmpresaDTO empresaDTO)throws RemoteException{
		try {
			Empresa empresa = (new ClienteSRV()).buscarEmpresa(empresaDTO.getTipoDoc(), empresaDTO.getNroDoc());
			if(empresa == null){
				empresa = new Empresa();
				empresa.setTipoDoc(empresaDTO.getTipoDoc());
				empresa.setNroDoc(empresaDTO.getNroDoc());
				empresa.setNombre(empresaDTO.getNombre());
				empresa.setNroCuenta(empresaDTO.getNroCuenta());
				empresa.setCtaCte(empresaDTO.getCtaCte());
				empresa.setMontoMinAutoriz(empresaDTO.getMontoMinAutoriz());
				empresa.setReqManifiesto(empresaDTO.isReqManifiesto());
				empresa.setEsDepositoPrevio(empresaDTO.isEsDepositoPrevio());
				empresa.setEsPagoMensual(empresaDTO.isEsPagoMensual());
				empresa.setActivo(true);
				
				(new ClienteSRV()).grabarCliente(empresa);
				System.out.println("La empresa se grabó con éxito");
				return 2;
			}else{
				System.out.println("La empresa ya existe");
				return 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar la empresa");
			return 0;
		}
	}
	
	// BAJAS
	public int bajaCliente (int codigo) throws RemoteException{
		try {
			Empresa empresa = (new ClienteSRV()).buscarEmpresa (codigo);
			if(empresa != null){
				empresa.setActivo(false);
				
				(new ClienteSRV()).grabarCliente(empresa);
				System.out.println("La empresa se eliminó con éxito");
				return 2;
			}else{
				System.out.println("La empresa no existe");
				return 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al eliminar la empresa ");
			return 0;
		}
	}
	
	// MODIFICACIONES
	public int modificarCliente (EmpresaDTO empresaDTO) throws RemoteException {
		try {
			Empresa empresa = (new ClienteSRV()).buscarEmpresa(empresaDTO.getCodigo());
			if(empresa != null){
				empresa.setCodigo(empresaDTO.getCodigo());
				empresa.setTipoDoc(empresaDTO.getTipoDoc());
				empresa.setNroDoc(empresaDTO.getNroDoc());
				empresa.setNombre(empresaDTO.getNombre());
				empresa.setNroCuenta(empresaDTO.getNroCuenta());
				empresa.setCtaCte(empresaDTO.getCtaCte());
				empresa.setMontoMinAutoriz(empresaDTO.getMontoMinAutoriz());
				empresa.setReqManifiesto(empresaDTO.isReqManifiesto());
				empresa.setEsDepositoPrevio(empresaDTO.isEsDepositoPrevio());
				empresa.setEsPagoMensual(empresaDTO.isEsPagoMensual());
				empresa.setActivo(empresaDTO.isActivo());
				
				(new ClienteSRV()).grabarCliente(empresa);
				System.out.println("La empresa se grabó con éxito");
				return 2;
			}else{
				System.out.println("La empresa no existe");
				return 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar la empresa");
			return 0;
		}
	}
}