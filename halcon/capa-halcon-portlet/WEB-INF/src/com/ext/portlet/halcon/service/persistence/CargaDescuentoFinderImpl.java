package com.ext.portlet.halcon.service.persistence;

import java.util.List;

import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.CargaDescuento;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class CargaDescuentoFinderImpl extends BasePersistenceImpl<CargaDescuento> implements CargaDescuentoFinder {
	
	private static final String nameClase = CargaDescuentoFinderImpl.class.getName() ;
	private static Log _log = LogFactoryUtil.getLog(CargaDescuentoFinderImpl.class);
	public static final String FINDER_CLASS_PREFIX = "CargaDescuento";
	
	public static final String FINDER_TRUNCATE = FINDER_CLASS_PREFIX+".truncate";	
	public static final String FINDER_INSERT = FINDER_CLASS_PREFIX+".insert";
	
	
	public Boolean insertCargaDescuentos( List<CargaDescuento> lstBeans ) throws BusinessException {
		
		Integer out = null;
		Session session = null;
		try {			
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_INSERT);
			SQLQuery q = null;			
			
		
			for (CargaDescuento cargaDescuento : lstBeans) {				
				q = session.createSQLQuery(sql);
				QueryPos qPos = QueryPos.getInstance(q);
				qPos.add(cargaDescuento.getLocal());
				qPos.add(cargaDescuento.getDescuentoGeneral() );
				qPos.add(cargaDescuento.getCondicionesRestricciones());
				qPos.add(cargaDescuento.getDireccion());
				qPos.add(cargaDescuento.getIdDistrito());
				qPos.add(cargaDescuento.getIdDistrito());
				qPos.add(cargaDescuento.getTelefono());
				qPos.add(cargaDescuento.getWeb());
				qPos.add(cargaDescuento.getFinVigencia());
				qPos.add(cargaDescuento.getCategoria());
				qPos.add(cargaDescuento.getCoordenada());
				qPos.add(cargaDescuento.getURLImagen());
				qPos.add(cargaDescuento.getLatitud());
				qPos.add(cargaDescuento.getLongitud());				
				out = q.executeUpdate();				
			}			
			if (out > 0) {
				return true;
			}
		} catch (Exception e) {
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.CargaDescuento.insertCargaDescuentos") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.CargaDescuento", "capa.halcon.auditoria.CargaDescuento.insertCargaDescuentos") , e.toString());

		} finally {
			closeSession(session);
		}
		System.out.println("insertSocioRemesa  return false ");
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
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.CargaDescuento.truncate") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.CargaDescuento", "capa.halcon.auditoria.CargaDescuento.truncate") , e.toString());
			
		}finally {
			closeSession(session);
		}
		return out;
	}
	
}
