package com.ext.portlet.halcon.service.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.exp.portlet.halcon.utils.Propiedades;
import com.exp.portlet.halcon.utils.TiempoUtil;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.FondosMutuos;
import com.ext.portlet.halcon.model.Parametro;
import com.ext.portlet.halcon.model.impl.FondosMutuosImpl;
import com.ext.portlet.halcon.model.impl.ParametroImpl;
import com.ext.portlet.halcon.service.ParametroLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class FondosMutuosFinderImpl extends BasePersistenceImpl<FondosMutuos> implements FondosMutuosFinder {
	
//	private static final String nameClase = FondosMutuosFinderImpl.class.getName() ;
	private static Log _log = LogFactoryUtil.getLog(FondosMutuosFinderImpl.class);
	public static final String FINDER_CLASS_PREFIX = "Simulador";
	public static final String FINDER_OBTENER_ZONA = FINDER_CLASS_PREFIX+".consultarFondoMutuoZona";
	public static final String FINDER_LISTAR_PLAZOS = FINDER_CLASS_PREFIX+".consultarPlazosFondoMutuo";
	public static final String FINDER_LISTAR_FONDOS_MUTUOS = FINDER_CLASS_PREFIX+".consultarFondoMutuo";
	public static final String FINDER_OBTENER_FECHA = FINDER_CLASS_PREFIX+".consultarUltimaFecha";
	public static final String FINDER_INSERTAR_FONDOS_MUTUOS = FINDER_CLASS_PREFIX+".insertarFondoMutuo";
	public static final String FINDER_LISTAR_FONDOS_MUTUOS_TIPOS = FINDER_CLASS_PREFIX+".consultarFondoMutuoTipos";
	public static final String FINDER_OBTENER_FONDOS_MUTUOS_PUNTOS = FINDER_CLASS_PREFIX+".consultarFondosMutuosPuntos";
	
	public static final String FINDER_LISTAR_FONDOS_MUTUOS_PARTE01 = FINDER_CLASS_PREFIX+".consultarFondosMutuosParte01";
	public static final String FINDER_LISTAR_FONDOS_MUTUOS_PARTE02 = FINDER_CLASS_PREFIX+".consultarFondosMutuosParte02";
	public static final String FINDER_LISTAR_FONDOS_MUTUOS_PARTE03 = FINDER_CLASS_PREFIX+".consultarFondosMutuosParte03";
	public static final String FINDER_LISTAR_FONDOS_MUTUOS_PARTE04 = FINDER_CLASS_PREFIX+".consultarFondosMutuosParte04";
	
	public static final String FINDER_OBTENER_DIAS_DESDE_ID = FINDER_CLASS_PREFIX+".consultarDiasDesdeIdentificadorSlider";
	
		
	public Parametro obtenerFondoMutuoZona(Integer puntaje, String moneda, String etiqueta) throws BusinessException {
		
		Parametro parametro = ParametroLocalServiceUtil.getInstance();
		Session session = null;
		try {
		
		session = openSession();
		String sql = CustomSQLUtil.get(FINDER_OBTENER_ZONA);
		SQLQuery q = session.createSQLQuery(sql);
		q.addEntity("Parametro", ParametroImpl.class);

		QueryPos qPos = QueryPos.getInstance(q);
		
		qPos.add(moneda);
		qPos.add(puntaje);
		qPos.add(etiqueta);
	
		parametro = (Parametro) q.uniqueResult();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.fondos.mutuos.obtener.fondo.mutuo.zona") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.fondos.mutuos","capa.halcon.fondos.mutuos.obtener.fondo.mutuo.zona") , e.toString());
		}finally {
			closeSession(session);
		}
		return parametro;
	}
	
	@SuppressWarnings("unchecked")
	public List<Parametro> listarPlazozFondoMutuo(String valor) throws BusinessException {
		List<Parametro> listaParametro = new ArrayList<Parametro>();
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_LISTAR_PLAZOS);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Parametro", ParametroImpl.class);
	
			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add(valor);
		
			listaParametro = q.list();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.fondos.mutuos.listar.plazoz.fondo.mutuo") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.fondos.mutuos","capa.halcon.fondos.mutuos.listar.plazoz.fondo.mutuo") , e.toString());
		}finally {
			closeSession(session);
		}
		return listaParametro;
	}
	
	@SuppressWarnings("unchecked")
	public List<FondosMutuos> listarFondoMutuo(String moneda, List<String> lista, String tipoFondo) throws BusinessException {
		List<FondosMutuos> listaFondosMutuos = new ArrayList<FondosMutuos>();
		//_log.info("Impresion"+fechas);
		Session session = null;
		String fechas = "'"+StringUtils.join(lista, "','")+"'";
		_log.info("Impresion"+fechas);
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_LISTAR_FONDOS_MUTUOS) + fechas +" ) ";
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("FondosMutuos", FondosMutuosImpl.class);
	
			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add(moneda);
			//qPos.add(fechas);
			qPos.add(tipoFondo);

			listaFondosMutuos = q.list();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.fondos.mutuos.listar.fondo.mutuo") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.fondos.mutuos","capa.halcon.fondos.mutuos.listar.fondo.mutuo") , e.toString());
		}finally {
			closeSession(session);
		}
		return listaFondosMutuos;
	}
	
	public FondosMutuos consultarUltimaFecha() throws BusinessException {
		
		FondosMutuos fondosMutuos;
//		String fecha=null;
		Session session = null;
		try {
		
		session = openSession();
		String sql = CustomSQLUtil.get(FINDER_OBTENER_FECHA);
		SQLQuery q = session.createSQLQuery(sql);
		q.addEntity("FondosMutuos", FondosMutuosImpl.class);

		QueryPos qPos = QueryPos.getInstance(q);
		
//		fecha =   (String) q.uniqueResult();
		fondosMutuos =   (FondosMutuos) q.uniqueResult();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.fondos.mutuos.consulta.rultima.fecha") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.fondos.mutuos","capa.halcon.fondos.mutuos.consulta.rultima.fecha") , e.toString());
		}finally {
			closeSession(session);
		}
		return fondosMutuos;
	}
	
	public Boolean insertarFondoMutuo( List<FondosMutuos> lstBeans ) throws BusinessException {
		
		Integer out = null;
		Session session = null;
		try {			
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_INSERTAR_FONDOS_MUTUOS);
			SQLQuery q = null;			
			
		
			for (FondosMutuos fondoMutuo : lstBeans) {	
				
				q = session.createSQLQuery(sql);
				QueryPos qPos = QueryPos.getInstance(q);
				
				qPos.add(fondoMutuo.getCodigoMoneda());
				qPos.add(fondoMutuo.getTipoFondo() );
				qPos.add(fondoMutuo.getValorCuota());
				qPos.add(TiempoUtil.getFechaStringDateAMD(fondoMutuo.getFecha()));
				qPos.add(fondoMutuo.getFecha());
							
				out = q.executeUpdate();				
			}			
			if (out > 0) {
				return true;
			}
		} catch (Exception e) {
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.fondos.mutuos.insertar.fondo.mutuo") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.fondos.mutuos","capa.halcon.fondos.mutuos.insertar.fondo.mutuo") ,e.toString());
		} finally {
			closeSession(session);
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<Parametro> consultarFondoMutuoTipos(Integer puntaje, String moneda, String etiqueta) throws BusinessException {
		List<Parametro> listaFondosMutuos = new ArrayList<Parametro>();
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_LISTAR_FONDOS_MUTUOS_TIPOS);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Parametro", ParametroImpl.class);
	
			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add(puntaje);
			qPos.add(moneda);
			qPos.add(etiqueta);
			
			listaFondosMutuos = q.list();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.fondos.mutuos.consultar.fondo.mutuo.tipos") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.fondos.mutuos","capa.halcon.fondos.mutuos.consultar.fondo.mutuo.tipos") , e.toString());
		}finally {
			closeSession(session);
		}
		return listaFondosMutuos;
	}
	
	public Parametro obtenerFondosMutuosPuntos(String numeroDias, String etiqueta) throws BusinessException {
		
		Parametro parametro = ParametroLocalServiceUtil.getInstance();
		Session session = null;
		
		try {
		
		session = openSession();
		String sql = CustomSQLUtil.get(FINDER_OBTENER_FONDOS_MUTUOS_PUNTOS);
		SQLQuery q = session.createSQLQuery(sql);
		q.addEntity("Parametro", ParametroImpl.class);

		QueryPos qPos = QueryPos.getInstance(q);
	
		qPos.add(numeroDias);
		qPos.add(etiqueta);
	
		parametro = (Parametro) q.uniqueResult();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.fondos.mutuos.obtener.fondos.mutuos.puntos") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.fondos.mutuos","capa.halcon.fondos.mutuos.obtener.fondos.mutuos.puntos") , e.toString());
		}finally {
			closeSession(session);
		}
		return parametro;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> consultarFondosMutuosParte (String moneda, String fondo1,  String fondo2,  String fondo3, 
			Integer dias, List<String> lista) throws BusinessException {

		List<Object[]> listado =null;
		String fechas = "'"+StringUtils.join(lista, "','")+"'";

		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FINDER_LISTAR_FONDOS_MUTUOS_PARTE01) + fechas +
					CustomSQLUtil.get(FINDER_LISTAR_FONDOS_MUTUOS_PARTE02) + fechas +
					CustomSQLUtil.get(FINDER_LISTAR_FONDOS_MUTUOS_PARTE03) + fechas +
					CustomSQLUtil.get(FINDER_LISTAR_FONDOS_MUTUOS_PARTE04);
			
			SQLQuery q = session.createSQLQuery(sql);
	
			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add(moneda);
			qPos.add(fondo1);
			qPos.add(fondo2);
			qPos.add(fondo3);
			qPos.add(dias);
			
			listado =  q.list();
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.fondos.mutuos.consultar.fondos.mutuos.parte") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.fondos.mutuos","capa.halcon.fondos.mutuos.consultar.fondos.mutuos.parte") + e.toString());
		}finally {
			closeSession(session);
		}
		return listado;
	}
	
	public Parametro consultarDiasDesdeIdentificadorSlider(String etiqueta, String periodo) throws BusinessException {
		
		Parametro parametro = ParametroLocalServiceUtil.getInstance();
		Session session = null;
		
		try {
		
		session = openSession();
		String sql = CustomSQLUtil.get(FINDER_OBTENER_DIAS_DESDE_ID);
		SQLQuery q = session.createSQLQuery(sql);
		q.addEntity("Parametro", ParametroImpl.class);

		QueryPos qPos = QueryPos.getInstance(q);
	
		qPos.add(etiqueta);
		qPos.add(periodo);
	
		parametro = (Parametro) q.uniqueResult();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.fondos.mutuos.consultar.dias.desde.identificador.slider") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.fondos.mutuos","capa.halcon.fondos.mutuos.consultar.dias.desde.identificador.slider") , e.toString());
		}finally {
			closeSession(session);
		}
		return parametro;
	}
	
}
