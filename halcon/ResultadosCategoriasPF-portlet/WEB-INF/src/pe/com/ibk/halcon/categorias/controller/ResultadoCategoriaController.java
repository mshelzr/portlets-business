package pe.com.ibk.halcon.categorias.controller;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.ibk.halcon.categorias.service.ResultadoCategoriaService;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class ResultadoCategoriaController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */

@Controller
@RequestMapping("VIEW")
public class ResultadoCategoriaController {
	
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(ResultadoCategoriaController.class);
	//private static Integer indicadorPortlet=36;
	//private static Integer indicadorController=1;

	
	/** The resultado categoria service. */
	@Autowired
	ResultadoCategoriaService resultadoCategoriaService;

	/**
	 * Default view.
	 * Fecha: 18/02/2013
	 *
	 * @param renderRequest the render request
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay;
		long companyId, groupId, idPregunta;
		HttpServletRequest httpReq;
		String keywords, catID;
		List<AssetCategory> totalCategorias;

		themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		companyId = themeDisplay.getCompanyId();
		groupId = themeDisplay.getScopeGroupId();
		httpReq = PortalUtil.getOriginalServletRequest(PortalUtil
				.getHttpServletRequest(renderRequest));
		keywords = ParamUtil.get(httpReq, "keywords", "");
		catID = ParamUtil.get(httpReq, "c", "");
		idPregunta = ParamUtil.getLong(httpReq, "id", 0L);
		try {
			long idCategoria = resultadoCategoriaService.getCategoryIdbyName(companyId, groupId,
					"Preguntas Frecuentes");
			if (idPregunta == 0) {
				totalCategorias = resultadoCategoriaService.getLuceneContentSearchCountCategorias(
						renderRequest, companyId, groupId, idCategoria, keywords);
			} else {
				AssetCategory categoria = AssetCategoryLocalServiceUtil.getAssetCategory(Long
						.parseLong(catID));
				totalCategorias = new ArrayList<AssetCategory>();
				totalCategorias.add(categoria);
			}
			renderRequest.setAttribute("totalCategorias", totalCategorias);
			renderRequest.setAttribute("key", keywords);
			renderRequest.setAttribute("catID", catID);
			renderRequest.setAttribute("idPregunta", idPregunta);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error("Error al ver portlet de categoria de preguntas Frecuentes:" + e.toString());
		}
		
		//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "view";
	}

}
