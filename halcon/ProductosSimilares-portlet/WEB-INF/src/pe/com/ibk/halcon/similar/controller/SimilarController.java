package pe.com.ibk.halcon.similar.controller;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.ibk.halcon.similar.bean.SimilarBean;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class SimilarController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class SimilarController {
	
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(SimilarController.class);
	//private static Integer indicadorPortlet=29;
	//private static Integer indicadorController=1;
	/**
	 * Default view.
	 * Fecha: 18/02/2013
	 *
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest, RenderResponse renderResponse) {
		ThemeDisplay themeDisplay;
		long groupId;
		List<SimilarBean> asociados;
		try {
			themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			groupId = themeDisplay.getScopeGroupId();
			asociados = null;
			/* Obtenemos la pagina actual */
			Layout paginaActual = themeDisplay.getLayout();
			Layout paginaPadre = LayoutLocalServiceUtil.getLayout(groupId, false,
					paginaActual.getParentLayoutId());
			/* Obtenemos los hermanos */
			List<Layout> hermanos = paginaPadre.getChildren();

			if (hermanos != null) {
				for (Layout hermano : hermanos) {
					boolean hasFichaProducto = false;
					/* Extraemos el producto asociado la página */
					String codProducto =  (String) hermano.getExpandoBridge().getAttribute(
							"idContenidoProducto");
					_log.info("Hermano:" + hermano.getName(themeDisplay.getLocale()) + "-"
							+ codProducto);
					if (Validator.isNotNull(codProducto)) {
						try {
							JournalArticle articulo = JournalArticleLocalServiceUtil
									.getLatestArticle(themeDisplay.getScopeGroupId(), codProducto, WorkflowConstants.STATUS_APPROVED);
							String idContenidoSeccion = getParseValue("idContenidoSeccion",
									articulo, themeDisplay.getLanguageId());
							if (!idContenidoSeccion.equalsIgnoreCase("0")) {
								hasFichaProducto = true;
							}
						} catch (Exception e) {
							_log.error("La página " + hermano.getName(themeDisplay.getLocale())
									+ " no tiene un producto asociado:" + e.toString());
						}
					}
					/* Que no sea oculto,privado ni la pagina actual y tenga Ficha de producto */

					if (!hermano.isHidden() && !hermano.isPrivateLayout()
							&& (hermano.getLayoutId() != paginaActual.getLayoutId())
							&& hasFichaProducto) {
						if (asociados == null) {
							asociados = new ArrayList<SimilarBean>();
						}
						SimilarBean aux = new SimilarBean();
						aux.setNombre(hermano.getName(themeDisplay.getLocale()));
						aux.setUrl(hermano.getFriendlyURL());

						asociados.add(aux);
					}
				}
			}

			renderRequest.setAttribute("hermanos", asociados);
			renderRequest
					.setAttribute("nombrePadre", paginaPadre.getName(themeDisplay.getLocale()));
			renderRequest.setAttribute("urlPadre", paginaPadre.getFriendlyURL());
		} catch (Exception e) {
			_log.error("Error al obtener productos de la misma seccion : " +e.toString());
			e.printStackTrace();
		}
		//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "view";
	}

	/**
	 * Obtiene parses the value.
	 * Fecha: 18/02/2013
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
