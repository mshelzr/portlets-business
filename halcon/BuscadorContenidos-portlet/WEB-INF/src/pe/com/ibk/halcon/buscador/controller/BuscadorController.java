package pe.com.ibk.halcon.buscador.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.ibk.halcon.buscador.model.BuscadorBean;
import pe.com.ibk.halcon.buscador.service.impl.BuscadorUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.util.portlet.PortletProps;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class BuscadorController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class BuscadorController {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(BuscadorController.class);
	//logAuditoria
	//private static Integer indicadorPortlet=1;
	//private static Integer indicadorController=1;
	/**
	 * Defaul view.
	 * Fecha: 18/02/2013
	 *Metodo controlador principal que resolverá las vistas por defecto
	 *
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping
	protected String defaulView(RenderRequest renderRequest, RenderResponse renderResponse) {
		ThemeDisplay themeDisplay;
		long companyId, groupId;
		List<Document> documentos;
		List<Layout> lstLayout;
		HttpServletRequest httpReq;
		List<BuscadorBean> resultados;
		String keywords, pagina;
		int delta, totalContenidos,totalPaginas, paginaActual, inicio, fin;

		themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		companyId = themeDisplay.getCompanyId();
		groupId = themeDisplay.getScopeGroupId();
		httpReq = PortalUtil.getOriginalServletRequest(PortalUtil
				.getHttpServletRequest(renderRequest));
		keywords = ParamUtil.get(httpReq, "keywords", "");
		//Evitamos Modificacion de ataques XSS
		keywords=HtmlUtil.extractText(keywords);
		keywords=HtmlUtil.escape(keywords);
		
		if(Validator.isNull(keywords)){
			return "empty";
		}
		
		paginaActual = ParamUtil.getInteger(httpReq, "page", 1);

		resultados = null;
		delta = Integer.parseInt(PortletProps.get("parametros.PAGINADO_BUSCADOR"));// Delta es el
																					// numero de
																					// contenidos
																					// por pagina
		inicio = (paginaActual * delta) - delta;// start
		fin = inicio + delta;// end
		pagina = "error";
		totalPaginas=0;
		try {
			String categoriasExcluidas[] = { "Banners Promocionales"/* ,"Productos" */};
			String nivelPadreExcluidas[]={"/empresas","/personas", "/pequena-empresa", "/corporativo", "/institucional"};
			List<Long> idCategorias = BuscadorUtil.getCategoriasExcepto(companyId, groupId,
					categoriasExcluidas);

			documentos = BuscadorUtil.getLuceneContentSearch(renderRequest, companyId, groupId,
					idCategorias, keywords, -1, -1);
			
			totalContenidos = BuscadorUtil.getLuceneContentSearchCount(renderRequest, companyId, groupId,
					idCategorias, keywords);
			
			int maxPagesContenidos=(totalContenidos%delta==0?(totalContenidos/delta):(totalContenidos/delta)+1);
			
			_log.info("Se encontraron " + totalContenidos + " contenidos para la palabra " + keywords +" para "+maxPagesContenidos+" páginas máximas");
			
			List<Long> lstExc = BuscadorUtil.getNivelDosExcepto(nivelPadreExcluidas);
			
			lstLayout =  BuscadorUtil.getListUrlSearch(keywords, lstExc);
			
			
			/**/
			if (documentos != null && !documentos.isEmpty()) {
				for (Document doc : documentos) {
					try {
						Long classPK;
						AssetEntry assetEntry;

						classPK = Long.parseLong(doc.get(Field.ENTRY_CLASS_PK));
						assetEntry = AssetEntryLocalServiceUtil.getEntry(
								JournalArticle.class.getName(), classPK);
						BuscadorBean aux = BuscadorUtil.visualizarAsset(themeDisplay, assetEntry);
						if (aux != null) {
							if (resultados == null) {
								resultados = new ArrayList<BuscadorBean>();
							}
							aux.setResumen(StringUtil.highlight(aux.getResumen(),
									new String[] { keywords }));
							aux.setTitulo(StringUtil.highlight(aux.getTitulo(),
									new String[] { keywords }));
							resultados.add(aux);
						}
					} catch (Exception e) {
						_log.error("Error al consultar el AssetEntry de la búsqueda:"+e.toString());
					}

				}
			}
			
			_log.info("Iniciando búsqueda en URLs");
			 List<BuscadorBean> lstBb = resultados;
			 
			 if(lstLayout!=null){
				 List<BuscadorBean>resultadosAux=null;
				  for(Layout la: lstLayout){
					  boolean flagRep = true;
					  
					  if(lstBb!=null){
						  for(BuscadorBean bus : lstBb){
							  if(bus.getUrl().equalsIgnoreCase(themeDisplay.getURLPortal()+ la.getFriendlyURL())){
								  flagRep = false;
								  break;
							  }
						  }
					  }
					  
					  if(flagRep == true){
						  BuscadorBean bb = new BuscadorBean();
						  bb.setTitulo(la.getName(Locale.getDefault()));
						  bb.setUrl(themeDisplay.getURLPortal() + la.getFriendlyURL());
						  if(resultadosAux==null){resultadosAux=new ArrayList<BuscadorBean>();}
						  resultadosAux.add(bb);
					  }
					} 
				  
				  	totalPaginas=resultadosAux==null?0:resultadosAux.size();
					
					int maxPagesPaginas=(totalPaginas%delta==0?(totalPaginas/delta):(totalPaginas/delta)+1);
					_log.info("Se encontraron " + totalPaginas + " páginas para la palabra " + keywords+" para "+maxPagesPaginas+" páginas máximas");
				  	/*filtro los ultimos si es necesario*/
				     //Completare solo si estoy en la ultima pagina de resultados
					/*if((paginaActual==maxPagesContenidos) || maxPagesContenidos==0){*/
						//Genero el indice para completar lo faltante
						/*int faltante=delta-(documentos != null && !documentos.isEmpty()?documentos.size():0);*/
						/*_log.info("Faltan "+faltante+" para completar la pagina "+paginaActual);*/
						if(resultadosAux!=null){
							for(int i=0;/*i<faltante && */i<totalPaginas;i++){
								BuscadorBean bb = resultadosAux.get(i);
								bb.setTitulo(StringUtil.highlight(bb.getTitulo(),
										new String[] { keywords }));
								
								if (resultados == null) {
									resultados = new ArrayList<BuscadorBean>();
								}
								
								resultados.add(bb);
							}
						/*}*/
					}
				}

			renderRequest.setAttribute("keywords", keywords);
			
			if (resultados == null) {
				pagina = "empty";
			} else {
				
				/*Ordenamos en orden alfabetico*/
				Comparator<BuscadorBean> c = 
					    new Comparator<BuscadorBean>()
					    {
					        @Override
					        public int compare( BuscadorBean o1, BuscadorBean o2 )
					        {
					        	
					        	return o1.getTitulo().toLowerCase().compareTo(o2.getTitulo().toLowerCase());
					        }
					    };
			     ListUtil.sort(resultados, c);
				/*Hacemos la sublista de resultados*/
				List<BuscadorBean> listaFinal=ListUtil.subList(resultados, inicio, fin);
				
				/*Filtro para paginas especiales*/
				int totalFiltrado=0;
				String [] urlRestringidas={"resultado-preguntas-frecuentes","resultado-simulacion-deposito","resultado-simulacion-personal",
						"resultado-simulacion-vehicular","resultado-simulacion-hipotecaria","resultado-simulacion-fondos-mutuos","buscador"};
				
				List<BuscadorBean> listaFiltrada=new ArrayList<BuscadorBean>();
				
				if(listaFinal!=null){
					for (BuscadorBean filtro : listaFinal) {
						String url=filtro.getUrl();
						
						if(Validator.isNotNull(url)){
							String urlFinal=url.substring(url.lastIndexOf("/") + 1);
							boolean restringido=false;
							
							for(String p :urlRestringidas){
								if(p.equalsIgnoreCase(urlFinal)){
									totalFiltrado++;
									restringido=true;
									break;
								}
							}
							
							if(!restringido){
								listaFiltrada.add(filtro);
							}
						}
					}
					
					_log.info("Se elimino "+totalFiltrado+" URLS restringidas");
				}
				
				
				
				
				//Aqui filtro repetidos
				for (int i = 0; i < listaFiltrada.size(); i++) {
					if (isRepetido(listaFiltrada, listaFiltrada.get(i))) {
						listaFiltrada.remove(i);
						i--;
					}
				}
				
				
				renderRequest.setAttribute("resultado", listaFiltrada);
				//renderRequest.setAttribute("total",(totalContenidos+totalPaginas)-totalFiltrado);
				renderRequest.setAttribute("total",listaFiltrada.size());
				renderRequest.setAttribute("paginaActual", paginaActual);
				renderRequest.setAttribute("delta", delta);
				renderRequest.setAttribute("inicio", inicio+1);
				
				pagina = "view";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error("Error en el Buscador:", e);
			pagina = "error";
		}
		//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return pagina;
	}
	
	private boolean isRepetido(List<BuscadorBean> listaFiltrada,BuscadorBean b){
		int contador = 0;
		for (BuscadorBean buscadorBean : listaFiltrada) {
			if(buscadorBean.getUrl().equalsIgnoreCase(b.getUrl())){
				contador++;
				if(contador > 1){
					return true;
				}
			}else{
				if (b.getUrl().length()  > buscadorBean.getUrl().length()) {
					String urlSinNumero = b.getUrl().substring(0, b.getUrl().length()-1);
					if(urlSinNumero.equalsIgnoreCase(buscadorBean.getUrl())){
						return true;
					}
				}
			}
		}
			return false;
		}

}
