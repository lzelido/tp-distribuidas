package srv;

import java.util.List;
import dao.EmpleadoDAO;
import entities.Empleado;

public class EmpleadoSRV {
	private static EmpleadoDAO dao;
	static {
		dao = EmpleadoDAO.getInstancia();
	}
	
	public void grabarEmpleado(Empleado empleado){
		dao.grabarEmpleado(empleado);
		
	}
	
	public Empleado buscarEmpleado(int numero){
		return  dao.buscarEmpleado(numero);
		
	}
	
	public void ModificarEmpleado(Empleado empleado){
		dao.ModificarEmpleado(empleado);
		
	}

	public void EliminarEmpleado(Empleado empleado){
		dao.EliminarEmpleado(empleado);
		
	}
	
	public List<Empleado> buscarEmpleados(){
		return dao.buscarEmpleados();
	}
}