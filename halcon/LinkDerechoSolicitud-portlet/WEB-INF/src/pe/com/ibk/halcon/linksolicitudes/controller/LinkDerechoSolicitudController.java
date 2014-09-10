package pe.com.ibk.halcon.linksolicitudes.controller;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exp.portlet.halcon.utils.TextoUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class LinkDerechoSolicitudController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Controller  
@RequestMapping("VIEW")  
public class LinkDerechoSolicitudController {  
	
	/** The nombre_producto. */
	private static String nombre_producto = "";
	
	private static Log _log = LogFactoryUtil.getLog(LinkDerechoSolicitudController.class);
	/**
	 * Instancia un nuevo link derecho solicitud controller.
	 */
	public LinkDerechoSolicitudController() {  
    }  
  

    /**
     * Default view.
     * Fecha: 22/08/2013
     *
     * @param renderRequest the render request
     * @param renderResponse the render response
     * @return the string
     */
    @RequestMapping  
    protected String defaultView( RenderRequest renderRequest, RenderResponse renderResponse) {  
    	  String mensaje1 = "";
    	  String mensaje2 = "";
    	  String url1 = "";
    	  String url2 = "";
    	  String urlProducto="";
    	HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
    	
    	nombre_producto = HtmlUtil.escape(HtmlUtil.extractText(ParamUtil.getString(httpReq, "sol"))) ;		
		
		Integer indicadorProducto = devolver(nombre_producto);
		
		String dominio = renderRequest.getScheme() + "://" + renderRequest.getServerName() + ":" + renderRequest.getServerPort();
		
		switch (indicadorProducto) {
		case 1:
			mensaje1=PortletProps.get("link.texto.vehicular");
			url1=dominio + PortletProps.get("link.pagina.vehicular");
			break;

		case 2:
			mensaje1=PortletProps.get("link.texto.hipotecario");
			url1=dominio + PortletProps.get("link.pagina.hipotecario");
			break;
			
		case 3:
			mensaje1=PortletProps.get("link.texto.fondos");
			url1=dominio + PortletProps.get("link.pagina.fondos");
			break;
			
		case 4:
			mensaje1=PortletProps.get("link.texto.prestamo1");
			url1=dominio + PortletProps.get("link.pagina.prestamo1");
			
			mensaje2=PortletProps.get("link.texto.prestamo2");
			url2=dominio + PortletProps.get("link.pagina.prestamo2");
			break;
			
		case 5:
			mensaje1=PortletProps.get("link.texto.tarjeta");
			url1=dominio + PortletProps.get("link.pagina.tarjeta");
			break;
			
		case 6:
			mensaje1=PortletProps.get("link.texto.sueldo");
			url1=dominio + PortletProps.get("link.pagina.sueldo");
			break;
			
		case 7:
			mensaje1=PortletProps.get("link.texto.soat");
			url1=dominio + PortletProps.get("link.pagina.soat");
			break;

		default:
			urlProducto=ParamUtil.getString(httpReq, "pro");
			String adicional="";
			adicional=urlProducto.replaceAll("-", " ");
			adicional=TextoUtil.primerasMayuscula(adicional);
			mensaje1=adicional;
			url1=dominio;

			if(urlProducto.matches("(.*)tarjeta(.*)")){
				mensaje1=PortletProps.get("link.texto.tarjeta");
				url1=dominio + PortletProps.get("link.pagina.tarjeta");
			}else
				if(urlProducto.matches("(.*)vehicular(.*)") || urlProducto.matches("(.*)auto(.*)") || urlProducto.matches("(.*)inteligente(.*)")){
					mensaje1=PortletProps.get("link.texto.vehicular");
					url1=dominio + PortletProps.get("link.pagina.vehicular");
				}else
					if(urlProducto.matches("(.*)hipotecario(.*)") || urlProducto.matches("(.*)techo(.*)") || urlProducto.matches("(.*)mivivienda(.*)") || urlProducto.matches("(.*)garantioa(.*)")){
						mensaje1=PortletProps.get("link.texto.hipotecario");
						url1=dominio + PortletProps.get("link.pagina.hipotecario");
					}else
						if(urlProducto.matches("(.*)fondos(.*)")){
							mensaje1=PortletProps.get("link.texto.fondos");
							url1=dominio + PortletProps.get("link.pagina.fondos");
						}else
							if(urlProducto.matches("(.*)sueldo(.*)")){
								mensaje1=PortletProps.get("link.texto.sueldo");
								url1=dominio + PortletProps.get("link.pagina.sueldo");
							}else
								if(urlProducto.matches("(.*)soat(.*)")){
								mensaje1=PortletProps.get("link.texto.soat");
								url1=dominio + PortletProps.get("link.pagina.soat");
								}else
									if(urlProducto.matches("(.*)prestamo(.*)")){
										mensaje1=PortletProps.get("link.texto.prestamo1");
										url1=dominio + PortletProps.get("link.pagina.prestamo1");
											}else
												if(urlProducto.matches("(.*)convenio(.*)")){
												url1=dominio + PortletProps.get("link.pagina.convenio");
												}			
			

			break;
		}
//		_log.info("_______________________________");
//		_log.info(mensaje1);
//		_log.info(url1);
//		_log.info(urlProducto);
//		_log.info("_______________________________");
		
		renderRequest.setAttribute("mensaje1", mensaje1);
		renderRequest.setAttribute("url1", url1);
		
		renderRequest.setAttribute("mensaje2", mensaje2);
		renderRequest.setAttribute("url2", url2);

        return "view";  
    }
        
    
    /**
     * Devolver.
     * Fecha: 22/08/2013
     *
     * @param nombre_producto the nombre_producto
     * @return the integer
     */
    public Integer devolver(String nombre_producto){
		Integer indicador=0;
		
    	if(nombre_producto.equals("solicitud-vehicular")){
    								indicador=1;
    	}else if(nombre_producto.equals("solicitud-hipotecaria")){
    								indicador=2;
    	}else if(nombre_producto.equals("solicitud-fondos-mutuos")){
    								indicador=3;
    	}else if(nombre_producto.equals("solicitud-prestamo")){
    								indicador=4;
    	}else if(nombre_producto.equals("solicitud-tarjeta")){
    								indicador=5;
    	}else if(nombre_producto.equals("solicitud-cuenta-sueldo")){
    								indicador=6;
    	}else if(nombre_producto.equals("solicitud-soat")){
    								indicador=7;
    	}else if(nombre_producto.equals("solicitud-preaprobada")){
    								indicador=8;
    	}
    	
    	return indicador;
    }
  
}
