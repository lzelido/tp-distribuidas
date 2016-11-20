package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import service.IFacturaService;
import srv.CargaSRV;
import srv.ClienteSRV;
import srv.EmpleadoSRV;
import srv.FacturaSRV;
import srv.ItemFacturaSRV;
import srv.ListaPreciosSRV;
import srv.SolicitudEnvioSRV;
import srv.SucursalSRV;
import srv.ViajeSRV;
import dto.EmpleadoDTO;
import dto.FacturaDTO;
import dto.SolicitudEnvioDTO;
import dto.SucursalDTO;
import entities.Carga;
import entities.Cliente;
import entities.Empleado;
import entities.Empresa;
import entities.Factura;
import entities.ItemFactura;
import entities.ListaPrecios;
import entities.Particular;
import entities.SolicitudEnvio;
import entities.Sucursal;
import entities.Viaje;

public class FacturaController extends UnicastRemoteObject implements IFacturaService{
	private static final long serialVersionUID = -1058562641672618202L;

	// CONSTRUCTOR
	public FacturaController() throws RemoteException {
		super();
	}
	
	// ALTA
	//TODO:
	// TODO: Los errores los manejaria con exceptions...
	//TODO: 
	public int grabarFactura (SolicitudEnvioDTO solicitudDTO, EmpleadoDTO empleadoDTO, SucursalDTO sucursalDTO) throws RemoteException{
		try {
			SolicitudEnvio solicitud = (new SolicitudEnvioSRV()).buscarSolicitud(solicitudDTO.getCodigo());
			
			if (solicitud != null){
				Factura factura = new Factura();
				
				Cliente cliente = (new ClienteSRV()).buscarCliente(solicitudDTO.getCliente().getCodigo());
				if (cliente != null){
					factura.setCliente(cliente);
				}else{
					System.out.println("Error al grabar la factura (No existe el cliente)");
					return 0;
				}
				
				Date fechaAct = new java.sql.Date((new Date()).getTime());
				factura.setFechaEmision(fechaAct);
				
				Sucursal sucursal = (new SucursalSRV()).buscarSucursal(sucursalDTO.getCodigo());
				if (sucursal != null){
					factura.setSucursal(sucursal);
				}else{
					System.out.println("Error al grabar la factura (No existe la sucursal)");
					return 0;
				}
				
				Empleado empleado = (new EmpleadoSRV()).buscarEmpleado(empleadoDTO.getNumero());
				if (empleado != null){
					factura.setEmpleado(empleado);
				}else{
					System.out.println("Error al grabar la factura (No existe el empleado)");
					return 0;
				}
				
				//TODO:
				// TODO: No entiendo esto.. si ya tengo las cargas en la solicitud envio..
				//TODO:
				List<Carga> cargas = solicitud.getCargas();
				List<ItemFactura> items = new ArrayList<ItemFactura>();
				for (Carga carga : cargas){
					ItemFactura item = this.grabarItemFactura(carga);
					
					items.add(item);
				}
				factura.setItems(items);
				
				//TODO: esto lo cambiaria por: factura.setTotal(factura.calcularTotal())
				//TODO: sino (no se si esta bien) en el .calcularTotal() haria que se setee directamente.
				float total = factura.calcularTotal();
				factura.setTotal(total);
				factura.setSolicitudEnvio(solicitud);
				
				//TODO: Estos metodos los manejaria en la entidad, no en el contrller.
				(new FacturaSRV()).grabarFactura(factura);
				solicitud.setFactura(factura);
				
				(new SolicitudEnvioSRV()).grabarSolicitud(solicitud);
				
				System.out.println("La factura se grabó con éxito");
				return factura.getCodigo();
			}else{
				System.out.println("Error al grabar la factura (No existe la solicitud)");
				return 0;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar la factura");
			return 0;
		}
	}
	
	private ItemFactura grabarItemFactura (Carga cargaDTO){
		try {
			ItemFactura item = new ItemFactura();
			//ver cantidad siempre es 1
			//TODO: ves, aca pusieron este comentario, y me confirma mas que no tenga sentido el itemfactura.
			item.setCantidad(1);
			
			Carga carga = (new CargaSRV()).buscarCarga(cargaDTO.getCodigo());
			if (carga != null){
				item.setCarga(carga);
			}else{
				System.out.println("Error al grabar el ítemFactura (No existe carga)");
				return null;
			}

			//busco los precios que cummplen con la descripcion
			List<ListaPrecios> listaPreciosPorDescripcion = (new ListaPreciosSRV()).buscarListaPreciosPorDescripcion(carga.getTipoC().getDescri());
			float precioUnitario = listaPreciosPorDescripcion.get(0).getPrecio();
			if (listaPreciosPorDescripcion!=null){
				for (ListaPrecios lp : listaPreciosPorDescripcion) {
					//calculo los m3 de ese precio
					float m3 = (new ListaPreciosSRV()).calculoM3Item(lp);
					if(m3>=carga.getVolumen()&&lp.getPeso()>=carga.getPeso()&&precioUnitario>=lp.getPrecio()){
						precioUnitario = lp.getPrecio();
					}
				}
			}else{
				System.out.println("Error al grabar el ítemFactura (No existe Precio para esa Descripción)");
				return null;
			}
			
			//TODO: idem a lo de factura, me parece cabeza eso de llamar a calcular y despues a setear, declarando un float.
			item.setPrecioUnitario(precioUnitario);
			float subTotal = item.calcularSubtotal();
			item.setSubTotal(subTotal);
			
			(new ItemFacturaSRV()).grabarItemFactura(item);
			
			//TODO: item remito?????
			System.out.println("El ítemRemito se grabó con éxito");
			return item;
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al grabar el ítemFactura");
			return null;
		}
	}
	
	@Override
	public int pagarFactura (int codigoFactura){
		try {
			Factura factura = (new FacturaSRV()).buscarFactura(codigoFactura);
			if (factura != null){
				// TODO: Si me traje la factura de la base, ¿no me trae el cliente ya?
				// TODO: me parece mejor preguntar por instanceOf, por ejemplo.
				Particular clienteP = (new ClienteSRV()).buscarParticular(factura.getCliente().getCodigo());
				if (clienteP != null){
					factura.setPago(true);
					//TODO: Esto deberia llamarse actualizar factura.
					//TODO: recien veo que hay controller y service.. no me gusta
					(new FacturaSRV()).grabarFactura(factura);
					
					System.out.println("Se registró correctamente el pago de la factura");
					return 1;
				}else{
					Empresa clienteE = (new ClienteSRV()).buscarEmpresa(factura.getCliente().getCodigo());
					if (clienteE != null){
						float ctaCte = clienteE.getCtaCte() - factura.getTotal();
						clienteE.setCtaCte(ctaCte);
						factura.setPago(true);
						
						(new FacturaSRV()).grabarFactura(factura);
						(new ClienteSRV()).grabarCliente(clienteE);
						System.out.println("Se registró correctamente el pago de la factura");
						return 1;
					}else{
						System.out.println("Error al pagar la factura (No existe el cliente)");
						return 0;
					}
				}
			}else{
				System.out.println("Error al pagar la factura (No existe la factura)");
				return 0;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al pagar la factura");
			return 0;
		}
	}

	@Override
	public List<FacturaDTO> buscarFacturas(int codigoCliente)throws RemoteException {
		List<FacturaDTO> facturas = new ArrayList<FacturaDTO>();
		for(Factura f : (new FacturaSRV()).buscarFacturasCliente(codigoCliente)){
			FacturaDTO fDTO = new FacturaDTO();
			fDTO.setCodigo(f.getCodigo());
			fDTO.setFechaEmision(f.getFechaEmision());
			fDTO.setTotal(f.getTotal());
			facturas.add(fDTO);
		}		
		return facturas;
	}
	
	// MODIFICACION
	//TODO: EntregarCarga en FacturaController???? 
		public int entregarCarga (FacturaDTO facturaDTO, SucursalDTO sucDDTO){
			try {
				Factura factura = (new FacturaSRV()).buscarFactura(facturaDTO.getCodigo());
				if(factura != null){
					if(factura.isPago() != null && factura.isPago()){				
						
						List<ItemFactura> items = (new ItemFacturaSRV()).obtenerItems(facturaDTO.getCodigo());
					
						/* No me gusta como está este método, pero se planteo en un primer momento que 
						 * todas las cargas de cada solicitud de envío se mueven juntas en el mismo 
						 * viaje. */
						for(ItemFactura i : items){
							Carga carga = i.getCarga();
							Viaje viaje = (new ViajeSRV()).buscarViajeByCarga(carga.getCodigo());
							if (!viaje.isEntregado()){
								System.out.println("La carga no fue entregada en la sucursal");
								return 0;
							}
							carga.setEntregado(true);
							
							(new CargaSRV()).grabarCarga(carga);
						}
						
						System.out.println("Se registró correctamente la entrega de la carga");
						return 3;
					}else{
						System.out.println("La factura no está paga");
						return 2;
					}
				}else{
					System.out.println("La factura no existe");
					return 1;
				}				
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error al entregar la carga");
				return 0;
			}
		}
}
