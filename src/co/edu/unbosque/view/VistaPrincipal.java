/**
 * 
 */
package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JFileChooser;
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

		setLayout(new BorderLayout());

		inicializarComponentes();
	}

	public void inicializarComponentes() {
		this.vistaPropiedades = new VistaPropiedades();
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

}
