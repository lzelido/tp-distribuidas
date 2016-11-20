package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import controlador.ClienteController;
import controlador.ProductoController;
import controlador.UbicacionController;
import dto.EmpresaDTO;
import dto.ProductoDTO;
import dto.UbicacionDTO;

public class ClienteEmpresaModificarView extends javax.swing.JDialog {
	private static final long serialVersionUID = 1L;
	private ImageIcon picture;
	private static EmpresaDTO empresaAct;
	private JTextField txtCodigo;
	private JSeparator jSeparator1;
	private JTextField txtTipoDoc;
	private JButton btnBuscar;
	private JLabel lblCodigo;
	private JLabel lblTipoDoc;
	private JTextField txtNroDoc;
	private JLabel lblNroDoc;
	private JLabel lblNombre;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JButton btnEliminarP;
	private JButton btnAgregarP;
	private JLabel lblProducto;
	private JButton btnEliminarD;
	private JButton btnAgregarD;
	private JLabel lblDestinos;
	private JTextField txtNombre;
	private JTextField txtMonto;
	private JTextField txtCtaCte;
	private JLabel lblCtaCte;
	private JLabel lblMontoMin;
	private JLabel lblManifiesto;
	@SuppressWarnings("rawtypes")
	private JComboBox cboManifiesto;
	@SuppressWarnings("unused")
	private JLabel lblPagoAdelantado;
	@SuppressWarnings({ "rawtypes", "unused" })
	private JComboBox cboPagoAdelantado;
	private JLabel lblDepositoPrevio;
	@SuppressWarnings("rawtypes")
	private JComboBox cboDepositoPrevio;
	private JLabel lblPagoMensual;
	@SuppressWarnings("rawtypes")
	private JComboBox cboPagoMensual;
	private JScrollPane jscrPanelD;
	@SuppressWarnings("rawtypes")
	private JList lstDestinos;
	private DefaultComboBoxModel<UbicacionDTO> listaDestinos;
	private Vector<UbicacionDTO> destinos;
	private JScrollPane jscrPanelP;
	@SuppressWarnings("rawtypes")
	private JList lstProductos;
	private DefaultComboBoxModel<ProductoDTO> listaProductos;
	private Vector<ProductoDTO> productos;
	private JButton btnModificarD;
	private JButton btnModificarP;
	private JTextField txtNroCte;
	private JLabel lblNroCte;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				JFrame frame = new JFrame();
				ClienteEmpresaModificarView inst = new ClienteEmpresaModificarView(empresaAct);
				inst.setVisible(true);
			}
		});
	}
	
	public ClienteEmpresaModificarView(EmpresaDTO empresa) {
		super();
		initGUI();
		this.loadData(empresa);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Modificaci�n de Empresa");
			picture = new ImageIcon("C:/Users/Facu/git/tpo_cliente-ad15/TPO_Cliente/picture/4.png");
			this.setIconImage(picture.getImage());
			{
				txtTipoDoc = new JTextField();
				getContentPane().add(txtTipoDoc);
				txtTipoDoc.setBounds(119, 12, 116, 23);
			}
			{
				lblTipoDoc = new JLabel();
				getContentPane().add(lblTipoDoc);
				lblTipoDoc.setText("Tipo Documento");
				lblTipoDoc.setBounds(11, 15, 96, 16);
			}
			{
				txtNroDoc = new JTextField();
				getContentPane().add(txtNroDoc);
				txtNroDoc.setBounds(373, 12, 160, 23);
			}
			{
				lblNroDoc = new JLabel();
				getContentPane().add(lblNroDoc);
				lblNroDoc.setText("Nro de Documento");
				lblNroDoc.setBounds(247, 15, 119, 16);
			}
			{
				btnBuscar = new JButton();
				getContentPane().add(btnBuscar);
				btnBuscar.setText("Buscar");
				btnBuscar.setBounds(457, 47, 76, 23);
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBuscar (evt);
					}
				});
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(11, 81, 522, 10);
			}
			{
				txtCodigo = new JTextField();
				getContentPane().add(txtCodigo);
				txtCodigo.setBounds(119, 47, 116, 23);
				txtCodigo.setEditable(false);
			}
			{
				lblCodigo = new JLabel();
				getContentPane().add(lblCodigo);
				lblCodigo.setText("C�digo");
				lblCodigo.setBounds(12, 50, 89, 16);
			}
			{
				lblNombre = new JLabel();
				getContentPane().add(lblNombre);
				lblNombre.setText("Nombre");
				lblNombre.setBounds(12, 100, 90, 16);
			}
			{
				txtNombre = new JTextField();
				getContentPane().add(txtNombre);
				txtNombre.setBounds(120, 97, 413, 23);
			}
			{
				txtNroCte = new JTextField();
				getContentPane().add(txtNroCte);
				txtNroCte.setBounds(120, 132, 168, 23);
			}
			{
				lblNroCte = new JLabel();
				getContentPane().add(lblNroCte);
				lblNroCte.setText("Nro. de Corriente");
				lblNroCte.setBounds(12, 135, 96, 16);
			}
			{
				lblCtaCte = new JLabel();
				getContentPane().add(lblCtaCte);
				lblCtaCte.setText("Cta. Corriente");
				lblCtaCte.setBounds(300, 135, 96, 16);
			}
			{
				txtCtaCte = new JTextField();
				getContentPane().add(txtCtaCte);
				txtCtaCte.setBounds(403, 132, 126, 23);
			}
			{
				txtMonto = new JTextField();
				getContentPane().add(txtMonto);
				txtMonto.setBounds(120, 167, 131, 23);
			}
			{
				txtMonto = new JTextField();
				getContentPane().add(txtMonto);
				txtMonto.setBounds(120, 167, 131, 23);
			}
			{
				lblMontoMin = new JLabel();
				getContentPane().add(lblMontoMin);
				lblMontoMin.setText("Monto M�n. Auto.");
				lblMontoMin.setBounds(12, 170, 108, 16);
			}
			{
				lblManifiesto = new JLabel();
				getContentPane().add(lblManifiesto);
				lblManifiesto.setText("Req. Manifiesto");
				lblManifiesto.setBounds(12, 205, 98, 16);
			}
			{
				ComboBoxModel tipoModel = 
						new DefaultComboBoxModel(
								new String[] { "Si", "No" });
				cboManifiesto = new JComboBox();
				getContentPane().add(cboManifiesto);
				cboManifiesto.setModel(tipoModel);
				cboManifiesto.setBounds(120, 202, 131, 23);
			}
			{
				lblDepositoPrevio = new JLabel();
				getContentPane().add(lblDepositoPrevio);
				lblDepositoPrevio.setText("Dep�sito Previo");
				lblDepositoPrevio.setBounds(12, 240, 101, 16);
			}
			{
				ComboBoxModel tipoModel = 
						new DefaultComboBoxModel(
								new String[] { "Si", "No" });
				cboDepositoPrevio = new JComboBox();
				getContentPane().add(cboDepositoPrevio);
				cboDepositoPrevio.setModel(tipoModel);
				cboDepositoPrevio.setBounds(120, 237, 131, 23);
				cboDepositoPrevio.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cboDepositoPrevio (evt);
					}
				});
			}
			{
				lblPagoMensual = new JLabel();
				getContentPane().add(lblPagoMensual);
				lblPagoMensual.setText("Pago Mensual");
				lblPagoMensual.setBounds(263, 240, 101, 16);
			}
			{
				ComboBoxModel tipoModel = 
						new DefaultComboBoxModel(
								new String[] { "Si", "No" });
				cboPagoMensual = new JComboBox();
				getContentPane().add(cboPagoMensual);
				cboPagoMensual.setModel(tipoModel);
				cboPagoMensual.setBounds(373, 237, 160, 23);
				cboPagoMensual.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cboPagoMensual (evt);
					}
				});
			}
			{
				jscrPanelD = new JScrollPane();
				getContentPane().add(jscrPanelD);
				jscrPanelD.setBounds(12, 305, 517, 100);
				{
					lstDestinos = new JList();
					getContentPane().add(lstDestinos);
					lstDestinos.setBounds(12, 355, 516, 221);
					jscrPanelD.setViewportView(lstDestinos);
					lstDestinos.setPreferredSize(new java.awt.Dimension(451, 100));

				}	
			}
			{
				lblDestinos = new JLabel();
				getContentPane().add(lblDestinos);
				lblDestinos.setText("Destinos");
				lblDestinos.setBounds(12, 279, 64, 16);
				lblDestinos.setFont(new Font("Calibri", Font.ITALIC, 14));
			}
			{
				btnAgregarD = new JButton();
				getContentPane().add(btnAgregarD);
				btnAgregarD.setText("Agregar");
				btnAgregarD.setBounds(162, 275, 115, 23);
				btnAgregarD.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAgregarD(evt);
					}
				});
			}
			{
				btnModificarD = new JButton();
				getContentPane().add(btnModificarD);
				btnModificarD.setText("Modificar");
				btnModificarD.setBounds(288, 275, 115, 23);
				btnModificarD.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnModificarD (evt);
					}
				});
			}
			{
				btnEliminarD = new JButton();
				getContentPane().add(btnEliminarD);
				btnEliminarD.setText("Eliminar");
				btnEliminarD.setBounds(414, 275, 115, 23);
				btnEliminarD.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnEliminarD(evt);
					}
				});

			}
			
			{
				jscrPanelP = new JScrollPane();
				getContentPane().add(jscrPanelP);
				jscrPanelP.setBounds(12, 455, 517, 100);
				{
					lstProductos = new JList();
					getContentPane().add(lstProductos);
					lstProductos.setBounds(12, 455, 516, 221);
					jscrPanelP.setViewportView(lstProductos);
					lstProductos.setPreferredSize(new java.awt.Dimension(451, 100));

				}	
			}
			{
				lblProducto = new JLabel();
				getContentPane().add(lblProducto);
				lblProducto.setText("Productos");
				lblProducto.setBounds(12, 428, 70, 16);
				lblProducto.setFont(new Font("Calibri", Font.ITALIC, 14));
			}
			{
				btnAgregarP = new JButton();
				getContentPane().add(btnAgregarP);
				btnAgregarP.setText("Agregar");
				btnAgregarP.setBounds(162, 424, 115, 23);
				btnAgregarP.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAgregarP (evt);
					}
				});
			}
			{
				btnModificarP = new JButton();
				getContentPane().add(btnModificarP);
				btnModificarP.setText("Modificar");
				btnModificarP.setBounds(288, 424, 115, 23);
				btnModificarP.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnModificarP (evt);
					}
				});
			}
			{
				btnEliminarP = new JButton();
				getContentPane().add(btnEliminarP);
				btnEliminarP.setText("Eliminar");
				btnEliminarP.setBounds(414, 424, 115, 23);
				btnEliminarP.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnEliminarP (evt);
					}
				});
			}
			{
				btnAceptar = new JButton();
				getContentPane().add(btnAceptar);
				btnAceptar.setText("Aceptar");
				btnAceptar.setBounds(12, 585, 108, 23);
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAceptar (evt);
					}
				});
			}
			{
				btnCancelar = new JButton();
				getContentPane().add(btnCancelar);
				btnCancelar.setText("Cancelar");
				btnCancelar.setBounds(421, 585, 108, 23);
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCancelar (evt);
					}
				});
			}
			this.setSize(561, 658);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void cboDepositoPrevio (ActionEvent evt){
		if(this.cboDepositoPrevio.getSelectedItem().toString().equals("Si")){
			this.cboPagoMensual.setSelectedItem("No");
		}else{
			if (this.cboDepositoPrevio.getSelectedItem().toString().equals("No")){
				this.cboPagoMensual.setSelectedItem("Si");
			}
		}
	}
	
	private void cboPagoMensual (ActionEvent evt){
		if(this.cboPagoMensual.getSelectedItem().toString().equals("Si")){
			this.cboDepositoPrevio.setSelectedItem("No");
		}else{
			if (this.cboPagoMensual.getSelectedItem().toString().equals("No")){
				this.cboDepositoPrevio.setSelectedItem("Si");
			}
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void loadData(EmpresaDTO empresa){
		try {
			if(empresa != null){
				empresaAct = ClienteController.getInstance().buscarClienteEmpresa (empresa.getCodigo());
				
				this.txtTipoDoc.setText(empresaAct.getTipoDoc());
				this.txtTipoDoc.setEditable(false);
				this.txtNroDoc.setText(empresaAct.getNroDoc());
				this.txtNroDoc.setEditable(false);
				this.txtCodigo.setText(String.valueOf(empresaAct.getCodigo()));
				this.txtNombre.setText(empresaAct.getNombre());
				this.txtNroCte.setText(empresaAct.getNroCuenta());
				this.txtCtaCte.setText(String.valueOf(empresaAct.getCtaCte()));
				this.txtCtaCte.setEditable(false);
				this.txtMonto.setText(String.valueOf(empresaAct.getMontoMinAutoriz()));
				
				boolean manifiesto = empresaAct.isReqManifiesto();
				if(manifiesto){
					this.cboManifiesto.setSelectedIndex(0);
				}else{
					this.cboManifiesto.setSelectedIndex(1);
				}
					
				boolean deposito = empresaAct.isEsDepositoPrevio();
				if(deposito){
					this.cboDepositoPrevio.setSelectedIndex(0);
				}else{
					this.cboDepositoPrevio.setSelectedIndex(1);
				}
				
				boolean mensual = empresaAct.isEsPagoMensual();
				if(mensual){
					this.cboPagoMensual.setSelectedIndex(0);
				}else{
					this.cboPagoMensual.setSelectedIndex(1);
				}
				
				this.destinos = UbicacionController.getInstance().buscarUbicacionesCliente(Integer.valueOf(this.txtCodigo.getText()));
				if (this.destinos == null){
					System.out.println("No hay destinos cargados para la empresa");
				}else{
					if (this.destinos.isEmpty()){
						System.out.println("No hay destinos cargados para la empresa");
					}else{
						this.listaDestinos = new DefaultComboBoxModel(destinos);
						this.lstDestinos.setModel(listaDestinos);
					}
				}
				
				this.productos = ProductoController.getInstance().buscarProductos (Integer.valueOf(this.txtCodigo.getText()));
				if (this.productos == null){
					System.out.println("No hay productos cargados para la empresa");
				}else{
					if(this.productos.isEmpty()){
						System.out.println("No hay productos cargados para la empresa");
					}else{
						this.listaProductos = new DefaultComboBoxModel(productos);
						this.lstProductos.setModel(listaProductos);
					}
				}
			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al cargar la pantalla de modificaci�n de una empresa: " + e.getMessage());
			System.out.println("Stack Trace al cargar la pantalla de alta de modificaci�n de una empresa: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void btnBuscar (ActionEvent evt){
		try {
			empresaAct = ClienteController.getInstance().buscarClienteEmpresa (this.txtTipoDoc.getText(), this.txtNroDoc.getText());
						
			if (empresaAct == null){
				String mensaje = "No existe la empresa";
				JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				this.dispose();
			}else{
				this.txtTipoDoc.setEditable(false);
				this.txtNroDoc.setEditable(false);
				this.txtCodigo.setText(String.valueOf(empresaAct.getCodigo()));
				this.txtNombre.setText(empresaAct.getNombre());
				this.txtNroCte.setText(empresaAct.getNroCuenta());
				this.txtCtaCte.setText(String.valueOf(empresaAct.getCtaCte()));
				this.txtCtaCte.setEditable(false);
				this.txtMonto.setText(String.valueOf(empresaAct.getMontoMinAutoriz()));
				
				boolean manifiesto = empresaAct.isReqManifiesto();
				if(manifiesto){
					this.cboManifiesto.setSelectedIndex(0);
				}else{
					this.cboManifiesto.setSelectedIndex(1);
				}
				
				boolean deposito = empresaAct.isEsDepositoPrevio();
				if(deposito){
					this.cboDepositoPrevio.setSelectedIndex(0);
				}else{
					this.cboDepositoPrevio.setSelectedIndex(1);
				}
				
				boolean mensual = empresaAct.isEsPagoMensual();
				if(mensual){
					this.cboPagoMensual.setSelectedIndex(0);
				}else{
					this.cboPagoMensual.setSelectedIndex(1);
				}
				
				this.destinos = UbicacionController.getInstance().buscarUbicacionesCliente(Integer.valueOf(this.txtCodigo.getText()));
				if (this.destinos == null){
					String mensaje = "No hay destinos cargados para la empresa";
					JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
				}else{
					if (this.destinos.isEmpty()){
						String mensaje = "No hay destinos cargados para la empresa";
						JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
					}else{
						this.listaDestinos = new DefaultComboBoxModel(destinos);
						this.lstDestinos.setModel(listaDestinos);
					}
				}
				
				this.productos = ProductoController.getInstance().buscarProductos(Integer.valueOf(this.txtCodigo.getText()));
				if (this.productos == null){
					String mensaje = "No hay productos cargados para la empresa";
					JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
				}else{
					if(this.productos.isEmpty()){
						String mensaje = "No hay productos cargados para la empresa";
						JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
					}else{
						this.listaProductos = new DefaultComboBoxModel(productos);
						this.lstProductos.setModel(listaProductos);
					}
				}
			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al buscar una empresa: " + e.getMessage());
			System.out.println("Stack Trace al buscar una empresa: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnAgregarD (ActionEvent evt){
		try {
			ClienteEmpresaModificarView.this.dispose();
			new UbicacionAltaView(empresaAct, null, null, null);
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al agregar un destino: " + e.getMessage());
			System.out.println("Stack Trace al agregar un destino: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnModificarD (ActionEvent evt){
		try {
			UbicacionDTO ubicacion = (UbicacionDTO) this.lstDestinos.getSelectedValue();
			if(ubicacion == null){
				JOptionPane.showMessageDialog(this, "Debe seleccionar por lo menos un destino", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				ClienteEmpresaModificarView.this.dispose();
				new UbicacionModificarView(ubicacion, empresaAct, null, null, null);
			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al agregar un destino: " + e.getMessage());
			System.out.println("Stack Trace al agregar un destino: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void btnEliminarD(ActionEvent evt){
		try {
			UbicacionDTO destino = (UbicacionDTO) this.lstDestinos.getSelectedValue();
			if(destino == null){
				JOptionPane.showMessageDialog(this, "Debe seleccionar por lo menos un destino", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				for(int i=0; i<this.destinos.size(); i++){
					if(destino.getCodPost().equals(this.destinos.get(i).getCodPost())){
						if (destino.getCalle().equals(this.destinos.get(i).getCalle())){
							if(destino.getNumero() == this.destinos.get(i).getNumero()){
								if (destino.getPiso() == this.destinos.get(i).getPiso()){
									if(destino.getDepto().equals(this.destinos.get(i).getDepto())){
										int check = UbicacionController.getInstance().eliminarUbicacionCliente(Integer.valueOf(this.txtCodigo.getText()), this.destinos.get(i));
										if(check == 3){
											this.destinos.remove(this.destinos.get(i));
											this.listaDestinos = new DefaultComboBoxModel(this.destinos);
											this.lstDestinos.setModel(this.listaDestinos);
										}else{
											if (check == 2){
												String mensaje = "El destino no existe para la empresa";
												JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
											}else{
												if (check == 1){
													String mensaje = "La empresa no existe";
													JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
												}else{
													String mensaje = "Error al eliminar el destino";
													JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al eliminar un destino: " + e.getMessage());
			System.out.println("Stack Trace al eliminar un destino: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnAgregarP (ActionEvent evt){
		try {
			ClienteEmpresaModificarView.this.dispose();
			new ProductoAltaView(empresaAct);
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al agregar un producto: " + e.getMessage());
			System.out.println("Stack Trace al agregar un producto: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnModificarP (ActionEvent evt){
		try {
			ProductoDTO producto = (ProductoDTO) this.lstProductos.getSelectedValue();
			if(producto == null){
				JOptionPane.showMessageDialog(this, "Debe seleccionar pot lo menos un producto", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				ClienteEmpresaModificarView.this.dispose();
				new ProductoModificarView(empresaAct, producto);
			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al modificar un producto: " + e.getMessage());
			System.out.println("Stack Trace al modificar un producto: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void btnEliminarP(ActionEvent evt){
		try {
			ProductoDTO producto = (ProductoDTO) this.lstProductos.getSelectedValue();
			if(producto == null){
				JOptionPane.showMessageDialog(this, "Debe seleccionar pot lo menos un producto", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				for(int i=0; i<this.productos.size(); i++){
					if(producto.getCodigo() == this.productos.get(i).getCodigo()){
						int check = ProductoController.getInstance().eliminarProducto(Integer.valueOf(this.txtCodigo.getText()), this.productos.get(i));
						if(check == 3){
							this.productos.remove(this.productos.get(i));
							this.listaProductos = new DefaultComboBoxModel(this.productos);
							this.lstProductos.setModel(this.listaProductos);
						}else{
							if (check == 2){
								String mensaje = "El producto no existe para la empresa";
								JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
							}else{
								if (check == 1){
									String mensaje = "La empresa no existe";
									JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
								}else{
									String mensaje = "Error al eliminar el producto";
									JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						}
					}
				}
			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al eliminar un producto: " + e.getMessage());
			System.out.println("Stack Trace al eliminar un producto: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnAceptar (ActionEvent evt){
		try{
			int response = JOptionPane.showConfirmDialog(null,"�Esta seguro que desea continuar?\nEsta acci�n no puede deshacerse.", "Confirmaci�n", JOptionPane.YES_NO_OPTION);
			if(response == JOptionPane.NO_OPTION){
				return;
			}else{
				if (response == JOptionPane.YES_OPTION){
					empresaAct.setNombre(this.txtNombre.getText());
					empresaAct.setNroCuenta(this.txtNroCte.getText());
					empresaAct.setCtaCte(Float.valueOf(this.txtCtaCte.getText()));
					empresaAct.setMontoMinAutoriz(Float.parseFloat(this.txtMonto.getText()));
					
					boolean manifiesto = false;
					if(this.cboManifiesto.getSelectedItem().toString().equals("Si"))
						manifiesto = true;
					empresaAct.setReqManifiesto(manifiesto);
					
					boolean deposito = false;
					if(this.cboDepositoPrevio.getSelectedItem().toString().equals("Si"))
						deposito = true;
					empresaAct.setEsDepositoPrevio(deposito);
					
					boolean mensual = false;
					if(this.cboPagoMensual.getSelectedItem().toString().equals("Si"))
						mensual = true;
					empresaAct.setEsPagoMensual(mensual);
					
					empresaAct.setDestinos(this.destinos);
					empresaAct.setProductos(this.productos);
					
					int check = 0;
					check = ClienteController.getInstance().modificarClienteEmpresa(empresaAct);
					if (check == 2){
						String mensaje = "Se modific� la empresa";
						JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
					}else{
						if (check == 1){
							String mensaje = "La empresa no existe";
							JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
						}else{
							String mensaje = "Falla en la modificaci�n de la empresa";
							JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
					
					ClienteEmpresaModificarView.this.dispose();
//					new Principal();
				}
			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al modificar una empresa: " + e.getMessage());
			System.out.println("Stack Trace al modificar una empresa: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnCancelar (ActionEvent evt){
		try{
			ClienteEmpresaModificarView.this.dispose();
//			new Principal();
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al cancelar la modificaci�n de una empresa: " + e.getMessage());
			System.out.println("Stack Trace al cancelar la modificaci�n de una empresa: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
