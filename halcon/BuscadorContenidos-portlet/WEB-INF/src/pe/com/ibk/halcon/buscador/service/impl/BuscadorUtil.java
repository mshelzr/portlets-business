package pe.com.ibk.halcon.buscador.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.portlet.RenderRequest;

import pe.com.ibk.halcon.buscador.model.BuscadorBean;

import com.exp.portlet.halcon.utils.AsciiUtils;
import com.exp.portlet.halcon.utils.FriendlyURLGenerator;
import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
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
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleDisplay;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class BuscadorUtil.
 * Contiene los métodos que hacen la búsqueda dentro del portal asi como métodos relacionados.
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
public class BuscadorUtil {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(BuscadorUtil.class);

	/**
	 * Obtiene los codigos de categorias de contenido del portal excepto el listado de categorias 
	 * enviado como parametro.
	 * Fecha: 18/02/2013
	 *
	 * @param companyId , el código de la compania asignada.
	 * @param groupId , el codigo del grupo asignado.
	 * @param nombreCategoriasExcluidas , listado de categorias que serán excluidas.
	 * @return List<Long> , lista con los codigos de las categorias.
	 */
	public static List<Long> getCategoriasExcepto(long companyId, long groupId,
			String[] nombreCategoriasExcluidas) {
		List<Long> admitidos = null;
		try {
			DynamicQuery queryCategoria = DynamicQueryFactoryUtil
					.forClass(AssetCategory.class, PortalClassLoaderUtil.getClassLoader())
					.add(PropertyFactoryUtil.forName("companyId").eq(companyId))
					.add(PropertyFactoryUtil.forName("groupId").eq(groupId));

			List<AssetCategory> categorias = AssetCategoryLocalServiceUtil
					.dynamicQuery(queryCategoria);
			for (AssetCategory categoria : categorias) {
				boolean isActive = true;

				for (String excluidos : nombreCategoriasExcluidas) {
					if (excluidos.equalsIgnoreCase(categoria.getName())) {
						isActive = false;
						break;
					}
				}

				/* Agrego y hago break al for de excluidos */
				if (isActive) {
					if (admitidos == null) {
						admitidos = new ArrayList<Long>();
					}
					admitidos.add(categoria.getCategoryId());
					
				}
			}
		} catch (Exception e) {
			_log.error("Error al filtrar las Categorias:" + e.toString());
		}
		return admitidos;
	}

	/**
	 * Obtiene el listado de contenidos dado los parámetros de búsqueda dentro del portal.
	 * Fecha: 18/02/2013
	 *
	 * @param renderRequest , el request en fase render.
	 * @param companyId , el codigo de la compania asignada por el aplicativo.
	 * @param groupId , el codigo de grupo.
	 * @param categoryIds , lista de códigos de categorias donde se buscarán.
	 * @param palabraClave , la palabra clave a buscar.
	 * @param start , posicion inicio de la lista. Inicia con 0.
	 * @param end , posicion fin de la lista. Finaliza con longitud-1
	 * @return List<Document> conteniendo la lista de contenidos resultados de búsqueda.
	 */
	public static List<Document> getLuceneContentSearch(RenderRequest renderRequest,
			long companyId, long groupId, List<Long> categoryIds, String palabraClave, int start,
			int end) {

		List<Document> documentos = null;
		Hits resultados;
		try {
			SearchContext searchContext = SearchContextFactory.getInstance(PortalUtil
					.getHttpServletRequest(renderRequest));
			// Query que busca en el portal que deseemos
			BooleanQuery contextQuery = BooleanQueryFactoryUtil.create(searchContext);
			contextQuery.addRequiredTerm(Field.COMPANY_ID, companyId);
			contextQuery.addRequiredTerm(Field.GROUP_ID, groupId);

			// Query que busca que la cadena introducida por el usuairo está en
			
			// uno de los campos principales
			BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);

			if(Validator.isNotNull(palabraClave)){
				palabraClave=escapeLuceneCharacters(palabraClave);
				
				String[] frases = palabraClave.split(" ");
				for (String frase : frases) {
					/*String decode=escapeLuceneSpanish(frase)+"*";*/
					frase=removeSpanish(frase);
					searchQuery.addTerm(Field.TITLE,frase+"*" );
					searchQuery.addTerm(Field.CONTENT, frase+"*");
					
					searchQuery.addTerm(Field.TITLE,frase );
					searchQuery.addTerm(Field.CONTENT, frase);
				}
			}
			// searchQuery.addTerm(Field.DESCRIPTION, palabraClave);
			// searchQuery.addTerm(Field.PROPERTIES, palabraClave);

			// Querypara buscador solo JournalContents
			BooleanQuery JCQuery = BooleanQueryFactoryUtil.create(searchContext);
			JCQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, JournalArticle.class.getName());
			JCQuery.addRequiredTerm(Field.STATUS, 0);

