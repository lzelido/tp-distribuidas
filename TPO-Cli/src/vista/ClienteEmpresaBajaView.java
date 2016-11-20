package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import controlador.ClienteController;
import dto.EmpresaDTO;

public class ClienteEmpresaBajaView extends javax.swing.JDialog {
	private static final long serialVersionUID = 1L;
	private ImageIcon picture;
	private JTextField txtTipoDoc;
	private JLabel lblTipoDoc;
	private JTextField txtNroDoc;
	private JLabel lblNroDoc;
	private JButton btnBuscar;
	private JSeparator jSeparator1;
	private JTextField txtCodigo;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JTextField txtCtaCte;
	private JLabel lblCtaCte;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private static EmpresaDTO empresaAct;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				JFrame frame = new JFrame();
				ClienteEmpresaBajaView inst = new ClienteEmpresaBajaView();
				inst.setVisible(true);
			}
		});
	}
	
	public ClienteEmpresaBajaView() {
		super();
		initGUI();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Eliminaci�n de Empresa");
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
				txtCtaCte = new JTextField();
				getContentPane().add(txtCtaCte);
				txtCtaCte.setBounds(120, 132, 413, 23);
			}
			{
				lblCtaCte = new JLabel();
				getContentPane().add(lblCtaCte);
				lblCtaCte.setText("Cuenta Corriente");
				lblCtaCte.setBounds(12, 135, 96, 16);
			}
			{
				btnAceptar = new JButton();
				getContentPane().add(btnAceptar);
				btnAceptar.setText("Aceptar");
				btnAceptar.setBounds(12, 184, 108, 23);
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
				btnCancelar.setBounds(425, 184, 108, 23);
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCancelar (evt);
					}
				});
			}
			this.setSize(561, 257);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
				this.txtNombre.setEditable(false);
				this.txtCtaCte.setText(String.valueOf(empresaAct.getCtaCte()));
				this.txtCtaCte.setEditable(false);
			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al buscar una empresa: " + e.getMessage());
			System.out.println("Stack Trace al buscar una empresa: " + e.getStackTrace());
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
					int check = 0;
					check = ClienteController.getInstance().bajaClienteEmpresa(Integer.valueOf(this.txtCodigo.getText()));
					if (check == 2){
						String mensaje = "Se elimin� el particular";
						JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
					}else{
						if (check == 1){
							String mensaje = "El particular no existe";
							JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
						}else{
							String mensaje = "Falla en la eliminaci�n del particular";
							JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
					
					ClienteEmpresaBajaView.this.dispose();
//					new Principal();
				}
			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al eliminar una empresa: " + e.getMessage());
			System.out.println("Stack Trace al eliminar una empresa: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnCancelar (ActionEvent evt){
		try{
			ClienteEmpresaBajaView.this.dispose();
//			new Principal();
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al cancelar la eliminaci�n de una empresa: " + e.getMessage());
			System.out.println("Stack Trace al cancelar la eliminaci�n de una empresa: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
