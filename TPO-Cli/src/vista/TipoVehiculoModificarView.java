package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controlador.TipoVehiculoController;
import dto.TipoVehiculoDTO;

public class TipoVehiculoModificarView extends javax.swing.JDialog {
	private static final long serialVersionUID = 9184645873008076439L;
	private JButton cancelar;
	private JButton modificar;
	private JLabel descripcionLabel;
	private JTextField codigo;
	@SuppressWarnings("rawtypes")
	private JComboBox tipos;
	private JLabel tiposLabel;
	private JLabel codigoLabel;
	private JTextField condicionEspecial;
	private JLabel condicionEspecialLabel;
	private JCheckBox tieneCondicionEspecial;
	private JTextField descripcion;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				TipoVehiculoModificarView inst = new TipoVehiculoModificarView(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public TipoVehiculoModificarView(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("Modificar Tipo Vehiculo");
				{
					modificar = new JButton();
					getContentPane().add(modificar);
					modificar.setText("Modificar");
					modificar.setBounds(351, 423, 112, 23);
					modificar.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					    	TipoVehiculoDTO tipoVehiculo = new TipoVehiculoDTO();
					    	tipoVehiculo.setCodigo(Integer.valueOf(codigo.getText()));
					    	tipoVehiculo.setDescri(descripcion.getText());
					    	tipoVehiculo.setTieneCondEspecial(tieneCondicionEspecial.isSelected());
					    	tipoVehiculo.setCondicion(condicionEspecial.getText());
					    
					        try {
								TipoVehiculoController.getInstance().modificarTipoVehiculo(tipoVehiculo);
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
					descripcionLabel.setBounds(34, 122, 97, 16);
				}
				{
					descripcion = new JTextField();
					getContentPane().add(descripcion);
					descripcion.setBounds(166, 119, 168, 23);
				}
				{
					tieneCondicionEspecial = new JCheckBox();
					getContentPane().add(tieneCondicionEspecial);
					tieneCondicionEspecial.setText("Tiene Condicion Especial");
					tieneCondicionEspecial.setBounds(34, 163, 251, 20);
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
					condicionEspecialLabel.setBounds(34, 210, 132, 16);
				}
				{
					condicionEspecial = new JTextField();
					condicionEspecial.setEnabled(false);
					getContentPane().add(condicionEspecial);
					condicionEspecial.setBounds(166, 207, 168, 23);
				}
				{
					codigoLabel = new JLabel();
					getContentPane().add(codigoLabel);
					codigoLabel.setText("Codigo:");
					codigoLabel.setBounds(34, 79, 84, 16);
				}
				{
					codigo = new JTextField();
					getContentPane().add(codigo);
					codigo.setEnabled(false);
					codigo.setBounds(166, 76, 168, 23);
				}
				{
					tiposLabel = new JLabel();
					getContentPane().add(tiposLabel);
					tiposLabel.setText("Tipos:");
					tiposLabel.setBounds(36, 35, 71, 16);
				}
				{
					tipos = new JComboBox();
					
					TipoVehiculoDTO tv = new TipoVehiculoDTO();
					tipos.addItem(tv);					
					for(TipoVehiculoDTO tipoDTO : TipoVehiculoController.getInstance().buscarTiposVehiculos()){
						tipos.addItem(tipoDTO);						
					}	
										
					getContentPane().add(tipos);
					tipos.setBounds(166, 32, 168, 23);
					tipos.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							TipoVehiculoDTO tipoVehiculo = (TipoVehiculoDTO) tipos.getSelectedItem();
							codigo.setText(String.valueOf(tipoVehiculo.getCodigo()));
							descripcion.setText(tipoVehiculo.getDescri());
							tieneCondicionEspecial.setSelected(tipoVehiculo.isTieneCondEspecial());
							if(tipoVehiculo.isTieneCondEspecial()){
								condicionEspecial.setEnabled(true);
								condicionEspecial.setText(tipoVehiculo.getCondicion());
							}else{
								condicionEspecial.setEnabled(false);
								condicionEspecial.setText("");
							}
						}
					});
				}
			}
			this.setSize(753, 514);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
