package dao;

import java.util.List;
import javax.swing.JOptionPane;
import hbt.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;
import entities.Viaje;

public class ViajeDAO {
	private static ViajeDAO instancia = null;
	private static SessionFactory sf = null;

	public static ViajeDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ViajeDAO();
		} 
		return instancia;
	}
	
	// ALTAS
	public void grabarViaje(Viaje viaje){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(viaje);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	// BUSCAR
	public Viaje buscarViaje (int codigo){
		Viaje viaje = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Viaje V " +
						 "WHERE V.codigo = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", codigo);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				viaje = (Viaje) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ViajeDAO: buscarViaje");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viaje;
	}
	
	public Viaje buscarViajeByCarga (int idCarga){
		Viaje viaje = null;
		try {
			Session session = sf.openSession();
			
			String hql = "SELECT V FROM Viaje V " +
						 " JOIN V.cargas G "+
						 "WHERE G.codigo = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", idCarga);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				viaje = (Viaje) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ViajeDAO: buscarViaje");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viaje;
	}
	
	public Viaje buscarViajeVigente (int sucOrigen, int sucDestino){
		Viaje viaje = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Viaje V " +
						 "WHERE V.sucSalida.codigo = :idSucOrigen AND "
						+"		V.sucDestino.codigo = :idSucDestino AND "
						+"		V.estaEntregado = false";
			
			Query query = session.createQuery(hql);
			query.setParameter("idSucOrigen", sucOrigen);
			query.setParameter("idSucDestino", sucDestino);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				viaje = (Viaje) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ViajeDAO: buscarViajeVigente");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viaje;
	}
	
	@SuppressWarnings("unchecked")
	public List<Viaje> buscarViajesNoEntregadosBySucursal (int idSucursal){
		List<Viaje> viajes = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Viaje V WHERE V.sucDestino.codigo = :nroSucursal and V.estaEntregado is false";
			
			Query query = session.createQuery(hql);
			query.setParameter("nroSucursal", idSucursal);
			viajes = (List<Viaje>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ViajeDAO: buscarViajesNoEntregadosBySucursal");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viajes;
	}
	
}
