package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Vector;

import dto.GPSDTO;
import dto.UbicacionDTO;
import entities.Empresa;
import entities.GPS;
import entities.Sucursal;
import entities.Ubicacion;
import service.IUbicacionService;
import srv.ClienteSRV;
import srv.GPSSRV;
import srv.SucursalSRV;
import srv.UbicacionSRV;

public class UbicacionController extends UnicastRemoteObject implements IUbicacionService{
	private static final long serialVersionUID = -8927173698860853796L;

	public UbicacionController() throws RemoteException {
		super();
	}

	// BUSCAR
	public Vector<UbicacionDTO> buscarUbicacionesCliente (int idCliente) throws RemoteException{
		List<Ubicacion> destinos = (new ClienteSRV()).buscarUbicacionesByCliente(idCliente);
		Vector<UbicacionDTO> destinosDTO = new Vector<UbicacionDTO>();
		for(Ubicacion destino : destinos){
			UbicacionDTO destinoDTO = new UbicacionDTO();
			destinoDTO.setCodigo(destino.getCodigo());
			destinoDTO.setCalle(destino.getCalle());
			destinoDTO.setNumero(destino.getNumero());
			destinoDTO.setPiso(destino.getPiso());
			destinoDTO.setDepto(destino.getDepto());
			destinoDTO.setCodPost(destino.getCodPost());
			destinoDTO.setLocalidad(destino.getLocalidad());
			destinoDTO.setProvincia(destino.getProvincia());
			
			GPS gps = new GPS(); 
			gps = destino.getGps();
			if(gps != null){
				GPSDTO gpsDTO = new GPSDTO();
				gpsDTO.setLatitud(gps.getLatitud());
				gpsDTO.setGradosLat(gps.getGradosLat());
				gpsDTO.setMinutosLat(gps.getMinutosLat());
				gpsDTO.setSegundosLat(gps.getSegundosLat());
				gpsDTO.setLongitud(gps.getLongitud());
				gpsDTO.setGradosLon(gps.getGradosLon());
				gpsDTO.setMinutosLon(gps.getMinutosLon());
				gpsDTO.setSegundosLon(gps.getSegundosLon());
				destinoDTO.setGps(gpsDTO);
			}
			destinosDTO.add(destinoDTO);
		}
		return destinosDTO;
	}
		
