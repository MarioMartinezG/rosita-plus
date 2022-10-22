/**
 * Clase que implementa el modelo de tipo ContactoTrabajo. Hereda de la clase Contacto
 */
package co.edu.unbosque.model;

/**
 * @author Andres.Martinez
 *
 */
public class ContactoTrabajo extends Contacto {
	
	private String empresa;

	public ContactoTrabajo(String nombre, String numero, String pais, String correo, String empresa) {
		super(nombre, numero, pais, correo);
		this.empresa=empresa;
	}

	@Override
	public String toString() {
		return super.toString() + " empresa: " + empresa;
	}

}
