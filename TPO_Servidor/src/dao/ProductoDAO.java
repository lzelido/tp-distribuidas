package dao;

import java.util.List;
import javax.swing.JOptionPane;
import hbt.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;
import entities.Producto;

public class ProductoDAO {
	private static ProductoDAO instancia = null;
	private static SessionFactory sf = null;

	public static ProductoDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ProductoDAO();
		} 
		return instancia;
	}
	
	// ALTA
	public void grabarProducto(Producto producto){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(producto);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	// BUSCAR
	@SuppressWarnings("unchecked")
	public List<Producto> buscarProductos (){
		List<Producto> productos = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Producto";
			
			Query query = session.createQuery(hql);
			productos = (List<Producto>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ProductoDAO: buscarProductos");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productos;
	}
	
	public Producto buscarProducto (String descri){
		Producto producto = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Producto P " +
						 "WHERE P.descrip = :descri";
			
			Query query = session.createQuery(hql);
			query.setParameter("descrip", descri);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				producto = (Producto) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ProductoDAO: buscarProducto");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return producto;
	}
	
	public Producto buscarProducto (int idProducto){
		Producto producto = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Producto P " +
						 "WHERE P.codigo = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", idProducto);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				producto = (Producto) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ProductoDAO: buscarProducto");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return producto;
	}
	
	// BAJA
	public void eliminarProducto(Producto producto){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.delete(producto);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
}
