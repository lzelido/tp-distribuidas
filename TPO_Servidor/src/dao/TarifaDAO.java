package dao;

import java.util.List;

import hbt.HibernateUtil;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.Tarifa;

public class TarifaDAO {
	
	private static TarifaDAO instancia = null;
	private static SessionFactory sf = null;

	public static TarifaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new TarifaDAO();
		} 
		return instancia;
	}
	
	// ALTAS
	public void grabarTarifa(Tarifa tarifa){
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(tarifa);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	//MODIFICAR
	public void ModificarTarifa(Tarifa tarifa){
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(tarifa);  
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	//ELIMINAR
	public void BajaTarifa(Tarifa tarifa){
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(tarifa);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	// BUSCAR
	public Tarifa buscarTarifa (int codigo){
		Tarifa tarifa = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Tarifa T " +
						 "WHERE T.codigo = :tipoD";
			
			Query query = session.createQuery(hql);
			query.setParameter("tipoD", codigo);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				tarifa = (Tarifa) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en TarifaDAO: buscarTarifa");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tarifa;
	}
	
	public Tarifa buscarTarifaid (int idTipoSeguro, int idTipoMercaderia){
		Tarifa tarifa = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Tarifa T " +
						 "WHERE T.idTipoSeguro = :tipoA" +
						 "AND T.idTipoMercaderia = :tipoB";
			
			Query query = session.createQuery(hql);
			query.setParameter("tipoA", idTipoSeguro);
			query.setParameter("tipoB", idTipoMercaderia);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				tarifa = (Tarifa) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en TarifaDAO: buscarTarifa");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tarifa;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tarifa> getTarifas(){
		List<Tarifa> tarifa = null;
		try {
			Session session = sf.openSession();
	
			String hql = "SELECT *FROM Tarifa";
			
			Query query = session.createQuery(hql);
			//query.setParameter("nroCliente", idCliente);
			tarifa = (List<Tarifa>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en TarifaDAO: buscarTarifaByTarifas");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tarifa;
	}

}
