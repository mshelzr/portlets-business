package pe.com.ibk.halcon.gestionperfilador.controller;

import java.util.ArrayList;
import java.util.List;

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

import pe.com.ibk.halcon.gestionperfilador.bean.BeanListadoRespuestas;
import pe.com.ibk.halcon.gestionperfilador.bean.BeanListadoVariables;
import pe.com.ibk.halcon.gestionperfilador.bean.VariablePerfiladorBean;
import pe.com.ibk.halcon.gestionperfilador.service.impl.VariablePerfiladorServiceImpl;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.ext.portlet.halcon.model.ConfiguracionPerfilador;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.portlet.PortletProps;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class ConfiguracionVariablesPerfiladorController.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 24/06/2013
 * @version Halcon 1.0
 */

@Controller
@RequestMapping("VIEW")
public class ConfiguracionVariablesPerfiladorController {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(ConfiguracionVariablesPerfiladorController.class);

	/** The indicador portlet. */
	// private static Integer indicadorPortlet = 10;
	//
	// /** The indicador controller. */
	// private static Integer indicadorController = 1;

	/** The variable perfilador service. */
	@Autowired
	private VariablePerfiladorServiceImpl variablePerfiladorService;

	/** The flag inicializar. */
	private boolean flagInicializar = true;

	/** The flag guardar edicion. */
	private boolean flagGuardarEdicion = false;

	/** The nivel variable. */
	private int nivelVariable;

