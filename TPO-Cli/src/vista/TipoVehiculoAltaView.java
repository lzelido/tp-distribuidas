package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controlador.TipoVehiculoController;
import dto.TipoVehiculoDTO;

public class TipoVehiculoAltaView extends javax.swing.JDialog {
	private static final long serialVersionUID = 9184645873008076439L;
	private JButton cancelar;
	private JButton altaUnidad;
	private JLabel descripcionLabel;
	private JTextField condicionEspecial;
	private JLabel condicionEspecialLabel;
	private JCheckBox tieneCondicionEspecial;
	private JTextField descripcion;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				TipoVehiculoAltaView inst = new TipoVehiculoAltaView(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public TipoVehiculoAltaView(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("Alta Tipo Vehiculo");
				{
					altaUnidad = new JButton();
					getContentPane().add(altaUnidad);
					altaUnidad.setText("Dar de Alta");
					altaUnidad.setBounds(351, 423, 112, 23);
					altaUnidad.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					    	TipoVehiculoDTO tipoVehiculo = new TipoVehiculoDTO();
					    	tipoVehiculo.setDescri(descripcion.getText());
					    	tipoVehiculo.setTieneCondEspecial(tieneCondicionEspecial.isSelected());
					    	tipoVehiculo.setCondicion(condicionEspecial.getText());
					    
					        try {
								TipoVehiculoController.getInstance().altaTipoVehiculo(tipoVehiculo);
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
					descripcionLabel = new JLabel();
					getContentPane().add(descripcionLabel);
					descripcionLabel.setText("Descripcion:");
					descripcionLabel.setBounds(34, 41, 97, 16);
				}
				{
					descripcion = new JTextField();
					getContentPane().add(descripcion);
					descripcion.setBounds(166, 38, 168, 23);
				}
				{
					tieneCondicionEspecial = new JCheckBox();
					getContentPane().add(tieneCondicionEspecial);
					tieneCondicionEspecial.setText("Tiene Condicion Especial");
					tieneCondicionEspecial.setBounds(34, 82, 251, 20);
					tieneCondicionEspecial.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							if(tieneCondicionEspecial.isSelected()){
								condicionEspecial.setEnabled(true);
							}else{
								condicionEspecial.setText("");
								condicionEspecial.setEnabled(false);
							}
						}
					});
				}
				{
					condicionEspecialLabel = new JLabel();
					getContentPane().add(condicionEspecialLabel);
					condicionEspecialLabel.setText("Condicion Especial:");
					condicionEspecialLabel.setBounds(34, 129, 132, 16);
				}
				{
					condicionEspecial = new JTextField();
					condicionEspecial.setEnabled(false);
					getContentPane().add(condicionEspecial);
					condicionEspecial.setBounds(166, 126, 168, 23);
				}
			}
			this.setSize(753, 514);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
