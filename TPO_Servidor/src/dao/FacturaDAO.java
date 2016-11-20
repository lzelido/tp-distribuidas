package dao;

import hbt.HibernateUtil;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.Factura;

public class FacturaDAO {
	private static FacturaDAO instancia = null;
	private static SessionFactory sf = null;

	public static FacturaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new FacturaDAO();
		} 
		return instancia;
	}
	
	// ALTAS
	public void grabarFactura(Factura factura){
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(factura);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	// BUSCAR
	public Factura buscarFactura (int codigo){
		Factura factura = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Factura F " +
						 "WHERE F.codigo = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", codigo);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				factura = (Factura) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en FacturaDAO: buscarFactura");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return factura;
	}

	public List<Factura> buscarFacturas(int codigoCliente) {
		List<Factura> facturas = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Factura F " +
						 "WHERE F.cliente = :codigoCliente and (F.pago=false or F.pago is null)";
			
			Query query = session.createQuery(hql);
			query.setInteger("codigoCliente", codigoCliente);
			

        	facturas = query.list();
        	session.close();

		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en FacturaDAO: buscarFacturas");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return facturas;
	}
}
