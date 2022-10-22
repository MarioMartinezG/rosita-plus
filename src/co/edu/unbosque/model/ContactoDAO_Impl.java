/**
 * 
 */
package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 * @author mariomartinez
 *
 */
public class ContactoDAO_Impl implements ContactoDAO{

	@Override
	public void insertarContacto(ArrayList<Contacto> lista, Contacto c) {
		lista.add(c);
	}

	@Override
	public Contacto consultarContacto(ArrayList<Contacto> lista, String nombre) {
		Contacto x = null;
		for (Contacto contacto : lista) {
			if (contacto.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
				x = contacto;
			}
		}
		return x;
	}

	@Override
	public String leerContactos(ArrayList<Contacto> lista) {
		String datos = "";
		for (Contacto contacto : lista) {
			datos += contacto.toString() + "\n" + "\n";
		}
		return datos;
	}

	@Override
	public void eliminarContacto(ArrayList<Contacto> lista, Contacto c) {
		lista.remove(c);		
	}

	@Override
	public void modificarContacto(ArrayList<Contacto> lista, Contacto c) {
		Contacto c_buscar= consultarContacto(lista, c.getNombre().toLowerCase());
		if(c_buscar != null) {
			eliminarContacto(lista, c_buscar);
			insertarContacto(lista, c);
		}
		
	}

	@Override
	public boolean eliminarContactoPorNombre(ArrayList<Contacto> lista, String nombre) {
		for (Contacto contacto : lista) {
			if (contacto.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
				lista.remove(contacto);
				return true;
			}
		}
		return false;
	}
}
