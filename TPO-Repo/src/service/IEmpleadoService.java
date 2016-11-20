package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;
import dto.EmpleadoDTO;
 
public interface IEmpleadoService extends Remote{
	 
	// BUSCAR
	public EmpleadoDTO buscarEmpleado (int numero) throws RemoteException;
	public Vector<EmpleadoDTO> buscarEmpleados()throws RemoteException;
	 
	// ALTAS
	public int guardarEmpleado(EmpleadoDTO empleado)throws RemoteException;
	 
	// BAJAS
	public int eliminarEmpleado(EmpleadoDTO empleadoDTO) throws RemoteException;
	 
	//MODIFICACIONES
	public int ModificarEmpleado(EmpleadoDTO empleadoDTO) throws RemoteException;
}