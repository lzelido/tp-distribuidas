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
import dto.EmpleadoDTO;

public class EmpleadoAltaView extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private JButton jButton1;
	private JButton jButton2;
	private JLabel jLabel3;
	private JTextField jTextField4;
	private JTextField jTextField3;
	private JTextField jTextField2;
	private JTextField jTextField1;
	private JLabel jLabel4;
	private JLabel jLabel2;
	private JLabel jLabel1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				EmpleadoAltaView inst = new EmpleadoAltaView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public EmpleadoAltaView() {
		super();
		initGUI();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			this.setTitle("Alta de Empleado");
			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("Dar de Alta Empleado");
				jButton2.setBounds(170, 331, 158, 37);
				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						EmpleadoDTO empleado = new EmpleadoDTO();
						empleado.setNumero(Integer.parseInt(jTextField1.getText()));
						empleado.setNombre(jTextField2.getText());
						empleado.setApellido(jTextField3.getText());
						empleado.setPuesto(jTextField4.getText());
						
						EmpleadoController.getInstance().darDeAltaEmpleado(empleado);
						
						dispose(); 		
						
					}
				});
				
				
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Numero");
				jLabel1.setBounds(60, 52, 70, 16);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Nombre");
				jLabel2.setBounds(60, 111, 64, 22);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Apellido");
				jLabel3.setBounds(60, 178, 58, 16);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Puesto");
				jLabel4.setBounds(60, 239, 70, 21);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(136, 49, 109, 23);
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2);
				jTextField2.setBounds(136, 111, 185, 23);
			}
			{
				jTextField3 = new JTextField();
				getContentPane().add(jTextField3);
				jTextField3.setBounds(136, 166, 185, 23);
			}
			{
				jTextField4 = new JTextField();
				getContentPane().add(jTextField4);
				jTextField4.setBounds(136, 238, 104, 23);
			}
			pack();
			this.setSize(753, 514);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}