package pe.com.ibk.halcon.categorias.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.PortletRequest;

import org.springframework.stereotype.Service;

import pe.com.ibk.halcon.categorias.service.ResultadoCategoriaService;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class ResultadoCategoriaServiceImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
@Service
public class ResultadoCategoriaServiceImpl implements ResultadoCategoriaService {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(ResultadoCategoriaServiceImpl.class);

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.categorias.service.ResultadoCategoriaService#getLuceneContentSearchCountCategorias(javax.portlet.PortletRequest, long, long, java.lang.Long, java.lang.String)
	 */
	public List<AssetCategory> getLuceneContentSearchCountCategorias(PortletRequest request,
			long companyId, long groupId, Long categoryId, String palabraClave) {

		List<AssetCategory> numCategorias = null;
		List<Document> documentos = null;
		List<String> categorias = null;
		try {
			/* Extraigo los hijos de la categoria Preguntas Frecuentes */
			List<AssetCategory> hijosCategoria = AssetCategoryLocalServiceUtil
					.getChildCategories(categoryId);
			List<AssetCategory> hijosContenido = null;

			documentos = getLuceneContentSearch(request, companyId, groupId, categoryId,
					palabraClave, -1, -1);
			if (documentos != null && !documentos.isEmpty()) {
				for (Document doc : documentos) {
					Long classPK;
					AssetEntry assetEntry;

					classPK = Long.parseLong(doc.get(Field.ENTRY_CLASS_PK));
					assetEntry = AssetEntryLocalServiceUtil.getEntry(
							JournalArticle.class.getName(), classPK);

					if (assetEntry.getCategories() != null && !assetEntry.getCategories().isEmpty()) {
						for (AssetCategory assetCategory : assetEntry.getCategories()) {
							if (hijosContenido == null) {
								hijosContenido = new ArrayList<AssetCategory>();
							}
							hijosContenido.add(assetCategory);
						}
					}
				}

				/* Sacamo el maximo */
				// intersection as set
				Set<AssetCategory> intersect = new HashSet<AssetCategory>(hijosCategoria);
				intersect.retainAll(hijosContenido);
				if (intersect.size() > 0) {
					numCategorias = new ArrayList<AssetCategory>(intersect);
				}

			}

		} catch (Exception e) {
			_log.error("Error al realizar la busqueda Lucene:" + e.toString());
		}

		return numCategorias;
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.categorias.service.ResultadoCategoriaService#getCategoryIdbyName(long, long, java.lang.String)
	 */
	public long getCategoryIdbyName(long companyId, long groupId, String nombreCategoria) {
		long categoryId = 0;
		/* Obtenemos la categoria desde el nombre */
		try {
			DynamicQuery queryCategoria = DynamicQueryFactoryUtil
					.forClass(AssetCategory.class, PortalClassLoaderUtil.getClassLoader())
					.add(PropertyFactoryUtil.forName("companyId").eq(companyId))
					.add(PropertyFactoryUtil.forName("groupId").eq(groupId))
					.add(PropertyFactoryUtil.forName("name").like(nombreCategoria));

			AssetCategory codassset = (AssetCategory) AssetCategoryLocalServiceUtil.dynamicQuery(
					queryCategoria).get(0);

			categoryId = codassset.getCategoryId();
			_log.info("Categoria:" + categoryId + " / " + codassset.getName());
		} catch (Exception e) {
			_log.error("Error al obetener el Id de Categoria:" + e.toString());
		}

		return categoryId;
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.categorias.service.ResultadoCategoriaService#getLuceneContentSearch(javax.portlet.PortletRequest, long, long, java.lang.Long, java.lang.String, int, int)
	 */
	public List<Document> getLuceneContentSearch(PortletRequest request, long companyId,
			long groupId, Long categoria, String palabraClave, int start, int end) {

		List<Document> documentos = null;
		SearchContext searchContext = null;
		Hits resultados;
		try {

			searchContext = SearchContextFactory.getInstance((PortalUtil
					.getHttpServletRequest(request)));
			// Query que busca en el portal que deseemos
			BooleanQuery contextQuery = BooleanQueryFactoryUtil.create(searchContext);
			contextQuery.addRequiredTerm(Field.COMPANY_ID, companyId);
			contextQuery.addRequiredTerm(Field.GROUP_ID, groupId);

			// Query que busca que la cadena introducida por el usuairo estï¿½ en uno de los campos
			// principales
			// Query que busca que la cadena introducida por el usuairo está en
			String[] frases = palabraClave.split(" ");
			// uno de los campos principales
			BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);

			for (String frase : frases) {
				searchQuery.addTerm(Field.TITLE, escapeLuceneSpanish(frase));
				searchQuery.addTerm(Field.CONTENT, escapeLuceneSpanish(frase));
			}

			// searchQuery.addTerm(Field.PROPERTIES, palabraClave);

			// Querypara buscador solo JournalContents
			BooleanQuery JCQuery = BooleanQueryFactoryUtil.create(searchContext);
			JCQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, JournalArticle.class.getName());
			JCQuery.addRequiredTerm(Field.STATUS, 0);

			// Querypara buscador solo Ciertas categorias
			BooleanQuery categoriaQuery = BooleanQueryFactoryUtil.create(searchContext);

			categoriaQuery.addRequiredTerm(Field.ASSET_CATEGORY_IDS, categoria + "");

			// Query
			// expandoQuery=StringQueryFactoryUtil.create("expando/custom_fields/destacado:si");
			// Creamos query completa para enlazar las demï¿½s obligando a que
			// el enlace sea un AND [MUST] en lugar de un OR[SHOULD]
			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);
			if (!palabraClave.equals(""))
				fullQuery.add(searchQuery, BooleanClauseOccur.MUST);
			fullQuery.add(JCQuery, BooleanClauseOccur.MUST);
			fullQuery.add(categoriaQuery, BooleanClauseOccur.MUST);
			// fullQuery.add(expandoQuery , BooleanClauseOccur.MUST);

			// Aï¿½adimos ordenaciï¿½n (nombre descendente)
			Sort sort = new Sort();
			sort.setFieldName(Field.TITLE);
			sort.setType(Sort.STRING_TYPE);
			sort.setReverse(true);

			// _log.info("Query New:"+fullQuery.toString());

			// Recorremos resultados

			resultados = SearchEngineUtil.search(SearchEngineUtil.getDefaultSearchEngineId(),
					companyId, fullQuery, sort, start, end);

			documentos = resultados.toList();
		} catch (Exception e) {
			_log.error("Error al realizar la busqueda Lucene:" + e.toString());
		}

