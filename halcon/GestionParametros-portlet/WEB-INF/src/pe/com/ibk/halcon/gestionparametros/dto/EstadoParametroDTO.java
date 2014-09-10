package pe.com.ibk.halcon.gestionparametros.dto;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class EstadoParametroDTO.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public class EstadoParametroDTO {
	
	/** The nombre estado. */
	private String nombreEstado;
	
	/** The id estado. */
	private Integer idEstado;
	
	/**
	 * Instancia un nuevo estado parametro dto.
	 */
	public EstadoParametroDTO() {
		
	}
	
	/**
	 * Instancia un nuevo estado parametro dto.
	 *
	 * @param idEstado the id estado
	 * @param nombreEstado the nombre estado
	 */
	public EstadoParametroDTO(Integer idEstado, String nombreEstado) {
		this.idEstado = idEstado;
		this.nombreEstado = nombreEstado;
	}

	/**
	 * Obtiene nombre estado.
	 * Fecha: 22/08/2013
	 *
	 * @return nombre estado
	 */
	public String getNombreEstado() {
		return nombreEstado;
	}

	/**
	 * Establece el nombre estado.
	 *
	 * @param nombreEstado el new nombre estado
	 */
	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	/**
	 * Obtiene id estado.
	 * Fecha: 22/08/2013
	 *
	 * @return id estado
	 */
	public Integer getIdEstado() {
		return idEstado;
	}

	/**
	 * Establece el id estado.
	 *
	 * @param idEstado el new id estado
	 */
	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}
	
	

}
