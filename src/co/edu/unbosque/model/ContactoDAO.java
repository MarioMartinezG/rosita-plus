/**
 * Interface con los métodos del CRUD de la agenda
 */
package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 * @author mariomartinez
 *
 */
public interface ContactoDAO {
	
	void insertarContacto(ArrayList<Contacto> lista, Contacto c);
	Contacto consultarContacto(ArrayList<Contacto> lista, String nombre);
	String leerContactos(ArrayList<Contacto> lista);
	void eliminarContacto(ArrayList<Contacto> lista, Contacto c);
	boolean eliminarContactoPorNombre(ArrayList<Contacto> lista, String nombre);
	void modificarContacto(ArrayList<Contacto> lista, Contacto c);
	

}