		return documentos;
	}

	/** The Constant SPECIAL. */
	public static final String[] SPECIAL = new String[] { "á", "Á", "é", "É", "í", "Í", "o", "Ó",
			"u", "Ú" };

	/** The Constant NORMAL. */
	public static final String[] NORMAL = new String[] { "a", "A", "e", "E", "i", "I", "o", "O",
			"u", "U" };

	/**
	 * Escape spanish.
	 * Fecha: 18/02/2013
	 *
	 * @param text the text
	 * @return the string
	 */
	public String escapeSpanish(String text) {
		text = removeSpanish(text);
		for (int i = SPECIAL.length - 1; i >= 0; i--) {
			text = StringUtil.replace(text, NORMAL[i], "[" + NORMAL[i] + SPECIAL[i] + "]");
		}
		return text;
	}

	/**
	 * Removes the spanish.
	 * Fecha: 18/02/2013
	 *
	 * @param text the text
	 * @return the string
	 */
	public String removeSpanish(String text) {
		for (int i = SPECIAL.length - 1; i >= 0; i--) {
			text = StringUtil.replace(text, SPECIAL[i], NORMAL[i]);
		}
		return text;
	}

	/**
	 * Escape lucene spanish.
	 * Fecha: 18/02/2013
	 *
	 * @param text the text
	 * @return the string
	 */
	public String escapeLuceneSpanish(String text) {
		text = removeSpanish(text);
		/* Verificamos que la primera letra no sea vocal pa no poner '?' */
		String primeraLetra = text.substring(0, 1);// Primer Caracter Normal
		String primeraLetraSpecial = "";// Primer Caracter Special
		boolean esVocal = false;
		int tamanio = text.length();
		// Verificamos si es una vocal
		for (int i = NORMAL.length - 1; i >= 0; i--) {
			if (primeraLetra.equalsIgnoreCase(NORMAL[i]) && !esVocal) {
				esVocal = true;
				primeraLetraSpecial = SPECIAL[i];
			}

			text = StringUtil.replace(text, NORMAL[i], "?");
		}

		if (esVocal) {
			text = primeraLetra + text.substring(1, tamanio) + " OR " + primeraLetraSpecial
					+ text.substring(1, tamanio);
		}

		return text;
	}

}
