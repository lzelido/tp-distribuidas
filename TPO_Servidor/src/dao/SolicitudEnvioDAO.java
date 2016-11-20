package dao;

import javax.swing.JOptionPane;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.Empresa;
import entities.SolicitudEnvio;

public class SolicitudEnvioDAO {
	private static SolicitudEnvioDAO instancia = null;
	private static SessionFactory sf = null;
	
	public static SolicitudEnvioDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new SolicitudEnvioDAO();
		}
		return instancia;
	}
	
	// ALTAS
	public void grabarSolicitud (SolicitudEnvio solicitud){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(solicitud);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	// BUSCAR
	public SolicitudEnvio buscarSolicitud (int codigo){
		SolicitudEnvio solicitud = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM SolicitudEnvio SE " +
						 "WHERE SE.codigo = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", codigo);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
	        	solicitud = (SolicitudEnvio) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en SolicitudEnvioDAO: buscarSolcitud");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return solicitud;
	}
}
