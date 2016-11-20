package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessDelegate.BusinessDelegate;

public class PagarFactura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PagarFactura() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("clientes", BusinessDelegate.getInstance().buscarClientes());
		
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("/jsp/pagarFactura.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
