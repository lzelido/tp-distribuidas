package dao;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.CompaniaSeguro;
import hbt.HibernateUtil;

public class CompaniaSeguroDAO {

	private static CompaniaSeguroDAO instancia = null;
	private static SessionFactory sf = null;

	public static CompaniaSeguroDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new CompaniaSeguroDAO();
		}
		return instancia;
	}

	// ALTAS
	public void save(CompaniaSeguro companiaSeguro) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(companiaSeguro);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	// MODIFICAR
	public void ModificarCompaniaSeguro(CompaniaSeguro companiaSeguro) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(companiaSeguro);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	// ELIMINAR
	public void BajaCompaniaSeguro(CompaniaSeguro companiaSeguro) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(companiaSeguro);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	// BUSCAR
	public CompaniaSeguro buscarCompaniaSeguro(int codigo) {
		CompaniaSeguro companiaSeguro = null;
		try {
			Session session = sf.openSession();

			String hql = "FROM CompaniaSeguro T " + "WHERE T.codigo = :tipoD";

			Query query = session.createQuery(hql);
			query.setParameter("tipoD", codigo);
			query.setMaxResults(1);

			if (query.uniqueResult() != null) {
				companiaSeguro = (CompaniaSeguro) query.uniqueResult();
				session.close();
			} else {
				session.close();
			}
		} catch (QuerySyntaxException q) {
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en CompaniaSeguroDAO: buscarCompaniaSeguro");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companiaSeguro;
	}

	@SuppressWarnings("unchecked")
	public List<CompaniaSeguro> getCompaniaSeguros() {
		List<CompaniaSeguro> companiaSeguro = null;
		try {
			Session session = sf.openSession();

			String hql = "SELECT *FROM CompaniaSeguro";

			Query query = session.createQuery(hql);
			// query.setParameter("nroCliente", idCliente);
			companiaSeguro = (List<CompaniaSeguro>) query.list();

			session.close();

		} catch (QuerySyntaxException q) {
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en CompaniaSeguroDAO: buscarCompaniaSeguroByCompaniaSeguros");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companiaSeguro;
	}

	public void remove(CompaniaSeguro companiaSeguro) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(companiaSeguro);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
}
