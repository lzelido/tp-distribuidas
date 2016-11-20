package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.EmpleadoController;
import controlador.SucursalController;
import dto.EmpleadoDTO;
import dto.EmpresaDTO;
import dto.SucursalDTO;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
@SuppressWarnings("unused")
public class SucursalAltaView extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	//private static EmpleadoDTO empleadoAct;
	private static SucursalDTO sucursalAct;
	private JLabel jLabel1;
	private JLabel jLabel2;
	@SuppressWarnings("rawtypes")
	private JComboBox cboERecep;
	@SuppressWarnings("rawtypes")
	private JComboBox cboEDespa;
	@SuppressWarnings("rawtypes")
	private JComboBox cboEDepo;
	@SuppressWarnings("rawtypes")
	private JComboBox cboGerente;
	@SuppressWarnings("rawtypes")
	private JList lstGerente;
	private JPopupMenu lblg;
	private JSeparator jSeparator1;
	private JButton jButton2;
	private JButton jButton1;
	private JTextField jTextField2;
	private JTextField jTextField1;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel5;
	private JLabel jLabel4;
	private DefaultComboBoxModel<EmpleadoDTO> listaGerentes;
	private DefaultComboBoxModel<EmpleadoDTO> listaEDepo;
	private DefaultComboBoxModel<EmpleadoDTO> listaEDespa;
	private DefaultComboBoxModel<EmpleadoDTO> listaERecep;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SucursalAltaView inst = new SucursalAltaView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public SucursalAltaView(){
		super();
		initGUI();
		this.loadData();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@SuppressWarnings("rawtypes")
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			this.setTitle("Alta de Sucursal");
			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Codigo");
				jLabel1.setBounds(12, 31, 65, 16);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Nombre");
				jLabel2.setBounds(12, 66, 78, 16);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Gerente");
				jLabel4.setBounds(12, 120, 105, 16);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("Encargado Depósito");
				jLabel5.setBounds(12, 156, 126, 17);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("Encargado Despacho");
				jLabel6.setBounds(12, 192, 129, 16);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("Encargado Recepción");
				jLabel7.setBounds(12, 227, 135, 16);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(135, 28, 69, 23);
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2);
				jTextField2.setBounds(135, 63, 125, 23);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Dar de Alta Sucursal");
				jButton1.setBounds(12, 259, 164, 23);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAceptar (evt);
					}
				});
				
				
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("Cancelar");
				jButton2.setBounds(345, 259, 164, 23);
				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCancelar (evt);
					}
				});
				
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(12, 101, 497, 10);
			}
			{
				
				cboGerente = new JComboBox();
				getContentPane().add(cboGerente);
				cboGerente.setBounds(159, 117, 350, 23);
			}
			{
				cboEDepo = new JComboBox();
				getContentPane().add(cboEDepo);
				cboEDepo.setBounds(159, 152, 350, 25);
			}
			{
				cboEDespa = new JComboBox();
				getContentPane().add(cboEDespa);
				cboEDespa.setBounds(159, 189, 350, 23);
			}
			{
				cboERecep = new JComboBox();
				getContentPane().add(cboERecep);
				cboERecep.setBounds(159, 224, 350, 23);
			}

			pack();
			this.setSize(561, 332);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void loadData(){
		try{
			Vector<EmpleadoDTO> gerentes =  EmpleadoController.getInstance().buscarEmpleados();
			if(gerentes.isEmpty()){
				this.dispose();
				String mensaje = "No hay empleados cargados";
				JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
			}
			this.listaGerentes = new DefaultComboBoxModel(gerentes);
			this.cboGerente.setModel(listaGerentes);
			
			this.listaEDepo = new DefaultComboBoxModel(gerentes);
			this.cboEDepo.setModel(listaEDepo);
			
			this.listaEDespa = new DefaultComboBoxModel(gerentes);
			this.cboEDespa.setModel(listaEDespa);
			
			this.listaERecep = new DefaultComboBoxModel(gerentes);
			this.cboERecep.setModel(listaERecep);
			
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error load del alta de una sucursal: " + e.getMessage());
			System.out.println("Stack Trace load del alta de una sucursal: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnUbicacion (ActionEvent evt){
		try {
			SucursalAltaView.this.dispose();
			new UbicacionAltaView(null, null, sucursalAct, null);
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al agregar un destino: " + e.getMessage());
			System.out.println("Stack Trace al agregar un destino: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void btnAceptar (ActionEvent evt){
		try{
			SucursalDTO sucursal = new SucursalDTO();
			sucursal.setCodigo(Integer.valueOf(this.jTextField1.getText()));
			sucursal.setNombre(this.jTextField2.getText());
			
			// veo que es lo que seleccionó el usuario:
			EmpleadoDTO gerente = (EmpleadoDTO) this.cboGerente.getSelectedItem();
			EmpleadoDTO EDepo = (EmpleadoDTO) this.cboEDepo.getSelectedItem();
			EmpleadoDTO EDespa = (EmpleadoDTO) this.cboEDespa.getSelectedItem();
			EmpleadoDTO ERecep = (EmpleadoDTO) this.cboERecep.getSelectedItem();
			
			sucursal.setGerente(gerente);
			sucursal.setEncargadoDeposito(EDepo);
			sucursal.setEncargadoDespacho(EDespa);
			sucursal.setEncargadoRecepcion(ERecep);
			
			int check = 0;
			check =  SucursalController.getInstance().darDeAltaSucursal(sucursal);
			
			if (check == 2){
				String mensaje = "Se dio de alta la sucurdal";
				JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
			}else{
				if(check == 1){
				String mensaje = "La sucursal ya existe";
				JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
					String mensaje = "Falla en el alta de la sucursal";
					JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			SucursalAltaView.this.dispose();
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al modificar de una empresa: " + e.getMessage());
			System.out.println("Stack Trace al modificar de una empresa: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void btnCancelar (ActionEvent evt){
		try{
			SucursalAltaView.this.dispose();

		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al cancelar el alta de una sucursal: " + e.getMessage());
			System.out.println("Stack Trace al cancelar el alta de una sucursal: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}	
	
	
}
