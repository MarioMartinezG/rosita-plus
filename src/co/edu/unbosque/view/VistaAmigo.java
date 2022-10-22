/**
 * 
 */
package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author mariomartinez
 *
 */
public class VistaAmigo extends JPanel {

	private JTextField nombreTxf;
	private JComboBox<String> paisTxf;
	private JTextField telefonoTxf;
	private JTextField correoTxf;

	/**
	 * 
	 */
	public VistaAmigo() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(0,1));

		inicializarComponentes();

	}

	public void inicializarComponentes() {

		JLabel nombreLbl = new JLabel("Nombre: ");
		this.nombreTxf = new JTextField(20);
		add(nombreLbl);
		add(this.nombreTxf);

		JLabel paisLbl = new JLabel("Pais: ");
		this.paisTxf = new JComboBox<>();
		add(paisLbl);
		add(this.paisTxf);

		JLabel telefonoManLbl = new JLabel("Telefono: ");
		this.telefonoTxf = new JTextField(20);
		add(telefonoManLbl);
		add(this.telefonoTxf);

		JLabel correoLbl = new JLabel("Correo: ");
		this.correoTxf = new JTextField(20);
		add(correoLbl);
		add(this.correoTxf);

	}

	/**
	 * @return the nombreTxf
	 */
	public JTextField getNombreTxf() {
		return nombreTxf;
	}

	/**
	 * @param nombreTxf the nombreTxf to set
	 */
	public void setNombreTxf(JTextField nombreTxf) {
		this.nombreTxf = nombreTxf;
	}

	/**
	 * @return the paisTxf
	 */
	public JComboBox<String> getPaisCbx() {
		return paisTxf;
	}

	/**
	 * @param paisTxf the paisTxf to set
	 */
	public void setPaisTxf(JComboBox<String> paisTxf) {
		this.paisTxf = paisTxf;
	}

	/**
	 * @return the telefonoTxf
	 */
	public JTextField getTelefonoTxf() {
		return telefonoTxf;
	}

	/**
	 * @param telefonoTxf the telefonoTxf to set
	 */
	public void setTelefonoTxf(JTextField telefonoTxf) {
		this.telefonoTxf = telefonoTxf;
	}

	/**
	 * @return the correoTxf
	 */
	public JTextField getCorreoTxf() {
		return correoTxf;
	}

	/**
	 * @param correoTxf the correoTxf to set
	 */
	public void setCorreoTxf(JTextField correoTxf) {
		this.correoTxf = correoTxf;
	}
}
