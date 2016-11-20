package dao;

import hbt.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;
import entities.GPS;
import entities.Ubicacion;

public class UbicacionDAO {
	private static UbicacionDAO instancia = null;
	private static SessionFactory sf = null;

	public static UbicacionDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new UbicacionDAO();
		} 
		return instancia;
	}
	
	// ALTA
	public void grabarUbicacion (Ubicacion ubicacion){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(ubicacion);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	// BUSCAR
	@SuppressWarnings("unchecked")
	public List<Ubicacion> buscarUbicaciones (){
		List<Ubicacion> ubicaciones = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Ubicacion";
			
			Query query = session.createQuery(hql);
			ubicaciones = (List<Ubicacion>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en UbicacionDAO: buscarUbicaciones");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ubicaciones;
	}

	public Ubicacion buscarUbicacion (int codigo){
		Ubicacion ubicacion = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Ubicacion U "+
						 "WHERE U.codigo = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", codigo);
			query.setMaxResults(1);
			
			if (query.uniqueResult() != null){
				ubicacion = (Ubicacion) query.uniqueResult();
				session.close();
			}else{
				session.close();
			}
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en UbicacionDAO: buscaUbicacion");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ubicacion;
	}
	
	public GPS buscarGPS (int idUbicacion){
		GPS gps = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM GPS G " +
						 "WHERE G.ubicacion.codigo = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", idUbicacion);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				gps = (GPS) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en UbicacionDAO: buscaGPS");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gps;
	}
	
	// BAJA
	public void eliminarUbicacion (Ubicacion ubicacion){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.delete(ubicacion);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
}
