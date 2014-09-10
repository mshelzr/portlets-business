package pe.com.ibk.halcon.gestionparametros.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;

import pe.com.ibk.halcon.gestionparametros.bean.BeanEditarParametro;
import pe.com.ibk.halcon.gestionparametros.bean.BeanListarParametro;
import pe.com.ibk.halcon.gestionparametros.bean.BeanNuevoRango;
import pe.com.ibk.halcon.gestionparametros.bean.soporte.Soporte;
import pe.com.ibk.halcon.gestionparametros.service.ParametroEditarService;
import pe.com.ibk.halcon.gestionparametros.service.ParametroListarService;
import pe.com.ibk.halcon.gestionparametros.service.ParametroService;

import com.exp.portlet.halcon.utils.AuditoriaHalconUtil;
import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.LogErrorUtil;
import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class ParametrosController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */

@Controller
@RequestMapping("VIEW")
public class ParametrosController {
	
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(ParametrosController.class);
	
	/** The parametro listar service impl. */
	@Autowired
	private ParametroListarService parametroListarServiceImpl;
	
	/** The parametro editar service impl. */
	@Autowired
	private ParametroEditarService parametroEditarServiceImpl;
	
	/** The parametro service impl. */
	@Autowired
	private ParametroService parametroServiceImpl;

//	@PostConstruct
//	public void inicio(){
//		_log.info("****************Inicio 001************");
//	}
//	
	/**
 * Instancia un nuevo parametros controller.
 */
public ParametrosController() {
		mensaje = new String();
	}
	
	/** The mensaje. */
	private String mensaje;
	
	/** The estado. */
	private String estado;
	
	private boolean cambiarEstado = false;
	
	/**
	 * Limpiar mensaje.
	 * Fecha: 22/08/2013
	 */
	private void limpiarMensaje() {
		this.mensaje = "";
		this.estado = "";
	}
	
	//private static RenderRequest ren1;
	
