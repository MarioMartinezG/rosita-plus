/**
 * 
 */
package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author mariomartinez
 *
 */
public class VistaMenu extends JPanel {
	private JComboBox<String> menu;
	private JPanel cards;
	private VistaPropiedades props;
	private VistaTipoAgregar tipoContacto;
	private VistaTipoModificar tipoContactoMod;
	private VistaAgenda vistaAgenda;
	private VistaEliminar vistaEliminar;
	
	final static String OPCION_CARGAR = "Cargar Propiedades";
	final static String OPCION_AGREGAR = "Agregar Contacto";
	final static String OPCION_MODIFICAR = "Modificar Contacto";
	final static String OPCION_BUSCAR = "Buscar contactos";
	final static String OPCION_ELIMINAR = "Eliminar contacto";

	/**
	 * 
	 */
	public VistaMenu() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());

		inicializarComponentes();
	}

	public void inicializarComponentes() {
		JLabel eleccionLbl = new JLabel("�Que quieres hacer?");
		add(eleccionLbl);
		
		String opciones[] = {OPCION_CARGAR, OPCION_AGREGAR, OPCION_MODIFICAR, OPCION_BUSCAR, OPCION_ELIMINAR};
		this.menu = new JComboBox<String>(opciones);
		add(menu, BorderLayout.PAGE_START);
		
		this.cards = new JPanel(new CardLayout());
		this.props = new VistaPropiedades();
		this.tipoContacto = new VistaTipoAgregar();
		this.tipoContactoMod = new VistaTipoModificar();
		this.vistaAgenda = new VistaAgenda();
		this.vistaEliminar = new VistaEliminar();
		
		this.cards.add(this.props, OPCION_CARGAR);
		this.cards.add(this.tipoContacto, OPCION_AGREGAR);
		this.cards.add(this.tipoContactoMod, OPCION_MODIFICAR);
		this.cards.add(this.vistaAgenda, OPCION_BUSCAR);
		this.cards.add(this.vistaEliminar, OPCION_ELIMINAR);
		
		add(this.cards, BorderLayout.CENTER);
	}
	/**
	 * @return the menu
	 */
	public JComboBox<String> getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public void setMenu(JComboBox<String> menu) {
		this.menu = menu;
	}

	/**
	 * @return the cards
	 */
	public JPanel getCards() {
		return cards;
	}

	/**
	 * @param cards the cards to set
	 */
	public void setCards(JPanel cards) {
		this.cards = cards;
	}

	/**
	 * @return the tipoContacto
	 */
	public VistaTipoAgregar getTipoContacto() {
		return tipoContacto;
	}

	/**
	 * @param tipoContacto the tipoContacto to set
	 */
	public void setTipoContacto(VistaTipoAgregar tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	/**
	 * @return the props
	 */
	public VistaPropiedades getProps() {
		return props;
	}

	/**
	 * @param props the props to set
	 */
	public void setProps(VistaPropiedades props) {
		this.props = props;
	}

	/**
	 * @return the tipoContactoMod
	 */
	public VistaTipoModificar getTipoContactoMod() {
		return tipoContactoMod;
	}

	/**
	 * @param tipoContactoMod the tipoContactoMod to set
	 */
	public void setTipoContactoMod(VistaTipoModificar tipoContactoMod) {
		this.tipoContactoMod = tipoContactoMod;
	}

	/**
	 * @return the vistaAgenda
	 */
	public VistaAgenda getVistaAgenda() {
		return vistaAgenda;
	}

	/**
	 * @param vistaAgenda the vistaAgenda to set
	 */
	public void setVistaAgenda(VistaAgenda vistaAgenda) {
		this.vistaAgenda = vistaAgenda;
	}

	/**
	 * @return the vistaEliminar
	 */
	public VistaEliminar getVistaEliminar() {
		return vistaEliminar;
	}

	/**
	 * @param vistaEliminar the vistaEliminar to set
	 */
	public void setVistaEliminar(VistaEliminar vistaEliminar) {
		this.vistaEliminar = vistaEliminar;
	}
}
