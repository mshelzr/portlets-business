package com.ext.portlet.halcon.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.Ocurrencia;
import com.ext.portlet.halcon.model.impl.OcurrenciaImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class OcurrenciaFinderImpl extends OcurrenciaPersistenceImpl implements OcurrenciaFinder {
	
	private static final String nameClase = OcurrenciaFinderImpl.class.getName() ;
	private static Log _log = LogFactoryUtil.getLog(OcurrenciaFinderImpl.class);
	public static final String FINDER_CLASS_PREFIX = "Ocurrencia";
	public static final String FINDER_OBTENER_ULTIMA_PETICION = FINDER_CLASS_PREFIX + ".obtenerUltimaPeticion";
	public static final String FINDER_CAMBIAR_ESTADO = FINDER_CLASS_PREFIX + ".cambiarEstado";
	public static final String FINDER_INSERTAR_OCURRENCIA = FINDER_CLASS_PREFIX + ".insertar";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ocurrencia> obtenerUltimaPeticion(String ip, String codigoProducto, Integer estado, String fecha) throws BusinessException {
		List<Ocurrencia> listaPeticion = new ArrayList<Ocurrencia>();
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_OBTENER_ULTIMA_PETICION);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Peticion", OcurrenciaImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(ip);
			qPos.add(codigoProducto);
			qPos.add(estado);
			qPos.add(fecha);
			
			listaPeticion = q.list();

		} catch (Exception e) {
			// TODO Auto-generated catch block
//			_log.error("Error al obtener la Ultima Peticion:" + e.toString());
//			throw new BusinessException(nameClase+" - obtenerUltimaPeticion",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.ocurrencia.obtenerUltimaPeticion") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.ocurrencia", "capa.halcon.auditoria.ocurrencia.obtenerUltimaPeticion") , e.toString());
		} finally {
			closeSession(session);
		}
		return listaPeticion;
	}
	
	
			
	@Override
	public Integer cambiarPeticionEstado(Long id, Integer estado) throws BusinessException {
		Integer out = null;
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_CAMBIAR_ESTADO);
			SQLQuery q = session.createSQLQuery(sql);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(estado);
			qPos.add(id);

			out = q.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
//			_log.error("Error al cambiar Estado de Peticion:" + e.toString());
//			throw new BusinessException(nameClase+" - cambiarPeticionEstado",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.ocurrencia.cambiarPeticionEstado") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.ocurrencia", "capa.halcon.auditoria.ocurrencia.cambiarPeticionEstado") , e.toString());
		} finally {
			closeSession(session);
		}
		return out;
	}



	@Override
	public Ocurrencia insertar(Ocurrencia ocurrencia) throws BusinessException  {
		
		Session session = null;
		
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_INSERTAR_OCURRENCIA);
			SQLQuery q = session.createSQLQuery(sql);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(ocurrencia.getIp());
			qPos.add(ocurrencia.getCodigoProducto());
			qPos.add(ocurrencia.getFecha());
			qPos.add(ocurrencia.getEstado());
			qPos.add(ocurrencia.getOcurrencia());
			
			q.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
//			_log.error("Error al cambiar Estado de Peticion:" + e.toString());
//			throw new BusinessException(nameClase+" - cambiarPeticionEstado",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.ocurrencia.cambiarPeticionEstado") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.ocurrencia", "capa.halcon.auditoria.ocurrencia.cambiarPeticionEstado") , e.toString());
		} finally {
			closeSession(session);
		}
		
		
		
		return ocurrencia;
	}
	
	
	

}
