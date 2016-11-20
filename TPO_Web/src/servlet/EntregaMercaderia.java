package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessDelegate.BusinessDelegate;

import dto.FacturaDTO;
import dto.SucursalDTO;

/**
 * Servlet implementation class EntregaMercaderia
 */
public class EntregaMercaderia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntregaMercaderia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		SucursalDTO s = new SucursalDTO();
		s.setCodigo(2);
		
		FacturaDTO f = new FacturaDTO();
		f.setCodigo(Integer.valueOf(request.getParameter("codigo")));
		BusinessDelegate.getInstance().entregarCarga(f,s);
		request.setAttribute("entregado", true);
		dispatcher = request.getRequestDispatcher("/jsp/marcarEntregado.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
