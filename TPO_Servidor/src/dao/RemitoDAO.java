package dao;

import javax.swing.JOptionPane;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.Cliente;
import entities.Remito;

public class RemitoDAO {
	private static RemitoDAO instancia = null;
	private static SessionFactory sf = null;

	public static RemitoDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new RemitoDAO();
		} 
		return instancia;
	}
	
	// ALTAS
	public void grabarRemito (Remito remito){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(remito);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	// BUSCAR
	public Remito buscarRemito (int codigo){
		Remito remito = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Remito R " +
						 "WHERE R.codigo = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", codigo);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				remito = (Remito) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en RemitoDAO: buscarRemito");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return remito;
	}
}
