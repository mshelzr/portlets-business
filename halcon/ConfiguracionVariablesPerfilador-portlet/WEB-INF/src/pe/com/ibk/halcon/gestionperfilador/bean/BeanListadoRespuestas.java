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
 * The Class BeanListadoRespuestas.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 24/06/2013
 * @version Halcon 1.0
 */
public class BeanListadoRespuestas {

	/** The lista respuestas. */
	private List<ConfiguracionPerfilador> listaRespuestas;

	/** The Constant COD_PERFILADOR_ACTIVO. */
	private static final String COD_PERFILADOR_ACTIVO = PortletProps.get("variable.perfilador.code.estado.activo");

	/**
	 * Obtiene lista respuestas. Fecha: 24/06/2013
	 * 
	 * @return lista respuestas
	 */
	public List<ConfiguracionPerfilador> getListaRespuestas() {
		return listaRespuestas;
	}

	/**
	 * Establece el lista respuestas.
	 * 
	 * @param listaRespuestas el new lista respuestas
	 */
	public void setListaRespuestas(List<ConfiguracionPerfilador> listaRespuestas) {
		this.listaRespuestas = listaRespuestas;
	}

	/**
	 * Listar respuestas. Fecha: 24/06/2013
	 * 
	 * @param idConfiguracionPerfilador the id configuracion perfilador
	 * @throws Exception the exception
	 */
	public void listarRespuestas(Long idConfiguracionPerfilador) throws Exception {

		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
		List<ConfiguracionPerfilador> listadoRespuestas = null;

		try {

			DynamicQuery consultaP = DynamicQueryFactoryUtil.forClass(ConfiguracionPerfilador.class, classLoader).add(PropertyFactoryUtil.forName("estado").eq(Integer.valueOf(COD_PERFILADOR_ACTIVO)))
					.add(PropertyFactoryUtil.forName("codigoVariablePadre").eq(idConfiguracionPerfilador));

			listadoRespuestas = ConfiguracionPerfiladorLocalServiceUtil.dynamicQuery(consultaP, -1, -1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setListaRespuestas(listadoRespuestas);
	}

}
