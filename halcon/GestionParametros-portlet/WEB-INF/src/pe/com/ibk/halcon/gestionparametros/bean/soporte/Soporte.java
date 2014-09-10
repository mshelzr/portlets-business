package pe.com.ibk.halcon.gestionparametros.bean.soporte;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import pe.com.ibk.halcon.gestionparametros.criterio.CriterioListarParametro;
import pe.com.ibk.halcon.gestionparametros.criterio.LabelFormParametros;
import pe.com.ibk.halcon.gestionparametros.dto.EstadoParametroDTO;
import pe.com.ibk.halcon.gestionparametros.dto.TipoValorDTO;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.LogErrorUtil;
import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.Parametro;
import com.ext.portlet.halcon.service.ParametroLocalServiceUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class Soporte.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public class Soporte {
	
	/** The _log. */
	private Log _log = LogFactoryUtil.getLog(Soporte.class);

	/** The Constant PARAMETRO_ACTIVO. */
	public final static int PARAMETRO_ACTIVO = 1;
	
	/** The Constant PARAMETRO_INACTIVO. */
	public final static int PARAMETRO_INACTIVO = 0;
	
	/** The Constant PARAMETRO_TIPO_VALOR_NUMERICO. */
	public final static int PARAMETRO_TIPO_VALOR_NUMERICO = 1;
	
	/** The Constant PARAMETRO_TIPO_VALOR_CADENA. */
	public final static int PARAMETRO_TIPO_VALOR_CADENA = 2;
	
	/** The Constant MASK_PORCENTAJE. */
	public final static String MASK_PORCENTAJE = "%";
	
	/** The Constant PARAMETRO_TIPO_RANGO. */
	public final static int PARAMETRO_TIPO_RANGO = 10;
	
	/** The Constant PARAMETRO_TIPO_LISTA. */
	public final static int PARAMETRO_TIPO_LISTA = 20;
	
	/** The Constant PARAMETRO_TIPO_VALOR. */
	public final static int PARAMETRO_TIPO_VALOR = 30;
	
	/** The Constant PROPERTIES_PORTLET. */
	public final static String PROPERTIES_PORTLET = "content.Language";
	
	
	/** The db lista padre parametro. */
	private List<Parametro> dbListaPadreParametro;
	
	/** The db lista estado parametro. */
	private List<EstadoParametroDTO> dbListaEstadoParametro;
	
	/** The db lista tipo valor parametro. */
	private List<TipoValorDTO> dbListaTipoValorParametro;

	/**
	 * Obtiene db lista padre parametro.
	 * Fecha: 22/08/2013
	 *
	 * @return db lista padre parametro
	 */
	public List<Parametro> getDbListaPadreParametro() {
		if (dbListaPadreParametro == null) {
			try {
				dbListaPadreParametro = ParametroLocalServiceUtil.obtenerParametroListaPadre();
			} catch (BusinessException e) {
				String asunto = Propiedades.getResourceBundle("gestion.parametros.soporte.get.db.lista.padre.parametro");
				LogErrorUtil.registrarError(JSonUtil.NO_EXISTE_PARAMETRO, e.getTrazaMessage(), asunto);
				_log.error(asunto+e.toString());
			}
		}
		return dbListaPadreParametro;
	}

	/**
	 * Establece el db lista padre parametro.
	 *
	 * @param dbListaPadreParametro el new db lista padre parametro
	 */
	public void setDbListaPadreParametro(List<Parametro> dbListaPadreParametro) {
		this.dbListaPadreParametro = dbListaPadreParametro;
	}
	
	/**
	 * Obtiene db lista estado parametro.
	 * Fecha: 22/08/2013
	 *
	 * @return db lista estado parametro
	 */
	public List<EstadoParametroDTO> getDbListaEstadoParametro() {
		if (dbListaEstadoParametro == null) {
			dbListaEstadoParametro = new ArrayList<EstadoParametroDTO>();
			dbListaEstadoParametro.add(new EstadoParametroDTO(PARAMETRO_INACTIVO, "INACTIVO"));
			dbListaEstadoParametro.add(new EstadoParametroDTO(PARAMETRO_ACTIVO, "ACTIVO"));
		}
		return dbListaEstadoParametro;
	}

	/**
	 * Establece el db lista estado parametro.
	 *
	 * @param dbListaEstadoParametro el new db lista estado parametro
	 */
	public void setDbListaEstadoParametro(List<EstadoParametroDTO> dbListaEstadoParametro) {
		this.dbListaEstadoParametro = dbListaEstadoParametro;
	}

	/**
	 * Obtiene db lista tipo valor parametro.
	 * Fecha: 22/08/2013
	 *
	 * @return db lista tipo valor parametro
	 */
	public List<TipoValorDTO> getDbListaTipoValorParametro() {
		if (dbListaTipoValorParametro == null) {
			dbListaTipoValorParametro = new ArrayList<TipoValorDTO>();
			dbListaTipoValorParametro.add(new TipoValorDTO(PARAMETRO_TIPO_VALOR_NUMERICO, "Numérico"));
			dbListaTipoValorParametro.add(new TipoValorDTO(PARAMETRO_TIPO_VALOR_CADENA, "Texto"));
		}
		return dbListaTipoValorParametro;
	}

	/**
	 * Establece el db lista tipo valor parametro.
	 *
	 * @param dbListaTipoValorParametro el new db lista tipo valor parametro
	 */
	public void setDbListaTipoValorParametro(List<TipoValorDTO> dbListaTipoValorParametro) {
		this.dbListaTipoValorParametro = dbListaTipoValorParametro;
	}
	
	/**
	 * Obtener resource bundle.
	 * Fecha: 22/08/2013
	 *
	 * @return the resource bundle
	 */
	public static ResourceBundle obtenerResourceBundle() {
		return ResourceBundle.getBundle(PROPERTIES_PORTLET);
	}
	
	/**
	 * Obtener parametro nuevo.
	 * Fecha: 22/08/2013
	 *
	 * @return the parametro
	 * @throws Exception the exception
	 */
	public Parametro obtenerParametroNuevo() throws Exception {
		return ParametroLocalServiceUtil.getInstance();
	}

	/**
	 * Obtener lista parametro.
	 * Fecha: 22/08/2013
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Parametro> obtenerListaParametro() throws Exception {
		return ParametroLocalServiceUtil.listarParametro();
	}

	/**
	 * Adicionar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @param parametro the parametro
	 * @return the parametro
	 * @throws Exception the exception
	 */
	public Parametro adicionarParametro(Parametro parametro) throws Exception  {
		parametro = ParametroLocalServiceUtil.addParametro(parametro);
		this.clearCache();		
		return parametro;
	}

	/**
	 * Actualizar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @param parametro the parametro
	 * @return the parametro
	 * @throws Exception the exception
	 */
	public Parametro actualizarParametro(Parametro parametro) throws Exception {
		Parametro paramReturn = ParametroLocalServiceUtil.updateParametro(parametro, false);
		this.clearCache();
		return paramReturn;
	}

	/**
	 * Eliminar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @param idParametro the id parametro
	 * @throws Exception the exception
	 */
	public void eliminarParametro(Integer idParametro) throws Exception {
		ParametroLocalServiceUtil.deleteParametro(idParametro);
		this.clearCache();
	}
	
	/**
	 * Obtener parametro.
	 * Fecha: 22/08/2013
	 *
	 * @param idParametro the id parametro
	 * @return the parametro
	 * @throws Exception the exception
	 */
	public Parametro obtenerParametro(Integer idParametro) throws Exception {
		return ParametroLocalServiceUtil.getParametro(idParametro);
	}
	
	/**
	 * Obtener parametros hijos.
	 * Fecha: 22/08/2013
	 *
	 * @param idParametroPadre the id parametro padre
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Parametro> obtenerParametrosHijos(Integer idParametroPadre) throws Exception {
		return ParametroLocalServiceUtil.obtenerParametrosHijos(idParametroPadre);
	}
	
	/**
	 * Obtener parametros por tipo.
	 * Fecha: 22/08/2013
	 *
	 * @param criterioListarParametro the criterio listar parametro
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Parametro> obtenerParametrosPorTipo(CriterioListarParametro criterioListarParametro) throws Exception {
		return ParametroLocalServiceUtil.obtenerParametrosPorTipo(criterioListarParametro.getParametro().getNum2());
	}
	
	/**
	 * Obtener parametros por descripcion.
	 * Fecha: 22/08/2013
	 *
	 * @param descParametro the desc parametro
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Parametro> obtenerParametrosPorDescripcion(String descParametro) throws Exception {
		ParametroLocalServiceUtil.obtenerParametrosPorDescripcion(Soporte.MASK_PORCENTAJE + "DESCRIPCION RANGO 1" + Soporte.MASK_PORCENTAJE ,null);
		return ParametroLocalServiceUtil.obtenerParametrosPorDescripcion(Soporte.MASK_PORCENTAJE + descParametro + Soporte.MASK_PORCENTAJE);
	}
	
	/**
	 * Obtener parametros por descripcion.
	 * Fecha: 22/08/2013
	 *
	 * @param descParametro the desc parametro
	 * @param descParametroPadre the desc parametro padre
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Parametro> obtenerParametrosPorDescripcion(String descParametro, String descParametroPadre) throws Exception {
		return ParametroLocalServiceUtil.obtenerParametrosPorDescripcion(Soporte.MASK_PORCENTAJE + descParametro + Soporte.MASK_PORCENTAJE, Soporte.MASK_PORCENTAJE + descParametroPadre + Soporte.MASK_PORCENTAJE);
	}
	
	/**
	 * Cambiar parametro estado.
	 * Fecha: 22/08/2013
	 *
	 * @param idParametro the id parametro
	 * @param estado the estado
	 */
	public void cambiarParametroEstado(Integer idParametro, Integer estado) {
		try {
			ParametroLocalServiceUtil.cambiarParametroEstado(idParametro, estado);
			this.clearCache();
		} catch (BusinessException e) {
			String asunto = Propiedades.getResourceBundle("gestion.parametros.soporte.cambiar.parametro.estado");
			LogErrorUtil.registrarError(String.format("{idParametro:%s,estado:%s}", idParametro,estado), e.getTrazaMessage(), asunto);
			_log.error(asunto+e.toString());
		}
	}
	
	/**
	 * Obtener etiquetas parametros.
	 * Fecha: 22/08/2013
	 *
	 * @param idParametroPadre the id parametro padre
	 * @return the label form parametros
	 */
	public LabelFormParametros obtenerEtiquetasParametros(Integer idParametroPadre){
		LabelFormParametros bean = new LabelFormParametros();
		try {
			Parametro parametro = ParametroLocalServiceUtil.getParametro(idParametroPadre);
			if(parametro.getNum2() == PARAMETRO_TIPO_LISTA || parametro.getNum2() == PARAMETRO_TIPO_RANGO){
				String dato4Parametro = parametro.getDato4();

				JSONArray jsonArray = JSONFactoryUtil.createJSONArray(dato4Parametro.toString());
			    for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject obj = jsonArray.getJSONObject(i);
					bean.setLabelParmDato1(obj.getString("parm_Dato1"));
					bean.setLabelParmDato2(obj.getString("parm_Dato2"));
					bean.setLabelParmNum1(obj.getString("parm_Num1"));
					bean.setLabelParmNum2(obj.getString("parm_Num2"));
					bean.setLabelParmNum3(obj.getString("parm_Num3"));
					bean.setLabelParmValorMonto1(obj.getString("parm_ValorMonto1"));
					bean.setLabelParmValorMonto2(obj.getString("parm_ValorMonto2"));
					bean.setLabelParmValorMonto3(obj.getString("parm_ValorMonto3"));
					bean.setLabelParmDato4(obj.getString("parm_Dato4"));
				}
			}
			
		} catch (Exception e) {
			_log.error(e.toString());
		}
		
		return bean;
	}
	
	private void clearCache(){
		MultiVMPoolUtil.clear("com.ext.portlet.halcon.model.Parametro");
		MultiVMPoolUtil.clear("pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil");
		MultiVMPoolUtil.clear("pe.com.interbank.halcon.visualizar.cache.util.CacheVisualizarUtil");
		MultiVMPoolUtil.clear("pe.com.ibk.halcon.simulacion.cache.util.CacheSimulacionUtil");
		MultiVMPoolUtil.clear("pe.com.ibk.halcon.solicitudes.cache.util.CacheSolicitudesUtil");
		MultiVMPoolUtil.clear("pe.com.ibk.halcon.perfilador.cache.util.CachePerfiladorUtil");
		MultiVMPoolUtil.clear("pe.com.ibk.halcon.denuncia.cache.util.CacheDenunciaUtil");
		MultiVMPoolUtil.clear("pe.com.ibk.halcon.contenidoweb.cache.util.CacheContenidoUtil");
	}
}
