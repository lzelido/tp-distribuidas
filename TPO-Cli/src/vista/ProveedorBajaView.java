package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import controlador.ProveedorController;
import dto.ProveedorDTO;

public class ProveedorBajaView extends javax.swing.JDialog {
	private static final long serialVersionUID = 9184645873008076439L;
	private JButton cancelar;
	private JButton altaUnidad;
	private JLabel proveedoresLabel;
	@SuppressWarnings("rawtypes")
	private JComboBox proveedores;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				ProveedorBajaView inst = new ProveedorBajaView(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public ProveedorBajaView(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("Baja Proveedor");
				{
					altaUnidad = new JButton();
					getContentPane().add(altaUnidad);
					altaUnidad.setText("Dar de Baja");
					altaUnidad.setBounds(351, 423, 112, 23);
					altaUnidad.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {					    
					        try {
								ProveedorController.getInstance().bajaProveedor(((ProveedorDTO)proveedores.getSelectedItem()).getCodigo());
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
					proveedoresLabel = new JLabel();
					getContentPane().add(proveedoresLabel);
					proveedoresLabel.setText("Proveedores");
					proveedoresLabel.setBounds(37, 38, 117, 16);
				}
				{
					proveedores = new JComboBox();
					
					for(Object proveedor : ProveedorController.getInstance().buscarProveedores()){
						proveedores.addItem(proveedor);						
					}
					getContentPane().add(proveedores);
					proveedores.setBounds(188, 35, 219, 23);
				}
			}
			this.setSize(753, 514);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
