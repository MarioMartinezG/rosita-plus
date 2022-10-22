/**
 * Vista que implementa los campos para modificar un amigo/contacto
 */
package co.edu.unbosque.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * @author Andres.Martinez
 *
 */
public class VistaTipoModificar extends JPanel{
	private JButton amigoBtn;
	private JButton contactoBtn;

	/**
	 * 
	 */
	public VistaTipoModificar() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout());
		
		inicializarComponentes();
	}
	public void inicializarComponentes() {
		setBorder(new TitledBorder("Tipo contacto - Modificar"));
		
		JLabel tipoLbl = new JLabel("�Que tipo de contacto quiere modificar? ");
		add(tipoLbl);
		
		this.amigoBtn = new JButton("Modificar un amigo");
		this.amigoBtn.setActionCommand("MODIFICAR_AMIGO");
		add(this.amigoBtn);
		
		this.contactoBtn = new JButton("Modificar un contacto de trabajo");
		this.contactoBtn.setActionCommand("MODIFICAR_CONTACTO");
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
