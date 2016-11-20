package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import controlador.RutaController;
import dto.RutaDTO;
import dto.SucursalDTO;

public class RutaModificarView extends javax.swing.JDialog {
	private static final long serialVersionUID = 1L;
	private ImageIcon picture;
	private JLabel lblNombre;
	private JTextField txtNombr;
	private JTextField txtDuracion;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JLabel lblEsVigente;
	private JLabel lblDuracion;
	private JLabel lblCamino;
	private JTextField txtCamino;
	private JLabel lblSucDestino;
	private JTextField txtSucDestino;
	private JLabel lblSucOrigen;
	private JTextField txtSucOrigen;
	@SuppressWarnings("rawtypes")
	private JComboBox cboEsVigente;
	private JLabel lblCosto;
	private JTextField txtCosto;
	private RutaDTO rutaact;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				JFrame frame = new JFrame();
				RutaModificarView inst = new RutaModificarView();
				inst.setVisible(true);
			}
		});
	}
	
	public RutaModificarView() {
		super();
		initGUI();
//		this.loadData();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Modificar Ruta");
			picture = new ImageIcon("C:/Users/Facu/git/tpo_cliente-ad15/TPO_Cliente/picture/4.png");
			this.setIconImage(picture.getImage());
			{
				lblNombre = new JLabel(); 
				getContentPane().add(lblNombre);
				lblNombre.setText("ID Ruta");
				lblNombre.setBounds(12, 15, 90, 16);
			}
			{
				txtNombr = new JTextField();
				getContentPane().add(txtNombr);
				txtNombr.setBounds(120, 12, 116, 23);
			}
			{
				txtSucOrigen = new JTextField();
				getContentPane().add(txtSucOrigen);
				txtSucOrigen.setBounds(120, 41, 116, 23);
			}
			{
				lblSucOrigen = new JLabel();
				getContentPane().add(lblSucOrigen);
				lblSucOrigen.setText("Suc. Origen");
				lblSucOrigen.setBounds(12, 44, 96, 16);
			}
			{
				txtSucDestino = new JTextField();
				getContentPane().add(txtSucDestino);
				txtSucDestino.setBounds(373, 41, 160, 23);
			}
			{
				lblSucDestino = new JLabel();
				getContentPane().add(lblSucDestino);
				lblSucDestino.setText("Suc. Destino");
				lblSucDestino.setBounds(306, 44, 119, 16);
			}
			{
				txtCamino = new JTextField();
				getContentPane().add(txtCamino);
				txtCamino.setBounds(120, 76, 413, 23);
			}
			{
				lblCamino = new JLabel();
				getContentPane().add(lblCamino);
				lblCamino.setText("Camino");
				lblCamino.setBounds(12, 79, 96, 16);
			}
			{
				txtDuracion = new JTextField();
				getContentPane().add(txtDuracion);
				txtDuracion.setBounds(120, 105, 131, 23);
			}
			{
				lblDuracion = new JLabel();
				getContentPane().add(lblDuracion);
				lblDuracion.setText("Duracion");
				lblDuracion.setBounds(12, 108, 108, 16);
			}
			{
				lblEsVigente = new JLabel();
				getContentPane().add(lblEsVigente);
				lblEsVigente.setText("Es vigente");
				lblEsVigente.setBounds(12, 144, 98, 16);
			}
			{
				ComboBoxModel tipoModel = 
						new DefaultComboBoxModel(
								new String[] { "Si", "No" });
				cboEsVigente = new JComboBox();
				getContentPane().add(cboEsVigente);
				cboEsVigente.setModel(tipoModel);
				cboEsVigente.setBounds(120, 141, 131, 23);
			}
			{
				ComboBoxModel tipoModel = 
						new DefaultComboBoxModel(
								new String[] { "Si", "No" });
			}
			{
				ComboBoxModel tipoModel = 
						new DefaultComboBoxModel(
								new String[] { "Si", "No" });
			}
			{
				btnAceptar = new JButton();
				getContentPane().add(btnAceptar);
				btnAceptar.setText("Aceptar");
				btnAceptar.setBounds(12, 228, 108, 23);
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
				btnCancelar.setBounds(425, 228, 108, 23);
				{
					lblCosto = new JLabel("Costo");
					lblCosto.setBounds(306, 110, 108, 16);
					getContentPane().add(lblCosto);
				}
				
				txtCosto = new JTextField();
				txtCosto.setBounds(373, 110, 160, 20);
				getContentPane().add(txtCosto);
				txtCosto.setColumns(10);
				
				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnBuscar (arg0);
					}
				});
				btnBuscar.setBounds(246, 12, 89, 23);
				getContentPane().add(btnBuscar);
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCancelar (evt);
					}
				});
			}
			this.setSize(561, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnBuscar (ActionEvent evt){
		try {
			rutaact = RutaController.getInstance().buscarRuta (Integer.parseInt(this.txtNombr.getText()));
			if (rutaact == null){
				String mensaje = "No existe la ruta";
				JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				this.dispose();
			}else{
				this.txtCamino.setEditable(false);
				this.txtCosto.setText(String.valueOf(rutaact.getCosto()));
				this.txtDuracion.setText(String.valueOf(rutaact.getDuracion()));
				this.txtSucDestino.setText(String.valueOf(rutaact.getSucursalDestino()));
				this.txtSucOrigen.setText(String.valueOf(rutaact.getSucursalOrigen()));
				//this.txtMonto.setText(String.valueOf(empresaAct.getMontoMinAutoriz()));
				}
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (RemoteException e) {
			System.out.println("Mensaje Error al buscar una ruta: " + e.getMessage());
			System.out.println("Stack Trace al buscar una ruta: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private void btnAceptar (ActionEvent evt){
		try{
			int response = JOptionPane.showConfirmDialog(null,"¿Esta seguro que desea continuar?.", "Confirmación", JOptionPane.YES_NO_OPTION);
			if(response == JOptionPane.NO_OPTION){
				return;
			}else{
				if (response == JOptionPane.YES_OPTION){
					RutaDTO ruta = new RutaDTO();
					ruta.setId(Integer.parseInt(this.txtNombr.getText()));
					SucursalDTO sucursalOrigen = new SucursalDTO();
					sucursalOrigen.setCodigo(Integer.parseInt(this.txtSucOrigen.getText()));
					ruta.setSucursalOrigen(sucursalOrigen);
					SucursalDTO sucursalDestino = new SucursalDTO();
					sucursalDestino.setCodigo(Integer.parseInt(this.txtSucDestino.getText()));
					ruta.setSucursalDestino(sucursalDestino);
					ruta.setCamino(this.txtCamino.getText());
					ruta.setCosto(Float.parseFloat(this.txtCosto.getText()));
					ruta.setDuracion(Float.parseFloat(this.txtDuracion.getText()));
					
					boolean manifiesto = false;
					if(this.cboEsVigente.getSelectedItem().toString().equals("Si"))
						manifiesto = true;
					ruta.setEsVigente(manifiesto);
					
					int check = 0;
					check = RutaController.getInstance().altaRuta(ruta);
					if (check == 2){
						String mensaje = "Se modificó la ruta";
						JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
					}else{
						if(check == 1){
							String mensaje = "La ruta ya existe";
							JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
						}else{
							String mensaje = "Falla en la modificación de la  ruta";
							JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
					
					RutaModificarView.this.dispose();
//					new Principal();
				}
			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al grabar una ruta: " + e.getMessage());
			System.out.println("Stack Trace al grabar una ruta: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnCancelar (ActionEvent evt){
		try{
			RutaModificarView.this.dispose();
//			new Principal();
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al cancelar: " + e.getMessage());
			System.out.println("Stack Trace al cancelar: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
