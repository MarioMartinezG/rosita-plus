/**
 * 
 */
package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Andres.Martinez
 *
 */
public class PropiedadLoader {
	
	private Properties prop;
	final static String RUTA_PROPIEDADES = "datos/agendaFisica.properties";

	/**
	 * 
	 */
	public PropiedadLoader() {
		
		cargarPropiedades();
	}
	
	private void cargarPropiedades() {
		
		this.prop =  new Properties();
		File file = new File(RUTA_PROPIEDADES);
		
		try {
			
			FileInputStream doc = new FileInputStream(file);
			this.prop.load(doc);
			doc.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("No fue posible cargar el archivo de propiedades");
		}
		
	}

	/**
	 * @return the prop
	 */
	public Properties getProp() {
		return prop;
	}

	/**
	 * @param prop the prop to set
	 */
	public void setProp(Properties prop) {
		this.prop = prop;
	}

	
}
