package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controlador.ProveedorController;
import dto.CarrierDTO;

public class CarrierAltaView extends javax.swing.JDialog {
	private static final long serialVersionUID = 9184645873008076439L;
	private JButton cancelar;
	private JButton altaProveedor;
	private JTextField nombre;
	private JTextField telefono;
	private JLabel telefonoLabel;
	private JLabel nombreLabel;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				CarrierAltaView inst = new CarrierAltaView(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public CarrierAltaView(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("Alta Unidad");
				{
					altaProveedor = new JButton();
					getContentPane().add(altaProveedor);
					altaProveedor.setText("Dar de Alta");
					altaProveedor.setBounds(351, 423, 112, 23);
					altaProveedor.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					    	CarrierDTO proveedor= new CarrierDTO();
					    	proveedor.setNombre(nombre.getText());
					    	proveedor.setTelefono(telefono.getText());
					        try {
								ProveedorController.getInstance().altaCarrier(proveedor);
							} catch (RemoteException e1) {
								e1.printStackTrace();
							}
					    }
					});
				}
				{
					cancelar = new JButton();
					getContentPane().add(cancelar);
					cancelar.setText("Cancelar");
					cancelar.setBounds(244, 423, 90, 23);
				}
				{
					nombreLabel = new JLabel();
					getContentPane().add(nombreLabel);
					nombreLabel.setText("Nombre:");
					nombreLabel.setBounds(42, 42, 90, 16);
				}
				{
					telefonoLabel = new JLabel();
					getContentPane().add(telefonoLabel);
					telefonoLabel.setText("Telefono:");
					telefonoLabel.setBounds(42, 91, 81, 16);
				}
				{
					telefono = new JTextField();
					getContentPane().add(telefono);
					telefono.setBounds(181, 88, 153, 23);
				}
				{
					nombre = new JTextField();
					getContentPane().add(nombre);
					nombre.setBounds(181, 39, 153, 23);
				}
			}
			this.setSize(753, 514);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
