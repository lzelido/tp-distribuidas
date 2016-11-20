package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class AdministracionView extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private JMenuBar jMenuBarMenuPrincipal;
	private JSeparator jSeparator2;
	private JMenuItem jMenuItemBajaSucursal;
	private JMenuItem jMenuItemAltaSucursal;
	private JMenuItem jMenuItemModificarVehiculosPropio;
	private JMenuItem jMenuItemAltaVehiculosPropio;
	private JMenuItem jMenuItemAltaVehiculosExternos;
	private JMenuItem jMenuItemEmpleadoModificar;
	private JMenuItem jMenuItemEmpleadoBaja;
	private JMenuItem jMenuItemEmpleadoAlta;
	private JMenuItem jMenuItemClienteEmpresaModificar;
	private JMenuItem jMenuItemClienteEmpresaBaja;
	private JMenuItem jMenuItemClienteEmpresaAlta;
	private JMenuItem jMenuItemClienteParticularModificar;
	private JMenuItem jMenuItemClienteParticularBaja;
	private JMenuItem jMenuItemClienteParticularAlta;
	private JMenu jMenuClienteEmpresa;
	private JMenu jMenuClienteParticular;
	private JMenuItem jMenuItemModificarTarifa;
	private JMenuItem jMenuItemBajaTarifa;
	private JMenuItem jMenuItemAltaTarifa;
	private JMenuItem jMenuItemModificarCompaniaSeguro;
	private JMenuItem jMenuItemBajaCompaniaSeguro;
	private JMenuItem jMenuItemAltaCompaniaSeguro;
	private JMenu jMenuTarifas;
	private JMenu jMenuCompaniasDeSeguros;
	private JMenuItem jMenuItemModificarListaPrecios;
	private JMenuItem jMenuItemBajaListaPrecios;
	private JMenuItem jMenuItemAltaListaPrecios;
	private JMenuItem jMenuItemModificarSucursal;
	private JMenu jMenuListaPrecios;
	private JSeparator jSeparator4;
	private JMenu jMenuSucursales;
	private JSeparator jSeparator3;
	private JSeparator jSeparator5;
	private JSeparator jSeparator6;
	private JMenu jMenuCompaniasSeguro;
	private JMenu jMenuVehiculos;
	private JSeparator jSeparator1;
	private JMenu jMenuEmpleados;
	private JMenu jMenu1;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AdministracionView inst = new AdministracionView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public AdministracionView() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			this.setTitle("MENÚ ADMINISITRACIÓN");

			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jMenuBarMenuPrincipal = new JMenuBar();
				setJMenuBar(jMenuBarMenuPrincipal);
				{
					jMenu1 = new JMenu();
					jMenuBarMenuPrincipal.add(jMenu1);
					jMenu1.setText("ADMINISTRACIÓN");
					{
						jMenuEmpleados = new JMenu();
						jMenu1.add(jMenuEmpleados);
						jMenuEmpleados.setText("Empleados");
						{
							jMenuItemEmpleadoAlta = new JMenuItem();
							jMenuEmpleados.add(jMenuItemEmpleadoAlta);
							jMenuItemEmpleadoAlta.setText("Alta de Empleado");
							jMenuItemEmpleadoAlta
									.addActionListener(new ActionListener() {
										public void actionPerformed(
												ActionEvent evt) {
											jMenuItemEmpleadoAlta(evt);

										}
									});
						}
						{
							jMenuItemEmpleadoBaja = new JMenuItem();
							jMenuEmpleados.add(jMenuItemEmpleadoBaja);
							jMenuItemEmpleadoBaja.setText("Baja de Empleado");
							jMenuItemEmpleadoBaja
									.addActionListener(new ActionListener() {
										public void actionPerformed(
												ActionEvent evt) {
											jMenuItemEmpleadoBaja(evt);

										}
									});
						}
						{
							jMenuItemEmpleadoModificar = new JMenuItem();
							jMenuEmpleados.add(jMenuItemEmpleadoModificar);
							jMenuItemEmpleadoModificar
									.setText("Modificar Empleado");
							jMenuItemEmpleadoModificar
									.addActionListener(new ActionListener() {
										public void actionPerformed(
												ActionEvent evt) {
											jMenuItemEmpleadoModificar(evt);

										}
									});
						}
					}
					{
						jSeparator1 = new JSeparator();
						jMenu1.add(jSeparator1);
					}
					{
						jMenuVehiculos = new JMenu();
						jMenu1.add(jMenuVehiculos);
						jMenuVehiculos.setText("Vehiculos");
						{
							jMenuItemAltaVehiculosExternos = new JMenuItem();
							jMenuVehiculos.add(jMenuItemAltaVehiculosExternos);
							jMenuItemAltaVehiculosExternos
									.setText("Alta de Vehiculo Externo");
							jMenuItemAltaVehiculosExternos
									.addActionListener(new ActionListener() {
										public void actionPerformed(
												ActionEvent evt) {
											jMenuItemAltaVehiculosExternos(evt);

										}
									});
						}
						{
							jMenuItemAltaVehiculosPropio = new JMenuItem();
							jMenuVehiculos.add(jMenuItemAltaVehiculosPropio);
							jMenuItemAltaVehiculosPropio
									.setText("Alta Vehiculo Propio");
							jMenuItemAltaVehiculosPropio
									.addActionListener(new ActionListener() {
										public void actionPerformed(
												ActionEvent evt) {
											jMenuItemAltaVehiculosPropio(evt);

										}
									});
						}
						{
							jMenuItemModificarVehiculosPropio = new JMenuItem();
							jMenuVehiculos
									.add(jMenuItemModificarVehiculosPropio);
							jMenuItemModificarVehiculosPropio
									.setText("Modif Vehiculo Propio");
							jMenuItemModificarVehiculosPropio
									.addActionListener(new ActionListener() {
										public void actionPerformed(
												ActionEvent evt) {
											jMenuItemModificarVehiculosPropio(evt);

										}
									});
						}
					}
					{
						jSeparator2 = new JSeparator();
						jMenu1.add(jSeparator2);
					}
					{
						jMenuCompaniasSeguro = new JMenu();
						jMenu1.add(jMenuCompaniasSeguro);
						jMenuCompaniasSeguro.setText("Seguros");

						{
							jMenuCompaniasDeSeguros = new JMenu();
							jMenuCompaniasSeguro.add(jMenuCompaniasDeSeguros);
							jMenuCompaniasDeSeguros
									.setText("Companias de Seguros");
							{
								jMenuItemAltaCompaniaSeguro = new JMenuItem();
								jMenuCompaniasDeSeguros
										.add(jMenuItemAltaCompaniaSeguro);
								jMenuItemAltaCompaniaSeguro
										.setText("Alta de Compania Seguro");
								jMenuItemAltaCompaniaSeguro
										.addActionListener(new ActionListener() {
											public void actionPerformed(
													ActionEvent evt) {
												jMenuItemAltaCompaniasSeguro(evt);

											}
										});
							}
							{
								jMenuItemBajaCompaniaSeguro = new JMenuItem();
								jMenuCompaniasDeSeguros
										.add(jMenuItemBajaCompaniaSeguro);
								jMenuItemBajaCompaniaSeguro
										.setText("Baja de Compania Seguro");
								jMenuItemBajaCompaniaSeguro
										.addActionListener(new ActionListener() {
											public void actionPerformed(
													ActionEvent evt) {
												jMenuItemBajaCompaniasSeguros(evt);

											}
										});
							}
							{
								jMenuItemModificarCompaniaSeguro = new JMenuItem();
								jMenuCompaniasDeSeguros
										.add(jMenuItemModificarCompaniaSeguro);
								jMenuItemModificarCompaniaSeguro
										.setText("Modificar Compania Seguro");
								jMenuItemModificarCompaniaSeguro
										.addActionListener(new ActionListener() {
											public void actionPerformed(
													ActionEvent evt) {
												jMenuItemModificarCompaniasSeguros(evt);

											}
										});
							}
						}
						{
							jMenuTarifas = new JMenu();
							jMenuCompaniasSeguro.add(jMenuTarifas);
							jMenuTarifas.setText("Tarifas");
							{
								jMenuItemAltaTarifa = new JMenuItem();
								jMenuTarifas.add(jMenuItemAltaTarifa);
								jMenuItemAltaTarifa.setText("Alta Tarifa");
								jMenuItemAltaTarifa
										.addActionListener(new ActionListener() {
											public void actionPerformed(
													ActionEvent evt) {
												jMenuItemAltaTarifa(evt);

											}
										});
							}
							{
								jMenuItemBajaTarifa = new JMenuItem();
								jMenuTarifas.add(jMenuItemBajaTarifa);
								jMenuItemBajaTarifa.setText("Baja Tarifa");
								jMenuItemBajaTarifa
										.addActionListener(new ActionListener() {
											public void actionPerformed(
													ActionEvent evt) {
												jMenuItemBajaTarifa(evt);

											}
										});

							}
							{
								jMenuItemModificarTarifa = new JMenuItem();
								jMenuTarifas.add(jMenuItemModificarTarifa);
								jMenuItemModificarTarifa
										.setText("Modificar Tarifa");
								jMenuItemModificarTarifa
										.addActionListener(new ActionListener() {
											public void actionPerformed(
													ActionEvent evt) {
												jMenuItemModificarTarifa(evt);

											}
										});
							}
						}
					}
					{
						jSeparator3 = new JSeparator();
						jMenu1.add(jSeparator3);
					}
					{
						jMenuSucursales = new JMenu();
						jMenu1.add(jMenuSucursales);
						jMenuSucursales.setText("Sucursales");
						{
							jMenuItemAltaSucursal = new JMenuItem();
							jMenuSucursales.add(jMenuItemAltaSucursal);
							jMenuItemAltaSucursal.setText("Alta de Sucursal");
							jMenuItemAltaSucursal
									.addActionListener(new ActionListener() {
										public void actionPerformed(
												ActionEvent evt) {
											jMenuItemAltaSucursal(evt);

										}
									});
						}
						{
							jMenuItemBajaSucursal = new JMenuItem();
							jMenuSucursales.add(jMenuItemBajaSucursal);
							jMenuItemBajaSucursal.setText("Baja de Sucursal");
							jMenuItemBajaSucursal
									.addActionListener(new ActionListener() {
										public void actionPerformed(
												ActionEvent evt) {
											jMenuItemBajaSucursal(evt);

										}
									});
						}
						{
							jMenuItemModificarSucursal = new JMenuItem();
							jMenuSucursales.add(jMenuItemModificarSucursal);
							jMenuItemModificarSucursal
									.setText("Modificar Sucursal");
							jMenuItemModificarSucursal
									.addActionListener(new ActionListener() {
										public void actionPerformed(
												ActionEvent evt) {
											jMenuItemModificarSucursal(evt);

										}
									});
						}
					}
					{
						jSeparator4 = new JSeparator();
						jMenu1.add(jSeparator4);
					}
					{
						jMenuListaPrecios = new JMenu();
						jMenu1.add(jMenuListaPrecios);
						jMenuListaPrecios.setText("Lista Precios");
						{
							jMenuItemAltaListaPrecios = new JMenuItem();
							jMenuListaPrecios.add(jMenuItemAltaListaPrecios);
							jMenuItemAltaListaPrecios
									.setText("Alta Lista de Precios");
							jMenuItemAltaListaPrecios
									.addActionListener(new ActionListener() {
										public void actionPerformed(
												ActionEvent evt) {
											jMenuItemAltaListaPrecios(evt);

										}
									});
						}
						{
							jMenuItemBajaListaPrecios = new JMenuItem();
							jMenuListaPrecios.add(jMenuItemBajaListaPrecios);
							jMenuItemBajaListaPrecios
									.setText("Baja Lista de Precios");
						}
						{
							jMenuItemModificarListaPrecios = new JMenuItem();
							jMenuListaPrecios
									.add(jMenuItemModificarListaPrecios);
							jMenuItemModificarListaPrecios
									.setText("Modificar Lista de Precios");
						}
					}
				}
				jSeparator5 = new JSeparator();
				jMenu1.add(jSeparator5);

				{
					jMenuClienteParticular = new JMenu();
					jMenu1.add(jMenuClienteParticular);
					jMenuClienteParticular.setText("Cliente Particular");
					{
						jMenuItemClienteParticularAlta = new JMenuItem();
						jMenuClienteParticular
								.add(jMenuItemClienteParticularAlta);
						jMenuItemClienteParticularAlta
								.setText("Alta de Cliente Particular");
						jMenuItemClienteParticularAlta
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jMenuItemClienteParticularAlta(evt);

									}
								});
					}
					jSeparator6 = new JSeparator();
					jMenu1.add(jSeparator6);
					{
						jMenuItemClienteParticularBaja = new JMenuItem();
						jMenuClienteParticular
								.add(jMenuItemClienteParticularBaja);
						jMenuItemClienteParticularBaja
								.setText("Baja de Cliente Particular");
						jMenuItemClienteParticularBaja
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jMenuItemClienteParticularBaja(evt);

									}
								});
					}
					{
						jMenuItemClienteParticularModificar = new JMenuItem();
						jMenuClienteParticular
								.add(jMenuItemClienteParticularModificar);
						jMenuItemClienteParticularModificar
								.setText("Modificar Cliente Particular");
						jMenuItemClienteParticularModificar
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jMenuItemClienteParticularModificar(evt);

									}
								});
					}
				}
				{
					jMenuClienteEmpresa = new JMenu();
					jMenu1.add(jMenuClienteEmpresa);
					jMenuClienteEmpresa.setText("ClienteEmpresa");
					{
						jMenuItemClienteEmpresaAlta = new JMenuItem();
						jMenuClienteEmpresa.add(jMenuItemClienteEmpresaAlta);
						jMenuItemClienteEmpresaAlta
								.setText("Alta de Cliente Empresa");
						jMenuItemClienteEmpresaAlta
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jMenuItemClienteEmpresaAlta(evt);

									}
								});
					}
					{
						jMenuItemClienteEmpresaBaja = new JMenuItem();
						jMenuClienteEmpresa.add(jMenuItemClienteEmpresaBaja);
						jMenuItemClienteEmpresaBaja
								.setText("Baja de Cliente Empresa");
						jMenuItemClienteEmpresaBaja
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jMenuItemClienteEmpresBaja(evt);

									}
								});
					}
					{
						jMenuItemClienteEmpresaModificar = new JMenuItem();
						jMenuClienteEmpresa
								.add(jMenuItemClienteEmpresaModificar);
						jMenuItemClienteEmpresaModificar
								.setText("Modificar Cliente Empresa");
						jMenuItemClienteEmpresaModificar
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jMenuItemClienteEmpresModificar(evt);

									}
								});
					}
				}
			}

			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jMenuItemEmpleadoAlta(ActionEvent evt) {
		try {
			new EmpleadoAltaView();
		} catch (Exception e) {
			System.out.println("Mensaje Error " + e.getMessage());
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItemEmpleadoBaja(ActionEvent evt) {
		try {
			new EmpleadoBajaView();
		} catch (Exception e) {
			System.out.println("Mensaje Error " + e.getMessage());
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItemEmpleadoModificar(ActionEvent evt) {
		try {
			new EmpleadoModificarView();
		} catch (Exception e) {
			System.out.println("Mensaje Error " + e.getMessage());
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItemAltaCompaniasSeguro(ActionEvent evt) {
		try {
			new CompaniaSeguroAltaView();
		} catch (Exception e) {
			System.out.println("Mensaje Error " + e.getMessage());
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItemBajaCompaniasSeguros(ActionEvent evt) {
		try {
			new CompaniaSeguroEliminar();
		} catch (Exception e) {
			System.out.println("Mensaje Error " + e.getMessage());
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItemModificarCompaniasSeguros(ActionEvent evt) {
		try {
			new CompaniaSeguroModificarView();
		} catch (Exception e) {
			System.out.println("Mensaje Error " + e.getMessage());
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItemAltaSucursal(ActionEvent evt) {
		try {
			new SucursalAltaView();
		} catch (Exception e) {
			System.out
					.println("Mensaje Error al queres abrir la pantalla del Menn Principal - Alta de Sucursales: "
							+ e.getMessage());
			System.out
					.println("Stack Trace al queres abrir la pantalla del Menn Principal - Alta de Sucursales: "
							+ e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItemBajaSucursal(ActionEvent evt) {
		try {
			new SucursalBajaView();
		} catch (Exception e) {
			System.out
					.println("Mensaje Error al queres abrir la pantalla del Menn Principal - Baja de Sucursales: "
							+ e.getMessage());
			System.out
					.println("Stack Trace al queres abrir la pantalla del Menn Principal - Baja de Sucursales: "
							+ e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItemModificarSucursal(ActionEvent evt) {
		try {
			new SucursalModificarView();
		} catch (Exception e) {
			System.out.println("Mensaje Error " + e.getMessage());
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItemAltaTarifa(ActionEvent evt) {
		try {
			new TarifaAltaView();
		} catch (Exception e) {
			System.out.println("Mensaje Error " + e.getMessage());
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItemBajaTarifa(ActionEvent evt) {
		try {
			new TarifaEliminarView();
		} catch (Exception e) {
			System.out.println("Mensaje Error " + e.getMessage());
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItemModificarTarifa(ActionEvent evt) {
		try {
			new TarifaModificarView();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItemClienteParticularAlta(ActionEvent evt) {
		try {
			new ClienteParticularAltaView();
		} catch (Exception e) {
			System.out.println("Mensaje Error " + e.getMessage());
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItemClienteParticularBaja(ActionEvent evt) {
		try {
			new ClienteParticularBajaView();
		} catch (Exception e) {
			System.out.println("Mensaje Error " + e.getMessage());
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItemClienteParticularModificar(ActionEvent evt) {
		try {
			new ClienteParticularModificarView();
		} catch (Exception e) {
			System.out.println("Mensaje Error " + e.getMessage());
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItemClienteEmpresaAlta(ActionEvent evt) {
		try {
			new ClienteEmpresaAltaView();
		} catch (Exception e) {
			System.out.println("Mensaje Error " + e.getMessage());
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItemClienteEmpresBaja(ActionEvent evt) {
		try {
			new ClienteEmpresaBajaView();
		} catch (Exception e) {
			System.out.println("Mensaje Error " + e.getMessage());
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItemClienteEmpresModificar(ActionEvent evt) {
		try {
			new ClienteEmpresaModificarView(null);
		} catch (Exception e) {
			System.out.println("Mensaje Error " + e.getMessage());
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItemAltaVehiculosExternos(ActionEvent evt) {
		try {
			new VehiculoExternoAltaView(null);
		} catch (Exception e) {
			System.out.println("Mensaje Error " + e.getMessage());
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItemAltaVehiculosPropio(ActionEvent evt) {
		try {
			new VehiculoPropioAltaView(null);
		} catch (Exception e) {
			System.out.println("Mensaje Error " + e.getMessage());
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItemModificarVehiculosPropio(ActionEvent evt) {
		try {
			new VehiculoPropioModificarView(null);
		} catch (Exception e) {
			System.out.println("Mensaje Error " + e.getMessage());
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItemAltaListaPrecios(ActionEvent evt) {
		try {
			new ListaPreciosView();
		} catch (Exception e) {
			System.out.println("Mensaje Error " + e.getMessage());
			JOptionPane.showMessageDialog(this, e, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
