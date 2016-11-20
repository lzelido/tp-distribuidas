package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.EmpleadoDTO;
import dto.FacturaDTO;
import dto.SolicitudEnvioDTO;
import dto.SucursalDTO;

public interface IFacturaService extends Remote{
	public int grabarFactura (SolicitudEnvioDTO solicitud, EmpleadoDTO empleado, SucursalDTO sucursal)throws RemoteException;
	public List<FacturaDTO> buscarFacturas (int codigoCliente)throws RemoteException;
	public int pagarFactura (int codigoFactura)throws RemoteException;
	public int entregarCarga (FacturaDTO facturaDTO, SucursalDTO sucDDTO)throws RemoteException;
}
