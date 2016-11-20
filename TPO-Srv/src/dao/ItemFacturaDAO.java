package dao;

import hbt.HibernateUtil;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.ItemFactura;

public class ItemFacturaDAO {
	private static ItemFacturaDAO instancia = null;
	private static SessionFactory sf = null;

	public static ItemFacturaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ItemFacturaDAO();
		} 
		return instancia;
	}
	
	// ALTAS
	public void grabarItemFactura(ItemFactura item){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(item);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<ItemFactura> obtenerItems(int codigo) {
		List<ItemFactura> productos = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM ItemFactura P WHERE P.factura.codigo = :codigo";
			
			Query query = session.createQuery(hql);
			query.setParameter("codigo", codigo);
			productos = (List<ItemFactura>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ItemFacturaDAO: obtenerItems");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productos;		
	}
}
