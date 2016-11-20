package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessDelegate.BusinessDelegate;


public class RecepcionPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RecepcionPedido() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("clientes", BusinessDelegate.getInstance().buscarClientes());
		request.setAttribute("tipoUnidades", BusinessDelegate.getInstance().buscarUnidades());
		request.setAttribute("tiposCargas", BusinessDelegate.getInstance().obtenerTiposCargas());
		request.setAttribute("categoriasFragilidad", BusinessDelegate.getInstance().obtenerCategoriasFragilidad());
		request.setAttribute("categoriasTratamiento", BusinessDelegate.getInstance().obtenerCategoriasTratamiento());

		
		if("1".equals(request.getParameter("resultado"))){
			request.setAttribute("resultado", "1");
		}
		
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("/jsp/solicitud.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
