package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dto.EmpleadoDTO;
import dto.GPSDTO;
import dto.SucursalDTO;
import dto.UbicacionDTO;
import entities.Empleado;
import entities.GPS;
import entities.Sucursal;
import entities.Ubicacion;
import service.ISucursalService;
import srv.EmpleadoSRV;
import srv.SucursalSRV;

public class SucursalController extends UnicastRemoteObject implements ISucursalService {
	private static final long serialVersionUID = 1L;

	public SucursalController() throws RemoteException {
		super();
	}

	@Override
	public SucursalDTO buscarSucursal(int codigo) throws RemoteException {
		try {
			Sucursal sucursal = (new SucursalSRV()).buscarSucursal(codigo);
			if (sucursal != null) {
				// Transformo la entidad Sucursal en DTO
				SucursalDTO sucursalDTO = new SucursalDTO();
				sucursalDTO.setCodigo(sucursal.getCodigo());
				sucursalDTO.setNombre(sucursal.getNombre());

				// Transformo los empleados de la sucursal en DTO
				Empleado gerente = sucursal.getGerente();
				EmpleadoDTO gerenteDTO = new EmpleadoDTO();
				if (gerente != null) {
					gerenteDTO.setNumero(gerente.getNumero());
					gerenteDTO.setApellido(gerente.getApellido());
					gerenteDTO.setNombre(gerente.getNombre());
					gerenteDTO.setPuesto(gerente.getPuesto());
				}

				Empleado encargadoDespacho = sucursal.getEncargadoDespacho();
				EmpleadoDTO encargadoDespachoDTO = new EmpleadoDTO();
				if (encargadoDespacho != null) {
					encargadoDespachoDTO.setNumero(encargadoDespacho.getNumero());
					encargadoDespachoDTO.setApellido(encargadoDespacho.getApellido());
					encargadoDespachoDTO.setNombre(encargadoDespacho.getNombre());
					encargadoDespachoDTO.setPuesto(encargadoDespacho.getPuesto());
				}

				Empleado encargadoDeposito = sucursal.getEncargadoDeposito();
				EmpleadoDTO encargadoDepositoDTO = new EmpleadoDTO();
				if (encargadoDeposito != null) {
					encargadoDepositoDTO.setNumero(encargadoDeposito.getNumero());
					encargadoDepositoDTO.setApellido(encargadoDeposito.getApellido());
					encargadoDepositoDTO.setNombre(encargadoDeposito.getNombre());
					encargadoDepositoDTO.setPuesto(encargadoDeposito.getPuesto());
				}

				Empleado encargadoRecepcion = sucursal.getEncargadoRecepcion();
				EmpleadoDTO encargadoRecepcionDTO = new EmpleadoDTO();
				if (encargadoRecepcion != null) {
					encargadoRecepcionDTO.setNumero(encargadoRecepcion.getNumero());
					encargadoRecepcionDTO.setApellido(encargadoRecepcion.getApellido());
					encargadoRecepcionDTO.setNombre(encargadoRecepcion.getNombre());
					encargadoRecepcionDTO.setPuesto(encargadoRecepcion.getPuesto());
				}

				// Setteo los empleados a la sucursal
				sucursalDTO.setGerente(gerenteDTO);
				sucursalDTO.setEncargadoDeposito(encargadoDepositoDTO);
				sucursalDTO.setEncargadoDespacho(encargadoDespachoDTO);
				sucursalDTO.setEncargadoRecepcion(encargadoRecepcionDTO);

				Ubicacion ubicacion = sucursal.getUbicacion();
				UbicacionDTO ubicacionDTO = new UbicacionDTO();
				if (ubicacion != null) {
					ubicacionDTO.setCodigo(ubicacion.getCodigo());
					ubicacionDTO.setCalle(ubicacion.getCalle());
					ubicacionDTO.setNumero(ubicacion.getNumero());
					ubicacionDTO.setPiso(ubicacion.getPiso());
					ubicacionDTO.setDepto(ubicacion.getDepto());
					ubicacionDTO.setCodPost(ubicacion.getCodPost());
					ubicacionDTO.setLocalidad(ubicacion.getLocalidad());
					ubicacionDTO.setProvincia(ubicacion.getProvincia());

					GPS gps = ubicacion.getGps();
					if (gps != null) {
						GPSDTO gpsDTO = new GPSDTO();
						gpsDTO.setCodigo(gps.getCodigo());
						gpsDTO.setLatitud(gps.getLatitud());
						gpsDTO.setGradosLat(gps.getGradosLat());
						gpsDTO.setMinutosLat(gps.getMinutosLat());
						gpsDTO.setSegundosLat(gps.getSegundosLat());
						gpsDTO.setLongitud(gps.getLongitud());
						gpsDTO.setGradosLon(gps.getGradosLon());
						gpsDTO.setMinutosLon(gps.getMinutosLon());
						gpsDTO.setSegundosLon(gps.getSegundosLon());
						ubicacionDTO.setGps(gpsDTO);
					}
				} else {
					ubicacionDTO.setCodigo(0);
					ubicacionDTO.setCalle("");
					ubicacionDTO.setNumero(0);
					ubicacionDTO.setPiso(0);
					ubicacionDTO.setDepto("");
					ubicacionDTO.setCodPost("");
					ubicacionDTO.setLocalidad("");
					ubicacionDTO.setProvincia("");
				}

				sucursalDTO.setUbicacion(ubicacionDTO);

				return sucursalDTO;

			} else {
				System.out.println("La sucursal ya existe");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al buscar la sucursal");
			return null;
		}
	}

	@Override
	public int guardarSucursal(SucursalDTO sucursalDTO) throws RemoteException {
		try {
			Sucursal sucursal = (new SucursalSRV()).buscarSucursal(sucursalDTO.getCodigo());

			if (sucursal == null) {
				sucursal = new Sucursal();
				sucursal.setCodigo(sucursalDTO.getCodigo());
				sucursal.setNombre(sucursalDTO.getNombre());
				Empleado gerente = (new EmpleadoSRV()).buscarEmpleado(sucursalDTO.getGerente().getNumero());
				sucursal.setGerente(gerente);
				Empleado encargadoDespacho = (new EmpleadoSRV())
						.buscarEmpleado(sucursalDTO.getEncargadoDespacho().getNumero());
				sucursal.setEncargadoDespacho(encargadoDespacho);
				Empleado encargadoDeposito = (new EmpleadoSRV())
						.buscarEmpleado(sucursalDTO.getEncargadoDeposito().getNumero());
				sucursal.setEncargadoDeposito(encargadoDeposito);
				Empleado encargadoRecepcion = (new EmpleadoSRV())
						.buscarEmpleado(sucursalDTO.getEncargadoRecepcion().getNumero());
				sucursal.setEncargadoRecepcion(encargadoRecepcion);

				(new SucursalSRV()).grabarSucursal(sucursal);
				System.out.println("La sucursal se grab� con �xito");
				return 2;
			} else {
				System.out.println("La sucursal ya existe");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar la sucursal");
			return 0;
		}
	}

	@Override
	public int ModificarSucursal(SucursalDTO sucursalDTO) throws RemoteException {
		try {
			Sucursal sucursal = (new SucursalSRV()).buscarSucursal(sucursalDTO.getCodigo());

			if (sucursal != null) {
				sucursal.setCodigo(sucursalDTO.getCodigo());
				sucursal.setNombre(sucursalDTO.getNombre());
				Empleado gerente = (new EmpleadoSRV()).buscarEmpleado(sucursalDTO.getGerente().getNumero());
				sucursal.setGerente(gerente);
				Empleado encargadoDeposito = (new EmpleadoSRV())
						.buscarEmpleado(sucursalDTO.getEncargadoDeposito().getNumero());
				sucursal.setEncargadoDeposito(encargadoDeposito);
				Empleado encargadoDespacho = (new EmpleadoSRV())
						.buscarEmpleado(sucursalDTO.getEncargadoDespacho().getNumero());
				sucursal.setEncargadoDespacho(encargadoDespacho);
				Empleado encargadoRecepcion = (new EmpleadoSRV())
						.buscarEmpleado(sucursalDTO.getEncargadoRecepcion().getNumero());
				sucursal.setEncargadoRecepcion(encargadoRecepcion);

				(new SucursalSRV()).ModificarSucursal(sucursal);
				System.out.println("La sucursal se modifico con �xito");
				return 2;
			} else {
				System.out.println("La sucursal no existe");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al modificar la sucursal");
			return 0;
		}
	}

	@Override
	public int eliminarSucursal(SucursalDTO sucursalDTO) throws RemoteException {
		try {
			Sucursal sucursal = (new SucursalSRV()).buscarSucursal(sucursalDTO.getCodigo());
			if (sucursal != null) {
				(new SucursalSRV()).EliminarSucursal(sucursal);
				System.out.println("La sucursal se elimino con �xito");
				return 2;
			} else {
				System.out.println("La sucursal no existe");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al eliminar la sucursal");
			return 0;
		}
	}

	@Override
	public List<SucursalDTO> buscarSucursales() throws RemoteException {
		try {
			List<SucursalDTO> sucursales = new ArrayList<SucursalDTO>();
			for (Sucursal s : (new SucursalSRV()).buscarSucursales()) {
				SucursalDTO sucursalDTO = new SucursalDTO();
				sucursalDTO.setCodigo(s.getCodigo());
				sucursalDTO.setNombre(s.getNombre());
				sucursales.add(sucursalDTO);
			}
			return sucursales;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
