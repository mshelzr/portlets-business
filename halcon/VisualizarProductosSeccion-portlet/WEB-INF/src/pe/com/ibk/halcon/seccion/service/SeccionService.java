package pe.com.ibk.halcon.seccion.service;

import java.util.List;

import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.journal.model.JournalArticle;

/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Interface SeccionService.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
public interface SeccionService {
	
	/**
	 * Obtiene assets by name.
	 * Fecha: 18/02/2013
	 *
	 * @param companyId the company id
	 * @param groupId the group id
	 * @param nombreCategoria the nombre categoria
	 * @return assets by name
	 */
	List<AssetEntry> getAssetsByName(long companyId, long groupId, String nombreCategoria);

	/**
	 * Obtiene parses the value.
	 * Fecha: 18/02/2013
	 *
	 * @param fieldname the fieldname
	 * @param article the article
	 * @param languageID the language id
	 * @return parses the value
	 */
	String getParseValue(String fieldname, JournalArticle article, String languageID);
	
	<T> List<T> subtract(List<T> list1, List<T> list2);
}
