package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dto.RutaDTO;
import dto.SucursalDTO;
import entities.Ruta;
import entities.Sucursal;
import srv.RutaSRV;
import srv.SucursalSRV;
import service.IRutaService;

public class RutaController extends UnicastRemoteObject implements IRutaService{
	private static final long serialVersionUID = -9117118351167576127L;
	
	public RutaController() throws RemoteException {
		super();
	}
	
	// BUSCAR
	public RutaDTO buscarRuta (int id) throws RemoteException{
		try {
			Ruta ruta = (new RutaSRV()).buscarRuta(id);
			if (ruta != null){
				//TODO: Reemplazo por RutaDTO rDTO = ruta.toDTO();
				RutaDTO rutaDTO = new RutaDTO();
				rutaDTO.setCosto(ruta.getCosto());
				rutaDTO.setDuracion(ruta.getDuracion());
				rutaDTO.setCamino(ruta.getCamino());
				rutaDTO.setId(ruta.getId());
				
				Sucursal sucursalOrigen = ruta.getSucursalOrigen();
				SucursalDTO sucursalOrigenDTO = new SucursalDTO();
				sucursalOrigenDTO.setCodigo(sucursalOrigen.getCodigo());
				sucursalOrigenDTO.setNombre(sucursalOrigen.getNombre());
				rutaDTO.setSucursalDestino(sucursalOrigenDTO);
				
				Sucursal sucursalDestino = ruta.getSucursalDestino();
				SucursalDTO sucursalDestinoDTO = new SucursalDTO();
				sucursalDestinoDTO.setCodigo(sucursalDestino.getCodigo());
				sucursalDestinoDTO.setNombre(sucursalDestino.getNombre());
				rutaDTO.setSucursalOrigen(sucursalDestinoDTO);
				
				rutaDTO.setEsVigente(ruta.isEsVigente());
				
				return rutaDTO;
			}
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public RutaDTO buscarRutaVigente (SucursalDTO sucursalOrigenDTO, SucursalDTO sucursalDestinoDTO) throws RemoteException{
		try {	
			Ruta ruta = (new RutaSRV ()).buscarRutaVigente(sucursalOrigenDTO.getCodigo(), sucursalDestinoDTO.getCodigo());
			RutaDTO rutaDTO = new RutaDTO();
			if(ruta != null){
				//TODO: rutaDTO = ruta.toDTO();
				//TODO: Todo lo que esta abajo es pasar a DTO.
				//TODO: lo de buscar en la base la sucursal creo que esta mal si ya me la trae de la base con la ruta.
				rutaDTO.setId(ruta.getId());
				
				Sucursal sucursalO = (new SucursalSRV()).buscarSucursal(sucursalOrigenDTO.getCodigo());
				if (sucursalO != null){
					SucursalDTO sucursalODTO = new SucursalDTO();
					sucursalODTO.setCodigo(sucursalO.getCodigo());
					sucursalODTO.setNombre(sucursalO.getNombre());
					rutaDTO.setSucursalDestino(sucursalODTO);
				}
				
				Sucursal sucursalD = (new SucursalSRV()).buscarSucursal(sucursalDestinoDTO.getCodigo());
				if (sucursalD != null){
					SucursalDTO sucursalDDTO = new SucursalDTO();
					sucursalDDTO.setCodigo(sucursalD.getCodigo());
					sucursalDDTO.setNombre(sucursalD.getNombre());
					rutaDTO.setSucursalOrigen(sucursalDDTO);
				}
				
				rutaDTO.setCamino(ruta.getCamino());
				rutaDTO.setCosto(ruta.getCosto());
				rutaDTO.setDuracion(ruta.getDuracion());
				rutaDTO.setEsVigente(ruta.isEsVigente());
			}
			
			return rutaDTO;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// ALTAS
	public int guardarRuta (RutaDTO rutaDTO)throws RemoteException{
		try {
			Ruta ruta = (new RutaSRV()).buscarRuta(rutaDTO.getId());
			if(ruta == null){
				ruta = new Ruta();
				//TODO: ruta = Ruta.toEntity(rutaDTO);
				ruta.setCosto(rutaDTO.getCosto());
				ruta.setDuracion(rutaDTO.getDuracion());
				ruta.setCamino(rutaDTO.getCamino());
				ruta.setEsVigente(rutaDTO.isEsVigente());
				
				SucursalDTO sucursalOrigenDTO = rutaDTO.getSucursalOrigen();
				Sucursal sucursalOrigen = new Sucursal();
				sucursalOrigen.setCodigo(sucursalOrigenDTO.getCodigo());
				sucursalOrigen.setNombre(sucursalOrigenDTO.getNombre());
				ruta.setSucursalDestino(sucursalOrigen);
				
				SucursalDTO sucursalDestinoDTO = rutaDTO.getSucursalDestino();
				Sucursal sucursalDestino = new Sucursal();
				sucursalDestino.setCodigo(sucursalDestinoDTO.getCodigo());
				sucursalDestino.setNombre(sucursalDestinoDTO.getNombre());
				ruta.setSucursalOrigen(sucursalDestino);		
				//TODO: ruta.save();				
				(new RutaSRV()).grabarRuta(ruta);
				System.out.println("La Ruta se grabó con éxito");
				return 2;
			}else{
				System.out.println("La Ruta ya existe");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar la Ruta");
			return 0;
		}
	}

	// BAJA
	public int bajaRuta (int codigo) throws RemoteException{
		try {
			Ruta ruta = (new RutaSRV()).buscarRuta(codigo);
			if(ruta != null){
				ruta.setEsVigente(false);
				//TODO: ruta.actualizarRuta();
				(new RutaSRV()).grabarRuta(ruta);
				System.out.println("La Ruta se eliminó con éxito");
				return 2;
			}else{
				System.out.println("La Ruta no existe");
				return 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al eliminar la ruta");
			return 0;
		}
	}
	
	// MODIFICAR
	public int modificarRuta (RutaDTO rutaDTO) throws RemoteException {
		try {
			Ruta ruta = (new RutaSRV()).buscarRuta (rutaDTO.getId());
			if(ruta != null){
				//TODO: ruta = Ruta.toEntity(rutaDTO);
				ruta.setId(rutaDTO.getId());
				ruta.setCosto(rutaDTO.getCosto());
				ruta.setDuracion(rutaDTO.getDuracion());
				ruta.setCamino(rutaDTO.getCamino());
				ruta.setEsVigente(rutaDTO.isEsVigente());
				
				SucursalDTO sucursalOrigenDTO = rutaDTO.getSucursalOrigen();
				Sucursal sucursalOrigen = new Sucursal();
				sucursalOrigen.setCodigo(sucursalOrigenDTO.getCodigo());
				sucursalOrigen.setNombre(sucursalOrigenDTO.getNombre());
				ruta.setSucursalDestino(sucursalOrigen);
				
				SucursalDTO sucursalDestinoDTO = rutaDTO.getSucursalDestino();
				Sucursal sucursalDestino = new Sucursal();
				sucursalDestino.setCodigo(sucursalDestinoDTO.getCodigo());
				sucursalDestino.setNombre(sucursalDestinoDTO.getNombre());
				ruta.setSucursalOrigen(sucursalDestino);				
				//TODO: ruta.actualizar();
				(new RutaSRV()).grabarRuta(ruta);
				System.out.println("La ruta se grabó con éxito");
				return 2;
			}else{
				System.out.println("La ruta no existe");
				return 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar al ruta");
			return 0;
		}
	}
}
