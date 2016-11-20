package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.ExportException;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.CategoriaFragilidadController;
import controller.CategoriaTratamientoController;
import controller.ClienteEmpresaController;
import controller.ClienteParticularController;
import controller.CompaniaSeguroController;
import controller.EmpleadoController;
import controller.FacturaController;
import controller.ListaPreciosController;
import controller.ProductoController;
import controller.ProveedorController;
import controller.RemitoController;
import controller.RutaController;
import controller.SolicitudEnvioController;
import controller.SucursalController;
import controller.TarifaController;
import controller.TipoDeCargaController;
import controller.TipoMercaderiaController;
import controller.TipoSeguroController;
import controller.TipoVehiculoController;
import controller.UbicacionController;
import controller.UnidadController;
import controller.UsuarioController;
import controller.VehiculoController;
import controller.ViajeController;
import dao.ClienteDAO;
import dao.EmpleadoDAO;
import dao.ListaPreciosDAO;
import dao.TipoVehiculoDAO;
import dao.UnidadDAO;
import entities.Empleado;
import entities.Empresa;
import entities.ListaPrecios;
import entities.Particular;
import entities.TipoVehiculo;
import entities.Unidad;
import hbt.HibernateUtil;

public class Server {
	private Session s;

	public Server() {
		iniciar();
	}