	/**
	 * Default view. Fecha: 24/06/2013
	 * 
	 * @param renderRequest the render request
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest) {

		// *****Linea por default para todos los portlet******
		JSonUtil.getPath(renderRequest);
		// ***************************************************

		if (this.isFlagInicializar()) {
			variablePerfiladorService.inicializar();
			variablePerfiladorService.setIdPreguntaActual(0L);
			variablePerfiladorService.setIdRespuestaActual(0L);
			this.setNivelVariable(1);
		}
		renderRequest.setAttribute("variablePreguntaPerfiladorBean", variablePerfiladorService.getVariablePerfiladorBean());

		renderRequest.setAttribute("beanListadoVariables", variablePerfiladorService.getBeanListadoPreguntas());

		renderRequest.setAttribute("nivelVariable", String.valueOf(this.getNivelVariable()));
		// _log.info("DEFAULT " + variablePerfiladorService.getVariablePerfiladorBean().getNombre()
		// + "    " +
		// variablePerfiladorService.getBeanListadoPreguntas().getListaVariable().size());

		this.setFlagInicializar(true);
		// JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "listadoPreguntasPerfilador";
	}

	/**
	 * Response action. Fecha: 24/06/2013
	 * 
	 * @param variablePreguntaPerfiladorBean the variable pregunta perfilador bean
	 * @param action the action
	 * @param request the request
	 * @param response the response
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "action")
	public void responseAction(@ModelAttribute("variablePreguntaPerfiladorBean") VariablePerfiladorBean variablePreguntaPerfiladorBean, @RequestParam String action, ActionRequest request,
			ActionResponse response) throws Exception {

		_log.info("Entro a action Preguntas: " + variablePreguntaPerfiladorBean.getNombre() + " " + action);

		if (action.equalsIgnoreCase("Agregar Pregunta")) {
			this.actionAgregarVariable(variablePreguntaPerfiladorBean, request, response);
		} else if (action.equalsIgnoreCase("guardar pregunta")) {
			this.actionActionGuardarNuevaVariable(variablePreguntaPerfiladorBean, request, response);
		} else if (action.equalsIgnoreCase("cancelar")) {
			variablePerfiladorService.inicializarPregunta(variablePreguntaPerfiladorBean);
			this.actionCancelarVariable(variablePreguntaPerfiladorBean, request, response);
		}
		// JSonUtil.LogAuditoria(request, indicadorPortlet, indicadorController);

	}

	/**
	 * Response action editar variable. Fecha: 24/06/2013
	 * 
	 * @param id the id
	 * @param request the request
	 * @param response the response
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "actionEditarPregunta")
	public void responseActionEditarVariable(@RequestParam(value = "id", required = true) String id, ActionRequest request, ActionResponse response) throws Exception {

		ConfiguracionPerfilador cnf = variablePerfiladorService.buscarConfiguracionPerfilador(Long.valueOf(id));

		variablePerfiladorService.setVariablePerfiladorBean(variablePerfiladorService.convertirConfiguracionBean(cnf));
		setFlagInicializar(false);
		_log.info("EDITAR ---> codigo Clasificacion: " + cnf.getCodigoClasificacion() + " " + id);
		this.setFlagGuardarEdicion(true);

		request.setAttribute("variablePreguntaPerfiladorBean", variablePerfiladorService.getVariablePerfiladorBean());
		request.setAttribute("flagEdicion", this.isFlagGuardarEdicion());
		// JSonUtil.LogAuditoria(request, indicadorPortlet, indicadorController);
	}

	/**
	 * Response action asociacion variable. Fecha: 24/06/2013
	 * 
	 * @param id the id
	 * @param request the request
	 * @param response the response
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "actionAsociarRespuestas")
	public void responseActionAsociacionVariable(@RequestParam(value = "id", required = true) String id, ActionRequest request, ActionResponse response) throws Exception {

		_log.info("Entro a responseActionAsociacionVariable " + id);
		// JSonUtil.LogAuditoria(request, indicadorPortlet, indicadorController);
		response.setRenderParameter("id", id);
		response.setRenderParameter("action", "asociaRespuestas");

	}

	/**
	 * Action asociar respuesta. Fecha: 24/06/2013
	 * 
	 * @param id the id
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping(params = "action=asociaRespuestas")
	protected String actionAsociarRespuesta(@RequestParam(value = "id", required = false) String id, RenderRequest renderRequest, RenderResponse renderResponse) {

		_log.info("asociaRespuestas " + id);
		try {

			variablePerfiladorService.inicializarListados();
			variablePerfiladorService.setIdPreguntaActual(Long.valueOf(id));
			this.setFlagGuardarEdicion(false);
			variablePerfiladorService.setRespuestaPerfiladorBean(null);
			renderRequest.setAttribute("variableRespuestaPerfiladorBean", variablePerfiladorService.getRespuestaPerfiladorBean());
			renderRequest.setAttribute("listadoRespuestasPerfilador", variablePerfiladorService.getBeanListadoRespuestas().getListaRespuestas());
			renderRequest.setAttribute("nivelVariable", String.valueOf(this.getNivelVariable()));

		} catch (Exception e) {
			_log.error("Error en Action Listar Asociar Respuesta" + e.toString());
		}
		// JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "listadoRespuestasPerfilador";

	}

	/**
	 * Action agregar variable. Fecha: 24/06/2013
	 * 
	 * @param variablePerfiladorBean the variable perfilador bean
	 * @param request the request
	 * @param response the response
	 */
	private void actionAgregarVariable(VariablePerfiladorBean variablePerfiladorBean, ActionRequest request, ActionResponse response) {

		_log.info("Entro a ActionAgregarVariable Pregunta " + variablePerfiladorBean.getNombre());

		try {
			List<String> listaErrores = new ArrayList<String>();
			listaErrores = variablePerfiladorService.validarVariablePregunta(variablePerfiladorBean);

			if (listaErrores.size() > 0) {
				_log.info("listaErrores > 0");
				variablePerfiladorBean.setListaErrores(listaErrores);
				for (String error : listaErrores) {
					_log.info("Error " + error);
				}
				variablePerfiladorService.getBeanListadoPreguntas().getListaVariable();

			} else {
				ConfiguracionPerfilador conf = variablePerfiladorService.convertirPreguntaBeanConfiguracion(variablePerfiladorBean, true);

				variablePerfiladorService.getBeanListadoPreguntas().getListaVariable().add(conf);
				variablePerfiladorService.inicializarPregunta(variablePerfiladorBean);
			}
			this.setFlagInicializar(false);

		} catch (Exception e) {
			_log.error("Ocurrio un error al agregar la variable al listado " + e.toString());
		}
		// JSonUtil.LogAuditoria(request, indicadorPortlet, indicadorController);
	}

