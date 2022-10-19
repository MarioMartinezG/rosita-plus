/**
 * 
 */
package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author mariomartinez
 *
 */
public class VistaPrincipal extends JFrame {

	private VistaPropiedades vistaPropiedades;
	//private VistaMenu vistaMenu;

	/**
	 * 
	 */
	public VistaPrincipal() {
		// TODO Auto-generated constructor stub

		setLayout(new BorderLayout());

		inicializarComponentes();
	}

	public void inicializarComponentes() {
		this.vistaPropiedades = new VistaPropiedades();
		//this.vistaMenu = new VistaMenu();
		//getContentPane().add(this.vistaMenu, BorderLayout.CENTER);		
		getContentPane().add(this.vistaPropiedades, BorderLayout.CENTER);

		setSize(800, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		setTitle("Agenda de rosita plus");
		setVisible(true);
	}

	public File abrirArchivo() {
		JFileChooser chooser = new JFileChooser();
		int valorArchivo = chooser.showOpenDialog(this);
		if (valorArchivo == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile();

		}
		return null;
	}
	
	public void mostrarMsgError(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarMsgInfo(String message) {
		JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * @return the vistaPropiedades
	 */
	public VistaPropiedades getVistaPropiedades() {
		return vistaPropiedades;
	}

	/**
	 * @param vistaPropiedades the vistaPropiedades to set
	 */
	public void setVistaPropiedades(VistaPropiedades vistaPropiedades) {
		this.vistaPropiedades = vistaPropiedades;
	}

	/**
	 * @return the vistaMenu
	 */
	/*public VistaMenu getVistaMenu() {
		return vistaMenu;
	}*/

	/**
	 * @param vistaMenu the vistaMenu to set
	 */
	/*public void setVistaMenu(VistaMenu vistaMenu) {
		this.vistaMenu = vistaMenu;
	}*/
	

}
