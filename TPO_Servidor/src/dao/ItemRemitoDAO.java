package dao;

import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import entities.ItemRemito;

public class ItemRemitoDAO {
	private static ItemRemitoDAO instancia = null;
	private static SessionFactory sf = null;

	public static ItemRemitoDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ItemRemitoDAO();
		} 
		return instancia;
	}
	
	// ALTAS
	public void grabarItemRemito (ItemRemito item){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(item);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
}
