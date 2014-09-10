package com.ext.portlet.halcon.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.Pais;
import com.ext.portlet.halcon.model.impl.PaisImpl;
import com.ext.portlet.halcon.model.impl.UbigeoImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class PaisFinderImpl extends BasePersistenceImpl<Pais> implements PaisFinder {
	
	private static final String nameClase = PaisFinderImpl.class.getName() ;
	private static Log _log = LogFactoryUtil.getLog(PaisFinderImpl.class);
	public static final String FINDER_CLASS_PREFIX = "Parametro";
	private static final String FINDER_PAIS = FINDER_CLASS_PREFIX+".obtenerPaises";
	
	@Override
	public List<Pais> obtenerPais() throws BusinessException {
		List<Pais> listaParametro = new ArrayList<Pais>();
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_PAIS);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Pais", PaisImpl.class);
	
			QueryPos qPos = QueryPos.getInstance(q);
			
			listaParametro = q.list();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error("Error al listar Parametro:"+e.toString());
			throw new BusinessException(nameClase+" - obtenerPais",e.toString());
		}finally {
			closeSession(session);
		}
		return listaParametro;
	}
	
	public List<Pais> obtenerPaises(String codigos) throws BusinessException {
		
		List<Pais> listaPaises = new ArrayList<Pais>();
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT pais_IdPais " +
		      ",pais_Codigo " +
		      ",pais_Nombre " +
			"FROM T_PAIS " +
			"WHERE pais_Codigo IN " + codigos +
			"ORDER BY pais_Nombre";
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Pais", PaisImpl.class);
	
			QueryPos qPos = QueryPos.getInstance(q);
			listaPaises = q.list();
			
		} catch (Exception e) {
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.pais.obtenerPaises") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.pais", "capa.halcon.auditoria.pais.obtenerPaises") , e.toString());
		}finally {
			closeSession(session);
		}
		return listaPaises;
	}
	
}
