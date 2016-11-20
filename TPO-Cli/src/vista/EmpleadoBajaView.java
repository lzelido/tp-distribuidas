package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import controlador.EmpleadoController;
import dto.EmpleadoDTO;

public class EmpleadoBajaView extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private JButton jButton;
	private JLabel jLabel3;
	private JButton jButton1;
	private JTextField jTextField4;
	private JTextField jTextField3;
	private JTextField jTextField2;
	private JTextField jTextField1;
	private JLabel jLabel4;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private static EmpleadoDTO empleadoAct;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				EmpleadoBajaView inst = new EmpleadoBajaView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public EmpleadoBajaView() {
		super();
		initGUI();
		 this.setLocationRelativeTo(null);
		 this.setVisible(true);
	}
	
	private void initGUI() {
		try {
			
			   setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			   getContentPane().setLayout(null);
			   this.setTitle("Baja de Empleado");
			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jButton = new JButton();
				getContentPane().add(jButton);
				jButton.setText("Dar de Baja Empleado");
				jButton.setBounds(155, 324, 158, 37);
				jButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnEliminar(evt);
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
				jLabel3.setBounds(60, 169, 58, 16);
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
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Buscar Empleado");
				jButton1.setBounds(273, 48, 181, 25);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBuscar (evt);
					}
			});
			}
			pack();
			this.setSize(753, 514);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	private void btnBuscar(ActionEvent evt) {
		try {
			
			empleadoAct =  (EmpleadoDTO) EmpleadoController.getInstance().buscarEmpleado(Integer.parseInt(this.jTextField1.getText()));
			
			if (empleadoAct == null){
				String mensaje = "No existe el empleado";
				JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				this.dispose();
			}else{
				
				this.jTextField1.setText(String.valueOf(empleadoAct.getNumero()));
				this.jTextField1.setEditable(false);
				
				this.jTextField2.setText(String.valueOf(empleadoAct.getNombre()));
				this.jTextField2.setEditable(false);
				
				this.jTextField3.setText(String.valueOf(empleadoAct.getApellido()));
				this.jTextField3.setEditable(false);
				
				this.jTextField4.setText(String.valueOf(empleadoAct.getPuesto()));
				this.jTextField4.setEditable(false);
				
				}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println(e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void  btnEliminar (ActionEvent evt){
		try{
			int check = 0;
			check = EmpleadoController.getInstance().eliminarEmpleado(empleadoAct);
			if (check == 2){
				String mensaje = "Se eliminó el empleado";
				JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
			}else{
				if(check == 1){
				String mensaje = "El empleado no existe";
				JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
					String mensaje = "Error al eliminar el empleado";
					JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println(e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
