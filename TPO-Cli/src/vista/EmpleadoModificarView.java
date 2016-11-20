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

public class EmpleadoModificarView extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JButton jButton3;
	private JTextField jTextField4;
	private JTextField jTextField3;
	private JTextField jTextField2;
	private JTextField jTextField1;
	private JButton jButton1;
	private JLabel jLabel4;
	private static EmpleadoDTO empleado;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				EmpleadoModificarView inst = new EmpleadoModificarView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public EmpleadoModificarView() {
		super();
		initGUI();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initGUI() {
		try {
			
			 getContentPane().setLayout(null);
			   this.setTitle("Modificar de Empleado");
			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Numero");
				jLabel1.setBounds(43, 60, 122, 23);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Nombre");
				jLabel2.setBounds(43, 125, 116, 23);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Apellido");
				jLabel3.setBounds(43, 185, 121, 23);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Puesto");
				jLabel4.setBounds(43, 248, 104, 22);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Modificar");
				jButton1.setBounds(165, 337, 154, 33);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAceptar (evt);
					}
				});
				
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(165, 60, 82, 23);
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2);
				jTextField2.setBounds(164, 125, 153, 23);
			}
			{
				jTextField3 = new JTextField();
				getContentPane().add(jTextField3);
				jTextField3.setBounds(164, 185, 153, 23);
			}
			{
				jTextField4 = new JTextField();
				getContentPane().add(jTextField4);
				jTextField4.setBounds(165, 247, 82, 26);
			}
			{
				jButton3 = new JButton();
				getContentPane().add(jButton3);
				jButton3.setText("Buscar Empleado");
				jButton3.setBounds(285, 60, 155, 23);
				jButton3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBuscar (evt);
					}
				});
			}
			pack();
			setSize(753, 514);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void btnBuscar(ActionEvent evt) {
		try {
			
			empleado =  (EmpleadoDTO) EmpleadoController.getInstance().buscarEmpleado(Integer.parseInt(this.jTextField1.getText()));
			
			if (empleado == null){
				String mensaje = "No existe el empleado";
				JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				this.dispose();
			}else{
				
				this.jTextField1.setText(String.valueOf(empleado.getNumero()));
				this.jTextField1.setEditable(false);
				
				this.jTextField2.setText(String.valueOf(empleado.getNombre()));
								
				this.jTextField3.setText(String.valueOf(empleado.getApellido()));
								
				this.jTextField4.setText(String.valueOf(empleado.getPuesto()));
								
				}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println(e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
		
	
	private void btnAceptar (ActionEvent evt){
		try{
			empleado.setNombre(this.jTextField2.getText());
			empleado.setApellido(this.jTextField3.getText());
			empleado.setPuesto(this.jTextField4.getText());
			
			int check = 0;
			check = EmpleadoController.getInstance().modificarEmpleado(empleado);
			if (check == 2){
				String mensaje = "Se modificó el empleado";
				JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
			}else{
				if(check == 1){
				String mensaje = "El empleado no existe";
				JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
					String mensaje = "Error al modificar el empleado";
					JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			EmpleadoModificarView.this.dispose();
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
