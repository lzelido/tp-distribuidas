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

import controlador.TipoVehiculoController;
import controlador.UnidadController;
import controlador.VehiculoController;
import dto.TipoVehiculoDTO;
import dto.UnidadDTO;
import dto.VehiculoPropioDTO;

public class VehiculoPropioAltaView extends javax.swing.JDialog {
	private static final long serialVersionUID = 9184645873008076439L;
	private JLabel labelMatricula;
	private JLabel tipoLabel;
	private JLabel informacionRegistroLabel;
	private JLabel kilometrajeLabel;
	@SuppressWarnings("rawtypes")
	private JComboBox unidadTara;
	@SuppressWarnings("rawtypes")
	private JComboBox unidadVolumen;
	private JTextField vidaUtil;
	private JTextField kilometraje;
	private JTextField informacionRegistro;
	private JTextField garantiaHasta;
	private JTextField condicionesTransporte;
	private JTextField tara;
	private JTextField volumen;
	@SuppressWarnings("rawtypes")
	private JComboBox tipo;
	private JTextField matricula;
	private JLabel vidaUtilLabel;
	private JButton cancelar;
	private JButton altaVehiculo;
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
				VehiculoPropioAltaView inst = new VehiculoPropioAltaView(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public VehiculoPropioAltaView(JFrame frame) {
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
					garantiaHastaLabel.setText("Garantía Hasta (yyyy-mm-dd)");
					garantiaHastaLabel.setBounds(22, 240, 160, 16);
				}
				{
					informacionRegistroLabel = new JLabel();
					getContentPane().add(informacionRegistroLabel);
					informacionRegistroLabel.setText("Información Registro");
					informacionRegistroLabel.setBounds(22, 275, 142, 16);
				}
				{
					kilometrajeLabel = new JLabel();
					getContentPane().add(kilometrajeLabel);
					kilometrajeLabel.setText("Kilometraje");
					kilometrajeLabel.setBounds(22, 314, 106, 16);
				}
				{
					vidaUtilLabel = new JLabel();
					getContentPane().add(vidaUtilLabel);
					vidaUtilLabel.setText("Vida Util(años)");
					vidaUtilLabel.setBounds(22, 354, 100, 16);
				}
				{
					altaVehiculo = new JButton();
					getContentPane().add(altaVehiculo);
					altaVehiculo.setText("Dar de Alta");
					altaVehiculo.setBounds(351, 423, 112, 23);
					altaVehiculo.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					    	VehiculoPropioDTO vehiculo = new VehiculoPropioDTO();
					    	vehiculo.setActivo(true);
					    	vehiculo.setCondicionesTransp(condicionesTransporte.getText());
					    	vehiculo.setEnMantenimiento(false);
					    	Date fecha = null;
					    	SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
					    	try {
					    		fecha = formatoFecha.parse(garantiaHasta.getText());
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
					    	vehiculo.setGarantiaHasta(fecha);
					    	vehiculo.setInformacionRegistro(informacionRegistro.getText());
					    	vehiculo.setKilometraje(Integer.parseInt(kilometraje.getText()));
					    	vehiculo.setMatricula(matricula.getText());
					    	vehiculo.setTara(Float.parseFloat(tara.getText()));
					    	vehiculo.setTipo((TipoVehiculoDTO)tipo.getSelectedItem());
					    	vehiculo.setUnidadTara((UnidadDTO)unidadTara.getSelectedItem());
					    	vehiculo.setUnidadVol((UnidadDTO)unidadVolumen.getSelectedItem());
					    	vehiculo.setVidaUtil(Integer.parseInt(vidaUtil.getText()));
					    	vehiculo.setVolumen(Float.parseFloat(volumen.getText()));
					        try {
								VehiculoController.getInstance().altaVehiculoPropio(vehiculo);
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					    }
					});
				}
				{
					matricula = new JTextField();
					getContentPane().add(matricula);
					matricula.setBounds(175, 30, 186, 23);
				}
				{
					tipo = new JComboBox();
					
					for(TipoVehiculoDTO tipoDTO : TipoVehiculoController.getInstance().buscarTiposVehiculos()){
						tipo.addItem(tipoDTO);						
					}
										
					getContentPane().add(tipo);
					tipo.setBounds(175, 68, 186, 23);
				}
				{
					volumen = new JTextField();
					getContentPane().add(volumen);
					volumen.setBounds(175, 108, 186, 23);
				}
				{
					tara = new JTextField();
					getContentPane().add(tara);
					tara.setBounds(175, 152, 186, 23);
				}
				{
					condicionesTransporte = new JTextField();
					getContentPane().add(condicionesTransporte);
					condicionesTransporte.setBounds(175, 196, 186, 23);
				}
				{
					garantiaHasta = new JTextField();
					getContentPane().add(garantiaHasta);
					garantiaHasta.setBounds(175, 232, 186, 23);
				}
				{
					informacionRegistro = new JTextField();
					getContentPane().add(informacionRegistro);
					informacionRegistro.setBounds(175, 272, 186, 23);
				}
				{
					kilometraje = new JTextField();
					getContentPane().add(kilometraje);
					kilometraje.setBounds(175, 311, 186, 23);
				}
				{
					vidaUtil = new JTextField();
					getContentPane().add(vidaUtil);
					vidaUtil.setBounds(175, 346, 186, 23);
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
			}
			this.setSize(753, 514);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
