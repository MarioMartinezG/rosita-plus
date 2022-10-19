/**
 * 
 */
package co.edu.unbosque.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author mariomartinez
 *
 */
public class VistaMenu extends JPanel{
	
	private JButton agregarBtn;
	private JButton modificarBtn;
	private JButton buscarBtn;
	private JButton eliminarBtn;
	
	/**
	 * 
	 */
	public VistaMenu() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout());
		
		inicializarComponentes();
	}
	
	public void inicializarComponentes(){
		
		JLabel eleccionLbl = new JLabel("¿Que quieres hacer?");
		
		this.agregarBtn = new JButton("Agregar");
		this.agregarBtn.setActionCommand("AGREGAR");
		add(this.agregarBtn);
		
		this.modificarBtn = new JButton("Modificar");
		this.modificarBtn.setActionCommand("MODIFICAR");
		add(this.modificarBtn);
		
		this.buscarBtn = new JButton("Buscar");
		this.buscarBtn.setActionCommand("BUSCAR");
		add(this.buscarBtn);
		
		this.eliminarBtn = new JButton("Eliminar");
		this.buscarBtn.setActionCommand("ELIMINAR");
		add(this.eliminarBtn);
		
	}

	/**
	 * @return the agregarBtn
	 */
	public JButton getAgregarBtn() {
		return agregarBtn;
	}

	/**
	 * @param agregarBtn the agregarBtn to set
	 */
	public void setAgregarBtn(JButton agregarBtn) {
		this.agregarBtn = agregarBtn;
	}

	/**
	 * @return the modificarBtn
	 */
	public JButton getModificarBtn() {
		return modificarBtn;
	}

	/**
	 * @param modificarBtn the modificarBtn to set
	 */
	public void setModificarBtn(JButton modificarBtn) {
		this.modificarBtn = modificarBtn;
	}

	/**
	 * @return the buscarBtn
	 */
	public JButton getBuscarBtn() {
		return buscarBtn;
	}

	/**
	 * @param buscarBtn the buscarBtn to set
	 */
	public void setBuscarBtn(JButton buscarBtn) {
		this.buscarBtn = buscarBtn;
	}

	/**
	 * @return the eliminarBtn
	 */
	public JButton getEliminarBtn() {
		return eliminarBtn;
	}

	/**
	 * @param eliminarBtn the eliminarBtn to set
	 */
	public void setEliminarBtn(JButton eliminarBtn) {
		this.eliminarBtn = eliminarBtn;
	}
	

}
