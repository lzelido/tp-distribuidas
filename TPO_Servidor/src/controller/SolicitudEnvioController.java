package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import service.ISolicitudEnvioService;
import srv.CategoriaFragilidadSRV;
import srv.CategoriaTratamientoSRV;
import srv.ClienteSRV;
import srv.DimensionSRV;
import srv.SolicitudEnvioSRV;
import srv.TipoCargaSRV;
import srv.TipoMercaderiaSRV;
import srv.UnidadSRV;
import dto.CargaDTO;
import dto.DimensionDTO;
import dto.SolicitudEnvioDTO;
import entities.Carga;
import entities.CategoriaFragilidad;
import entities.CategoriaTratamiento;
import entities.Cliente;
import entities.Dimension;
import entities.GPS;
import entities.SolicitudEnvio;
import entities.TipoCarga;
import entities.TipoMercaderia;
import entities.Ubicacion;
import entities.Unidad;

public class SolicitudEnvioController extends UnicastRemoteObject implements ISolicitudEnvioService{
	private static final long serialVersionUID = -6077549301239818726L;

	// CONSTRUCTOR
	public SolicitudEnvioController() throws RemoteException {
		super();
	}

	// ALTA
	public int guardarSolicitudEnvio(SolicitudEnvioDTO solicitudDTO) throws RemoteException {
		try {
			SolicitudEnvio solicitud = new SolicitudEnvio();
			solicitud.setFechaEmision(solicitudDTO.getFechaEmision());
			
			Cliente cliente = (new ClienteSRV()).buscarCliente(solicitudDTO.getCliente().getCodigo());

			if (cliente != null){
				solicitud.setCliente(cliente);
			}else{
				System.out.println("Error al grabar la solicitud de envío (No existe el cliente)");
				return 0;
			}
			
			solicitud.setFechaMaxEntrega(solicitudDTO.getFechaMaxEntrega());
			solicitud.setFechaEstEntrega(solicitudDTO.getFechaEsEntrega());
			
			String clienteHabRecep = solicitudDTO.getClienteHabRecepcion();
			if (!clienteHabRecep.equals("")){
				solicitud.setClienteHabRecepcion(clienteHabRecep);
			}else{
				System.out.println("Error al grabar la solicitud de envío (No existe el cliente habilitado para la recepción)");
				return 0;
			}
			
			String clienteHabRetiro = solicitudDTO.getClienteHabRetiro();
			if (!clienteHabRetiro.equals("")){
				solicitud.setClienteHabRetiro(clienteHabRetiro);
			}else{
				solicitud.setClienteHabRetiro(clienteHabRecep);
			}	
			
			
			Ubicacion destino = new Ubicacion();
			destino.setCalle(solicitudDTO.getDomicilioEntrega().getCalle());
			destino.setCodPost(solicitudDTO.getDomicilioEntrega().getCodPost());
			destino.setDepto(solicitudDTO.getDomicilioEntrega().getDepto());
			GPS gps = new GPS();
			gps.setGradosLat(solicitudDTO.getDomicilioEntrega().getGps().getGradosLat());
			gps.setGradosLon(solicitudDTO.getDomicilioEntrega().getGps().getGradosLon());
			gps.setLatitud(solicitudDTO.getDomicilioEntrega().getGps().getLatitud());
			gps.setLongitud(solicitudDTO.getDomicilioEntrega().getGps().getLongitud());
			gps.setMinutosLat(solicitudDTO.getDomicilioEntrega().getGps().getMinutosLat());
			gps.setMinutosLon(solicitudDTO.getDomicilioEntrega().getGps().getMinutosLon());
			gps.setSegundosLat(solicitudDTO.getDomicilioEntrega().getGps().getSegundosLat());
			gps.setSegundosLon(solicitudDTO.getDomicilioEntrega().getGps().getSegundosLon());
			destino.setGps(gps);
			destino.setLocalidad(solicitudDTO.getDomicilioEntrega().getLocalidad());
			destino.setNumero(solicitudDTO.getDomicilioEntrega().getNumero());
			destino.setPiso(solicitudDTO.getDomicilioEntrega().getPiso());
			destino.setProvincia(solicitudDTO.getDomicilioEntrega().getProvincia());
			solicitud.setDomicilioEntrega(destino);

			solicitud.setEsRetiroDomicilio(solicitudDTO.isEsRetiroDomicilio());
			
			if (solicitud.isEsRetiroDomicilio()){
				Ubicacion retiro = new Ubicacion();
				retiro.setCalle(solicitudDTO.getDomicilioRetiro().getCalle());
				retiro.setCodPost(solicitudDTO.getDomicilioRetiro().getCodPost());
				retiro.setDepto(solicitudDTO.getDomicilioRetiro().getDepto());
				GPS gpsRetiro = new GPS();
				gpsRetiro.setGradosLat(solicitudDTO.getDomicilioRetiro().getGps().getGradosLat());
				gpsRetiro.setGradosLon(solicitudDTO.getDomicilioRetiro().getGps().getGradosLon());
				gpsRetiro.setLatitud(solicitudDTO.getDomicilioRetiro().getGps().getLatitud());
				gpsRetiro.setLongitud(solicitudDTO.getDomicilioRetiro().getGps().getLongitud());
				gpsRetiro.setMinutosLat(solicitudDTO.getDomicilioRetiro().getGps().getMinutosLat());
				gpsRetiro.setMinutosLon(solicitudDTO.getDomicilioRetiro().getGps().getMinutosLon());
				gpsRetiro.setSegundosLat(solicitudDTO.getDomicilioRetiro().getGps().getSegundosLat());
				gpsRetiro.setSegundosLon(solicitudDTO.getDomicilioRetiro().getGps().getSegundosLon());
				retiro.setGps(gpsRetiro);
				retiro.setLocalidad(solicitudDTO.getDomicilioRetiro().getLocalidad());
				retiro.setNumero(solicitudDTO.getDomicilioRetiro().getNumero());
				retiro.setPiso(solicitudDTO.getDomicilioRetiro().getPiso());
				retiro.setProvincia(solicitudDTO.getDomicilioRetiro().getProvincia());
				solicitud.setDomicilioRetiro(retiro);

				
				solicitud.setFechaRetiro(solicitudDTO.getFechaRetiro());
				solicitud.setHoraRetiroMax(solicitudDTO.getHoraRetiroMax());
				solicitud.setHoraRetiroMin(solicitudDTO.getHoraRetiroMin());
				
			}else{
				System.out.println("No se solicitó retiro a domicilio");
			}
			
			solicitud.setManifesto(solicitudDTO.getManifesto());
			
			List<CargaDTO> cargasDTO = solicitudDTO.getCargas();
			if (cargasDTO != null && !cargasDTO.isEmpty()){
				List<Carga> cargas = new ArrayList<Carga>();
				for(CargaDTO cargaDTO : cargasDTO){
					Carga carga = this.grabarCarga(cargaDTO);	
					cargas.add(carga);
				}
				solicitud.setCargas(cargas);
			}else{
				System.out.println("Error al grabar la solicitud de envío (No existen cargas)");
				return 0;
			}
			
			(new SolicitudEnvioSRV()).grabarSolicitud(solicitud);
			
			System.out.println("La solicitud se grabó con éxito");
			return solicitud.getCodigo();		
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar la solicitud de envío");
			return 0;
		}
	}
	
