package dao;

import java.util.List;

import hbt.HibernateUtil;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.Empleado;

public class EmpleadoDAO {
	private static EmpleadoDAO instancia = null;
	private static SessionFactory sf = null;

	public static EmpleadoDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new EmpleadoDAO();
		} 
		return instancia;
	}
	
	public void grabarEmpleado(Empleado empleado){
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(empleado);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	
	public Empleado buscarEmpleado (int numero){
		Empleado empleado = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Empleado E " +
						 "WHERE E.numero = :tipoD";
			
			Query query = session.createQuery(hql);
			query.setParameter("tipoD", numero);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
	        	empleado = (Empleado) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en EmpleadoDAO: buscarEmpleado");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empleado;
	}
	
	@SuppressWarnings("unchecked")
	public List<Empleado> buscarEmpleados() {
		List<Empleado> empleados = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Empleado E";
			
			Query query = session.createQuery(hql);
			empleados = (List<Empleado>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en EmpleadoDAO: buscarEmpleadosBySucursal");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empleados;
	}
	
	public void ModificarEmpleado(Empleado empleado){
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(empleado);  
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	
	public void EliminarEmpleado(Empleado empleado){
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(empleado);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
}