	/**
	 * Default view.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 * @throws Exception the exception
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		
		if(!cambiarEstado){
			limpiarMensaje();
		}
		cambiarEstado = false;
		renderRequest.setAttribute("mensaje", mensaje);
		renderRequest.setAttribute("estado", estado);
		renderRequest.setAttribute("beanListarParametro", parametroListarServiceImpl.getBeanListarParametro());		
		parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().setNuevoRango(false);
		
		renderRequest.setAttribute("estado", estado);
		renderRequest.setAttribute("beanListarParametro", parametroListarServiceImpl.getBeanListarParametro());
		
		JSonUtil.getPath(renderRequest);

		/***INICIO AUDITORIA***/
		//ESTE METODO DEBER SER UTILIZADO EN LA CAPA CONTROLLER
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null, PortalUtil.getHttpServletRequest(renderRequest));
		//ESTE METODO DEBE SER UTILIZADO EN LA CAPA MODELO/SERVICIO
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null);
		/***FIN AUDITORIA***/
		
		return "listarParametro";
	}
	
	/**
	 * Editar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @param id the id
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping(params = "action=editarParametro")
	protected String editarParametro(@RequestParam(value = "id", required = false) String id, RenderRequest renderRequest, RenderResponse renderResponse) {
		renderRequest.setAttribute("mensaje", mensaje);
		renderRequest.setAttribute("estado", estado);
		renderRequest.setAttribute("beanEditarParametro", parametroEditarServiceImpl.getBeanEditarParametro());
		/***INICIO AUDITORIA***/
		//ESTE METODO DEBER SER UTILIZADO EN LA CAPA CONTROLLER
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null, PortalUtil.getHttpServletRequest(renderRequest));
		//ESTE METODO DEBE SER UTILIZADO EN LA CAPA MODELO/SERVICIO
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null);
		/***FIN AUDITORIA***/
		
		return "editarParametro";
	}
	
	/**
	 * Response action generar ubigeo.
	 * Fecha: 22/08/2013
	 *
	 * @param request the request
	 * @param response the response
	 * @throws BusinessException the business exception
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "actionGenerarUbigeo")
	protected void responseActionGenerarUbigeo(ActionRequest request, ActionResponse response) throws BusinessException, Exception {
		limpiarMensaje();
		try {
			parametroServiceImpl.ubigeo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/***INICIO AUDITORIA***/
		//ESTE METODO DEBER SER UTILIZADO EN LA CAPA CONTROLLER
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null, PortalUtil.getHttpServletRequest(request));
		//ESTE METODO DEBE SER UTILIZADO EN LA CAPA MODELO/SERVICIO
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null);
		/***FIN AUDITORIA***/
	}
	
	/**
	 * Response action sincronizar json.
	 * Fecha: 22/08/2013
	 *
	 * @param request the request
	 * @param response the response
	 * @throws BusinessException the business exception
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "actionSincronizarJson")
	protected void responseActionSincronizarJson(ActionRequest request, ActionResponse response) throws BusinessException, Exception {
		limpiarMensaje();
		_log.info("******** responseActionSincronizarJson *********");
		try {
			parametroServiceImpl.generarJSonMasivo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/***INICIO AUDITORIA***/
		//ESTE METODO DEBER SER UTILIZADO EN LA CAPA CONTROLLER
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null, PortalUtil.getHttpServletRequest(request));
		//ESTE METODO DEBE SER UTILIZADO EN LA CAPA MODELO/SERVICIO
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null);
		/***FIN AUDITORIA***/
	}
	
	/**
	 * Response action listar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @param beanListarParametro the bean listar parametro
	 * @param request the request
	 * @param response the response
	 * @throws BusinessException the business exception
	 * @throws Exception the exception
	 */
	@ActionMapping(value="actionListarParametro")
	protected void responseActionListarParametro(@ModelAttribute("beanListarParametro") BeanListarParametro beanListarParametro, ActionRequest request, ActionResponse response) throws BusinessException, Exception {
		limpiarMensaje();
		try {
			parametroListarServiceImpl.setBeanListarParametro(beanListarParametro);
			parametroListarServiceImpl.listarParametros("");
		} catch (BusinessException e) {
			estado = "error";
			mensaje = e.getMessage();
			String asunto = Propiedades.getResourceBundle("gestion.parametros.parametro.controller.response.action.listar.parametro");
//			LogErrorUtil.registrarError(JSonUtil.getStringJson(beanListarParametro), e.getTrazaMessage(), asunto);
			_log.error(asunto+e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/***INICIO AUDITORIA***/
		//ESTE METODO DEBER SER UTILIZADO EN LA CAPA CONTROLLER
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null, PortalUtil.getHttpServletRequest(request));
		//ESTE METODO DEBE SER UTILIZADO EN LA CAPA MODELO/SERVICIO
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null);
		/***FIN AUDITORIA***/
	}

	/**
	 * Response action desactivar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @param id the id
	 * @param page the page
	 * @param beanListarParametro the bean listar parametro
	 * @param request the request
	 * @param response the response
	 * @throws BusinessException the business exception
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "actionDesactivarParametro")
	protected void responseActionDesactivarParametro(@RequestParam(value = "id", required = true) String id, @RequestParam(value = "page", required = true) String page, @ModelAttribute("beanListarParametro") BeanListarParametro beanListarParametro, ActionRequest request, ActionResponse response) throws BusinessException, Exception {
		limpiarMensaje();
		try {
			parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().setParametro(parametroListarServiceImpl.getBeanListarParametro().getSoporteListarParametro().obtenerParametro(Integer.valueOf(id)));
			parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().setParametroPadre(parametroEditarServiceImpl.getBeanEditarParametro().getSoporteEditarParametro().obtenerParametro(parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().getParametro().getIdParametroPadre()));
			if (page.equals("editarParametro")) {
				parametroEditarServiceImpl.getBeanEditarParametro().desactivarParametro(id);
				response.setRenderParameter("id", id);
				response.setRenderParameter("action", "editarParametro");
				estado = "success";
				mensaje = Soporte.obtenerResourceBundle().getString("parametro.editar.save.desactivar");
			} else {
				cambiarEstado = true;
				parametroListarServiceImpl.getBeanListarParametro().desactivarParametro(id);
				parametroEditarServiceImpl.getBeanEditarParametro().desactivarParametro(id);
				estado = "success";
				mensaje = Soporte.obtenerResourceBundle().getString("parametro.listar.save.desactivar");
			}
			parametroEditarServiceImpl.guardarParametro();
			parametroServiceImpl.generarArchivo(Integer.valueOf(id));
		} catch (BusinessException e) {
			estado = "error";
			mensaje = e.getMessage();
			String asunto = Propiedades.getResourceBundle("gestion.parametros.parametro.controller.response.action.desactivar.parametro");
			LogErrorUtil.registrarError(String.format("[{id:%s,page:%s,%s}]", id,page,JSonUtil.getStringJson(beanListarParametro)) , e.getTrazaMessage(), asunto);
			_log.error(asunto+e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/***INICIO AUDITORIA***/
		//ESTE METODO DEBER SER UTILIZADO EN LA CAPA CONTROLLER
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null, PortalUtil.getHttpServletRequest(request));
		//ESTE METODO DEBE SER UTILIZADO EN LA CAPA MODELO/SERVICIO
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null);
		/***FIN AUDITORIA***/
	}
	
	/**
	 * Response action activar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @param id the id
	 * @param page the page
	 * @param beanListarParametro the bean listar parametro
	 * @param request the request
	 * @param response the response
	 * @throws BusinessException the business exception
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "actionActivarParametro")
	protected void responseActionActivarParametro(@RequestParam(value = "id", required = true) String id, @RequestParam(value = "page", required = true) String page, @ModelAttribute("beanListarParametro") BeanListarParametro beanListarParametro, ActionRequest request, ActionResponse response) throws BusinessException, Exception {
		limpiarMensaje();
		try {
			parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().setParametro(parametroListarServiceImpl.getBeanListarParametro().getSoporteListarParametro().obtenerParametro(Integer.valueOf(id)));
			parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().setParametroPadre(parametroEditarServiceImpl.getBeanEditarParametro().getSoporteEditarParametro().obtenerParametro(parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().getParametro().getIdParametroPadre()));
			if (page.equals("editarParametro")) {
				parametroEditarServiceImpl.getBeanEditarParametro().activarParametro(id);
				response.setRenderParameter("id", id);
				response.setRenderParameter("action", "editarParametro");
				estado = "success";
				mensaje = Soporte.obtenerResourceBundle().getString("parametro.editar.save.activar");
			} else {
				cambiarEstado = true;
				parametroListarServiceImpl.getBeanListarParametro().activarParametro(id);
				parametroEditarServiceImpl.getBeanEditarParametro().activarParametro(id);
				estado = "success";
				mensaje = Soporte.obtenerResourceBundle().getString("parametro.listar.save.activar");
			}
			parametroEditarServiceImpl.guardarParametro();
			parametroServiceImpl.generarArchivo(Integer.valueOf(id));
			
		} catch (BusinessException e) {
			estado = "error";
			mensaje = e.getMessage();
			String asunto = Propiedades.getResourceBundle("gestion.parametros.parametro.controller.response.action.activar.parametro");
			LogErrorUtil.registrarError(String.format("[{id:%s,page:%s,%s}]", id,page,JSonUtil.getStringJson(beanListarParametro)) , e.getTrazaMessage(), asunto);
			_log.error(asunto+e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/***INICIO AUDITORIA***/
		//ESTE METODO DEBER SER UTILIZADO EN LA CAPA CONTROLLER
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null, PortalUtil.getHttpServletRequest(request));
		//ESTE METODO DEBE SER UTILIZADO EN LA CAPA MODELO/SERVICIO
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null);
		/***FIN AUDITORIA***/
	}
	
	/**
	 * Response action editar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @param id the id
	 * @param page the page
	 * @param beanEditarParametro the bean editar parametro
	 * @param request the request
	 * @param response the response
	 * @throws BusinessException the business exception
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "actionEditarParametro")
	protected void responseActionEditarParametro(@RequestParam(value = "id", required = true) String id, @RequestParam(value = "page", required = true) String page, @ModelAttribute("beanEditarParametro") BeanEditarParametro beanEditarParametro, ActionRequest request, ActionResponse response) throws BusinessException, Exception {
		limpiarMensaje();
		try {
			if (page.equals("listarParametro")) {
				
				parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().setParametro(parametroListarServiceImpl.getBeanListarParametro().getSoporteListarParametro().obtenerParametro(Integer.valueOf(id)));
				parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().setParametroPadre(parametroEditarServiceImpl.getBeanEditarParametro().getSoporteEditarParametro().obtenerParametro(parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().getParametro().getIdParametroPadre()));
				parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().setValorTipo(parametroListarServiceImpl.getBeanListarParametro().getCriterioListarParametro().getValorTipo());
				parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().setLabelFormParametros(parametroEditarServiceImpl.getBeanEditarParametro().getSoporteEditarParametro().obtenerEtiquetasParametros(parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().getParametro().getIdParametroPadre()));
				parametroEditarServiceImpl.listarParametros("");
				response.setRenderParameter("id", id);
				response.setRenderParameter("action", "editarParametro");
			} else {
				parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().setParametro(parametroEditarServiceImpl.getBeanEditarParametro().obtenerParametroLista(id));
				parametroEditarServiceImpl.listarParametros("");
				response.setRenderParameter("id", id);
				response.setRenderParameter("action", "editarParametro");
			}
		} catch (BusinessException e) {
			estado = "error";
			mensaje = e.getMessage();
			String asunto = Propiedades.getResourceBundle("gestion.parametros.parametro.controller.response.action.editar.parametro");
			LogErrorUtil.registrarError(String.format("[{id:%s,page:%s,%s}]", id,page,JSonUtil.getStringJson(beanEditarParametro)) , e.getTrazaMessage(), asunto);
			_log.error(asunto+e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/***INICIO AUDITORIA***/
		//ESTE METODO DEBER SER UTILIZADO EN LA CAPA CONTROLLER
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null, PortalUtil.getHttpServletRequest(request));
		//ESTE METODO DEBE SER UTILIZADO EN LA CAPA MODELO/SERVICIO
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null);
		/***FIN AUDITORIA***/
	}
	
	/**
	 * Response action nuevo parametro.
	 * Fecha: 22/08/2013
	 *
	 * @param id the id
	 * @param page the page
	 * @param beanEditarParametro the bean editar parametro
	 * @param request the request
	 * @param response the response
	 * @throws BusinessException the business exception
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "actionNuevoParametro")
	protected void responseActionNuevoParametro(@RequestParam(value = "id", required = true) String id, @RequestParam(value = "page", required = true) String page, @ModelAttribute("beanEditarParametro") BeanEditarParametro beanEditarParametro, ActionRequest request, ActionResponse response) throws BusinessException, Exception {
		limpiarMensaje();
		try {
			if (page.equals("nuevoParametro")) {
				parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().iniciar();
				parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().setParametroPadre(parametroEditarServiceImpl.getBeanEditarParametro().getSoporteEditarParametro().obtenerParametro(Integer.valueOf(id)));
				parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().getParametro().setIdParametroPadre(Integer.valueOf(id));
				parametroEditarServiceImpl.mostrarFormularioEditarParametro();
				response.setRenderParameter("id", id);
				response.setRenderParameter("action", "editarParametro");
			} else if(page.equals("nuevoRangoSiebel")) {
				parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().iniciar();
				parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().setNuevoRango(true);
				parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().setParametroPadre(parametroEditarServiceImpl.getBeanEditarParametro().getSoporteEditarParametro().obtenerParametro(Integer.valueOf(id)));
				parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().getParametro().setIdParametroPadre(Integer.valueOf(id));
				parametroEditarServiceImpl.mostrarFormularioEditarParametro();
				response.setRenderParameter("id", id);
				response.setRenderParameter("action", "editarParametro");
			}
		} catch (BusinessException e) {
			estado = "error";
			mensaje = e.getMessage();
			String asunto = Propiedades.getResourceBundle("gestion.parametros.parametro.controller.response.action.nuevo.parametro");
			LogErrorUtil.registrarError(String.format("[{id:%s,page:%s,%s}]", id,page,JSonUtil.getStringJson(beanEditarParametro)) , e.getTrazaMessage(), asunto);
			_log.error(asunto+e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/***INICIO AUDITORIA***/
		//ESTE METODO DEBER SER UTILIZADO EN LA CAPA CONTROLLER
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null, PortalUtil.getHttpServletRequest(request));
		//ESTE METODO DEBE SER UTILIZADO EN LA CAPA MODELO/SERVICIO
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null);
		/***FIN AUDITORIA***/
	}
	
	
	/**
	 * Response action guardar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @param id the id
	 * @param beanEditarParametro the bean editar parametro
	 * @param request the request
	 * @param response the response
	 * @throws BusinessException the business exception
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "actionGuardarParametro")
	protected void responseActionGuardarParametro(@RequestParam(value = "id", required = false) String id, @ModelAttribute("beanEditarParametro") BeanEditarParametro beanEditarParametro, ActionRequest request, ActionResponse response) throws BusinessException, Exception {
		limpiarMensaje();
		try {
			if(beanEditarParametro.getCriterioEditarParametro().isNuevoRango()){
				// Si se ingresaron los valores obligatorios
				Integer error = beanEditarParametro.getCriterioEditarParametro().validarNuevoRango();
				if(error == 0){
					Integer idRango = parametroServiceImpl.guardarNuevoRangoSiebel(beanEditarParametro.getCriterioEditarParametro().getBeanNuevoRango());
					if(idRango == 0){
						estado = "error";
						mensaje = Soporte.obtenerResourceBundle().getString("parametro.editar.etiqueta.siebel.error");
					} else {
						parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().setBeanNuevoRango(new BeanNuevoRango());
						beanEditarParametro.getCriterioEditarParametro().setNuevoRango(false);
						estado = "success";
						mensaje = Soporte.obtenerResourceBundle().getString("parametro.editar.save.success");
					}
				} else {
					estado = "error";
					if(error == 1){
						mensaje = Soporte.obtenerResourceBundle().getString("parametro.editar.etiqueta.siebel.obligatorio");
					} else if(error == 2){
						mensaje = Soporte.obtenerResourceBundle().getString("parametro.editar.nombre.producto.siebel.obligatorio");
					} else if(error == 3){
						mensaje = Soporte.obtenerResourceBundle().getString("parametro.editar.codigo.siebel.obligatorio");
					}
				
				}
			
			} else {
			parametroEditarServiceImpl.guardarParametro();
			response.setRenderParameter("action", "editarParametro");	
			//Codigo Adicional
			Integer idParametro= parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().
					getParametro().getIdParametro();
			parametroServiceImpl.generarArchivo(idParametro);
			
			estado = "success";
			mensaje = Soporte.obtenerResourceBundle().getString("parametro.editar.save.success");
			}
			
		} catch (BusinessException e) {
			estado = "error";
			mensaje = e.getMessage();
			String asunto = Propiedades.getResourceBundle("gestion.parametros.parametro.controller.response.action.guardar.parametro");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setRenderParameter("action", "editarParametro");
		
		/***INICIO AUDITORIA***/
		//ESTE METODO DEBER SER UTILIZADO EN LA CAPA CONTROLLER
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null, PortalUtil.getHttpServletRequest(request));
		//ESTE METODO DEBE SER UTILIZADO EN LA CAPA MODELO/SERVICIO
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null);
		/***FIN AUDITORIA***/
	}
	
	/**
	 * Response action limpiar lista parametro.
	 * Fecha: 22/08/2013
	 *
	 * @param beanListarParametro the bean listar parametro
	 * @param request the request
	 * @param response the response
	 * @throws BusinessException the business exception
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "actionLimpiarListaParametro")
	protected void responseActionLimpiarListaParametro(@ModelAttribute("beanListarParametro") BeanListarParametro beanListarParametro, ActionRequest request, ActionResponse response) throws BusinessException, Exception {
		limpiarMensaje();
		try {
			parametroListarServiceImpl.limpiarListaParametro();
		} catch (BusinessException e) {
			estado = "error";
			mensaje = e.getMessage();
			String asunto = Propiedades.getResourceBundle("gestion.parametros.parametro.controller.response.action.limpiar.lista.parametro");
			LogErrorUtil.registrarError(JSonUtil.getStringJson(beanListarParametro) , e.getTrazaMessage(), asunto);
			_log.error(asunto+e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/***INICIO AUDITORIA***/
		//ESTE METODO DEBER SER UTILIZADO EN LA CAPA CONTROLLER
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null, PortalUtil.getHttpServletRequest(request));
		//ESTE METODO DEBE SER UTILIZADO EN LA CAPA MODELO/SERVICIO
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null);
		/***FIN AUDITORIA***/
	}
		
	/**
	 * Response action limpiar editar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @param beanListarParametro the bean listar parametro
	 * @param request the request
	 * @param response the response
	 * @throws BusinessException the business exception
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "actionLimpiarEditarParametro")
	protected void responseActionLimpiarEditarParametro(@ModelAttribute("beanListarParametro") BeanListarParametro beanListarParametro, ActionRequest request, ActionResponse response) throws BusinessException, Exception {
		limpiarMensaje();
		try {
			parametroEditarServiceImpl.limpiarListaParametro();
			response.setRenderParameter("id", "0");
			response.setRenderParameter("action", "editarParametro");
		} catch (BusinessException e) {
			estado = "error";
			mensaje = e.getMessage();
			String asunto = Propiedades.getResourceBundle("gestion.parametros.parametro.controller.response.action.limpiar.editar.parametro");
			LogErrorUtil.registrarError(JSonUtil.getStringJson(beanListarParametro) , e.getTrazaMessage(), asunto);
			_log.error(asunto+e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setRenderParameter("id", "0");
		response.setRenderParameter("action", "editarParametro");
		
		/***INICIO AUDITORIA***/
		//ESTE METODO DEBER SER UTILIZADO EN LA CAPA CONTROLLER
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null, PortalUtil.getHttpServletRequest(request));
		//ESTE METODO DEBE SER UTILIZADO EN LA CAPA MODELO/SERVICIO
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null);
		/***FIN AUDITORIA***/
	}
	
	/**
	 * Response action cancelar editar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @param beanListarParametro the bean listar parametro
	 * @param request the request
	 * @param response the response
	 * @throws BusinessException the business exception
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "actionCancelarEditarParametro")
	protected void responseActionCancelarEditarParametro(@ModelAttribute("beanListarParametro") BeanListarParametro beanListarParametro, ActionRequest request, ActionResponse response) throws BusinessException, Exception {
		limpiarMensaje();
		try {
			parametroListarServiceImpl.listarParametros("");
			parametroEditarServiceImpl.getBeanEditarParametro().getCriterioEditarParametro().setNuevoRango(false);
		} catch (BusinessException e) {
			estado = "error";
			mensaje = e.getMessage();
			String asunto = Propiedades.getResourceBundle("gestion.parametros.parametro.controller.response.action.cancelar.editar.parametro");
			LogErrorUtil.registrarError(JSonUtil.getStringJson(beanListarParametro) , e.getTrazaMessage(), asunto);
			_log.error(asunto+e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setRenderParameter("id", "0");
		//response.setRenderParameter("action", "editarParametro");
		
		/***INICIO AUDITORIA***/
		//ESTE METODO DEBER SER UTILIZADO EN LA CAPA CONTROLLER
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null, PortalUtil.getHttpServletRequest(request));
		//ESTE METODO DEBE SER UTILIZADO EN LA CAPA MODELO/SERVICIO
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null);
		/***FIN AUDITORIA***/
	}
	
	/**
	 * Response action mostrar formulario parametro.
	 * Fecha: 22/08/2013
	 *
	 * @param beanEditarParametro the bean editar parametro
	 * @param request the request
	 * @param response the response
	 * @throws BusinessException the business exception
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "actionMostrarFormularioParametro")
	protected void responseActionMostrarFormularioParametro(@ModelAttribute("beanEditarParametro") BeanEditarParametro beanEditarParametro, ActionRequest request, ActionResponse response) throws BusinessException, Exception {
		limpiarMensaje();
		try {
			parametroEditarServiceImpl.mostrarFormularioEditarParametro();
			response.setRenderParameter("id", "0");
			response.setRenderParameter("action", "editarParametro");
		} catch (BusinessException e) {
			estado = "error";
			mensaje = e.getMessage();
			String asunto = Propiedades.getResourceBundle("gestion.parametros.parametro.controller.response.action.mostrar.formulario.parametro");
			LogErrorUtil.registrarError(JSonUtil.getStringJson(beanEditarParametro) , e.getTrazaMessage(), asunto);
			_log.error(asunto+e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setRenderParameter("id", "0");
		response.setRenderParameter("action", "editarParametro");
		
		/***INICIO AUDITORIA***/
		//ESTE METODO DEBER SER UTILIZADO EN LA CAPA CONTROLLER
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null, PortalUtil.getHttpServletRequest(request));
		//ESTE METODO DEBE SER UTILIZADO EN LA CAPA MODELO/SERVICIO
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), this.getClass().getName(), Long.parseLong(Soporte.obtenerResourceBundle().getString("resource.id."+this.getClass().getName())), null);
		/***FIN AUDITORIA***/
	}
	
	/**
	 * Obtiene bean listar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @return bean listar parametro
	 */
	@ModelAttribute(value = "beanListarParametro")
	public BeanListarParametro getBeanListarParametro() {
		return parametroListarServiceImpl.getBeanListarParametro();
	}
	
	/**
	 * Obtiene bean editar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @return bean editar parametro
	 */
	@ModelAttribute(value = "beanEditarParametro")
	public BeanEditarParametro getBeanEditarParametro() {	
		return parametroEditarServiceImpl.getBeanEditarParametro();
	}
	
//	private Object[] validarPeticion(RenderRequest renderRequest, String ip, String codigoProducto) throws BusinessException, Exception {
//		return SeguridadLocalServiceUtil.validar(renderRequest, ip, codigoProducto);
//	}

}
