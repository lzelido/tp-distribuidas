package dao;

import javax.swing.JOptionPane;
import hbt.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;
import entities.Dimension;

public class DimensionDAO {
	private static DimensionDAO instancia = null;
	private static SessionFactory sf = null;

	public static DimensionDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new DimensionDAO();
		} 
		return instancia;
	}
	
	// ALTAS
		public void grabarDimension (Dimension dimension){
			Session session = sf.openSession();
			session.getTransaction().begin();
			session.saveOrUpdate(dimension);
			session.flush();
			session.getTransaction().commit();
			session.close();
		}
	
	// BUSCAR
	public Dimension buscarDimension (int codigo){
		Dimension dimension = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Dimension D" +
						 "WHERE D.codigo = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", codigo);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				dimension = (Dimension) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en DimensionDAO: buscarDimension");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dimension;
	}
}
