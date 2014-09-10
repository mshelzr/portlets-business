package pe.com.interbank.halcon.cargar.tiendas.util;

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
 * @author Infonet Consulting S.A.C. Fecha: 31-ene-2013
 * @version Halcon 1.0
 */
public class Util {

	/** The gson. */
	public static Gson gson = new Gson();

	/**
	 * returno cualquier objeto a json y lo asigna al response.
	 * 
	 * @param o the o
	 * @param resourceResponse the resource response
	 * @throws IOException Señales de que una excepción de E / S se ha producido.
	 */
	public static void returnJson(Object o, ResourceResponse resourceResponse) throws IOException {
		String gsonString = gson.toJson(o);
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
		PrintWriter writer = resourceResponse.getWriter();
		writer.write(gsonString);
		writer.flush();
		writer.close();
	}

	/**
	 * retorna cualquier objeto json como string.
	 * 
	 * @param o the o
	 * @return the string
	 */

	public static String returnJson(Object o) {
		return gson.toJson(o);
	}

	/**
	 * capitaliza cualquier conjunto de palabras.
	 * 
	 * @param str the str
	 * @return the string
	 */
	public static String capitalizarFrase(String str) {
		str = str.trim();
		String[] spl = str.split(" ");
		str = "";
		for (int i = 0; i < spl.length; i++) {
			String st = spl[i];
			if (st.length() > 1) {
				st = st.toLowerCase();
				Character c = st.charAt(0);
				st = c.toString().toUpperCase() + st.substring(1);
			}
			str += st + " ";
		}
		str = str.trim();
		return str;
	}

}
