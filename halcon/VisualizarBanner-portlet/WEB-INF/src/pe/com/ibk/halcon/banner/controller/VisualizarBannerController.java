package pe.com.ibk.halcon.banner.controller;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.ibk.halcon.banner.utils.VisualizarBannerUtils;

import com.exp.portlet.halcon.utils.SessionUtil;
import com.exp.portlet.halcon.utils.SimuladoresUtil;
import com.ext.portlet.halcon.dto.PromocionBean;
import com.ext.portlet.halcon.dto.SessionBean;
import com.ext.portlet.halcon.service.SolicitudProductoLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class VisualizarBannerController.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 18/02/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class VisualizarBannerController {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(VisualizarBannerController.class);
	//private static Integer indicadorPortlet=44;
	//private static Integer indicadorController=1;
	/**
	 * Default view. Fecha: 18/02/2013
	 * 
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest, RenderResponse renderResponse) {

		boolean isWS = false;
		JournalArticle articulo;
		ThemeDisplay themeDisplay;
		String tipo;
		long groupId;
		String numDoc,tipoDoc;// Recuperamos en DNI De la session
		SessionBean sBean;
		
		themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		groupId = themeDisplay.getScopeGroupId();
		tipo = renderRequest.getPreferences().getValue("tipo", "L");// C:central //L:lateral
		numDoc = "";// Obtenemos el DNI de la session.
		tipoDoc="";
		
			sBean=SessionUtil.traerSession(renderRequest);
			//sBean.setIndicador(1);
			if(sBean.getIndicador()==1 && SimuladoresUtil.getBancaByURL(themeDisplay.getLayout()).equalsIgnoreCase("BP")){
				//Buscar Cookies 
				tipoDoc=sBean.getTipoDoc();
				numDoc=sBean.getNumDoc();
			}
		
		try {

			String codigoPromocion, archivo, urlPagina, altImagen, extension,tipoLink,urlSEO;

			
			if (Validator.isNotNull(numDoc)) {
				//Verificamos si se cambio el Documento en algun formulario
				
				if(sBean.isFlagCambio()){
					//LLAMO al WS
					_log.info("TRAE WS PQ SE CAMBIO DOCUMENTO DE SESSION:");
					// Bean para el web service
					PromocionBean identidadBean = new PromocionBean();
					identidadBean.setTipoDocumento(SimuladoresUtil.obtenerDocumentoSiebel(Integer.parseInt(tipoDoc)));
					identidadBean.setNumDocumento(numDoc);
					identidadBean.setCanal(String.valueOf(SimuladoresUtil.CODIGO_CANAL));
					
					/*Actualizamos el flag de cambio*/
					SessionBean session=new SessionBean();
					session.setTipoDoc(sBean.getTipoDoc());
					session.setNumDoc(sBean.getNumDoc());
					SessionUtil.registrarSession(session, renderRequest,false);

					articulo = VisualizarBannerUtils.getArticuloRamdomWS(renderRequest, identidadBean,SimuladoresUtil.getBancaByURL(themeDisplay.getLayout()),true);
					if (articulo == null) {
						_log.info("TRAE DEL RAMDOM PQ WS NO TRAE NADA");
						articulo = VisualizarBannerUtils.getArticuloRamdom(renderRequest,SimuladoresUtil.getBancaByURL(themeDisplay.getLayout()));
					}else{
						isWS = true;
					}
				}else{
					_log.info("TRAE DEL PROPERTIES PQ DOCUMENTO NO SE CAMBIO SESSION");
					articulo = VisualizarBannerUtils.getArticuloRamdomWS(renderRequest, null,SimuladoresUtil.getBancaByURL(themeDisplay.getLayout()),false);
					if (articulo == null) {
						_log.info("TRAE DEL RAMDOM PQ PROPERTIES NO TRAE NADA");
						articulo = VisualizarBannerUtils.getArticuloRamdom(renderRequest,SimuladoresUtil.getBancaByURL(themeDisplay.getLayout()));
					}else{
						isWS = true;
					}
				}
				
			} else {
//				_log.info("TRAE DEL RAMDOM PQ DOCUMENTO NO ESTA EN SESSION");
				articulo = VisualizarBannerUtils.getArticuloRamdom(renderRequest,SimuladoresUtil.getBancaByURL(themeDisplay.getLayout()));
			}

			if(Validator.isNotNull(articulo)){
				
				codigoPromocion = VisualizarBannerUtils.getParseValue("codigoPromocion", articulo,
						themeDisplay.getLanguageId());
				archivo = VisualizarBannerUtils.getParseValue("archivo", articulo,
						themeDisplay.getLanguageId());
				
				altImagen = VisualizarBannerUtils.getParseValue("altImagen", articulo,
						themeDisplay.getLanguageId());

				tipoLink = VisualizarBannerUtils.getParseValue("tipoLink", articulo,
						themeDisplay.getLanguageId());
				
				urlPagina="#";
				
				urlSEO = VisualizarBannerUtils.getParseValue("urlSEO", articulo,
						themeDisplay.getLanguageId());
				
				
				/* Identificar el tipo de plantilla IMAGEN o FLASH */
				boolean isFlash = archivo.matches(".*[.]swf.*");
				if (isFlash) {
					extension = "FLASH";
				} else {
					extension = "IMAGEN";
				}

				if(tipoLink.equalsIgnoreCase("SP")){
					urlPagina = VisualizarBannerUtils.getParseValue("enlaceSolicitud", articulo,themeDisplay.getLanguageId());
					if (isWS) {
						String[] urls = StringUtil.split(SolicitudProductoLocalServiceUtil.getURLSolicitudByEtiquetaContenido(urlPagina),"/");
						urlPagina = "/"+urls[1]+PropsUtil.get("SOLICITUDES.URL.PREFIX.SOLICITUD_PREAPROBADA")+"/"+urls[3];
					}else{
						urlPagina=SolicitudProductoLocalServiceUtil.getURLSolicitudByEtiquetaContenido(urlPagina);
					}
				}else{
					
					String urlPaginaProducto = VisualizarBannerUtils.getParseValue("enlacePagina", articulo,
							themeDisplay.getLanguageId());
					
					if(Validator.isNotNull(urlPaginaProducto)){
						try {
							Layout pAsoc = LayoutLocalServiceUtil.getLayout(groupId, false,
									Long.valueOf(urlPaginaProducto.replaceAll("@public", "")));
							
							urlPagina=pAsoc.getFriendlyURL();
						} catch (Exception e) {
							_log.warn("Revisar el Link al producto:"+e.toString());
						}
					}
				}

				if(Validator.isNotNull(urlSEO) && !urlPagina.equalsIgnoreCase("#")){
					renderRequest.setAttribute("urlString", "?"+urlSEO);
				}
				
				renderRequest.setAttribute("codigoPromocion", codigoPromocion);
				renderRequest.setAttribute("archivo", archivo);
				renderRequest.setAttribute("urlPagina", urlPagina);
				renderRequest.setAttribute("altImagen", altImagen);
				renderRequest.setAttribute("extension", extension);
				
			}
			//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);

			
		} catch (Exception e) {
			_log.error("Error al mostrar los banners promocionales:"+e.toString());
		}
		if (tipo.equals("L")) {
			return "lateral";
		} else {
			return "central";
		}

	}

}