	/**
	 * Action action guardar nueva variable. Fecha: 24/06/2013
	 * 
	 * @param variablePerfiladorBean the variable perfilador bean
	 * @param request the request
	 * @param response the response
	 * @throws Exception the exception
	 */
	private void actionActionGuardarNuevaVariable(VariablePerfiladorBean variablePerfiladorBean, ActionRequest request, ActionResponse response) throws Exception {

		_log.info("Entro a ActionGuardaVariable " + variablePerfiladorBean.getNombre() + variablePerfiladorBean.getIdVariablePerfilador());

		try {
			BeanListadoVariables beanListadoVariables = variablePerfiladorService.getBeanListadoPreguntas();

			if (this.isFlagGuardarEdicion()) {
				List<String> listaErrores = variablePerfiladorService.validarVariablePregunta(variablePerfiladorBean);

				if (listaErrores.size() > 0) {
					_log.info("listaErrores > 0");
					variablePerfiladorBean.setListaErrores(listaErrores);
					for (String error : listaErrores) {
						_log.info("Error " + error);
					}
				} else {
					ConfiguracionPerfilador confPregunta = variablePerfiladorService.convertirPreguntaBeanConfiguracion(variablePerfiladorBean, false);
					variablePerfiladorService.guardarEdicionPerfilador(confPregunta);
					_log.info("Nueva: " + confPregunta.getNombreVariable());
					variablePerfiladorService.setVariablePerfiladorBean(new VariablePerfiladorBean());
				}

			} else {
				List<String> listE = new ArrayList<String>();
				boolean flagNuevo = false;
				_log.info("obtener size " + beanListadoVariables.getListaVariable().size());
				for (ConfiguracionPerfilador conf : beanListadoVariables.getListaVariable()) {
					if (conf.getEstado() == 2 || conf.getEstado() == 3) {
						flagNuevo = true;
						variablePerfiladorService.guardarVariablePerfilador(conf);
						_log.info(conf.getNombreVariable() + " registrado ");
					}
				}
				if(!flagNuevo){
					_log.info("flagNuevo " + flagNuevo);
					listE.add(PortletProps.get("mensaje.error.guardar.sin.agregar"));
					variablePerfiladorBean.setListaErrores(listE);
				}
			}

			if (variablePerfiladorBean.getListaErrores() == null || variablePerfiladorBean.getListaErrores().size() < 1) {
				variablePerfiladorService.inicializarPregunta(variablePerfiladorBean);
				variablePerfiladorService.inicializarListados();
				this.setFlagInicializar(false);
				this.setFlagGuardarEdicion(false);
			}

			request.setAttribute("flagEdicion", this.isFlagGuardarEdicion());

		} catch (Exception e) {
			_log.error("Ocurrio un error al Guardar la variables Agregadas " + e.toString());
		}
		// JSonUtil.LogAuditoria(request, indicadorPortlet, indicadorController);
	}

	/**
	 * Action cancelar variable. Fecha: 24/06/2013
	 * 
	 * @param variablePreguntaPerfiladorBean the variable pregunta perfilador bean
	 * @param request the request
	 * @param response the response
	 * @throws Exception the exception
	 */
	private void actionCancelarVariable(VariablePerfiladorBean variablePreguntaPerfiladorBean, ActionRequest request, ActionResponse response) throws Exception {

		try {
			variablePerfiladorService.inicializarListados();
			request.setAttribute("beanListadoVariables", variablePerfiladorService.getBeanListadoPreguntas().getListaVariable());
			request.setAttribute("variablePreguntaPerfiladorBean", variablePerfiladorService.generarNuevaVariablePerfiladorBean());
			this.setFlagInicializar(false);
		} catch (Exception e) {
			_log.error("Ocurrio un error al Guardar la variables Agregadas " + e.toString());
		}
		// JSonUtil.LogAuditoria(request, indicadorPortlet, indicadorController);
	}

