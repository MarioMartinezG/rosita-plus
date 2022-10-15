/**
 * 
 */
package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 * @author mariomartinez
 *
 */
public interface ContactoDAO {
	
	void insertarContacto(Contacto c);
	ArrayList<Contacto> leerContactos();
	void eliminarContacto(Contacto c);
	void modificarContacto(Contacto c);
	

}
