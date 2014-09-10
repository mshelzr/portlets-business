package com.ext.portlet.halcon.service.persistence;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.Propiedades;
import com.exp.portlet.halcon.utils.TiempoUtil;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.LogIncidencias;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class LogIncidenciasFinderImpl extends BasePersistenceImpl<LogIncidencias> implements LogIncidenciasFinder {
	
	private static final String nameClase = LogIncidenciasFinderImpl.class.getName() ;
	private static Log _log = LogFactoryUtil.getLog(LogIncidenciasFinderImpl.class);
	public static final String FINDER_CLASS_PREFIX = "LogErrores";
	public static final String FINDER_INSERTAR = FINDER_CLASS_PREFIX+".insertar";
	
//	@SuppressWarnings("unchecked")
	public LogIncidencias insertarLogIncidencias(LogIncidencias logIncidencias) throws BusinessException {
		
		Session session = null;
		try {
			
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_INSERTAR);
			SQLQuery q = session.createSQLQuery(sql);
			//q.addEntity("Parametro", ParametroImpl.class);
	
			QueryPos qPos = QueryPos.getInstance(q);
			
//			logIncidencias.setIdSessionVisitante(JSonUtil.ID_SESSION_USER);
//			logIncidencias.setTipoNumDoc(JSonUtil.TIPO_NUM_DOC);
//			logIncidencias.setIP(JSonUtil.IP);
//			logIncidencias.setFechaHoraError(TiempoUtil.getTiempoActualEnDate());
			
			qPos.add(logIncidencias.getMensajeError());
			qPos.add(logIncidencias.getParametro());
			qPos.add(logIncidencias.getIdSessionVisitante());
			qPos.add(logIncidencias.getTipoNumDoc());
			qPos.add(logIncidencias.getIP());
			qPos.add(logIncidencias.getFechaHoraError());
			qPos.add(logIncidencias.getTrazaError());
			qPos.add(logIncidencias.getPaginaHija());
		
			
			q.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			_log.error(Propiedades.getResourceBundle("error.informacion") + e.toString());
//			throw new BusinessException(Propiedades.getResourceBundle("error.informacion"),e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.log.incidencias.insertarLogIncidencias") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.log.incidencias", "capa.halcon.auditoria.log.incidencias.insertarLogIncidencias") , e.toString());
		}finally {
			closeSession(session);
		}
		return logIncidencias;
	}
	
}
