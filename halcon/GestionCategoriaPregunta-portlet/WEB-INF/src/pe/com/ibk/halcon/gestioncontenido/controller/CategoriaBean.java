package pe.com.ibk.halcon.gestioncontenido.controller;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class CategoriaBean.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public class CategoriaBean {
	
	/** The id categoria. */
	private int idCategoria;
	
	/** The descripcion. */
	private String descripcion;
	
	
	/**
	 * Instancia un nuevo categoria bean.
	 *
	 * @param idCategoria the id categoria
	 * @param descripcion the descripcion
	 */
	public CategoriaBean(int idCategoria, String descripcion) {
		super();
		this.idCategoria = idCategoria;
		this.descripcion = descripcion;
	}
	
	/**
	 * Obtiene id categoria.
	 * Fecha: 22/08/2013
	 *
	 * @return id categoria
	 */
	public int getIdCategoria() {
		return idCategoria;
	}
	
	/**
	 * Establece el id categoria.
	 *
	 * @param idCategoria el new id categoria
	 */
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	/**
	 * Obtiene descripcion.
	 * Fecha: 22/08/2013
	 *
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * Establece el descripcion.
	 *
	 * @param descripcion el new descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
