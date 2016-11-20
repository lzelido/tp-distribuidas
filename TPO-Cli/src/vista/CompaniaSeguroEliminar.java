package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class CompaniaSeguroEliminar extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JLabel jLabelCodigo;
	private JSeparator jSeparator1;
	private JLabel jLabelTarifas;
	private JButton jButtonEliminar;
	private JButton jButtonBuscarCompaniaSeguro;
	private JButton jButtonSalir;
	private JTextArea jTextAreaTarifas;
	private JSeparator jSeparator2;
	private JTextField jTextFieldDescripcion;
	private JTextField jTextFieldCodigo;
	private JLabel jLabelDescripcion;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CompaniaSeguroEliminar inst = new CompaniaSeguroEliminar();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public CompaniaSeguroEliminar() {
		super();
		initGUI();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Eliminar Compañía de Seguro");
			{
				jLabelCodigo = new JLabel();
				getContentPane().add(jLabelCodigo);
				jLabelCodigo.setText("Código :");
				jLabelCodigo.setBounds(26, 22, 59, 16);
			}
			{
				jLabelDescripcion = new JLabel();
				getContentPane().add(jLabelDescripcion);
				jLabelDescripcion.setText("Descripción :");
				jLabelDescripcion.setBounds(26, 50, 77, 20);
			}
			{
				jTextFieldCodigo = new JTextField();
				getContentPane().add(jTextFieldCodigo);
				jTextFieldCodigo.setBounds(108, 16, 88, 28);
			}
			{
				jTextFieldDescripcion = new JTextField();
				getContentPane().add(jTextFieldDescripcion);
				jTextFieldDescripcion.setBounds(109, 46, 238, 28);
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(0, 86, 385, 13);
			}
			{
				jLabelTarifas = new JLabel();
				getContentPane().add(jLabelTarifas);
				jLabelTarifas.setText("Tarifas");
				jLabelTarifas.setBounds(26, 98, 38, 16);
			}
			{
				jSeparator2 = new JSeparator();
				getContentPane().add(jSeparator2);
				jSeparator2.setBounds(0, 292, 385, 13);
			}
			{
				jTextAreaTarifas = new JTextArea();
				getContentPane().add(jTextAreaTarifas);
				jTextAreaTarifas.setBounds(26, 126, 321, 154);
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(220, 303, 77, 28);
			}
			{
				jButtonBuscarCompaniaSeguro = new JButton();
				getContentPane().add(jButtonBuscarCompaniaSeguro);
				jButtonBuscarCompaniaSeguro.setText("Buscar");
				jButtonBuscarCompaniaSeguro.setBounds(274, 16, 67, 28);
			}
			{
				jButtonEliminar = new JButton();
				getContentPane().add(jButtonEliminar);
				jButtonEliminar.setText("Eliminar");
				jButtonEliminar.setBounds(76, 303, 74, 28);
			}
			pack();
			this.setSize(400, 379);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
