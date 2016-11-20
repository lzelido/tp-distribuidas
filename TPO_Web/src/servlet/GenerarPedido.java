package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessDelegate.BusinessDelegate;
import dto.CargaDTO;
import dto.CategoriaFragilidadDTO;
import dto.CategoriaTratamientoDTO;
import dto.ClienteDTO;
import dto.DimensionDTO;
import dto.GPSDTO;
import dto.SolicitudEnvioDTO;
import dto.SucursalDTO;
import dto.TipoCargaDTO;
import dto.UbicacionDTO;
import dto.UnidadDTO;
import enums.Fragilidad;

public class GenerarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GenerarPedido() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SolicitudEnvioDTO solicitud = new SolicitudEnvioDTO();
		
		String cliente = request.getParameter("cliente");
		
		ClienteDTO clienteDTO;
		
		clienteDTO = BusinessDelegate.getInstance().buscarClienteEmpresa(Integer.parseInt(cliente));
		if (clienteDTO == null){
			clienteDTO = BusinessDelegate.getInstance().buscarClienteParticular(Integer.parseInt(cliente));			
		}
		
		
		
		
		if(request.getParameter("domicilioEntrega") != null && request.getParameter("domicilioEntrega") != "" ){
			Map<String, String> domicilioEntregaDatos = parseQuery(request.getParameter("domicilioEntrega"));
			
			UbicacionDTO domicilioEntrega = new UbicacionDTO();
			domicilioEntrega.setCalle(domicilioEntregaDatos.get("calle"));
			domicilioEntrega.setNumero(domicilioEntregaDatos.get("numero") == null ? 0 : Integer.parseInt(domicilioEntregaDatos.get("numero")));
			domicilioEntrega.setPiso(domicilioEntregaDatos.get("piso") == null ? 0 : Integer.parseInt(domicilioEntregaDatos.get("piso")));
			domicilioEntrega.setDepto(domicilioEntregaDatos.get("departamento"));
			domicilioEntrega.setCodPost(domicilioEntregaDatos.get("codPostal"));
			domicilioEntrega.setLocalidad(domicilioEntregaDatos.get("localidad"));
			domicilioEntrega.setProvincia(domicilioEntregaDatos.get("provincia"));
			
			GPSDTO GPSdomicilioEntrega = new GPSDTO();
			GPSdomicilioEntrega.setLatitud(domicilioEntregaDatos.get("latitud"));
			GPSdomicilioEntrega.setGradosLat(domicilioEntregaDatos.get("gradosLat")== null ? 0 : Integer.parseInt(domicilioEntregaDatos.get("gradosLat")));
			GPSdomicilioEntrega.setMinutosLat(domicilioEntregaDatos.get("minutosLat")== null ? 0 : Integer.parseInt(domicilioEntregaDatos.get("minutosLat")));
			GPSdomicilioEntrega.setSegundosLat(domicilioEntregaDatos.get("segundosLat")== null ? 0 :Integer.parseInt(domicilioEntregaDatos.get("segundosLat")));
			GPSdomicilioEntrega.setLongitud(domicilioEntregaDatos.get("longitud"));
			GPSdomicilioEntrega.setGradosLon(domicilioEntregaDatos.get("gradosLon")== null ? 0 : Integer.parseInt(domicilioEntregaDatos.get("gradosLon")));
			GPSdomicilioEntrega.setMinutosLon(domicilioEntregaDatos.get("minutosLon")== null ? 0 : Integer.parseInt(domicilioEntregaDatos.get("minutosLon")));
			GPSdomicilioEntrega.setSegundosLon(domicilioEntregaDatos.get("segundosLon")== null ? 0 : Integer.parseInt(domicilioEntregaDatos.get("segundosLon")));
			domicilioEntrega.setGps(GPSdomicilioEntrega);
			
			solicitud.setDomicilioEntrega(domicilioEntrega);
		}
		
		
		solicitud.setEsRetiroDomicilio(request.getParameter("esRetiroDomicilio")== null || !"on".equals(request.getParameter("esRetiroDomicilio"))? false : true);
		if(request.getParameter("domicilioRetiro") != null && request.getParameter("domicilioRetiro") != "" ){
			Map<String, String> domicilioRetiroDatos = parseQuery(request.getParameter("domicilioRetiro"));
			
			UbicacionDTO domicilioRetiro = new UbicacionDTO();
			domicilioRetiro.setCalle(domicilioRetiroDatos.get("calle"));
			domicilioRetiro.setNumero(domicilioRetiroDatos.get("numero") == null ? 0 : Integer.parseInt(domicilioRetiroDatos.get("numero")));
			domicilioRetiro.setPiso(domicilioRetiroDatos.get("piso") == null ? 0 : Integer.parseInt(domicilioRetiroDatos.get("piso")));
			domicilioRetiro.setDepto(domicilioRetiroDatos.get("departamento"));
			domicilioRetiro.setCodPost(domicilioRetiroDatos.get("codPostal"));
			domicilioRetiro.setLocalidad(domicilioRetiroDatos.get("localidad"));
			domicilioRetiro.setProvincia(domicilioRetiroDatos.get("provincia"));
			
			GPSDTO GPSdomicilioRetiro = new GPSDTO();
			GPSdomicilioRetiro.setLatitud(domicilioRetiroDatos.get("latitud"));
			GPSdomicilioRetiro.setGradosLat(domicilioRetiroDatos.get("gradosLat")== null ? 0 : Integer.parseInt(domicilioRetiroDatos.get("gradosLat")));
			GPSdomicilioRetiro.setMinutosLat(domicilioRetiroDatos.get("minutosLat")== null ? 0 : Integer.parseInt(domicilioRetiroDatos.get("minutosLat")));
			GPSdomicilioRetiro.setSegundosLat(domicilioRetiroDatos.get("segundosLat")== null ? 0 :Integer.parseInt(domicilioRetiroDatos.get("segundosLat")));
			GPSdomicilioRetiro.setLongitud(domicilioRetiroDatos.get("longitud"));
			GPSdomicilioRetiro.setGradosLon(domicilioRetiroDatos.get("gradosLon")== null ? 0 : Integer.parseInt(domicilioRetiroDatos.get("gradosLon")));
			GPSdomicilioRetiro.setMinutosLon(domicilioRetiroDatos.get("minutosLon")== null ? 0 : Integer.parseInt(domicilioRetiroDatos.get("minutosLon")));
			GPSdomicilioRetiro.setSegundosLon(domicilioRetiroDatos.get("segundosLon")== null ? 0 : Integer.parseInt(domicilioRetiroDatos.get("segundosLon")));
			domicilioRetiro.setGps(GPSdomicilioRetiro);
			

			solicitud.setDomicilioRetiro(domicilioRetiro);
		}
		
		Date fechaEmision = new Date();
    	SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

    	try {
    		fechaEmision = formatoFecha.parse(request.getParameter("fechaEmision"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		solicitud.setFechaEmision(fechaEmision);
		
		Date fechaMaxEntrega = null;
    	try {
    		fechaMaxEntrega = formatoFecha.parse(request.getParameter("fechaMaxEntrega"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		solicitud.setFechaMaxEntrega(fechaMaxEntrega);
		
		Date fechaEsEntrega = null;
    	try {
    		fechaEsEntrega = formatoFecha.parse(request.getParameter("fechaEstimadaEntrega"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		solicitud.setFechaEsEntrega(fechaEsEntrega);
		
		
		Date fechaRetiro = null;
    	try {
    		fechaRetiro = formatoFecha.parse(request.getParameter("fechaRetiro"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
    	
		solicitud.setFechaRetiro(fechaRetiro);
		solicitud.setHoraRetiroMax(request.getParameter("horaRetiroMax"));
		solicitud.setHoraRetiroMin(request.getParameter("horaRetiroMin"));
		solicitud.setManifesto(request.getParameter("manifesto"));
		solicitud.setClienteHabRecepcion(request.getParameter("clienteHabRecepcion"));
		solicitud.setClienteHabRetiro(request.getParameter("clienteHabRetiro"));
		solicitud.setCliente(clienteDTO);

		
		String[] cargasString = request.getParameterValues("cargas");
		
		List<CargaDTO> cargas = new ArrayList<CargaDTO>();
		for (int i = 0 ; i< cargasString.length ; i++){
			Map<String, String> datosCarga = parseQuery(cargasString[i]);
			CargaDTO c = new CargaDTO();
			c.setCantApliable(datosCarga.get("cantApilable")== null ? 0 : Integer.parseInt(datosCarga.get("cantApilable")));
			c.setCondicionesManipulacion(datosCarga.get("condicionesManipulacion"));
			c.setCondicionesViaje(datosCarga.get("condicionesViaje"));
			c.setDescri(datosCarga.get("descripcion"));
			c.setEsApilable(datosCarga.get("apilable")== null || !"on".equals(datosCarga.get("apilable"))? false : true);
			c.setEsRefrigerada(datosCarga.get("refrigerada")== null || !"on".equals(datosCarga.get("refrigerada"))? false : true);
			c.setFragilidad(Fragilidad.valueOf(datosCarga.get("fragilidad")));
			c.setPeso(Integer.parseInt(datosCarga.get("peso")));
			TipoCargaDTO tipoCarga = new TipoCargaDTO();
			tipoCarga.setCodigo(Integer.parseInt(datosCarga.get("tipoCarga")));
			c.setTipoC(tipoCarga);
			CategoriaTratamientoDTO categoriaTratamiento = new CategoriaTratamientoDTO();
			categoriaTratamiento.setCodigo(Integer.parseInt(datosCarga.get("tratamiento"))); 
			c.setTratamiento(categoriaTratamiento);
			c.setVolumen(Integer.parseInt(datosCarga.get("volumen")));
			DimensionDTO dim = new DimensionDTO();
			dim.setCoordX(Integer.parseInt(datosCarga.get("coordX")));
			dim.setCoordY(Integer.parseInt(datosCarga.get("coordY")));
			dim.setCoordZ(Integer.parseInt(datosCarga.get("coordZ")));
			UnidadDTO xU = new UnidadDTO();
			xU.setCodigo(Integer.parseInt(datosCarga.get("unidadCoordX")));
			dim.setUnidadCoordX(xU);
			UnidadDTO yU = new UnidadDTO();
			yU.setCodigo(Integer.parseInt(datosCarga.get("unidadCoordY")));
			dim.setUnidadCoordY(yU);
			UnidadDTO zU = new UnidadDTO();
			zU.setCodigo(Integer.parseInt(datosCarga.get("unidadCoordZ")));
			dim.setUnidadCoordZ(zU);
			c.setDimensiones(dim);
			cargas.add(c);
		}
		
		solicitud.setCargas(cargas);
		
		RequestDispatcher dispatcher = null;
		
		SucursalDTO origen = new SucursalDTO();
		origen.setCodigo(1);
		SucursalDTO destino = new SucursalDTO();
		destino.setCodigo(2);
		request.setAttribute("resultado", BusinessDelegate.getInstance().solicitudEnvio(solicitud, origen, destino));

		request.setAttribute("clientes", BusinessDelegate.getInstance().buscarClientes());
		request.setAttribute("tipoUnidades", BusinessDelegate.getInstance().buscarUnidades());
		request.setAttribute("tiposCargas", BusinessDelegate.getInstance().obtenerTiposCargas());
		request.setAttribute("categoriasFragilidad", BusinessDelegate.getInstance().obtenerCategoriasFragilidad());
		request.setAttribute("categoriasTratamiento", BusinessDelegate.getInstance().obtenerCategoriasTratamiento());
		
		dispatcher = request.getRequestDispatcher("/jsp/solicitudResultado.jsp");
		dispatcher.forward(request, response);
	}
	
	private static Map<String, String> parseQuery(String query) throws UnsupportedEncodingException {
	    Map<String, String> query_pairs = new LinkedHashMap<String, String>();
	    String[] pairs = query.split("&");
	    for (String pair : pairs) {
	        int idx = pair.indexOf("=");
	        query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
	    }
	    return query_pairs;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
