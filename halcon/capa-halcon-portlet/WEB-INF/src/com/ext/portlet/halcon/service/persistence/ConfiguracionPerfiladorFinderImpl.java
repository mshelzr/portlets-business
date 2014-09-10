package com.ext.portlet.halcon.service.persistence;

import java.math.BigInteger;

import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.ConfiguracionPerfilador;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ConfiguracionPerfiladorFinderImpl extends BasePersistenceImpl<ConfiguracionPerfilador> implements ConfiguracionPerfiladorFinder {
	
	private static final String nameClase = LogIncidenciasFinderImpl.class.getName() ;
	private static Log _log = LogFactoryUtil.getLog(ConfiguracionPerfiladorFinderImpl.class);
	public static final String FINDER_CLASS_PREFIX = "ConfiguracionPerfilador";
	private static final String FINDER_RANGO_VALOR = FINDER_CLASS_PREFIX+".obtenerRangoValor";
	
	
	//CASO DE PARAMETROS JSON, MEMORIA
//	public List<Parametro> obtenerRangoValor (Integer id) {
//		_log.equals("Entro obtener Finder Impl:"+ id);
//		List<Parametro> listaParametro = new ArrayList<Parametro>();
//		Parametro parametro;// = ParametroLocalServiceUtil.getInstance();
//		Session session = null;
//		try {
//			session = openSession();
//			String sql = CustomSQLUtil.get(FINDER_RANGO_VALOR);
//			SQLQuery q = session.createSQLQuery(sql);
//			//------------------------
////			q.addEntity(
////			"Parametro", ParametroImpl.class);
//			//-------------------------- 
//			QueryPos qPos = QueryPos.getInstance(q);
//			qPos.add(id);
//			listaParametro = q.list();
//
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			_log.equals("Error al obtener Parametro:"+e.toString());
//		}finally {
//			closeSession(session);
//		}
//		return listaParametro;
//	}
//	
	

	public Long obtenerRangoValor(Long idConfiguracionPerfiladorPadre, Long valor) throws BusinessException {

		Session session = null;
		BigInteger resultadoBig = new BigInteger("0");
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_RANGO_VALOR);
			SQLQuery q = session.createSQLQuery(sql);
	
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(idConfiguracionPerfiladorPadre);
			qPos.add(valor);
		
			resultadoBig = (BigInteger) q.uniqueResult();

		} catch (Exception e) {
			// TODO Auto-generated catch block
//			_log.error("Error al obtener el rango del valor ConfiguracionPerfilador: " + e.toString());
//			throw new BusinessException(nameClase+" - obtenerRangoValor",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.configuracion.perfilador.obtenerrangovalor") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.configuracion.perfilador", "capa.halcon.auditoria.configuracion.perfilador.obtenerrangovalor") , e.toString());
		}finally {
			closeSession(session);
		}
		return resultadoBig.longValue();
	}	
	
}
