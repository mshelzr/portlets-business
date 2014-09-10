package pe.com.ibk.halcon.perfilador.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ResourceRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.ibk.halcon.perfilador.bean.ProductoBean;
import pe.com.ibk.halcon.perfilador.bean.VariableJsonBean;
import pe.com.ibk.halcon.perfilador.bean.VariablePerfiladorBean;
import pe.com.ibk.halcon.perfilador.cache.util.CachePerfiladorUtil;
import pe.com.ibk.halcon.perfilador.service.PerfiladorProductoService;

import com.exp.portlet.halcon.utils.FriendlyURLGenerator;
import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.LogErrorUtil;
import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.AuditoriaPerfilador;
import com.ext.portlet.halcon.model.ConfiguracionPerfilador;
import com.ext.portlet.halcon.model.ConfiguracionProducto;
import com.ext.portlet.halcon.service.AuditoriaPerfiladorLocalServiceUtil;
import com.ext.portlet.halcon.service.ClpSerializer;
import com.ext.portlet.halcon.service.ConfiguracionPerfiladorLocalServiceUtil;
import com.ext.portlet.halcon.service.ConfiguracionProductoLocalServiceUtil;
import com.ext.portlet.halcon.service.SolicitudProductoLocalServiceUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.webserver.WebServerServletTokenUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.util.portlet.PortletProps;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class PerfiladorProductoServiceImpl.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 24/06/2013
 * @version Halcon 1.0
 */
@Service
public class PerfiladorProductoServiceImpl implements PerfiladorProductoService {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(PerfiladorProductoServiceImpl.class);

	/** The Constant COD_PREGUNTA. */
	private static final String COD_PREGUNTA = PortletProps.get("parametros.code.pregunta");

	/** The Constant COD_RESPUESTA. */
	private static final String COD_RESPUESTA = PortletProps.get("parametros.code.respuesta");

	/** The Constant COD_PERFILADOR_ACTIVO. */
	private static final String COD_PERFILADOR_ACTIVO = PortletProps.get("parametros.code.estado.activo");

	/** The Constant COD_PERFILADOR_HIPOTECARIO. */
	private static final String COD_PERFILADOR_HIPOTECARIO = PortletProps.get("parametros.code.perfilador.hipotecario");

	/** The Constant COD_PERFILADOR_CUENTA_AHORRO. */
	private static final String COD_PERFILADOR_CUENTA_AHORRO = PortletProps.get("parametros.code.perfilador.cuenta.ahorro");

	/** The Constant COD_PERFILADOR_TARJETA_CREDITO. */
	private static final String COD_PERFILADOR_TARJETA_CREDITO = PortletProps.get("parametros.code.perfilador.tarjeta.credito");

	/** The Constant COD_PERFILADOR_SEGURO. */
	private static final String COD_PERFILADOR_SEGURO = PortletProps.get("parametros.code.perfilador.seguro");

