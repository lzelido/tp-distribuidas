package dao;

import hbt.HibernateUtil;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.Unidad;

public class UnidadDAO {
	private static UnidadDAO instancia = null;
	private static SessionFactory sf = null;

	public static UnidadDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new UnidadDAO();
		} 
		return instancia;
	}
	
	public void grabarUnidad(Unidad unidad){
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(unidad);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Unidad> buscarUnidades(){
		List<Unidad> unidades = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Unidad";
			
			Query query = session.createQuery(hql);
			unidades = (List<Unidad>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en UnidadDao: buscarUnidades");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return unidades;
	}
	
	@SuppressWarnings("unchecked")
	public List<Unidad> buscarUnidadesVolumen(){
		List<Unidad> unidades = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Unidad WHERE tipo = 'volumen'";
			
			Query query = session.createQuery(hql);
			unidades = (List<Unidad>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en UnidadDao: buscarUnidades");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return unidades;
	}
	
	@SuppressWarnings("unchecked")
	public List<Unidad> buscarUnidadesTara(){
		List<Unidad> unidades = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Unidad WHERE tipo = 'tara'";
			
			Query query = session.createQuery(hql);
			unidades = (List<Unidad>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en UnidadDao: buscarUnidades");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return unidades;
	}

	public Unidad buscarUnidad (int idUnidad){
		Unidad unidad = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Unidad U " +
						 "WHERE U.id = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", idUnidad);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				unidad = (Unidad) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en UnidadDAO: buscarUnidad");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return unidad;
	}

	public void eliminarUnidad (Unidad unidad){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.delete(unidad);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public void modificarUnidad (Unidad unidad){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.update(unidad);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
}
