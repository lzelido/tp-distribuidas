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
import dto.UbicacionDTO;

@SuppressWarnings("unused")
public class SucursalModificarView extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private static UbicacionDTO ubicacionAct;
	private static SucursalDTO sucursalAct;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JButton btnModificarUbicacion;
	private JTextField jTextField3;
	private JButton jButton3;
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
	private JButton jButton7;
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
				SucursalModificarView inst = new SucursalModificarView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public SucursalModificarView(){
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
			this.setTitle("Modificación de Sucursal");
			
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
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Ubicación");
				jLabel3.setBounds(22, 490, 78, 16);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Gerente");
				jLabel4.setBounds(19, 129, 105, 16);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("Encargado Depósito");
				jLabel5.setBounds(19, 231, 126, 17);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("Encargado Despacho");
				jLabel6.setBounds(19, 330, 129, 16);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("Encargado Recepción");
				jLabel7.setBounds(22, 429, 135, 16);
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
				jButton1.setText("Modificar Sucursal");
				jButton1.setBounds(61, 572, 164, 23);
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
				jButton2.setBounds(272, 572, 164, 23);
				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCancelar (evt);
					}
				});
				
			}
			{
				jButton7 = new JButton();
				getContentPane().add(jButton7);
				jButton7.setText("Cambiar");
				jButton7.setBounds(389, 487, 118, 23);
				jButton7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCambiarUbicacion (evt);
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
				cboGerente.setBounds(157, 126, 352, 23);
			}
			{
				cboEDepo = new JComboBox();
				getContentPane().add(cboEDepo);
				cboEDepo.setBounds(157, 227, 350, 25);
			}
			{
				cboEDespa = new JComboBox();
				getContentPane().add(cboEDespa);
				cboEDespa.setBounds(156, 327, 350, 23);
			}
			{
				cboERecep = new JComboBox();
				getContentPane().add(cboERecep);
				cboERecep.setBounds(157, 426, 350, 23);
			}
			{
				jButton3 = new JButton();
				getContentPane().add(jButton3);
				jButton3.setText("Buscar");
				jButton3.setBounds(225, 28, 95, 23);jButton3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBuscar (evt);
					}
				});
			}
			
			{
				jTextField3 = new JTextField();
				getContentPane().add(jTextField3);
				jTextField3.setBounds(90, 487, 289, 23);
			}
			{
				btnModificarUbicacion = new JButton();
				getContentPane().add(btnModificarUbicacion);
				btnModificarUbicacion.setText("Modificar");
				btnModificarUbicacion.setBounds(389, 521, 117, 23);
				btnModificarUbicacion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnModificarUbicacion (evt);
					}
				});
			}

			pack();
			this.setSize(561, 658);
			
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

	private void btnAceptar (ActionEvent evt){
		try{
			SucursalDTO sucursal = new SucursalDTO();
			
			sucursalAct.setNombre(this.jTextField2.getText());
						
			//veo que es lo que seleccionó el usuario:
			EmpleadoDTO gerente = (EmpleadoDTO) this.cboGerente.getSelectedItem();
			EmpleadoDTO EDepo = (EmpleadoDTO) this.cboEDepo.getSelectedItem();
			EmpleadoDTO EDespa = (EmpleadoDTO) this.cboEDespa.getSelectedItem();
			EmpleadoDTO ERecep = (EmpleadoDTO) this.cboERecep.getSelectedItem();
			
			sucursalAct.setGerente(gerente);
			sucursalAct.setEncargadoDeposito(EDepo);
			sucursalAct.setEncargadoDespacho(EDespa);
			sucursalAct.setEncargadoRecepcion(ERecep);
			
			int check = 0;
			check =  SucursalController.getInstance().modificarSucursal(sucursalAct);
		
			if (check == 2){
				String mensaje = "Se modificó la sucursal";
				JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
			}else{
				if(check == 1){
				String mensaje = "La sucursal no existe";
				JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
					String mensaje = "Error al modificar la sucursal";
					JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			SucursalModificarView.this.dispose();
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al modificar la sucursal: " + e.getMessage());
			System.out.println("Stack Trace al modificar la sucursal: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void btnCancelar (ActionEvent evt){
		try{
			SucursalModificarView.this.dispose();

		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al cancelar el alta de una sucursal: " + e.getMessage());
			System.out.println("Stack Trace al cancelar el alta de una sucursal: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void btnBuscar(ActionEvent evt) {
		try {
			sucursalAct = (SucursalDTO) SucursalController.getInstance().buscarSucursal(Integer.parseInt(this.jTextField1.getText()));
			
			if (sucursalAct == null){
				String mensaje= "No existe la sucursal";
				JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				this.dispose();
			}else{
				this.jTextField1.setText(String.valueOf(sucursalAct.getCodigo()));
				this.jTextField1.setEditable(false);
				this.jTextField2.setText(sucursalAct.getNombre());

				// Cargar el combo de gerentes con el gerente actual de la sucursal que se busco.
				Vector<EmpleadoDTO> gerentes =  EmpleadoController.getInstance().buscarEmpleados();
				if(gerentes.isEmpty()){
					this.dispose();
					String mensaje = "No hay empleados cargados";
					JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
					
				}
				this.listaGerentes = new DefaultComboBoxModel(gerentes);
				this.cboGerente.setModel(listaGerentes); 
				int comboIndex = 0;
				for(int i=0; i<gerentes.size();i++){
					if(gerentes.get(i).getNumero() == sucursalAct.getGerente().getNumero()){
						comboIndex = i;
					}
				}
				this.cboGerente.setSelectedIndex(comboIndex);
				
				// Cargar el combo de encargado de depósito con el gerente actual de la sucursal que se busco.
				Vector<EmpleadoDTO> encargadoDeposito =  EmpleadoController.getInstance().buscarEmpleados();
				if(encargadoDeposito.isEmpty()){
					this.dispose();
					String mensaje = "No hay empleados cargados";
					JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
					
				}
				this.listaEDepo = new DefaultComboBoxModel(gerentes);
				this.cboEDepo.setModel(listaEDepo); 
				comboIndex = 0;
				for(int i=0; i<encargadoDeposito.size();i++){
					if(encargadoDeposito.get(i).getNumero() == sucursalAct.getEncargadoDeposito().getNumero()){
						comboIndex = i;
					}
				}
				this.cboEDepo.setSelectedIndex(comboIndex);
				
				// Cargar el combo de encargado de despacho con el gerente actual de la sucursal que se busco.
				Vector<EmpleadoDTO> encargadoDespacho =  EmpleadoController.getInstance().buscarEmpleados();
				if(encargadoDespacho.isEmpty()){
					this.dispose();
					String mensaje = "No hay empleados cargados";
					JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
					
				}
				this.listaEDespa = new DefaultComboBoxModel(gerentes);
				this.cboEDespa.setModel(listaEDespa); 
				comboIndex = 0;
				for(int i=0; i<encargadoDespacho.size();i++){
					if(encargadoDespacho.get(i).getNumero() == sucursalAct.getEncargadoDespacho().getNumero()){
						comboIndex = i;
					}
				}
				this.cboEDespa.setSelectedIndex(comboIndex);
				
				// Cargar el combo de encargado de recepcion con el gerente actual de la sucursal que se busco.
				Vector<EmpleadoDTO> encargadoRecepcion =  EmpleadoController.getInstance().buscarEmpleados();
				if(encargadoRecepcion.isEmpty()){
					this.dispose();
					String mensaje = "No hay empleados cargados";
					JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
					
				}
				this.listaERecep = new DefaultComboBoxModel(gerentes);
				this.cboERecep.setModel(listaERecep); 
				comboIndex = 0;
				for(int i=0; i<encargadoRecepcion.size();i++){
					if(encargadoRecepcion.get(i).getNumero() == sucursalAct.getEncargadoRecepcion().getNumero()){
						comboIndex = i;
					}
				}
				this.cboERecep.setSelectedIndex(comboIndex);
				
				// La ubicación
				ubicacionAct = sucursalAct.getUbicacion();
				if (ubicacionAct != null){
					this.jTextField3.setText(sucursalAct.getUbicacion().toString());
				}				
			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al buscar una sucursal: " + e.getMessage());
			System.out.println("Stack Trace al buscar una sucursal: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnCambiarUbicacion (ActionEvent evt){
		try {
			SucursalModificarView.this.dispose();
			new UbicacionAltaView(null, null, sucursalAct, null);
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al agregar un destino: " + e.getMessage());
			System.out.println("Stack Trace al agregar un destino: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnModificarUbicacion (ActionEvent evt){
		try {
			SucursalModificarView.this.dispose();
			new UbicacionModificarView (ubicacionAct, null, null, sucursalAct, null);
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al agregar un destino: " + e.getMessage());
			System.out.println("Stack Trace al agregar un destino: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}