package pe.com.interbank.halcon.buscar.descuento.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ResourceResponse;

import com.google.gson.Gson;
import com.liferay.portal.kernel.util.ContentTypes;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class Util.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  21/08/2013
 * @version Halcon 1.0
 */
public class Util {

	/**
	 * Return JSon
	 * Metodo por le cual cualquier objeto se convierte en Json y se asigna al response.
	 * Fecha:  21/08/2013
	 *
	 * @param o the o
	 * @param resourceResponse the resource response
	 * @throws IOException Señales de que una excepción de E / S se ha producido.
	 */
	public static void returnJson(Object o,	ResourceResponse resourceResponse) throws IOException  {
		Gson gson = new Gson();
		String gsonString = gson.toJson(o);
		resourceResponse.setContentType(ContentTypes. APPLICATION_JSON);
		PrintWriter writer = resourceResponse.getWriter();		
		writer.write(gsonString);		
		writer.flush();
		writer.close();
	}
	
	/**
	 * Gson string.<br>
	 * Método por el cual cualquier objeto se convierte en una cadena con formato JSon.
	 * Fecha: 21/08/2013
	 *
	 * @param o the o
	 * @return the string
	 * @throws IOException Señales de que una excepción de E / S se ha producido.
	 */
	public static String gsonString(Object o) throws IOException  {
		Gson gson = new Gson();
		String gsonString = gson.toJson(o);	
		return gsonString;
	}
}
