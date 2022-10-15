/**
 * 
 */
package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import co.edu.unbosque.model.Contacto;
import co.edu.unbosque.model.ContactoDAO;

/**
 * @author Andres.Martinez
 *
 */
public class ArchivoBinario implements ContactoDAO{
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File archivoContacto = new File("datos/contactos.dat");
	private File archivoAmigo = new File("datos/amigos.dat");

	public ArchivoBinario() {
		if(archivoContacto.exists() && archivoAmigo.exists()) {
			System.out.println("Los archivo binarios ya existen");
		} else {
			try {
				archivoContacto.createNewFile();
				archivoAmigo.createNewFile();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	@Override
	public void insertarContacto(Contacto c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Contacto> leerContactos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarContacto(Contacto c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarContacto(Contacto c) {
		// TODO Auto-generated method stub
		
	}
}
