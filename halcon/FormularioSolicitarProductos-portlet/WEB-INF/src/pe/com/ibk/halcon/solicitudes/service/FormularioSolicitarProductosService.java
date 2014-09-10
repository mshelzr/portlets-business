package pe.com.ibk.halcon.solicitudes.service;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;

import org.springframework.ui.Model;

import com.ext.portlet.halcon.dto.ProductoComplementarioBean;
import com.ext.portlet.halcon.dto.SolicitudProductoBean;
import com.ext.portlet.halcon.dto.SolicitudProductoResponseBean;
import com.ext.portlet.halcon.exception.BusinessException;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Interface FormularioSolicitarProductosService.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public interface FormularioSolicitarProductosService {

	/**
	 * Registrar solicitud.
	 * Fecha: 22/08/2013
	 *
	 * @param productoBean the producto bean
	 * @return the integer
	 */
	Integer registrarSolicitud(SolicitudProductoBean productoBean);
	
	/**
	 * Enviar correo.
	 * Fecha: 22/08/2013
	 *
	 * @param solicitud the solicitud
	 * @param resourceRequest the resource request
	 * @return the int
	 */
	int enviarCorreo(SolicitudProductoBean solicitud, ResourceRequest resourceRequest);

	/**
	 * Traer bean simulador.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 * @param solicitud the solicitud
	 */
	void traerBeanSimulador(RenderRequest renderRequest, SolicitudProductoBean solicitud);
	
	/**
	 * Enviar correo interbank.
	 * Fecha: 22/08/2013
	 *
	 * @param solicitud the solicitud
	 * @param resourceRequest the resource request
	 * @return the int
	 */
	int enviarCorreoInterbank(SolicitudProductoBean solicitud, ResourceRequest resourceRequest);
	
	/**
	 * Registro leads.
	 * Fecha: 22/08/2013
	 *
	 * @param productoBean the producto bean
	 * @return the solicitud producto response bean
	 * @throws BusinessException the business exception
	 */
	SolicitudProductoResponseBean registroLeads(SolicitudProductoBean productoBean) throws BusinessException;
	
	/**
	 * Precalificacion.
	 * Fecha: 22/08/2013
	 *
	 * @param productoBean the producto bean
	 * @return the solicitud producto response bean
	 * @throws BusinessException the business exception
	 */
	SolicitudProductoResponseBean precalificacion(SolicitudProductoBean productoBean) throws BusinessException;

	/**
	 * Validar gestion peticion.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 * @param ip the ip
	 * @param codigoProducto the codigo producto
	 * @param etiqueta the etiqueta
	 * @return the boolean
	 */
	Boolean validarGestionPeticion(ResourceRequest renderRequest, String ip, String codigoProducto,String etiqueta);
	
	/**
	 * Registrar gestion peticion.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 * @param ip the ip
	 * @param codigoProducto the codigo producto
	 * @param etiqueta the etiqueta
	 * @return the boolean
	 */
	Boolean registrarGestionPeticion(ResourceRequest renderRequest, String ip, String codigoProducto,String etiqueta);

	/**
	 * Comprobar precalificacion.
	 * Fecha: 22/08/2013
	 *
	 * @param solicitud the solicitud
	 * @param resourceRequest the resource request
	 * @param codigoProducto the codigo producto
	 * @param etiqueta the etiqueta
	 * @return the integer
	 */
	Integer comprobarPrecalificacion(SolicitudProductoBean solicitud,ResourceRequest resourceRequest,String codigoProducto,String etiqueta);

	/**
	 * Listar complementario.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 * @param model the model
	 * @param solicitud the solicitud
	 * @param productoPrincipal the producto principal
	 */
	void listarComplementario(RenderRequest renderRequest, Model model, SolicitudProductoBean solicitud,ProductoComplementarioBean productoPrincipal);
	
	/**
	 * Guardar informacion.
	 * Fecha: 22/08/2013
	 *
	 * @param solicitud the solicitud
	 * @param resourceRequest the resource request
	 * @param registrarSolicitud the registrar solicitud
	 * @param codigoProducto the codigo producto
	 * @param etiqueta the etiqueta
	 * @return the integer
	 */
	Integer guardarInformacion(SolicitudProductoBean solicitud, ResourceRequest resourceRequest,boolean registrarSolicitud,String codigoProducto,String etiqueta);	

	int mapearEstadoADQ(int codigoBus);

}
