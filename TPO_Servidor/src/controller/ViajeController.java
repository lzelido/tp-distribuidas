package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import service.IViajeService;
import srv.SolicitudEnvioSRV;
import srv.SucursalSRV;
import srv.ViajeSRV;
import dto.CargaDTO;
import dto.SolicitudEnvioDTO;
import dto.SucursalDTO;
import dto.ViajeDTO;
import entities.Carga;
import entities.SolicitudEnvio;
import entities.Sucursal;
import entities.Viaje;

public class ViajeController extends UnicastRemoteObject implements IViajeService{
	private static final long serialVersionUID = 5521816029548896924L;

	// CONSTRUCTOR
	public ViajeController() throws RemoteException {
		super();
	}
	
	// ALTAS
	public int grabarViaje (SucursalDTO sucursalODTO, SucursalDTO sucursalDDTO, List<CargaDTO> cargasDTO, SolicitudEnvioDTO solicitud){
		try {
			Viaje viaje = (new ViajeSRV()).buscarViajeVigente(sucursalODTO.getCodigo(), sucursalDDTO.getCodigo());
			
			SolicitudEnvio sol = (new SolicitudEnvioSRV()).buscarSolicitud(solicitud.getCodigo());
			
			List<Carga> cargas = sol.getCargas();
			
			Sucursal sucursalO = (new SucursalSRV()).buscarSucursal(sucursalODTO.getCodigo());
			Sucursal sucursalD = (new SucursalSRV()).buscarSucursal(sucursalDDTO.getCodigo());
			
			if (viaje == null){
				if (sucursalO != null && sucursalD != null){
					if (!cargas.isEmpty()){
						viaje = new Viaje();
						
						Date fecha = new java.sql.Date((new Date()).getTime());
						
						Calendar fechaS = Calendar.getInstance();
						fechaS.setTime(fecha);
						fechaS.add(Calendar.DAY_OF_YEAR, 1);
						Date fSalida = fechaS.getTime();
						viaje.setFechaSalida(fSalida);
						
						Calendar fechaL = Calendar.getInstance();
						fechaL.setTime(fSalida);
						fechaL.add(Calendar.DAY_OF_YEAR, 5);
						Date fLlegada = fechaL.getTime();
						viaje.setFechaLlegada(fLlegada);
						
						viaje.setSucSalida(sucursalO);
						viaje.setSucDestino(sucursalD);
					
						viaje.setCargas(cargas);
						
						viaje.setEntregado(false);
						
						(new ViajeSRV()).grabarViaje(viaje);	
						
						
						System.out.println("El viaje se grabó con éxito");
						return 1;
					}else{
						System.out.println("Error al grabar el viaje - La carga no existe.");
						return 0;
					}
				}else{
					System.out.println("Error al grabar el viaje - Sucursal origen ó Sucursal destino no existen.");
					return 0;
				}
			}else{
				if (!cargas.isEmpty()){
					List<Carga> cargasViaje = viaje.getCargas();
					cargasViaje.addAll(cargas);
					
					(new ViajeSRV()).grabarViaje(viaje);
					System.out.println("El viaje se grabó con éxito");
					return 1;
				}else{
					System.out.println("Error al grabar el viaje - La carga no existe.");
					return 0;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar el viaje");
			return 0;
		}
	}
	
	// MODIFICACION
	@Override
	public int recepcionViaje (ViajeDTO viajeDTO){
		try {
			Viaje viaje = (new ViajeSRV()).buscarViaje(viajeDTO.getCodigo());
			if (viaje != null){
				viaje.setEntregado(true);
				
				(new ViajeSRV()).grabarViaje(viaje);
				System.out.println("El viaje se grabó con éxito");
				return 2;
			}else{
				System.out.println("El viaje no existe");
				return 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar el viaje");
			return 0;
		}
	}
	
	// BUSCAR
	public List<ViajeDTO> buscarViajesNoEntregadosBySucursal (SucursalDTO sucDDTO){
		try {
			List<Viaje> viajes = (new ViajeSRV()).buscarViajesNoEntregadosBySucursal(sucDDTO.getCodigo());
			List<ViajeDTO> viajesDTO = new ArrayList<ViajeDTO>();
			if(viajes != null){
				for(Viaje v : viajes){
					ViajeDTO vDTO = new ViajeDTO();
					vDTO.setCodigo(v.getCodigo());
					vDTO.setFechaSalida(v.getFechaSalida());
					vDTO.setFechaLlegada(v.getFechaLlegada());
					
					Sucursal sucursalO = v.getSucSalida();
					SucursalDTO sucursalODTO = new SucursalDTO();
					sucursalODTO.setCodigo(sucursalO.getCodigo());
					sucursalODTO.setNombre(sucursalO.getNombre());
					vDTO.setSucSalida(sucursalODTO);
					
					Sucursal sucursalD = v.getSucDestino();
					SucursalDTO sucursalDDTO = new SucursalDTO();
					sucursalDDTO.setCodigo(sucursalD.getCodigo());
					sucursalDDTO.setNombre(sucursalD.getNombre());
					vDTO.setSucDestino(sucursalDDTO);
					
					vDTO.setEntregado(v.isEntregado());
					
					List<Carga> cargas = v.getCargas();
					List<CargaDTO> cargasDTO = new ArrayList<CargaDTO>();
					for(Carga c : cargas){
						CargaDTO cDTO = new CargaDTO();
						cDTO.setCodigo(c.getCodigo());
						cDTO.setDescri(c.getDescri());
						
						cargasDTO.add(cDTO);
					}
							
					viajesDTO.add(vDTO);
				}
			}
			return viajesDTO;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
