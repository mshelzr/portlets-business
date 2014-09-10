package pe.com.ibk.halcon.promociones.controller;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class DetallePromocionController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class DetallePromocionController {
 
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(DetallePromocionController.class);
	//private static Integer indicadorPortlet=21;
	//private static Integer indicadorController=1;
	
	 /**
	 * Default view.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 * @throws SystemException the system exception
	 */
	@RequestMapping  
	    protected String defaultView(RenderRequest renderRequest,
				RenderResponse renderResponse) throws SystemException {
		 // Id Detalle 20112
		 
		 	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
 			Long groupId = themeDisplay.getScopeGroupId();
 			String idBanner = StringPool.BLANK;
 			String idDetalle = StringPool.BLANK;
 			HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
//		 	Long classPK = ParamUtil.getLong(httpReq, "idArticle");
		 	String classPK = ParamUtil.getString(httpReq, "idArticle");
		 	_log.info(classPK);
		 	
		 	try {
		 		if (classPK.length() > 0) {
		 			JournalArticle articulo =JournalArticleLocalServiceUtil.getArticle(groupId, String.valueOf(classPK));
			    	idBanner = getParseValue("idBannerPromocion",articulo,themeDisplay.getLanguageId());
			    	idDetalle = getParseValue("idDetallePromocion",articulo,themeDisplay.getLanguageId());
		 		}
		    	
			} catch (Exception e) {
				e.printStackTrace();
			}
		 
		 	renderRequest.setAttribute("idBanner", idBanner);
		 	renderRequest.setAttribute("idDetalle", idDetalle);
		 	//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		 return "view";
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
 	public String getParseValue(String fieldname, JournalArticle article, String languageID)
		{
		    String value = "";
		    try {
		    	 com.liferay.portal.kernel.xml.Document document =SAXReaderUtil.read(article.getContentByLocale(languageID));
		         Node node = document.selectSingleNode("/root/dynamic-element[@name='"+ fieldname + "']/dynamic-content");
		         value = node.getText();
		    }
		    catch(Exception e){
		      
		         _log.error(e.getMessage());
		    }
		 
		    return value;
		}
}
