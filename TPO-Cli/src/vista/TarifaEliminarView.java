package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.TarifaController;
import controlador.TipoMercaderiaController;
import controlador.TipoSeguroController;
import dto.TarifaDTO;
import dto.TipoMercaderiaDTO;
import dto.TipoSeguroDTO;

public class TarifaEliminarView extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel jLabelCodigo;
	private JLabel jLabelidTipoSeguro;
	private JTextField jTextFieldidTipoSeguro;
	private JButton jButtonBuscarTarifa;
	private JButton jButtonSalir;
	private JButton jButtonEliminar;
	private JSeparator jSeparator4;
	private JTextField jTextFieldValor;
	private JLabel jLabelValor;
	private JSeparator jSeparator3;
	private JTextField jTextFieldDescripcionTipoMercaderia;
	private JTextField jTextFieldidTipoMercaderia;
	private JLabel jLabelDescripcionTipoMercaderia;
	private JLabel jLabelidTipoMercaderia;
	private JLabel jLabelTipoMercaderia;
	private JSeparator jSeparator2;
	private JLabel jLabelTipoSeguro;
	private JSeparator jSeparator1;
	private JLabel jLabelDescripcionTipoSeguro;
	private JTextField jTextFieldDescripcionidTipoSeguro;
	private JTextField jTextFieldCodigo;
	private static TipoSeguroDTO tipoSeguroAct;
	private static TipoMercaderiaDTO tipoMercaderiaAct;
	private static TarifaDTO tarifaAct;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TarifaEliminarView inst = new TarifaEliminarView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public TarifaEliminarView() {
		super();
		initGUI();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Modificar Tarifa");
			{
				jLabelCodigo = new JLabel();
				getContentPane().add(jLabelCodigo);
				jLabelCodigo.setText("C�digo :");
				jLabelCodigo.setBounds(31, 18, 63, 16);
			}
			{
				jTextFieldCodigo = new JTextField();
				getContentPane().add(jTextFieldCodigo);
				jTextFieldCodigo.setBounds(106, 12, 74, 28);
			}
			{
				jLabelidTipoSeguro = new JLabel();
				getContentPane().add(jLabelidTipoSeguro);
				jLabelidTipoSeguro.setText("C�digo :");
				jLabelidTipoSeguro.setBounds(31, 90, 124, 16);
			}
			{
				jTextFieldidTipoSeguro = new JTextField();
				getContentPane().add(jTextFieldidTipoSeguro);
				jTextFieldidTipoSeguro.setBounds(107, 84, 74, 28);
			}
			{
				jTextFieldDescripcionidTipoSeguro = new JTextField();
				getContentPane().add(jTextFieldDescripcionidTipoSeguro);
				jTextFieldDescripcionidTipoSeguro.setBounds(108, 122, 233, 28);
			}
			{
				jLabelDescripcionTipoSeguro = new JLabel();
				getContentPane().add(jLabelDescripcionTipoSeguro);
				jLabelDescripcionTipoSeguro.setText("Descripci�n :");
				jLabelDescripcionTipoSeguro.setBounds(30, 128, 72, 16);
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(-5, 52, 389, 10);
			}
			{
				jLabelTipoSeguro = new JLabel();
				getContentPane().add(jLabelTipoSeguro);
				jLabelTipoSeguro.setText("Tipo de Seguro");
				jLabelTipoSeguro.setBounds(31, 62, 84, 16);
			}
			{
				jSeparator2 = new JSeparator();
				getContentPane().add(jSeparator2);
				jSeparator2.setBounds(0, 162, 384, 14);
			}
			{
				jLabelTipoMercaderia = new JLabel();
				getContentPane().add(jLabelTipoMercaderia);
				jLabelTipoMercaderia.setText("Tipo de Mercader�a");
				jLabelTipoMercaderia.setBounds(30, 175, 145, 16);
			}
			{
				jLabelidTipoMercaderia = new JLabel();
				getContentPane().add(jLabelidTipoMercaderia);
				jLabelidTipoMercaderia.setText("C�digo :");
				jLabelidTipoMercaderia.setBounds(30, 209, 46, 16);
			}
			{
				jLabelDescripcionTipoMercaderia = new JLabel();
				getContentPane().add(jLabelDescripcionTipoMercaderia);
				jLabelDescripcionTipoMercaderia.setText("Descripci�n :");
				jLabelDescripcionTipoMercaderia.setBounds(30, 246, 72, 16);
			}
			{
				jTextFieldidTipoMercaderia = new JTextField();
				getContentPane().add(jTextFieldidTipoMercaderia);
				jTextFieldidTipoMercaderia.setBounds(108, 203, 73, 28);
			}
			{
				jTextFieldDescripcionTipoMercaderia = new JTextField();
				getContentPane().add(jTextFieldDescripcionTipoMercaderia);
				jTextFieldDescripcionTipoMercaderia.setBounds(108, 240, 233, 28);
			}
			{
				jSeparator3 = new JSeparator();
				getContentPane().add(jSeparator3);
				jSeparator3.setBounds(0, 280, 384, 8);
			}
			{
				jLabelValor = new JLabel();
				getContentPane().add(jLabelValor);
				jLabelValor.setText("Valor :");
				jLabelValor.setBounds(30, 300, 34, 16);
			}
			{
				jTextFieldValor = new JTextField();
				getContentPane().add(jTextFieldValor);
				jTextFieldValor.setBounds(108, 294, 73, 28);
			}
			{
				jSeparator4 = new JSeparator();
				getContentPane().add(jSeparator4);
				jSeparator4.setBounds(0, 334, 384, 14);
			}
			{
				jButtonEliminar = new JButton();
				getContentPane().add(jButtonEliminar);
				jButtonEliminar.setText("Eliminar");
				jButtonEliminar.setBounds(64, 354, 91, 28);
				jButtonEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnEliminar (evt);
					}
				});
			
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(235, 354, 86, 28);
				jButtonSalir.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dispose();
					}
				});
			}
			{
				jButtonBuscarTarifa = new JButton();
				getContentPane().add(jButtonBuscarTarifa);
				jButtonBuscarTarifa.setText("Buscar");
				jButtonBuscarTarifa.setBounds(219, 12, 67, 28);
				jButtonBuscarTarifa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBuscarTarifa (evt);
					}
				});
			}
			pack();
			this.setSize(400, 435);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private void btnBuscarTarifa (ActionEvent evt){
		try {
			
			tarifaAct = TarifaController.getInstance().buscarTarifa(Integer.parseInt(this.jTextFieldCodigo.getText()));
			
			if (tarifaAct == null){
				String mensaje = "No existe la Tarifa";
				JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				this.dispose();
			}else{
				this.jTextFieldDescripcionidTipoSeguro.setText(Integer.toString(tarifaAct.getCodigo()));
				this.jTextFieldidTipoSeguro.setText(Integer.toString(tarifaAct.getTipoSeguro().getCodigo()));
				this.jTextFieldDescripcionidTipoSeguro.setText(tarifaAct.getTipoSeguro().getDescripcion());
				this.jTextFieldidTipoMercaderia.setText(Integer.toString(tarifaAct.getTipoMercaderia().getCodigo()));
				this.jTextFieldDescripcionTipoMercaderia.setText(tarifaAct.getTipoMercaderia().getDescripcion());
				this.jTextFieldValor.setText(Float.toString(tarifaAct.getValor()));
				this.jTextFieldDescripcionidTipoSeguro.setEditable(false);
				this.jTextFieldDescripcionTipoMercaderia.setEditable(false);
			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al buscar la Tarifa: " + e.getMessage());
			System.out.println("Stack Trace al buscar la Tarifa: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnEliminar (ActionEvent evt){
		try{
			int response = JOptionPane.showConfirmDialog(null,"�Esta seguro que desea continuar?\nEsta acci�n no puede deshacerse.", "Confirmaci�n", JOptionPane.YES_NO_OPTION);
			if(response == JOptionPane.NO_OPTION){
				return;
			}else{
				if (response == JOptionPane.YES_OPTION){
					
					int check = 0;
					check = TarifaController.getInstance().bajaTarifa(tarifaAct);
					if (check == 2){
						String mensaje = "Se Elimin� la Tarifa";
						JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
					}else{
						if (check == 1){
							String mensaje = "La Tarifa no existe";
							JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
						}else{
							String mensaje = "Falla en la Eliminaci�n de la Tarifa";
							JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
					
					TarifaEliminarView.this.dispose();
//					new Principal();
				}
			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al modificar un Tipo de Mercaderia: " + e.getMessage());
			System.out.println("Stack Trace al modificar un Tipo de Mercaderia: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
