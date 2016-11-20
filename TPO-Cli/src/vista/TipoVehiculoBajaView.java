package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import controlador.TipoVehiculoController;
import dto.TipoVehiculoDTO;

public class TipoVehiculoBajaView extends javax.swing.JDialog {
	private static final long serialVersionUID = 9184645873008076439L;
	private JButton cancelar;
	private JButton altaUnidad;
	private JLabel tiposVehiculoLabel;
	@SuppressWarnings("rawtypes")
	private JComboBox tiposVehiculo;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				TipoVehiculoBajaView inst = new TipoVehiculoBajaView(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public TipoVehiculoBajaView(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("Baja Tipo Vehiculo");
				{
					altaUnidad = new JButton();
					getContentPane().add(altaUnidad);
					altaUnidad.setText("Dar de Alta");
					altaUnidad.setBounds(351, 423, 112, 23);
					altaUnidad.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {					    
					        try {
								TipoVehiculoController.getInstance().bajaTipoVehiculo(((TipoVehiculoDTO)tiposVehiculo.getSelectedItem()).getCodigo());
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
					tiposVehiculoLabel = new JLabel();
					getContentPane().add(tiposVehiculoLabel);
					tiposVehiculoLabel.setText("Tipos Vehiculos:");
					tiposVehiculoLabel.setBounds(37, 38, 117, 16);
				}
				{
					tiposVehiculo = new JComboBox();
					
					for(TipoVehiculoDTO tipoDTO : TipoVehiculoController.getInstance().buscarTiposVehiculos()){
						tiposVehiculo.addItem(tipoDTO);						
					}
					getContentPane().add(tiposVehiculo);
					tiposVehiculo.setBounds(188, 35, 219, 23);
				}
			}
			this.setSize(753, 514);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