	/**
	 * Nueva pregunta. Fecha: 24/06/2013
	 * 
	 * @param request the request
	 * @param response the response
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "actionNuevaPregunta")
	private void nuevaPregunta(ActionRequest request, ActionResponse response) throws Exception {

		_log.info("Ingreso a nuevaPregunta");
		try {
			variablePerfiladorService.inicializarListados();
			request.setAttribute("variablePreguntaPerfiladorBean", variablePerfiladorService.getVariablePerfiladorBean());
			request.setAttribute("listadoRespuestasPerfilador", variablePerfiladorService.getBeanListadoPreguntas());
			_log.info(" " + variablePerfiladorService.getBeanListadoPreguntas().getListaVariable().size());
			this.setFlagInicializar(false);

		} catch (Exception e) {
			_log.error("Ocurrio un error al ir a Nueva Pregunta " + e.toString());
		}
		// JSonUtil.LogAuditoria(request, indicadorPortlet, indicadorController);
	}

	/**
	 * Nueva respuesta. Fecha: 24/06/2013
	 * 
	 * @param id the id
	 * @param request the request
	 * @param response the response
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "actionNuevaRespuesta")
	private void nuevaRespuesta(@RequestParam(value = "id", required = true) String id, ActionRequest request, ActionResponse response) throws Exception {

		try {
			_log.info("nuevaRespuesta " + request.getParameter("id"));

			response.setRenderParameter("id", id);
			response.setRenderParameter("action", "irNuevaRespuesta");

		} catch (Exception e) {
			_log.error("Ocurrio un error al ir a Nueva Respuesta " + e.toString());
		}
		// JSonUtil.LogAuditoria(request, indicadorPortlet, indicadorController);
	}

	/**
	 * Ir nueva respuesta. Fecha: 24/06/2013
	 * 
	 * @param id the id
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping(params = "action=irNuevaRespuesta")
	protected String irNuevaRespuesta(@RequestParam(value = "id", required = false) String id, RenderRequest renderRequest, RenderResponse renderResponse) {

		_log.info("nuevaPregunta " + id);

		variablePerfiladorService.inicializarListados();
		variablePerfiladorService.setIdPreguntaActual(Long.valueOf(id));

		ConfiguracionPerfilador configuracionPerfilador = variablePerfiladorService.buscarConfiguracionPerfilador(Long.valueOf(id));
		VariablePerfiladorBean variablePerfiladorBean = variablePerfiladorService.convertirConfiguracionBean(configuracionPerfilador);
		variablePerfiladorBean.setRespuestaAsociada(new VariablePerfiladorBean());

		renderRequest.setAttribute("variableRespuestaPerfiladorBean", variablePerfiladorService.getRespuestaPerfiladorBean());
		renderRequest.setAttribute("listadoRespuestasPerfilador", variablePerfiladorService.getBeanListadoRespuestas().getListaRespuestas());
		renderRequest.setAttribute("nivelVariable", String.valueOf(this.getNivelVariable()));
		// JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "listadoRespuestasPerfilador";
	}

	/**
	 * Response action respuesta. Fecha: 24/06/2013
	 * 
	 * @param variablePreguntaPerfiladorBean the variable pregunta perfilador bean
	 * @param id the id
	 * @param action the action
	 * @param request the request
	 * @param response the response
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "actionRespuesta")
	public void responseActionRespuesta(@ModelAttribute("variableRespuestaPerfiladorBean") VariablePerfiladorBean variablePreguntaPerfiladorBean,
			@RequestParam(value = "id", required = false) String id, @RequestParam String action, ActionRequest request, ActionResponse response) throws Exception {

		_log.info("Entro a action Respuestas " + variablePreguntaPerfiladorBean.getRespuestaAsociada().getNombre() + " " + action + " ID: " + id);

		if (action.equalsIgnoreCase("Agregar Respuesta")) {
			variablePreguntaPerfiladorBean.setIdVariablePerfilador(Long.valueOf(id));
			this.agregarRespuesta(variablePreguntaPerfiladorBean, request, response);
		} else if (action.equalsIgnoreCase("Guardar")) {
			variablePreguntaPerfiladorBean.setIdVariablePerfilador(Long.valueOf(id));
			this.guardarRespuesta(variablePreguntaPerfiladorBean, request, response);
		} else if (action.equalsIgnoreCase("Cancelar")) {
			variablePreguntaPerfiladorBean.setIdVariablePerfilador(Long.valueOf(id));
			variablePerfiladorService.inicializarRespuesta(variablePreguntaPerfiladorBean);
			this.cancelarRespuesta(request, response);
		}
		// JSonUtil.LogAuditoria(request, indicadorPortlet, indicadorController);
	}

	// Agregar Respuesta

	/**
	 * Agregar respuesta. Fecha: 24/06/2013
	 * 
	 * @param variablePerfiladorBean the variable perfilador bean
	 * @param request the request
	 * @param response the response
	 * @throws Exception the exception
	 */
	private void agregarRespuesta(VariablePerfiladorBean variablePerfiladorBean, ActionRequest request, ActionResponse response) throws Exception {
		try {
			List<String> listaErrores = new ArrayList<String>();
			listaErrores = variablePerfiladorService.validarVariableRespuesta(variablePerfiladorBean);
			
			if (listaErrores.size() > 0) {
				variablePerfiladorBean.setListaErrores(listaErrores);
			} else {
				if ((variablePerfiladorBean.getRespuestaAsociada().getNombre() != null && !variablePerfiladorBean.getRespuestaAsociada().getNombre().equals(""))
						|| (variablePerfiladorBean.getRespuestaAsociada().getValor1() != null && !variablePerfiladorBean.getRespuestaAsociada().getValor1().equals("")
								&& variablePerfiladorBean.getRespuestaAsociada().getValor2() != null && !variablePerfiladorBean.getRespuestaAsociada().getValor2().equals(""))) {
					variablePerfiladorBean.getRespuestaAsociada().setCodigoPadre(variablePerfiladorBean.getIdVariablePerfilador());
					
					
					ConfiguracionPerfilador conf = variablePerfiladorService.convertirRespuestaBeanConfiguracion(variablePerfiladorBean.getRespuestaAsociada(), true);
					
					BeanListadoRespuestas beanListadoRespuestas = variablePerfiladorService.getBeanListadoRespuestas();
					List<ConfiguracionPerfilador> lista = new ArrayList<ConfiguracionPerfilador>();
					lista.addAll(beanListadoRespuestas.getListaRespuestas());
					lista.add(conf);
					beanListadoRespuestas.setListaRespuestas(lista);
					variablePerfiladorService.inicializarRespuesta(variablePerfiladorBean);
					_log.info("Prueba");
				}
			}

			response.setRenderParameter("id", String.valueOf(variablePerfiladorBean.getIdVariablePerfilador()));
			response.setRenderParameter("action", "irAgregarRespuesta");

		} catch (Exception e) {
			_log.error("Ocurrio un error al ir a Agregar Respuesta " + e.toString(), e);
		}
	}

