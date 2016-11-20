package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.ExportException;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
import controller.TipoSeguroController;
import controller.TipoVehiculoController;
import controller.UbicacionController;
import controller.UnidadController;
import controller.UsuarioController;
import controller.VehiculoController;
import controller.ViajeController;
import dao.CategoriaTratamientoDAO;
import dao.ClienteDAO;
import dao.EmpleadoDAO;
import dao.ListaPreciosDAO;
import dao.SucursalDAO;
import dao.TipoCargaDAO;
import dao.TipoSeguroDAO;
import dao.TipoVehiculoDAO;
import dao.UnidadDAO;
import entities.CategoriaTratamiento;
import entities.Empleado;
import entities.Empresa;
import entities.ListaPrecios;
import entities.Particular;
import entities.Sucursal;
import entities.TipoCarga;
import entities.TipoSeguro;
import entities.TipoVehiculo;
import entities.Ubicacion;
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
			/** UBICACIï¿½N **/
			/****************************************************************************************/
			Naming.rebind("//localhost/Ubicacion", new UbicacionController());

			/****************************************************************************************/
			/** TIPO DE SEGURO **/
			/****************************************************************************************/
			Naming.rebind("//localhost/TipoSeguro", new TipoSeguroController());

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
			Naming.rebind("//localhost/CategoriaTratamiento", new CategoriaTratamientoController());
			Naming.rebind("//localhost/Viaje", new ViajeController());

			SessionFactory sf = HibernateUtil.getSessionFactory();
			s = sf.openSession();
			// EJECUTAR SI SE CORRE SERVIDOR POR PRIMERA VEZ
			preparedData();

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

			// CATEGORIAS TRATAMIENTO
			CategoriaTratamiento tratamiento1 = new CategoriaTratamiento();
			tratamiento1.setDescri("Muy Peligroso");
			try {
				CategoriaTratamientoDAO.getInstancia().grabarTratamiento(tratamiento1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			CategoriaTratamiento tratamiento2 = new CategoriaTratamiento();
			tratamiento2.setDescri("Peligroso");
			try {
				CategoriaTratamientoDAO.getInstancia().grabarTratamiento(tratamiento2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			CategoriaTratamiento tratamiento3 = new CategoriaTratamiento();
			tratamiento3.setDescri("Indiferente");
			try {
				CategoriaTratamientoDAO.getInstancia().grabarTratamiento(tratamiento3);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// TIPOS DE CARGA
			TipoCarga tipoCarga1 = new TipoCarga();
			tipoCarga1.setDescri("Paquete");
			try {
				TipoCargaDAO.getInstancia().grabarTipoCarga(tipoCarga1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			TipoCarga tipoCarga2 = new TipoCarga();
			tipoCarga2.setDescri("Caja");
			try {
				TipoCargaDAO.getInstancia().grabarTipoCarga(tipoCarga2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			TipoCarga tipoCarga3 = new TipoCarga();
			tipoCarga3.setDescri("Pallet");
			try {
				TipoCargaDAO.getInstancia().grabarTipoCarga(tipoCarga3);
			} catch (Exception e) {
				e.printStackTrace();
			}
			TipoCarga tipoCarga4 = new TipoCarga();
			tipoCarga4.setDescri("Bolsa");
			try {
				TipoCargaDAO.getInstancia().grabarTipoCarga(tipoCarga4);
			} catch (Exception e) {
				e.printStackTrace();
			}
			TipoCarga tipoCarga5 = new TipoCarga();
			tipoCarga5.setDescri("Bidon");
			try {
				TipoCargaDAO.getInstancia().grabarTipoCarga(tipoCarga5);
			} catch (Exception e) {
				e.printStackTrace();
			}
			TipoCarga tipoCarga6 = new TipoCarga();
			tipoCarga6.setDescri("Tambor");
			try {
				TipoCargaDAO.getInstancia().grabarTipoCarga(tipoCarga6);
			} catch (Exception e) {
				e.printStackTrace();
			}
			TipoCarga tipoCarga7 = new TipoCarga();
			tipoCarga7.setDescri("Barril");
			try {
				TipoCargaDAO.getInstancia().grabarTipoCarga(tipoCarga7);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// TIPO SEGURO
			TipoSeguro tipoSeguro1 = new TipoSeguro();
			tipoSeguro1.setCodigo(1);
			tipoSeguro1.setDescripcion("Cobertura Completa");
			try {
				TipoSeguroDAO.getInstancia().grabarTipoSeguro(tipoSeguro1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			TipoSeguro tipoSeguro2 = new TipoSeguro();
			tipoSeguro2.setCodigo(2);
			tipoSeguro2.setDescripcion("Cobertura parcial");
			try {
				TipoSeguroDAO.getInstancia().grabarTipoSeguro(tipoSeguro2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			TipoSeguro tipoSeguro3 = new TipoSeguro();
			tipoSeguro3.setCodigo(3);
			tipoSeguro3.setDescripcion("Descripcion cobertura");
			try {
				TipoSeguroDAO.getInstancia().grabarTipoSeguro(tipoSeguro3);
			} catch (Exception e) {
				e.printStackTrace();
			}
			TipoSeguro tipoSeguro4 = new TipoSeguro();
			tipoSeguro4.setCodigo(4);
			tipoSeguro4.setDescripcion("Tipo seguro");
			try {
				TipoSeguroDAO.getInstancia().grabarTipoSeguro(tipoSeguro4);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// TIPO DE VEHICULO
			TipoVehiculo tipoVehiculo1 = new TipoVehiculo();
			tipoVehiculo1.setDescri("Carga general");
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
					"Descripción caja refrigerada");
			try {
				TipoVehiculoDAO.getInstancia().grabarTipoVehiculo(tipoVehiculo2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			TipoVehiculo tipoVehiculo3 = new TipoVehiculo();
			tipoVehiculo3.setDescri("Carga mas pesada");
			tipoVehiculo3.setTieneCondEspecial(false);
			try {
				TipoVehiculoDAO.getInstancia().grabarTipoVehiculo(tipoVehiculo3);
			} catch (Exception e) {
				e.printStackTrace();
			}

			TipoVehiculo tipoVehiculo4 = new TipoVehiculo();
			tipoVehiculo4.setDescri("Carga extra pesada");
			tipoVehiculo4.setTieneCondEspecial(false);
			try {
				TipoVehiculoDAO.getInstancia().grabarTipoVehiculo(tipoVehiculo4);
			} catch (Exception e) {
				e.printStackTrace();
			}

			TipoVehiculo tipoVehiculo5 = new TipoVehiculo();
			tipoVehiculo5.setDescri("Vehiculo");
			tipoVehiculo5.setTieneCondEspecial(false);
			try {
				TipoVehiculoDAO.getInstancia().grabarTipoVehiculo(tipoVehiculo5);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// UNIDADES
			Unidad unidad1 = new Unidad();
			unidad1.setDescri("KM");
			unidad1.setTipo("longitud");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad1);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad2 = new Unidad();
			unidad2.setDescri("HM");
			unidad2.setTipo("longitud");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad3 = new Unidad();
			unidad3.setDescri("DAM");
			unidad3.setTipo("longitud");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad3);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad4 = new Unidad();
			unidad4.setDescri("M");
			unidad4.setTipo("longitud");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad4);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad5 = new Unidad();
			unidad5.setDescri("DM");
			unidad5.setTipo("longitud");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad5);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad6 = new Unidad();
			unidad6.setDescri("CM");
			unidad6.setTipo("longitud");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad6);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad7 = new Unidad();
			unidad7.setDescri("MM");
			unidad7.setTipo("longitud");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad7);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad8 = new Unidad();
			unidad8.setDescri("KG");
			unidad8.setTipo("tara");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad8);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad9 = new Unidad();
			unidad9.setDescri("HG");
			unidad9.setTipo("tara");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad9);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad10 = new Unidad();
			unidad10.setDescri("DAG");
			unidad10.setTipo("tara");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad10);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad11 = new Unidad();
			unidad11.setDescri("GR");
			unidad11.setTipo("tara");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad11);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad12 = new Unidad();
			unidad12.setDescri("DG");
			unidad12.setTipo("tara");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad12);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad13 = new Unidad();
			unidad13.setDescri("CG");
			unidad13.setTipo("tara");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad13);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad14 = new Unidad();
			unidad14.setDescri("MG");
			unidad14.setTipo("tara");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad14);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad15 = new Unidad();
			unidad15.setDescri("KM3");
			unidad15.setTipo("volumen");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad15);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad16 = new Unidad();
			unidad16.setDescri("HM3");
			unidad16.setTipo("volumen");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad16);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad17 = new Unidad();
			unidad17.setDescri("DAM3");
			unidad17.setTipo("volumen");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad17);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad18 = new Unidad();
			unidad18.setDescri("M3");
			unidad18.setTipo("volumen");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad18);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad19 = new Unidad();
			unidad19.setDescri("DM3");
			unidad19.setTipo("volumen");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad19);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad20 = new Unidad();
			unidad20.setDescri("CM3");
			unidad20.setTipo("volumen");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad20);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Unidad unidad21 = new Unidad();
			unidad21.setDescri("MM3");
			unidad21.setTipo("volumen");
			try {
				UnidadDAO.getInstancia().grabarUnidad(unidad21);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// CLIENTES
			Empresa empresa = new Empresa();
			empresa.setNombre("EMPRESA");
			empresa.setTipoDoc("CUIT");
			empresa.setNroDoc("30-555555-1");
			empresa.setNroCuenta("123456");
			empresa.setCtaCte(1000F);
			empresa.setReqManifiesto(true);
			empresa.setEsPagoMensual(true);
			empresa.setEsDepositoPrevio(false);
			empresa.setMontoMinAutoriz(10000);
			try {
				ClienteDAO.getInstancia().save(empresa);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Particular particular = new Particular();
			particular.setNombre("Laura Zelido");
			particular.setTipoDoc("DNI");
			particular.setNroDoc("35960928");
			particular.setReqManifiesto(true);
			particular.setEsPagoAdelantado(true);
			try {
				ClienteDAO.getInstancia().save(particular);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ListaPrecios listaPrecios1 = new ListaPrecios();
			listaPrecios1.setCoordenadaX(1);
			listaPrecios1.setCoordenadaY(1);
			listaPrecios1.setCoordenadaZ(1);
			listaPrecios1.setUnidadX("m");
			listaPrecios1.setUnidadY("m");
			listaPrecios1.setUnidadZ("m");
			listaPrecios1.setListaprecios("Lista");
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
			listaPrecios3.setListaprecios("Bolsa");
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
			listaPrecios4.setListaprecios("Bolsa1");
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
			listaPrecios5.setListaprecios("Container");
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
			listaPrecios6.setListaprecios("Container2");
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
			empleado1.setApellido("Cueto");
			empleado1.setNombre("Manuel");
			empleado1.setPuesto("Puesto");
			try {
				EmpleadoDAO.getInstancia().grabarEmpleado(empleado1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Empleado empleado2 = new Empleado();
			empleado2.setNumero(2);
			empleado2.setApellido("Quintana");
			empleado2.setNombre("Manuel");
			empleado2.setPuesto("Puesto");
			try {
				EmpleadoDAO.getInstancia().grabarEmpleado(empleado2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Empleado empleado3 = new Empleado();
			empleado3.setNumero(3);
			empleado3.setApellido("Ukmar");
			empleado3.setNombre("Federico");
			empleado3.setPuesto("Puesto");
			try {
				EmpleadoDAO.getInstancia().grabarEmpleado(empleado3);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Empleado empleado4 = new Empleado();
			empleado4.setNumero(4);
			empleado4.setApellido("Zelido");
			empleado4.setNombre("Laura");
			empleado4.setPuesto("Puesto");
			try {
				EmpleadoDAO.getInstancia().grabarEmpleado(empleado4);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Sucursal sucursal = new Sucursal();
			sucursal.setCodigo(1);
			sucursal.setEncargadoDeposito(empleado1);
			sucursal.setGerente(empleado4);
			sucursal.setNombre("sucursal");
			Ubicacion ubicacion = new Ubicacion();
			ubicacion.setCodigo(1);
			sucursal.setUbicacion(ubicacion);

			Sucursal sucursal2 = new Sucursal();
			sucursal2.setCodigo(2);
			sucursal2.setEncargadoDeposito(empleado1);
			sucursal2.setGerente(empleado4);
			sucursal2.setNombre("sucursal");
			Ubicacion ubicacion2 = new Ubicacion();
			ubicacion.setCodigo(2);
			sucursal.setUbicacion(ubicacion2);

			SucursalDAO.getInstancia().grabarSucursal(sucursal);
			SucursalDAO.getInstancia().grabarSucursal(sucursal2);
		} catch (Error e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}