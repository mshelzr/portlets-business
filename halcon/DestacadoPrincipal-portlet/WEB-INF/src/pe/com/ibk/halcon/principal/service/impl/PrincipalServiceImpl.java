package pe.com.ibk.halcon.principal.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;

import org.apache.commons.collections.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.ibk.halcon.principal.bean.ProductoDestacadoBean;
import pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil;
import pe.com.ibk.halcon.principal.service.PrincipalService;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.SessionUtil;
import com.exp.portlet.halcon.utils.SimuladoresUtil;
import com.exp.portlet.halcon.utils.WsCampaniasServiceUtil;
import com.ext.portlet.halcon.dto.CampaniaBean;
import com.ext.portlet.halcon.dto.CampaniaRequestBean;
import com.ext.portlet.halcon.dto.CampaniaResponseBean;
import com.ext.portlet.halcon.dto.SessionBean;
import com.ext.portlet.halcon.model.Parametro;
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
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.StringQueryFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil;


// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class PrincipalServiceImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Service
public class PrincipalServiceImpl implements PrincipalService {
	 
 	/** The _log. */
 	final Log _log = LogFactoryUtil.getLog(PrincipalServiceImpl.class);
	 
 	/** The j son util. */
 	JSonUtil jSonUtil;
	
 	@Autowired
	private CacheDestacadoUtil cachejsonUtil;
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.principal.service.PrincipalService#obtenerPromociones(javax.portlet.RenderRequest, java.lang.String)
	 */
	public   List<String> obtenerPromociones(RenderRequest renderRequest,String banca){
		List<String> promociones=new ArrayList<String>();
		//Solo se llamara al WS en la banca personas
		if(banca.equalsIgnoreCase("BP")){
			SessionBean sBean;
			String doc,tipoDoc;
			
			sBean=SessionUtil.traerSession(renderRequest);
			doc="";
			tipoDoc="";
			//sBean.setIndicador(1);
			if(sBean.getIndicador()==1){
				doc=sBean.getNumDoc();
				tipoDoc=sBean.getTipoDoc();
				//Llamamos a campaña
				
				CampaniaRequestBean campaniaBean=new CampaniaRequestBean();
				
				if(Validator.isNotNull(tipoDoc)){
					campaniaBean.setTipoDocumento(SimuladoresUtil.obtenerDocumentoSiebel(Integer.parseInt(tipoDoc)));
					campaniaBean.setNumeroDocumento(doc);
				}
				campaniaBean.setCodigoCanal(String.valueOf(SimuladoresUtil.CODIGO_CANAL));
				
				try {
					promociones = (List<String>) renderRequest.getPortletSession().getAttribute(doc,PortletSession.PORTLET_SCOPE);
					if (promociones == null) {
						promociones = new ArrayList<String>();
						CampaniaResponseBean campanias = WsCampaniasServiceUtil.consultarCampania(campaniaBean);
					
					List<CampaniaBean> productos=campanias.getCampanias();
					
					
					if(productos!=null){
						for(int i=0;i<productos.size();i++){
							_log.info("Codigo:"+productos.get(i).getCodigoProducto()+" / "+productos.get(i).getDescripcionProducto()+" / "+cachejsonUtil.getSiebelEtiqueta(productos.get(i).getCodigoProducto()));
							
							promociones.add(cachejsonUtil.getSiebelEtiqueta(productos.get(i).getCodigoProducto()));
						}
							renderRequest.getPortletSession().setAttribute(doc, promociones,PortletSession.PORTLET_SCOPE);
						}
					}
				} catch (Exception e) {
					_log.info("Sucedio un error al llamar al servicio web :  "+e.getMessage());
				}
			}
		}		
		return promociones;
	}

	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.principal.service.PrincipalService#getLuceneContentSearch(com.liferay.portal.kernel.search.SearchContext, long, long, long)
	 */
	public  List<Document> getLuceneContentSearch(SearchContext searchContext, long companyId, long groupId, long categoryId){
		
		List<Document> documentos=null;
		Hits  resultados;
		
		try{
			// Query que busca en el portal que deseemos
			BooleanQuery contextQuery = BooleanQueryFactoryUtil.create(searchContext);
			contextQuery.addRequiredTerm(Field.COMPANY_ID, companyId);
			contextQuery.addRequiredTerm(Field.GROUP_ID, groupId);

			
			// Querypara buscador solo JournalContents
			BooleanQuery JCQuery = BooleanQueryFactoryUtil.create(searchContext);
			JCQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, JournalArticle.class.getName());
			JCQuery.addRequiredTerm(Field.STATUS,0 );
			  
			// Querypara buscador solo Ciertas categorias
			BooleanQuery categoriaQuery = BooleanQueryFactoryUtil.create(searchContext);
			categoriaQuery.addRequiredTerm(Field.ASSET_CATEGORY_IDS,categoryId);
			
			Query expandoQuery=StringQueryFactoryUtil.create("expando/custom_fields/destacado:si");
			// Creamos query completa para enlazar las demás obligando a que
			// el enlace sea un AND en lugar de un OR
			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);

