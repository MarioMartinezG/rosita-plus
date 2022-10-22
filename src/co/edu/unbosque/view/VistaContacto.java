/**
 * Clase que implementa la vista con los campos para crear un contacto de trabajo
 */
package co.edu.unbosque.view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author mariomartinez
 *
 */
public class VistaContacto extends JPanel {

	private JTextField nombreTxf;
	private JTextField empresaTxf;
	private JComboBox<String> paisCbx;
	private JTextField telefonoManTxf;
	private JTextField correoTxf;

	/**
	 * 
	 */
	public VistaContacto() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(0,1));

		inicializarComponentes();
	}

	public void inicializarComponentes() {
		JLabel nombreLbl = new JLabel("Nombre: ");
		this.nombreTxf = new JTextField(20);
		add(nombreLbl);
		add(this.nombreTxf);

		JLabel empresaLbl = new JLabel("Empresa: ");
		this.empresaTxf = new JTextField(20);
		add(empresaLbl);
		add(this.empresaTxf);

		JLabel paisLbl = new JLabel("Pais: ");
		this.paisCbx = new JComboBox<String>();
		add(paisLbl);
		add(this.paisCbx);

		JLabel telefonoManLbl = new JLabel("Telefono Manager: ");
		this.telefonoManTxf = new JTextField(20);
		add(telefonoManLbl);
		add(this.telefonoManTxf);

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
	 * @return the empresaTxf
	 */
	public JTextField getEmpresaTxf() {
		return empresaTxf;
	}

	/**
	 * @param empresaTxf the empresaTxf to set
	 */
	public void setEmpresaTxf(JTextField empresaTxf) {
		this.empresaTxf = empresaTxf;
	}

	/**
	 * @return the paisTxf
	 */
	public JComboBox<String> getPaisCbx() {
		return paisCbx;
	}

	/**
	 * @param paisTxf the paisTxf to set
	 */
	public void setPaisTxf(JComboBox<String> paisTxf) {
		this.paisCbx = paisTxf;
	}

	/**
	 * @return the telefonoManTxf
	 */
	public JTextField getTelefonoManTxf() {
		return telefonoManTxf;
	}

	/**
	 * @param telefonoManTxf the telefonoManTxf to set
	 */
	public void setTelefonoManTxf(JTextField telefonoManTxf) {
		this.telefonoManTxf = telefonoManTxf;
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
