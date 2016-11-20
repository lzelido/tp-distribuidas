package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import controlador.SucursalController;
import dto.SucursalDTO;

public class SucursalBajaView extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JButton jButton3;
	private JTextField jTextField2;
	private JTextField jTextField1;
	private JButton jButton2;
	private JButton jButton1;
	private JLabel jLabel7;
	private JLabel jLabel1;
	private static SucursalDTO sucursalAct;

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SucursalBajaView inst = new SucursalBajaView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public SucursalBajaView() {
		super();
		initGUI();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			this.setTitle("Baja de Sucursal");
			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Codigo");
				jLabel1.setBounds(12, 31, 73, 16);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Nombre");
				jLabel2.setBounds(12, 73, 59, 16);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Ubicacion");
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("Encargado Recepción");
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Dar de Baja Sucursal");
				jButton1.setBounds(46, 128, 169, 23);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnEliminar(evt);
					}
				});
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("Cancelar");
				jButton2.setBounds(250, 129, 162, 22);
				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCancelar (evt);
					}
				});
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(137, 28, 67, 23);
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2);
				jTextField2.setBounds(137, 71, 113, 23);
			}
			{
				jButton3 = new JButton();
				getContentPane().add(jButton3);
				jButton3.setText("Buscar");
				jButton3.setBounds(216, 28, 97, 23);
				jButton3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBuscar (evt);
					}
			});
			}
			pack();
			this.setSize(480, 210);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void btnBuscar(ActionEvent evt) {
		try {
			
			sucursalAct = (SucursalDTO) SucursalController.getInstance().buscarSucursal(Integer.parseInt(this.jTextField1.getText()));
			
			if (sucursalAct == null){
				String mensaje = "No existe la sucursal";
				JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				this.dispose();
			}else{
				
				this.jTextField1.setText(String.valueOf(sucursalAct.getCodigo()));
				this.jTextField1.setEditable(false);
				
				this.jTextField2.setText(sucursalAct.getNombre());
				this.jTextField2.setEditable(false);
											
				}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al buscar una sucursal: " + e.getMessage());
			System.out.println("Stack Trace al buscar una sucursal: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void  btnEliminar (ActionEvent evt){
		try{
			int check = 0;
			check = SucursalController.getInstance().eliminarSucursal(sucursalAct);
			if (check == 2){
				String mensaje = "Se eliminó la sucursal";
				JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
			}else{
				if(check == 1){
				String mensaje = "La sucursal no existe";
				JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
					String mensaje = "Error al eliminar la sucursal";
					JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al eliminar una sucursal: " + e.getMessage());
			System.out.println("Stack Trace al eliminar una sucursal: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnCancelar (ActionEvent evt){
		try{
			SucursalBajaView.this.dispose();

		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al cancelar el alta de una sucursal: " + e.getMessage());
			System.out.println("Stack Trace al cancelar el alta de una sucursal: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}	
}