	// ALTAS
	public int agregarUbicacionCliente (int idCliente, UbicacionDTO destinoDTO) throws RemoteException{
		try {
			Empresa empresa = (new ClienteSRV ()).buscarEmpresa(idCliente);
			List<Ubicacion> destinos = (new ClienteSRV()).buscarUbicacionesByCliente(idCliente);
			if(empresa != null){
				for (Ubicacion destino : destinos){
					if (destino.getCalle().equals(destinoDTO.getCalle())){
						if (destino.getNumero() == destinoDTO.getNumero()){
							if (destino.getPiso() == destinoDTO.getPiso()){
								if (destino.getDepto().equals(destinoDTO.getDepto())){
									if (destino.getCodPost().equals(destinoDTO.getCodPost())){
										if (destino.getLocalidad().equals(destinoDTO.getLocalidad())){
											if (destino.getProvincia().equals(destinoDTO.getProvincia())){
												System.out.println("La ubicación ya existe para la empresa");
												return 2;
											}
										}
									}
									
								}
							}
						}
					}
				}
				Ubicacion destino = new Ubicacion();
				destino.setCalle(destinoDTO.getCalle());
				destino.setNumero(destinoDTO.getNumero());
				destino.setPiso(destinoDTO.getPiso());
				destino.setDepto(destinoDTO.getDepto());
				destino.setCodPost(destinoDTO.getCodPost());
				destino.setLocalidad(destinoDTO.getLocalidad());
				destino.setProvincia(destinoDTO.getProvincia());
				
				GPSDTO gpsDTO = destinoDTO.getGps();
				GPS gps = new GPS();
				if (gpsDTO != null){
					gps.setLatitud(destinoDTO.getGps().getLatitud());
					gps.setGradosLat(destinoDTO.getGps().getGradosLat());
					gps.setMinutosLat(destinoDTO.getGps().getMinutosLat());
					gps.setSegundosLat(destinoDTO.getGps().getSegundosLat());
					gps.setLongitud(destinoDTO.getGps().getLongitud());
					gps.setGradosLon(destinoDTO.getGps().getGradosLon());
					gps.setMinutosLon(destinoDTO.getGps().getMinutosLon());
					gps.setSegundosLon(destinoDTO.getGps().getSegundosLon());
					(new GPSSRV()).grabarGPS(gps);
					destino.setGps(gps);
				}
				
				(new UbicacionSRV()).grabarUbicacion(destino);
					
				destinos.add(destino);					
				empresa.setDestinos(destinos);
				
				(new ClienteSRV()).grabarCliente(empresa);
				
				System.out.println("Se dio de alta la ubicacion");
				return 3;
			}else{
				System.out.println("La empresa no existe");
				return 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar la ubicacion");
			return 0;
		}
	}
	
	public int grabarUbicacionSucursal (int idSucursal, UbicacionDTO ubicacionDTO) throws RemoteException{
		try {
			Sucursal sucursal = (new SucursalSRV()).buscarSucursal(idSucursal);
			if (sucursal != null){
				Ubicacion ubicacion = new Ubicacion();
				ubicacion.setCalle(ubicacionDTO.getCalle());
				ubicacion.setNumero(ubicacionDTO.getNumero());
				ubicacion.setPiso(ubicacionDTO.getPiso());
				ubicacion.setDepto(ubicacionDTO.getDepto());
				ubicacion.setCodPost(ubicacionDTO.getCodPost());
				ubicacion.setLocalidad(ubicacionDTO.getLocalidad());
				ubicacion.setProvincia(ubicacionDTO.getProvincia());
					
				GPSDTO gpsDTO = ubicacionDTO.getGps();
				GPS gps = new GPS();
				if (gpsDTO != null){
					gps.setLatitud(ubicacionDTO.getGps().getLatitud());
					gps.setGradosLat(ubicacionDTO.getGps().getGradosLat());
					gps.setMinutosLat(ubicacionDTO.getGps().getMinutosLat());
					gps.setSegundosLat(ubicacionDTO.getGps().getSegundosLat());
					gps.setLongitud(ubicacionDTO.getGps().getLongitud());
					gps.setGradosLon(ubicacionDTO.getGps().getGradosLon());
					gps.setMinutosLon(ubicacionDTO.getGps().getMinutosLon());
					gps.setSegundosLon(ubicacionDTO.getGps().getSegundosLon());
					(new GPSSRV()).grabarGPS(gps);
					ubicacion.setGps(gps);
				}
				
				(new UbicacionSRV()).grabarUbicacion(ubicacion);
				
				sucursal.setUbicacion(ubicacion);
				(new SucursalSRV()).ModificarSucursal(sucursal);
				
				System.out.println("Se dio de alta la ubicacion");
				return 2;
			}else{
				System.out.println("La sucursal no existe");
				return 1;
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar la ubicacion");
			return 0;
		}
	}
		
	// BAJAS
	public int eliminarUbicacionCliente (int idCliente, UbicacionDTO destinoDTO) throws RemoteException{
		try {
			Empresa empresa = (new ClienteSRV()).buscarEmpresa(idCliente);
			if (empresa != null){
				List <Ubicacion> ubicaciones = (new ClienteSRV()).buscarUbicacionesByCliente(idCliente);
				for(Ubicacion ubicacion : ubicaciones){
					if (ubicacion.getCodigo() == destinoDTO.getCodigo()){
						
						GPS gps = ubicacion.getGps();
						
						(new UbicacionSRV()).eliminarUbicacion(ubicacion);
											
						(new GPSSRV()).eliminarGPS(gps);
						
						ubicaciones.remove(ubicacion);
						empresa.setDestinos(ubicaciones);
						(new ClienteSRV()).grabarCliente(empresa);
										
						System.out.println("Se eliminó con éxito la ubicacion");
						return 3;
					}
				}
				System.out.println("La ubicacion no existe para la empresa");
				return 2;
			}else{
				System.out.println("La empresa no existe");
				return 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al eliminar la ubicacion");
			return 0;
		}
	}
		
	// MODIFICACIONES
	public int modificarUbicacionCliente (int idCliente, UbicacionDTO destinoDTO) throws RemoteException{
		try {
			Empresa empresa = (new ClienteSRV()).buscarEmpresa(idCliente);
			if (empresa != null){
				List <Ubicacion> ubicaciones = (new ClienteSRV()).buscarUbicacionesByCliente(idCliente);
				for(Ubicacion ubicacion : ubicaciones){
					if (ubicacion.getCodigo() == destinoDTO.getCodigo()){
						
						ubicacion.setCalle(destinoDTO.getCalle());
						ubicacion.setNumero(destinoDTO.getNumero());
						ubicacion.setPiso(destinoDTO.getPiso());
						ubicacion.setDepto(destinoDTO.getDepto());
						ubicacion.setCodPost(destinoDTO.getCodPost());
						ubicacion.setLocalidad(destinoDTO.getLocalidad());
						ubicacion.setProvincia(destinoDTO.getProvincia());
						(new UbicacionSRV()).grabarUbicacion(ubicacion);
						
						GPSDTO gpsDTO = destinoDTO.getGps();
						GPS gps = ubicacion.getGps();
						
						if(gps != null){
							gps.setLatitud(gpsDTO.getLatitud());
							gps.setGradosLat(gpsDTO.getGradosLat());
							gps.setMinutosLat(gpsDTO.getMinutosLat());
							gps.setSegundosLat(gpsDTO.getSegundosLat());
							gps.setLongitud(gpsDTO.getLongitud());
							gps.setGradosLon(gpsDTO.getGradosLon());
							gps.setMinutosLon(gpsDTO.getMinutosLon());
							gps.setSegundosLon(gpsDTO.getSegundosLon());
						}else{
							gps = new GPS();
							gps.setLatitud(gpsDTO.getLatitud());
							gps.setGradosLat(gpsDTO.getGradosLat());
							gps.setMinutosLat(gpsDTO.getMinutosLat());
							gps.setSegundosLat(gpsDTO.getSegundosLat());
							gps.setLongitud(gpsDTO.getLongitud());
							gps.setGradosLon(gpsDTO.getGradosLon());
							gps.setMinutosLon(gpsDTO.getMinutosLon());
							gps.setSegundosLon(gpsDTO.getSegundosLon());
						}						
						(new GPSSRV()).grabarGPS(gps);
						
						ubicacion.setGps(gps);
						(new UbicacionSRV()).grabarUbicacion(ubicacion);
						
						System.out.println("Se eliminó con éxito la ubicacion");
						return 3;
					}
				}
				System.out.println("La ubicacion no existe para la empresa");
				return 2;
			}else{
				System.out.println("La empresa no existe");
				return 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al eliminar la ubicacion");
			return 0;
		}
	}
}
