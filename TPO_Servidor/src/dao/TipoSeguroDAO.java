package dao;

import java.util.List;

import hbt.HibernateUtil;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.TipoSeguro;

public class TipoSeguroDAO {
	private static TipoSeguroDAO instancia = null;
	private static SessionFactory sf = null;

	public static TipoSeguroDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new TipoSeguroDAO();
		} 
		return instancia;
	}
	
	// ALTAS
	public void grabarTipoSeguro(TipoSeguro tipoSeguro){
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(tipoSeguro);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	//MODIFICAR
	public void ModificarTipoSeguro(TipoSeguro tipoSeguro){
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(tipoSeguro);  
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	//ELIMINAR
	public void BajaTipoSeguro(TipoSeguro tipoSeguro){
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(tipoSeguro);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	
	// BUSCAR
	public TipoSeguro buscarTipoSeguro (int codigo){
		TipoSeguro tipoSeguro = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM TipoSeguro TS " +
						 "WHERE TS.codigo = :tipoD";
			
			Query query = session.createQuery(hql);
			query.setParameter("tipoD", codigo);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				tipoSeguro = (TipoSeguro) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en TipoSeguroDAO: buscarTipoSeguro");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipoSeguro;
	}
		
	@SuppressWarnings("unchecked")
	public List<TipoSeguro> getTipoSeguros(){
		List<TipoSeguro> tipoSeguros = null;
		try {
			Session session = sf.openSession();
	
			String hql = "SELECT * FROM TipoSeguro";
			
			Query query = session.createQuery(hql);
			//query.setParameter("nroCliente", idCliente);
			tipoSeguros = (List<TipoSeguro>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en TipoSeguroDAO: buscarUbicacionesByCliente");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipoSeguros;
	}

}
