package dao;

import javax.swing.JOptionPane;
import hbt.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;
import entities.Carga;

public class CargaDAO {
	private static CargaDAO instancia = null;
	private static SessionFactory sf = null;
	
	public static CargaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new CargaDAO();
		}
		return instancia;
	}
	
	// ALTAS
	public void grabarCarga (Carga carga){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(carga);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public Carga buscarCarga (int codigo){
		Carga carga = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Carga C " +
						 "WHERE C.codigo = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", codigo);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				carga = (Carga) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ClienteDAO: buscarCliente");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carga;
	}
}
