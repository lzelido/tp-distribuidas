package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import service.IRemitoService;
import srv.CargaSRV;
import srv.ItemRemitoSRV;
import srv.RemitoSRV;
import srv.SolicitudEnvioSRV;
import dto.CargaDTO;
import dto.SolicitudEnvioDTO;
import entities.Carga;
import entities.GPS;
import entities.ItemRemito;
import entities.Remito;
import entities.SolicitudEnvio;
import entities.Ubicacion;

public class RemitoController extends UnicastRemoteObject implements IRemitoService{
	private static final long serialVersionUID = 4306612679567790849L;

	public RemitoController() throws RemoteException {
		super();
	}

	public int guardarRemito (SolicitudEnvioDTO solicitudDTO) throws RemoteException{
		try {
			SolicitudEnvio solicitud = (new SolicitudEnvioSRV()).buscarSolicitud(solicitudDTO.getCodigo());
			
			if (solicitud != null){
				Remito remito = new Remito();
				//TODO: todo esto lo pasaria a funcion del remito.
				//TODO: aca quedaria: Remito remito = Remito.toEntity(solicitudDTO);
				remito.setManifiesto(solicitudDTO.getManifesto());
				
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
				remito.setDestino(destino);
				
				
				
				
				//TODO: esto lo pondria como un metodo de remito que sea setFechaActual();
				Date fechaAct = new java.sql.Date((new Date()).getTime());
				remito.setFecha (fechaAct);
				
				remito.setFechaEstEntrega(solicitudDTO.getFechaEsEntrega());
				remito.setFechaMaxEntrega(solicitudDTO.getFechaMaxEntrega());
				
				String clienteHabRecep = solicitudDTO.getClienteHabRecepcion();
				if(!clienteHabRecep.equals("")){
					remito.setClienteHabRecepcion(clienteHabRecep);
				}else{
					System.out.println("Error al grabar el remito (No existe el cliente habilitado para la recepción)");
					return 0;
				}
				
				List<CargaDTO> cargasDTO = solicitudDTO.getCargas();
				List<ItemRemito> items = new ArrayList<ItemRemito>();
				for (CargaDTO cargaDTO : cargasDTO){
					ItemRemito item = this.grabarItemRemito(cargaDTO);
					
					items.add(item);
				}
				remito.setItems(items);
				
				(new RemitoSRV()).grabarRemito(remito);
				
				System.out.println("El remito se grabó con éxito");
				return 2;
			}else{
				System.out.println("Error al grabar el remito (No existe la solicitud)");
				return 0;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar el remito");
			return 0;
		}
	}
	
	private ItemRemito grabarItemRemito (CargaDTO cargaDTO){
		try {
			ItemRemito item = new ItemRemito();
			
			Carga carga = (new CargaSRV()).buscarCarga(cargaDTO.getCodigo());
			if (carga != null){
				item.setCarga(carga);
			}else{
				System.out.println("Error al grabar el ítemRemito (No existe carga)");
				return null;
			}
			
			(new ItemRemitoSRV()).grabarItemRemito(item);
			
			System.out.println("El ítemRemito se grabó con éxito");
			return item;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar el ítemRemito");
			return null;
		}
	}
}
