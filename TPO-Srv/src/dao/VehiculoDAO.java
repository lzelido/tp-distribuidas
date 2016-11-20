package dao;

import hbt.HibernateUtil;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.Vehiculo;
import entities.VehiculoExterno;
import entities.VehiculoPropio;

public class VehiculoDAO {
	private static VehiculoDAO instancia = null;
	private static SessionFactory sf = null;

	public static VehiculoDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new VehiculoDAO();
		} 
		return instancia;
	}
	
	public void grabarVehiculo (Vehiculo vehiculo){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(vehiculo);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<VehiculoExterno> buscarVehiculosExternos (){
		List<VehiculoExterno> vehiculosExternos = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM VehiculoExterno";
			
			Query query = session.createQuery(hql);
			vehiculosExternos = (List<VehiculoExterno>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en VehiculoDAO: buscarVehiculosExternos");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehiculosExternos;
	}
	
	@SuppressWarnings("unchecked")
	public List<VehiculoPropio> buscarVehiculosPropios (){
		List<VehiculoPropio> vehiculosPropios = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM VehiculoPropio";
			
			Query query = session.createQuery(hql);
			vehiculosPropios = (List<VehiculoPropio>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en VehiculoDAO: buscarVehiculosPropios");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehiculosPropios;
	}
	
	public VehiculoPropio buscarVehiculoPropio (String matricula){
		VehiculoPropio vehiculoPropio = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM VehiculoPropio V " +
						 "WHERE V.matricula = :matricula";
			
			Query query = session.createQuery(hql);
			query.setParameter("matricula", matricula);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				vehiculoPropio = (VehiculoPropio) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en VehiculoDAO: buscarVehiculoPropio");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehiculoPropio;
	}
	
	public VehiculoExterno buscarVehiculoExterno (String matricula){
		VehiculoExterno vehiculo = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM VehiculoExterno V " +
						 "WHERE V.matricula = :matricula";
			
			Query query = session.createQuery(hql);
			query.setParameter("matricula", matricula);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				vehiculo = (VehiculoExterno) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en VehiculoDAO: buscarVehiculoExterno");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehiculo;
	}
	
	public void eliminarVehiculo (Vehiculo vehiculo){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.delete(vehiculo);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public void modificarVehiculo (Vehiculo vehiculo){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(vehiculo);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public void mandarAlTallerVehiculoPropio(VehiculoPropio v) {
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(v);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
}
