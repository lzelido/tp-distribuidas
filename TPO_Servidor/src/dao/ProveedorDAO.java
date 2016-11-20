package dao;

import hbt.HibernateUtil;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.Carrier;
import entities.Proveedor;
import entities.ProveedorLocal;

public class ProveedorDAO {
	private static ProveedorDAO instancia = null;
	private static SessionFactory sf = null;

	public static ProveedorDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ProveedorDAO();
		} 
		return instancia;
	}
	
	public void darDeAltaProveedorLocal (ProveedorLocal proveedor){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(proveedor);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public void darDeAltaCarrier (Carrier proveedor){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(proveedor);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<ProveedorLocal> buscarProveedoresLocal (){
		List<ProveedorLocal> vehiculosExternos = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM ProveedorLocal";
			
			Query query = session.createQuery(hql);
			vehiculosExternos = (List<ProveedorLocal>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehiculosExternos;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> obtenerProveedores (){
		List<Object> proveedores = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Proveedor";
			
			Query query = session.createQuery(hql);
			proveedores = (List<Object>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return proveedores;
	}
	
	public ProveedorLocal buscarProveedorLocal (int codigo){
		ProveedorLocal proveedorLocal = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM ProveedorLocal V " +
						 "WHERE V.codigo = :codigo";
			
			Query query = session.createQuery(hql);
			query.setParameter("codigo", codigo);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				proveedorLocal = (ProveedorLocal) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return proveedorLocal;
	}
	
	public Carrier buscarCarrier (int codigo){
		Carrier carrier = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Carrier V " +
						 "WHERE V.codigo = :codigo";
			
			Query query = session.createQuery(hql);
			query.setParameter("codigo", codigo);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				carrier = (Carrier) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ProveedorDAO: buscarCarrier");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carrier;
	}
	
	public void bajaCarrier (Proveedor proveedor){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.delete(proveedor);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
}
