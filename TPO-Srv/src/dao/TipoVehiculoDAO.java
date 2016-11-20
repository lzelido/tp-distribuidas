package dao;

import hbt.HibernateUtil;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.TipoVehiculo;

public class TipoVehiculoDAO {
	private static TipoVehiculoDAO instancia = null;
	private static SessionFactory sf = null;

	public static TipoVehiculoDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new TipoVehiculoDAO();
		} 
		return instancia;
	}
	
	public void grabarTipoVehiculo(TipoVehiculo tipoVehiculo){
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(tipoVehiculo);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public void modificarTipoVehiculo(TipoVehiculo tipoVehiculo){
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(tipoVehiculo);  
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public void bajaTipoVehiculo(int codigo){
		try {
			Session session = sf.openSession();
			
			String hql = "Delete from TipoVehiculo t " +
						 "WHERE t.codigo = :codigo";
			
			Query query = session.createQuery(hql);
			query.setParameter("codigo", codigo);
			query.setMaxResults(1);
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public TipoVehiculo buscarTipoVehiculo (int codigo){
		TipoVehiculo tipoVehiculo = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM TipoVehiculo t " +
						 "WHERE t.codigo = :codigo";
			
			Query query = session.createQuery(hql);
			query.setParameter("codigo", codigo);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				tipoVehiculo = (TipoVehiculo) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipoVehiculo;
	}
		
	@SuppressWarnings("unchecked")
	public List<TipoVehiculo> getTipoVehiculo(){
		List<TipoVehiculo> tipoVehiculo = null;
		try {
			Session session = sf.openSession();
	
			String hql = "FROM TipoVehiculo";
			
			Query query = session.createQuery(hql);
			tipoVehiculo = (List<TipoVehiculo>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipoVehiculo;
	}

}
