package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dto.ParticularDTO;
import entities.Particular;
import service.IClienteParticularService;
import srv.ClienteSRV;

public class ClienteParticularController extends UnicastRemoteObject implements IClienteParticularService{
	private static final long serialVersionUID = -9117118351167576127L;
	
	public ClienteParticularController() throws RemoteException {
		super();
	}
	
	// BUSCAR
	public ParticularDTO buscarCliente (String tipoDoc, String nroDoc) throws RemoteException{
		try {
			Particular particular = (new ClienteSRV()).buscarParticular (tipoDoc, nroDoc);
			if (particular != null){
				ParticularDTO particularDTO = new ParticularDTO();
				particularDTO.setCodigo(particular.getCodigo());
				particularDTO.setTipoDoc(particular.getTipoDoc());
				particularDTO.setNroDoc(particular.getNroDoc());
				particularDTO.setNombre(particular.getNombre());
				particularDTO.setReqManifiesto(particular.isReqManifiesto());
				particularDTO.setEsPagoAdelantado(particular.isEsPagoAdelantado());
				particularDTO.setActivo(particular.isActivo());
				
				return particularDTO;
			}
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ParticularDTO buscarCliente (int codigo) throws RemoteException{
		try {
			Particular particular = (new ClienteSRV()).buscarParticular(codigo);
			if (particular != null){
				ParticularDTO particularDTO = new ParticularDTO();
				particularDTO.setCodigo(particular.getCodigo());
				particularDTO.setTipoDoc(particular.getTipoDoc());
				particularDTO.setNroDoc(particular.getNroDoc());
				particularDTO.setNombre(particular.getNombre());
				particularDTO.setReqManifiesto(particular.isReqManifiesto());
				particularDTO.setEsPagoAdelantado(particular.isEsPagoAdelantado());
				particularDTO.setActivo(particular.isActivo());
				
				return particularDTO;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Object> buscarClientes () throws RemoteException{
		try {
			List<Object> particulares = new ArrayList<Object>();
			for(Particular particular :  (new ClienteSRV()).buscarParticulares()){
				ParticularDTO particularDTO = new ParticularDTO();
				particularDTO.setCodigo(particular.getCodigo());
				particularDTO.setTipoDoc(particular.getTipoDoc());
				particularDTO.setNroDoc(particular.getNroDoc());
				particularDTO.setNombre(particular.getNombre());
				particularDTO.setReqManifiesto(particular.isReqManifiesto());
				particularDTO.setEsPagoAdelantado(particular.isEsPagoAdelantado());
				particularDTO.setActivo(particular.isActivo());
				particulares.add(particularDTO);
			}		
			return particulares;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	// ALTAS
	public int guardarCliente (ParticularDTO particularDTO)throws RemoteException{
		try {
			Particular particular = (new ClienteSRV()).buscarParticular(particularDTO.getTipoDoc(), particularDTO.getNroDoc());
			if(particular == null){
				particular = new Particular();
				particular.setTipoDoc(particularDTO.getTipoDoc());
				particular.setNroDoc(particularDTO.getNroDoc());
				particular.setNombre(particularDTO.getNombre());
				particular.setReqManifiesto(particularDTO.isReqManifiesto());
				particular.setEsPagoAdelantado(particularDTO.isEsPagoAdelantado());
				particular.setActivo(true);
								
				(new ClienteSRV()).grabarCliente(particular);
				System.out.println("El particular se grabó con éxito");
				return 2;
			}else{
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
	public int bajaCliente (int codigo) throws RemoteException{
		try {
			Particular particular = (new ClienteSRV()).buscarParticular (codigo);
			if(particular != null){
				particular.setActivo(false);
				
				(new ClienteSRV()).grabarCliente(particular);
				System.out.println("El particular se eliminó con éxito");
				return 2;
			}else{
				System.out.println("El particular no existe");
				return 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al eliminar al particular");
			return 0;
		}
	}
	
	// MODIFICAR
	public int modificarCliente (ParticularDTO particularDTO) throws RemoteException {
		try {
			Particular particular = (new ClienteSRV()).buscarParticular (particularDTO.getCodigo());
			if(particular != null){
				particular.setCodigo(particularDTO.getCodigo());
				particular.setTipoDoc(particularDTO.getTipoDoc());
				particular.setNroDoc(particularDTO.getNroDoc());
				particular.setNombre(particularDTO.getNombre());
				particular.setReqManifiesto(particularDTO.isReqManifiesto());
				particular.setEsPagoAdelantado(particularDTO.isEsPagoAdelantado());
				particular.setActivo(particularDTO.isActivo());
				
				(new ClienteSRV()).grabarCliente(particular);
				System.out.println("El particular se grabó con éxito");
				return 2;
			}else{
				System.out.println("El particular no existe");
				return 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar al particular");
			return 0;
		}
	}
}