	private Carga grabarCarga (CargaDTO cargaDTO){
		try {
			Carga carga = new Carga();
			carga.setDescri(cargaDTO.getDescri());
			
			TipoCarga tipoC = (new TipoCargaSRV()).buscarTipoCarga(cargaDTO.getTipoC().getCodigo());
			carga.setTipoC (tipoC);
			
			TipoMercaderia tipoM = (new TipoMercaderiaSRV()).buscarTipoMercaderia(cargaDTO.getTipoM().getCodigo());
			carga.setTipoM(tipoM);
					
			carga.setPeso(cargaDTO.getPeso());
			
			Dimension dimension = new Dimension();
			dimension.setCoordX(cargaDTO.getDimensiones().getCoordX());
			dimension.setCoordY(cargaDTO.getDimensiones().getCoordY());
			dimension.setCoordZ(cargaDTO.getDimensiones().getCoordZ());
			dimension.setUnidadCoordX(new UnidadSRV().buscarUnidad(cargaDTO.getDimensiones().getUnidadCoordX().getCodigo()));
			dimension.setUnidadCoordY(new UnidadSRV().buscarUnidad(cargaDTO.getDimensiones().getUnidadCoordY().getCodigo()));
			dimension.setUnidadCoordZ(new UnidadSRV().buscarUnidad(cargaDTO.getDimensiones().getUnidadCoordZ().getCodigo()));
			
			carga.setDimensiones(dimension);
			
			carga.setVolumen(cargaDTO.getVolumen());
			
			CategoriaFragilidad fragilidad = (new CategoriaFragilidadSRV()).buscarFragilidad(cargaDTO.getFragilidad().getCodigo());
			carga.setFragilidad(fragilidad);
			
			CategoriaTratamiento tratamiento = (new CategoriaTratamientoSRV()).buscarTratamiento(cargaDTO.getTratamiento().getCodigo());
			carga.setTratamiento(tratamiento);
			
			carga.setEsApilable(cargaDTO.isEsApilable());
			carga.setCantApliable(cargaDTO.getCantApliable());
			carga.setEsRefrigerada(cargaDTO.isEsRefrigerada());
			carga.setCondicionesViaje(cargaDTO.getCondicionesViaje());
			carga.setCondicionesManipulacion(cargaDTO.getCondicionesManipulacion());
			carga.setEntregado(cargaDTO.isEntregado());
			
			return carga;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar la carga");
			return null;
		}
	}
	
	private Dimension grabarDimension (DimensionDTO dimensionDTO){
		try {
			Dimension dimension = new Dimension();
			dimension.setCodigo(dimensionDTO.getCodigo());
			
			dimension.setCoordX(dimensionDTO.getCoordX());
			Unidad unidadX = (new UnidadSRV()).buscarUnidad(dimensionDTO.getUnidadCoordX().getCodigo());
			if (unidadX != null){
				dimension.setUnidadCoordX(unidadX);
			}else{
				System.out.println("Error al grabar la dimensión (No existe la unidad de la coordenada X)");
				return null;
			}
			
			dimension.setCoordY(dimensionDTO.getCoordY());
			Unidad unidadY = (new UnidadSRV()).buscarUnidad(dimensionDTO.getUnidadCoordY().getCodigo());
			if (unidadY != null){
				dimension.setUnidadCoordY(unidadY);
			}else{
				System.out.println("Error al grabar la dimensión (No existe la unidad de la coordenada Y)");
				return null;
			}
			
			dimension.setCoordZ(dimensionDTO.getCoordZ());
			Unidad unidadZ = (new UnidadSRV()).buscarUnidad(dimensionDTO.getUnidadCoordZ().getCodigo());
			if (unidadZ != null){
				dimension.setUnidadCoordZ(unidadZ);
			}else{
				System.out.println("Error al grabar la dimensión (No existe la unidad de la coordenada Z)");
				return null;
			}
			
			(new DimensionSRV()).grabarDimension(dimension);
			
			System.out.println("La dimensión se grabó con éxito");
			return dimension;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar la dimensión");
			return null;
		}
	}
}
