package pe.com.ibk.halcon.contenidoweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.RenderRequest;

import pe.com.ibk.halcon.contenidoweb.model.BuscadorBean;

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
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public class BuscadorUtil {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(BuscadorUtil.class);
	

	/**
	 * Obtiene categorias excepto.
	 * Fecha: 22/08/2013
	 *
	 * @param companyId the company id
	 * @param groupId the group id
	 * @param nombreCategoriasExcluidas the nombre categorias excluidas
	 * @return categorias excepto
	 */
	public static List<Long> getCategoriasExcepto(long companyId,long groupId,String[] nombreCategoriasExcluidas){
		  List<Long> admitidos=null;
		  try{
			  DynamicQuery queryCategoria =DynamicQueryFactoryUtil.forClass(AssetCategory.class, PortalClassLoaderUtil.getClassLoader())
						.add(PropertyFactoryUtil.forName("companyId").eq(companyId))
						.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
			  
			  List<AssetCategory> categorias =AssetCategoryLocalServiceUtil.dynamicQuery(queryCategoria);
				for (AssetCategory categoria : categorias) {
					boolean isActive=true;
					
					for (String excluidos : nombreCategoriasExcluidas) {
						if(excluidos.equalsIgnoreCase(categoria.getName())){
							isActive=false;
							break;
						}
					}
					
					/*Agrego y hago break al for de excluidos*/
					if(isActive){
						if(admitidos==null){admitidos=new ArrayList<Long>();}
						admitidos.add(categoria.getCategoryId());
						//_log.info("Admitido:"+categoria.getName());
					}
				}
		  }catch(Exception e){
			  _log.error("Error al filtrar las Categorias:"+e.toString());
		  }
		  return admitidos;
	  }
	  
		/**
		 * Obtiene lucene content search.
		 * Fecha: 22/08/2013
		 *
		 * @param renderRequest the render request
		 * @param companyId the company id
		 * @param groupId the group id
		 * @param categoryIds the category ids
		 * @param palabraClave the palabra clave
		 * @param start the start
		 * @param end the end
		 * @return lucene content search
		 */
		public static List<Document> getLuceneContentSearch(RenderRequest renderRequest,long companyId,long groupId,List<Long> categoryIds,String palabraClave,int start,int end){
			
			List<Document> documentos=null;
			Hits  resultados;
			try{
				SearchContext searchContext = SearchContextFactory.getInstance(PortalUtil.getHttpServletRequest(renderRequest));
				// Query que busca en el portal que deseemos
				BooleanQuery contextQuery = BooleanQueryFactoryUtil.create(searchContext);
				contextQuery.addRequiredTerm(Field.COMPANY_ID, companyId);
				contextQuery.addRequiredTerm(Field.GROUP_ID, groupId);

				// Query que busca que la cadena introducida por el usuairo está en
				String [] frases=palabraClave.split(" ");
				// uno de los campos principales
				BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);
				
				for (String frase : frases) {
					searchQuery.addTerm(Field.TITLE, escapeLuceneSpanish(frase));
					searchQuery.addTerm(Field.CONTENT, escapeLuceneSpanish(frase));
				}
				// searchQuery.addTerm(Field.DESCRIPTION, palabraClave);
				// searchQuery.addTerm(Field.PROPERTIES, palabraClave);

				// Querypara buscador solo JournalContents
				BooleanQuery JCQuery = BooleanQueryFactoryUtil.create(searchContext);
				JCQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, JournalArticle.class.getName());
				JCQuery.addRequiredTerm(Field.STATUS,0 );
				  
				// Querypara buscador solo Ciertas categorias
				BooleanQuery categoriaQuery = BooleanQueryFactoryUtil.create(searchContext);
				for (long categoria : categoryIds) {
					categoriaQuery.addTerm(Field.ASSET_CATEGORY_IDS,categoria+"",false,BooleanClauseOccur.SHOULD);
				}
				
				//Query expandoQuery=StringQueryFactoryUtil.create("expando/custom_fields/destacado:si");
				// Creamos query completa para enlazar las demás obligando a que
				// el enlace sea un AND [MUST] en lugar de un OR[SHOULD]
				BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
				fullQuery.add(contextQuery, BooleanClauseOccur.MUST);
				fullQuery.add(searchQuery, BooleanClauseOccur.MUST);
				fullQuery.add(JCQuery , BooleanClauseOccur.MUST);
				fullQuery.add(categoriaQuery , BooleanClauseOccur.MUST);
				//fullQuery.add(expandoQuery , BooleanClauseOccur.MUST);
				
				// Añadimos ordenación (nombre descendente)
				Sort sort = new Sort();
				sort.setFieldName(Field.TITLE);
				sort.setType(Sort.STRING_TYPE);
				sort.setReverse(true);   

				_log.info("Query New:"+fullQuery.toString());

				// Recorremos resultados
				
				resultados=SearchEngineUtil.search(SearchEngineUtil.getDefaultSearchEngineId(),companyId, fullQuery,sort,start,end);
				
				documentos = resultados.toList();
			}catch(Exception e){
				_log.error("Error al realizar la busqueda Lucene:"+e.toString());
			}
			
			return documentos;
		}
		
		
		
		/**
		 * Obtiene lucene content search count.
		 * Fecha: 22/08/2013
		 *
		 * @param renderRequest the render request
		 * @param companyId the company id
		 * @param groupId the group id
		 * @param categoryIds the category ids
		 * @param palabraClave the palabra clave
		 * @return lucene content search count
		 */
		public static int getLuceneContentSearchCount(RenderRequest renderRequest,long companyId,long groupId,List<Long> categoryIds,String palabraClave){
			
			List<Document> documentos=null;
			try{
				documentos=getLuceneContentSearch( renderRequest, companyId, groupId,categoryIds,palabraClave, -1, -1);
			}catch(Exception e){
				_log.error("Error al realizar la busqueda Lucene:"+e.toString());
			}
			
			if(documentos==null){
				return 0;
			}else{
				return documentos.size();
			}
		}
		
		/**
		 * Obtiene parses the content value.
		 * Fecha: 22/08/2013
		 *
		 * @param localeContent the locale content
		 * @return parses the content value
		 */
		public static String getParseContentValue(String localeContent)
		{
		    String value = "";
		    try {
		    	 com.liferay.portal.kernel.xml.Document document =SAXReaderUtil.read(localeContent);
		         Node node = document.selectSingleNode("/root/static-content");
		         if(node!=null){
		        	 value = node.getText();
		         }
		    }
		    catch(Exception e){
		      
		    	_log.error("Error en getParseValue:"+e.toString());
		    }
		 
		    return value;
		}
		
		/**
		 * Obtiene parses the value.
		 * Fecha: 22/08/2013
		 *
		 * @param fieldname the fieldname
		 * @param article the article
		 * @param languageID the language id
		 * @return parses the value
		 */
		public static String getParseValue(String fieldname, JournalArticle article,String languageID) {
			 String value = "";
			    try {
			    	 com.liferay.portal.kernel.xml.Document document =SAXReaderUtil.read(article.getContentByLocale(languageID));
			         Node node = document.selectSingleNode("/root/dynamic-element[@name='"+ fieldname + "']/dynamic-content");
			         value = node.getText();
			    }
			    catch(Exception e){
			      
			         _log.error("Error en getParseValue:"+e.toString());
			    }
			 
			    return value;
		}
		
		/**
		 * Visualizar asset.
		 * Fecha: 22/08/2013
		 *
		 * @param themeDisplay the theme display
		 * @param assetEntry the asset entry
		 * @return the buscador bean
		 */
		public static BuscadorBean visualizarAsset(ThemeDisplay themeDisplay,AssetEntry assetEntry){
		  	JournalArticleResource recurso;
			JournalArticle articulo;
			JournalArticleDisplay articleDisplay ;
			BuscadorBean aux=null;
			String contenido, languageID,titulo;
			
		  try{
			    aux=new BuscadorBean();
			    recurso = JournalArticleResourceLocalServiceUtil.getArticleResource(assetEntry.getClassPK());
				articulo =JournalArticleLocalServiceUtil.getArticle(assetEntry.getGroupId(), recurso.getArticleId());
				contenido="";
				languageID=themeDisplay.getLanguageId();
				titulo="";
				
				/*Genericos*/
				contenido=BuscadorUtil.getParseContentValue(articulo.getContentByLocale(themeDisplay.getLanguageId()));
				titulo=assetEntry.getTitle(themeDisplay.getLocale());
				
				/*Verificamos si tiene Template*/
				if(Validator.isNotNull(articulo.getStructureId())){
					if(!articulo.getStructureId().equalsIgnoreCase("0")){
						/*Si  tiene Estructura*/
						//Pintamos segun la categoria de contenido
						if(isCategoria("Preguntas Frecuentes",assetEntry.getCategories())){
							//Si es PREGUNTA FRECUENTE
							//Solo aplicamos la plantilla
							articleDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(
									articulo, 
					                null, 
					                null, 
					                themeDisplay.getLanguageId(), 1, null, themeDisplay);
							
							
							contenido=articleDisplay.getContent();
							
						}else{
							contenido=assetEntry.getDescription(themeDisplay.getLocale());
						}
						
					}
				}
				
				contenido=HtmlUtil.stripHtml(contenido);
				aux.setTitulo(titulo);
				aux.setUrl(themeDisplay.getURLPortal()+"/"+FriendlyURLGenerator.getURLAmigable(articulo, themeDisplay));
//				aux.setCategoria(AssetCategoryLocalServiceUtil.getAssetCategory(assetEntry.getCategoryIds()[0]).getName());
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  
		  return aux;
	  }
	  
	  /**
  	 * Comprueba si es categoria.
  	 * Fecha: 22/08/2013
  	 *
  	 * @param nombreCategoria the nombre categoria
  	 * @param categorias the categorias
  	 * @return true, si es categoria
  	 */
  	public static boolean isCategoria(String nombreCategoria,List<AssetCategory> categorias){
		  boolean resultado=false;
		  try{
			  if(categorias!=null){
				  for (AssetCategory categoria : categorias) {
					if(categoria.getName().equalsIgnoreCase(nombreCategoria)){
						resultado=true;
						break;
					}
				}
			  }
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  return resultado;
	  }
	  
	  /** The Constant SPECIAL. */
  	public static final String[] SPECIAL = new String[] {
			"á","Á","é","É","í","Í","o","Ó","u","Ú"
		};
		
		/** The Constant NORMAL. */
		public static final String[] NORMAL = new String[] {
			"a","A","e","E","i","I","o","O","u","U"
		};
	
		/**
		 * Escape spanish.
		 * Fecha: 22/08/2013
		 *
		 * @param text the text
		 * @return the string
		 */
		public static String escapeSpanish(String text) {
			text=removeSpanish(text);
			for (int i = SPECIAL.length - 1; i >= 0; i--) {
				text = StringUtil.replace(text, NORMAL[i],  "["+NORMAL[i]+SPECIAL[i]+"]");
			}
			return text;
		}
		
		/**
		 * Removes the spanish.
		 * Fecha: 22/08/2013
		 *
		 * @param text the text
		 * @return the string
		 */
		public static String  removeSpanish(String text) {
			for (int i = SPECIAL.length - 1; i >= 0; i--) {
				text = StringUtil.replace(text, SPECIAL[i], NORMAL[i]);
			}
			return text;
		}
		
		/**
		 * Escape lucene spanish.
		 * Fecha: 22/08/2013
		 *
		 * @param text the text
		 * @return the string
		 */
		public static String escapeLuceneSpanish(String text) {
			text=removeSpanish(text);
			/*Verificamos que la primera letra no sea vocal pa no poner '?'*/
			String primeraLetra=text.substring(0, 1);//Primer Caracter Normal
			String primeraLetraSpecial="";//Primer Caracter Special
			boolean esVocal=false;
			int tamanio=text.length();
			//Verificamos si es una vocal
			for (int i = NORMAL.length - 1; i >= 0; i--) {
				if(primeraLetra.equalsIgnoreCase( NORMAL[i]) && !esVocal){
					esVocal=true;
					primeraLetraSpecial=SPECIAL[i];
				}
				
				text = StringUtil.replace(text, NORMAL[i],  "?");
			}
			
			
			if(esVocal){
				text=primeraLetra+text.substring(1, tamanio)+" OR "+primeraLetraSpecial+text.substring(1, tamanio);
			}
			
			return text;
		}
		
		/**
		 * Obtiene list url search.
		 * Fecha: 22/08/2013
		 *
		 * @param palabraClave the palabra clave
		 * @param lstExc the lst exc
		 * @return list url search
		 */
		public static List<Layout> getListUrlSearch(String palabraClave, List<Long> lstExc){
			
			 List<Layout> lstLayout = new ArrayList<Layout>();
			 /*PAginas*/
			 
			 String [] frases=palabraClave.split(" ");
			 
			 try {
				 
				 DynamicQuery consultaLayouts =DynamicQueryFactoryUtil.forClass(Layout.class)
//						 .add(PropertyFactoryUtil.forName("name").like("%"+palabraClave+"%"))
						.add(PropertyFactoryUtil.forName("hidden").eq(false))
						.add(PropertyFactoryUtil.forName("privateLayout").eq(false))
						.add(PropertyFactoryUtil.forName("type").ne("link_to_layout"));

			 
			 List<Criterion> lsCriterio = new ArrayList<Criterion>();
			 List<Criterion> lsCriterioNivel2 = new ArrayList<Criterion>();
			 
			 int p = frases.length;
			 int i=0;
			 
			 for(int a=0;a<p;a++){
				 lsCriterio.add(RestrictionsFactoryUtil.ilike("name", "%"+ frases[a] + "%" ));
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
				e.printStackTrace();
			}
			 
			  return lstLayout;
		}
		
		/**
		 * Obtiene nivel dos excepto.
		 * Fecha: 22/08/2013
		 *
		 * @param lstExcepcionesNivel the lst excepciones nivel
		 * @return nivel dos excepto
		 */
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
				e.printStackTrace();
			}
			
			return lstNivel2;
		}
}