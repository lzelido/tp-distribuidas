package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessDelegate.BusinessDelegate;

public class BuscarFacturas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuscarFacturas() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("clientes", BusinessDelegate.getInstance().buscarClientes());
		request.setAttribute("facturas", BusinessDelegate.getInstance().buscarFacturas(Integer.parseInt(request.getParameter("cliente"))));
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("/jsp/pagarFactura.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
