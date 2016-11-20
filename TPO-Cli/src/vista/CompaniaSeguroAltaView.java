package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.CompaniaSeguroController;
import controlador.TarifaController;
import dto.CompaniaSeguroDTO;
import dto.TarifaDTO;
import dto.TipoSeguroDTO;
import enums.Fragilidad;

public class CompaniaSeguroAltaView extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JLabel jLabelCodigo;
	private JSeparator jSeparator1;
	private JLabel jLabelTarifas;
	private JTextField jTextFieldDescripcionMercaderia;
	private JTextField jTextFieldDescripcionSeguro;
	private JLabel jLabelTipoMercaderia;
	private JLabel jLabelTipoSeguro;
	private JButton jButtonSalir;
	private JButton jButtonAlta;
	private JSeparator jSeparator2;
	private JButton jButtonAgregar;
	private JButton jButtonBuscarTarifa;
	private JTextField jTextFieldCodigoTarifa;
	private JLabel jLabelCodigoTarifa;
	private JTextField jTextFieldDescripcion;
	private JTextField jTextFieldCodigo;
	private JLabel jLabelDescripcion;
	private static TarifaDTO tarifaAct;
	private static Vector<TarifaDTO> tarifasAct;
	private static TipoSeguroDTO tipoSeguroAct;
	private static Fragilidad tipoMercaderiaAct;
	private Vector<TarifaDTO> productos;
	@SuppressWarnings("rawtypes")
	private JList lstProductos;
	private DefaultComboBoxModel<TarifaDTO> listaProductos;
	
	private JScrollPane jscrPanelP;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CompaniaSeguroAltaView inst = new CompaniaSeguroAltaView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public CompaniaSeguroAltaView() {
		super();
		initGUI();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		tarifasAct = new Vector<TarifaDTO>();
	}
	
	@SuppressWarnings("rawtypes")
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Alta Compañía de Seguro");
			{
				jLabelCodigo = new JLabel();
				getContentPane().add(jLabelCodigo);
				jLabelCodigo.setText("Código :");
				jLabelCodigo.setBounds(26, 22, 59, 16);
			}
			{
				jLabelDescripcion = new JLabel();
				getContentPane().add(jLabelDescripcion);
				jLabelDescripcion.setText("Descripción :");
				jLabelDescripcion.setBounds(26, 50, 77, 20);
			}
			{
				jTextFieldCodigo = new JTextField();
				getContentPane().add(jTextFieldCodigo);
				jTextFieldCodigo.setBounds(108, 16, 88, 28);
			}
			{
				jTextFieldDescripcion = new JTextField();
				getContentPane().add(jTextFieldDescripcion);
				jTextFieldDescripcion.setBounds(109, 46, 238, 28);
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(0, 86, 385, 13);
			}
			{
				jLabelTarifas = new JLabel();
				getContentPane().add(jLabelTarifas);
				jLabelTarifas.setText("Tarifas");
				jLabelTarifas.setBounds(26, 98, 38, 16);
			}
			{
				jLabelCodigoTarifa = new JLabel();
				getContentPane().add(jLabelCodigoTarifa);
				jLabelCodigoTarifa.setText("Código :");
				jLabelCodigoTarifa.setBounds(26, 126, 46, 16);
			}
			{
				jTextFieldCodigoTarifa = new JTextField();
				getContentPane().add(jTextFieldCodigoTarifa);
				jTextFieldCodigoTarifa.setBounds(109, 120, 87, 28);
			}
			{
				jButtonBuscarTarifa = new JButton();
				getContentPane().add(jButtonBuscarTarifa);
				jButtonBuscarTarifa.setText("Buscar");
				jButtonBuscarTarifa.setBounds(202, 120, 67, 28);
				jButtonBuscarTarifa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBuscarTarifa (evt);
					}
				});
			}
			{
				jButtonAgregar = new JButton();
				getContentPane().add(jButtonAgregar);
				jButtonAgregar.setText("Agregar");
				jButtonAgregar.setBounds(275, 120, 71, 28);
				jButtonAgregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						try {
							btnAgregar (evt);
						} catch (NumberFormatException | RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
			}
			{
				jSeparator2 = new JSeparator();
				getContentPane().add(jSeparator2);
				jSeparator2.setBounds(0, 368, 385, 13);
			}
			/*{
				jTextAreaTarifas = new JTextArea();
				getContentPane().add(jTextAreaTarifas);
				jTextAreaTarifas.setBounds(26, 232, 321, 124);
			}*/
			
			{
				jscrPanelP = new JScrollPane();
				getContentPane().add(jscrPanelP);
				jscrPanelP.setBounds(26, 232, 321, 124);
				{
					lstProductos = new JList();
					getContentPane().add(lstProductos);
					lstProductos.setBounds(26, 232, 321, 124);
					jscrPanelP.setViewportView(lstProductos);
					lstProductos.setPreferredSize(new java.awt.Dimension(451, 100));

				}	
			}
			

			
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(221, 387, 77, 25);
				jButtonSalir.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dispose();
					}
				});
			}
			{
				jLabelTipoSeguro = new JLabel();
				getContentPane().add(jLabelTipoSeguro);
				jLabelTipoSeguro.setText("Tipo Seguro :");
				jLabelTipoSeguro.setBounds(26, 160, 73, 16);
			}
			{
				jLabelTipoMercaderia = new JLabel();
				getContentPane().add(jLabelTipoMercaderia);
				jLabelTipoMercaderia.setText("Tipo Mercadería :");
				jLabelTipoMercaderia.setBounds(26, 198, 94, 16);
			}
			{
				jTextFieldDescripcionSeguro = new JTextField();
				getContentPane().add(jTextFieldDescripcionSeguro);
				jTextFieldDescripcionSeguro.setBounds(131, 154, 215, 28);
			}
			{
				jTextFieldDescripcionMercaderia = new JTextField();
				getContentPane().add(jTextFieldDescripcionMercaderia);
				jTextFieldDescripcionMercaderia.setBounds(132, 192, 214, 28);
			}
			
			{
				jButtonAlta = new JButton();
				getContentPane().add(jButtonAlta);
				jButtonAlta.setText("Alta");
				jButtonAlta.setBounds(72, 387, 67, 28);
				jButtonAlta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						CompaniaSeguroDTO companiaSeguro = new CompaniaSeguroDTO();
						companiaSeguro.setCodigo(Integer.parseInt(jTextFieldCodigo.getText()));
						companiaSeguro.setDescripcion(jTextFieldDescripcion.getText());
						companiaSeguro.setTarifas(tarifasAct);
						int check = 0;
						check = CompaniaSeguroController.getInstance().darDeAltaCompaniaSeguro(companiaSeguro);
						if (check == 2){
							String mensaje = "Se dio de alta la nueva Compañía de Seguro";
							JOptionPane.showMessageDialog(null, mensaje, "Ok", JOptionPane.INFORMATION_MESSAGE);
						}else{
							if(check == 1){
								String mensaje = "La Compañía de Seguro ya existe";
								JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
							}else{
								String mensaje = "Falla en el alta de la nueva Compañía de Seguro";
								JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
							}
						}
						
						dispose();		
						
					}
				});
			}
			
			pack();
			this.setSize(400, 467);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnBuscarTarifa (ActionEvent evt){
		try {
			
			tarifaAct = TarifaController.getInstance().buscarTarifa(Integer.parseInt(this.jTextFieldCodigoTarifa.getText()));
			
			if (tarifaAct == null){
				String mensaje = "No existe la Tarifa";
				JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				this.dispose();
			}else{
				this.jTextFieldDescripcionSeguro.setText(tarifaAct.getTipoSeguro().getDescripcion());
				this.jTextFieldDescripcionMercaderia.setText(tarifaAct.getFragilidad());

			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al buscar la Tarifa: " + e.getMessage());
			System.out.println("Stack Trace al buscar la Tarifa: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@SuppressWarnings({ "unchecked", "static-access", "rawtypes" })
	private void btnAgregar (ActionEvent evt) throws NumberFormatException, RemoteException{

		tarifasAct.add(tarifaAct);
		this.jTextFieldDescripcionSeguro.setText("");
		this.jTextFieldDescripcionMercaderia.setText("");
		this.jTextFieldCodigoTarifa.setText("");
		
		//this.productos = ProductoController.getInstance().buscarProductos (Integer.valueOf(this.txtCodigo.getText()));
		
		if (tarifasAct == null){
			System.out.println("No hay productos cargados para la empresa");
		}else{
			if(this.tarifasAct.isEmpty()){
				System.out.println("No hay productos cargados para la empresa");
			}else{
				this.listaProductos = new DefaultComboBoxModel(tarifasAct);
				this.lstProductos.setModel(listaProductos);
			}
		}

	}
		
}
