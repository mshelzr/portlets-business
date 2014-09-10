package pe.com.ibk.halcon.categorias.service;

import java.util.List;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portlet.asset.model.AssetCategory;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Interface ResultadoCategoriaService.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
public interface ResultadoCategoriaService {

	/**
	 * Obtiene lucene content search.
	 * Fecha: 18/02/2013
	 *
	 * @param request the request
	 * @param companyId the company id
	 * @param groupId the group id
	 * @param categoria the categoria
	 * @param palabraClave the palabra clave
	 * @param start the start
	 * @param end the end
	 * @return lucene content search
	 */
	public List<Document> getLuceneContentSearch(PortletRequest request, long companyId,
			long groupId, Long categoria, String palabraClave, int start, int end);

	/**
	 * Obtiene lucene content search count categorias.
	 * Fecha: 18/02/2013
	 *
	 * @param request the request
	 * @param companyId the company id
	 * @param groupId the group id
	 * @param categoryId the category id
	 * @param palabraClave the palabra clave
	 * @return lucene content search count categorias
	 */
	public List<AssetCategory> getLuceneContentSearchCountCategorias(PortletRequest request,
			long companyId, long groupId, Long categoryId, String palabraClave);

	/**
	 * Obtiene category idby name.
	 * Fecha: 18/02/2013
	 *
	 * @param companyId the company id
	 * @param groupId the group id
	 * @param nombreCategoria the nombre categoria
	 * @return category idby name
	 */
	public long getCategoryIdbyName(long companyId, long groupId, String nombreCategoria);
}
