package com.exp.portlet.halcon.utils;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;

public class FriendlyURLGenerator {

	private static Log _log = LogFactoryUtil.getLog(FriendlyURLGenerator.class);
	
	private static final String CAT_NOTICIAS="Noticias";
	private static final String CAT_EVENTOS="Notas de Prensa";
	private static final String CAT_PROMOCIONES="Promociones";
	private static final String CAT_PRODUCTOS="Productos";
	private static final String CAT_PREGUNTAS_FRECUENTES="Preguntas Frecuentes";
	
	
	public static String getURLAmigable(JournalArticle articulo,ThemeDisplay themeDisplay)throws SystemException, PortalException{
		/*Formamos las URL de los tipos de contenidos
		 *  noticias
			promociones 
			eventos
			preguntas frecuentes
			productos
		 * */
		List<AssetCategory> categorias ;
		String nombreCategoria;
		StringBuilder url;
		long categoryId;
		
		categorias = AssetCategoryLocalServiceUtil.getCategories(JournalArticle.class.getName(), articulo.getResourcePrimKey());
		nombreCategoria="";
		categoryId=0;
		url=new StringBuilder();
		/*De las N Categorias que puede tener extraemos la que tenga el parent 0*/
		if(categorias!=null && !categorias.isEmpty()){
			for (AssetCategory categoria : categorias) {
				if(categoria.getParentCategoryId()==0){
					nombreCategoria=categoria.getName();
					categoryId=categoria.getCategoryId();
					break;
				}
			}
			
			
			//Verifico
			if(Validator.isNotNull(nombreCategoria)){
				if(nombreCategoria.equalsIgnoreCase(CAT_NOTICIAS)){
					//NOTICIAS  http://localhost:8090/detalle-noticia?idArticle=26070
					/*url.append("detalle-noticia?idArticle=");
					url.append(articulo.getArticleId());*/
					url.append("noticias");
					url.append("/");
					url.append(FriendlyURLNormalizer.normalizeNoStopWords(articulo.getTitle(themeDisplay.getLocale())));
					url.append("-");
					url.append(articulo.getArticleId());
					
				}else if(nombreCategoria.equalsIgnoreCase(CAT_EVENTOS)){
					//EVENTOS  http://localhost:8090/detalle-evento?idArticle=13224
					/*url.append("detalle-evento?idArticle=");
					url.append(articulo.getArticleId());*/
					url.append("notas-de-prensa");
					url.append("/");
					url.append(FriendlyURLNormalizer.normalizeNoStopWords(articulo.getTitle(themeDisplay.getLocale())));
					url.append("-");
					url.append(articulo.getArticleId());
					
				}else if(nombreCategoria.equalsIgnoreCase(CAT_PROMOCIONES)){
					//PROMOCIONES http://localhost:8090/detalle-promocion?idArticle=20112
					/*url.append("detalle-promocion?idArticle=");
					url.append(articulo.getArticleId());*/
					url.append("promociones");
					url.append("/");
					url.append(FriendlyURLNormalizer.normalizeNoStopWords(articulo.getTitle(themeDisplay.getLocale())));
					url.append("-");
					url.append(articulo.getArticleId());
					
				}else if(nombreCategoria.equalsIgnoreCase(CAT_PRODUCTOS)){
					//PRODUCTOS  http://localhost:8080/web/guest/cuenta-millonaria -- idPaginaAsociada
					String idPaginaAsociada=getParseValue("idPaginaAsociada", articulo,themeDisplay.getLanguageId());
					Layout pAsoc=LayoutLocalServiceUtil.getLayout(themeDisplay.getScopeGroupId(), false, Long.valueOf(idPaginaAsociada.replaceAll("@public", "")));
					url.append(pAsoc.getFriendlyURL().replaceAll("/", ""));
					
				}else if(nombreCategoria.equalsIgnoreCase(CAT_PREGUNTAS_FRECUENTES)){
					//PREGUNTAS FRECUENTES  http://localhost:8080/web/guest/resultado-preguntas-frecuentes?id=36426&c=36301
					url.append("resultado-preguntas-frecuentes?id=");
					url.append(articulo.getArticleId());
					url.append("&c=");
					url.append(categoryId);
				}
			}
		}
		return url.toString();
	}
	
	private static String getParseValue(String fieldname, JournalArticle article,String languageID) {
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
}