			// Querypara buscador solo Ciertas categorias
			BooleanQuery categoriaQuery = BooleanQueryFactoryUtil.create(searchContext);
			for (long categoria : categoryIds) {
				categoriaQuery.addTerm(Field.ASSET_CATEGORY_IDS, categoria + "", false,
						BooleanClauseOccur.SHOULD);
			}

			// Query
			// expandoQuery=StringQueryFactoryUtil.create("expando/custom_fields/destacado:si");
			// Creamos query completa para enlazar las demás obligando a que
			// el enlace sea un AND [MUST] en lugar de un OR[SHOULD]
			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);
			fullQuery.add(searchQuery, BooleanClauseOccur.MUST);
			fullQuery.add(JCQuery, BooleanClauseOccur.MUST);
			fullQuery.add(categoriaQuery, BooleanClauseOccur.MUST);
			// fullQuery.add(expandoQuery , BooleanClauseOccur.MUST);

			// Añadimos ordenación (nombre descendente)
			Sort sort = new Sort();
			sort.setFieldName(Field.TITLE);
			sort.setType(Sort.STRING_TYPE);
			sort.setReverse(true);

			_log.info("QUERY:"+fullQuery.toString());
			
			// Recorremos resultados

			resultados = SearchEngineUtil.search(SearchEngineUtil.getDefaultSearchEngineId(),
					companyId, fullQuery, sort, start, end);

			documentos = resultados.toList();
		} catch (Exception e) {
			_log.error("Error al realizar la búsqueda Lucene:" + e.toString());
		}

		return documentos;
	}

	/**
	 * Obtiene el listado de contenidos dado los parámetros de búsqueda dentro del portal.
	 * Fecha: 18/02/2013
	 *
	 * @param renderRequest , el request en fase render.
	 * @param companyId , el codigo de la compania asignada por el aplicativo.
	 * @param groupId , el codigo de grupo.
	 * @param categoryIds , lista de códigos de categorias donde se buscarán.
	 * @param palabraClave , la palabra clave a buscar.
	 * @return int , cantidad de contenidos de resultado.
	 */
	public static int getLuceneContentSearchCount(RenderRequest renderRequest, long companyId,
			long groupId, List<Long> categoryIds, String palabraClave) {

		List<Document> documentos = null;
		try {
			documentos = getLuceneContentSearch(renderRequest, companyId, groupId, categoryIds,
					palabraClave, -1, -1);
		} catch (Exception e) {
			_log.error("Error al realizar la búsqueda Lucene:" + e.toString());
		}

		if (documentos == null) {
			return 0;
		} else {
			return documentos.size();
		}
	}

	/**
	 * Obtiene el valor del contenido de una plantilla XML.
	 * Fecha: 18/02/2013
	 *
	 * @param localeContent , contenido XML del contenido.
	 * @return String , valor del contenido extraído de la plantilla.
	 */
	public static String getParseContentValue(String localeContent) {
		String value = "";
		try {
			com.liferay.portal.kernel.xml.Document document = SAXReaderUtil.read(localeContent);
			Node node = document.selectSingleNode("/root/static-content");
			if (node != null) {
				value = node.getText();
			}
		} catch (Exception e) {

			_log.error("Error en getParseValue:" + e.toString());
		}

		return value;
	}

	/**
	 * Obtiene el contenido de un campo obtenido de un articulo con plantilla.
	 * Fecha: 18/02/2013
	 *
	 * @param fieldname , nomrbe del campo en la plantilla.
	 * @param article , codigo del articulo.
	 * @param languageID , codigo del language.
	 * @return String , contenido extraído de la plantilla.
	 */
	public static String getParseValue(String fieldname, JournalArticle article, String languageID) {
		String value = "";
		try {
			com.liferay.portal.kernel.xml.Document document = SAXReaderUtil.read(article
					.getContentByLocale(languageID));
			Node node = document.selectSingleNode("/root/dynamic-element[@name='" + fieldname
					+ "']/dynamic-content");
			value = node.getText();
		} catch (Exception e) {

			_log.error("Error en getParseValue:" + e.toString());
		}

		return value;
	}

	/**
	 * Resultados de búsqueda retornados según la categoria.
	 * Fecha: 18/02/2013
	 *
	 * @param themeDisplay , objeto con información.
	 * @param assetEntry , el valor del contenido.
	 * @return BuscadorBean , con el valor de la respuesta a visualizar.
	 */
	public static BuscadorBean visualizarAsset(ThemeDisplay themeDisplay, AssetEntry assetEntry) {
		JournalArticleResource recurso;
		JournalArticle articulo;
		JournalArticleDisplay articleDisplay;
		BuscadorBean aux = null;
		String contenido, titulo;

		try {
			aux = new BuscadorBean();
			recurso = JournalArticleResourceLocalServiceUtil.getArticleResource(assetEntry
					.getClassPK());
			articulo = JournalArticleLocalServiceUtil.getArticle(assetEntry.getGroupId(),
					recurso.getArticleId());
			contenido = "";
			titulo = "";

			/* Genericos */
			contenido = BuscadorUtil.getParseContentValue(articulo.getContentByLocale(themeDisplay
					.getLanguageId()));
			titulo = assetEntry.getTitle(themeDisplay.getLocale());

			/* Verificamos si tiene Template */
			if (Validator.isNotNull(articulo.getStructureId())) {
				if (!articulo.getStructureId().equalsIgnoreCase("0")) {
					/* Si tiene Estructura */
					// Pintamos segun la categoria de contenido
					if (isCategoria("Preguntas Frecuentes", assetEntry.getCategories())) {
						// Si es PREGUNTA FRECUENTE
						// Solo aplicamos la plantilla
						articleDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(articulo,
								null, null, themeDisplay.getLanguageId(), 1, null, themeDisplay);

						contenido = articleDisplay.getContent();

					} else {
						contenido = assetEntry.getDescription(themeDisplay.getLocale());
					}

				}
			}

			contenido = HtmlUtil.stripHtml(contenido);
			aux.setTitulo(titulo);
			aux.setResumen(StringUtil.shorten(contenido, 100));
			try{
			aux.setUrl(themeDisplay.getURLPortal() + "/"
					+ FriendlyURLGenerator.getURLAmigable(articulo, themeDisplay));
			
			}catch(Exception e){
				_log.error("No existe url amigable:"+e.toString());
				aux.setUrl("SIN URL");
			}
			aux.setCategoria(AssetCategoryLocalServiceUtil.getAssetCategory(
					assetEntry.getCategoryIds()[0]).getName());
		} catch (Exception e) {
			_log.error("Error al traer el contenido asociado al resultado de búsqueda:"+e.toString());
		}

		return aux;
	}

	/**
	 * Comprueba si es categoria.
	 * Fecha: 18/02/2013
	 *
	 * @param nombreCategoria the nombre categoria
	 * @param categorias the categorias
	 * @return true, si es categoria
	 */
	public static boolean isCategoria(String nombreCategoria, List<AssetCategory> categorias) {
		boolean resultado = false;
		try {
			if (categorias != null) {
				for (AssetCategory categoria : categorias) {
					if (categoria.getName().equalsIgnoreCase(nombreCategoria)) {
						resultado = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			_log.error("Error al obtener la categoría:"+e.toString());
		}
		return resultado;
	}

	/** The Constant SPECIAL. */
	public static final String[] SPECIAL = new String[] { "á", "Á", "é", "É", "í", "Í", "ó", "Ó",
			"ú", "Ú" };

	/** The Constant NORMAL. */
	public static final String[] NORMAL = new String[] { "a", "A", "e", "E", "i", "I", "o", "O",
			"u", "U" };
	
	/** Constantes de Lucene **/
	private static final String LUCENE_ESCAPE_CHARS = "[\\\\+\\-\\!\\(\\)\\:\\^\\]\\{\\}\\~\\*\\?]";
	private static final Pattern LUCENE_PATTERN = Pattern.compile(LUCENE_ESCAPE_CHARS);
	private static final String REPLACEMENT_STRING =/* " ";//*/"\\\\$0";

	/**
	 * Escapa los caracteres especiales definidos para la busqueda de palabras.
	 * Fecha: 18/02/2013
	 *
	 * @param text , la cadena de texto a escapar.
	 * @return String , texto escapado.
	 */
	public static String escapeSpanish(String text) {
		text = removeSpanish(text);
		for (int i = SPECIAL.length - 1; i >= 0; i--) {
			text = StringUtil.replace(text, NORMAL[i], "[" + NORMAL[i] + SPECIAL[i] + "]");
		}
		return text;
	}

	/**
	 * Remueve los caracteres especiales definidos para la busqueda de palabras.
	 * Fecha: 18/02/2013
	 *
	 * @param text , la cadena de texto a escapar.
	 * @return String , texto removido de caracteres especiales.
	 */
	public static String removeSpanish(String text) {
		/*for (int i = SPECIAL.length - 1; i >= 0; i--) {
			text = StringUtil.replace(text, SPECIAL[i], NORMAL[i]);
		}
		return text;
		*/
		return AsciiUtils.convertNonAscii(text);
	}

	/**
	 * Escape lucene spanish.
	 * Fecha: 18/02/2013
	 *
	 * @param text the text
	 * @return the string
	 */
	public static String escapeLuceneSpanish(String text) {
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
	
	public static List<Long> getNivelDosExcepto(String[] lstExcepcionesNivel){
		List<Long> lstNivel2 = new ArrayList<Long>();
		
		try {
			 
			 DynamicQuery consultaLayouts =DynamicQueryFactoryUtil.forClass(Layout.class)
					.add(PropertyFactoryUtil.forName("hidden").eq(false))
					.add(PropertyFactoryUtil.forName("privateLayout").eq(false));
			 
			 List<Criterion> lsCriterio = new ArrayList<Criterion>();
			 
			 for(String sa: lstExcepcionesNivel){
				 lsCriterio.add(RestrictionsFactoryUtil.ilike("friendlyURL", sa ));
			 }

			// Se construye la funcion OR.		
		    Disjunction funcionOr = RestrictionsFactoryUtil.disjunction();
			
		    for(Criterion c :  lsCriterio){
		    	funcionOr.add(c);
		    }
		    
		    consultaLayouts.add(funcionOr);
		    List<Layout> lstLay= LayoutLocalServiceUtil.dynamicQuery(consultaLayouts);
		    
		    for(Layout l : lstLay){
		    	lstNivel2.add(l.getLayoutId());
		    }
		    
		} catch(Exception e){
			_log.error("Error al traer el nivel 2 de paginas:"+e.toString());
		}
		
		return lstNivel2;
	}
	
	public static List<Layout> getListUrlSearch(String palabraClave, List<Long> lstExc){
		
		 List<Layout> lstLayout = new ArrayList<Layout>();
		 /*PAginas*/
		 
		 String [] frases=palabraClave.split(" ");
		 
		 try {
			 
			 DynamicQuery consultaLayouts =DynamicQueryFactoryUtil.forClass(Layout.class)
					.add(PropertyFactoryUtil.forName("type").eq("portlet"))
					.add(PropertyFactoryUtil.forName("hidden").eq(false))
					.add(PropertyFactoryUtil.forName("privateLayout").eq(false));

		 
		 List<Criterion> lsCriterio = new ArrayList<Criterion>();
		 List<Criterion> lsCriterioNivel2 = new ArrayList<Criterion>();
		 
		 int p = frases.length;
		 
		 for(int a=0;a<p;a++){
			 lsCriterio.add(RestrictionsFactoryUtil.ilike("name", "%"+ escapeSpanish(frases[a]) + "%" ));
		 }

		// Se construye la funcion OR.		
	    Disjunction funcionOr = RestrictionsFactoryUtil.disjunction();
		
	    for(Criterion c :  lsCriterio){
	    	funcionOr.add(c);
	    }
	    
	    
	    //Construccion and de excepciones
	    for(long lo: lstExc){
	    	lsCriterioNivel2.add(RestrictionsFactoryUtil.ne("parentLayoutId", lo ));
		 }
	    
	    Conjunction funcionAnd = RestrictionsFactoryUtil.conjunction();
	    for(Criterion c :  lsCriterioNivel2){
	    	funcionAnd.add(c);
	    }
	    
	    consultaLayouts.add(funcionOr);
	    consultaLayouts.add(funcionAnd);
		lstLayout=LayoutLocalServiceUtil.dynamicQuery(consultaLayouts);

		} catch (Exception e) {
			// TODO: handle exception
			_log.error("Error al traer la búsqueda de URLS:"+e.toString());
		}
		 
		  return lstLayout;
	}
	
	public static String escapeLuceneCharacters(String userInput){
		String escaped = LUCENE_PATTERN.matcher(userInput).replaceAll(REPLACEMENT_STRING);
		return escaped;
	}
}
