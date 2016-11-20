package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import controlador.RutaController;

public class RutaBajaView extends javax.swing.JDialog {
	private static final long serialVersionUID = 1L;
	private ImageIcon picture;
	private JLabel lblNombre;
	private JTextField txtNombr;
	private JButton btnCancelar;
	private JButton btnAceptar;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				JFrame frame = new JFrame();
				RutaBajaView inst = new RutaBajaView();
				inst.setVisible(true);
			}
		});
	}
	
	public RutaBajaView() {
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
			this.setTitle("Baja de Ruta");
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
				ComboBoxModel tipoModel = 
						new DefaultComboBoxModel(
								new String[] { "Si", "No" });
			}
			{
				btnAceptar = new JButton();
				getContentPane().add(btnAceptar);
				btnAceptar.setText("Aceptar");
				btnAceptar.setBounds(10, 57, 108, 23);
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
				btnCancelar.setBounds(416, 57, 108, 23);
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCancelar (evt);
					}
				});
			}
			this.setSize(561, 129);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnAceptar (ActionEvent evt){
		try{
			int response = JOptionPane.showConfirmDialog(null,"¿Esta seguro que desea eliminar la ruta?.", "Confirmación", JOptionPane.YES_NO_OPTION);
			if(response == JOptionPane.NO_OPTION){
				return;
			}else{
				if (response == JOptionPane.YES_OPTION){
					int check=0;
					check = RutaController.getInstance().bajaRuta(Integer.valueOf(this.txtNombr.getText()));
					if (check == 2){
						String mensaje = "Se eliminó la ruta";
						JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
					}else{
						if (check == 1){
							String mensaje = "La ruta no existe";
							JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
						}else{
							String mensaje = "Falla en la eliminación de la ruta";
							JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
					
					RutaBajaView.this.dispose();
//					new Principal();
				}
			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al eliminar una ruta: " + e.getMessage());
			System.out.println("Stack Trace al eliminar una ruta: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnCancelar (ActionEvent evt){
		try{
			RutaBajaView.this.dispose();
//			new Principal();
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al cancelar la baja de una ruta: " + e.getMessage());
			System.out.println("Stack Trace al cancelar la baja de una ruta: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
