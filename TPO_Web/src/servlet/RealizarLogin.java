package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessDelegate.BusinessDelegate;

import dto.UsuarioDTO;

public class RealizarLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RealizarLogin() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<?> paramNames = request.getParameterNames();
		if (paramNames != null) {
			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");
			RequestDispatcher dispatcher = null;
			UsuarioDTO usuarioLogeado = null;

			UsuarioDTO usuarioIntroducido = new UsuarioDTO();
			usuarioIntroducido.setUsuario(usuario);
			usuarioIntroducido.setPassword(password);
			usuarioLogeado = BusinessDelegate.getInstance().login(usuarioIntroducido);
			if (usuarioLogeado != null) {
				dispatcher = request.getRequestDispatcher("/jsp/pantallaPrincipal.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("resultado", "datos incorrectos.");
				dispatcher = request.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			request.setAttribute("resultado", "error");
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
