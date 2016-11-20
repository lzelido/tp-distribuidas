package dao;

import java.util.List;

import javax.swing.JOptionPane;
import hbt.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;
import entities.TipoCarga;

public class TipoCargaDAO {
	private static TipoCargaDAO instancia = null;
	private static SessionFactory sf = null;
	
	public static TipoCargaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new TipoCargaDAO();
		}
		return instancia;
	}
	
	// ALTAS
	public void grabarTipoCarga (TipoCarga tipoCarga){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(tipoCarga);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	// BAJA
	public void eliminarTipoCarga (TipoCarga tipoCarga){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.delete(tipoCarga);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	// BUSCAR
	public TipoCarga buscarTipoCarga (int codigo){
		TipoCarga tipoC = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM TipoCarga TC " +
						 "WHERE TC.codigo = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", codigo);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				tipoC = (TipoCarga) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en TipoCargaDAO: buscarTipoCarga");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipoC;
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoCarga> buscarTiposCargas(){
		List<TipoCarga> tipoCarga = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM TipoCarga";
			
			Query query = session.createQuery(hql);
			tipoCarga = (List<TipoCarga>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en TipoDeCargaDAO: buscarUnidades");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipoCarga;
	}
}