	/**
	 * Ir agregar respuesta. Fecha: 24/06/2013
	 * 
	 * @param id the id
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping(params = "action=irAgregarRespuesta")
	protected String irAgregarRespuesta(@RequestParam(value = "id", required = false) String id, RenderRequest renderRequest, RenderResponse renderResponse) {

		_log.info("irAgregarRespuesta " + id);

		renderRequest.setAttribute("variableRespuestaPerfiladorBean", variablePerfiladorService.getRespuestaPerfiladorBean());
		renderRequest.setAttribute("listadoRespuestasPerfilador", variablePerfiladorService.getBeanListadoRespuestas().getListaRespuestas());
		renderRequest.setAttribute("nivelVariable", String.valueOf(this.getNivelVariable()));
		// JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "listadoRespuestasPerfilador";
	}

	// Guardar Respuesta

	/**
	 * Guardar respuesta. Fecha: 24/06/2013
	 * 
	 * @param variablePerfiladorBean the variable perfilador bean
	 * @param request the request
	 * @param response the response
	 * @throws Exception the exception
	 */
	private void guardarRespuesta(VariablePerfiladorBean variablePerfiladorBean, ActionRequest request, ActionResponse response) throws Exception {

		try {
			_log.info("guardarRespuesta: " + variablePerfiladorBean.getIdVariablePerfilador() + variablePerfiladorBean.getRespuestaAsociada().getNombre());

			if (this.isFlagGuardarEdicion()) {

				List<String> listaErrores = variablePerfiladorService.validarVariableRespuesta(variablePerfiladorBean);

				if (listaErrores.size() > 0) {
					_log.info("listaErrores > 0");
					variablePerfiladorBean.setListaErrores(listaErrores);
					for (String error : listaErrores) {
						_log.info("Error " + error);
					}
				} else {
					variablePerfiladorBean.getRespuestaAsociada().setIdVariablePerfilador(variablePerfiladorService.getIdRespuestaActual());
					ConfiguracionPerfilador confRespuesta = variablePerfiladorService.convertirRespuestaBeanConfiguracion(variablePerfiladorBean.getRespuestaAsociada(), false);
					variablePerfiladorService.guardarEdicionPerfilador(confRespuesta);
					_log.info("Editar: " + confRespuesta.getNombreVariable());
					variablePerfiladorService.setVariablePerfiladorBean(new VariablePerfiladorBean());
				}

			} else {
				variablePerfiladorService.getRespuestaPerfiladorBean().setIdVariablePerfilador(variablePerfiladorBean.getIdVariablePerfilador());
				BeanListadoRespuestas beanListadoRespuestas = variablePerfiladorService.getBeanListadoRespuestas();
				boolean flagNuevo = false;
				List<String> listE = new ArrayList<String>();
				for (ConfiguracionPerfilador conf : beanListadoRespuestas.getListaRespuestas()) {
					_log.info(conf.getEstado() + " " + conf.getCodigoVariablePadre());
					if (conf.getEstado() == 2 || conf.getEstado() == 3) {
						flagNuevo = true;
						_log.info(conf.getNombreVariable() + " no registrado ");
						variablePerfiladorService.guardarVariablePerfilador(conf);
					}
				}
				if(!flagNuevo){
					_log.info("flagNuevo " + flagNuevo);
					listE.add(PortletProps.get("mensaje.error.guardar.sin.agregar"));
					variablePerfiladorBean.setListaErrores(listE);
				}
			}

			if (variablePerfiladorBean.getListaErrores() == null || variablePerfiladorBean.getListaErrores().size() < 1) {
				variablePerfiladorService.inicializarListados();
				variablePerfiladorService.inicializarRespuesta(variablePerfiladorBean);
				variablePerfiladorService.setIdPreguntaActual(variablePerfiladorBean.getIdVariablePerfilador());

				this.setFlagInicializar(false);
				this.setFlagGuardarEdicion(false);
			}

			response.setRenderParameter("id", String.valueOf(variablePerfiladorBean.getIdVariablePerfilador()));
			response.setRenderParameter("action", "irAgregarRespuesta");
			request.setAttribute("flagEdicion", this.isFlagGuardarEdicion());

		} catch (Exception e) {
			_log.error("Ocurrio un error al ir a Guardar Respuesta " + e.toString());
		}
		// JSonUtil.LogAuditoria(request, indicadorPortlet, indicadorController);
	}

