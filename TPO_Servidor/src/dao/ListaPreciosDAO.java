package dao;

import java.util.List;

import javax.swing.JOptionPane;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.Empleado;
import entities.ListaPrecios;

public class ListaPreciosDAO {
	private static ListaPreciosDAO instancia = null;
	private static SessionFactory sf = null;

	public static ListaPreciosDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ListaPreciosDAO();
		} 
		return instancia;
	}
	

	public void grabarListaPrecios(ListaPrecios listaPrecios) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(listaPrecios);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
	}

	public ListaPrecios buscarListaPrecios (int numero){
		ListaPrecios listaPrecios = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM ListaPrecios L " +
						 "WHERE L.codigo = :tipoD";
			
			Query query = session.createQuery(hql);
			query.setParameter("tipoD", numero);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
	        	listaPrecios = (ListaPrecios) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ListaPrecioDAO: buscarListaPrecio");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaPrecios;
	}
	
	public List<ListaPrecios> buscarListaPreciosPorDescripcion(String descripcion){
		List<ListaPrecios> listaPrecios = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM ListaPrecios L " +
						 "WHERE L.listaprecios = :tipoD";
			
			Query query = session.createQuery(hql);
			query.setParameter("tipoD", descripcion);
			

        	listaPrecios = query.list();
        	session.close();

		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ListaPrecioDAO: buscarListaPreciosPorDescripcion");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaPrecios;
	}

	public float calculoM3Item(ListaPrecios listaPrecios){
		float x = conversionUnidad(listaPrecios.getCoordenadaX(),listaPrecios.getUnidadX());
		float y = conversionUnidad(listaPrecios.getCoordenadaY(),listaPrecios.getUnidadY());
		float z = conversionUnidad(listaPrecios.getCoordenadaZ(),listaPrecios.getUnidadZ());
		return (x*y*z);
	}
	 
	public float conversionUnidad(Float numero, String unidad){
		if(unidad == "km"){
			return (numero*1000);
		}
		if(unidad == "hm"){
			return (numero*100);
		}
		if(unidad == "dam"){
			return (numero*10);
		}
		if(unidad == "dm"){
			return (numero/10);
		}
		if(unidad == "cm"){
			return (numero/100);
		}
		if(unidad == "mm"){
			return (numero/1000);
		}
		return numero;
	}

}
