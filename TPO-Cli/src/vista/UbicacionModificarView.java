package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import controlador.UbicacionController;
import dto.EmpresaDTO;
import dto.GPSDTO;
import dto.RemitoDTO;
import dto.SucursalDTO;
import dto.TallerDTO;
import dto.UbicacionDTO;

public class UbicacionModificarView extends javax.swing.JDialog {
	private static final long serialVersionUID = 1L;
	private ImageIcon picture;
	private JLabel lblCalle;
	private JTextField txtCalle;
	private JLabel lblNumero;
	private JTextField txtNumero;
	private JLabel lblPiso;
	private JTextField txtPiso;
	private JLabel lblDepto;
	private JTextField txtDepto;
	private JLabel lblCodPos;
	private JTextField txtCodPos;
	private JLabel lblLocalidad;
	private JTextField txtLocalidad;
	private JLabel lblProvincia;
	private JTextField txtProvincia;
	private JLabel lblGPS;
	@SuppressWarnings("rawtypes")
	private JComboBox cboLatitud;
	private JLabel lblLatitud;
	private JTextField txtGradoLat;
	private JLabel lblGradoLat;
	private JTextField txtMinutoLat;
	private JLabel lblMinutoLat;
	private JTextField txtSegundoLat;
	private JLabel lblSegundoLat;
	private JLabel lblLongitud;
	@SuppressWarnings("rawtypes")
	private JComboBox cboLongitud;
	private JTextField txtGradoLon;
	private JLabel lblGradoLon;
	private JTextField txtMinutoLon;
	private JLabel lblMinutoLon;
	private JTextField txtSegundoLon;
	private JLabel lblSegundoLon;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private static UbicacionDTO ubicacionAct;
	private static EmpresaDTO empresaAct; 
	private static RemitoDTO remitoAct;
	private static SucursalDTO sucursalAct;
	private static TallerDTO tallerAct;

