/**
 * Vista que implementa los campos para ver estadisticas de la agenda
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
public class VistaEstadisticas extends JPanel {
	private JButton generalBtn;

	/**
	 * 
	 */
	public VistaEstadisticas() {
		setLayout(new FlowLayout());
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		setBorder(new TitledBorder("Estadisticas de la agenda: "));
		this.generalBtn = new JButton("Estadisticas generales");
		this.generalBtn.setActionCommand("GENERAL");
		add(this.generalBtn);

	}

	/**
	 * @return the generalBtn
	 */
	public JButton getGeneralBtn() {
		return generalBtn;
	}

	/**
	 * @param generalBtn the generalBtn to set
	 */
	public void setGeneralBtn(JButton generalBtn) {
		this.generalBtn = generalBtn;
	}

}
