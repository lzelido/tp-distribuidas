package controlador;

import java.rmi.RemoteException;
import java.util.Vector;
import businessDelegate.BusinessDelegate;
import dto.EmpleadoDTO;

public class EmpleadoController {
	private static EmpleadoController instance = null;

	public static EmpleadoController getInstance() {
		if (instance == null) {
			instance = new EmpleadoController();
		}
		return instance;
	}
	
	// ALTAS
	public int  darDeAltaEmpleado(EmpleadoDTO empleado) {
		return BusinessDelegate.getInstance().darDeAltaEmpleado(empleado);
	
	}
	
	// BUSCAR
	public EmpleadoDTO buscarEmpleado (int numero)throws RemoteException{
		return BusinessDelegate.getInstance().buscarEmpleado(numero);
	}
	
	public Vector<EmpleadoDTO> buscarEmpleados (){
		return BusinessDelegate.getInstance().buscarEmpleados ();
	}
		
	// BAJAS
	public int eliminarEmpleado (EmpleadoDTO empleado) throws RemoteException{
		return BusinessDelegate.getInstance().darDeBajaEmpleado(empleado);
	}
		
	// MODIFICACIONES
	public int modificarEmpleado (EmpleadoDTO empleado) throws RemoteException{
		return BusinessDelegate.getInstance().ModificarEmpleado(empleado);
	}	
}