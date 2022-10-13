/**
 * 
 */
package co.edu.unbosque.controller;

import co.edu.unbosque.model.persistence.PropiedadLoader;

/**
 * @author Andres.Martinez
 *
 */
public class Controller {
	private PropiedadLoader propiedades;

	/**
	 * 
	 */
	public Controller() {
		
		this.propiedades = new PropiedadLoader();
		
		ejecutar();
		
	}
	
	private void ejecutar() {
		
		String pais = this.propiedades.getProp().getProperty("amigo.pais4");
		System.out.println(pais);
	}

}
