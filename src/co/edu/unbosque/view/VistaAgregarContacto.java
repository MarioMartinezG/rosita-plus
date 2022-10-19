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
public class VistaAgregarContacto extends JPanel {
	
	private JTextField nombreTxf;
	private JTextField empresaTxf;
	private JTextField paisTxf;
	private JTextField telefonoManTxf;
	private JTextField correoTxf;
	private JButton guardarBtn;

	/**
	 * 
	 */
	public VistaAgregarContacto() {
		// TODO Auto-generated constructor stub
		
		setLayout(new FlowLayout());
		
		inicializarComponentes();
	}
	
	public void inicializarComponentes() {
		
		JLabel nombreLbl = new JLabel("Nombre: ");
		this.nombreTxf = new JTextField();
		add(this.nombreTxf);
		add(nombreLbl);
		
		JLabel empresaLbl = new JLabel("Empresa: ");
		this.empresaTxf = new JTextField();
		add(this.empresaTxf);
		add(empresaLbl);
		
		JLabel paisLbl = new JLabel("Pais: ");
		this.paisTxf = new JTextField();
		add(this.paisTxf);
		add(paisLbl);
		
		JLabel telefonoManLbl = new JLabel("Telefono Manager: ");
		this.telefonoManTxf = new JTextField();
		add(this.telefonoManTxf);
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
