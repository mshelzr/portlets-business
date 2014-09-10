package pe.com.ibk.halcon.gestionperfilador.bean;

import java.util.List;

import com.ext.portlet.halcon.model.ConfiguracionPerfilador;
import com.ext.portlet.halcon.service.ClpSerializer;
import com.ext.portlet.halcon.service.ConfiguracionPerfiladorLocalServiceUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.util.portlet.PortletProps;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class BeanListadoVariables.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 24/06/2013
 * @version Halcon 1.0
 */
public class BeanListadoVariables {

	/** The lista variable. */
	private List<ConfiguracionPerfilador> listaVariable;

	/** The Constant COD_PERFILADOR_ACTIVO. */
	private static final String COD_PERFILADOR_ACTIVO = PortletProps.get("variable.perfilador.code.estado.activo");

	/**
	 * Obtiene lista variable. Fecha: 24/06/2013
	 * 
	 * @return lista variable
	 */
	public List<ConfiguracionPerfilador> getListaVariable() {
		return listaVariable;
	}

	/**
	 * Establece el lista variable.
	 * 
	 * @param listaVariable el new lista variable
	 */
	public void setListaVariable(List<ConfiguracionPerfilador> listaVariable) {
		this.listaVariable = listaVariable;
	}

	/**
	 * Listar. Fecha: 24/06/2013
	 * 
	 * @param idConfiguracion the id configuracion
	 * @throws Exception the exception
	 */
	public void listar(Long idConfiguracion) throws Exception {

		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
		List<ConfiguracionPerfilador> listadoVariables = null;

		try {

			DynamicQuery consultaP = DynamicQueryFactoryUtil.forClass(ConfiguracionPerfilador.class, classLoader);
			// .add(
			// PropertyFactoryUtil.forName("estado")
			// .eq(Integer.valueOf(COD_PERFILADOR_ACTIVO)));

			if (idConfiguracion != null) {
				consultaP.add(PropertyFactoryUtil.forName("codigoVariablePadre").eq(idConfiguracion));
			} else {
				consultaP.add(PropertyFactoryUtil.forName("codigoVariablePadre").eq(0L));
			}

			listadoVariables = ConfiguracionPerfiladorLocalServiceUtil.dynamicQuery(consultaP, -1, -1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setListaVariable(listadoVariables);
	}

}