	@Autowired
	private CachePerfiladorUtil cachePerfiladorUtil;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.com.ibk.halcon.perfilador.service.PerfiladorProductoService#convertirBeanVariable(com.
	 * ext.portlet.halcon.model.ConfiguracionPerfilador)
	 */
	public VariablePerfiladorBean convertirBeanVariable(ConfiguracionPerfilador conf) {

		VariablePerfiladorBean variable = new VariablePerfiladorBean();
		variable.setIdVariablePerfilador(conf.getIdConfiguracionPerfilador());
		variable.setCodigoPadre(conf.getCodigoVariablePadre());
		variable.setCodigoClasificacion(conf.getCodigoClasificacion().intValue());
		variable.setNombre(conf.getNombreVariable());
		variable.setTipoVariable(conf.getTipoVariable() == 1l ? "P" : "R");
		variable.setValor1(conf.getValor1());
		variable.setValor2(conf.getValor2());
		variable.setValor3(conf.getValor3());

		return variable;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.com.ibk.halcon.perfilador.service.PerfiladorProductoService#convertirListadoPerfilador
	 * (java.util.List, java.lang.String)
	 */
	public void convertirListadoPerfilador(List<VariablePerfiladorBean> listaVariables, String codTipoPerfilador) {

		try {

			for (VariablePerfiladorBean var : listaVariables) {
				int codigoClas = var.getCodigoClasificacion();
				String tipoPer = "";

				switch (codigoClas) {

				case 10: // Slider
					if (codTipoPerfilador.equals(COD_PERFILADOR_HIPOTECARIO)) {
						tipoPer = (String) cachePerfiladorUtil.getValor(JSonUtil.ETIQUETA_DEFAULT_SLIDER_PERFILADOR_HIPOTECARIO);
					} else if (codTipoPerfilador.equals(COD_PERFILADOR_CUENTA_AHORRO)) {
						tipoPer = (String) cachePerfiladorUtil.getValor(JSonUtil.ETIQUETA_DEFAULT_SLIDER_PERFILADOR_AHORRRO);
					} else if (codTipoPerfilador.equals(COD_PERFILADOR_SEGURO)) {
						tipoPer = (String) cachePerfiladorUtil.getValor(JSonUtil.ETIQUETA_DEFAULT_SLIDER_PERFILADOR_SEGURO);
					} else if (codTipoPerfilador.equals(COD_PERFILADOR_TARJETA_CREDITO)) {
						tipoPer = (String) cachePerfiladorUtil.getValor(JSonUtil.ETIQUETA_DEFAULT_SLIDER_PERFILADOR_TARJETA);
					}
					// buscar valor por defecto
					if(tipoPer != null && !tipoPer.equals("")){
					var.setIdRangoActual(Long.valueOf(tipoPer));
					}
				case 20: // Combo
					generarJSonListadoCombo(var);
					break;
				case 30: // Listado Vertical con imagenes
					generarJSonListadoVertical(var);
					break;
				case 40: // Listado Horizontal
					generarJSonListadoHorizontal(var);
					break;
				default:
					break;
				}
			}

		} catch (Exception e) {
			_log.error("Error en la conversion de Respuestas a Formato Json" + e.toString());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.com.ibk.halcon.perfilador.service.PerfiladorProductoService#obtenerListadoProductos(java
	 * .lang.Long, javax.portlet.ResourceRequest)
	 */
	public List<ProductoBean> obtenerListadoProductos(Long idConfiguracionPerfilador, ResourceRequest renderRequest) {

		List<ConfiguracionProducto> listaProductos;
		List<ProductoBean> listaProdBean = null;
		try {
			listaProductos = ConfiguracionProductoLocalServiceUtil.obtenerProductoConfiguracionPerfilador(idConfiguracionPerfilador);
			listaProdBean = obtenerContenidoProductos(listaProductos, renderRequest);
		} catch (BusinessException e) {
			String asunto = Propiedades.getResourceBundle("perfilador.productos.perfilador.producto.serviceimpl.obtener.listado.productos");
			LogErrorUtil.registrarError(JSonUtil.getStringJson(idConfiguracionPerfilador), e.getTrazaMessage(), asunto);
			_log.error(Propiedades.getResourceBundle("perfilador.productos.perfilador.producto.serviceimpl.obtener.listado.productos") + e.toString());
		}

		return listaProdBean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.com.ibk.halcon.perfilador.service.PerfiladorProductoService#guardarDatosPerfilador(java
	 * .lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, double,
	 * java.lang.String, java.lang.String, java.util.Date, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	public void guardarDatosPerfilador(String tipoDoc, String numeroDoc, String perfilador, String sesion, String transaccion, double monto, String tipoCredito, String ip, String pregunta1,
			String pregunta2, String pregunta3, String pregunta4, String respuesta1, String respuesta2, String respuesta3, String respuesta4, Date fechaHora, String UTMSource, String UTMMedium,
			String UTMCampaign, String UTMContent) {

		_log.info("guardarDatosPerfilador");
		AuditoriaPerfilador auditoria = null;
		try {
			auditoria = AuditoriaPerfiladorLocalServiceUtil.getInstance();
			auditoria.setTipoDocumento(tipoDoc);
			auditoria.setNumeroDocumento(numeroDoc);
			auditoria.setPerfilador(perfilador);
			auditoria.setSession(sesion);
			auditoria.setTransaccion(transaccion);
			auditoria.setMonto(monto);
			auditoria.setTipoCredito(tipoCredito);
			auditoria.setIP(ip);
			auditoria.setFechaHora(fechaHora);
			auditoria.setUTMSource(UTMSource);
			auditoria.setUTMMedium(UTMMedium);
			auditoria.setUTMCampaing(UTMCampaign);
			auditoria.setUTMContent(UTMContent);
			auditoria.setPregunta01(pregunta1);
			auditoria.setPregunta02(pregunta2);
			auditoria.setPregunta03(pregunta3);
			auditoria.setPregunta04(pregunta4);
			auditoria.setRespuesta01(respuesta1);
			auditoria.setRespuesta02(respuesta2);
			auditoria.setRespuesta03(respuesta3);
			auditoria.setRespuesta04(respuesta4);
			AuditoriaPerfiladorLocalServiceUtil.insert(auditoria);

		} catch (BusinessException e) {
			String asunto = Propiedades.getResourceBundle("perfilador.productos.perfilador.producto.serviceimpl.guardar.datos.perfilador");
			LogErrorUtil.registrarError(JSonUtil.getStringJson(auditoria), e.getTrazaMessage(), asunto);
			_log.error(Propiedades.getResourceBundle("perfilador.productos.perfilador.producto.serviceimpl.guardar.datos.perfilador") + e.toString());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.com.ibk.halcon.perfilador.service.PerfiladorProductoService#obtenerListadoPreguntasPerfilador
	 * (java.lang.Long, int)
	 */
	@SuppressWarnings("unchecked")
	public List<VariablePerfiladorBean> obtenerListadoPreguntasPerfilador(Long idPerfiladorProd, int topLevel) {

		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
		List<VariablePerfiladorBean> lstVariable = new ArrayList<VariablePerfiladorBean>();
		List<ConfiguracionPerfilador> variableP = null;

		int it = 0;
		long idVariable = 0;

		try {

			do {

				if (it == 0) { // pregunta nivel1
					DynamicQuery consultaP = DynamicQueryFactoryUtil.forClass(ConfiguracionPerfilador.class, classLoader)
							.add(PropertyFactoryUtil.forName("idConfiguracionPerfilador").eq(idPerfiladorProd)).add(PropertyFactoryUtil.forName("estado").eq(Integer.valueOf(COD_PERFILADOR_ACTIVO)));
					variableP = ConfiguracionPerfiladorLocalServiceUtil.dynamicQuery(consultaP, 0, 1);
				} else { // pregunta nivel >1
					DynamicQuery consultaP = DynamicQueryFactoryUtil.forClass(ConfiguracionPerfilador.class, classLoader).add(PropertyFactoryUtil.forName("codigoVariablePadre").eq(idVariable))
							.add(PropertyFactoryUtil.forName("tipoVariable").eq(Long.valueOf(COD_PREGUNTA))).add(PropertyFactoryUtil.forName("estado").eq(Integer.valueOf(COD_PERFILADOR_ACTIVO)));
					variableP = ConfiguracionPerfiladorLocalServiceUtil.dynamicQuery(consultaP, 0, 1);
				}

				++it;
				_log.info("IT " + it);
				if (variableP.size() > 0) { // busqueda de rptas a la pregunta
					idVariable = this.obtenerListadoRespuestas(variableP, classLoader, idVariable, lstVariable, it);
				}

			} while (it < topLevel && idVariable > 0);

		} catch (Exception e) {
			_log.error(e.toString());
		}

		return lstVariable;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.com.ibk.halcon.perfilador.service.PerfiladorProductoService#
	 * actualizarListadoPreguntasPerfilador(java.lang.Long, int)
	 */
	@SuppressWarnings("unchecked")
	public List<VariablePerfiladorBean> actualizarListadoPreguntasPerfilador(Long idVariable, int nivel) {

		List<ConfiguracionPerfilador> variableP = null;
		int nivelF = 3 - nivel;
		List<VariablePerfiladorBean> lstVariable = new ArrayList<VariablePerfiladorBean>();

		try {

			ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");

			do {

				DynamicQuery consultaP = DynamicQueryFactoryUtil.forClass(ConfiguracionPerfilador.class, classLoader).add(PropertyFactoryUtil.forName("codigoVariablePadre").eq(idVariable))
						.add(PropertyFactoryUtil.forName("tipoVariable").eq(Long.valueOf(COD_PREGUNTA))).add(PropertyFactoryUtil.forName("estado").eq(Integer.valueOf(COD_PERFILADOR_ACTIVO)));
				variableP = ConfiguracionPerfiladorLocalServiceUtil.dynamicQuery(consultaP, 0, 1);

				if (variableP.size() > 0) { // si existe pregunta
					idVariable = this.obtenerListadoRespuestas(variableP, classLoader, idVariable, lstVariable, ++nivel);
				}

				nivelF--;

			} while (nivelF > 0);

		} catch (Exception e) {
			// TODO: handle exception
			_log.error("Error al actualizar listado de Componenter Perfilador " + e.toString());
		}

		return lstVariable;
	}

	/**
	 * Obtener listado respuestas. Fecha: 24/06/2013
	 * 
	 * @param variableP the variable p
	 * @param classLoader the class loader
	 * @param idVariable the id variable
	 * @param lstVariable the lst variable
	 * @param it the it
	 * @return the long
	 */
	@SuppressWarnings("unchecked")
	private long obtenerListadoRespuestas(List<ConfiguracionPerfilador> variableP, ClassLoader classLoader, long idVariable, List<VariablePerfiladorBean> lstVariable, int it) {

		VariablePerfiladorBean varBean;
		List<ConfiguracionPerfilador> respuestas = null;

		try {

			ConfiguracionPerfilador preg = variableP.get(0);
			varBean = this.convertirBeanVariable(preg);
			varBean.setIdRangoActual(0L);

			_log.info("Variable Pregunta Nivel " + it + " : " + preg.getNombreVariable());

			// Buscar respuestas a la pregunta
			DynamicQuery consultaRptaPerfilador = DynamicQueryFactoryUtil.forClass(ConfiguracionPerfilador.class, classLoader)
					.add(PropertyFactoryUtil.forName("codigoVariablePadre").eq(preg.getIdConfiguracionPerfilador())).add(PropertyFactoryUtil.forName("tipoVariable").eq(Long.valueOf(COD_RESPUESTA)))
					.add(PropertyFactoryUtil.forName("estado").eq(Integer.valueOf(COD_PERFILADOR_ACTIVO)));

			respuestas = ConfiguracionPerfiladorLocalServiceUtil.dynamicQuery(consultaRptaPerfilador, -1, -1);

			idVariable = 0;
			List<VariablePerfiladorBean> lstRespuestas = new ArrayList<VariablePerfiladorBean>();
			int cont = 0;

			for (ConfiguracionPerfilador cfp : respuestas) {

				if (cont == 0) {
					idVariable = cfp.getIdConfiguracionPerfilador();
					// if(varBean.getCodigoClasificacion() == 10){
					// varBean.setIdRangoActual(idVariable);
					// }
				}
				VariablePerfiladorBean varBeanRpta = this.convertirBeanVariable(cfp);
				lstRespuestas.add(varBeanRpta);

				cont++;
				varBean.setVarAsociadas(lstRespuestas);
				_log.info("Respuestas Nivel " + it + ": " + cfp.getNombreVariable());

			}

			varBean.setNivel(it);
			lstVariable.add(varBean);

		} catch (Exception e) {
			// TODO: handle exception
			_log.error("Error al obtener Respuestas a pregunta Perfilador " + idVariable + " :" + e.toString());
		}

		return idVariable;
	}

	/**
	 * Generar j son listado horizontal. Fecha: 24/06/2013
	 * 
	 * @param var the var
	 * @throws Exception the exception
	 */
	private void generarJSonListadoHorizontal(VariablePerfiladorBean var) throws Exception {

		List<VariableJsonBean> listaJson = new ArrayList<VariableJsonBean>();
		int cont = 0;

		for (VariablePerfiladorBean resp : var.getVarAsociadas()) {
			VariableJsonBean varJson = new VariableJsonBean();
			if (cont == 0) {
				varJson.setDefecto(1);
			}
			varJson.setId(resp.getIdVariablePerfilador());
			varJson.setEtiqueta(resp.getNombre());
			varJson.setOrden(++cont);
			varJson.setTool(resp.getNombre());
			listaJson.add(varJson);
		}

		var.setRespuestasJson(listaJson);
	}

	/**
	 * Generar j son listado vertical. Fecha: 24/06/2013
	 * 
	 * @param var the var
	 * @throws Exception the exception
	 */
	private void generarJSonListadoVertical(VariablePerfiladorBean var) throws Exception {

		List<VariableJsonBean> listaJson = new ArrayList<VariableJsonBean>();
		int cont = 0;

		for (VariablePerfiladorBean resp : var.getVarAsociadas()) {
			VariableJsonBean varJson = new VariableJsonBean();
			if (cont == 0) {
				varJson.setDefecto(1);
			}
			varJson.setId(resp.getIdVariablePerfilador());
			varJson.setTitle(resp.getNombre());
			varJson.setIco("ico-perf.jpg");
			listaJson.add(varJson);
		}

		var.setRespuestasJson(listaJson);
	}

	/**
	 * Generar j son listado combo. Fecha: 24/06/2013
	 * 
	 * @param var the var
	 * @throws Exception the exception
	 */
	private void generarJSonListadoCombo(VariablePerfiladorBean var) throws Exception {

		List<VariableJsonBean> listaJson = new ArrayList<VariableJsonBean>();
		int cont = 0;

		/** Prueba **/

		// Bean Seleccione por Defecto
		VariableJsonBean varJsonSeleccione = new VariableJsonBean();
		varJsonSeleccione.setId(cont);
		varJsonSeleccione.setEtiqueta("Seleccione");
		varJsonSeleccione.setOrden(0);
		varJsonSeleccione.setDefecto(1);
		listaJson.add(varJsonSeleccione);

		for (VariablePerfiladorBean resp : var.getVarAsociadas()) {
			VariableJsonBean varJson = new VariableJsonBean();
			varJson.setId(resp.getIdVariablePerfilador());
			varJson.setEtiqueta(resp.getNombre());
			varJson.setOrden(++cont);
			listaJson.add(varJson);
		}

		var.setRespuestasJson(listaJson);

	}

	/**
	 * Obtener contenido productos. Fecha: 24/06/2013
	 * 
	 * @param listaProducto the lista producto
	 * @param resourceRequest the resource request
	 * @return the list
	 */
	private List<ProductoBean> obtenerContenidoProductos(List<ConfiguracionProducto> listaProducto, ResourceRequest resourceRequest) {

		List<ProductoBean> listaProd = new ArrayList<ProductoBean>();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId, categoryId, companyId;

		groupId = themeDisplay.getScopeGroupId();
		companyId = themeDisplay.getCompanyId();

		try {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(AssetCategory.class, PortalClassLoaderUtil.getClassLoader()).add(PropertyFactoryUtil.forName("name").like("Productos"));

			AssetCategory codassset = (AssetCategory) AssetCategoryLocalServiceUtil.dynamicQuery(query).get(0);

			categoryId = codassset.getCategoryId();
			SearchContext searchContext = SearchContextFactory.getInstance(PortalUtil.getHttpServletRequest(resourceRequest));
			List<Document> listaDoc = getLuceneContentSearch(searchContext, companyId, groupId, categoryId);
			List<JournalArticle> lstArticle = getArticulosPorDocumentos(listaDoc, themeDisplay.getLanguageId(), themeDisplay);
			_log.info("listaDoc size: " + listaDoc.size() + " SIZE lstArticle :" + lstArticle.size() + " Inicio de Busqueda: " + new Date());

			for (ConfiguracionProducto pr : listaProducto) {
				String siebel = pr.getCodigoSiebelProducto();
				for (JournalArticle art : lstArticle) {
					String idProducto = getParseValue("codigoSiebel", art, themeDisplay.getLanguageId());
					// String idVerdadero = JSonUtil.getSiebel(idProducto);
					//
					// if (Validator.isNull(idVerdadero)) {
					// idVerdadero = idProducto;
					// }

					if (siebel.equals(idProducto)) {
						_log.info("Siebel encontrado : " + siebel);
						ProductoBean pdtoDestacado = obtenerBeanProducto(art, themeDisplay, idProducto);
						if (pdtoDestacado != null) {
							listaProd.add(pdtoDestacado);
						}

					}
				}

			}
			_log.info("Fin de Busqueda: " + new Date());

		} catch (Exception e) {
			_log.error("Se produjo un error al obtener los contenidos para PErfilador " + e.toString());
		}

		return listaProd;
	}

	/**
	 * Obtiene parse value. Fecha: 24/06/2013
	 * 
	 * @param fieldname the fieldname
	 * @param article the article
	 * @param languageID the language id
	 * @return parse value
	 */
	private String getParseValue(String fieldname, JournalArticle article, String languageID) {

		String value = "";
		try {
			com.liferay.portal.kernel.xml.Document document = SAXReaderUtil.read(article.getContentByLocale(languageID));
			Node node = document.selectSingleNode("/root/dynamic-element[@name='" + fieldname + "']/dynamic-content");
			value = node.getText();
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return value;
	}

	/**
	 * Obtiene articulos por documentos. Fecha: 24/06/2013
	 * 
	 * @param listaDoc the lista doc
	 * @param languageId the language id
	 * @param themeDisplay the theme display
	 * @return articulos por documentos
	 */
	private List<JournalArticle> getArticulosPorDocumentos(List<Document> listaDoc, String languageId, ThemeDisplay themeDisplay) {
		List<JournalArticle> lstArticle = new ArrayList<JournalArticle>();

		for (Document doc : listaDoc) {
			try {
				Long classPK;
				AssetEntry assetEntry;
				JournalArticle articulo;

				classPK = Long.parseLong(doc.get(Field.ENTRY_CLASS_PK));
				assetEntry = AssetEntryLocalServiceUtil.getEntry(JournalArticle.class.getName(), classPK);
				JournalArticleResource recurso = JournalArticleResourceLocalServiceUtil.getArticleResource(assetEntry.getClassPK());
				articulo = JournalArticleLocalServiceUtil.getLatestArticle(assetEntry.getGroupId(), recurso.getArticleId());

				lstArticle.add(articulo);

			} catch (Exception e) {
				_log.error("Error obteniendo articulos por documento " + e.toString());
			}
		}

		return lstArticle;
	}

	/**
	 * Obtiene lucene content search. Fecha: 24/06/2013
	 * 
	 * @param searchContext the search context
	 * @param companyId the company id
	 * @param groupId the group id
	 * @param categoryId the category id
	 * @return lucene content search
	 */
	private List<Document> getLuceneContentSearch(SearchContext searchContext, long companyId, long groupId, long categoryId) {

		List<Document> documentos = null;
		Hits resultados;

		try {
			// Query que busca en el portal que deseemos
			BooleanQuery contextQuery = BooleanQueryFactoryUtil.create(searchContext);
			contextQuery.addRequiredTerm(Field.COMPANY_ID, companyId);
			contextQuery.addRequiredTerm(Field.GROUP_ID, groupId);

			// Querypara buscador solo JournalContents
			BooleanQuery JCQuery = BooleanQueryFactoryUtil.create(searchContext);
			JCQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, JournalArticle.class.getName());
			JCQuery.addRequiredTerm(Field.STATUS, 0);

			// Querypara buscador solo Ciertas categorias
			BooleanQuery categoriaQuery = BooleanQueryFactoryUtil.create(searchContext);
			categoriaQuery.addRequiredTerm(Field.ASSET_CATEGORY_IDS, categoryId);

			/*
			 * Query expandoQuery = StringQueryFactoryUtil
			 * .create("expando/custom_fields/destacado:si");
			 */
			// Creamos query completa para enlazar las demás obligando a que
			// el enlace sea un AND en lugar de un OR
			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);

			fullQuery.add(JCQuery, BooleanClauseOccur.MUST);
			fullQuery.add(categoriaQuery, BooleanClauseOccur.MUST);
			// fullQuery.add(expandoQuery, BooleanClauseOccur.MUST);

			// Añadimos ordenación (nombre descendente)
			Sort sort = new Sort();
			sort.setFieldName(Field.CREATE_DATE);
			sort.setType(Sort.STRING_TYPE);
			sort.setReverse(true);

			resultados = SearchEngineUtil.search(SearchEngineUtil.getDefaultSearchEngineId(), companyId, fullQuery, sort, -1, -1);
			documentos = resultados.toList();

		} catch (Exception e) {
			_log.error("Error al realizar la busqueda Lucene:" + e.toString());
		}
		return documentos;
	}

	/**
	 * Obtener bean producto. Fecha: 24/06/2013
	 * 
	 * @param art the art
	 * @param themeDisplay the theme display
	 * @param idProducto the id producto
	 * @return the producto bean
	 */
	private ProductoBean obtenerBeanProducto(JournalArticle art, ThemeDisplay themeDisplay, String idProducto) {

		ProductoBean prod = new ProductoBean();

		String idSimulador = "";
		String urlImagen = "";

		try {

			prod.setCodSiebel(idProducto);
			prod.setNombre(art.getTitle(themeDisplay.getLocale()));
			prod.setDescripcion(art.getDescription(themeDisplay.getLocale()));
			String indicaSimulador = getParseValue("indicadorSimulador", art, themeDisplay.getLanguageId());
			prod.setFlagSimulador(Boolean.valueOf(indicaSimulador));

			prod.setLinkDetalle(themeDisplay.getURLPortal() + "/" + FriendlyURLGenerator.getURLAmigable(art, themeDisplay));

			if (indicaSimulador.equals("true")) {
				idSimulador = getParseValue("identificadorSimulador", art, themeDisplay.getLanguageId());
				_log.info("identificadorSimulador " + idSimulador);
				_log.info(indicaSimulador + " enlaceSimulador " + getParseValue("enlaceSimulador", art, themeDisplay.getLanguageId()));

				String idPaginaSimulador = getParseValue("enlaceSimulador", art, themeDisplay.getLanguageId());
				Layout pAsoc = LayoutLocalServiceUtil.getLayout(themeDisplay.getScopeGroupId(), false, Long.valueOf(idPaginaSimulador.replaceAll("@public", "")));
				prod.setUrlSimulador(themeDisplay.getURLPortal() + "/" + pAsoc.getFriendlyURL().replaceAll("/", ""));

			}

			if (art.isSmallImage()) {

				if (Validator.isNotNull(art.getSmallImageURL())) {
					// si la imagen es obtenida a través de una url externa
					urlImagen = art.getSmallImageURL();
				} else {
					// si la imagen fue subida al portal
					urlImagen = themeDisplay.getPathImage() + "/journal/article?img_id=" + art.getSmallImageId() + "&t=" + WebServerServletTokenUtil.getToken(art.getSmallImageId());
				}
			}

			String linkSolicitud = getParseValue("enlaceSolicitud", art, themeDisplay.getLanguageId());
			_log.info("linkSolicitud " + linkSolicitud);
			if (Validator.isNotNull(linkSolicitud) && !linkSolicitud.equals("0")) {
				prod.setUrlSolicitud(themeDisplay.getURLPortal() + SolicitudProductoLocalServiceUtil.getURLSolicitudByEtiquetaContenido(linkSolicitud));
			}

			prod.setUrlImagen(urlImagen);
			_log.info("urlImagen: " + urlImagen + "LinkDetalle: " + prod.getLinkDetalle());

		} catch (Exception e) {
			_log.error("Error al obtener el bean del producto resultado" + e.toString());
		}

		return prod;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.com.ibk.halcon.perfilador.service.PerfiladorProductoService#obtenerIdRangoRegistrar(java
	 * .lang.String, java.lang.String)
	 */
	public Long obtenerIdRangoRegistrar(String config, String valor3) {

		Long idConfiguracionPerfilador = 0L;

		try {
			idConfiguracionPerfilador = ConfiguracionPerfiladorLocalServiceUtil.obtenerRangoValorConfiguracionPerfilador(Long.valueOf(config), Long.valueOf(valor3));

		} catch (BusinessException e) {
			String asunto = Propiedades.getResourceBundle("perfilador.productos.perfilador.producto.serviceimpl.obtener.id.rango.registrar");
			LogErrorUtil.registrarError(String.format("{config:%s,valor3:%s}", config, valor3), e.getTrazaMessage(), asunto);
			_log.error(asunto + e.toString());
		}

		return idConfiguracionPerfilador;
	}

}
