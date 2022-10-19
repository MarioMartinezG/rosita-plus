/**
 * 
 */
package co.edu.unbosque.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author mariomartinez
 *
 */
public class VistaTipo extends JPanel{
	
	private JButton amigoBtn;
	private JButton contactoBtn;

	/**
	 * 
	 */
	public VistaTipo() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout());
		
		inicializarComponentes();
	}
	public void inicializarComponentes() {
		
		JLabel tipoLbl = new JLabel("Que tipo de contacto quiere agregar?");
		
		this.amigoBtn = new JButton("Agregar un amigo");
		add(this.amigoBtn);
		
		this.contactoBtn = new JButton("Agregar un contacto de trabajo");
		add(this.contactoBtn);
		
	}
	/**
	 * @return the amigoBtn
	 */
	public JButton getAmigoBtn() {
		return amigoBtn;
	}
	/**
	 * @param amigoBtn the amigoBtn to set
	 */
	public void setAmigoBtn(JButton amigoBtn) {
		this.amigoBtn = amigoBtn;
	}
	/**
	 * @return the contactoBtn
	 */
	public JButton getContactoBtn() {
		return contactoBtn;
	}
	/**
	 * @param contactoBtn the contactoBtn to set
	 */
	public void setContactoBtn(JButton contactoBtn) {
		this.contactoBtn = contactoBtn;
	}
	
	

}
