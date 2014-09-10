package com.ext.portlet.halcon.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.Ubigeo;
import com.ext.portlet.halcon.model.impl.UbigeoImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class UbigeoFinderImpl extends BasePersistenceImpl<Ubigeo> implements UbigeoFinder {
	
	private static final String nameClase = UbigeoFinderImpl.class.getName() ;
	private static Log _log = LogFactoryUtil.getLog(UbigeoFinderImpl.class);
	public static final String FINDER_CLASS_PREFIX = "Parametro";
	private static final String FINDER_DEPARTAMENTO = FINDER_CLASS_PREFIX+".obtenerDepartamentos";
	private static final String FINDER_PROVINCIA = FINDER_CLASS_PREFIX+".obtenerProvincias";
	private static final String FINDER_DISTRITO = FINDER_CLASS_PREFIX+".obtenerDistritos";
	private static final String FINDER_DISTRITOLIMA = FINDER_CLASS_PREFIX+".obtenerDistritosLima";
//	private static final String FINDER_PAIS = FINDER_CLASS_PREFIX+".obtenerPaises";
	
	
	@Override
	public List<Ubigeo> obtenerDepartamentos() throws BusinessException {
		List<Ubigeo> listaParametro = new ArrayList<Ubigeo>();
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_DEPARTAMENTO);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Ubigeo", UbigeoImpl.class);
	
			QueryPos qPos = QueryPos.getInstance(q);
		
			listaParametro = q.list();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			_log.error("Error al listar Parametro:"+e.toString());
//			throw new BusinessException(nameClase+" - obtenerDepartamentos",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.ubigeo.obtenerDepartamentos") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.ubigeo", "capa.halcon.auditoria.ubigeo.obtenerDepartamentos") , e.toString());
		}finally {
			closeSession(session);
		}
		return listaParametro;
	}
	
	@Override
	public List<Ubigeo> obtenerProvincias() throws BusinessException {
		List<Ubigeo> listaParametro = new ArrayList<Ubigeo>();
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_PROVINCIA);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Ubigeo", UbigeoImpl.class);
	
			QueryPos qPos = QueryPos.getInstance(q);
		
			listaParametro = q.list();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			_log.error("Error al listar Parametro:"+e.toString());
//			throw new BusinessException(nameClase+" - obtenerProvincias",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.ubigeo.obtenerProvincias") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.ubigeo", "capa.halcon.auditoria.ubigeo.obtenerProvincias") , e.toString());
		}finally {
			closeSession(session);
		}
		return listaParametro;
	}

	@Override
	public List<Ubigeo> obtenerDistritos() throws BusinessException {
		List<Ubigeo> listaParametro = new ArrayList<Ubigeo>();
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_DISTRITO);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Ubigeo", UbigeoImpl.class);
	
			QueryPos qPos = QueryPos.getInstance(q);
		
			listaParametro = q.list();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			_log.error("Error al listar Parametro:"+e.toString());
//			throw new BusinessException(nameClase+" - obtenerDistritos",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.ubigeo.obtenerDistritos") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.ubigeo.obtenerDistritos", "capa.halcon.auditoria.ubigeo.obtenerDistritos") , e.toString());
		}finally {
			closeSession(session);
		}
		return listaParametro;
	}
	
	@Override
	public List<Ubigeo> obtenerDistritosLima(String codigos) throws BusinessException {
//		public List<Ubigeo> obtenerDistritosLima(String codigos) {
		
		List<Ubigeo> listaParametro = new ArrayList<Ubigeo>();
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT ubig_IdUbigeo " +
		      ",ubig_Codigo " +
		      ",ubig_Nombre " +
		      ",ubig_CodDepartamento " +
		      ",ubig_CodProvincia " +
		      ",ubig_CodDistrito " +
		"FROM T_UBIGEO  " +
		"WHERE ubig_Codigo IN " + codigos + " AND " +
			 "ubig_CodDistrito <> '00' AND " +
			 "ubig_CodProvincia <> '00' AND " +
			 "(ubig_CodDepartamento = '15' OR ubig_CodDepartamento = '07') " +
		"ORDER BY ubig_Nombre";
//			String sql = CustomSQLUtil.get(FINDER_DISTRITOLIMA);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Ubigeo", UbigeoImpl.class);
	
			QueryPos qPos = QueryPos.getInstance(q);
//			qPos.add(listaCodigos);
			listaParametro = q.list();
			
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
//			_log.error("Error al listar Parametro:"+e.toString());
//			throw new BusinessException(nameClase+" - obtenerDistritosLima",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.ubigeo.obtenerDistritosLima") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.ubigeo", "capa.halcon.auditoria.ubigeo.obtenerDistritosLima") , e.toString());
		}finally {
			closeSession(session);
		}
		return listaParametro;
	}
}
