package hbt;

import javax.swing.JOptionPane;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import entities.Cliente;
import entities.Empresa;
import entities.Particular;
import entities.*;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	
	static{
		try{
			AnnotationConfiguration config = new AnnotationConfiguration();
			config.addAnnotatedClass(Cliente.class);
			config.addAnnotatedClass(Empresa.class);
			config.addAnnotatedClass(Particular.class);
			config.addAnnotatedClass(Producto.class);
			config.addAnnotatedClass(Ubicacion.class);
			config.addAnnotatedClass(GPS.class);
			config.addAnnotatedClass(TipoSeguro.class);
			config.addAnnotatedClass(Tarifa.class);
			config.addAnnotatedClass(CompaniaSeguro.class);
			config.addAnnotatedClass(SolicitudEnvio.class);
			config.addAnnotatedClass(Carga.class);
			config.addAnnotatedClass(Empleado.class);
			config.addAnnotatedClass(Unidad.class);
			config.addAnnotatedClass(TipoVehiculo.class);
			config.addAnnotatedClass(Taller.class);
			config.addAnnotatedClass(Mantenimiento.class);
			config.addAnnotatedClass(Vehiculo.class);
			config.addAnnotatedClass(Tarea.class);
			config.addAnnotatedClass(VehiculoExterno.class);
			config.addAnnotatedClass(VehiculoPropio.class);
			config.addAnnotatedClass(Proveedor.class);
			config.addAnnotatedClass(ProveedorLocal.class);
			config.addAnnotatedClass(Carrier.class);
			config.addAnnotatedClass(CategoriaTratamiento.class);
			config.addAnnotatedClass(TipoCarga.class);
			config.addAnnotatedClass(Dimension.class);
			config.addAnnotatedClass(Sucursal.class);
			config.addAnnotatedClass(Remito.class);
			config.addAnnotatedClass(ItemRemito.class);
			config.addAnnotatedClass(Usuario.class);
			config.addAnnotatedClass(Factura.class);
			config.addAnnotatedClass(ItemFactura.class);
			config.addAnnotatedClass(ListaPrecios.class);
			config.addAnnotatedClass(PlanMantenimiento.class);
			config.addAnnotatedClass(Ruta.class);
			config.addAnnotatedClass(Viaje.class);
//			JOptionPane.showMessageDialog(null, "Antes del buildSessionFactory en el HUtil");
			sessionFactory = config.buildSessionFactory();
//			JOptionPane.showMessageDialog(null, "Despues del buildSessionFactory en el HUtil");
		}catch (Throwable e){
			JOptionPane.showMessageDialog(null, "En el catch del HUtil");
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
	}
	
	public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
