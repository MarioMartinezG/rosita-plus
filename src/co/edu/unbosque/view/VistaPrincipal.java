/**
 * 
 */
package co.edu.unbosque.view;

import java.awt.FlowLayout;

import javax.swing.JFrame;

/**
 * @author mariomartinez
 *
 */
public class VistaPrincipal extends JFrame {

	private VistaPropiedades vistaPropiedades;
	/**
	 * 
	 */
	public VistaPrincipal() {
		// TODO Auto-generated constructor stub
		
		setLayout(new FlowLayout());
		
		this.vistaPropiedades= new VistaPropiedades();
		
		inicializarComponentes();
	}
	
	public void inicializarComponentes() {
		
		setSize(800, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		setTitle("Agenda de rosita plus");
		setVisible(true);
		
	}
}
