package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import controlador.EmpleadoController;
import controlador.TipoSeguroController;
import dto.EmpleadoDTO;
import dto.TipoSeguroDTO;

public class TipoSeguroAltaView extends javax.swing.JFrame {


	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JLabel jLabelCodigo;
	private JButton jButtonSalir;
	private JButton jButtonAlta;
	private JTextField jTextFieldDescripcion;
	private JTextField jTextFieldCodigo;
	private JLabel jLabelDescripcion;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TipoSeguroAltaView inst = new TipoSeguroAltaView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public TipoSeguroAltaView() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			setTitle("Alta Tipo Seguro");
			{
				jLabelCodigo = new JLabel();
				getContentPane().add(jLabelCodigo);
				jLabelCodigo.setText("Código : ");
				jLabelCodigo.setBounds(27, 37, 83, 16);
			}
			{
				jLabelDescripcion = new JLabel();
				getContentPane().add(jLabelDescripcion);
				jLabelDescripcion.setText("Descripción :");
				jLabelDescripcion.setBounds(27, 86, 90, 16);
			}
			{
				jTextFieldCodigo = new JTextField();
				getContentPane().add(jTextFieldCodigo);
				jTextFieldCodigo.setBounds(116, 33, 106, 24);
			}
			{
				jTextFieldDescripcion = new JTextField();
				getContentPane().add(jTextFieldDescripcion);
				jTextFieldDescripcion.setBounds(117, 83, 241, 24);
			}
			{
				jButtonAlta = new JButton();
				getContentPane().add(jButtonAlta);
				jButtonAlta.setText("Alta");
				jButtonAlta.setBounds(80, 190, 88, 34);
				jButtonAlta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						TipoSeguroDTO tipoSeguro = new TipoSeguroDTO();
						tipoSeguro.setCodigo(Integer.parseInt(jTextFieldCodigo.getText()));
						tipoSeguro.setDescripcion(jTextFieldDescripcion.getText());
						int check = 0;
						check = TipoSeguroController.getInstance().darDeAltaTipoSeguro(tipoSeguro);
						if (check == 2){
							String mensaje = "Se dio de alta el nuevo Tipo de Seguro";
							JOptionPane.showMessageDialog(null, mensaje, "Ok", JOptionPane.INFORMATION_MESSAGE);
						}else{
							if(check == 1){
								String mensaje = "El Tipo de Seguro ya existe";
								JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
							}else{
								String mensaje = "Falla en el alta del nuevo Tipo de Seguro";
								JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
							}
						}
						
						dispose(); 		
						
					}
				});
				
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(213, 190, 88, 34);
				jButtonSalir.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dispose();
					}
				});
			}
			pack();
			this.setSize(400, 280);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