	/**
	 * Ir guardar respuesta. Fecha: 24/06/2013
	 * 
	 * @param id the id
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping(params = "action=irGuardarRespuesta")
	protected String irGuardarRespuesta(@RequestParam(value = "id", required = false) String id, RenderRequest renderRequest, RenderResponse renderResponse) {

		_log.info("irGuardarRespuesta " + id);

		ConfiguracionPerfilador configuracionPerfilador = variablePerfiladorService.buscarConfiguracionPerfilador(Long.valueOf(id));
		VariablePerfiladorBean variablePerfiladorBean = variablePerfiladorService.convertirConfiguracionBean(configuracionPerfilador);
		variablePerfiladorBean.setRespuestaAsociada(new VariablePerfiladorBean());

		renderRequest.setAttribute("variableRespuestaPerfiladorBean", variablePerfiladorBean);
		renderRequest.setAttribute("listadoRespuestasPerfilador", variablePerfiladorService.getBeanListadoRespuestas());
		// JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "listadoRespuestasPerfilador";
	}

	/**
	 * Response action asociacion preguntas. Fecha: 24/06/2013
	 * 
	 * @param id the id
	 * @param request the request
	 * @param response the response
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "actionAsociarPreguntas")
	public void responseActionAsociacionPreguntas(@RequestParam(value = "id", required = true) String id, ActionRequest request, ActionResponse response) throws Exception {

		// JSonUtil.LogAuditoria(request, indicadorPortlet, indicadorController);
		_log.info("Entro a responseActionAsociacionPreguntas " + id);
		response.setRenderParameter("id", id);
		response.setRenderParameter("action", "asociaPreguntas");
	}

	/**
	 * Action nueva pregunta asociar. Fecha: 24/06/2013
	 * 
	 * @param id the id
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping(params = "action=asociaPreguntas")
	protected String actionNuevaPreguntaAsociar(@RequestParam(value = "id", required = false) String id, RenderRequest renderRequest, RenderResponse renderResponse) {

		_log.info("asociaPreguntas " + id);

		try {

			variablePerfiladorService.inicializarListados();
			variablePerfiladorService.setIdRespuestaActual(Long.valueOf(id));
			this.setFlagGuardarEdicion(false);
			nivelVariable++;
			_log.info("Tamaño listaaa para ID " + variablePerfiladorService.getIdRespuestaActual() + " " + variablePerfiladorService.getBeanListadoPreguntas().getListaVariable().size());
			renderRequest.setAttribute("variablePreguntaPerfiladorBean", variablePerfiladorService.getVariablePerfiladorBean());
			renderRequest.setAttribute("beanListadoVariables", variablePerfiladorService.getBeanListadoPreguntas());
			renderRequest.setAttribute("nivelVariable", String.valueOf(this.getNivelVariable()));

		} catch (Exception e) {
			_log.error("Error en Action Listar Asociar Respuesta" + e.toString());
		}
		// JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "listadoPreguntasPerfilador";

	}

	/**
	 * Cancelar respuesta. Fecha: 24/06/2013
	 * 
	 * @param request the request
	 * @param response the response
	 * @throws Exception the exception
	 */
	private void cancelarRespuesta(ActionRequest request, ActionResponse response) throws Exception {

		try {
			Long idPregunta = variablePerfiladorService.getIdPreguntaActual();
			variablePerfiladorService.inicializarListados();
			variablePerfiladorService.setIdPreguntaActual(idPregunta);

			response.setRenderParameter("id", String.valueOf(idPregunta));
			response.setRenderParameter("action", "irCancelarRespuesta");

		} catch (Exception e) {
			_log.error("Ocurrio un error al Guardar la variables Agregadas " + e.toString());
		}
		// JSonUtil.LogAuditoria(request, indicadorPortlet, indicadorController);
	}

