/**
 * 
 */
package co.edu.unbosque.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author mariomartinez
 *
 */
public class VistaAgregarAmigo extends JPanel{
	
	private JTextField nombreTxf;
	private JTextField paisTxf;
	private JTextField telefonoTxf;
	private JTextField correoTxf;
	private JButton guardarBtn;

	/**
	 * 
	 */
	public VistaAgregarAmigo() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout());
		
		inicializarComponentes();
		
	}
	
	public void inicializarComponentes() {
		
		JLabel nombreLbl = new JLabel("Nombre: ");
		this.nombreTxf = new JTextField();
		add(this.nombreTxf);
		add(nombreLbl);
		
		
		
		JLabel paisLbl = new JLabel("Pais: ");
		this.paisTxf = new JTextField();
		add(this.paisTxf);
		add(paisLbl);
		
		JLabel telefonoManLbl = new JLabel("Telefono: ");
		this.telefonoTxf = new JTextField();
		add(this.telefonoTxf);
		add(telefonoManLbl);
		
		this.guardarBtn = new JButton("Guardar");
		add(this.guardarBtn);
		
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
	public JTextField getPaisTxf() {
		return paisTxf;
	}

	/**
	 * @param paisTxf the paisTxf to set
	 */
	public void setPaisTxf(JTextField paisTxf) {
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

	/**
	 * @return the guardarBtn
	 */
	public JButton getGuardarBtn() {
		return guardarBtn;
	}

	/**
	 * @param guardarBtn the guardarBtn to set
	 */
	public void setGuardarBtn(JButton guardarBtn) {
		this.guardarBtn = guardarBtn;
	}
	
	

}
