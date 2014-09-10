package pe.com.ibk.halcon.gestionperfilador.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pe.com.ibk.halcon.gestionperfilador.bean.BeanListadoRespuestas;
import pe.com.ibk.halcon.gestionperfilador.bean.BeanListadoVariables;
import pe.com.ibk.halcon.gestionperfilador.bean.VariablePerfiladorBean;
import pe.com.ibk.halcon.gestionperfilador.service.VariablePerfiladorService;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.LogErrorUtil;
import com.exp.portlet.halcon.utils.Propiedades;
import com.exp.portlet.halcon.utils.ValidatorUtils;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.ConfiguracionPerfilador;
import com.ext.portlet.halcon.service.ClpSerializer;
import com.ext.portlet.halcon.service.ConfiguracionPerfiladorLocalServiceUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.portlet.PortletProps;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class VariablePerfiladorServiceImpl.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 24/06/2013
 * @version Halcon 1.0
 */
@Service
public class VariablePerfiladorServiceImpl implements VariablePerfiladorService {

	/** The Constant COD_PERFILADOR_ACTIVO. */
	private static final String COD_PERFILADOR_ACTIVO = PortletProps.get("variable.perfilador.code.estado.activo");

	/** The Constant COD_PERFILADOR_INACTIVO. */
	private static final String COD_PERFILADOR_INACTIVO = PortletProps.get("variable.perfilador.code.estado.inactivo");

	/** The Constant COD_PERFILADOR_NO_REGISTRADO_ACTIVO. */
	private static final String COD_PERFILADOR_NO_REGISTRADO_ACTIVO = PortletProps.get("variable.perfilador.code.estado.no.registrado.activo");

	/** The Constant COD_PERFILADOR_NO_REGISTRADO_INACTIVO. */
	private static final String COD_PERFILADOR_NO_REGISTRADO_INACTIVO = PortletProps.get("variable.perfilador.code.estado.no.registrado.inactivo");

	/** The Constant COD_PERFILADOR_PREGUNTA. */
	private static final String COD_PERFILADOR_PREGUNTA = PortletProps.get("variable.perfilador.code.tipo.pregunta");

	/** The Constant COD_PERFILADOR_RESPUESTA. */
	private static final String COD_PERFILADOR_RESPUESTA = PortletProps.get("variable.perfilador.code.tipo.respuesta");

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(VariablePerfiladorServiceImpl.class);

	/** The bean listado preguntas. */
	protected BeanListadoVariables beanListadoPreguntas;

	/** The variable perfilador bean. */
	protected VariablePerfiladorBean variablePerfiladorBean;

	/** The respuesta perfilador bean. */
	protected VariablePerfiladorBean respuestaPerfiladorBean;

	/** The bean listado respuestas. */
	protected BeanListadoRespuestas beanListadoRespuestas;

	/** The id pregunta actual. */
	protected Long idPreguntaActual;

	/** The id respuesta actual. */
	protected Long idRespuestaActual;

	/**
	 * Inicializar. Fecha: 24/06/2013
	 */
	public void inicializar() {
		this.setIdPreguntaActual(null);
		this.setIdRespuestaActual(null);
		this.setBeanListadoRespuestas(null);
		this.setRespuestaPerfiladorBean(null);
		this.setBeanListadoPreguntas(null);
		this.setVariablePerfiladorBean(null);
	}

