package businessDelegate;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import service.ICategoriaTratamientoService;
import service.IClienteEmpresaService;
import service.IClienteParticularService;
import service.ICompaniaSeguroService;
import service.IEmpleadoService;
import service.IFacturaService;
import service.IListaPreciosService;
import service.IProductoService;
import service.IProveedorService;
import service.IRemitoService;
import service.IRutaService;
import service.ISolicitudEnvioService;
import service.ISucursalService;
import service.ITarifaService;
import service.ITipoDeCargaService;
import service.ITipoSeguroService;
import service.ITipoVehiculoService;
import service.IUbicacionService;
import service.IUnidadService;
import service.IUsuarioService;
import service.IVehiculoService;
import service.IViajeService;
import dto.CarrierDTO;
import dto.CategoriaFragilidadDTO;
import dto.CategoriaTratamientoDTO;
import dto.CompaniaSeguroDTO;
import dto.EmpleadoDTO;
import dto.EmpresaDTO;
import dto.FacturaDTO;
import dto.ListaPreciosDTO;
import dto.ParticularDTO;
import dto.ProductoDTO;
import dto.ProveedorLocalDTO;
import dto.RutaDTO;
import dto.SolicitudEnvioDTO;
import dto.SucursalDTO;
import dto.TarifaDTO;
import dto.TipoCargaDTO;
import dto.TipoSeguroDTO;
import dto.TipoVehiculoDTO;
import dto.UbicacionDTO;
import dto.UnidadDTO;
import dto.UsuarioDTO;
import dto.VehiculoExternoDTO;
import dto.VehiculoPropioDTO;
import dto.ViajeDTO;
import enums.Fragilidad;

public class BusinessDelegate {
	private static BusinessDelegate instance = null;
	private IVehiculoService vehiculoService;
	private IClienteEmpresaService clienteEmpresaService;
	private IClienteParticularService clienteParticularService;
	private IProductoService productoService;
	private IEmpleadoService empleadoService;
	private IUbicacionService ubicacionService;
	private ITipoSeguroService tipoSeguroService;
	private ITarifaService tarifaService;
	private ICompaniaSeguroService companiaSeguroService;
	private IUnidadService unidadService;
	private ISucursalService sucursalService;
	private IRutaService rutaService;
	private ITipoVehiculoService tipoVehiculoService;
	private IProveedorService proveedorService;
	private IUsuarioService usuarioService;
	private ITipoDeCargaService tipoDeCargaService;
	private ICategoriaTratamientoService categoriaTratamiento;
	private ISolicitudEnvioService solicitudEnvio;
	private IRemitoService remito;
	private IFacturaService factura;
	private IListaPreciosService listaPreciosService;
	private IViajeService viajeService;
	

	private BusinessDelegate() {
		obtenerServicios();
	}

	public static BusinessDelegate getInstance() {
		if (instance == null) {
			instance = new BusinessDelegate();
		}
		return instance;
	}
	
