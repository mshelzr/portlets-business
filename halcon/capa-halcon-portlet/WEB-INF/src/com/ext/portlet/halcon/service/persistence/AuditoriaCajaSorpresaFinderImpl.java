package com.ext.portlet.halcon.service.persistence;

import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.AuditoriaCajaSorpresa;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class AuditoriaCajaSorpresaFinderImpl extends BasePersistenceImpl<AuditoriaCajaSorpresa> implements AuditoriaCajaSorpresaFinder {
	
	private static final String nameClase = AuditoriaCajaSorpresaFinderImpl.class.getName() ;
	private static Log _log = LogFactoryUtil.getLog(AuditoriaCajaSorpresaFinderImpl.class);
	public static final String FINDER_CLASS_PREFIX = "CajaSorpresa";
	public static final String FINDER_INSERT = FINDER_CLASS_PREFIX+".insert";
	
	
	
	public Boolean insert(AuditoriaCajaSorpresa beans) throws BusinessException {
		Integer out = null;
		Session session = null;
		try {			
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_INSERT);
			SQLQuery q = session.createSQLQuery(sql);
			
				QueryPos qPos = QueryPos.getInstance(q);
				
				qPos.add(beans.getIdTransaccion());
				qPos.add(beans.getTipoDocumento());
				qPos.add(beans.getNumDocumento());
				qPos.add(beans.getProducto1());
				qPos.add(beans.getProducto2());
				qPos.add(beans.getProducto3());
				qPos.add(beans.getProducto4());
				qPos.add(beans.getCodProducto1());
				qPos.add(beans.getCodProducto2());
				qPos.add(beans.getCodProducto3());
				qPos.add(beans.getCodProducto4());
				qPos.add(beans.getIP());
				qPos.add(beans.getSession());
				qPos.add(beans.getFechaHora());
				qPos.add(beans.getUTMSource());
				qPos.add(beans.getUTMMedium());
				qPos.add(beans.getUTMCampaing());
				qPos.add(beans.getUTMContent());
				
				out = q.executeUpdate();
				
			if (out > 0) {

				return true;
			}
		} catch (Exception e) {
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.caja.sorpresa.insertar") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.caja.sorpresa", "capa.halcon.auditoria.caja.sorpresa.insertar") , e.toString());
		} finally {
			closeSession(session);
		}
		return false;
	}
	
}
