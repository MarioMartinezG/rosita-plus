/**
 * 
 */
package co.edu.unbosque.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * @author mariomartinez
 *
 */
public class VistaTipoAgregar extends JPanel{
	
	private JButton amigoBtn;
	private JButton contactoBtn;

	/**
	 * 
	 */
	public VistaTipoAgregar() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout());
		
		inicializarComponentes();
	}
	public void inicializarComponentes() {
		setBorder(new TitledBorder("Tipo contacto - Agregar"));
		
		JLabel tipoLbl = new JLabel("¿Que tipo de contacto quiere agregar? ");
		add(tipoLbl);
		
		this.amigoBtn = new JButton("Agregar un amigo");
		this.amigoBtn.setActionCommand("AGREGAR_AMIGO");
		add(this.amigoBtn);
		
		this.contactoBtn = new JButton("Agregar un contacto de trabajo");
		this.contactoBtn.setActionCommand("AGREGAR_CONTACTO");
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
