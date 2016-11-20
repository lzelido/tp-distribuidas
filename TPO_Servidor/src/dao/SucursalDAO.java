package dao;

import java.util.List;

import hbt.HibernateUtil;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.Sucursal;
import entities.VehiculoPropio;

public class SucursalDAO {
	private static SucursalDAO instancia = null;
	private static SessionFactory sf = null;

	public static SucursalDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new SucursalDAO();
		} 
		return instancia;
	}
	
	public void grabarSucursal(Sucursal sucursal){
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(sucursal);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	
	public Sucursal buscarSucursal (int codigo){
		Sucursal sucursal = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Sucursal S " +
						 "WHERE S.codigo = :tipoD";
			
			Query query = session.createQuery(hql);
			query.setParameter("tipoD", codigo);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
	        	sucursal = (Sucursal) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en SucursalDAO: buscarSucursal");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sucursal;
	}
	
	public void ModificarSucursal(Sucursal sucursal){
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(sucursal);  
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	
	public void EliminarSucursal(Sucursal sucursal){
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(sucursal);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Sucursal> buscarSucursales() {
		List<Sucursal> sucursales = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Sucursal";
			
			Query query = session.createQuery(hql);
			sucursales = (List<Sucursal>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en SucursalDAO: buscarSucursales");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sucursales;
	}
}
