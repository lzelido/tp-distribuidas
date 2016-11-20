package controlador;

import java.rmi.RemoteException;
import businessDelegate.BusinessDelegate;
import dto.EmpresaDTO;
import dto.ParticularDTO;

public class ClienteController {
	private static ClienteController instance = null;

	public static ClienteController getInstance() {
		if (instance == null) {
			instance = new ClienteController();
		}
		return instance;
	}

	// BUSCAR
	public EmpresaDTO buscarClienteEmpresa (String tipoDoc, String nroDoc)throws RemoteException{
		return BusinessDelegate.getInstance().buscarClienteEmpresa (tipoDoc, nroDoc);
	}
	
	public EmpresaDTO buscarClienteEmpresa (int codigo)throws RemoteException{
		return BusinessDelegate.getInstance().buscarClienteEmpresa (codigo);
	}
	
	public ParticularDTO buscarClienteParticular (String tipoDoc, String nroDoc)throws RemoteException{
		return BusinessDelegate.getInstance().buscarClienteParticular (tipoDoc, nroDoc);
	}
	
	public ParticularDTO buscarClienteParticular (int codigo)throws RemoteException{
		return BusinessDelegate.getInstance().buscarClienteParticular (codigo);
	}

	// ALTAS
	public int altaClienteEmpresa (EmpresaDTO empresa) throws RemoteException{
		return BusinessDelegate.getInstance().altaClienteEmpresa (empresa);
	}
	
	public int altaClienteParticular (ParticularDTO particular) throws RemoteException{
		return BusinessDelegate.getInstance().altaClienteParticular (particular);
	}
	
	// BAJAS
	public int bajaClienteEmpresa (int codigo) throws RemoteException{
		return BusinessDelegate.getInstance().bajaClienteEmpresa (codigo);
	}
	
	public int bajaClienteParticular (int codigo) throws RemoteException{
		return BusinessDelegate.getInstance().bajaClienteParticular (codigo);
	}
	
	// MODIFICACIONES
	
	public int modificarClienteEmpresa (EmpresaDTO empresa) throws RemoteException{
		return BusinessDelegate.getInstance().modificarClienteEmpresa (empresa);
	}
	
	public int modificarClienteParticular (ParticularDTO particular) throws RemoteException{
		return BusinessDelegate.getInstance().modificarClienteParticular (particular);
	}

}
