package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import controlador.ProductoController;
import dto.EmpresaDTO;
import dto.ProductoDTO;

public class ProductoModificarView extends javax.swing.JDialog {
	private static final long serialVersionUID = 1L;
	private ImageIcon picture;
	private static EmpresaDTO empresaAct;
	private static ProductoDTO productoAct;
	private JTextField txtDescri;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblDescri;

	public ProductoModificarView (EmpresaDTO empresa, ProductoDTO producto) {
		super();
		initGUI();
		this.loadData(empresa, producto);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Modificación de Producto");
			picture = new ImageIcon("C:/Users/Facu/git/tpo_cliente-ad15/TPO_Cliente/picture/4.png");
			this.setIconImage(picture.getImage());
		
			{
				lblDescri = new JLabel();
				getContentPane().add(lblDescri);
				lblDescri.setText("Descripción");
				lblDescri.setBounds(12, 15, 77, 16);
			}
			{
				txtDescri = new JTextField();
				getContentPane().add(txtDescri);
				txtDescri.setBounds(89, 12, 283, 23);
			}
			{
				btnAceptar = new JButton();
				getContentPane().add(btnAceptar);
				btnAceptar.setText("Aceptar");
				btnAceptar.setBounds(12, 56, 108, 23);
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
				btnCancelar.setBounds(265, 56, 108, 23);
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCancelar (evt);
					}
				});
			}
			this.setSize(400, 129);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadData (EmpresaDTO empresa, ProductoDTO producto){
		try {
			if(empresa != null){
				empresaAct = new EmpresaDTO();
				empresaAct.setCodigo(empresa.getCodigo());
			}
			productoAct = new ProductoDTO();
			productoAct.setCodigo(producto.getCodigo());
			productoAct.setDescrip(producto.getDescrip());
			
			this.txtDescri.setText(productoAct.getDescrip());
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al cargar la pantalla de modificación de un producto: " + e.getMessage());
			System.out.println("Stack Trace al cargar la pantalla de modificación de un producto: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		} 
	}
	
	private void btnAceptar (ActionEvent evt){
		try{
			ProductoDTO producto = new ProductoDTO();
			producto.setCodigo(productoAct.getCodigo());
			producto.setDescrip(this.txtDescri.getText());
			
			int check = 0;
			check = ProductoController.getInstance().modificarProducto(producto);
			if (check == 2){
				String mensaje = "Se modificó el producto";
				JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
			}else{
				if (check == 1){
					String mensaje = "El producto no existe";
					JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
				}else{
					String mensaje = "Falla en el alta del producto";
					JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			ProductoModificarView.this.dispose();
			new ClienteEmpresaModificarView(empresaAct);
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al modificar un producto: " + e.getMessage());
			System.out.println("Stack Trace al modificar un producto: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnCancelar (ActionEvent evt){
		try{
			if (empresaAct == null){
				ProductoModificarView.this.dispose();
				new ClienteEmpresaModificarView(empresaAct);
			}else{
				ProductoModificarView.this.dispose();
				new ClienteEmpresaModificarView(empresaAct);
			}
		}catch (Error e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			System.out.println("Mensaje Error al cancelar la modificación de un producto: " + e.getMessage());
			System.out.println("Stack Trace al cancelar la modificación de un producto: " + e.getStackTrace());
			JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
