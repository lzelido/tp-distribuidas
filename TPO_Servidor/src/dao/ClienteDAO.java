package dao;

import hbt.HibernateUtil;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.Cliente;
import entities.Empresa;
import entities.Particular;
import entities.Producto;
import entities.Ubicacion;

public class ClienteDAO {
	private static ClienteDAO instancia = null;
	private static SessionFactory sf = null;

	public static ClienteDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ClienteDAO();
		} 
		return instancia;
	}
	
	// ALTAS
	public void grabarCliente(Cliente cliente){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(cliente);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	// BUSCAR
	public Cliente buscarCliente (int codigo){
		Cliente cliente = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Cliente C " +
						 "WHERE C.codigo = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", codigo);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				cliente = (Cliente) query.uniqueResult();
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
		return cliente;
	}
	
	
	public Empresa buscarEmpresa (String tipoDoc, String nroDoc){
		Empresa empresa = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Empresa E " +
						 "WHERE E.tipoDoc = :tipoD AND E.nroDoc = :nroD";
			
			Query query = session.createQuery(hql);
			query.setParameter("tipoD", tipoDoc);
			query.setParameter("nroD", nroDoc);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
	        	empresa = (Empresa) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ClienteDAO: buscarEmpresa");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empresa;
	}
	
	public Empresa buscarEmpresa (int codigo){
		Empresa empresa = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Empresa E " +
						 "WHERE E.codigo = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", codigo);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
	        	empresa = (Empresa) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ClienteDAO: buscarEmpresa");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empresa;
	}
	
	public Particular buscarParticular (String tipoDoc, String nroDoc){
		Particular particular = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Particular P " +
						 "WHERE P.tipoDoc = :tipoD AND P.nroDoc = :nroD";
			
			Query query = session.createQuery(hql);
			query.setParameter("tipoD", tipoDoc);
			query.setParameter("nroD", nroDoc);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				particular = (Particular) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ClienteDAO: buscarParticular");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return particular;
	}
	
	public Particular buscarParticular (int codigo){
		Particular particular = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Particular P " +
						 "WHERE P.codigo = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", codigo);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				particular = (Particular) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ClienteDAO: buscaParticular");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return particular;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Particular> buscarParticulares (){
		Session session = sf.openSession();
		try {
			
			String hql = "FROM Particular P ";
			
			Query query = session.createQuery(hql);
			
			return (ArrayList<Particular>) query.list();
				
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ClienteDAO: buscarParticulares");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> buscarProductosByCliente (int idCliente){
		List<Producto> productos = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Producto P WHERE P.empresa.codigo = :nroCliente";
			
			Query query = session.createQuery(hql);
			query.setParameter("nroCliente", idCliente);
			productos = (List<Producto>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ClienteDAO: buscarProductosByCliente");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productos;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Ubicacion> buscarUbicacionesByCliente (int idCliente){
		ArrayList<Ubicacion> destinos = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Ubicacion U "
						+"WHERE U.empresa.codigo = :nroCliente";
/*			
			String hql = "SELECT U, G "
						+"FROM Ubicacion U JOIN U.gps G "
						+"WHERE U.empresa.codigo = :nroCliente";
*//*			
			String hql = "SELECT U "
						+"FROM Ubicacion U JOIN U.gps G "
						+"WHERE U.empresa.codigo = :nroCliente";
*/			
			Query query = session.createQuery(hql);
			query.setParameter("nroCliente", idCliente);
			destinos = (ArrayList<Ubicacion>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ClienteDAO: buscarUbicacionesByCliente");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return destinos;
	}

	@SuppressWarnings("unchecked")
	public List<Empresa> buscarEmpresas() {
		Session session = sf.openSession();
		try {
			String hql = "FROM Empresa E ";			
			Query query = session.createQuery(hql);
			
	        return (ArrayList<Empresa>) query.list();
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ClienteDAO: buscarEmpresas");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
		return null;
	}
}