	/**
	 * Inicializar listados. Fecha: 24/06/2013
	 */
	public void inicializarListados() {
		this.setBeanListadoRespuestas(null);
		this.setBeanListadoPreguntas(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.com.ibk.halcon.gestionperfilador.service.VariablePerfiladorService#getBeanListadoPreguntas
	 * ()
	 */
	public BeanListadoVariables getBeanListadoPreguntas() {
		System.out.println("resp Actual" + this.getIdRespuestaActual());
		try {
			if (beanListadoPreguntas == null) {
				beanListadoPreguntas = new BeanListadoVariables();
				if (this.getIdRespuestaActual() != null && this.getIdRespuestaActual() > 0) {
					this.getBeanListadoPreguntas().listar(this.getIdRespuestaActual());
				} else {
					this.getBeanListadoPreguntas().listar(null);
				}

			}
		} catch (Exception e) {
			_log.error("getBeanListadoPreguntas " + e.toString());
		}

		return beanListadoPreguntas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.com.ibk.halcon.gestionperfilador.service.VariablePerfiladorService#setBeanListadoPreguntas
	 * (pe.com.ibk.halcon.gestionperfilador.bean.BeanListadoVariables)
	 */
	public void setBeanListadoPreguntas(BeanListadoVariables beanListadoPreguntas) {
		this.beanListadoPreguntas = beanListadoPreguntas;
	}

	/**
	 * Obtiene bean listado respuestas. Fecha: 24/06/2013
	 * 
	 * @return bean listado respuestas
	 */
	public BeanListadoRespuestas getBeanListadoRespuestas() {
		try {
			if (beanListadoRespuestas == null) {
				beanListadoRespuestas = new BeanListadoRespuestas();
				if (this.getIdPreguntaActual() != null && this.getIdPreguntaActual() > 0) {
					this.getBeanListadoRespuestas().listarRespuestas(this.getIdPreguntaActual());
				}
			}
		} catch (Exception e) {
			_log.error("getBeanListadoVariables " + e.toString());
		}

		return beanListadoRespuestas;
	}

	/**
	 * Establece el bean listado respuestas.
	 * 
	 * @param beanListadoRespuestas el new bean listado respuestas
	 */
	public void setBeanListadoRespuestas(BeanListadoRespuestas beanListadoRespuestas) {
		this.beanListadoRespuestas = beanListadoRespuestas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.com.ibk.halcon.gestionperfilador.service.VariablePerfiladorService#getVariablePerfiladorBean
	 * ()
	 */
	public VariablePerfiladorBean getVariablePerfiladorBean() {
		try {
			if (variablePerfiladorBean == null) {
				variablePerfiladorBean = generarNuevaVariablePerfiladorBean();
			}
		} catch (Exception e) {
			_log.error("Error getBeanListadoVariables " + e.toString());
		}
		return variablePerfiladorBean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.com.ibk.halcon.gestionperfilador.service.VariablePerfiladorService#setVariablePerfiladorBean
	 * (pe.com.ibk.halcon.gestionperfilador.bean.VariablePerfiladorBean)
	 */
	public void setVariablePerfiladorBean(VariablePerfiladorBean variablePerfiladorBean) {
		this.variablePerfiladorBean = variablePerfiladorBean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.com.ibk.halcon.gestionperfilador.service.VariablePerfiladorService#listarVariables()
	 */
	public void listarVariables() throws Exception {
		beanListadoPreguntas.listar(this.getIdRespuestaActual());
	}

	/**
	 * Establece el respuesta perfilador bean.
	 * 
	 * @param respuestaPerfiladorBean el new respuesta perfilador bean
	 */
	public void setRespuestaPerfiladorBean(VariablePerfiladorBean respuestaPerfiladorBean) {
		this.respuestaPerfiladorBean = respuestaPerfiladorBean;
	}

	/**
	 * Obtiene id pregunta actual. Fecha: 24/06/2013
	 * 
	 * @return id pregunta actual
	 */
	public Long getIdPreguntaActual() {
		return idPreguntaActual;
	}

	/**
	 * Establece el id pregunta actual.
	 * 
	 * @param idPreguntaActual el new id pregunta actual
	 */
	public void setIdPreguntaActual(Long idPreguntaActual) {
		this.idPreguntaActual = idPreguntaActual;
	}

	/**
	 * Generar variable perfilador bean. Fecha: 24/06/2013
	 * 
	 * @return the variable perfilador bean
	 * @throws Exception the exception
	 */
	public VariablePerfiladorBean generarNuevaVariablePerfiladorBean() throws Exception {
		VariablePerfiladorBean varBean = new VariablePerfiladorBean();
		varBean.setEstado(Integer.valueOf(COD_PERFILADOR_ACTIVO));
		varBean.setCodigoClasificacion(10);
		return varBean;
	}

	/**
	 * Generar respuesta perfilador bean. Fecha: 24/06/2013
	 * 
	 * @return the variable perfilador bean
	 * @throws Exception the exception
	 */
	public VariablePerfiladorBean generarRespuestaPerfiladorBean() throws Exception {
		VariablePerfiladorBean varBean = new VariablePerfiladorBean();
		if (this.getIdPreguntaActual() != null && this.getIdPreguntaActual() > 0) {
			ConfiguracionPerfilador conf = this.buscarConfiguracionPerfilador(this.getIdPreguntaActual());
			varBean = this.convertirConfiguracionBean(conf);
			varBean.setRespuestaAsociada(new VariablePerfiladorBean());
			varBean.getRespuestaAsociada().setEstado(Integer.valueOf(COD_PERFILADOR_ACTIVO));
		}
		return varBean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.com.ibk.halcon.gestionperfilador.service.VariablePerfiladorService#
	 * convertirPreguntaBeanConfiguracion
	 * (pe.com.ibk.halcon.gestionperfilador.bean.VariablePerfiladorBean, java.lang.Boolean)
	 */
	public ConfiguracionPerfilador convertirPreguntaBeanConfiguracion(VariablePerfiladorBean varBean, Boolean flagNuevo) {

		Long idConfiguracion = 0L;

		if (flagNuevo) {
			try {
				idConfiguracion = ConfiguracionPerfiladorLocalServiceUtil.obtenerCorrelativoConfiguracionPerfilador();
			} catch (BusinessException e) {

				String asunto = Propiedades.getResourceBundle("configuracion.variables.perfilador.variable.perfilador.serviceimpl.convertir.preguntabean.configuracion");
				LogErrorUtil.registrarError(JSonUtil.getStringJson(JSonUtil.NO_EXISTE_PARAMETRO), e.getTrazaMessage(), asunto);
				_log.error(Propiedades.getResourceBundle("configuracion.variables.perfilador.variable.perfilador.serviceimpl.convertir.preguntabean.configuracion") + e.toString());

			}
		} else {
			idConfiguracion = varBean.getIdVariablePerfilador();
		}

		ConfiguracionPerfilador conf = ConfiguracionPerfiladorLocalServiceUtil.createConfiguracionPerfilador(idConfiguracion);
		conf.setNombreVariable(varBean.getNombre());
		conf.setEstado(varBean.getEstado() == Integer.valueOf(COD_PERFILADOR_ACTIVO) ? Integer.valueOf(COD_PERFILADOR_NO_REGISTRADO_ACTIVO) : Integer.valueOf(COD_PERFILADOR_NO_REGISTRADO_INACTIVO));
		conf.setTipoVariable(Long.valueOf(COD_PERFILADOR_PREGUNTA));
		conf.setCodigoClasificacion(varBean.getCodigoClasificacion() != null ? Long.valueOf(varBean.getCodigoClasificacion()) : null);
		conf.setCodigoVariablePadre(this.getIdRespuestaActual() != null ? this.getIdRespuestaActual() : null);

		if (varBean.getCodigoClasificacion() != null && varBean.getCodigoClasificacion() == 10) {
			conf.setValor1(varBean.getValor1());
			conf.setValor2(varBean.getValor2());
			conf.setValor3(varBean.getValor3());
		}

		return conf;
	}

	/**
	 * Convertir respuesta bean configuracion. Fecha: 24/06/2013
	 * 
	 * @param varBean the var bean
	 * @param flagNuevo the flag nuevo
	 * @return the configuracion perfilador
	 */
	public ConfiguracionPerfilador convertirRespuestaBeanConfiguracion(VariablePerfiladorBean varBean, Boolean flagNuevo) {

		Long idConfiguracion = 0L;

		if (flagNuevo) {
			try {
				idConfiguracion = ConfiguracionPerfiladorLocalServiceUtil.obtenerCorrelativoConfiguracionPerfilador();
			} catch (BusinessException e) {

				String asunto = Propiedades.getResourceBundle("configuracion.variables.perfilador.variable.perfilador.serviceimpl.convertir.respuestabean.configuracion");
				LogErrorUtil.registrarError(JSonUtil.getStringJson(JSonUtil.NO_EXISTE_PARAMETRO), e.getTrazaMessage(), asunto);
				_log.error(Propiedades.getResourceBundle("configuracion.variables.perfilador.variable.perfilador.serviceimpl.convertir.respuestabean.configuracion") + e.toString());

			}
		} else {
			idConfiguracion = varBean.getIdVariablePerfilador();
		}
		ConfiguracionPerfilador conf = ConfiguracionPerfiladorLocalServiceUtil.createConfiguracionPerfilador(idConfiguracion);
		conf.setNombreVariable(varBean.getNombre() != null ? varBean.getNombre() : "");
		conf.setEstado(varBean.getEstado() == Integer.valueOf(COD_PERFILADOR_ACTIVO) ? Integer.valueOf(COD_PERFILADOR_NO_REGISTRADO_ACTIVO) : Integer.valueOf(COD_PERFILADOR_NO_REGISTRADO_INACTIVO));
		conf.setTipoVariable(Long.valueOf(COD_PERFILADOR_RESPUESTA));
		conf.setCodigoClasificacion(null);
		conf.setCodigoVariablePadre(varBean.getCodigoPadre());

		conf.setValor1(varBean.getValor1() != null ? varBean.getValor1() : "");
		conf.setValor2(varBean.getValor2() != null ? varBean.getValor2() : "");
		conf.setValor3(varBean.getValor3() != null ? varBean.getValor3() : "");

		return conf;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.com.ibk.halcon.gestionperfilador.service.VariablePerfiladorService#
	 * consultarBeanListadoVariables()
	 */
	public BeanListadoVariables consultarBeanListadoVariables() {
		try {
			this.getBeanListadoPreguntas().listar(this.getIdRespuestaActual());
		} catch (Exception e) {
			_log.error("Error consultarBeanListadoVariables " + e.toString());
		}
		return beanListadoPreguntas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.com.ibk.halcon.gestionperfilador.service.VariablePerfiladorService#guardarVariablePerfilador
	 * (com.ext.portlet.halcon.model.ConfiguracionPerfilador)
	 */
	public void guardarVariablePerfilador(ConfiguracionPerfilador configuracionPerfilador) {
		try {
			configuracionPerfilador.setEstado(configuracionPerfilador.getEstado() == Integer.valueOf(COD_PERFILADOR_NO_REGISTRADO_ACTIVO) ? Integer.valueOf(COD_PERFILADOR_ACTIVO) : Integer
					.valueOf(COD_PERFILADOR_INACTIVO));
			ConfiguracionPerfiladorLocalServiceUtil.insert(configuracionPerfilador);
		} catch (BusinessException e) {
			String asunto = Propiedades.getResourceBundle("configuracion.variables.perfilador.variable.perfilador.serviceimpl.guardar.variable.perfilador");
			LogErrorUtil.registrarError(JSonUtil.getStringJson(configuracionPerfilador), e.getTrazaMessage(), asunto);
			_log.error(Propiedades.getResourceBundle("configuracion.variables.perfilador.variable.perfilador.serviceimpl.guardar.variable.perfilador") + e.toString());

		}

	}

	/**
	 * Guardar edicion perfilador. Fecha: 24/06/2013
	 * 
	 * @param configuracionPerfilador the configuracion perfilador
	 */
	public void guardarEdicionPerfilador(ConfiguracionPerfilador configuracionPerfilador) {
		try {
			configuracionPerfilador.setEstado(configuracionPerfilador.getEstado() == Integer.valueOf(COD_PERFILADOR_NO_REGISTRADO_ACTIVO) ? Integer.valueOf(COD_PERFILADOR_ACTIVO) : Integer
					.valueOf(COD_PERFILADOR_INACTIVO));
			ConfiguracionPerfiladorLocalServiceUtil.update(configuracionPerfilador);
		} catch (BusinessException e) {

			String asunto = Propiedades.getResourceBundle("configuracion.variables.perfilador.variable.perfilador.serviceimpl.guardar.edicion.perfilador");
			LogErrorUtil.registrarError(JSonUtil.getStringJson(configuracionPerfilador), e.getTrazaMessage(), asunto);
			_log.error(Propiedades.getResourceBundle("configuracion.variables.perfilador.variable.perfilador.serviceimpl.guardar.edicion.perfilador") + e.toString());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.com.ibk.halcon.gestionperfilador.service.VariablePerfiladorService#
	 * buscarConfiguracionPerfilador(java.lang.Long)
	 */
	public ConfiguracionPerfilador buscarConfiguracionPerfilador(Long idConfiguracionPerfilador) {

		List<ConfiguracionPerfilador> listadoVariables = null;
		ConfiguracionPerfilador configuracionPerfilador = null;

		try {
			ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");

			DynamicQuery consultaP = DynamicQueryFactoryUtil.forClass(ConfiguracionPerfilador.class, classLoader)
			// .add(PropertyFactoryUtil.forName("estado").eq(
			// Integer.valueOf(COD_PERFILADOR_ACTIVO)))
					.add(PropertyFactoryUtil.forName("idConfiguracionPerfilador").eq(idConfiguracionPerfilador));

			listadoVariables = ConfiguracionPerfiladorLocalServiceUtil.dynamicQuery(consultaP, -1, -1);
			if (listadoVariables != null && listadoVariables.size() > 0) {
				configuracionPerfilador = listadoVariables.get(0);
			}

		} catch (Exception e) {
			_log.error("Error buscarConfiguracionPerfilador " + e.toString());
		}
		return configuracionPerfilador;
	}

	/**
	 * Convertir configuracion bean. Fecha: 24/06/2013
	 * 
	 * @param configuracionPerfilador the configuracion perfilador
	 * @return the variable perfilador bean
	 */
	public VariablePerfiladorBean convertirConfiguracionBean(ConfiguracionPerfilador configuracionPerfilador) {

		VariablePerfiladorBean varBean = new VariablePerfiladorBean();
		varBean.setCodigoClasificacion(configuracionPerfilador.getCodigoClasificacion().intValue());
		varBean.setCodigoPadre(configuracionPerfilador.getCodigoVariablePadre());
		varBean.setEstado(configuracionPerfilador.getEstado());
		varBean.setIdVariablePerfilador(configuracionPerfilador.getIdConfiguracionPerfilador());
		varBean.setNombre(configuracionPerfilador.getNombreVariable());
		varBean.setTipoVariable(String.valueOf(configuracionPerfilador.getTipoVariable()));
		varBean.setValor1(configuracionPerfilador.getValor1());
		varBean.setValor2(configuracionPerfilador.getValor2());
		varBean.setValor3(configuracionPerfilador.getValor3());

		return varBean;
	}

	/**
	 * Obtiene respuesta perfilador bean. Fecha: 24/06/2013
	 * 
	 * @return respuesta perfilador bean
	 */
	public VariablePerfiladorBean getRespuestaPerfiladorBean() {
		try {
			if (respuestaPerfiladorBean == null || respuestaPerfiladorBean.getIdVariablePerfilador() == 0) {
				respuestaPerfiladorBean = generarRespuestaPerfiladorBean();
				this.setRespuestaPerfiladorBean(respuestaPerfiladorBean);
			}
		} catch (Exception e) {
			_log.error("Error getRespuestaPerfiladorBean " + e.toString());
		}
		return respuestaPerfiladorBean;
	}

	/**
	 * Obtiene id respuesta actual. Fecha: 24/06/2013
	 * 
	 * @return id respuesta actual
	 */
	public Long getIdRespuestaActual() {
		return idRespuestaActual;
	}

	/**
	 * Establece el id respuesta actual.
	 * 
	 * @param idRespuestaActual el new id respuesta actual
	 */
	public void setIdRespuestaActual(Long idRespuestaActual) {
		this.idRespuestaActual = idRespuestaActual;
	}

	/**
	 * Inicializar pregunta. Fecha: 24/06/2013
	 * 
	 * @param var the var
	 */
	public void inicializarPregunta(VariablePerfiladorBean var) {
		var.setNombre("");
		var.setEstado(Integer.valueOf(COD_PERFILADOR_ACTIVO));
		var.setCodigoClasificacion(10);
		var.setValor1("");
		var.setValor2("");
		var.setValor3("");
	}

	/**
	 * Inicializar respuesta. Fecha: 24/06/2013
	 * 
	 * @param var the var
	 */
	public void inicializarRespuesta(VariablePerfiladorBean var) {
		var.getRespuestaAsociada().setNombre("");
		var.getRespuestaAsociada().setEstado(Integer.valueOf(COD_PERFILADOR_ACTIVO));
		var.getRespuestaAsociada().setValor1("");
		var.getRespuestaAsociada().setValor2("");
	}

	public List<String> validarVariablePregunta(VariablePerfiladorBean variable) {
		List<String> listaErrores = new ArrayList<String>();
		_log.info("TIPO " + variable.getCodigoClasificacion());
		boolean validarRangos = true;
		boolean validarIncremento = true;
		boolean validarDiferencia = true;

		if (Validator.isNull(variable.getNombre()) || variable.getNombre().equals("")) {
			listaErrores.add(PortletProps.get("mensaje.error.nombre.pregunta"));
		}

		if (variable.getCodigoClasificacion() == 10) {
			_log.info("TIPO 2 " + variable.getCodigoClasificacion());
			//Valor Inicial
			if (Validator.isNull(variable.getValor1()) || variable.getValor1().equals("")) {
				listaErrores.add(PortletProps.get("mensaje.error.rango.inicial.pregunta"));
				validarRangos = false;
			} else if (!(ValidatorUtils.isNumber(variable.getValor1()) || isNegativo(variable.getValor1()))) {
				listaErrores.add(PortletProps.get("mensaje.error.rango.inicial.pregunta.formato"));
				validarRangos = false;
			} else if (!(Integer.valueOf(variable.getValor1()) >= 0)) {
				_log.info(Integer.valueOf(variable.getValor1()));
				listaErrores.add(PortletProps.get("mensaje.error.valor.inicial.positivo"));
				validarRangos = false;
			}
			
			//Valor Final
			if (Validator.isNull(variable.getValor2()) || variable.getValor2().equals("")) {
				listaErrores.add(PortletProps.get("mensaje.error.rango.final.pregunta"));
				validarRangos = false;
			} else if (!(ValidatorUtils.isNumber(variable.getValor2()) || isNegativo(variable.getValor2()))) {
				listaErrores.add(PortletProps.get("mensaje.error.rango.final.pregunta.formato"));
				validarRangos = false;
			} else if (!(Integer.valueOf(variable.getValor2()) >= 0)) {
				listaErrores.add(PortletProps.get("mensaje.error.valor.final.positivo"));
				validarRangos = false;
			}

			if (validarRangos) {
				if (Integer.valueOf(variable.getValor1()) >= Integer.valueOf(variable.getValor2())) {
					listaErrores.add(PortletProps.get("mensaje.error.monto.inicial.mayor.final"));
					validarDiferencia = false;
				}
			}
			//Incremento
			if (Validator.isNull(variable.getValor3()) || variable.getValor3().equals("")) {
				listaErrores.add(PortletProps.get("mensaje.error.rango.incremento.pregunta"));
				validarIncremento = false;
			} else if (!(ValidatorUtils.isNumber(variable.getValor3()) || isNegativo(variable.getValor3()))) {
				listaErrores.add(PortletProps.get("mensaje.error.rango.incremento.pregunta.formato"));
				validarIncremento = false;
			} else if (!ValidatorUtils.isMayor_0(Integer.valueOf(variable.getValor3()))) {
				listaErrores.add(PortletProps.get("mensaje.error.incremento.positivo"));
				validarIncremento = false;
			} 
			
			if (validarRangos && validarIncremento && validarDiferencia) {
				if((Integer.valueOf(variable.getValor2()) - Integer.valueOf(variable.getValor1())) < Integer.valueOf(variable.getValor3())){
					listaErrores.add(PortletProps.get("mensaje.error.valor.diferencia.final.inicial.mayor.incremento"));
				}
			}

		}

		return listaErrores;
	}

	public List<String> validarVariableRespuesta(VariablePerfiladorBean variable) {
		List<String> listaErrores = new ArrayList<String>();
		boolean validarRangos = true;

		if (variable.getCodigoClasificacion() == 10) {
			if (Validator.isNull(variable.getRespuestaAsociada().getValor1()) || variable.getRespuestaAsociada().getValor1().equals("")) {
				listaErrores.add(PortletProps.get("mensaje.error.monto.inicial.respuesta"));
				validarRangos = false;
			} else if (!(ValidatorUtils.isNumber(variable.getRespuestaAsociada().getValor1()) || isNegativo(variable.getRespuestaAsociada().getValor1()))) {
				listaErrores.add(PortletProps.get("mensaje.error.monto.inicial.respuesta.formato"));
				validarRangos = false;
			} else if (!(Integer.valueOf(variable.getRespuestaAsociada().getValor1()) >= 0)) {
				listaErrores.add(PortletProps.get("mensaje.error.valor.inicial.positivo"));
				validarRangos = false;
			} else if (Integer.valueOf(variable.getValor1()) > Integer.valueOf(variable.getRespuestaAsociada().getValor1())) {
				listaErrores.add(PortletProps.get("mensaje.error.valor.inicial.padre.menor.valor.inicial.respuesta"));
				validarRangos = false;
			} else if (Integer.valueOf(variable.getValor2()) < Integer.valueOf(variable.getRespuestaAsociada().getValor1())) {
				listaErrores.add(PortletProps.get("mensaje.error.valor.inicial.menor.rango.pregunta"));
				validarRangos = false;
			}
			
			if (Validator.isNull(variable.getRespuestaAsociada().getValor2()) || variable.getRespuestaAsociada().getValor2().equals("")) {
				listaErrores.add(PortletProps.get("mensaje.error.monto.final.respuesta"));
				validarRangos = false;
			} else if (!(ValidatorUtils.isNumber(variable.getRespuestaAsociada().getValor2()) || isNegativo(variable.getRespuestaAsociada().getValor2()))) {
				listaErrores.add(PortletProps.get("mensaje.error.monto.final.respuesta.formato"));
				validarRangos = false;
			} else if (!(Integer.valueOf(variable.getRespuestaAsociada().getValor2()) >= 0)) {
				listaErrores.add(PortletProps.get("mensaje.error.valor.final.positivo"));
				validarRangos = false;
			} else if (Integer.valueOf(variable.getValor2()) < Integer.valueOf(variable.getRespuestaAsociada().getValor2())) {
				listaErrores.add(PortletProps.get("mensaje.error.valor.final.hijo.mayor.valor.final.respuesta"));
				validarRangos = false;
			} else if (Integer.valueOf(variable.getValor1()) > Integer.valueOf(variable.getRespuestaAsociada().getValor2())) {
				listaErrores.add(PortletProps.get("mensaje.error.valor.final.mayor.rango.pregunta"));
				validarRangos = false;
			}

			if (validarRangos) {
				if (Integer.valueOf(variable.getRespuestaAsociada().getValor1()) >= Integer.valueOf(variable.getRespuestaAsociada().getValor2())) {
					listaErrores.add(PortletProps.get("mensaje.error.monto.inicial.mayor.final"));
				} 
//					else {
//					if (Integer.valueOf(variable.getValor1()) > Integer.valueOf(variable.getRespuestaAsociada().getValor1())) {
//						listaErrores.add(PortletProps.get("mensaje.error.valor.inicial.padre.menor.valor.inicial.respuesta"));
//					}
//					if (Integer.valueOf(variable.getValor2()) < Integer.valueOf(variable.getRespuestaAsociada().getValor2())) {
//						listaErrores.add(PortletProps.get("mensaje.error.valor.final.hijo.mayor.valor.final.respuesta"));
//					}
//				}

			}

		} else {
			if (Validator.isNull(variable.getRespuestaAsociada().getNombre()) || variable.getRespuestaAsociada().getNombre().equals("")) {
				listaErrores.add(PortletProps.get("mensaje.error.nombre.respuesta"));
			}
		}

		return listaErrores;
	}

	public VariablePerfiladorBean obtenerPreguntaBean() {
		VariablePerfiladorBean pregunta = new VariablePerfiladorBean();
		if (this.getIdPreguntaActual() != null && this.getIdPreguntaActual() > 0) {

		}
		return pregunta;
	}
	
	public boolean isNegativo(String valor){
		if (valor.startsWith("-") && ValidatorUtils.isNumber(valor.substring(1, valor.length()))){
			return true;
		}
		return false;
	}

	// public VariablePerfiladorBean generarRespuestaPerfiladorBean() throws Exception {
	// VariablePerfiladorBean varBean = new VariablePerfiladorBean();
	// if (this.getIdPreguntaActual() != null && this.getIdPreguntaActual() > 0) {
	// ConfiguracionPerfilador conf = this.buscarConfiguracionPerfilador(this
	// .getIdPreguntaActual());
	// varBean = this.convertirConfiguracionBean(conf);
	// varBean.setRespuestaAsociada(new VariablePerfiladorBean());
	// varBean.getRespuestaAsociada().setEstado(Integer.valueOf(COD_PERFILADOR_ACTIVO));
	// }
	// return varBean;
	// }
}
