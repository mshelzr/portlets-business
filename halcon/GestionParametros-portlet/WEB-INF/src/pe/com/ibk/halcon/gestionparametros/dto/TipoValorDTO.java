package pe.com.ibk.halcon.gestionparametros.dto;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class TipoValorDTO.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public class TipoValorDTO {
	
	/** The nombre tipo valor. */
	private String nombreTipoValor;
	
	/** The id tipo valor. */
	private Integer idTipoValor;
	
	/**
	 * Instancia un nuevo tipo valor dto.
	 */
	public TipoValorDTO() {
		
	}
	
	/**
	 * Instancia un nuevo tipo valor dto.
	 *
	 * @param idTipoValor the id tipo valor
	 * @param nombreTipoValor the nombre tipo valor
	 */
	public TipoValorDTO(Integer idTipoValor, String nombreTipoValor) {
		this.idTipoValor = idTipoValor;
		this.nombreTipoValor = nombreTipoValor;
	}

	/**
	 * Obtiene nombre tipo valor.
	 * Fecha: 22/08/2013
	 *
	 * @return nombre tipo valor
	 */
	public String getNombreTipoValor() {
		return nombreTipoValor;
	}

	/**
	 * Establece el nombre tipo valor.
	 *
	 * @param nombreTipoValor el new nombre tipo valor
	 */
	public void setNombreTipoValor(String nombreTipoValor) {
		this.nombreTipoValor = nombreTipoValor;
	}

	/**
	 * Obtiene id tipo valor.
	 * Fecha: 22/08/2013
	 *
	 * @return id tipo valor
	 */
	public Integer getIdTipoValor() {
		return idTipoValor;
	}

	/**
	 * Establece el id tipo valor.
	 *
	 * @param idTipoValor el new id tipo valor
	 */
	public void setIdTipoValor(Integer idTipoValor) {
		this.idTipoValor = idTipoValor;
	}
	
	

}
