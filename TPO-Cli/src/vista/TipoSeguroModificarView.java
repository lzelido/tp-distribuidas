package vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.ClienteController;
import controlador.TipoSeguroController;
import dto.ParticularDTO;
import dto.TipoSeguroDTO;


public class TipoSeguroModificarView extends javax.swing.JFrame {

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
	private JSeparator jSeparator2;
	private JButton jButtonSalir;
	private JButton jButtonModificar;
	private JTextField jTextFieldDescripcion;
	private JLabel jLabelDescripcion;
	private JButton jButtonBuscar;
	private JTextField jTextFieldCodigo;
	private static TipoSeguroDTO tipoSeguroAct;

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TipoSeguroModificarView inst = new TipoSeguroModificarView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public TipoSeguroModificarView() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			pack();
			this.setSize(400, 247);
			this.setTitle("Modificación de Tipo Seguro");
			{
				jLabelCodigo = new JLabel();
				getContentPane().add(jLabelCodigo);
				jLabelCodigo.setText("Código :");
				jLabelCodigo.setBounds(28, 27, 58, 16);
			}
			{
				jTextFieldCodigo = new JTextField();
				getContentPane().add(jTextFieldCodigo);
				jTextFieldCodigo.setBounds(109, 24, 112, 23);
			}
			{
				jButtonBuscar = new JButton();
				getContentPane().add(jButtonBuscar);
				jButtonBuscar.setText("Buscar");
				jButtonBuscar.setBounds(262, 21, 85, 27);
				jButtonBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBuscar (evt);
					}
				});
			}
			{
				jLabelDescripcion = new JLabel();
				getContentPane().add(jLabelDescripcion);
				jLabelDescripcion.setText("Descripción :");
				jLabelDescripcion.setBounds(28, 102, 81, 16);
			}
			{
				jTextFieldDescripcion = new JTextField();
				getContentPane().add(jTextFieldDescripcion);
				jTextFieldDescripcion.setBounds(109, 96, 238, 28);
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(1, 74, 384, 10);
			}
			{
				jSeparator2 = new JSeparator();
				getContentPane().add(jSeparator2);
				jSeparator2.setBounds(0, 146, 384, 30);
			}
			{
				jButtonModificar = new JButton();
				getContentPane().add(jButtonModificar);
				jButtonModificar.setText("Modificar");
				jButtonModificar.setBounds(36, 165, 85, 28);
				jButtonModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnModificar (evt);
					}
				});
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(262, 165, 85, 28);
				jButtonSalir.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dispose();
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnBuscar (ActionEvent evt){
		try {
			//particularAct = ClienteController.getInstance().buscarClienteParticular(this.txtTipoDoc.getText(), this.txtNroDoc.getText());
			tipoSeguroAct = TipoSeguroController.getInstance().buscarTipoSeguro(Integer.parseInt(this.jTextFieldCodigo.getText()));
			
			if (tipoSeguroAct == null){
				String mensaje = "No existe el Tipo de Seguro";
				JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				this.dispose();
			}else{
				this.jTextFieldCodigo.setEditable(false);
				//this.jTextFieldCodigo.setText(String.valueOf(tipoSeguroAct.getCodigo()));
				this.jTextFieldDescripcion.setText(tipoSeguroAct.getDescripcion());
			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al buscar el Tipo de Seguro: " + e.getMessage());
			System.out.println("Stack Trace al buscar el Tipo de Seguro: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnModificar (ActionEvent evt){
		try{
			int response = JOptionPane.showConfirmDialog(null,"¿Esta seguro que desea continuar?\nEsta acción no puede deshacerse.", "Confirmación", JOptionPane.YES_NO_OPTION);
			if(response == JOptionPane.NO_OPTION){
				return;
			}else{
				if (response == JOptionPane.YES_OPTION){
					tipoSeguroAct.setCodigo(Integer.parseInt(this.jTextFieldCodigo.getText()));
					tipoSeguroAct.setDescripcion(this.jTextFieldDescripcion.getText());
					int check = 0;
					check = TipoSeguroController.getInstance().modificarTipoSeguro(tipoSeguroAct);
					if (check == 2){
						String mensaje = "Se modificó el Tipo de Seguro";
						JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
					}else{
						if (check == 1){
							String mensaje = "El Tipo de Seguro no existe";
							JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
						}else{
							String mensaje = "Falla en la modificación del Tipo de Seguro";
							JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
					
					TipoSeguroModificarView.this.dispose();
//					new Principal();
				}
			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al modificar un Tipo de Seguro: " + e.getMessage());
			System.out.println("Stack Trace al modificar un Tipo de Seguro: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
