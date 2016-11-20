package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessDelegate.BusinessDelegate;

public class ListaVehiculosReparacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListaVehiculosReparacion() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("vehiculos", BusinessDelegate.getInstance().buscarVehiculosParaMantenimiento());
		
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("/jsp/listaVehiculosReparacion.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}