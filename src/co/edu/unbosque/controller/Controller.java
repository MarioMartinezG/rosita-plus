/**
 * 
 */
package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import co.edu.unbosque.model.Contacto;
import co.edu.unbosque.model.persistence.PropiedadLoader;
import co.edu.unbosque.view.VistaMenu;
import co.edu.unbosque.view.VistaPrincipal;

/**
 * @author Andres.Martinez
 *
 */
public class Controller implements ActionListener {
	private PropiedadLoader propiedades;
	private VistaPrincipal vista;
	private VistaMenu vistaMenu;
	private ArrayList<Contacto> listaContactos;

	/**
	 * 
	 */
	public Controller() {

		ejecutar();

	}

	private void ejecutar() {

		this.propiedades = new PropiedadLoader();
		this.vista = new VistaPrincipal();
		this.vistaMenu = new VistaMenu();
		this.listaContactos = new ArrayList<>();

		agregarOyentes();
	}

	private void agregarOyentes() {

		this.vista.getVistaPropiedades().getCargarBtn().addActionListener(this);

		this.vistaMenu.getAgregarBtn().addActionListener(this);
		this.vistaMenu.getModificarBtn().addActionListener(this);
		this.vistaMenu.getBuscarBtn().addActionListener(this);
		this.vistaMenu.getEliminarBtn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();

		if (comando.equals("Cargar Propiedades")) {
			if (this.propiedades.getProp() == null) {

				try {
					File archivoSeleccionado = this.vista.abrirArchivo();
					System.out.println("Nombre del archivo seleccionado: " + archivoSeleccionado.getName());
					this.propiedades.cargarPropiedades(archivoSeleccionado);
					this.vista.mostrarMsgInfo("Se cargaron exitosamente los contactos");
					
					/*
					 * PENDIENTE VALIDAR CON HELIO
					int cantContactos = Integer.parseInt(this.propiedades.getProp().getProperty("contacto.cantidad"));
					int cantAmigos = Integer.parseInt(this.propiedades.getProp().getProperty("amigo.cantidad"));
					// preguntar pa que sirve la propiedad de cantidad
					for (int i = 1; i <= 3; i++) {
						String nombre = this.propiedades.getProp().getProperty("contacto.nombre" + i);
						String empresa = this.propiedades.getProp().getProperty("contacto.empresa" + i);
						String telefono = this.propiedades.getProp().getProperty("contacto.telefonoManager" + i);
						String pais = this.propiedades.getProp().getProperty("contacto.pais" + i);
						String correo = this.propiedades.getProp().getProperty("contacto.correo" + i);

						ContactoTrabajo c = new ContactoTrabajo(nombre, telefono, pais, correo, empresa);

						listaContactos.add(c);
						
					}

					for (int i = 1; i <= 4; i++) {
						String nombre = this.propiedades.getProp().getProperty("amigo.nombre" + i);
						String telefono = this.propiedades.getProp().getProperty("amigo.telefono" + i);
						String pais = this.propiedades.getProp().getProperty("amigo.pais" + i);
						String correo = this.propiedades.getProp().getProperty("amigo.correo" + i);

						Amigo a = new Amigo(nombre, telefono, pais, correo);

						listaContactos.add(a);
					}
					System.out.println("Contactos cargados: " + listaContactos);
					 */
					
				} catch (NullPointerException e2) {
					// TODO: handle exception
					e2.printStackTrace();
					this.vista.mostrarMsgError("No se cargo ningun archivo.");
				}

			} else {
				this.vista.mostrarMsgInfo("Ya hay un archivo cargado");

			}

		}
		if (comando.equals("AGREGAR")) {

		} else if (comando.equals("MODIFICAR")) {

		} else if (comando.equals("BUSCAR")) {

		} else if (comando.equals("ELIMINAR")) {

		}

	}

}
