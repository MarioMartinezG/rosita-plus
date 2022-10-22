/**
 * Clase encargada de mostrar la ventana con los paneles
 */
package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author mariomartinez
 *
 */
public class VistaPrincipal extends JFrame {
	private VistaMenu vistaMenu;

	/**
	 * 
	 */
	public VistaPrincipal() {
		// TODO Auto-generated constructor stub
		setSize(800, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		setTitle("Agenda de rosita plus");
		setLayout(new BorderLayout());

		inicializarComponentes();
		setVisible(true);
	}

	public void inicializarComponentes() {
		this.vistaMenu = new VistaMenu();
		getContentPane().add(this.vistaMenu, BorderLayout.CENTER);
	}

	public File abrirArchivo() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de Propiedades", "properties");
		chooser.setFileFilter(filtro);
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
		JOptionPane.showMessageDialog(null, message, "Información", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void ocultarPanel(JPanel component) {
		component.setVisible(false);
	}
	
	public void mostrarPanel(JPanel component) {
		component.setVisible(true);
	}
	/**
	 * @return the vistaMenu
	 */
	public VistaMenu getVistaMenu() {
		return vistaMenu;
	}

	/**
	 * @param vistaMenu the vistaMenu to set
	 */
	public void setVistaMenu(VistaMenu vistaMenu) {
		this.vistaMenu = vistaMenu;
	}

}
