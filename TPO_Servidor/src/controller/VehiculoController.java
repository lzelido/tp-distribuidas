package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import service.IVehiculoService;
import srv.ProveedorSRV;
import srv.TipoVehiculoSRV;
import srv.UnidadSRV;
import srv.VehiculoSRV;
import dto.ProveedorLocalDTO;
import dto.VehiculoExternoDTO;
import dto.VehiculoPropioDTO;
import entities.Carrier;
import entities.Mantenimiento;
import entities.ProveedorLocal;
import entities.TipoVehiculo;
import entities.Unidad;
import entities.VehiculoExterno;
import entities.VehiculoPropio;

public class VehiculoController extends UnicastRemoteObject implements IVehiculoService{

	private static final long serialVersionUID = 787351955386009590L;

	public VehiculoController() throws RemoteException{
		super();
	}
	
	@Override
	public VehiculoPropioDTO obtenerVehiculoPropio(String matricula) throws RemoteException {
		return new VehiculoSRV().buscarVehiculoPropio(matricula);
	}
	
	@Override
	public VehiculoExternoDTO obtenerVehiculoExterno(String matricula) throws RemoteException {
		return new VehiculoSRV().buscarVehiculoExterno(matricula);
	}
	
	@Override
	public void eliminarVehiculoExterno(String matricula) throws RemoteException {
		new VehiculoSRV().eliminarVehiculoExterno(matricula);
	}
	
	@Override
	public void eliminarVehiculoPropio(String matricula) throws RemoteException {
		new VehiculoSRV().eliminarVehiculoPropio(matricula);
	}

	@Override
	public void guardarVehiculoPropio(VehiculoPropioDTO vehiculo) throws RemoteException {		
		VehiculoPropio v = new VehiculoPropio();
		v.setActivo(vehiculo.isActivo());
		v.setCondicionesTransp(vehiculo.getCondicionesTransp());
		v.setEnMantenimiento(vehiculo.isEnMantenimiento());
		v.setGarantiaHasta(vehiculo.getGarantiaHasta());
		v.setInformacionRegistro(vehiculo.getInformacionRegistro());
		v.setKilometraje(vehiculo.getKilometraje());
		v.setMantenimientos(new ArrayList<Mantenimiento>());
		v.setMatricula(vehiculo.getMatricula());
		v.setTara(vehiculo.getTara());
		
		TipoVehiculo t = (new TipoVehiculoSRV()).buscarTipoVehiculo(vehiculo.getTipo().getCodigo());;
		v.setTipo(t);
		
		Unidad u = new UnidadSRV().buscarUnidad(vehiculo.getUnidadTara().getCodigo());
		v.setUnidadTara(u);
		
		Unidad uv = new UnidadSRV().buscarUnidad(vehiculo.getUnidadVol().getCodigo());
		v.setUnidadVol(uv);
		
		v.setVidaUtil(vehiculo.getVidaUtil());
		v.setVolumen(vehiculo.getVolumen());
		
		
		new VehiculoSRV().grabarVehiculoPropio(v);
	}
	
	@Override
	public void guardarVehiculoExterno(VehiculoExternoDTO vehiculo) throws RemoteException {		
		VehiculoExterno v = new VehiculoExterno();
		v.setCondicionesTransp(vehiculo.getCondicionesTransp());
		v.setGarantiaHasta(vehiculo.getGarantiaHasta());
		v.setMantenimientos(new ArrayList<Mantenimiento>());
		v.setMatricula(vehiculo.getMatricula());
		v.setTara(vehiculo.getTara());
		
		TipoVehiculo t = (new TipoVehiculoSRV()).buscarTipoVehiculo(vehiculo.getTipo().getCodigo());;
		v.setTipo(t);
		
		Unidad u = new UnidadSRV().buscarUnidad(vehiculo.getUnidadTara().getCodigo());
		v.setUnidadTara(u);
		
		Unidad uv = new UnidadSRV().buscarUnidad(vehiculo.getUnidadVol().getCodigo());
		v.setUnidadVol(uv);
		
		v.setVolumen(vehiculo.getVolumen());
		
		if(vehiculo.getProveedor() instanceof ProveedorLocalDTO){
			ProveedorLocal p = new ProveedorSRV().buscarProveedorLocal(vehiculo.getProveedor().getCodigo());
			v.setProveedor(p);
		}else{
			Carrier p = new ProveedorSRV().buscarCarrier(vehiculo.getProveedor().getCodigo());
			v.setProveedor(p);
		}
		
		new VehiculoSRV().grabarVehiculoExterno(v);
	}

	@Override
	public List<VehiculoPropioDTO> obtenerVehiculosPropios(){
		return new VehiculoSRV().buscarVehiculosPropios();
	}

	@Override
	public List<VehiculoExternoDTO> obtenerVehiculosExternos(){
		return new VehiculoSRV().buscarVehiculosExternos();
	}
	
	public List<VehiculoPropioDTO> obtenerVehiculosParaMantenimiento(){
		
		List<VehiculoPropioDTO> vehiculosParaMantener = new ArrayList<VehiculoPropioDTO>();
		
		for (VehiculoPropio v : new VehiculoSRV().buscarVehiculosParaMantenimiento()){
			if(!v.isEnMantenimiento() && v.getPlanMantenimiento() != null){
				boolean matenimientoRealizado = false;
				if(v.getPlanMantenimiento().esKilometros()){
					for(Mantenimiento m : v.getMantenimientos()){
						if(v.getPlanMantenimiento().getKilometros()==m.getKilometraje()){
							matenimientoRealizado=true;
							break;
						}
					}
				}else{
					if(v.getPlanMantenimiento().getFecha().before(new Date())){
						matenimientoRealizado=true;
					}
				}
				if(!matenimientoRealizado){
					vehiculosParaMantener.add(v.getDTO());
				}
			}
		}
		return vehiculosParaMantener;
	}

	@Override
	public void mandarAlTallerVehiculoPropio(String matricula)
			throws RemoteException {
		VehiculoPropio v = new VehiculoSRV().buscarVehiculoPropioParaMantenimiento(matricula);
		v.setEnMantenimiento(true);
		new VehiculoSRV().mandarAlTallerVehiculoPropio(v);
	}
}

