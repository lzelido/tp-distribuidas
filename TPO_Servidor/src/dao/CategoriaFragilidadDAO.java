package dao;

import hbt.HibernateUtil;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.CategoriaFragilidad;

public class CategoriaFragilidadDAO {
	private static CategoriaFragilidadDAO instancia = null;
	private static SessionFactory sf = null;
	
	public static CategoriaFragilidadDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new CategoriaFragilidadDAO();
		}
		return instancia;
	}
	
	// ALTAS
	public void grabarFragilidad (CategoriaFragilidad fragilidad){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(fragilidad);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	// BAJA
	public void eliminarFragilidad (CategoriaFragilidad fragilidad){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.delete(fragilidad);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	// BUSCAR
	public CategoriaFragilidad buscarFragilidad (int codigo){
		CategoriaFragilidad fragilidad = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM CategoriaFragilidad CF " +
						 "WHERE CF.codigo = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", codigo);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				fragilidad = (CategoriaFragilidad) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en CategoriaFragiliadaDAO: buscarFragilidad");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fragilidad;
	}
	
	@SuppressWarnings("unchecked")
	public List<CategoriaFragilidad> buscarCategoriasFragilidad(){
		List<CategoriaFragilidad> tipoCarga = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM CategoriaFragilidad";
			
			Query query = session.createQuery(hql);
			tipoCarga = (List<CategoriaFragilidad>) query.list();
			
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
