package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controlador.ProveedorController;
import controlador.TipoVehiculoController;
import controlador.UnidadController;
import controlador.VehiculoController;
import dto.TipoVehiculoDTO;
import dto.UnidadDTO;
import dto.VehiculoExternoDTO;

public class VehiculoExternoAltaView extends javax.swing.JDialog {
	private static final long serialVersionUID = 9184645873008076439L;
	private JLabel labelMatricula;
	private JLabel tipoLabel;
	@SuppressWarnings("rawtypes")
	private JComboBox unidadTara;
	@SuppressWarnings("rawtypes")
	private JComboBox unidadVolumen;
	private JTextField garantiaHasta;
	private JTextField condicionesTransporte;
	private JTextField tara;
	private JTextField volumen;
	@SuppressWarnings("rawtypes")
	private JComboBox tipo;
	private JTextField matricula;
	private JButton cancelar;
	private JButton altaVehiculo;
	@SuppressWarnings("rawtypes")
	private JComboBox proveedor;
	private JLabel proveedorLabel;
	private JLabel garantiaHastaLabel;
	private JLabel condicionesTransporteLabel;
	private JLabel unidadTaraLabel;
	private JLabel taraLabel;
	private JLabel unidadVolumenLabel;
	private JLabel volumenLabel;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				VehiculoExternoAltaView inst = new VehiculoExternoAltaView(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public VehiculoExternoAltaView(JFrame frame) {
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
				this.setTitle("Alta Vehículo");
				{
					labelMatricula = new JLabel();
					getContentPane().add(labelMatricula);
					labelMatricula.setText("Matricula");
					labelMatricula.setBounds(22, 35, 86, 16);
				}
				{
					tipoLabel = new JLabel();
					getContentPane().add(tipoLabel);
					tipoLabel.setText("Tipo");
					tipoLabel.setBounds(22, 71, 53, 16);
				}
				{
					volumenLabel = new JLabel();
					getContentPane().add(volumenLabel);
					volumenLabel.setText("Volumen");
					volumenLabel.setBounds(22, 111, 70, 16);
				}
				{
					unidadVolumenLabel = new JLabel();
					getContentPane().add(unidadVolumenLabel);
					unidadVolumenLabel.setText("Unidad Volumen");
					unidadVolumenLabel.setBounds(414, 111, 113, 16);
				}
				{
					taraLabel = new JLabel();
					getContentPane().add(taraLabel);
					taraLabel.setText("Tara");
					taraLabel.setBounds(22, 155, 49, 16);
				}
				{
					unidadTaraLabel = new JLabel();
					getContentPane().add(unidadTaraLabel);
					unidadTaraLabel.setText("Unidad Tara");
					unidadTaraLabel.setBounds(414, 155, 83, 16);
				}
				{
					condicionesTransporteLabel = new JLabel();
					getContentPane().add(condicionesTransporteLabel);
					condicionesTransporteLabel.setText("Condiciones Transporte");
					condicionesTransporteLabel.setBounds(22, 199, 159, 16);
				}
				{
					garantiaHastaLabel = new JLabel();
					getContentPane().add(garantiaHastaLabel);
					garantiaHastaLabel.setText("Garantía Hasta");
					garantiaHastaLabel.setBounds(22, 235, 105, 16);
				}
				{
					altaVehiculo = new JButton();
					getContentPane().add(altaVehiculo);
					altaVehiculo.setText("Dar de Alta");
					altaVehiculo.setBounds(351, 423, 112, 23);
					altaVehiculo.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					    	VehiculoExternoDTO vehiculo = new VehiculoExternoDTO();
					    	vehiculo.setCondicionesTransp(condicionesTransporte.getText());
					    	Date fecha = null;
					    	SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
					    	try {
					    		fecha = formatoFecha.parse(garantiaHasta.getText());
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
					    	vehiculo.setGarantiaHasta(fecha);
					    	vehiculo.setMatricula(matricula.getText());
					    	vehiculo.setTara(Float.parseFloat(tara.getText()));
					    	vehiculo.setTipo((TipoVehiculoDTO)tipo.getSelectedItem());
					    	vehiculo.setUnidadTara((UnidadDTO)unidadTara.getSelectedItem());
					    	vehiculo.setUnidadVol((UnidadDTO)unidadVolumen.getSelectedItem());
					    	vehiculo.setVolumen(Float.parseFloat(volumen.getText()));
					    	vehiculo.setProveedor(proveedor.getSelectedItem());
					        try {
								VehiculoController.getInstance().altaVehiculoExterno(vehiculo);
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
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
					matricula = new JTextField();
					getContentPane().add(matricula);
					matricula.setBounds(165, 30, 186, 23);
				}
				{
					tipo = new JComboBox();
					
					for(TipoVehiculoDTO tipoDTO : TipoVehiculoController.getInstance().buscarTiposVehiculos()){
						tipo.addItem(tipoDTO);						
					}
										
					getContentPane().add(tipo);
					tipo.setBounds(165, 68, 186, 23);
				}
				{
					volumen = new JTextField();
					getContentPane().add(volumen);
					volumen.setBounds(165, 108, 186, 23);
				}
				{
					tara = new JTextField();
					getContentPane().add(tara);
					tara.setBounds(165, 152, 186, 23);
				}
				{
					condicionesTransporte = new JTextField();
					getContentPane().add(condicionesTransporte);
					condicionesTransporte.setBounds(165, 196, 186, 23);
				}
				{
					garantiaHasta = new JTextField();
					getContentPane().add(garantiaHasta);
					garantiaHasta.setBounds(165, 232, 186, 23);
				}
				{
					unidadVolumen = new JComboBox();

					for(UnidadDTO unidadDTO : UnidadController.getInstance().buscarUnidadesVolumen()){
						unidadVolumen.addItem(unidadDTO);						
					}
					getContentPane().add(unidadVolumen);
					unidadVolumen.setBounds(524, 111, 157, 23);
				}
				{
					unidadTara = new JComboBox();

					for(UnidadDTO unidadDTO : UnidadController.getInstance().buscarUnidadesTara()){
						unidadTara.addItem(unidadDTO);						
					}

					getContentPane().add(unidadTara);
					unidadTara.setBounds(524, 152, 157, 23);
				}
				{
					proveedorLabel = new JLabel();
					getContentPane().add(proveedorLabel);
					proveedorLabel.setText("Proveedor");
					proveedorLabel.setBounds(414, 71, 89, 16);
				}
				{
					proveedor = new JComboBox();

					for(Object proveedorDTO : ProveedorController.getInstance().buscarProveedores()){
						proveedor.addItem(proveedorDTO);						
					}

					getContentPane().add(proveedor);
					proveedor.setBounds(527, 68, 154, 23);
				}
			}
			this.setSize(753, 514);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
