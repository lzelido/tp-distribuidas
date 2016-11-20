package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.CargaDTO;
import dto.SolicitudEnvioDTO;
import dto.SucursalDTO;
import dto.ViajeDTO;

public interface IViajeService  extends Remote{
	int grabarViaje (SucursalDTO sucursalODTO, SucursalDTO sucursalDDTO, List<CargaDTO> cargasDTO, SolicitudEnvioDTO solicitud) throws RemoteException;
	
	List<ViajeDTO> buscarViajesNoEntregadosBySucursal (SucursalDTO sucDDTO) throws RemoteException;
	
	int recepcionViaje (ViajeDTO viajeDTO) throws RemoteException;
}