	/**
	 * Action cancelar respuesta. Fecha: 24/06/2013
	 * 
	 * @param id the id
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping(params = "action=irCancelarRespuesta")
	protected String actionCancelarRespuesta(@RequestParam(value = "id", required = false) String id, RenderRequest renderRequest, RenderResponse renderResponse) {

		_log.info("irCancelarRespuesta " + id);

		try {

			variablePerfiladorService.inicializar();
			variablePerfiladorService.setIdPreguntaActual(Long.valueOf(id));

			renderRequest.setAttribute("variableRespuestaPerfiladorBean", variablePerfiladorService.getRespuestaPerfiladorBean());
			renderRequest.setAttribute("listadoRespuestasPerfilador", variablePerfiladorService.getBeanListadoRespuestas().getListaRespuestas());
			renderRequest.setAttribute("nivelVariable", String.valueOf(this.getNivelVariable()));

			_log.info("irCancelarRespuesta " + variablePerfiladorService.getRespuestaPerfiladorBean().getRespuestaAsociada().getNombre());

		} catch (Exception e) {
			_log.error("Error en Action Listar Asociar Respuesta" + e.toString());
		}
		// JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "listadoRespuestasPerfilador";

	}

	/**
	 * Response action editar respuesta. Fecha: 24/06/2013
	 * 
	 * @param id the id
	 * @param request the request
	 * @param response the response
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "actionEditarRespuesta")
	public void responseActionEditarRespuesta(@RequestParam(value = "id", required = true) String id, ActionRequest request, ActionResponse response) throws Exception {

		ConfiguracionPerfilador cnf = variablePerfiladorService.buscarConfiguracionPerfilador(Long.valueOf(id));

		variablePerfiladorService.getRespuestaPerfiladorBean().setRespuestaAsociada(variablePerfiladorService.convertirConfiguracionBean(cnf));
		setFlagInicializar(false);
		this.setFlagGuardarEdicion(true);
		variablePerfiladorService.setIdRespuestaActual(Long.valueOf(id));

		// JSonUtil.LogAuditoria(request, indicadorPortlet, indicadorController);
		response.setRenderParameter("id", String.valueOf(id));
		response.setRenderParameter("action", "irEditarRespuesta");

	}

	/**
	 * Action ir editar respuesta. Fecha: 24/06/2013
	 * 
	 * @param id the id
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping(params = "action=irEditarRespuesta")
	protected String actionIrEditarRespuesta(@RequestParam(value = "id", required = false) String id, RenderRequest renderRequest, RenderResponse renderResponse) {

		_log.info("irEditarRespuesta " + id);

		try {
			renderRequest.setAttribute("listadoRespuestasPerfilador", variablePerfiladorService.getBeanListadoRespuestas().getListaRespuestas());
			renderRequest.setAttribute("variableRespuestaPerfiladorBean", variablePerfiladorService.getRespuestaPerfiladorBean());
			renderRequest.setAttribute("nivelVariable", String.valueOf(this.getNivelVariable()));
			renderRequest.setAttribute("flagEdicion", this.isFlagGuardarEdicion());

		} catch (Exception e) {
			_log.error("Error en Editar Respuesta" + e.toString());
		}
		// JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "listadoRespuestasPerfilador";

	}

	/**
	 * Action regresar respuesta. Fecha: 24/06/2013
	 * 
	 * @param request the request
	 * @param response the response
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "irRegresarRespuesta")
	public void actionRegresarRespuesta(ActionRequest request, ActionResponse response) throws Exception {

		_log.info("Ir regresar Respuesta");
		// JSonUtil.LogAuditoria(request, indicadorPortlet, indicadorController);
		response.setRenderParameter("action", "regresarAPregunta");
	}

	/**
	 * Regresar a pregunta. Fecha: 24/06/2013
	 * 
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping(params = "action=regresarAPregunta")
	protected String regresarAPregunta(RenderRequest renderRequest, RenderResponse renderResponse) {

		_log.info("regresarAPregunta " + variablePerfiladorService.getIdRespuestaActual());

		try {
			variablePerfiladorService.inicializarListados();
			if (this.getNivelVariable() == 1) {
				variablePerfiladorService.inicializar();
				variablePerfiladorService.setIdPreguntaActual(0L);
				variablePerfiladorService.setIdRespuestaActual(0L);
			}
			renderRequest.setAttribute("variablePreguntaPerfiladorBean", variablePerfiladorService.getVariablePerfiladorBean());

			renderRequest.setAttribute("beanListadoVariables", variablePerfiladorService.getBeanListadoPreguntas());

			renderRequest.setAttribute("nivelVariable", String.valueOf(this.getNivelVariable()));

		} catch (Exception e) {
			_log.error("Error en Editar Respuesta" + e.toString());
		}
		// JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "listadoPreguntasPerfilador";

	}

	/**
	 * Action regresar pregunta. Fecha: 24/06/2013
	 * 
	 * @param request the request
	 * @param response the response
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "irRegresarPregunta")
	public void actionRegresarPregunta(ActionRequest request, ActionResponse response) throws Exception {

		_log.info("Ir regresar Pregunta");
		if (this.nivelVariable > 1) {
			response.setRenderParameter("action", "regresarARespuesta");
		}
		// JSonUtil.LogAuditoria(request, indicadorPortlet, indicadorController);
	}

	/**
	 * Regresar a respuesta. Fecha: 24/06/2013
	 * 
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping(params = "action=regresarARespuesta")
	protected String regresarARespuesta(RenderRequest renderRequest, RenderResponse renderResponse) {

		_log.info("regresarARespuesta " + variablePerfiladorService.getIdPreguntaActual());

		try {
			nivelVariable--;
			variablePerfiladorService.inicializarListados();
			ConfiguracionPerfilador respuestaA = variablePerfiladorService.buscarConfiguracionPerfilador(variablePerfiladorService.getIdRespuestaActual());
			variablePerfiladorService.setIdPreguntaActual(respuestaA.getCodigoVariablePadre());
			variablePerfiladorService.setRespuestaPerfiladorBean(null);
			renderRequest.setAttribute("variableRespuestaPerfiladorBean", variablePerfiladorService.getRespuestaPerfiladorBean());
			renderRequest.setAttribute("listadoRespuestasPerfilador", variablePerfiladorService.getBeanListadoRespuestas().getListaRespuestas());
			renderRequest.setAttribute("nivelVariable", String.valueOf(this.getNivelVariable()));

		} catch (Exception e) {
			_log.error("Error en regresarARespuesta" + e.toString());
		}
		// JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "listadoRespuestasPerfilador";

	}

	/**
	 * Comprueba si es flag inicializar. Fecha: 24/06/2013
	 * 
	 * @return true, si es flag inicializar
	 */
	public boolean isFlagInicializar() {
		return flagInicializar;
	}

	/**
	 * Establece el flag inicializar.
	 * 
	 * @param flagInicializar el new flag inicializar
	 */
	public void setFlagInicializar(boolean flagInicializar) {
		this.flagInicializar = flagInicializar;
	}

	/**
	 * Comprueba si es flag guardar edicion. Fecha: 24/06/2013
	 * 
	 * @return true, si es flag guardar edicion
	 */
	public boolean isFlagGuardarEdicion() {
		return flagGuardarEdicion;
	}

	/**
	 * Establece el flag guardar edicion.
	 * 
	 * @param flagGuardarEdicion el new flag guardar edicion
	 */
	public void setFlagGuardarEdicion(boolean flagGuardarEdicion) {
		this.flagGuardarEdicion = flagGuardarEdicion;
	}

	/**
	 * Obtiene nivel variable. Fecha: 24/06/2013
	 * 
	 * @return nivel variable
	 */
	public int getNivelVariable() {
		return nivelVariable;
	}

	/**
	 * Establece el nivel variable.
	 * 
	 * @param nivelVariable el new nivel variable
	 */
	public void setNivelVariable(int nivelVariable) {
		this.nivelVariable = nivelVariable;
	}

}
