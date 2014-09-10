package com.ext.portlet.halcon.service.persistence;

import java.util.List;

import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.CargaSocioRemesa;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class CargaSocioRemesaFinderImpl extends BasePersistenceImpl<CargaSocioRemesa> implements CargaSocioRemesaFinder {

	private static final String nameClase = CargaSocioRemesaFinderImpl.class.getName() ;
	private static Log _log = LogFactoryUtil.getLog(CargaSocioRemesaFinderImpl.class);
	public static final String FINDER_CLASS_PREFIX = "CargaRemesas";
	public static final String FINDER_TRUNCATE = FINDER_CLASS_PREFIX+".truncate";	
	public static final String FINDER_INSERT = FINDER_CLASS_PREFIX + ".insert";

	public Boolean insertSocioRemesa(List<CargaSocioRemesa> beans) throws BusinessException {
		Integer out = null;
		Session session = null;
		try {			
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_INSERT);
			SQLQuery q = null;
			
			for (int i = 0; i < beans.size(); i++) {
				
				q = session.createSQLQuery(sql);
				QueryPos qPos = QueryPos.getInstance(q);
				
				qPos.add(beans.get(i).getEmpresa());
				qPos.add(beans.get(i).getPaisCobertura());
				qPos.add(beans.get(i).getPaginaWeb());
				qPos.add(beans.get(i).getTelefono());
				
				out = q.executeUpdate();
				
			}			
			if (out > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("  e : " + e);
			_log.error("Error al listar Parametro:" + e.toString());
		} finally {
			closeSession(session);
		}
		return false;
	}
	
	@Override
	public Integer truncate() throws BusinessException {
		Integer out = null;
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_TRUNCATE);
			SQLQuery q = session.createSQLQuery(sql);				
			out = q.executeUpdate();			
		} catch (Exception e) {
			//_log.error("Error al listar Parametro:"+e.toString());
			//throw new BusinessException(nameClase+" - truncate",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.Carga.Socio.Remesa.truncate") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.Carga.Socio.Remesa", "capa.halcon.auditoria.Carga.Socio.Remesa.truncate") , e.toString());
		}finally {
			closeSession(session);
		}
		return out;
	}
}
