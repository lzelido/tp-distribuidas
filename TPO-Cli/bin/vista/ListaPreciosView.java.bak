package vista;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.ListaPreciosController;
import controlador.TipoVehiculoController;
import dto.ListaPreciosDTO;
import dto.TipoVehiculoDTO;



/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
@SuppressWarnings("serial")
public class ListaPreciosView extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel3;
	private JLabel jLabel9;
	private JTextField jTextFieldPeso;
	@SuppressWarnings("rawtypes")
	private JComboBox cboZ;
	@SuppressWarnings("rawtypes")
	private JComboBox cboY;
	@SuppressWarnings("rawtypes")
	private JComboBox cboX;
	private JLabel jLabel2;
	private JTextField txtCoordenadaPrecio; 
	@SuppressWarnings("rawtypes")
	private JComboBox cboListaPrecios;
	private JButton jbtCancelar; 
	private JButton jbtAceptar; 
	private JTextField txtCoordenadaZ; 
	private JTextField txtCoordenadaY;
	private JTextField txtCoordenadaX; 	
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel5;
	private JLabel jLabel4;


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ListaPreciosView inst = new ListaPreciosView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ListaPreciosView() {
		super();
		initGUI();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			this.setTitle("Lista de Precios");
			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Tipo de Carga");
				jLabel1.setBounds(155, 19, 89, 16);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("CoordenadaX");
				jLabel3.setBounds(35, 72, 80, 16);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("CoordenadaY");
				jLabel4.setBounds(35, 100, 80, 16);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("CoordenadaZ");
				jLabel5.setBounds(37, 128, 84, 16);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("UnidadX");
				jLabel6.setBounds(174, 74, 72, 24);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("UnidadY");
				jLabel7.setBounds(174, 107, 78, 16);
			}
			{
				jLabel8 = new JLabel();
				getContentPane().add(jLabel8);
				jLabel8.setText("UnidadZ");
				jLabel8.setBounds(175, 134, 78, 16);
			}
			{
				txtCoordenadaX = new JTextField();
				getContentPane().add(txtCoordenadaX);
				txtCoordenadaX.setBounds(127, 69, 29, 23);
			}
			{
				txtCoordenadaY = new JTextField();
				getContentPane().add(txtCoordenadaY);
				txtCoordenadaY.setBounds(127, 97, 29, 22);
			}
			{
				txtCoordenadaZ = new JTextField();
				getContentPane().add(txtCoordenadaZ);
				txtCoordenadaZ.setBounds(127, 125, 29, 23);
			}
			{
				jbtAceptar = new JButton();
				getContentPane().add(jbtAceptar);
				jbtAceptar.setText("Aceptar");
				jbtAceptar.setBounds(75, 205, 93, 30);
				jbtAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAceptar (evt);
						
					}
				});
			}
			{
				jbtCancelar = new JButton();
				getContentPane().add(jbtCancelar);
				jbtCancelar.setText("Cancelar");
				jbtCancelar.setBounds(205, 205, 96, 30);
				jbtCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCancelar (evt);
						
					}
				});
			}
			{
				ComboBoxModel cboListaPreciosModel = 
						new DefaultComboBoxModel(
								new String[] { "Paquete", "Caja", "Pallet", "Bolsa","Bidón", "Tambor","Barril"  });
				cboListaPrecios = new JComboBox();
				getContentPane().add(cboListaPrecios);
				cboListaPrecios.setModel(cboListaPreciosModel);
				cboListaPrecios.setBounds(256, 16, 116, 23);
			}
			{
				txtCoordenadaPrecio = new JTextField();
				getContentPane().add(txtCoordenadaPrecio);
				txtCoordenadaPrecio.setBounds(107, 174, 55, 23);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Precio");
				jLabel2.setBounds(49, 177, 61, 16);
			}
			{
				ComboBoxModel cboXModel = 
						new DefaultComboBoxModel(
								new String[] { "km", "hm", "dam", "m", "dm", "cm", "mm" });
				cboX = new JComboBox();
				getContentPane().add(cboX);
				cboX.setModel(cboXModel);
				cboX.setBounds(253, 75, 65, 23);
			}
			{
				ComboBoxModel cboYModel = 
						new DefaultComboBoxModel(
								new String[] { "km", "hm", "dam", "m", "dm", "cm", "mm" });
				cboY = new JComboBox();
				getContentPane().add(cboY);
				cboY.setModel(cboYModel);
				cboY.setBounds(253, 104, 63, 22);
			}
			{
				ComboBoxModel cboZModel = 
						new DefaultComboBoxModel(
								new String[] { "km", "hm", "dam", "m", "dm", "cm", "mm" });
				cboZ = new JComboBox();
				getContentPane().add(cboZ);
				cboZ.setModel(cboZModel);
				cboZ.setBounds(253, 131, 64, 23);
			}
			{
				jTextFieldPeso = new JTextField();
				getContentPane().add(jTextFieldPeso);
				jTextFieldPeso.setBounds(268, 174, 55, 23);
			}
			{
				jLabel9 = new JLabel();
				getContentPane().add(jLabel9);
				jLabel9.setText("Peso");
				jLabel9.setBounds(195, 177, 61, 16);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		
	private void btnAceptar(ActionEvent evt) {
		try{
			
			ListaPreciosDTO listaPrecios = new ListaPreciosDTO();
			listaPrecios.setListaprecios((String) cboListaPrecios.getSelectedItem());
			listaPrecios.setCoordenadaX(Integer.parseInt(this.txtCoordenadaX.getText()));
			listaPrecios.setCoordenadaY(Integer.parseInt(this.txtCoordenadaY.getText()));
			listaPrecios.setCoordenadaZ(Integer.parseInt(this.txtCoordenadaZ.getText()));
			listaPrecios.setUnidadX((String) cboX.getSelectedItem());
			listaPrecios.setUnidadY((String) cboY.getSelectedItem());
			listaPrecios.setUnidadZ((String) cboZ.getSelectedItem());
			listaPrecios.setPrecio(Integer.parseInt(txtCoordenadaPrecio.getText()));
			listaPrecios.setPeso(Integer.parseInt(jTextFieldPeso.getText()));
			int check = 0;
			check =  ListaPreciosController.getInstance().darDeAltaListaPrecios(listaPrecios);
			
			if (check == 2){
				String mensaje = "Se dio de alta la lista de precios";
				JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
			}else{
				if(check == 1){
				String mensaje = "La lista de precios ya existe";
				JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
					String mensaje = "Falla en el alta de lista de precios";
					JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			ListaPreciosView.this.dispose();
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error el alta de lista de precios: " + e.getMessage());
			System.out.println("Stack Trace el alta de lista de precios: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnCancelar(ActionEvent evt) {
		try{
			ListaPreciosView.this.dispose();

		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al cancelar el alta de lista de precios: " + e.getMessage());
			System.out.println("Stack Trace al cancelar alta de lista de precios: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}	

}
