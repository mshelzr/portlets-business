package pe.com.ibk.halcon.home.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.ibk.halcon.home.bean.CabeceraBean;
import pe.com.ibk.halcon.home.bean.NietoBean;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.webserver.WebServerServletTokenUtil;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class Destacado por nivel.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */

@Controller
@RequestMapping("VIEW")
public class DestacadosPorNivel2Controller {
	
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(DestacadosPorNivel2Controller.class);
	//private static Integer indicadorPortlet=18;
	//private static Integer indicadorController=1;
	
	/**
	 * Default view, metodo que carga inicial com
	 * Fecha: 18/02/2013
	 *
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest, RenderResponse renderResponse) {

		Map<CabeceraBean, List> mapaHijos = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int limiteNivel2 = 0;// Solo 5
		Layout padre = null;
		try {
			Layout paginaActual = themeDisplay.getLayout();
			if (paginaActual.getAncestors() != null && !paginaActual.getAncestors().isEmpty()) {
				for (Layout page : paginaActual.getAncestors()) {
					/* Verificamos qie tenga como padre 0 */
					if (page.getParentLayoutId() == 0) {
						padre = page;
						break;
					}
				}
			} 
			else{
				if (paginaActual.getParentLayoutId() == 0) {
					padre = paginaActual;
				}
			}

			// Obtener padre: PERSONAS,EMPRESAS,ETC
			if (padre != null) {
				_log.info("NIVEL 1: " + padre.getName(themeDisplay.getLocale()));
				/* Lee los padres: 1er nivel */
				if (padre.getChildren() != null) {
					for (Layout hijo : padre.getChildren()) {
						/* 2do Nivel */
						boolean mostrar = false;// No se muestra
						List<NietoBean> nietos = null;
						if (!hijo.isHidden() && !hijo.isPrivateLayout()) {
							if (limiteNivel2 > 3) {
								break;
							}
							if (hijo.getChildren() != null) {
								for (Layout nieto : hijo.getChildren()) {
									/* 3er nivel */
									if (!nieto.isHidden() && !nieto.isPrivateLayout()) {						
											/* Verificare si esta activo o no */
											String activo[] = ((String[]) (nieto.getExpandoBridge().getAttribute("esDestacadoNivel")));
											// muestra true si esta activo
											if (Validator.isNotNull(activo) && activo.length > 0) {
												if (activo[0].equalsIgnoreCase("SI")) {
													/* Asigna a la lista */
													NietoBean activeNieto = new NietoBean();
													// activeNieto.setTitulo(nieto.getName(themeDisplay.getLocale()));
													Integer orden =(Integer)nieto.getExpandoBridge().getAttribute("orden");
													activeNieto.setTitulo(nieto.getName(themeDisplay.getLocale()));
													activeNieto.setUrl(nieto.getFriendlyURL());
													activeNieto.setOrden(orden);
													
												if (nietos == null)
													nietos = new ArrayList<NietoBean>();
													nietos.add(activeNieto);
													mostrar = true;
												}
										   }
									}
									/* Nos vamos al 4to.. Nivel */
									for (Layout bisnieto : nieto.getChildren()) {
											if (!bisnieto.isHidden() && !bisnieto.isPrivateLayout()) {
												/* Verifica si esta activo o NO */
												String activo[] = ((String[]) (bisnieto.getExpandoBridge().getAttribute("esDestacadoNivel")));
												/* Muestra true si esta activo */
												if (Validator.isNotNull(activo) && activo.length > 0) {
													if (activo[0].equalsIgnoreCase("SI")) {
														/* Asigno a mi lista */
														NietoBean activeNieto = new NietoBean();
														// activeNieto.setTitulo(bisnieto.getName(themeDisplay.getLocale()));
														Integer orden =(Integer)bisnieto.getExpandoBridge().getAttribute("orden");
														activeNieto.setTitulo(bisnieto.getName(themeDisplay.getLocale()));
														activeNieto.setUrl(bisnieto.getFriendlyURL());
														activeNieto.setOrden(orden);
													if (nietos == null)
														nietos = new ArrayList<NietoBean>();
														nietos.add(activeNieto);
														mostrar = true;
														}
													}
												}
											}	
									  }
								}
						}
						if (mostrar) {
							/* Asigno que se pinte la cabecera */
							if (mapaHijos == null)
								mapaHijos = new LinkedHashMap<CabeceraBean, List>();
								CabeceraBean header = new CabeceraBean();
								header.setTitulo(hijo.getName(themeDisplay.getLocale()));
								header.setUrlImagen(themeDisplay.getPathImage()	+ "/layout_icon?img_id=" + hijo.getIconImageId() + "&t=" + WebServerServletTokenUtil.getToken(hijo.getIconImageId()));
								
							if (limiteNivel2 > 3) {
								break;
							}
							
							//Ordenar
							Comparator<NietoBean> c = new Comparator<NietoBean>(){
								        @Override
								        public int compare( NietoBean o1, NietoBean o2 ){
								        	Integer ordeno1=(Integer)o1.getOrden();
								        	Integer ordeno2=(Integer)o2.getOrden();
								        	//0= Son iguales     -1: o1 <o2     1: o1>o2
								        	//Para hacer que si no tiene orden vaya al ultimo
								           if(ordeno1==0)ordeno1=9999;
								           if(ordeno2==0)ordeno2=9999;
								           if(ordeno1<ordeno2) 
								        	   return -1;
								           else 
								           if (ordeno1>ordeno2) 
								        	   return 1;
								           else return 0;
								        }
								    };	    
							ListUtil.sort(nietos, c);
							mapaHijos.put(header, nietos);
							limiteNivel2++;
						}
					}
				}
			}
			/* Enviar al Request el mapa */
			renderRequest.setAttribute("mapa", mapaHijos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "view";
	}
}
