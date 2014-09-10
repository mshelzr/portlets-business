package pe.com.ibk.halcon.gestionparametros.service;

import pe.com.ibk.halcon.gestionparametros.bean.BeanNuevoRango;


// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Interface ParametroService.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public interface ParametroService {

	/**
	 * Generar archivo.
	 * Fecha: 22/08/2013
	 *
	 * @param idParametro the id parametro
	 * @throws Exception the exception
	 */
	void generarArchivo(Integer idParametro)  throws Exception;
	
	/**
	 * Generar j son masivo.
	 * Fecha: 22/08/2013
	 *
	 * @throws Exception the exception
	 */
	void generarJSonMasivo() throws Exception;
	/**
	 * Ubigeo.
	 * Fecha: 22/08/2013
	 */
	void ubigeo();

	int guardarNuevoRangoSiebel(BeanNuevoRango beanRango) throws Exception;

}
