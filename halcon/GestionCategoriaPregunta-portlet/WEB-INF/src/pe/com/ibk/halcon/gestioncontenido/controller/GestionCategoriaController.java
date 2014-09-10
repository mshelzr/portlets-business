package pe.com.ibk.halcon.gestioncontenido.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.ext.portlet.halcon.model.CategoriaSubcategoria;
import com.ext.portlet.halcon.service.CategoriaSubcategoriaLocalServiceUtil;
import com.ext.portlet.halcon.service.ClpSerializer;
import com.ext.portlet.halcon.service.PreguntaFrecuenteLocalServiceUtil;
import com.google.gson.Gson;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class GestionCategoriaController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */

@Controller
@RequestMapping("VIEW")
public class GestionCategoriaController {
 
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(GestionCategoriaController.class);
	 
	/**
	 * Instancia un nuevo gestion categoria controller.
	 */
	public GestionCategoriaController() {  
		
    }  
	
	
	 /**
 	 * Default view.
 	 * Fecha: 22/08/2013
 	 *
 	 * @param renderRequest the render request
 	 * @return the string
 	 */
 	@RequestMapping  
	 protected String defaultView(RenderRequest renderRequest){
		 
		List<CategoriaSubcategoria> categorias = new ArrayList<CategoriaSubcategoria>();
		List<CategoriaSubcategoria> subCategorias = new ArrayList<CategoriaSubcategoria>();
		
			try {
				categorias = listarCategorias();
				subCategorias = listarSubCategorias();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
			renderRequest.setAttribute("lstCategorias", categorias);
			renderRequest.setAttribute("lstSubCategorias", subCategorias);
		
		 return "view"; 
	 }
	 

	/**
	 * Listar categorias.
	 * Fecha: 22/08/2013
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<CategoriaSubcategoria> listarCategorias() throws Exception {
			_log.info("listarCategorias");
			int numCategorias = 10;
		 
			List<CategoriaSubcategoria> categorias = new ArrayList<CategoriaSubcategoria>();

		 	ClassLoader classLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),"portletClassLoader");
		 	DynamicQuery consultaCategorias = DynamicQueryFactoryUtil.forClass(CategoriaSubcategoria.class,classLoader)
					.add(PropertyFactoryUtil.forName("idCategoriaSubCatPadre").isNull());
		 	
		 	try {
		 		categorias = PreguntaFrecuenteLocalServiceUtil.dynamicQuery(consultaCategorias, 0, numCategorias);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 return categorias;
	 }
	
	/**
	 * Listar sub categorias.
	 * Fecha: 22/08/2013
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<CategoriaSubcategoria> listarSubCategorias() throws Exception {
		 _log.info("listarSubCategorias");
		 int numCategorias = 10;
		 
		 List<CategoriaSubcategoria> subCategorias = new ArrayList<CategoriaSubcategoria>();
		 
		 ClassLoader classLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),"portletClassLoader");
			DynamicQuery consultaSubCategorias = DynamicQueryFactoryUtil.forClass(CategoriaSubcategoria.class,classLoader)
											.add(PropertyFactoryUtil.forName("idCategoriaSubCatPadre").isNotNull());
			try {
				subCategorias = PreguntaFrecuenteLocalServiceUtil.dynamicQuery(consultaSubCategorias, 0, numCategorias);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 return subCategorias;
	 }
	 
	 /**
 	 * Agregar categoria nueva.
 	 * Fecha: 22/08/2013
 	 *
 	 * @param resourceRequest the resource request
 	 * @param resourceResponse the resource response
 	 * @throws Exception the exception
 	 */
 	@ResourceMapping("agregarCategoriaNueva")
		public void agregarCategoriaNueva(ResourceRequest resourceRequest,
				ResourceResponse resourceResponse) throws Exception {
		 _log.info("agregarCategoriaNueva");
		 String categoria = ParamUtil.getString(resourceRequest,"categoria");
		 
		 String tipo = ParamUtil.getString(resourceRequest,"tipo");
		 _log.info("Tipo: " + tipo);
		 
		 List<CategoriaSubcategoria> categorias = new ArrayList<CategoriaSubcategoria>();
		 
		 if(tipo.equals("subcategoria")) {
			 String subCategoria = ParamUtil.getString(resourceRequest,"subcategoria");
//			 int  subCategoriaObj = CategoriaSubcategoriaLocalServiceUtil.insertar(Integer.valueOf(categoria), subCategoria);
			 categorias = listarSubCategorias();
		 } else {
//			 int  categoriaObj = CategoriaSubcategoriaLocalServiceUtil.insertar(null, categoria);
			 categorias = listarCategorias();
		 }
		 
		Gson gson = new Gson();
		String gsonString = "";

			gsonString = gson.toJson(categorias);
			_log.info("gsonString: " + gsonString);
			resourceResponse.setContentType(ContentTypes. APPLICATION_JSON);
			PrintWriter writer = resourceResponse.getWriter();		
			writer.write(gsonString);		
			writer.flush();
			writer.close();
	 

	 }
	 
	 /**
 	 * Editar categoria.
 	 * Fecha: 22/08/2013
 	 *
 	 * @param resourceRequest the resource request
 	 * @param resourceResponse the resource response
 	 * @throws Exception the exception
 	 */
 	@ResourceMapping("editarCategoria")
		public void editarCategoria(ResourceRequest resourceRequest,
				ResourceResponse resourceResponse) throws Exception {
		 _log.info("editarCategoria");
		 
		 String idCategoria = ParamUtil.getString(resourceRequest,"idCategoria");
		 CategoriaSubcategoria  cat = CategoriaSubcategoriaLocalServiceUtil.getCategoriaSubcategoria(Long.valueOf(idCategoria));

		 	Gson gson = new Gson();
		 	String gsonString = "";

			gsonString = gson.toJson(cat);
			_log.info("gsonString: " + gsonString);
			resourceResponse.setContentType(ContentTypes. APPLICATION_JSON);
			PrintWriter writer = resourceResponse.getWriter();		
			writer.write(gsonString);		
			writer.flush();
			writer.close();
		 
	 }
	 
	 /**
 	 * Actualizar categoria.
 	 * Fecha: 22/08/2013
 	 *
 	 * @param resourceRequest the resource request
 	 * @param resourceResponse the resource response
 	 * @throws Exception the exception
 	 */
 	@ResourceMapping("actualizarCategoria")
		public void actualizarCategoria(ResourceRequest resourceRequest,
				ResourceResponse resourceResponse) throws Exception {
		 _log.info("agregarSubCategoriaNueva");
		 
		String idCategoria = ParamUtil.getString(resourceRequest,"idCategoria");
		String nombreCategoria = ParamUtil.getString(resourceRequest,"categoria");
		CategoriaSubcategoria cat = CategoriaSubcategoriaLocalServiceUtil.getCategoriaSubcategoria(Long.valueOf(idCategoria));
 		cat.setDescripcion(nombreCategoria);
 		cat = CategoriaSubcategoriaLocalServiceUtil.updateCategoriaSubcategoria(cat);
 		
		//listar SubCategorias
	 }
	 
	 
	 /**
 	 * Eliminar categoria.
 	 * Fecha: 22/08/2013
 	 *
 	 * @param resourceRequest the resource request
 	 * @param resourceResponse the resource response
 	 * @throws Exception the exception
 	 */
 	@ResourceMapping("eliminarCategoria")
		 public void eliminarCategoria(ResourceRequest resourceRequest,
					ResourceResponse resourceResponse) throws Exception {
		 
		 	 String tipo = ParamUtil.getString(resourceRequest,"tipoCategoria");
			 String[] cat =  ParamUtil.getParameterValues(resourceRequest, "categoria");
			 String  error = "No se pudieron eliminar las siguientes categorias debido a que tienen subcategorias asociadas";
			 String errorDet = "";
			 
			 if(tipo.equals("subcategoria")) {
				 
				for (int i = 0; i < cat.length; i++) {
						CategoriaSubcategoriaLocalServiceUtil.deleteCategoriaSubcategoria(Long.valueOf(cat[i]));
						System.out.println(cat[i]);
				}
				 
			 } else {
				 ClassLoader classLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),"portletClassLoader");
				 
				 for (int i = 0; i < cat.length; i++) {
					 
					 DynamicQuery consultaCountSubcategoria = DynamicQueryFactoryUtil.forClass(CategoriaSubcategoria.class,classLoader)
								.add(PropertyFactoryUtil.forName("idCategoriaSubCatPadre").eq(new Long(cat[i])))
								.setProjection(ProjectionFactoryUtil.rowCount());
					 
					try {
						 List<Object> result = CategoriaSubcategoriaLocalServiceUtil.dynamicQuery(consultaCountSubcategoria);
						 int cantSubcategorias = ((Long)result.get(0)).intValue();
						 _log.info("Cantidad= " + cantSubcategorias);
						 if (cantSubcategorias > 0) {
							errorDet += String.valueOf(i);
							System.out.println(errorDet);
						 } else {
							 CategoriaSubcategoriaLocalServiceUtil.deleteCategoriaSubcategoria(Long.valueOf(cat[i]));
							 System.out.println(cat[i]);
						 }
						 
//					 		Integer contador = PreguntaFrecuenteLocalServiceUtil.dynamicQuery(consultaCountSubcategoria, 0, ;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 
					CategoriaSubcategoriaLocalServiceUtil.deleteCategoriaSubcategoria(Long.valueOf(cat[i]));
					System.out.println(cat[i]);
				}
				 
			 }
			 
			 _log.info("Tipo: " + tipo);
			 
			 List<CategoriaSubcategoria> categorias = new ArrayList<CategoriaSubcategoria>();
			 
			 if(tipo.equals("subcategoria")) {
				 categorias = listarSubCategorias();
			 } else {
				 categorias = listarCategorias();
			 }
			 
			 Gson gson = new Gson();
			 String gsonString = "";

			gsonString = gson.toJson(categorias);
			_log.info("gsonString: " + gsonString);
			resourceResponse.setContentType(ContentTypes. APPLICATION_JSON);
			PrintWriter writer = resourceResponse.getWriter();		
			writer.write(gsonString);		
			writer.flush();
			writer.close();
	 }
	 
	 
}
