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
public class VistaPropiedades extends JPanel{
	
	private JButton cargarBtn;
	private JLabel bienvenidaLbl;
	
	
	/**
	 * 
	 */
	public VistaPropiedades() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout());
		
		inicializarComponentes();
	}
	

	public void inicializarComponentes() {
		
		setBorder( new TitledBorder( "Agenda de Rosita - plus" ) ) ;
		
		this.bienvenidaLbl = new JLabel("Ingresa tus amigos");
		add(this.bienvenidaLbl);
		this.cargarBtn = new JButton("Cargar");
		this.cargarBtn.setActionCommand("Cargar Propiedades");
		add(this.cargarBtn);
	}

	/**
	 * @return the cargarBtn
	 */
	public JButton getCargarBtn() {
		return cargarBtn;
	}

	/**
	 * @param cargarBtn the cargarBtn to set
	 */
	public void setCargarBtn(JButton cargarBtn) {
		this.cargarBtn = cargarBtn;
	}
	
	/**
	 * @return the bienvenidaLbl
	 */
	public JLabel getBienvenidaLbl() {
		return bienvenidaLbl;
	}
	
	/**
	 * @param bienvenidaLbl the bienvenidaLbl to set
	 */
	public void setBienvenidaLbl(JLabel bienvenidaLbl) {
		this.bienvenidaLbl = bienvenidaLbl;
	}
	
}
