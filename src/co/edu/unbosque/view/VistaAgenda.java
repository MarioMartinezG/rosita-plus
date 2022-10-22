/**
 * 
 */
package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

/**
 * @author mariomartinez
 *
 */
public class VistaAgenda extends JPanel{

	private JTextPane contactosTxt;

	/**
	 * 
	 */
	public VistaAgenda() {
		setLayout(new BorderLayout());
		setBorder(new TitledBorder("Contactos de la agenda: "));
		inicializarComponentes();
		setVisible(true);
	}

	private void inicializarComponentes() {
		this.contactosTxt = new JTextPane();
		this.contactosTxt.setEditable(false);

		JScrollPane aux = new JScrollPane(this.contactosTxt);
		add(aux, BorderLayout.CENTER);
		
	}

	/**
	 * @return the contactosTxt
	 */
	public JTextPane getContactosTxt() {
		return contactosTxt;
	}

	/**
	 * @param contactosTxt the contactosTxt to set
	 */
	public void setContactosTxt(JTextPane contactosTxt) {
		this.contactosTxt = contactosTxt;
	}
	
	

}
