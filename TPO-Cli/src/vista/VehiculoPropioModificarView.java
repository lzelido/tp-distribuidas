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

public class VehiculoPropioModificarView extends javax.swing.JDialog {
	private static final long serialVersionUID = 9184645873008076439L;
	private JLabel labelMatricula;
	private JLabel tipoLabel;
	private JLabel informacionRegistroLabel;
	private JLabel kilometrajeLabel;
	@SuppressWarnings("rawtypes")
	private JComboBox vehiculos;
	private JLabel vehiculosLabel;
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
	private JButton modificar;
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
				VehiculoPropioModificarView inst = new VehiculoPropioModificarView(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public VehiculoPropioModificarView(JFrame frame) {
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
				this.setTitle("Modificar Vehículo");
				{
					labelMatricula = new JLabel();
					getContentPane().add(labelMatricula);
					labelMatricula.setText("Matricula");
					labelMatricula.setBounds(22, 79, 86, 16);
				}
				{
					tipoLabel = new JLabel();
					getContentPane().add(tipoLabel);
					tipoLabel.setText("Tipo");
					tipoLabel.setBounds(22, 115, 53, 16);
				}
				{
					volumenLabel = new JLabel();
					getContentPane().add(volumenLabel);
					volumenLabel.setText("Volumen");
					volumenLabel.setBounds(22, 155, 70, 16);
				}
				{
					unidadVolumenLabel = new JLabel();
					getContentPane().add(unidadVolumenLabel);
					unidadVolumenLabel.setText("Unidad Volumen");
					unidadVolumenLabel.setBounds(414, 155, 113, 16);
				}
				{
					taraLabel = new JLabel();
					getContentPane().add(taraLabel);
					taraLabel.setText("Tara");
					taraLabel.setBounds(22, 199, 49, 16);
				}
				{
					unidadTaraLabel = new JLabel();
					getContentPane().add(unidadTaraLabel);
					unidadTaraLabel.setText("Unidad Tara");
					unidadTaraLabel.setBounds(414, 199, 83, 16);
				}
				{
					condicionesTransporteLabel = new JLabel();
					getContentPane().add(condicionesTransporteLabel);
					condicionesTransporteLabel.setText("Condiciones Transporte");
					condicionesTransporteLabel.setBounds(22, 243, 159, 16);
				}
				{
					garantiaHastaLabel = new JLabel();
					getContentPane().add(garantiaHastaLabel);
					garantiaHastaLabel.setText("Garantía Hasta");
					garantiaHastaLabel.setBounds(22, 279, 105, 16);
				}
				{
					informacionRegistroLabel = new JLabel();
					getContentPane().add(informacionRegistroLabel);
					informacionRegistroLabel.setText("Información Registro");
					informacionRegistroLabel.setBounds(22, 319, 142, 16);
				}
				{
					kilometrajeLabel = new JLabel();
					getContentPane().add(kilometrajeLabel);
					kilometrajeLabel.setText("Kilometraje");
					kilometrajeLabel.setBounds(22, 358, 106, 16);
				}
				{
					vidaUtilLabel = new JLabel();
					getContentPane().add(vidaUtilLabel);
					vidaUtilLabel.setText("Vida Util");
					vidaUtilLabel.setBounds(22, 398, 68, 16);
				}
				{
					modificar = new JButton();
					getContentPane().add(modificar);
					modificar.setText("Modificar");
					modificar.setBounds(351, 423, 112, 23);
					modificar.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					    	VehiculoPropioDTO vehiculo = new VehiculoPropioDTO();
					    	vehiculo.setMatricula(matricula.getText());
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
								VehiculoController.getInstance().modificarVehiculoPropio(vehiculo);
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
					matricula.setBounds(165, 74, 186, 23);
					matricula.setEnabled(false);
				}
				{
					tipo = new JComboBox();
					
					for(TipoVehiculoDTO tipoDTO : TipoVehiculoController.getInstance().buscarTiposVehiculos()){
						tipo.addItem(tipoDTO);						
					}
										
					getContentPane().add(tipo);
					tipo.setBounds(165, 112, 186, 23);
				}
				{
					volumen = new JTextField();
					getContentPane().add(volumen);
					volumen.setBounds(165, 152, 186, 23);
				}
				{
					tara = new JTextField();
					getContentPane().add(tara);
					tara.setBounds(165, 196, 186, 23);
				}
				{
					condicionesTransporte = new JTextField();
					getContentPane().add(condicionesTransporte);
					condicionesTransporte.setBounds(165, 240, 186, 23);
				}
				{
					garantiaHasta = new JTextField();
					getContentPane().add(garantiaHasta);
					garantiaHasta.setBounds(165, 276, 186, 23);
				}
				{
					informacionRegistro = new JTextField();
					getContentPane().add(informacionRegistro);
					informacionRegistro.setBounds(165, 316, 186, 23);
				}
				{
					kilometraje = new JTextField();
					getContentPane().add(kilometraje);
					kilometraje.setBounds(165, 355, 186, 23);
				}
				{
					vidaUtil = new JTextField();
					getContentPane().add(vidaUtil);
					vidaUtil.setBounds(165, 390, 186, 23);
				}
				{
					unidadVolumen = new JComboBox();

					for(UnidadDTO unidadDTO : UnidadController.getInstance().buscarUnidadesVolumen()){
						unidadVolumen.addItem(unidadDTO);						
					}
					getContentPane().add(unidadVolumen);
					unidadVolumen.setBounds(524, 155, 157, 23);
				}
				{
					unidadTara = new JComboBox();

					for(UnidadDTO unidadDTO : UnidadController.getInstance().buscarUnidadesTara()){
						unidadTara.addItem(unidadDTO);						
					}

					getContentPane().add(unidadTara);
					unidadTara.setBounds(524, 196, 157, 23);
				}
				{
					vehiculosLabel = new JLabel();
					getContentPane().add(vehiculosLabel);
					vehiculosLabel.setText("Vehiculos");
					vehiculosLabel.setBounds(22, 12, 86, 16);
				}
				{
					vehiculos = new JComboBox();
					
					for(VehiculoPropioDTO v : VehiculoController.getInstance().buscarVehiculosPropio()){
						vehiculos.addItem(v);						
					}
					getContentPane().add(vehiculos);
					vehiculos.setBounds(165, 9, 186, 23);
					
					vehiculos.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							matricula.setText(((VehiculoPropioDTO)vehiculos.getSelectedItem()).getMatricula());
							tipo.setSelectedItem((((VehiculoPropioDTO)vehiculos.getSelectedItem()).getTipo()));
							volumen.setText(String.valueOf(((VehiculoPropioDTO)vehiculos.getSelectedItem()).getVolumen()));
							unidadVolumen.setSelectedItem(((VehiculoPropioDTO)vehiculos.getSelectedItem()).getUnidadVol());
							unidadTara.setSelectedItem(((VehiculoPropioDTO)vehiculos.getSelectedItem()).getUnidadTara());
							tara.setText(String.valueOf(((VehiculoPropioDTO)vehiculos.getSelectedItem()).getTara()));
							condicionesTransporte.setText(((VehiculoPropioDTO)vehiculos.getSelectedItem()).getCondicionesTransp());
							garantiaHasta.setText(((VehiculoPropioDTO)vehiculos.getSelectedItem()).getGarantiaHasta().toString());
							informacionRegistro.setText(((VehiculoPropioDTO)vehiculos.getSelectedItem()).getInformacionRegistro());
							kilometraje.setText(String.valueOf(((VehiculoPropioDTO)vehiculos.getSelectedItem()).getKilometraje()));
							vidaUtil.setText(String.valueOf(((VehiculoPropioDTO)vehiculos.getSelectedItem()).getVidaUtil()));							
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
