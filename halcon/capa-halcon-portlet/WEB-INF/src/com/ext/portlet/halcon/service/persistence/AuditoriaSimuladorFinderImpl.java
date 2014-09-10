package com.ext.portlet.halcon.service.persistence;

import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.AuditoriaSimulador;
import com.ext.portlet.halcon.model.Parametro;
import com.ext.portlet.halcon.model.SolicitudProducto;
import com.ext.portlet.halcon.model.impl.AuditoriaSimuladorImpl;
import com.ext.portlet.halcon.model.impl.ParametroImpl;
import com.ext.portlet.halcon.model.impl.SolicitudProductoImpl;
import com.ext.portlet.halcon.service.ParametroLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class AuditoriaSimuladorFinderImpl extends BasePersistenceImpl<AuditoriaSimulador> implements AuditoriaSimuladorFinder {
	
	private static final String nameClase = AuditoriaSimuladorFinderImpl.class.getName() ;
	private static Log _log = LogFactoryUtil.getLog(AuditoriaSimuladorFinderImpl.class);
	public static final String FINDER_CLASS_PREFIX = "Simulador";
	public static final String FINDER_OBTENER_TARIFARIO_DEPOSITO_PLAZO = FINDER_CLASS_PREFIX+".consultarTarifaDepositoPlazo";
	public static final String FINDER_INSERTAR_AUDITORIA_SIMULADOR = FINDER_CLASS_PREFIX+".insertarAuditoriaSimulador";
	
	public Parametro obtenerTarifarioDepositoPlazo(Integer monto, String moneda, String plazo, String tipoTabla) throws BusinessException {
		
		Parametro parametro = ParametroLocalServiceUtil.getInstance();
		String porcentaje=null;
		Session session = null;
		try {
		
		session = openSession();
		String sql = CustomSQLUtil.get(FINDER_OBTENER_TARIFARIO_DEPOSITO_PLAZO);
		_log.info("****sql******:"+sql);
		
		SQLQuery q = session.createSQLQuery(sql);
		q.addEntity("Parametro", ParametroImpl.class);

		QueryPos qPos = QueryPos.getInstance(q);
	
		qPos.add(monto);
		qPos.add(moneda);
		qPos.add(plazo);
		qPos.add(tipoTabla);
	
		parametro =  (Parametro) q.uniqueResult();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//_log.error("Error al obtener obtenerTarifaDepositoPlazo:"+e.getMessage());
			//throw new BusinessException(nameClase+" - obtenerTarifaDepositoPlazo",e.toString());
			
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.simulador.obtenerTarifarioDepositoPlazo") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.simulador", "capa.halcon.auditoria.simulador.obtenerTarifarioDepositoPlazo") , e.toString());
			
			
			
		}finally {
			closeSession(session);
		}
		return parametro;
	}

//	public Integer insertarAuditoriaSimulador(AuditoriaSimulador simulador) throws BusinessException {
//
//		Session session = null;
//		try {
//
//			session = openSession();
//			String sql = CustomSQLUtil.get(FINDER_INSERTAR_AUDITORIA_SIMULADOR);
//			SQLQuery q = session.createSQLQuery(sql);
//			q.addEntity("AuditoriaSimulador", AuditoriaSimuladorImpl.class);
//
//			QueryPos qPos = QueryPos.getInstance(q);
//
//			qPos.add(simulador.getTipoSimulador());
//			qPos.add(simulador.getIdTransaccion());
//			qPos.add(simulador.getTipoDocumento());
//			qPos.add(simulador.getNumDocumento());
//			qPos.add(simulador.getMoneda());
//			qPos.add(simulador.getTipoProducto());
//			qPos.add(simulador.getInvirtioFondMut());
//			qPos.add(simulador.getNivelConocimFondMut());
//			qPos.add(simulador.getReaccionVarMerc());
//			qPos.add(simulador.getValorBien());
//			qPos.add(simulador.getMontoPrestamo());
//			qPos.add(simulador.getCuotaInicial());
//			qPos.add(simulador.getPeriodoInvers());
//			qPos.add(simulador.getTasa());
//			qPos.add(simulador.getSegDesgrav());
//			qPos.add(simulador.getTipoCuota());
//			qPos.add(simulador.getIP());
//			qPos.add(simulador.getFechaHora());
//			qPos.add(simulador.getUTMSource());
//			qPos.add(simulador.getUTMMedium());
//			qPos.add(simulador.getUTMCampaing());
//			qPos.add(simulador.getUTMContent());
//
//			return q.executeUpdate();
//
//		} catch (Exception e) {
//			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.solicitud.producto.insertarSolicitud") + e.toString());
//			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.Carga.Socio.Remesa", "capa.halcon.auditoria.solicitud.producto.insertarSolicitud") , e.toString());
//		} finally {
//			closeSession(session);
//		}
////
//	}
	
}
