package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import controlador.ClienteController;
import dto.ParticularDTO;

public class ClienteParticularAltaView extends javax.swing.JDialog {
	private static final long serialVersionUID = 1L;
	private ImageIcon picture;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JTextField txtTipoDoc;
	private JLabel lblTipoDoc;
	private JTextField txtNroDoc;
	private JLabel lblNroDoc;
	private JLabel lblManifiesto;
	@SuppressWarnings("rawtypes")
	private JComboBox cboManifiesto;
	private JLabel lblPagoAdelantado;
	@SuppressWarnings("rawtypes")
	private JComboBox cboPagoAdelantado;
	private JButton btnAceptar;
	private JButton btnCancelar;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				JFrame frame = new JFrame();
				ClienteParticularAltaView inst = new ClienteParticularAltaView();
				inst.setVisible(true);
			}
		});
	}
	
	public ClienteParticularAltaView() {
		super();
		initGUI();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Alta de Particular");
			picture = new ImageIcon("C:/Users/Facu/git/tpo_cliente-ad15/TPO_Cliente/picture/4.png");
			this.setIconImage(picture.getImage());
			{
				lblNombre = new JLabel();
				getContentPane().add(lblNombre);
				lblNombre.setText("Nombre");
				lblNombre.setBounds(12, 15, 90, 16);
			}
			{
				txtNombre = new JTextField();
				getContentPane().add(txtNombre);
				txtNombre.setBounds(120, 12, 413, 23);
			}
			{
				txtTipoDoc = new JTextField();
				getContentPane().add(txtTipoDoc);
				txtTipoDoc.setBounds(120, 41, 116, 23);
			}
			{
				lblTipoDoc = new JLabel();
				getContentPane().add(lblTipoDoc);
				lblTipoDoc.setText("Tipo Documento");
				lblTipoDoc.setBounds(12, 44, 96, 16);
			}
			{
				txtNroDoc = new JTextField();
				getContentPane().add(txtNroDoc);
				txtNroDoc.setBounds(373, 41, 160, 23);
			}
			{
				lblNroDoc = new JLabel();
				getContentPane().add(lblNroDoc);
				lblNroDoc.setText("Nro de Documento");
				lblNroDoc.setBounds(248, 44, 119, 16);
			}
			{
				lblManifiesto = new JLabel();
				getContentPane().add(lblManifiesto);
				lblManifiesto.setText("Req. Manifiesto");
				lblManifiesto.setBounds(12, 79, 98, 16);
			}
			{
				ComboBoxModel tipoModel = 
						new DefaultComboBoxModel(
								new String[] { "Si", "No" });
				cboManifiesto = new JComboBox();
				getContentPane().add(cboManifiesto);
				cboManifiesto.setModel(tipoModel);
				cboManifiesto.setBounds(120, 76, 116, 23);
			}
			{
				lblPagoAdelantado = new JLabel();
				getContentPane().add(lblPagoAdelantado);
				lblPagoAdelantado.setText("Pago Adelantado");
				lblPagoAdelantado.setBounds(260, 79, 101, 16);
			}
			{
				ComboBoxModel tipoModel = 
						new DefaultComboBoxModel(
								new String[] { "Si", "No" });
				cboPagoAdelantado = new JComboBox();
				getContentPane().add(cboPagoAdelantado);
				cboPagoAdelantado.setModel(tipoModel);
				cboPagoAdelantado.setBounds(373, 76, 160, 23);
			}
			{
				btnAceptar = new JButton();
				getContentPane().add(btnAceptar);
				btnAceptar.setText("Aceptar");
				btnAceptar.setBounds(12, 133, 108, 23);
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
				btnCancelar.setBounds(426, 133, 108, 23);
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCancelar (evt);
					}
				});
			}
			this.setSize(561, 206);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void btnAceptar (ActionEvent evt){
		try{
			int response = JOptionPane.showConfirmDialog(null,"¿Esta seguro que desea continuar?\nEsta acción no puede deshacerse.", "Confirmación", JOptionPane.YES_NO_OPTION);
			if(response == JOptionPane.NO_OPTION){
				return;
			}else{
				if (response == JOptionPane.YES_OPTION){
					ParticularDTO particular = new ParticularDTO();
					particular.setNombre(this.txtNombre.getText());
					particular.setTipoDoc(this.txtTipoDoc.getText());
					particular.setNroDoc(this.txtNroDoc.getText());
					boolean manifiesto = false;
					if(this.cboManifiesto.getSelectedItem().toString().equals("Si"))
						manifiesto = true;
					particular.setReqManifiesto(manifiesto);
					boolean adelanto = false;
					if(this.cboPagoAdelantado.getSelectedItem().toString().equals("Si"))
						adelanto = true;
					particular.setEsPagoAdelantado(adelanto);
					
					int check = 0;
					check = ClienteController.getInstance().altaClienteParticular(particular);
					if (check == 2){
						String mensaje = "Se dio de alta el nuevo particular";
						JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
					}else{
						if(check == 1){
							String mensaje = "El particular ya existe";
							JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
						}else{
							String mensaje = "Falla en el alta del nuevo particular";
							JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
					
					ClienteParticularAltaView.this.dispose();
//					new Principal();
				}
			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al grabar un particular: " + e.getMessage());
			System.out.println("Stack Trace al grabar un particular: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnCancelar (ActionEvent evt){
		try{
			ClienteParticularAltaView.this.dispose();
//			new Principal();
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al cancelar el alta de un particular: " + e.getMessage());
			System.out.println("Stack Trace al cancelar el alta de un particular: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
