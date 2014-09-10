package pe.com.interbank.halcon.carga.masiva.util;

import com.liferay.util.portlet.PortletProps;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class Constantes.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 31-ene-2013
 * @version Halcon 1.0
 */
public class Constantes {

	/** The ext xls. */
	public static String EXT_XLS = "xls";

	/** The ext xlsx. */
	public static String EXT_XLSX = "xlsx";

	/** The ext txt. */
	public static String EXT_TXT = "txt";

	/** The limite. */
	public static Double LIMITE = Double.parseDouble(PortletProps.get("limite.parametro.archivo.documento.bytes"));

	/** The cabecera empresa. */
	public static String CABECERA_EMPRESA = PortletProps.get("pe.com.interbank.halcon.carga.masiva.util.Constantes.empresa");

	/** The cabecera id pais. */
	public static String CABECERA_ID_PAIS = PortletProps.get("pe.com.interbank.halcon.carga.masiva.util.Constantes.idpais");

	/** The cabecera pagina web. */
	public static String CABECERA_PAGINA_WEB = PortletProps.get("pe.com.interbank.halcon.carga.masiva.util.Constantes.paginaweb");

	/** The cabecera telefono. */
	public static String CABECERA_TELEFONO = PortletProps.get("pe.com.interbank.halcon.carga.masiva.util.Constantes.telefono");

	public static String MENSAJE_EMPRESA = PortletProps.get("pe.com.interbank.halcon.carga.masiva.util.Constantes.mensaje.empresa");
	public static String MENSAJE_EMPRESA_REQUERIDO = PortletProps.get("pe.com.interbank.halcon.carga.masiva.util.Constantes.mensaje.requerido.empresa");
	public static String MENSAJE_EMPRESA_LONGITUD = PortletProps.get("pe.com.interbank.halcon.carga.masiva.util.Constantes.mensaje.longitud.empresa");
	public static String MENSAJE_ID_PAIS = PortletProps.get("pe.com.interbank.halcon.carga.masiva.util.Constantes.mensaje.idpais");
	public static String MENSAJE_ID_PAIS_REQUERIDO = PortletProps.get("pe.com.interbank.halcon.carga.masiva.util.Constantes.mensaje.requerido.idpais");
	public static String MENSAJE_ID_PAIS_VALIDACION = PortletProps.get("pe.com.interbank.halcon.carga.masiva.util.Constantes.mensaje.validacion.idpais");
	public static String MENSAJE_ID_PAIS_LONGITUD = PortletProps.get("pe.com.interbank.halcon.carga.masiva.util.Constantes.mensaje.longitud.idpais");	
	public static String MENSAJE_PAGINA_WEB = PortletProps.get("pe.com.interbank.halcon.carga.masiva.util.Constantes.mensaje.paginaweb");
	public static String MENSAJE_PAGINA_WEB_LONGITUD = PortletProps.get("pe.com.interbank.halcon.carga.masiva.util.Constantes.mensaje.longitud.paginaweb");
	public static String MENSAJE_TELEFONO = PortletProps.get("pe.com.interbank.halcon.carga.masiva.util.Constantes.mensaje.telefono");
	public static String MENSAJE_TELEFONO_LONGITUD = PortletProps.get("pe.com.interbank.halcon.carga.masiva.util.Constantes.mensaje.longitud.telefono");
	
	public static String MENSAJE_COLUMNA_EMPRESA = PortletProps.get("pe.com.interbank.halcon.carga.masiva.util.Constantes.mensaje.columna.empresa");
	public static String MENSAJE_COLUMNA_ID_PAIS = PortletProps.get("pe.com.interbank.halcon.carga.masiva.util.Constantes.mensaje.columna.pais");
	public static String MENSAJE_COLUMNA_PAGINA_WEB = PortletProps.get("pe.com.interbank.halcon.carga.masiva.util.Constantes.mensaje.columna.web");
	public static String MENSAJE_COLUMNA_TELEFONO = PortletProps.get("pe.com.interbank.halcon.carga.masiva.util.Constantes.mensaje.columna.telefono");
	
	
	/** The valid length empresa. */
	public static int validLengthEmpresa = 100;

	/** The valid length pais cobertura. */
	public static int validLengthPaisCobertura = 4;

	/** The valid length pagina web. */
	public static int validLengthPaginaWeb = 100;

	/** The valid length telefono. */
	public static int validLengthTelefono = 100;

	/** The token separador. */
	public static String tokenSeparador = ",";


	public static String CARPETA_TEMPLATE="/error";
	public static String CARPETA_PAGE_HTML="/listaErrore.txt";
	
//	public static String[] CABECERA_OBLIGATORIOS = getObligatorios(PortletProps.get("pe.com.interbank.halcon.carga.masiva.util.Constantes.OBLIGATORIOS"));
	public static int CABECERA_OBLIGATORIOS = 4;
//	private static String[] getObligatorios(String oblig) {
//		return oblig.split(",");
//	}

	public static int validLengthminTelefono = 6;
	
	
	
}
