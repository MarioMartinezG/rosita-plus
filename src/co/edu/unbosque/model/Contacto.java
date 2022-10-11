/**
 * 
 */
package co.edu.unbosque.model;

/**
 * @author Andres.Martinez
 *
 */
public abstract class Contacto {
	private String nombre;
	private String numero;
	private String pais;
	private String correo;
	/**
	 * @param nombre
	 * @param numero
	 * @param pais
	 * @param correo
	 */
	public Contacto(String nombre, String numero, String pais, String correo) {
		this.nombre = nombre;
		this.numero = numero;
		this.pais = pais;
		this.correo = correo;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}
	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	

}