	public UbicacionModificarView(UbicacionDTO ubicacion, EmpresaDTO empresa, RemitoDTO reminto, SucursalDTO sucursal, TallerDTO taller) {
		super();
		initGUI();
		this.loadData(ubicacion, empresa, reminto, sucursal, taller);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Modificar de Ubicación");
			picture = new ImageIcon("C:/Users/Facu/git/tpo_cliente-ad15/TPO_Cliente/picture/4.png");
			this.setIconImage(picture.getImage());
			{
				lblCalle = new JLabel();
				getContentPane().add(lblCalle);
				lblCalle.setText("Calle");
				lblCalle.setBounds(12, 12, 54, 16);
			}
			{
				txtCalle = new JTextField();
				getContentPane().add(txtCalle);
				txtCalle.setBounds(78, 9, 294, 23);
			}
			{
				lblNumero = new JLabel();
				getContentPane().add(lblNumero);
				lblNumero.setText("Número");
				lblNumero.setBounds(12, 49, 66, 16);
			}
			{
				txtNumero = new JTextField();
				getContentPane().add(txtNumero);
				txtNumero.setBounds(78, 46, 105, 23);
			}
			{
				lblPiso = new JLabel();
				getContentPane().add(lblPiso);
				lblPiso.setText("Piso");
				lblPiso.setBounds(246, 49, 41, 16);
			}
			{
				txtPiso = new JTextField();
				getContentPane().add(txtPiso);
				txtPiso.setBounds(287, 46, 85, 23);
			}
			{
				lblDepto = new JLabel();
				getContentPane().add(lblDepto);
				lblDepto.setText("Depto");
				lblDepto.setBounds(12, 84, 66, 16);
			}
			{
				txtDepto = new JTextField();
				getContentPane().add(txtDepto);
				txtDepto.setBounds(78, 81, 105, 23);
			}
			{
				lblCodPos = new JLabel();
				getContentPane().add(lblCodPos);
				lblCodPos.setText("Código Postal");
				lblCodPos.setBounds(195, 84, 92, 16);
			}
			{
				txtCodPos = new JTextField();
				getContentPane().add(txtCodPos);
				txtCodPos.setBounds(287, 81, 85, 23);
			}
			{
				lblLocalidad = new JLabel();
				getContentPane().add(lblLocalidad);
				lblLocalidad.setText("Localidad");
				lblLocalidad.setBounds(12, 119, 66, 16);
			}
			{
				txtLocalidad = new JTextField();
				getContentPane().add(txtLocalidad);
				txtLocalidad.setBounds(78, 116, 294, 23);
			}
			{
				lblProvincia = new JLabel();
				getContentPane().add(lblProvincia);
				lblProvincia.setText("Provincia");
				lblProvincia.setBounds(12, 154, 66, 16);
			}
			{
				txtProvincia = new JTextField();
				getContentPane().add(txtProvincia);
				txtProvincia.setBounds(78, 151, 294, 23);
			}
			{
				lblGPS = new JLabel();
				getContentPane().add(lblGPS);
				lblGPS.setText("GPS");
				lblGPS.setBounds(12, 186, 54, 16);
				lblGPS.setFont(new Font("Calibri", Font.ITALIC, 14));
			}
			{
				ComboBoxModel cboLatitudModel = 
						new DefaultComboBoxModel(
								new String[] { "Norte", "Sur" });
				cboLatitud = new JComboBox();
				getContentPane().add(cboLatitud);
				cboLatitud.setModel(cboLatitudModel);
				cboLatitud.setBounds(79, 211, 65, 23);
			}
			{
				lblLatitud = new JLabel();
				getContentPane().add(lblLatitud);
				lblLatitud.setText("Latitud");
				lblLatitud.setBounds(12, 214, 49, 16);
			}
			{
				txtGradoLat = new JTextField();
				getContentPane().add(txtGradoLat);
				txtGradoLat.setBounds(156, 211, 40, 23);
			}
			{
				lblGradoLat = new JLabel();
				getContentPane().add(lblGradoLat);
				lblGradoLat.setText("°");
				lblGradoLat.setBounds(198, 214, 10, 16);
			}
			{
				txtMinutoLat = new JTextField();
				getContentPane().add(txtMinutoLat);
				txtMinutoLat.setBounds(219, 211, 40, 23);
			}
			{
				lblMinutoLat = new JLabel();
				getContentPane().add(lblMinutoLat);
				lblMinutoLat.setText("'");
				lblMinutoLat.setBounds(261, 214, 10, 16);
			}
			{
				txtSegundoLat = new JTextField();
				getContentPane().add(txtSegundoLat);
				txtSegundoLat.setBounds(277, 211, 40, 23);
			}
			{
				lblSegundoLat = new JLabel();
				getContentPane().add(lblSegundoLat);
				lblSegundoLat.setText("\"");
				lblSegundoLat.setBounds(318, 214, 10, 16);
			}
			{
				lblLongitud = new JLabel();
				getContentPane().add(lblLongitud);
				lblLongitud.setText("Longitud");
				lblLongitud.setBounds(12, 242, 66, 16);
			}
			{
				ComboBoxModel cboLongitudModel = 
						new DefaultComboBoxModel(
								new String[] { "Este", "Oeste" });
				cboLongitud = new JComboBox();
				getContentPane().add(cboLongitud);
				cboLongitud.setModel(cboLongitudModel);
				cboLongitud.setBounds(78, 239, 66, 23);
			}
			{
				txtGradoLon = new JTextField();
				getContentPane().add(txtGradoLon);
				txtGradoLon.setBounds(156, 239, 40, 23);
			}
			{
				lblGradoLon = new JLabel();
				getContentPane().add(lblGradoLon);
				lblGradoLon.setText("°");
				lblGradoLon.setBounds(198, 242, 10, 16);
			}
			{
				txtMinutoLon = new JTextField();
				getContentPane().add(txtMinutoLon);
				txtMinutoLon.setBounds(219, 239, 40, 23);
			}
			{
				lblMinutoLon = new JLabel();
				getContentPane().add(lblMinutoLon);
				lblMinutoLon.setText("'");
				lblMinutoLon.setBounds(261, 242, 10, 16);
			}
			{
				txtSegundoLon = new JTextField();
				getContentPane().add(txtSegundoLon);
				txtSegundoLon.setBounds(277, 239, 40, 23);
			}
			{
				lblSegundoLon = new JLabel();
				getContentPane().add(lblSegundoLon);
				lblSegundoLon.setText("\"");
				lblSegundoLon.setBounds(318, 242, 10, 16);
			}
			{
				btnAceptar = new JButton();
				getContentPane().add(btnAceptar);
				btnAceptar.setText("Aceptar");
				btnAceptar.setBounds(12, 294, 108, 23);
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAceptar (evt);
					}
				});
			}
			{
				btnCancelar = new JButton();
				getContentPane().add(btnCancelar);
				btnCancelar.setText("Cancelar");
				btnCancelar.setBounds(265, 294, 108, 23);
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCancelar (evt);
					}
				});
			}

			this.setSize(400, 366);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadData (UbicacionDTO ubicacion, EmpresaDTO empresa, RemitoDTO remito, SucursalDTO sucursal, TallerDTO taller){
		try {
			if(empresa != null && remito == null && sucursal == null && taller == null){
				empresaAct = new EmpresaDTO();
				empresaAct.setCodigo(empresa.getCodigo());
				ubicacionAct = new UbicacionDTO();
				ubicacionAct.setCodigo(ubicacion.getCodigo());
				ubicacionAct.setCalle(ubicacion.getCalle());
				ubicacionAct.setNumero(ubicacion.getNumero());
				ubicacionAct.setPiso(ubicacion.getPiso());
				ubicacionAct.setDepto(ubicacion.getDepto());
				ubicacionAct.setCodPost(ubicacion.getCodPost());
				ubicacionAct.setLocalidad(ubicacion.getLocalidad());
				ubicacionAct.setProvincia(ubicacion.getProvincia());
				GPSDTO gps = ubicacion.getGps();
				ubicacionAct.setGps(gps);
				
				this.txtCalle.setText(ubicacionAct.getCalle());
				this.txtNumero.setText(String.valueOf(ubicacionAct.getNumero()));
				this.txtPiso.setText(String.valueOf(ubicacionAct.getPiso()));
				this.txtDepto.setText(ubicacionAct.getDepto());
				this.txtCodPos.setText(ubicacionAct.getCodPost());
				this.txtLocalidad.setText(ubicacionAct.getLocalidad());
				this.txtProvincia.setText(ubicacionAct.getProvincia());
				
				if (ubicacionAct.getGps() != null){
					String latitud = ubicacionAct.getGps().getLatitud();
					if(latitud.equals("Norte")){
						this.cboLatitud.setSelectedIndex(0);
					}else{
						this.cboLatitud.setSelectedIndex(1);
					}
					this.txtGradoLat.setText(String.valueOf(ubicacionAct.getGps().getGradosLat()));
					this.txtMinutoLat.setText(String.valueOf(ubicacionAct.getGps().getMinutosLat()));
					this.txtSegundoLat.setText(String.valueOf(ubicacionAct.getGps().getSegundosLat()));
					
					String longitud = ubicacionAct.getGps().getLongitud();
					if(longitud.equals("Este")){
						this.cboLongitud.setSelectedIndex(0);
					}else{
						this.cboLongitud.setSelectedIndex(1);
					}
					this.txtGradoLon.setText(String.valueOf(ubicacionAct.getGps().getGradosLon()));
					this.txtMinutoLon.setText(String.valueOf(ubicacionAct.getGps().getMinutosLon()));
					this.txtSegundoLon.setText(String.valueOf(ubicacionAct.getGps().getSegundosLon()));
				}				
			}else{
				if(remito != null && empresa == null  && sucursal == null && taller == null){
					remitoAct = new RemitoDTO();
					remitoAct.setCodigo(remito.getCodigo());
				}else{
					if(sucursal != null && empresa == null  && remito == null && taller == null){
						sucursalAct = new SucursalDTO();
						sucursalAct.setCodigo(sucursal.getCodigo());
					}else{
						if(taller != null && empresa == null  && remito == null && sucursal == null){
							tallerAct = new TallerDTO();
							tallerAct.setCodigo(taller.getCodigo());
						}else{
							String mensaje = "Error en los parámetros de ingreso a la pantalla";
							JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al cargar la pantalla de alta de una ubicación: " + e.getMessage());
			System.out.println("Stack Trace al cargar la pantalla de alta de una ubicación: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		} 
	}
	
	private void btnAceptar (ActionEvent evt){
		try {
			UbicacionDTO ubicacion = new UbicacionDTO();
			ubicacion.setCodigo(ubicacionAct.getCodigo());
			ubicacion.setCalle(this.txtCalle.getText());
			
			if(this.txtNumero.getText().isEmpty()){
				ubicacion.setNumero(0);
			}else{
				ubicacion.setNumero(Integer.valueOf(this.txtNumero.getText()));
			}
			
			if(this.txtPiso.getText().isEmpty()){
				ubicacion.setPiso(0);
			}else{
				ubicacion.setPiso(Integer.valueOf(this.txtPiso.getText()));
			}
			
			ubicacion.setDepto(this.txtDepto.getText());
			ubicacion.setCodPost(this.txtCodPos.getText());
			ubicacion.setLocalidad(this.txtLocalidad.getText());
			ubicacion.setProvincia(this.txtProvincia.getText());
			
			if (!this.txtGradoLat.getText().equals("") && !this.txtGradoLon.getText().equals("")){
				if(!this.txtMinutoLat.getText().equals("") && !this.txtMinutoLon.getText().equals("")){
					if (!this.txtSegundoLat.getText().equals("") && !this.txtSegundoLon.getText().equals("")){
						GPSDTO gps = new GPSDTO();
						
						gps.setLatitud(this.cboLatitud.getSelectedItem().toString());
						gps.setGradosLat(Integer.valueOf(this.txtGradoLat.getText()));
						gps.setMinutosLat(Integer.valueOf(this.txtMinutoLat.getText()));
						gps.setSegundosLat(Integer.valueOf(this.txtSegundoLat.getText()));
						
						gps.setLongitud(this.cboLongitud.getSelectedItem().toString());
						gps.setGradosLon(Integer.valueOf(this.txtGradoLon.getText()));
						gps.setMinutosLon(Integer.valueOf(this.txtMinutoLon.getText()));
						gps.setSegundosLon(Integer.valueOf(this.txtSegundoLon.getText()));
						
						ubicacion.setGps(gps);
					}
				}
			}

			int check = 0;
			if (empresaAct != null && remitoAct == null && sucursalAct == null && tallerAct == null){
				check = UbicacionController.getInstance().modificarUbicacionCliente(empresaAct.getCodigo(), ubicacion);
				if (check == 3){
					String mensaje = "Se modificó la ubicación";
					JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
					UbicacionModificarView.this.dispose();
					new ClienteEmpresaModificarView(empresaAct);
				}else{
					if(check == 2){
						String mensaje = "La ubicacion no existe para la empresa";
						JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
					}else{
						if(check == 1){
							String mensaje = "La empresa no existe";
							JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
						}else{
							String mensaje = "Falla en la modificación de la ubicación";
							JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				}				
			}else{
				if(remitoAct != null && empresaAct == null  && sucursalAct == null && tallerAct == null){
					UbicacionModificarView.this.dispose();
				}else{
					if(sucursalAct != null && empresaAct == null  && remitoAct == null && tallerAct == null){
						UbicacionModificarView.this.dispose();
					}else{
						if(tallerAct != null && empresaAct == null  && remitoAct == null && sucursalAct == null){
							UbicacionModificarView.this.dispose();
						}
					}
				}
			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al modificar una ubicación: " + e.getMessage());
			System.out.println("Stack Trace al modificar una ubicación: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnCancelar (ActionEvent evt){
		try{
			if(empresaAct != null && remitoAct == null && sucursalAct == null && tallerAct == null){
				UbicacionModificarView.this.dispose();
				new ClienteEmpresaModificarView(empresaAct);
			}else{
				if(remitoAct != null && empresaAct == null  && sucursalAct == null && tallerAct == null){
					UbicacionModificarView.this.dispose();
				}else{
					if(sucursalAct != null && empresaAct == null  && remitoAct == null && tallerAct == null){
						UbicacionModificarView.this.dispose();
					}else{
						if(tallerAct != null && empresaAct == null  && remitoAct == null && sucursalAct == null){
							UbicacionModificarView.this.dispose();
						}
					}
				}
			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al cancelar la modificación de una ubicación: " + e.getMessage());
			System.out.println("Stack Trace al cancelar el modificación de una ubicación: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