	private boolean obtenerServicios() {
		try {
			vehiculoService = (IVehiculoService) Naming.lookup("//localhost/Vehiculo");
			clienteEmpresaService = (IClienteEmpresaService) Naming.lookup("//localhost/ClienteEmpresa");
			clienteParticularService = (IClienteParticularService) Naming.lookup("//localhost/ClienteParticular");
			productoService = (IProductoService) Naming.lookup("//localhost/Producto");
			empleadoService = (IEmpleadoService) Naming.lookup("//localhost/Empleado");
			ubicacionService = (IUbicacionService) Naming.lookup("//localhost/Ubicacion");
			tipoSeguroService = (ITipoSeguroService) Naming.lookup("//localhost/TipoSeguro");
			tarifaService = (ITarifaService) Naming.lookup("//localhost/Tarifa");
			companiaSeguroService = (ICompaniaSeguroService) Naming.lookup("//localhost/CompaniaSeguro");
			unidadService = (IUnidadService) Naming.lookup("//localhost/Unidad");
			sucursalService = (ISucursalService) Naming.lookup("//localhost/Sucursal");
			rutaService = (IRutaService) Naming.lookup("//localhost/Ruta");
			tipoVehiculoService = (ITipoVehiculoService) Naming.lookup("//localhost/TipoVehiculo");
			proveedorService = (IProveedorService) Naming.lookup("//localhost/Proveedor");	
			usuarioService = (IUsuarioService) Naming.lookup("//localhost/Usuario");
			tipoDeCargaService = (ITipoDeCargaService) Naming.lookup("//localhost/TipoCarga");
			categoriaTratamiento = (ICategoriaTratamientoService) Naming.lookup("//localhost/CategoriaTratamiento");
			solicitudEnvio = (ISolicitudEnvioService)Naming.lookup("//localhost/SolicitudEnvio");
			remito = (IRemitoService)Naming.lookup("//localhost/Remito");
			factura = (IFacturaService)Naming.lookup("//localhost/Factura");
			listaPreciosService = (IListaPreciosService) Naming.lookup("//localhost/ListaPrecios");
			viajeService = (IViajeService) Naming.lookup("//localhost/Viaje");
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/****************************************************************************************/
	/** METODOS DE VEHICULOS (PROPIOS Y EXTERNOS)                                          **/
	/****************************************************************************************/
	
	public String darDeAltaVehiculoPropio(VehiculoPropioDTO vehiculo) {
		try {
			vehiculoService.guardarVehiculoPropio(vehiculo);
			return "Vehiculo Guardado Correctamente";
		} catch (RemoteException e) {
			e.printStackTrace();
			return "Error al guardar el vehiculo";
		}
	}
	
	public String darDeAltaVehiculoExterno(VehiculoExternoDTO vehiculo) {
		try {
			vehiculoService.guardarVehiculoExterno(vehiculo);
			return "Vehiculo Guardado Correctamente";
		} catch (RemoteException e) {
			e.printStackTrace();
			return "Error al guardar el vehiculo";
		}
	}
	
	public VehiculoPropioDTO buscarVehiculoPropio(String matricula) {
		try {
			return vehiculoService.obtenerVehiculoPropio(matricula);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public VehiculoExternoDTO buscarVehiculoExterno(String matricula) {
		try {
			return vehiculoService.obtenerVehiculoExterno(matricula);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String bajaVehiculo(String matricula) {
		try {
			vehiculoService.eliminarVehiculoPropio(matricula);
			return "Vehiculo Eliminado Correctamente";
		} catch (RemoteException e) {
			e.printStackTrace();
			return "Error al eliminar el vehiculo";
		}
	}
	
	public String modificarVehiculoPropio(VehiculoPropioDTO vehiculo) {
		try {
			vehiculoService.guardarVehiculoPropio(vehiculo);
			return "Vehiculo modificar Correctamente";
		} catch (RemoteException e) {
			e.printStackTrace();
			return "Error al modificar el vehiculo";
		}
	}
	
	public String modificarVehiculoExterno(VehiculoExternoDTO vehiculo) {
		try {
			vehiculoService.guardarVehiculoExterno(vehiculo);
			return "Vehiculo modificar Correctamente";
		} catch (RemoteException e) {
			e.printStackTrace();
			return "Error al modificar el vehiculo";
		}
	}
	
	public List<VehiculoPropioDTO> buscarVehiculosPropio() {
		try {
			return vehiculoService.obtenerVehiculosPropios();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<VehiculoExternoDTO> buscarVehiculosExterno() {
		try {
			return vehiculoService.obtenerVehiculosExternos();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/****************************************************************************************/
	/** METODOS DE CLIENTES (EMPRESAS Y PARTICULARES)                                      **/
	/****************************************************************************************/
	// BUSCAR
	public EmpresaDTO buscarClienteEmpresa (String tipoDoc, String nroDoc) throws RemoteException{
		try {
			EmpresaDTO cliente = null;
			cliente = clienteEmpresaService.buscarCliente(tipoDoc, nroDoc);
			return cliente;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public EmpresaDTO buscarClienteEmpresa (int codigo) throws RemoteException{
		try {
			EmpresaDTO cliente = null;
			cliente = clienteEmpresaService.buscarCliente(codigo);
			return cliente;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ParticularDTO buscarClienteParticular (String tipoDoc, String nroDoc) throws RemoteException{
		try {
			ParticularDTO cliente = null;
			cliente = clienteParticularService.buscarCliente(tipoDoc, nroDoc);
			return cliente;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ParticularDTO buscarClienteParticular (int codigo) throws RemoteException{
		try {
			ParticularDTO cliente = null;
			cliente = clienteParticularService.buscarCliente(codigo);
			return cliente;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Object> buscarClientes() throws RemoteException{
		try {
			List<Object> clientes = new ArrayList<Object>();
			clientes.addAll(clienteParticularService.buscarClientes());
			clientes.addAll(clienteEmpresaService.buscarClientes());
			return clientes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// ALTAS
	public int altaClienteEmpresa (EmpresaDTO empresa) throws RemoteException{
		int check = 0;
		try {
			check = clienteEmpresaService.guardarCliente(empresa);
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public int altaClienteParticular (ParticularDTO particular) throws RemoteException{
		int check = 0;
		try {
			check = clienteParticularService.guardarCliente(particular);
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	// BAJAS
	public int bajaClienteEmpresa (int codigo) throws RemoteException{
		try {
			return (clienteEmpresaService.bajaCliente (codigo));
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int bajaClienteParticular (int codigo) throws RemoteException{
		try {
			return (clienteParticularService.bajaCliente (codigo));
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	// MODIFICACIONES
	
	public int modificarClienteEmpresa (EmpresaDTO empresa) throws RemoteException{
		try {
			return (clienteEmpresaService.modificarCliente(empresa));
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int modificarClienteParticular (ParticularDTO particular) throws RemoteException{
		try {
			return (clienteParticularService.modificarCliente(particular));
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/****************************************************************************************/
	/** METODOS DE PRODUCTOS                                                               **/
	/****************************************************************************************/
	
	// BUSCAR
	public Vector<ProductoDTO> buscarProductos (int idCliente){
		try {
			Vector<ProductoDTO> productos = productoService.buscarProductos(idCliente);
			return productos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// ALTA
	public int agregarProducto (int idCliente, ProductoDTO productoDTO)throws RemoteException{
		try {
			return (productoService.agregarProducto(idCliente, productoDTO));
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	// BAJA
	public int eliminarProducto (int idCliente, ProductoDTO productoDTO)throws RemoteException{
		try {
			return (productoService.eliminarProducto(idCliente, productoDTO));
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	// MODIFICACI�N
	public int modificarProducto (ProductoDTO productoDTO)throws RemoteException{
		try {
			return (productoService.modificarProducto(productoDTO));
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/****************************************************************************************/
	/** METODOS DE EMPLEADOS                                                               **/
	/****************************************************************************************/	
	public int darDeAltaEmpleado(EmpleadoDTO empleado) {
		int w = 0;
		try {
			w = empleadoService.guardarEmpleado(empleado);
			return w;
		} catch (RemoteException e) {
			e.printStackTrace();
			return w;
		}
	}
	
	
	public int darDeBajaEmpleado(EmpleadoDTO empleado) {
		int b = 0;
		try {
			b =  empleadoService.eliminarEmpleado(empleado);
			return b;
		} catch (RemoteException e) {
			e.printStackTrace();
			return b;
		}
	}

	public EmpleadoDTO buscarEmpleado (int numero) throws RemoteException{
		try {
			EmpleadoDTO empleado = null;
			empleado = empleadoService.buscarEmpleado(numero);
			return empleado;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Vector<EmpleadoDTO> buscarEmpleados (){
		try {
			Vector<EmpleadoDTO> empleados = empleadoService.buscarEmpleados();
			return empleados;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int ModificarEmpleado(EmpleadoDTO empleado) {
		int a = 0;
		try {
			a = empleadoService.ModificarEmpleado(empleado);  
			return a;
		} catch (RemoteException e) {
			e.printStackTrace();
			return a;
		}
	}
	
	/****************************************************************************************/
	/** METODOS DE UBICACION                                                               **/
	/****************************************************************************************/
	
	// BUSCAR
	public Vector<UbicacionDTO> buscarUbicacionesCliente (int idCliente){
		try {
			//TODO: return ubicacionService.buscarUbicacionesCliente(idCliente);
			Vector<UbicacionDTO> destinos = null; 
			destinos = ubicacionService.buscarUbicacionesCliente(idCliente);
			return destinos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// ALTA
	public int agregarUbicacionCliente (int idCliente, UbicacionDTO ubicacionDTO)throws RemoteException{
		try {
			return (ubicacionService.agregarUbicacionCliente (idCliente, ubicacionDTO));
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int grabarUbicacionSucursal (int idSucursal, UbicacionDTO ubicacion) throws RemoteException{
		try {
			return (ubicacionService.grabarUbicacionSucursal (idSucursal, ubicacion));
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	// BAJA
	public int eliminarUbicacionCliente (int idCliente, UbicacionDTO destinoDTO)throws RemoteException{
		try {
			return (ubicacionService.eliminarUbicacionCliente(idCliente, destinoDTO));
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	// MODIFICACI�N	
	public int modificarUbicacionCliente (int idCliente, UbicacionDTO ubicacionDTO)throws RemoteException{
		try {
			return (ubicacionService.modificarUbicacionCliente (idCliente, ubicacionDTO));
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/****************************************************************************************/
	/** METODOS TIPO DE SEGUROS                                                            **/
	/****************************************************************************************/	
	
	// ALTAS
	public int darDeAltaTipoSeguro(TipoSeguroDTO tipoSeguro) {
		//TODO: me parece una verga esto del w
		int w = 0;
		try {
			w = tipoSeguroService.guardarTipoSeguro(tipoSeguro);
			return w;
		} catch (RemoteException e) {
			e.printStackTrace();
			return w;
		}
	}
	
	// BUSCAR
	public TipoSeguroDTO buscarTipoSeguro (int codigo) throws RemoteException{
		try {
			//TODO: return tipoSeguroService.buscarTipoSeguro(codigo);
			TipoSeguroDTO tipoSeguro = null;
			tipoSeguro = tipoSeguroService.buscarTipoSeguro(codigo);
			return tipoSeguro;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// BAJAS
	public int bajaTipoSeguro (TipoSeguroDTO tipoSeguro) throws RemoteException{
		try {
			return (tipoSeguroService.bajaTipoSeguro (tipoSeguro));
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	// MODIFICACIONES
	public int modificarTipoSeguro (TipoSeguroDTO tipoSeguro) throws RemoteException{
		try {
			return (tipoSeguroService.modificarTipoSeguro(tipoSeguro));
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/****************************************************************************************/
	/** METODOS TARIFA                                                                     **/
	/****************************************************************************************/	
	
	//ALTAS
	public int darDeAltaTarifa(TarifaDTO tarifa) {
		int w = 0;
		try {
			w = tarifaService.guardarTarifa(tarifa);
			return w;
		} catch (RemoteException e) {
			e.printStackTrace();
			return w;
		}
	}
			
			
	// BUSCAR
	public TarifaDTO buscarTarifa (int codigo) throws RemoteException{
		try {
			TarifaDTO tarifa = null;
			tarifa = tarifaService.buscarTarifa(codigo);
			return tarifa;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
			
	public TarifaDTO buscarTarifaid (int idTipoSeguro, int idTipoMercaderia) throws RemoteException{
		try {
			TarifaDTO tarifa = null;
			tarifa = tarifaService.buscarTarifaid(idTipoSeguro,idTipoMercaderia);
			return tarifa;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		
	// BAJAS	
	public int bajaTarifa (TarifaDTO tarifa) throws RemoteException{
			try {
				return (tarifaService.bajaTarifa (tarifa));
			}catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		
	// MODIFICACIONES	
	public int modificarTarifa (TarifaDTO tarifa) throws RemoteException{
		try {
			return (tarifaService.modificarTarifa(tarifa));
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/****************************************************************************************/
	/** METODOS COMPANIA SEGURO                                                                     **/
	/****************************************************************************************/	
	
	//ALTAS
	public int darDeAltaCompaniaSeguro(CompaniaSeguroDTO companiaSeguro) {
		int w = 0;
		try {
			w = companiaSeguroService.guardarCompaniaSeguro(companiaSeguro);
			return w;
		} catch (RemoteException e) {
			e.printStackTrace();
			return w;
		}
	}
				
	// BUSCAR
	public CompaniaSeguroDTO buscarCompaniaSeguro (int codigo) throws RemoteException{
		try {
			CompaniaSeguroDTO companiaSeguro = null;
			companiaSeguro = companiaSeguroService.buscarCompaniaSeguro(codigo);
			return companiaSeguro;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
				
		
	// BAJAS
	public int bajaCompaniaSeguro (CompaniaSeguroDTO companiaSeguro) throws RemoteException{
		try {
			return (companiaSeguroService.bajaCompaniaSeguro (companiaSeguro));
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
			
	// MODIFICACIONES
	public int modificarCompaniaSeguro(CompaniaSeguroDTO companiaSeguro) throws RemoteException{
		try {
			return (companiaSeguroService.modificarCompaniaSeguro(companiaSeguro));
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/****************************************************************************************/
	/** METODOS DE UNIDAD							                                       **/
	/****************************************************************************************/
	
	public String darDeAltaUnidad(UnidadDTO unidad) {
		try {
			unidadService.guardarUnidad(unidad);
			return "Unidad Guardada Correctamente";
		} catch (RemoteException e) {
			e.printStackTrace();
			return "Error al guardar el tipo de vehiculo";
		}
	}

	public String darDeBajaUnidad(int codigo) {
		try {
			unidadService.eliminarUnidad(codigo);
			return "Unidad Eliminada Correctamente";
		} catch (RemoteException e) {
			e.printStackTrace();
			return "Error al eliminar la unidad";
		}
	}

	public String modificarUnidad(UnidadDTO unidad) {
		try {
			unidadService.modificarUnidad(unidad);
			return "Unidad modificada Correctamente";
		} catch (RemoteException e) {
			e.printStackTrace();
			return "Error al modificar la unidad";
		}
	}

	public List<UnidadDTO> buscarUnidades() {
		try {
			return unidadService.obtenerUnidades();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<UnidadDTO> buscarUnidadesVolumen() {
		try {
			return unidadService.obtenerUnidadesVolumen();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<UnidadDTO> buscarUnidadesTara() {
		try {
			return unidadService.obtenerUnidadesTara();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public UnidadDTO buscarUnidad(int codigo) {
		try {
			return unidadService.obtenerUnidad(codigo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/****************************************************************************************/
	/** METODOS DE SUCURSAL							                                       **/
	/****************************************************************************************/
		
	public int darDeAltaSucursal(SucursalDTO sucursal) {
		int s = 0;
		try {
			s = sucursalService.guardarSucursal(sucursal);
			return s;
		} catch (RemoteException e) {
			e.printStackTrace();
			return s;
		}
	}
	
	public SucursalDTO buscarSucursal (int codigo) throws RemoteException{
		try {
			SucursalDTO sucursal = null;
			sucursal = sucursalService.buscarSucursal(codigo);
			return sucursal;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int darDeBajaSucursal(SucursalDTO sucursal) {
		int b = 0;
		try {
			b =  sucursalService.eliminarSucursal(sucursal);
			return b;
		} catch (RemoteException e) {
			e.printStackTrace();
			return b;
		}
	}
	
	public int ModificarSucursal(SucursalDTO sucursal) {
		int a = 0;
		try {
			a = sucursalService.ModificarSucursal(sucursal);  
			return a;
		} catch (RemoteException e) {
			e.printStackTrace();
			return a;
		}
	}
	
	/****************************************************************************************/
	/** METODOS DE RUTAS                                                                   **/
	/****************************************************************************************/
	// ALTAS
	public int altaRuta (RutaDTO ruta) throws RemoteException{
		int check = 0;
		try {
			check = rutaService.guardarRuta(ruta);
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	// BAJAS
	public int bajaRuta (int ruta) throws RemoteException{
		try {
			return (rutaService.bajaRuta (ruta));
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	// MODIFICACIONES
	public int modificarRuta (RutaDTO ruta) throws RemoteException{
		try {
			return (rutaService.modificarRuta(ruta));
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
		
	// BUSCAR
	public RutaDTO buscarRuta (int id) throws RemoteException{
		try {
			RutaDTO ruta = null;
			ruta = rutaService.buscarRuta(id);
			return ruta;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/****************************************************************************************/
	/** METODOS DE TIPOS DE VEHICULOS	                                                   **/
	/****************************************************************************************/
	public String altaTipoVehiculo(TipoVehiculoDTO tipoVehiculo) {
		try {
			tipoVehiculoService.guardarTipoVehiculo(tipoVehiculo);
			return "Tipo Vehiculo Guardado Correctamente";
		} catch (RemoteException e) {
			e.printStackTrace();
			return "Error al guardar el tipo de vehiculo";
		}
	}

	public TipoVehiculoDTO buscarTipoVehiculo(int codigo) {
		try {
			return tipoVehiculoService.buscarTipoVehiculo(codigo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String bajaTipoVehiculo(int codigo) {
		try {
			tipoVehiculoService.bajaTipoVehiculo(codigo);
			return "Vehiculo eliminado Correctamente";
		} catch (RemoteException e) {
			e.printStackTrace();
			return "Error al eliminar el vehiculo";
		}
	}

	public String modificarTipoVehiculo(TipoVehiculoDTO tipoVehiculo) {
		try {
			tipoVehiculoService.modificarTipoVehiculo(tipoVehiculo);
			return "Tipo Vehiculo modificado Correctamente";
		} catch (RemoteException e) {
			e.printStackTrace();
			return "Error al modificar el tipo de vehiculo";
		}
	}

	public List<TipoVehiculoDTO> buscarTiposVehiculos() {
		try {
			return tipoVehiculoService.buscarTiposVehiculo();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/****************************************************************************************/
	/** METODOS DE PROVEEDORES      	                                                   **/
	/****************************************************************************************/
	//TODO: solicitar envio a un proveedor??
	
	public ProveedorLocalDTO buscarProveedorLocal(int codigo) {
		try {
			return proveedorService.buscarProveedorLocalDTO(codigo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public CarrierDTO buscarCarrier(int codigo) {
		try {
			return proveedorService.buscarCarrierDTO(codigo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String darDeAltaProveedorLocal(ProveedorLocalDTO proveedorLocal) {
		try {
			proveedorService.darDeAltaProveedorLocal(proveedorLocal);
			return "Proveedor local guardado Correctamente";
		} catch (RemoteException e) {
			e.printStackTrace();
			return "Error al guardar el proveedor";
		}
	}

	public String darDeAltaCarrier(CarrierDTO carrier) {
		try {
			proveedorService.darDeAltaCarrier(carrier);
			return "Carrier Guardado Correctamente";
		} catch (RemoteException e) {
			e.printStackTrace();
			return "Error al guardar el carrier";
		}	
	}

	public String bajaCarrier(int codigo) {
		try {
			proveedorService.bajaCarrier(codigo);
			return "Proveedor Eliminado Correctamente";
		} catch (RemoteException e) {
			e.printStackTrace();
			return "Error al eliminar el proveedor";
		}
	}

	public String modificarProveedorLocal(ProveedorLocalDTO proveedorLocal) {
		try {
			proveedorService.modificarProveedorLocal(proveedorLocal);
			return "Proveedor local modificado Correctamente";
		} catch (RemoteException e) {
			e.printStackTrace();
			return "Error al modificar el proveedor";
		}
	}

	public String modificarCarrier(CarrierDTO carrier) {
		try {
			proveedorService.modificarCarrier(carrier);
			return "Carrier modificado Correctamente";
		} catch (RemoteException e) {
			e.printStackTrace();
			return "Error al modificar el carrier";
		}
	}

	public List<Object> buscarProveedores() {
		try {
			return proveedorService.obtenerProveedores();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/****************************************************************************************/
	/** METODOS USUARIOS            	                                                   **/
	/****************************************************************************************/
	public UsuarioDTO login(UsuarioDTO usuario){
		try {
			return usuarioService.login(usuario);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}	
	
	public List<TipoCargaDTO> obtenerTiposCargas(){
		 try {
			return tipoDeCargaService.obtenerTiposCargas();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<CategoriaTratamientoDTO> obtenerCategoriasTratamiento(){
		try {
			return categoriaTratamiento.obtenerCategoriasTratamiento();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int solicitudEnvio(SolicitudEnvioDTO solicitud, SucursalDTO sucursalOrigen, SucursalDTO sucursalDestino){
		try {
			int codigo = solicitudEnvio.guardarSolicitudEnvio(solicitud);
			solicitud.setCodigo(codigo);
			if(codigo != 0){
				if(remito.guardarRemito(solicitud) != 0){
					viajeService.grabarViaje(sucursalOrigen, sucursalDestino, solicitud.getCargas(), solicitud);
					return factura.grabarFactura(solicitud, empleadoService.buscarEmpleado(1), sucursalService.buscarSucursal(1));
				}
			}
			return 0;
		} catch (RemoteException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/****************************************************************************************/
	/** METODOS LISTA PRECIOS            	                                                   **/
	/****************************************************************************************/
	
	public int darDeAltaListaPrecios(ListaPreciosDTO listaPrecios) {
		int w = 0;
		try {
			w = listaPreciosService.guardarListaPrecios(listaPrecios);
			return w;
		} catch (RemoteException e) {
			e.printStackTrace();
			return w;
		}
	}
	
	
	
	public List<FacturaDTO> buscarFacturas(int codigoCliente){
		try {
			return factura.buscarFacturas(codigoCliente);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public int pagarFactura(int codigoFactura){
		try {
			return factura.pagarFactura(codigoFactura);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	
	public void mandarAlTaller(String matricula){
		try {
			//TODO: Esto esta re manual.. o sea lo mandas al taller cuando te pinta �?=?=�?
			//TODO: Por mas que haga el buscar para mantenimiento antes... 
			vehiculoService.mandarAlTallerVehiculoPropio(matricula);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public List<VehiculoPropioDTO> buscarVehiculosParaMantenimiento(){
		try {
			return vehiculoService.obtenerVehiculosParaMantenimiento();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<ViajeDTO> buscarViajesNoEntregadosBySucursal(SucursalDTO sucursal) throws RemoteException{
		return viajeService.buscarViajesNoEntregadosBySucursal(sucursal);
	}
	
	public int recepcionViaje (ViajeDTO viajeDTO) throws RemoteException{
		return viajeService.recepcionViaje(viajeDTO);
	}
	
	public int entregarCarga (FacturaDTO facturaDTO, SucursalDTO sucursal) throws RemoteException{
		return factura.entregarCarga(facturaDTO, sucursal);
	}

	public List<String> obtenerCategoriasFragilidad() {
		List<String> values = new ArrayList<String>();
		for (Fragilidad fragilidad: Fragilidad.values()) {
			values.add(fragilidad.name());
		}
		return values;
	}
	
	
}
