package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Botonera extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Botonera() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String funcionalidad = request.getParameter("funcionalidad");
		RequestDispatcher dispatcher = null;
		
		switch(funcionalidad){
			case "recepcionPedido":
				dispatcher = request.getRequestDispatcher("/RecepcionPedido");
				break;
			case "pagar":
				dispatcher = request.getRequestDispatcher("/PagarFactura");
				break;
			case "confeccionarEnvio":
				dispatcher = request.getRequestDispatcher("/confeccionarEnvio");
				break;
			case "viajesPendientes":
				dispatcher = request.getRequestDispatcher("/ViajesPendientes");
				break;
			case "entregarCarga":
				dispatcher = request.getRequestDispatcher("/MarcarEntregado");
				break;
			case "planDeMantenimiento":
				dispatcher = request.getRequestDispatcher("/ListaVehiculosReparacion");
				break;
			case "contratacionVehiculos":
				dispatcher = request.getRequestDispatcher("/contratacionVehiculos");
				break;
			case "enviosAlExterior":
				dispatcher = request.getRequestDispatcher("/enviosAlExterior");
				break;
		}

		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