			fullQuery.add(JCQuery , BooleanClauseOccur.MUST);
			fullQuery.add(categoriaQuery , BooleanClauseOccur.MUST);
			fullQuery.add(expandoQuery , BooleanClauseOccur.MUST);
			
			// Añadimos ordenación (nombre descendente)
			Sort sort = new Sort();
			sort.setFieldName(Field.CREATE_DATE);
			sort.setType(Sort.STRING_TYPE);
			sort.setReverse(true);   
			
			resultados=SearchEngineUtil.search(SearchEngineUtil.getDefaultSearchEngineId(),companyId, fullQuery,sort,-1,-1);
			documentos = resultados.toList();
			
		}catch(Exception e){
			_log.error("Error al realizar la busqueda Lucene:" + e.toString());
		}
		return documentos;
	}
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.principal.service.PrincipalService#getArticulosPorDocumentos(javax.portlet.RenderRequest, java.util.List, java.lang.String, com.liferay.portal.theme.ThemeDisplay)
	 */
	public Map<String,JournalArticle> getArticulosPorDocumentos(RenderRequest renderRequest, List<Document> listaDoc, String languageId, ThemeDisplay themeDisplay){
		//List<JournalArticle> lstArticle = new ArrayList<JournalArticle>();
		Map<String,JournalArticle> mapaArticulos = new HashMap<String, JournalArticle>();
		try {
			for(Document doc :  listaDoc){
				Long classPK;
				AssetEntry assetEntry ;
				JournalArticle articulo;
				
			    classPK = Long.parseLong(doc.get(Field.ENTRY_CLASS_PK));
			    assetEntry = AssetEntryLocalServiceUtil.getEntry(JournalArticle.class.getName(), classPK);							
			    JournalArticleResource recurso = JournalArticleResourceLocalServiceUtil.getArticleResource(assetEntry.getClassPK());
				articulo =JournalArticleLocalServiceUtil.getLatestArticle(assetEntry.getGroupId(), recurso.getArticleId());
				
				
				mapaArticulos.put(getParseValue("codigoSiebel", articulo,themeDisplay.getLanguageId()), articulo);
				//lstArticle.add(articulo);
				
			}
		} catch (Exception e) {
			_log.error("Error obteniendo articulos por documento " + e.toString());
		}
		
		return mapaArticulos;
	}
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.principal.service.PrincipalService#getParseValue(java.lang.String, com.liferay.portlet.journal.model.JournalArticle, java.lang.String)
	 */
	public  String getParseValue(String fieldname, JournalArticle article, String languageID) {
		
	    String value = "";
	    try {
	    	 com.liferay.portal.kernel.xml.Document document =SAXReaderUtil.read(article.getContentByLocale(languageID));
	    	 Node node = document.selectSingleNode("/root/dynamic-element[@name='"+ fieldname + "']/dynamic-content");
	         value = node.getText();
	    }
	    catch(Exception e){
	         _log.error("Error al obtener la etiqueta Siebel:"+e.getMessage());
	    }	 
	    return value;
	}
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.principal.service.PrincipalService#obtenerBeanDestacado(com.liferay.portlet.journal.model.JournalArticle, com.liferay.portal.theme.ThemeDisplay, java.lang.String, java.util.List)
	 */
	public  ProductoDestacadoBean obtenerBeanDestacado(JournalArticle art, ThemeDisplay themeDisplay, String idProducto,List<Parametro> listaProductos){
		    
			ProductoDestacadoBean dest = new ProductoDestacadoBean();
			Long groupId = themeDisplay.getScopeGroupId();
			
			String indicaSimulador = getParseValue("indicadorSimulador", art,themeDisplay.getLanguageId());
			String idSimulador ="";
			String idContenido ="";
			
			
			try {
				
				if(indicaSimulador.equals("true")){
					idSimulador = getParseValue("identificadorSimulador", art,themeDisplay.getLanguageId());
					dest.setIndicadorSimulador(true);
					dest.setIdSimulador(idSimulador);
					dest.setIdTab(idSimulador);
				} else {
					idContenido = getParseValue("idContenidoWeb", art, themeDisplay.getLanguageId());
					dest.setIndicadorSimulador(false);
					dest.setIdContenidoWeb(idContenido);
					
					if(Validator.isNotNull(idContenido)){
						JournalArticle articuloMenor = JournalArticleLocalServiceUtil.getLatestArticle(groupId, String.valueOf(idContenido));
						String title = articuloMenor.getTitle(themeDisplay.getLocale());
						dest.setTitleTag(title);
					}
				}
				if(idSimulador.equals("") && idContenido.equals("")){
					return null;
				}
				dest.setCodSiebel(idProducto);
				dest.setIdArticulo(art.getArticleId());
				
				//Agregamos el orden segun banca y defecto
				for (Parametro pa: listaProductos ) {
					if(pa.getDato1().equalsIgnoreCase(idProducto)){
						dest.setOrden(pa.getNum2());
						
						break;
					}else{
						dest.setOrden(-1);
					}
				}
				
			} catch (Exception e) {
				_log.error("Error al obtener el Detalle del destacado " + e.toString());
				return null;
			}
			
			return dest;
		
	}
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.principal.service.PrincipalService#initDestacadoPrincipal(javax.portlet.RenderRequest)
	 */
	public  List<ProductoDestacadoBean>  initDestacadoPrincipal(RenderRequest renderRequest){
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId,categoryId, companyId;
		
		groupId = themeDisplay.getScopeGroupId();
		companyId=themeDisplay.getCompanyId();
		
		List<ProductoDestacadoBean> lstDestacados = new ArrayList<ProductoDestacadoBean>();
		
		List<ProductoDestacadoBean> lstDestacadosWS = new ArrayList<ProductoDestacadoBean>();
		List<ProductoDestacadoBean> lstDestacadosDefecto = new ArrayList<ProductoDestacadoBean>();
		List<String> productosWS = new ArrayList<String>();
		List<String> productosWSFiltrado = new ArrayList<String>();
		
		List<String> productosDefecto = new ArrayList<String>();
		String banca=SimuladoresUtil.getBancaByURL(themeDisplay.getLayout());
		
		try{
			DynamicQuery query =DynamicQueryFactoryUtil.forClass(AssetCategory.class, PortalClassLoaderUtil.getClassLoader())
		      		.add(PropertyFactoryUtil.forName("name").like("Productos"));

			AssetCategory codassset=  (AssetCategory) AssetCategoryLocalServiceUtil.dynamicQuery(query).get(0);
			categoryId = codassset.getCategoryId();
			SearchContext searchContext = SearchContextFactory.getInstance(PortalUtil.getHttpServletRequest(renderRequest));
			List<Document> listaDoc = getLuceneContentSearch(searchContext, companyId, groupId, categoryId);
			//Todos los prodcutos destacados
			//List<JournalArticle> lstArticle = getArticulosPorDocumentos(renderRequest, listaDoc, themeDisplay.getLanguageId(), themeDisplay);
			Map<String,JournalArticle> lstArticle = getArticulosPorDocumentos(renderRequest, listaDoc, themeDisplay.getLanguageId(), themeDisplay);
			
			productosWS = obtenerPromociones(renderRequest,banca);//Obtenemos las promociones del WS
			List<Parametro> parametrosWS =cachejsonUtil.getProductobyBanca(true,banca);
			
			for(String pr : productosWS){
				if (lstArticle.containsKey(pr)) {
					ProductoDestacadoBean pdtoDestacado =  obtenerBeanDestacado(lstArticle.get(pr), themeDisplay, pr,parametrosWS);
					if(pdtoDestacado!=null){
						if(pdtoDestacado.getOrden()!=-1){
							lstDestacadosWS.add(pdtoDestacado);
							productosWSFiltrado.add(pr);
							_log.info("WS:"+"/"+pdtoDestacado.getOrden()+":"+pdtoDestacado.getIdTab());
						}
					}
				}
				
				/*
				for(JournalArticle art :  lstArticle){
					String idProducto = getParseValue("codigoSiebel", art,themeDisplay.getLanguageId());
					if (pr.equalsIgnoreCase(idProducto)){
						ProductoDestacadoBean pdtoDestacado =  obtenerBeanDestacado(art, themeDisplay, idProducto,parametrosWS);
						if(pdtoDestacado!=null){
							if(pdtoDestacado.getOrden()!=-1){
								lstDestacadosWS.add(pdtoDestacado);
								productosWSFiltrado.add(pr);
								_log.info("WS:"+"/"+pdtoDestacado.getOrden()+":"+pdtoDestacado.getIdTab());
							}
						}
						
					}
				}*/
				
			}
						
			
			int numFalt = 5-lstDestacadosWS.size();
			//Ordenamos los del WS
			Collections.sort(lstDestacadosWS,  new Comparator<ProductoDestacadoBean>(){
				public int compare(ProductoDestacadoBean o1, ProductoDestacadoBean o2){
					return o1.getOrden()-o2.getOrden();
				}
			});
			
			if(numFalt>0){
				//Falta al menos 1 producto completamos con los destacados
				List<Parametro> listaProductosDefecto=cachejsonUtil.getProductobyBanca(false,banca);
				//Primero ordenamos
				
				Collections.sort(listaProductosDefecto,  new Comparator<Parametro>(){
					public int compare(Parametro o1, Parametro o2){
						return o1.getNum2()-o2.getNum2();
					}
				});
			
				for (Parametro pa: listaProductosDefecto ) {
					
					boolean repetido=false;
					
					if(productosWSFiltrado!=null && productosWSFiltrado.size()>0){
						for (String producto : productosWSFiltrado) {
							
							if(pa.getDato1().equalsIgnoreCase(producto)){
								repetido=true;
								break;
							}
							
						}
					}
					
					if(!repetido){
						productosDefecto.add(pa.getDato1());
						numFalt--;
					}
					
					if(numFalt<=0){
						break;
					}
				}
								
				for(String pr : productosDefecto){
					if (lstArticle.containsKey(pr)) {
						ProductoDestacadoBean pdtoDestacado =  obtenerBeanDestacado(lstArticle.get(pr), themeDisplay, pr,listaProductosDefecto);
						if(pdtoDestacado!=null){
							if(pdtoDestacado.getOrden()!=-1){
								lstDestacadosWS.add(pdtoDestacado);
							}
						}
					}
						
					/*for(JournalArticle art :  lstArticle){
						String idProducto = getParseValue("codigoSiebel", art,themeDisplay.getLanguageId());
						if (pr.equals(idProducto)){
							ProductoDestacadoBean pdtoDestacado =  obtenerBeanDestacado(art, themeDisplay, idProducto,listaProductosDefecto);
							if(pdtoDestacado!=null){
								if(pdtoDestacado.getOrden()!=-1){
									lstDestacadosWS.add(pdtoDestacado);
//									_log.info("DEFECTO:"+"/"+pdtoDestacado.getOrden()+":"+pdtoDestacado.getIdTab());
								}
							}
							
						}
					}*/
					
				}
								
			}
			//Combinamos las listas
			lstDestacados=ListUtils.union(lstDestacadosWS, lstDestacadosDefecto);
		}catch(Exception e){
			_log.info("El servicio web no trajo resultado : " +e.getMessage());
		}
		return lstDestacados;
	}
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.principal.service.PrincipalService#getHPCbyURL(java.lang.String)
	 */
	public Integer getHPCbyURL(String parametroURL){
		
		Integer valorHPC=0;
		try{
			Map<String, Integer> productos=new LinkedHashMap<String, Integer>();
			//Simulador vEhicular
			productos.put("vehicular-tradicional", SimuladoresUtil.PRODUCTO_VEHICULAR_TRADICIONAL);//Credito vehicular TRadicional
			productos.put("vehicular-inteligente", SimuladoresUtil.PRODUCTO_VEHICULAR_COMPRA_INTELIGENTE);//Credito vehicular inteligente
			productos.put("vehicular-casi-nuevo", SimuladoresUtil.PRODUCTO_VEHICULAR_CASI_NUEVO);//Credito vehicular casi nuevo
			productos.put("vehicular-especial", SimuladoresUtil.PRODUCTO_VEHICULAR_ESPECIAL	);//Credito vehicular especial
			productos.put("personal-efectivo", SimuladoresUtil.PRODUCTO_PRESTAMO_EFECTIVO);//Préstamo Efectivo
			productos.put("personal-maestria-part", SimuladoresUtil.PRODUCTO_PRESTAMO_PART_TIME);//P. Maestría Part Time
			productos.put("personal-maestria-full", SimuladoresUtil.PRODUCTO_PRESTAMO_FULL_TIME);//P. Maestría Full Time
			productos.put("hipotecario-regular",SimuladoresUtil.PRODUCTO_HIPOTECARIO_REGULAR);//Crédito hipotecario regular
			productos.put("hipotecario-mi-vivienda",SimuladoresUtil.PRODUCTO_HIPOTECARIO_MI_VIVIENDA);//Credito mi vivienda
			productos.put("hipotecario-techo-propio", SimuladoresUtil.PRODUCTO_HIPOTECARIO_TECHO_PROPIO);//Crédito hipotecario techo propio cofide
			productos.put("garantia-hipotecaria", SimuladoresUtil.PRODUCTO_HIPOTECARIO_GARANTIA_HIPOTECARIA);//Préstamo efectivo con garantía hipotecaria.
			
			valorHPC=productos.get(parametroURL);
			
			
		}catch(Exception e){
			_log.error("");
		}
		
		return valorHPC;
	}
	
	 /**
 	 * Obtiene productoby banca.
 	 * Fecha: 22/08/2013
 	 *
 	 * @param esWS the es ws
 	 * @param banca the banca
 	 * @return productoby banca
 	 */
