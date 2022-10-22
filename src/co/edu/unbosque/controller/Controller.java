/**
 * 
 */
package co.edu.unbosque.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.Amigo;
import co.edu.unbosque.model.Contacto;
import co.edu.unbosque.model.ContactoDAO_Impl;
import co.edu.unbosque.model.ContactoTrabajo;
import co.edu.unbosque.model.persistence.ArchivoBinario;
import co.edu.unbosque.model.persistence.PropiedadLoader;
import co.edu.unbosque.view.VistaAmigo;
import co.edu.unbosque.view.VistaContacto;
import co.edu.unbosque.view.VistaEliminar;
import co.edu.unbosque.view.VistaPrincipal;

/**
 * @author Andres.Martinez
 *
 */
public class Controller implements ActionListener, ItemListener {
	private PropiedadLoader propiedades;
	private ArchivoBinario archivo;
	private VistaPrincipal vista;
	private VistaAmigo vistaAmigo;
	private VistaContacto vistaContacto;
	private VistaEliminar vistaEliminar;
	private ContactoDAO_Impl dao;
	private ArrayList<Contacto> listaContactos;
	private ArrayList<Contacto> listaAmigos;
	private ArrayList<String> paises;

	/**
	 * 
	 */
	public Controller() {
		ejecutar();
	}

	private void ejecutar() {

		this.propiedades = new PropiedadLoader();
		this.archivo = new ArchivoBinario();
		this.vista = new VistaPrincipal();
		this.vistaAmigo = new VistaAmigo();
		this.vistaContacto = new VistaContacto();
		this.vistaEliminar = new VistaEliminar();
		this.dao = new ContactoDAO_Impl();
		this.listaContactos = new ArrayList<>();
		this.listaAmigos = new ArrayList<>();
		this.paises = new ArrayList<String>();
		ArrayList<Contacto> directorio = new ArrayList<>();

		if (this.archivo.getArchivoPaises().length() == 0) {
			this.vista.mostrarMsgInfo(
					"Debe cargar los paises de la agenda fisica al sistema. Por favor, suba el archivo de propiedades");
		} else {
			this.paises = this.archivo.leerPaises();
			for (String pais : paises) {
				this.vistaAmigo.getPaisCbx().addItem(pais);
				this.vistaContacto.getPaisCbx().addItem(pais);
			}
		}

		agregarOyentes();
		cargarContactos();
	}

	private void cargarContactos() {

		if (this.archivo.getArchivoAmigo().length() == 0 || this.archivo.getArchivoContacto().length() == 0) {
			this.vista.mostrarMsgInfo(
					"No se encontraron amigos o contactos en el almacenamiento. Por favor, carguelos de la agenda fisica.");
		} else {
			this.listaAmigos.addAll(this.archivo.leerArchivoAmigos());
			this.listaContactos.addAll(this.archivo.leerArchivoContactos());
			System.out.println("Contactos cargados desde los archivos binarios");
		}

	}

