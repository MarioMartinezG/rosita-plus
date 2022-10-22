/**
 * Clase que implementa la logica de interaccion con los archivos binarios
 */
package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import co.edu.unbosque.model.Contacto;

/**
 * @author Andres.Martinez
 *
 */
public class ArchivoBinario {
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File archivoContacto = new File("datos/contactos.dat");
	private File archivoAmigo = new File("datos/amigos.dat");
	private File archivoPaises = new File("datos/paises.dat");

	public ArchivoBinario() {
		if (archivoContacto.exists() && archivoAmigo.exists() && archivoPaises.exists()) {
			System.out.println("Los archivo binarios ya existen");
		} else {
			try {
				archivoContacto.createNewFile();
				archivoAmigo.createNewFile();
				archivoPaises.createNewFile();
				System.out.println("Se crean los archivos binarios");
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Contacto> leerArchivoAmigos() {
		ArrayList<Contacto> amigos = new ArrayList<Contacto>();
		if (this.archivoAmigo.length() != 0) {
			try {
				this.entrada = new ObjectInputStream(new FileInputStream(this.archivoAmigo));
				amigos = (ArrayList<Contacto>) entrada.readObject();
				this.entrada.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return amigos;
	}

	public ArrayList<Contacto> leerArchivoContactos() {
		ArrayList<Contacto> contactos = new ArrayList<Contacto>();
		if (this.archivoAmigo.length() != 0) {
			try {
				this.entrada = new ObjectInputStream(new FileInputStream(this.archivoContacto));
				contactos = (ArrayList<Contacto>) entrada.readObject();
				this.entrada.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return contactos;
	}

	public void escribirEnArchivoAmigos(ArrayList<Contacto> amigos) {
		try {
			this.salida = new ObjectOutputStream(new FileOutputStream(this.archivoAmigo));
			this.salida.writeObject(amigos);
			this.salida.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void escribirEnArchivoContactos(ArrayList<Contacto> contactos) {
		try {
			this.salida = new ObjectOutputStream(new FileOutputStream(this.archivoContacto));
			this.salida.writeObject(contactos);
			this.salida.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> leerPaises() {
		ArrayList<String> paises = new ArrayList<String>();
		if (this.archivoPaises.length() != 0) {
			try {
				this.entrada = new ObjectInputStream(new FileInputStream(this.archivoPaises));
				paises = (ArrayList<String>) entrada.readObject();
				this.entrada.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return paises;
	}
	
	public void escribirPaises(ArrayList<String> paises) {
		try {
			this.salida = new ObjectOutputStream(new FileOutputStream(this.archivoPaises));
			this.salida.writeObject(paises);
			this.salida.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the archivoContacto
	 */
	public File getArchivoContacto() {
		return archivoContacto;
	}

	/**
	 * @param archivoContacto the archivoContacto to set
	 */
	public void setArchivoContacto(File archivoContacto) {
		this.archivoContacto = archivoContacto;
	}

	/**
	 * @return the archivoAmigo
	 */
	public File getArchivoAmigo() {
		return archivoAmigo;
	}

	/**
	 * @param archivoAmigo the archivoAmigo to set
	 */
	public void setArchivoAmigo(File archivoAmigo) {
		this.archivoAmigo = archivoAmigo;
	}

	/**
	 * @return the archivoPaises
	 */
	public File getArchivoPaises() {
		return archivoPaises;
	}

	/**
	 * @param archivoPaises the archivoPaises to set
	 */
	public void setArchivoPaises(File archivoPaises) {
		this.archivoPaises = archivoPaises;
	}
}
