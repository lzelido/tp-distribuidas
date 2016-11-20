package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Vector;

import service.IEmpleadoService;
import srv.EmpleadoSRV;
import dto.EmpleadoDTO;
import entities.Empleado;

public class EmpleadoController extends UnicastRemoteObject implements IEmpleadoService {
	private static final long serialVersionUID = 1L;

	public EmpleadoController() throws RemoteException {
		super();
	}
	
	@Override
	public EmpleadoDTO buscarEmpleado(int numero) throws RemoteException {
		try {
			Empleado empleado = (new EmpleadoSRV()).buscarEmpleado(numero);
			if (empleado!=null){
				//transformo la entidad en dto
				EmpleadoDTO empleadoDTO= new EmpleadoDTO();
				empleadoDTO.setNumero(empleado.getNumero());
				empleadoDTO.setNombre(empleado.getNombre());
				empleadoDTO.setApellido(empleado.getApellido());
				empleadoDTO.setPuesto(empleado.getPuesto());
				empleadoDTO.setSucursal(empleado.getSucursal());
				return empleadoDTO;
			
			}else{
				System.out.println("El empleado ya existe");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al buscar el empleado");
			return null;
		}
	}

	@Override
	public int guardarEmpleado(EmpleadoDTO empleadoDTO) throws RemoteException {
		try {
			Empleado empleado = (new EmpleadoSRV()).buscarEmpleado(empleadoDTO.getNumero());
			
			if(empleado == null){
				empleado = new Empleado();
				empleado.setNumero(empleadoDTO.getNumero());
				empleado.setNombre(empleadoDTO.getNombre());
				empleado.setApellido(empleadoDTO.getApellido());
				empleado.setPuesto(empleadoDTO.getPuesto());
				empleado.setSucursal(empleadoDTO.getSucursal());
				(new EmpleadoSRV()).grabarEmpleado(empleado);
				System.out.println("El empleado se grabó con éxito");
				return 2;
			}else{
				System.out.println("El empleado ya existe");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar el empleado");
			return 0;
		}
	}

	@Override
	public int ModificarEmpleado(EmpleadoDTO empleadoDTO) throws RemoteException {
		try {
			Empleado empleado = (new EmpleadoSRV()).buscarEmpleado(empleadoDTO.getNumero());
			
			if(empleado != null){
				empleado.setNumero(empleadoDTO.getNumero());
				empleado.setNombre(empleadoDTO.getNombre());
				empleado.setApellido(empleadoDTO.getApellido());
				empleado.setPuesto(empleadoDTO.getPuesto());
				empleado.setSucursal(empleadoDTO.getSucursal());
				(new EmpleadoSRV()).ModificarEmpleado(empleado); 
				System.out.println("El empleado se modifico con éxito");
				return 2;
			}else{
				System.out.println("El empleado no existe");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al modificar el empleado");
			return 0;
		}
	}
		
	public int eliminarEmpleado(EmpleadoDTO empleadoDTO) throws RemoteException {
		try {
			Empleado empleado = (new EmpleadoSRV()).buscarEmpleado(empleadoDTO.getNumero());
			if(empleado != null){
				(new EmpleadoSRV()).EliminarEmpleado(empleado); 
				System.out.println("El empleado se elimino con éxito");
				return 2;
			}else{
				System.out.println("El empleado no existe");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al eliminar el empleado");
			return 0;
		}
	}
	
	public Vector<EmpleadoDTO> buscarEmpleados () throws RemoteException{
		try {
			List<Empleado> empleados = (new EmpleadoSRV()).buscarEmpleados();
			Vector<EmpleadoDTO> empleadosDTO = new Vector<EmpleadoDTO>();
			if (empleados != null){
				for(Empleado empleado : empleados){
					EmpleadoDTO empleadoDTO = new EmpleadoDTO();
					empleadoDTO.setNumero(empleado.getNumero());
					empleadoDTO.setNombre(empleado.getNombre());
					empleadoDTO.setApellido(empleado.getApellido());
					empleadoDTO.setPuesto(empleado.getPuesto());
					empleadoDTO.setSucursal(empleado.getSucursal());
					
					empleadosDTO.add(empleadoDTO);
				}
			}
			return empleadosDTO;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