	public void iniciar() {
		int puerto = 1099;
		try {
			System.out.println("Iniciando servidor...");
			LocateRegistry.createRegistry(puerto);

			/****************************************************************************************/
			/** VEHICULOS **/
			/****************************************************************************************/
			Naming.rebind("//localhost/Vehiculo", new VehiculoController());

			/****************************************************************************************/
			/** EMPLEADO **/
			/****************************************************************************************/
			Naming.rebind("//localhost/Empleado", new EmpleadoController());

			/****************************************************************************************/
			/** CLIENTES (EMPRESAS Y PARTICULARES) **/
			/****************************************************************************************/
			Naming.rebind("//localhost/ClienteEmpresa", new ClienteEmpresaController());
			Naming.rebind("//localhost/ClienteParticular", new ClienteParticularController());

			/****************************************************************************************/
			/** PRODUCTO (EMPRESAS) **/
			/****************************************************************************************/
			Naming.rebind("//localhost/Producto", new ProductoController());

			/****************************************************************************************/
			/** UBICACI�N **/
			/****************************************************************************************/
			Naming.rebind("//localhost/Ubicacion", new UbicacionController());

			/****************************************************************************************/
			/** TIPO DE SEGURO **/
			/****************************************************************************************/
			Naming.rebind("//localhost/TipoSeguro", new TipoSeguroController());

			/****************************************************************************************/
			/** TIPO DE MERCADERIA **/
			/****************************************************************************************/
			Naming.rebind("//localhost/TipoMercaderia", new TipoMercaderiaController());

			/****************************************************************************************/
			/** TARIFA **/
			/****************************************************************************************/
			Naming.rebind("//localhost/Tarifa", new TarifaController());

			/****************************************************************************************/
			/** COMPANIA DE SEGURO **/
			/****************************************************************************************/
			Naming.rebind("//localhost/CompaniaSeguro", new CompaniaSeguroController());

			/****************************************************************************************/
			/** UNIDAD **/
			/****************************************************************************************/
			Naming.rebind("//localhost/Unidad", new UnidadController());

			/****************************************************************************************/
			/** SOLICITUD DE ENVIO **/
			/****************************************************************************************/
			Naming.rebind("//localhost/SolicitudEnvio", new SolicitudEnvioController());

			Naming.rebind("//localhost/Remito", new RemitoController());

			Naming.rebind("//localhost/Factura", new FacturaController());

			/****************************************************************************************/
			/** SUCURSAL **/
			/****************************************************************************************/
			Naming.rebind("//localhost/Sucursal", new SucursalController());

			/****************************************************************************************/
			/**
			 * RUTA /
			 ****************************************************************************************/
			Naming.rebind("//localhost/Ruta", new RutaController());

			/****************************************************************************************/
			/** TIPO DE VEHICULO **/
			/****************************************************************************************/
			Naming.rebind("//localhost/TipoVehiculo", new TipoVehiculoController());

			/****************************************************************************************/
			/** PROVEEDOR **/
			/****************************************************************************************/
			Naming.rebind("//localhost/Proveedor", new ProveedorController());

			/****************************************************************************************/
			/** USUARIO **/
			/****************************************************************************************/
			Naming.rebind("//localhost/Usuario", new UsuarioController());

			/****************************************************************************************/
			/** LISTA PRECIOS **/
			/****************************************************************************************/
			Naming.rebind("//localhost/ListaPrecios", new ListaPreciosController());

			Naming.rebind("//localhost/TipoCarga", new TipoDeCargaController());
			Naming.rebind("//localhost/CategoriaFragilidad", new CategoriaFragilidadController());
			Naming.rebind("//localhost/CategoriaTratamiento", new CategoriaTratamientoController());
			Naming.rebind("//localhost/Viaje", new ViajeController());

			SessionFactory sf = HibernateUtil.getSessionFactory();
			s = sf.openSession();
			// EJECUTAR SI SE CORRE SERVIDOR POR PRIMERA VEZ
			// preparedData();

			s.close();

			System.out.println("Servidor iniciado correctamente.");

		} catch (ExportException e) {
			e.printStackTrace();
			System.out.println("No se pudo iniciar el servidor porque el puerto " + puerto
					+ " esta siendo utilizado por otra instancia.");
			System.out.println("Tenes que matar el otro servidor que iniciaste...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server();

	}

	private void preparedData() {
		try {

			// TIPO DE VEHICULO
			TipoVehiculo tipoVehiculo1 = new TipoVehiculo();
			tipoVehiculo1.setDescri("Caja carga seca (Carga general)");
			tipoVehiculo1.setTieneCondEspecial(false);
			try {
				TipoVehiculoDAO.getInstancia().grabarTipoVehiculo(tipoVehiculo1);
			} catch (Exception e) {
				e.printStackTrace();
			}

			TipoVehiculo tipoVehiculo2 = new TipoVehiculo();
			tipoVehiculo2.setDescri("Caja refrigerada");
			tipoVehiculo2.setTieneCondEspecial(true);
			tipoVehiculo2.setCondicion(
					"Cuentan con un sistema que permite reducir la temperatura del interior y mantenerla estable");
			try {
				TipoVehiculoDAO.getInstancia().grabarTipoVehiculo(tipoVehiculo2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			TipoVehiculo tipoVehiculo3 = new TipoVehiculo();
			tipoVehiculo3.setDescri("Plataforma para maquinaria pesada (carga extra pesada)");
			tipoVehiculo3.setTieneCondEspecial(false);
			try {
				TipoVehiculoDAO.getInstancia().grabarTipoVehiculo(tipoVehiculo3);
			} catch (Exception e) {
				e.printStackTrace();
			}

			TipoVehiculo tipoVehiculo4 = new TipoVehiculo();
			tipoVehiculo4.setDescri("Plataforma para carga sobredimencionada (carga extra dimensionada)");
			tipoVehiculo4.setTieneCondEspecial(false);
			try {
				TipoVehiculoDAO.getInstancia().grabarTipoVehiculo(tipoVehiculo4);
			} catch (Exception e) {
				e.printStackTrace();
			}

			TipoVehiculo tipoVehiculo5 = new TipoVehiculo();
			tipoVehiculo5.setDescri("Plataforma multinivel (Veh�culos)");
			tipoVehiculo5.setTieneCondEspecial(false);
			try {
				TipoVehiculoDAO.getInstancia().grabarTipoVehiculo(tipoVehiculo5);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// UNIDADES
			Unidad unidad1 = new Unidad();
			unidad1.setDescri("kil�metro (km)");
			unidad1.setTipo("longitud");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad1);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad2 = new Unidad();
			unidad2.setDescri("hect�metro (hm)");
			unidad2.setTipo("longitud");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad3 = new Unidad();
			unidad3.setDescri("dec�metro (dam)");
			unidad3.setTipo("longitud");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad3);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad4 = new Unidad();
			unidad4.setDescri("metro (m)");
			unidad4.setTipo("longitud");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad4);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad5 = new Unidad();
			unidad5.setDescri("dec�metro (dm)");
			unidad5.setTipo("longitud");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad5);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad6 = new Unidad();
			unidad6.setDescri("cent�metro (cm)");
			unidad6.setTipo("longitud");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad6);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad7 = new Unidad();
			unidad7.setDescri("mil�metro (mm)");
			unidad7.setTipo("longitud");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad7);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad8 = new Unidad();
			unidad8.setDescri("kilogramo (kg)");
			unidad8.setTipo("tara");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad8);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad9 = new Unidad();
			unidad9.setDescri("hectogramo (hg)");
			unidad9.setTipo("tara");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad9);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad10 = new Unidad();
			unidad10.setDescri("decagramo (dag)");
			unidad10.setTipo("tara");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad10);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad11 = new Unidad();
			unidad11.setDescri("gramo (g)");
			unidad11.setTipo("tara");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad11);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad12 = new Unidad();
			unidad12.setDescri("decigramo (dg)");
			unidad12.setTipo("tara");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad12);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad13 = new Unidad();
			unidad13.setDescri("centigramo (cg)");
			unidad13.setTipo("tara");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad13);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad14 = new Unidad();
			unidad14.setDescri("miligramo (mg)");
			unidad14.setTipo("tara");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad14);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad15 = new Unidad();
			unidad15.setDescri("kil�metro c�bico (km3)");
			unidad15.setTipo("volumen");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad15);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad16 = new Unidad();
			unidad16.setDescri("hec�metro c�bico (hm3)");
			unidad16.setTipo("volumen");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad16);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad17 = new Unidad();
			unidad17.setDescri("dec�metro c�bico (dam3)");
			unidad17.setTipo("volumen");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad17);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad18 = new Unidad();
			unidad18.setDescri("metro c�bico (m3)");
			unidad18.setTipo("volumen");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad18);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad19 = new Unidad();
			unidad19.setDescri("dec�metro c�bico dm3)");
			unidad19.setTipo("volumen");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad19);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad20 = new Unidad();
			unidad20.setDescri("cent�metro c�bico (cm3)");
			unidad20.setTipo("volumen");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad20);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad21 = new Unidad();
			unidad21.setDescri("mil�metro c�bico (mm3)");
			unidad21.setTipo("volumen");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad21);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// CLIENTES
			Empresa empresa = new Empresa();
			empresa.setNombre("UADE");
			empresa.setTipoDoc("CUIT");
			empresa.setNroDoc("30-11111111-4");
			empresa.setNroCuenta("1234567890123456789012");
			empresa.setCtaCte(1000F);
			empresa.setReqManifiesto(true);
			empresa.setEsPagoMensual(true);
			empresa.setEsDepositoPrevio(false);
			empresa.setMontoMinAutoriz(10000);
			empresa.setActivo(true);
			try {
				ClienteDAO.getInstancia().grabarCliente(empresa);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Particular particular = new Particular();
			particular.setNombre("Ver�nica Engrassi");
			particular.setTipoDoc("DNI");
			particular.setNroDoc("30000000");
			particular.setReqManifiesto(true);
			particular.setEsPagoAdelantado(true);
			particular.setActivo(true);
			try {
				ClienteDAO.getInstancia().grabarCliente(particular);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// ListaPrecios

			ListaPrecios listaPrecios1 = new ListaPrecios();
			listaPrecios1.setCoordenadaX(1);
			listaPrecios1.setCoordenadaY(1);
			listaPrecios1.setCoordenadaZ(1);
			listaPrecios1.setUnidadX("m");
			listaPrecios1.setUnidadY("m");
			listaPrecios1.setUnidadZ("m");
			listaPrecios1.setListaprecios("Paquete");
			listaPrecios1.setPeso(100);
			listaPrecios1.setPrecio(100);
			ListaPreciosDAO.getInstancia().grabarListaPrecios(listaPrecios1);

			ListaPrecios listaPrecios2 = new ListaPrecios();
			listaPrecios2.setCoordenadaX(1);
			listaPrecios2.setCoordenadaY(1);
			listaPrecios2.setCoordenadaZ(1);
			listaPrecios2.setUnidadX("m");
			listaPrecios2.setUnidadY("m");
			listaPrecios2.setUnidadZ("m");
			listaPrecios2.setListaprecios("Caja");
			listaPrecios2.setPeso(100);
			listaPrecios2.setPrecio(200);
			ListaPreciosDAO.getInstancia().grabarListaPrecios(listaPrecios2);

			ListaPrecios listaPrecios3 = new ListaPrecios();
			listaPrecios3.setCoordenadaX(1);
			listaPrecios3.setCoordenadaY(1);
			listaPrecios3.setCoordenadaZ(1);
			listaPrecios3.setUnidadX("m");
			listaPrecios3.setUnidadY("m");
			listaPrecios3.setUnidadZ("m");
			listaPrecios3.setListaprecios("Pallet");
			listaPrecios3.setPeso(100);
			listaPrecios3.setPrecio(300);
			ListaPreciosDAO.getInstancia().grabarListaPrecios(listaPrecios3);

			ListaPrecios listaPrecios4 = new ListaPrecios();
			listaPrecios4.setCoordenadaX(1);
			listaPrecios4.setCoordenadaY(1);
			listaPrecios4.setCoordenadaZ(1);
			listaPrecios4.setUnidadX("m");
			listaPrecios4.setUnidadY("m");
			listaPrecios4.setUnidadZ("m");
			listaPrecios4.setListaprecios("Bolsa");
			listaPrecios4.setPeso(100);
			listaPrecios4.setPrecio(250);
			ListaPreciosDAO.getInstancia().grabarListaPrecios(listaPrecios4);

			ListaPrecios listaPrecios5 = new ListaPrecios();
			listaPrecios5.setCoordenadaX(1);
			listaPrecios5.setCoordenadaY(1);
			listaPrecios5.setCoordenadaZ(1);
			listaPrecios5.setUnidadX("m");
			listaPrecios5.setUnidadY("m");
			listaPrecios5.setUnidadZ("m");
			listaPrecios5.setListaprecios("Bid�n");
			listaPrecios5.setPeso(100);
			listaPrecios5.setPrecio(350);
			ListaPreciosDAO.getInstancia().grabarListaPrecios(listaPrecios5);

			ListaPrecios listaPrecios6 = new ListaPrecios();
			listaPrecios6.setCoordenadaX(1);
			listaPrecios6.setCoordenadaY(1);
			listaPrecios6.setCoordenadaZ(1);
			listaPrecios6.setUnidadX("m");
			listaPrecios6.setUnidadY("m");
			listaPrecios6.setUnidadZ("m");
			listaPrecios6.setListaprecios("Tambor");
			listaPrecios6.setPeso(100);
			listaPrecios6.setPrecio(450);
			ListaPreciosDAO.getInstancia().grabarListaPrecios(listaPrecios6);

			ListaPrecios listaPrecios7 = new ListaPrecios();
			listaPrecios7.setCoordenadaX(1);
			listaPrecios7.setCoordenadaY(1);
			listaPrecios7.setCoordenadaZ(1);
			listaPrecios7.setUnidadX("m");
			listaPrecios7.setUnidadY("m");
			listaPrecios7.setUnidadZ("m");
			listaPrecios7.setListaprecios("Barril");
			listaPrecios7.setPeso(100);
			listaPrecios7.setPrecio(650);
			ListaPreciosDAO.getInstancia().grabarListaPrecios(listaPrecios7);

			// EMPLEADO
			Empleado empleado1 = new Empleado();
			empleado1.setNumero(1);
			empleado1.setApellido("ENGRASSI");
			empleado1.setNombre("Ver�nica");
			empleado1.setPuesto("Analista");
			empleado1.setSucursal(1);
			try {
				EmpleadoDAO.getInstancia().grabarEmpleado(empleado1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Empleado empleado2 = new Empleado();
			empleado2.setNumero(2);
			empleado2.setApellido("PEREZ de ANTUENO");
			empleado2.setNombre("Gustavo");
			empleado2.setPuesto("Analista");
			empleado2.setSucursal(1);
			try {
				EmpleadoDAO.getInstancia().grabarEmpleado(empleado2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Empleado empleado3 = new Empleado();
			empleado3.setNumero(3);
			empleado3.setApellido("FIORENTINO");
			empleado3.setNombre("Sebasti�n");
			empleado3.setPuesto("Lider");
			empleado3.setSucursal(1);
			try {
				EmpleadoDAO.getInstancia().grabarEmpleado(empleado3);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Empleado empleado4 = new Empleado();
			empleado4.setNumero(4);
			empleado4.setApellido("MARTINEZ");
			empleado4.setNombre("Leonardo");
			empleado4.setPuesto("Analista");
			empleado4.setSucursal(1);
			try {
				EmpleadoDAO.getInstancia().grabarEmpleado(empleado4);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Empleado empleado5 = new Empleado();
			empleado5.setNumero(5);
			empleado5.setApellido("MARTINEZ");
			empleado5.setNombre("Juan Manuel");
			empleado5.setPuesto("Analista");
			empleado5.setSucursal(1);
			try {
				EmpleadoDAO.getInstancia().grabarEmpleado(empleado5);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Empleado empleado6 = new Empleado();
			empleado6.setNumero(6);
			empleado6.setApellido("ROITMAN");
			empleado6.setNombre("Alan");
			empleado6.setPuesto("Analista");
			empleado6.setSucursal(1);
			try {
				EmpleadoDAO.getInstancia().grabarEmpleado(empleado6);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Error e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			System.out.println("Mensaje Error en el m�todo preparedData: " + e.getMessage());
			System.out.println("Stack Trace en el m�todo preparedData: " + e.getStackTrace());
			JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}