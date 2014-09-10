package com.ext.portlet.halcon.service.persistence;

import java.util.List;

import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.CargaTienda;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class CargaTiendaFinderImpl extends BasePersistenceImpl<CargaTienda> implements CargaTiendaFinder {
	
//	private static final String nameClase = CargaTiendaFinderImpl.class.getName() ;
	private static Log _log = LogFactoryUtil.getLog(CargaTiendaFinderImpl.class);
	public static final String FINDER_CLASS_PREFIX = "CargaTienda";
	public static final String FINDER_TRUNCATE = FINDER_CLASS_PREFIX+".truncate";
	public static final String FINDER_INSERT = FINDER_CLASS_PREFIX+".insert";
	
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
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.carga.tienda.truncate") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.carga.tienda", "capa.halcon.auditoria.carga.tienda.truncate") , e.toString());
			
		}finally {
			closeSession(session);
		}
		return out;
	}

	public Boolean insert(List<CargaTienda> beans) throws BusinessException {
		Integer out = null;
		Session session = null;
		try {			
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_INSERT);
			SQLQuery q = null;
			
//			System.out.println(" antes de los insert");
			
			for (int i = 0; i < beans.size(); i++) {
				q = session.createSQLQuery(sql);
				QueryPos qPos = QueryPos.getInstance(q);
				qPos.add(beans.get(i).getIdCanal());
				qPos.add(beans.get(i).getCodDistrito());
				qPos.add(beans.get(i).getLatitud());
				qPos.add(beans.get(i).getLongitud());
				qPos.add(beans.get(i).getDireccion());
				qPos.add(beans.get(i).getHorario());
				qPos.add(beans.get(i).getIdLocacion());
				qPos.add(beans.get(i).getLocacion());
				qPos.add(beans.get(i).getEmailCom());
				qPos.add(beans.get(i).getTelefono());
				out = q.executeUpdate();
				
			}			
			if (out > 0) {
//				System.out.println("insertCargaTienda  return true ");
				return true;
			}
		} catch (Exception e) {
//			System.out.println("  e : " + e);
			//_log.error("Error al listar Parametro:" + e.toString());
			//throw new BusinessException(nameClase+" - insert",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.carga.tienda.insert") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.carga.tienda", "capa.halcon.auditoria.carga.tienda.insert") , e.toString());
		} finally {
			closeSession(session);
		}
//		System.out.println("insertCargaTienda  return false ");
		return false;
	}
	
}
