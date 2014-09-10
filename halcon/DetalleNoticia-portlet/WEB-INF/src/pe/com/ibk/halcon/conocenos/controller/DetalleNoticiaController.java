package pe.com.ibk.halcon.conocenos.controller;

import java.text.SimpleDateFormat;

import javax.portlet.RenderRequest;
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
 * Portlet implementation class DetalleNoticiaController
 * Clase controladora para la seccion de detalle de noticias accediendo a contenido Web.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class DetalleNoticiaController {

	/** The Constant _log. */
	static final Log _log = LogFactoryUtil.getLog(DetalleNoticiaController.class);
	//private static Integer indicadorPortlet=20;
	//private static Integer indicadorController=1;

	/**
	 * Default view.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 * @return the string
	 * @throws SystemException the system exception
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest) throws SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Long groupId = themeDisplay.getScopeGroupId();
		String html = StringPool.BLANK;
		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil
				.getHttpServletRequest(renderRequest));
		String classPK = ParamUtil.getString(httpReq, "idArticle");
		_log.info(classPK);
		SimpleDateFormat sdf = new SimpleDateFormat(
				"EEEE dd 'de' MMMMM 'del' yyyy ' > Hora ' HH:mm", PortalUtil.getLocale(renderRequest));
		String resumen = "";
		String titulo = "";
		String fechaCreacion = "";

		try {
			if (classPK.length()>0) {
				JournalArticle articulo = JournalArticleLocalServiceUtil.getLatestArticle(groupId,
						String.valueOf(classPK));
				// if(articulo.getStatus() == 0){
				// }
				html = getParseValue("html", articulo, themeDisplay.getLanguageId());
				resumen = articulo.getDescription(themeDisplay.getLocale());
				titulo = articulo.getTitle(themeDisplay.getLocale());
				//fechaCreacion = sdf.format(articulo.getCreateDate());
				fechaCreacion = sdf.format(articulo.getDisplayDate());
				fechaCreacion = String.valueOf(fechaCreacion.charAt(0)).toUpperCase()
						+ fechaCreacion.substring(1);

			}

		} catch (Exception e) {
			_log.error("Error al obtener el detalle de la noticia " + e.toString());
		}

		renderRequest.setAttribute("html", html);
		renderRequest.setAttribute("resumen", resumen);
		renderRequest.setAttribute("fechaCreacion", fechaCreacion);
		renderRequest.setAttribute("titulo", titulo);
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
	public String getParseValue(String fieldname, JournalArticle article, String languageID) {
		String value = "";
		try {
			com.liferay.portal.kernel.xml.Document document = SAXReaderUtil.read(article
					.getContentByLocale(languageID));
			Node node = document.selectSingleNode("/root/dynamic-element[@name='" + fieldname
					+ "']/dynamic-content");
			value = node.getText();
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		return value;
	}
}
