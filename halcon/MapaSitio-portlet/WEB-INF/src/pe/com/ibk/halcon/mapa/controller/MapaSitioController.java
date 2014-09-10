package pe.com.ibk.halcon.mapa.controller;

import java.util.List;

import javax.portlet.RenderRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class MapaSitioController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class MapaSitioController{
 
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(MapaSitioController.class);
	//private static Integer indicadorPortlet=24;
	//private static Integer indicadorController=1;
	
	/**
	 * Default view.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 * @return the string
	 */
	@RequestMapping
	private String defaultView(RenderRequest renderRequest){
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId, companyId;
		
		groupId=themeDisplay.getScopeGroupId();
		companyId=themeDisplay.getCompanyId();
		
		try{
			DynamicQuery queryPaginas=DynamicQueryFactoryUtil.forClass(Layout.class, PortalClassLoaderUtil.getClassLoader())
					.add(PropertyFactoryUtil.forName("groupId").eq(groupId))
					.add(PropertyFactoryUtil.forName("companyId").eq(companyId))
					.add(PropertyFactoryUtil.forName("privateLayout").eq(false))
					.add(PropertyFactoryUtil.forName("hidden").eq(false))
					.add(PropertyFactoryUtil.forName("parentLayoutId").eq(0L))
					.addOrder(OrderFactoryUtil.asc("priority"));
			//List<Layout> nivel1=(List<Layout>)SingleVMPoolUtil.get("com.liferay.portal.model.Layout", "listaMapaSitio");//LOCAL
			List<Layout> nivel1=(List<Layout>)MultiVMPoolUtil.get("com.liferay.portal.model.Layout", "listaMapaSitio");//PRODUCCION
			
			if(nivel1==null){
				
				nivel1=LayoutLocalServiceUtil.dynamicQuery(queryPaginas);
				//SingleVMPoolUtil.put("com.liferay.portal.model.Layout", "listaMapaSitio", nivel1);//Local
				MultiVMPoolUtil.put("com.liferay.portal.model.Layout", "listaMapaSitio", nivel1);//Produccion
				System.out.println("NO CACHE");
			}
			
			//List<Layout> nivel1=LayoutLocalServiceUtil.dynamicQuery(queryPaginas);
			
			renderRequest.setAttribute("paginas", nivel1);
			renderRequest.setAttribute("locale", themeDisplay.getLocale());

		}catch(Exception e){
			_log.error("Error al formar mapa de sitio:"+e.toString());
		}
		//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "view";
	}
}
