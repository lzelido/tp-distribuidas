package dao;

import hbt.HibernateUtil;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.CategoriaTratamiento;

public class CategoriaTratamientoDAO {
	private static CategoriaTratamientoDAO instancia = null;
	private static SessionFactory sf = null;
	
	public static CategoriaTratamientoDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new CategoriaTratamientoDAO();
		}
		return instancia;
	}
	
	// ALTAS
	public void grabarTratamiento (CategoriaTratamiento tratamiento){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(tratamiento);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	// BAJA
	public void eliminarTratamiento (CategoriaTratamiento tratamiento){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.delete(tratamiento);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	// BUSCAR
	public CategoriaTratamiento buscarTratamiento (int codigo){
		CategoriaTratamiento tratamiento = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM CategoriaTratamiento CT " +
						 "WHERE CT.codigo = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", codigo);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				tratamiento = (CategoriaTratamiento) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en CategoriaTratamientoDAO: buscarTratamiento");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tratamiento;
	}

	public List<CategoriaTratamiento> buscarTratamientos() {
		List<CategoriaTratamiento> tratamientos = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM CategoriaTratamiento";
			
			Query query = session.createQuery(hql);
			tratamientos = (List<CategoriaTratamiento>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en CategoriaTratamiento: buscarTratamientos");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tratamientos;
	}
}
