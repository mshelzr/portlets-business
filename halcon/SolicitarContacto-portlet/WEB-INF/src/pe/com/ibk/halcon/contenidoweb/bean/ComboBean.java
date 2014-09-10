package pe.com.ibk.halcon.contenidoweb.bean;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * Julio Hurtado 26/11/2012 Bean para los combobox.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 30/01/2013
 * @version Halcon 1.0
 */

public class ComboBean implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	int id;

	/** The nombre. */
	String nombre;

	/**
	 * Instancia un nuevo combo bean.
	 */
	public ComboBean() {
	}

	/**
	 * Obtiene id. Fecha: 30/01/2013
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el id.
	 * 
	 * @param id el new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene nombre. Fecha: 30/01/2013
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre.
	 * 
	 * @param nombre el new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
