package dao;

import java.util.List;

import hbt.HibernateUtil;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.TipoMercaderia;


public class TipoMercaderiaDAO {
	
	private static TipoMercaderiaDAO instancia = null;
	private static SessionFactory sf = null;

	public static TipoMercaderiaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new TipoMercaderiaDAO();
		} 
		return instancia;
	}
	
	// ALTAS
	public void grabarTipoMercaderia(TipoMercaderia tipoMercaderia){
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(tipoMercaderia);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	
	//MODIFICAR
		public void ModificarTipoMercaderia(TipoMercaderia tipoMercaderia){
			Session session = sf.openSession();
			session.beginTransaction();
			session.saveOrUpdate(tipoMercaderia);  
			session.flush();
			session.getTransaction().commit();
			session.close();
		}
		
		//ELIMINAR
		public void BajaTipoMercaderia(TipoMercaderia tipoMercaderia){
			Session session = sf.openSession();
			session.beginTransaction();
			session.delete(tipoMercaderia);
			session.flush();
			session.getTransaction().commit();
			session.close();
		}
		
		
		// BUSCAR
		public TipoMercaderia buscarTipoMercaderia (int codigo){
			TipoMercaderia tipoMercaderia = null;
			try {
				Session session = sf.openSession();
				
				String hql = "FROM TipoMercaderia TS " +
							 "WHERE TS.codigo = :tipoD";
				
				Query query = session.createQuery(hql);
				query.setParameter("tipoD", codigo);
				query.setMaxResults(1);
				
				if(query.uniqueResult() != null){
					tipoMercaderia = (TipoMercaderia) query.uniqueResult();
		        	session.close();
		        }else{
		        	session.close();
		        }
			}catch (QuerySyntaxException q){
				JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
				System.out.println("Exception de sintaxis en TipoMercaderiaDAO: buscarTipoMercaderia");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return tipoMercaderia;
		}
			
		@SuppressWarnings("unchecked")
		public List<TipoMercaderia> getTipoMercaderias(){
			List<TipoMercaderia> tipoMercaderia = null;
			try {
				Session session = sf.openSession();
		
				String hql = "FROM TipoMercaderia";
				
				Query query = session.createQuery(hql);
				tipoMercaderia = (List<TipoMercaderia>) query.list();
				
				session.close();
				
			}catch (QuerySyntaxException q){
				JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
				System.out.println("Exception de sintaxis en TipoMercaderiaDAO: buscarUbicacionesByCliente");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return tipoMercaderia;
		}

}
