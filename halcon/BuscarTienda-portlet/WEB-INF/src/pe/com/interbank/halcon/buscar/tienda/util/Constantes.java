package pe.com.interbank.halcon.buscar.tienda.util;

import com.liferay.util.portlet.PortletProps;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class Constantes.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public class Constantes {

	/** The canal tiendas. */
	public static Integer CANAL_TIENDAS = 1;
	
	/** The canal agentes. */
	public static Integer CANAL_AGENTES = 2;
	
	/** The canal cajeros global net. */
	public static Integer CANAL_CAJEROS_GLOBAL_NET = 3;
	
	/** The canal monederos global net. */
	public static Integer CANAL_MONEDEROS_GLOBAL_NET = 4;
	
	/** The canal cajeros global net plus. */
	public static Integer CANAL_CAJEROS_GLOBAL_NET_PLUS = 5;	
	
	/** The carpeta template. */
	public static String CARPETA_TEMPLATE="/template";
	
	/** The carpeta page html. */
	public static String CARPETA_PAGE_HTML="/gmap-result.html";
	
	/** The mensaje sin resultados. */
	public static String MENSAJE_SIN_RESULTADOS =PortletProps.get("pe.com.interbank.halcon.buscar.tienda.sinresultados");			
	
}
