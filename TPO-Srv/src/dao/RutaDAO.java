package dao;

import hbt.HibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;
import entities.Ruta;

public class RutaDAO {
	private static RutaDAO instancia = null;
	private static SessionFactory sf = null;

	public static RutaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new RutaDAO();
		} 
		return instancia;
	}
	
	public void grabarRuta(Ruta ruta){
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(ruta);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	
	public Ruta buscarRuta (int id){
		Ruta ruta = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Ruta R " +
						 "WHERE R.id = :codigo";
			
			Query query = session.createQuery(hql);
			query.setParameter("codigo", id);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
	        	ruta = (Ruta) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en RutaDAO: buscarRuta");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ruta;
	}
	
	public Ruta buscarRutaVigenteBySucursales (int sucursalO, int sucursalD){
		Ruta ruta = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Ruta R " +
						 "WHERE R.sucOrigen.codigo = :origen AND "
						+"		R.sucOrigen.codigo = :destino AND "
						+"		R.esVigente = true";
			
			Query query = session.createQuery(hql);
			query.setParameter("origen", sucursalO);
			query.setParameter("destino", sucursalD);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
	        	ruta = (Ruta) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en RutaDAO: buscarRuta");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ruta;
	}
	
	public void ModificarRuta(Ruta ruta){
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(ruta);  
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	
	public void EliminarRuta(Ruta ruta){
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(ruta);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
}