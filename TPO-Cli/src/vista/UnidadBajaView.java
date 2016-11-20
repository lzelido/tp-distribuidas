package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import controlador.UnidadController;
import dto.UnidadDTO;

public class UnidadBajaView extends javax.swing.JDialog {
	private static final long serialVersionUID = 9184645873008076439L;
	private JButton cancelar;
	private JButton altaUnidad;
	@SuppressWarnings("rawtypes")
	private JComboBox unidades;
	private JLabel unidadesLabel;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				UnidadBajaView inst = new UnidadBajaView(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public UnidadBajaView(JFrame frame) {
		super(frame);
		initGUI();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("Baja Unidad");
				{
					altaUnidad = new JButton();
					getContentPane().add(altaUnidad);
					altaUnidad.setText("Dar de Baja");
					altaUnidad.setBounds(351, 423, 112, 23);
					altaUnidad.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {					    
					        try {
								UnidadController.getInstance().bajaUnidad(((UnidadDTO)unidades.getSelectedItem()).getCodigo());
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
					unidadesLabel = new JLabel();
					getContentPane().add(unidadesLabel);
					unidadesLabel.setText("Unidades");
					unidadesLabel.setBounds(28, 37, 115, 16);
				}
				{
					unidades = new JComboBox();

					for(UnidadDTO unidadDTO : UnidadController.getInstance().buscarUnidades()){
						unidades.addItem(unidadDTO);						
					}

					getContentPane().add(unidades);
					unidades.setBounds(143, 30, 180, 23);
				}
			}
			this.setSize(753, 514);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
