/**
 * 
 */
package co.edu.unbosque.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author mariomartinez
 *
 */
public class VistaPropiedades extends JPanel{
	
	private JButton cargarBtn;
	
	/**
	 * 
	 */
	public VistaPropiedades() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout());
		
		inicializarComponentes();
	}
	
	public void inicializarComponentes() {
		
		this.cargarBtn = new JButton("Cargar");
		this.cargarBtn.setActionCommand("Cargar Propiedades");
		add(this.cargarBtn);
		
	}

	/**
	 * @return the cargarBtn
	 */
	public JButton getCargarBtn() {
		return cargarBtn;
	}

	/**
	 * @param cargarBtn the cargarBtn to set
	 */
	public void setCargarBtn(JButton cargarBtn) {
		this.cargarBtn = cargarBtn;
	}
	
	
}
