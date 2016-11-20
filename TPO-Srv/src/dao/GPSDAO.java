package dao;

import hbt.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;
import entities.GPS;

public class GPSDAO {
	private static GPSDAO instancia = null;
	private static SessionFactory sf = null;

	public static GPSDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new GPSDAO();
		} 
		return instancia;
	}
	
	// ALTA
	public void grabarGPS (GPS gps){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(gps);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	// BUSCAR
	@SuppressWarnings("unchecked")
	public List<GPS> buscarGPSs (){
		List<GPS> gpss = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM GPS";
			
			Query query = session.createQuery(hql);
			gpss = (List<GPS>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en GPSDAO: buscarGPSs");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gpss;
	}

	
	// BAJA
	public void eliminarGPS (GPS gps){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.delete(gps);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
}
