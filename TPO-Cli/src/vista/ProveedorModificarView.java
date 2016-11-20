package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controlador.ProveedorController;
import dto.CarrierDTO;
import dto.ProveedorDTO;
import dto.ProveedorLocalDTO;

public class ProveedorModificarView extends javax.swing.JDialog {
	private static final long serialVersionUID = 9184645873008076439L;
	private JButton cancelar;
	private JButton altaProveedor;
	private JTextField nombre;
	private JLabel EodigoLabel;
	private JTextField codigo;
	private JLabel jLabel1;
	@SuppressWarnings("rawtypes")
	private JComboBox proveedores;
	private JLabel proveedoresLabel;
	private JTextField telefono;
	private JLabel nombreLabel;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				ProveedorModificarView inst = new ProveedorModificarView(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public ProveedorModificarView(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("Modificar Proveedor");
				{
					altaProveedor = new JButton();
					getContentPane().add(altaProveedor);
					altaProveedor.setText("Modificar");
					altaProveedor.setBounds(351, 423, 112, 23);
					altaProveedor.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					        try {
					        	if(proveedores.getSelectedItem() instanceof ProveedorLocalDTO){
					        		ProveedorLocalDTO proveedor= new ProveedorLocalDTO();
					        		proveedor.setCodigo(Integer.valueOf(codigo.getText()));
					        		proveedor.setNombre(nombre.getText());
					        		proveedor.setTelefono(telefono.getText());
					        		ProveedorController.getInstance().modificarProveedorLocal(proveedor);					        		
					        	}else{
					        		CarrierDTO proveedor = new CarrierDTO();
							    	proveedor.setCodigo(Integer.valueOf(codigo.getText()));
							    	proveedor.setNombre(nombre.getText());
							    	proveedor.setTelefono(telefono.getText());
					        		ProveedorController.getInstance().modificarCarrier(proveedor);
					        	}
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
					nombreLabel.setBounds(42, 142, 90, 16);
				}
				{
					telefono = new JTextField();
					getContentPane().add(telefono);
					telefono.setBounds(181, 188, 153, 23);
				}
				{
					nombre = new JTextField();
					getContentPane().add(nombre);
					nombre.setBounds(181, 139, 153, 23);
				}
				{
					proveedoresLabel = new JLabel();
					getContentPane().add(proveedoresLabel);
					proveedoresLabel.setText("Proveedores");
					proveedoresLabel.setBounds(42, 40, 110, 16);
				}
				{
					proveedores = new JComboBox();
					ProveedorDTO p = new ProveedorLocalDTO();
					proveedores.addItem(p);

					for(Object proveedorDTO : ProveedorController.getInstance().buscarProveedores()){
						proveedores.addItem(proveedorDTO);						
					}

					getContentPane().add(proveedores);
					proveedores.setBounds(181, 37, 153, 23);
					
					proveedores.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							if(proveedores.getSelectedItem() instanceof ProveedorLocalDTO){
								ProveedorLocalDTO local = (ProveedorLocalDTO) proveedores.getSelectedItem();
								codigo.setText(String.valueOf(local.getCodigo()));
								nombre.setText(local.getNombre());
								telefono.setText(local.getTelefono());
							}else{
								CarrierDTO carrier = (CarrierDTO) proveedores.getSelectedItem();
								codigo.setText(String.valueOf(carrier.getCodigo()));
								nombre.setText(carrier.getNombre());
								telefono.setText(carrier.getTelefono());
							}
						}
					});
				}
				{
					jLabel1 = new JLabel();
					getContentPane().add(jLabel1);
					jLabel1.setText("Telefono:");
					jLabel1.setBounds(42, 191, 81, 16);
				}
				{
					EodigoLabel = new JLabel();
					getContentPane().add(EodigoLabel);
					EodigoLabel.setText("Codigo:");
					EodigoLabel.setBounds(42, 99, 72, 16);
				}
				{
					codigo = new JTextField();
					getContentPane().add(codigo);
					codigo.setEnabled(false);
					codigo.setBounds(181, 96, 153, 23);
				}
			}
			this.setSize(753, 514);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
