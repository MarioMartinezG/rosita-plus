/**
 * 
 */
package co.edu.unbosque.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author mariomartinez
 *
 */
public class VistaEliminar extends JPanel {
	private JButton eliminarBtn;

	/**
	 * 
	 */
	public VistaEliminar() {
		setLayout(new FlowLayout());
		setBorder(new TitledBorder("Eliminar contacto de la agenda: "));
		inicializarComponentes();
	}

	private void inicializarComponentes() {

		this.eliminarBtn = new JButton("Eliminar Contacto");
		this.eliminarBtn.setActionCommand("ELIMINAR");
		add(this.eliminarBtn);

	}

	public JButton getEliminarBtn() {
		return eliminarBtn;
	}

	public void setEliminarBtn(JButton eliminarBtn) {
		this.eliminarBtn = eliminarBtn;
	}

}
