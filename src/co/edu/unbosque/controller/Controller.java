/**
 * 
 */
package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.event.AncestorListener;

import co.edu.unbosque.model.Amigo;
import co.edu.unbosque.model.Contacto;
import co.edu.unbosque.model.ContactoTrabajo;
import co.edu.unbosque.model.persistence.PropiedadLoader;
import co.edu.unbosque.view.VistaPrincipal;

/**
 * @author Andres.Martinez
 *
 */
public class Controller implements ActionListener {
	private PropiedadLoader propiedades;
	private VistaPrincipal vista;
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
		this.listaContactos = new ArrayList<>();

		agregarOyentes();
	}

	private void agregarOyentes() {

		this.vista.getVistaPropiedades().getCargarBtn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();

		if (comando.equals("Cargar Propiedades")) {
			if (this.propiedades.getProp() == null) {

				File archivoSeleccionado = this.vista.abrirArchivo();
				System.out.println("Nombre del archivo seleccionado: " + archivoSeleccionado.getName());
				this.propiedades.cargarPropiedades(archivoSeleccionado);
				int cantContactos = Integer.parseInt(this.propiedades.getProp().getProperty("contacto.cantidad"));
				int cantAmigos = Integer.parseInt(this.propiedades.getProp().getProperty("amigo.cantidad"));
				// preguntar pa que sirve la propiedad de cantidad
				
				for (int i = 1; i <= 3; i++) {
					String nombre = this.propiedades.getProp().getProperty("contacto.nombre"+i);
					String empresa = this.propiedades.getProp().getProperty("contacto.empresa"+i);
					String telefono = this.propiedades.getProp().getProperty("contacto.telefonoManager"+i);
					String pais = this.propiedades.getProp().getProperty("contacto.pais"+i);
					String correo = this.propiedades.getProp().getProperty("contacto.correo"+i);
					
					ContactoTrabajo c = new ContactoTrabajo(nombre, telefono, pais, correo, empresa);
					
					listaContactos.add(c);
				}
				
				for (int i = 1; i <= 4; i++) {
					String nombre = this.propiedades.getProp().getProperty("amigo.nombre"+i);
					String telefono = this.propiedades.getProp().getProperty("amigo.telefono"+i);
					String pais = this.propiedades.getProp().getProperty("amigo.pais"+i);
					String correo = this.propiedades.getProp().getProperty("amigo.correo"+i);
					
					Amigo a = new Amigo(nombre, telefono, pais, correo);
					
					listaContactos.add(a);
				}
				
				System.out.println("Contactos cargados: " + listaContactos);
			}else {
				System.out.println("Ya hay un archivo cargado");
			}
				
		}

	}

}
