package dao;

import hbt.HibernateUtil;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import dto.UsuarioDTO;
import entities.Usuario;

public class UsuarioDAO {
	private static UsuarioDAO instancia = null;
	private static SessionFactory sf = null;

	public static UsuarioDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new UsuarioDAO();
		} 
		return instancia;
	}
	

	public Usuario login (UsuarioDTO usuarioDTO){
		Usuario usuario = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM Usuario U " +
						 "WHERE U.usuario = :usuario AND U.password = :password";
			
			Query query = session.createQuery(hql);
			query.setParameter("usuario", usuarioDTO.getUsuario());			
			query.setParameter("password", usuarioDTO.getPassword());
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				usuario = (Usuario) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
}
