package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controlador.UnidadController;
import dto.UnidadDTO;

public class UnidadAltaView extends javax.swing.JDialog {
	private static final long serialVersionUID = 9184645873008076439L;
	private JButton cancelar;
	private JButton altaUnidad;
	private JLabel descripcionLabel;
	private JTextField descripcion;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				UnidadAltaView inst = new UnidadAltaView(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public UnidadAltaView(JFrame frame) {
		super(frame);
		initGUI();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("Alta Unidad");
				{
					altaUnidad = new JButton();
					getContentPane().add(altaUnidad);
					altaUnidad.setText("Dar de Alta");
					altaUnidad.setBounds(351, 423, 112, 23);
					altaUnidad.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					    	UnidadDTO unidad = new UnidadDTO();
					    	unidad.setDescri(descripcion.getText());
					    
					        try {
								UnidadController.getInstance().altaUnidad(unidad);
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
					descripcionLabel.setText("Descripcion: ");
					descripcionLabel.setBounds(28, 37, 115, 16);
				}
				{
					descripcion = new JTextField();
					getContentPane().add(descripcion);
					descripcion.setBounds(161, 34, 165, 23);
				}
			}
			this.setSize(753, 514);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