	private void agregarOyentes() {
		this.vista.getVistaMenu().getMenu().addItemListener(this);

		this.vista.getVistaMenu().getProps().getCargarBtn().addActionListener(this);
		this.vista.getVistaMenu().getTipoContacto().getAmigoBtn().addActionListener(this);
		this.vista.getVistaMenu().getTipoContacto().getContactoBtn().addActionListener(this);
		this.vista.getVistaMenu().getTipoContactoMod().getAmigoBtn().addActionListener(this);
		this.vista.getVistaMenu().getTipoContactoMod().getContactoBtn().addActionListener(this);
		this.vista.getVistaMenu().getVistaEliminar().getEliminarBtn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();

		if (comando.equals("CARGAR")) {
			if (this.propiedades.getProp() == null) {
				try {
					File archivoSeleccionado = this.vista.abrirArchivo();
					System.out.println("Nombre del archivo seleccionado: " + archivoSeleccionado.getName());
					this.propiedades.cargarPropiedades(archivoSeleccionado);
					this.vista.mostrarMsgInfo("Propiedades cargadas correctamente");

					int cantPaises = Integer.parseInt(this.propiedades.getProp().getProperty("agenda.paises"));

					for (int i = 1; i <= cantPaises; i++) {
						String pais = this.propiedades.getProp().getProperty("agenda.pais" + i);
						paises.add(pais);
					}

					this.archivo.escribirPaises(paises);
					
					for (String pais : paises) {
						this.vistaAmigo.getPaisCbx().addItem(pais);
						this.vistaContacto.getPaisCbx().addItem(pais);
					}
				} catch (NullPointerException e2) {
					// TODO: handle exception
					e2.printStackTrace();
					this.vista.mostrarMsgError("No se cargo ningun archivo.");
				}

			} else {
				this.vista.mostrarMsgInfo("Ya hay un archivo cargado");
			}

			if (this.listaAmigos == null || this.listaAmigos.size() == 0) {
				/*
				 * PENDIENTE VALIDAR CON HELIO
				 */
				int cantContactos = Integer.parseInt(this.propiedades.getProp().getProperty("contacto.cantidad"));

				// preguntar pa que sirve la propiedad de cantidad
				for (int i = 1; i <= 3; i++) {
					String nombre = this.propiedades.getProp().getProperty("contacto.nombre" + i);
					String empresa = this.propiedades.getProp().getProperty("contacto.empresa" + i);
					String telefono = this.propiedades.getProp().getProperty("contacto.telefonoManager" + i);
					String pais = this.propiedades.getProp().getProperty("contacto.pais" + i);
					String correo = this.propiedades.getProp().getProperty("contacto.correo" + i);

					ContactoTrabajo c = new ContactoTrabajo(nombre, telefono, pais, correo, empresa);

					dao.insertarContacto(this.listaContactos, c);
				}
				this.archivo.escribirEnArchivoContactos(this.listaContactos);

				System.out.println("Contactos persistidos en el archivo binario");
			}

			if (this.listaAmigos == null || this.listaAmigos.size() == 0) {
				int cantAmigos = Integer.parseInt(this.propiedades.getProp().getProperty("amigo.cantidad"));
				for (int i = 1; i <= 4; i++) {
					String nombre = this.propiedades.getProp().getProperty("amigo.nombre" + i);
					String telefono = this.propiedades.getProp().getProperty("amigo.telefono" + i);
					String pais = this.propiedades.getProp().getProperty("amigo.pais" + i);
					String correo = this.propiedades.getProp().getProperty("amigo.correo" + i);

					Amigo a = new Amigo(nombre, telefono, pais, correo);

					dao.insertarContacto(listaAmigos, a);
				}
				this.archivo.escribirEnArchivoAmigos(this.listaAmigos);
				System.out.println("Amigos persistidos en el archivo binario");
			}

		} else if (comando.equals("AGREGAR_AMIGO")) {
			System.out.println("Click en agregar amigo");

			if (this.paises == null || this.paises.size() == 0) {
				this.vista.mostrarMsgInfo(
						"Debe cargar los paises de la agenda fisica al sistema. Por favor, suba el archivo de propiedades");
			} else {
				int resultado = JOptionPane.showConfirmDialog(null, this.vistaAmigo, "Agregar amigo",
						JOptionPane.OK_CANCEL_OPTION);
				if (resultado == JOptionPane.OK_OPTION) {
					System.out.println("Nombre amigo: " + this.vistaAmigo.getNombreTxf().getText());
					System.out.println("Pais amigo: " + this.vistaAmigo.getPaisCbx().getSelectedItem());
					System.out.println("Telefono amigo: " + this.vistaAmigo.getTelefonoTxf().getText());
					System.out.println("Correo amigo: " + this.vistaAmigo.getCorreoTxf().getText());

					String nombre = this.vistaAmigo.getNombreTxf().getText();
					String pais = (String) this.vistaAmigo.getPaisCbx().getSelectedItem();
					String telefono = this.vistaAmigo.getTelefonoTxf().getText();
					String correo = this.vistaAmigo.getCorreoTxf().getText();

					if (dao.consultarContacto(this.listaAmigos, nombre) == null) {
						Amigo nuevoAmigo = new Amigo(nombre, telefono, pais, correo);
						dao.insertarContacto(this.listaAmigos, nuevoAmigo);
						this.archivo.escribirEnArchivoAmigos(this.listaAmigos);
						this.vista.mostrarMsgInfo("Contacto agregado exitosamente");
					} else {
						this.vista.mostrarMsgError("El contacto ingresado ya existe");
					}
				}

			}

		} else if (comando.equals("AGREGAR_CONTACTO")) {
			System.out.println("Click en agregar contacto");
			if (this.paises == null || this.paises.size() == 0) {
				this.vista.mostrarMsgInfo(
						"Debe cargar los paises de la agenda fisica al sistema. Por favor, suba el archivo de propiedades");
			} else {
				int resultado = JOptionPane.showConfirmDialog(null, this.vistaContacto, "Agregar contacto",
						JOptionPane.OK_CANCEL_OPTION);
				if (resultado == JOptionPane.OK_OPTION) {
					System.out.println("Nombre contacto: " + this.vistaContacto.getNombreTxf().getText());
					System.out.println("Empresa contacto: " + this.vistaContacto.getEmpresaTxf().getText());
					System.out.println("Pais contacto: " + this.vistaContacto.getPaisCbx().getSelectedItem());
					System.out.println("Telefono contacto: " + this.vistaContacto.getTelefonoManTxf().getText());
					System.out.println("Correo contacto: " + this.vistaContacto.getCorreoTxf().getText());

					String nombre = this.vistaContacto.getNombreTxf().getText();
					String empresa = this.vistaContacto.getEmpresaTxf().getText();
					String pais = (String) this.vistaContacto.getPaisCbx().getSelectedItem();
					String telefono = this.vistaContacto.getTelefonoManTxf().getText();
					String correo = this.vistaContacto.getCorreoTxf().getText();

					if (dao.consultarContacto(this.listaContactos, nombre) == null) {
						ContactoTrabajo nuevoContacto = new ContactoTrabajo(nombre, telefono, pais, correo, empresa);
						dao.insertarContacto(this.listaContactos, nuevoContacto);
						this.archivo.escribirEnArchivoContactos(this.listaContactos);
						this.vista.mostrarMsgInfo("Contacto agregado exitosamente");
					} else {
						this.vista.mostrarMsgError("El contacto ingresado ya existe");
					}
				}
			}

		} else if (comando.equals("MODIFICAR_AMIGO")) {
			System.out.println("Click en modificar amigo");
			if (this.paises == null || this.paises.size() == 0) {
				this.vista.mostrarMsgInfo(
						"Debe cargar los paises de la agenda fisica al sistema. Por favor, suba el archivo de propiedades");
			} else {
				int resultado = JOptionPane.showConfirmDialog(null, this.vistaAmigo, "Modificar amigo",
						JOptionPane.OK_CANCEL_OPTION);
				if (resultado == JOptionPane.OK_OPTION) {
					System.out.println("Nombre amigo: " + this.vistaAmigo.getNombreTxf().getText());
					System.out.println("Pais amigo: " + this.vistaAmigo.getPaisCbx().getSelectedItem());
					System.out.println("Telefono amigo: " + this.vistaAmigo.getTelefonoTxf().getText());
					System.out.println("Correo amigo: " + this.vistaAmigo.getCorreoTxf().getText());

					String nombre = this.vistaAmigo.getNombreTxf().getText();
					String pais = (String) this.vistaAmigo.getPaisCbx().getSelectedItem();
					String telefono = this.vistaAmigo.getTelefonoTxf().getText();
					String correo = this.vistaAmigo.getCorreoTxf().getText();

					if (dao.consultarContacto(this.listaAmigos, nombre) != null) {
						Amigo modAmigo = new Amigo(nombre, telefono, pais, correo);
						dao.modificarContacto(this.listaAmigos, modAmigo);
						this.archivo.escribirEnArchivoAmigos(this.listaAmigos);
						this.vista.mostrarMsgInfo("Contacto modificado exitosamente");
					} else {
						this.vista.mostrarMsgError("El amigo que quiere modificar no existe");
					}
				}
			}

		} else if (comando.equals("MODIFICAR_CONTACTO")) {
			System.out.println("Click en modificar contacto");
			if (this.paises == null || this.paises.size() == 0) {
				this.vista.mostrarMsgInfo(
						"Debe cargar los paises de la agenda fisica al sistema. Por favor, suba el archivo de propiedades");
			} else {
				int resultado = JOptionPane.showConfirmDialog(null, this.vistaContacto, "Modificar contacto",
						JOptionPane.OK_CANCEL_OPTION);
				if (resultado == JOptionPane.OK_OPTION) {
					System.out.println("Nombre contacto: " + this.vistaContacto.getNombreTxf().getText());
					System.out.println("Empresa contacto: " + this.vistaContacto.getEmpresaTxf().getText());
					System.out.println("Pais contacto: " + this.vistaContacto.getPaisCbx().getSelectedItem());
					System.out.println("Telefono contacto: " + this.vistaContacto.getTelefonoManTxf().getText());
					System.out.println("Correo contacto: " + this.vistaContacto.getCorreoTxf().getText());

					String nombre = this.vistaContacto.getNombreTxf().getText();
					String empresa = this.vistaContacto.getEmpresaTxf().getText();
					String pais = (String) this.vistaContacto.getPaisCbx().getSelectedItem();
					String telefono = this.vistaContacto.getTelefonoManTxf().getText();
					String correo = this.vistaContacto.getCorreoTxf().getText();

					if (dao.consultarContacto(this.listaContactos, nombre) != null) {
						ContactoTrabajo modContacto = new ContactoTrabajo(nombre, telefono, pais, correo, empresa);
						dao.modificarContacto(this.listaContactos, modContacto);
						this.archivo.escribirEnArchivoContactos(this.listaContactos);
						this.vista.mostrarMsgInfo("Contacto modificado exitosamente");
					} else {
						this.vista.mostrarMsgError("El contacto que quiere modificar no existe");
					}
				}
			}
		} else if (comando.equals("ELIMINAR")) {
			System.out.println("Click en eliminar");
			String nombre = JOptionPane.showInputDialog("Ingrese el nombre del contacto que desea eliminar");

			if (dao.consultarContacto(this.listaContactos, nombre) != null
					&& dao.consultarContacto(this.listaContactos, nombre) instanceof ContactoTrabajo) {
				dao.eliminarContactoPorNombre(this.listaContactos, nombre);
				this.archivo.escribirEnArchivoContactos(this.listaContactos);
				this.vista.mostrarMsgInfo("Contacto eliminado exitosamente");
			} else if (dao.consultarContacto(this.listaAmigos, nombre) != null
					&& dao.consultarContacto(this.listaAmigos, nombre) instanceof Amigo) {
				dao.eliminarContactoPorNombre(this.listaAmigos, nombre);
				this.archivo.escribirEnArchivoAmigos(this.listaAmigos);
				this.vista.mostrarMsgInfo("Amigo eliminado exitosamente");
			} else {
				this.vista.mostrarMsgError("No se encontro el contacto en la agenda");
			}
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		ArrayList<Contacto> contactos = new ArrayList<>();
		String valor = (String) e.getItem();
		CardLayout cl = (CardLayout) (this.vista.getVistaMenu().getCards().getLayout());
		cl.show(this.vista.getVistaMenu().getCards(), valor);
		contactos.addAll(listaContactos);
		contactos.addAll(listaAmigos);

		if (valor.equals("Buscar contactos")) {
			this.vista.getVistaMenu().getVistaAgenda().getContactosTxt().setText(dao.leerContactos(contactos));
		}
	}

	public boolean validarNombre(String nombre) {
		Pattern regEx = Pattern.compile("^[A-Z][a-z]$");
		Matcher mat = regEx.matcher(nombre);

		if (mat.matches()) {
			System.out.println("Nombre valido");
			return true;
		} else {
			System.out.println("Nombre NO valido");
			return false;
		}
	}

}