// 	private List<Parametro> getProductobyBanca(boolean esWS,String banca){
//		String parametroBanca="";
//		if(esWS){
//			parametroBanca=JSonUtil.PRODUCTO_PRIORIDAD_DESTACADO_PRINCIPAL_PERSONA;
//		}else{
//			if(banca.equalsIgnoreCase("BP")){
//				parametroBanca=JSonUtil.PRODUCTO_DEFECTO_DESTACADO_PRINCIPAL_PERSONA;
//			}else if(banca.equalsIgnoreCase("BI")){
//				parametroBanca=JSonUtil.PRODUCTO_DEFECTO_DESTACADO_PRINCIPAL_INSTITUCIONAL;
//			}else if(banca.equalsIgnoreCase("BC")){
//				parametroBanca=JSonUtil.PRODUCTO_DEFECTO_DESTACADO_PRINCIPAL_CORPORATIVO;
//			}else if(banca.equalsIgnoreCase("BPE")){
//				parametroBanca=JSonUtil.PRODUCTO_DEFECTO_DESTACADO_PRINCIPAL_PEQUENIA_EMPRESA;
//			}else if(banca.equalsIgnoreCase("BE")){
//				parametroBanca=JSonUtil.PRODUCTO_DEFECTO_DESTACADO_PRINCIPAL_EMPRESA;
//			}
//		}
//
//		//Falta al menos 1 producto completamos con los destacados
//		try {
//			return ParametroLocalServiceUtil.obtenerParametrosHijos(parametroBanca);
//		} catch (BusinessException e) {
//			_log.error("No se encuentra en una banca válida:"+e.toString());
//			return null;
//		}
//	}


	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.principal.service.PrincipalService#getjSonUtil()
	 */
	public JSonUtil getjSonUtil() {
		if (jSonUtil == null) {
			jSonUtil = new JSonUtil();
		}
		return jSonUtil;
	}
	 
	 
}