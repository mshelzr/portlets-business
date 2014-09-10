/*
 * 27/10/2013
 */
package com.ext.portlet.halcon.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.Parametro;
import com.ext.portlet.halcon.model.impl.ParametroImpl;
import com.ext.portlet.halcon.service.ParametroLocalServiceUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class ParametroFinderImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  27/10/2013
 * @version Halcon 1.0
 */
public class ParametroFinderImpl extends BasePersistenceImpl<Parametro> implements ParametroFinder {
	
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(ParametroFinderImpl.class);
	
	/** The Constant FINDER_CLASS_PREFIX. */
	public static final String FINDER_CLASS_PREFIX = "Parametro";
	
	/** The Constant FINDER_LISTAR. */
	public static final String FINDER_LISTAR = FINDER_CLASS_PREFIX+".listar";
	
	/** The Constant FINDER_OBTENER_PADRE. */
	public static final String FINDER_OBTENER_PADRE = FINDER_CLASS_PREFIX+".obtenerPadre";
	
	/** The Constant FINDER_OBTENER_HIJOS. */
	public static final String FINDER_OBTENER_HIJOS = FINDER_CLASS_PREFIX+".obtenerHijos";
	
	/** The Constant FINDER_OBTENER_HIJOS2. */
	public static final String FINDER_OBTENER_HIJOS2 = FINDER_CLASS_PREFIX+".obtenerHijos2";
	
	/** The Constant FINDER_OBTENER_POR_TIPOS. */
	public static final String FINDER_OBTENER_POR_TIPOS = FINDER_CLASS_PREFIX+".obtenerPorTipo";
	
	/** The Constant FINDER_OBTENER_POR_DESCRIPCION. */
	public static final String FINDER_OBTENER_POR_DESCRIPCION = FINDER_CLASS_PREFIX+".obtenerPorDescripcion";
	
	/** The Constant FINDER_CAMBIAR_ESTADO. */
	public static final String FINDER_CAMBIAR_ESTADO = FINDER_CLASS_PREFIX+".cambiarEstado";
	
	/** The Constant FINDER_OBTENER_LISTA_PADRE. */
	public static final String FINDER_OBTENER_LISTA_PADRE = FINDER_CLASS_PREFIX+".obtenerListaPadre";
	
	/** The Constant FINDER_RANGO_VALOR. */
	private static final String FINDER_RANGO_VALOR = FINDER_CLASS_PREFIX+".obtenerRangoValor";
	
	/** The Constant FINDER_VALIDAR_TIPO. */
	private static final String FINDER_VALIDAR_TIPO = FINDER_CLASS_PREFIX+".validarTipo";
	
	/** The Constant FINDER_OBTENER_HIJOS_DOS. */
	private static final String FINDER_OBTENER_HIJOS_DOS = FINDER_CLASS_PREFIX+".obtenerHijosDos";
	
	/** The Constant FINDER_OBTENER_LISTADO_JSON_HIJOS. */
	private static final String FINDER_OBTENER_LISTADO_JSON_HIJOS = FINDER_CLASS_PREFIX+".listadoHijosPadresJson"; 
	
	/** The Constant FINDER_OBTENER_LISTADO_JSON. */
	private static final String FINDER_OBTENER_LISTADO_JSON = FINDER_CLASS_PREFIX+".listadoPadresJson"; 
	
	
	private static final String FINDER_REG_CABECERA = FINDER_CLASS_PREFIX+".insertCabecera"; 
	
	
	private static final String FINDER_REG_DETALLE = FINDER_CLASS_PREFIX+".insertDetalle";
	
	private static final String FINDER_ID_CABECERA = FINDER_CLASS_PREFIX+".selectIdCabecera"; 
	
	private static final String FINDER_ID_COUNT_SIEBEL = FINDER_CLASS_PREFIX+".countSiebel";
	
	/* (non-Javadoc)
	 * @see com.ext.portlet.halcon.service.persistence.ParametroFinder#listarParametro()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Parametro> listarParametro() throws BusinessException {
		List<Parametro> listaParametro = new ArrayList<Parametro>();
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_LISTAR);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Parametro", ParametroImpl.class);
	
			listaParametro = q.list();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.parametro.listarParametro") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.parametro", "capa.halcon.auditoria.parametro.listarParametro") , e.toString());
		}finally {
			closeSession(session);
		}
		return listaParametro;
	}
	

	/* (non-Javadoc)
	 * @see com.ext.portlet.halcon.service.persistence.ParametroFinder#obtenerParametroPadre(java.lang.Integer)
	 */
	@Override
	public Parametro obtenerParametroPadre(Integer idParametro) throws BusinessException {

		Parametro parametro = ParametroLocalServiceUtil.getInstance();
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_OBTENER_PADRE);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Parametro", ParametroImpl.class);
	
			QueryPos qPos = QueryPos.getInstance(q);
		
			qPos.add(idParametro);
		
			parametro = (Parametro) q.uniqueResult();
			_log.info(" obtener Parametro:"+parametro.getDato1());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.parametro.obtenerParametroPadre") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.parametro", "capa.halcon.auditoria.parametro.obtenerParametroPadre") , e.toString());
		}finally {
			closeSession(session);
		}
		return parametro;
	}
	
	/* (non-Javadoc)
	 * @see com.ext.portlet.halcon.service.persistence.ParametroFinder#obtenerParametrosHijos(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Parametro> obtenerParametrosHijos(Integer idParametro) throws BusinessException {
		List<Parametro> listaParametro = new ArrayList<Parametro>();
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_OBTENER_HIJOS);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Parametro", ParametroImpl.class);
	
			QueryPos qPos = QueryPos.getInstance(q);
		
			qPos.add(idParametro);
		
			listaParametro = q.list();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.parametro.obtenerParametrosHijos") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.parametro", "capa.halcon.auditoria.parametro.obtenerParametrosHijos") , e.toString());
		}finally {
			closeSession(session);
		}
		return listaParametro;
	}
	
	/* (non-Javadoc)
	 * @see com.ext.portlet.halcon.service.persistence.ParametroFinder#obtenerParametrosHijos(java.lang.String)
	 */
	public List<Parametro> obtenerParametrosHijos(String etiqueta) throws BusinessException {
		List<Parametro> listaParametro = new ArrayList<Parametro>();
		Session session = null;
		_log.info("***etiqueta***:"+etiqueta);
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_OBTENER_HIJOS2);
			SQLQuery q = session.createSQLQuery(sql);
			_log.info("***sql***:"+sql);
			q.addEntity("Parametro", ParametroImpl.class);
	
			QueryPos qPos = QueryPos.getInstance(q);
		
			qPos.add(etiqueta);
		
			listaParametro = q.list();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.parametro.obtenerParametrosHijos") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.parametro", "capa.halcon.auditoria.parametro.obtenerParametrosHijos") , e.toString());
		}finally {
			closeSession(session);
		}
		return listaParametro;
	}

/**
 * *.
 *
 * @param id the id
 * @return the list
 * @throws BusinessException the business exception
 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Parametro> obtenerParametrosPorTipo(Integer id) throws BusinessException { 
		List<Parametro> listaParametro = new ArrayList<Parametro>();
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_OBTENER_POR_TIPOS);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Parametro", ParametroImpl.class);
	
			QueryPos qPos = QueryPos.getInstance(q);
		
			qPos.add(id);
		
			listaParametro = q.list();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.Carga.Socio.Remesa.insertSocioRemesa") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.Carga.Socio.Remesa", "capa.halcon.auditoria.Carga.Socio.Remesa.insertSocioRemesa") , e.toString());
		}finally {
			closeSession(session);
		}
		return listaParametro;
	}
	
	/* (non-Javadoc)
	 * @see com.ext.portlet.halcon.service.persistence.ParametroFinder#obtenerParametrosPorDescripcion(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Parametro> obtenerParametrosPorDescripcion(String descripcion) throws BusinessException {
		List<Parametro> listaParametro = new ArrayList<Parametro>();
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_OBTENER_POR_DESCRIPCION);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Parametro", ParametroImpl.class);
	
			QueryPos qPos = QueryPos.getInstance(q);
		
			qPos.add(descripcion);
		
			listaParametro = q.list();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.parametro.obtenerParametrosPorDescripcion.paramUno") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.parametro", "capa.halcon.auditoria.parametro.obtenerParametrosPorDescripcion.paramUno") , e.toString());
		}finally {
			closeSession(session);
		}
		return listaParametro;
	}
	
	
	/* (non-Javadoc)
	 * @see com.ext.portlet.halcon.service.persistence.ParametroFinder#obtenerParametrosPorDescripcion(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Parametro> obtenerParametrosPorDescripcion(
			String descripcionParametro, String descripcionParametroPadre) throws BusinessException {
		List<Parametro> listaParametro = new ArrayList<Parametro>();
		Session session = null;
		try {
			session = openSession();
		
			String sql = "SELECT p1.parm_IdParametro, p1.parm_IdParametroPadre,	p1.parm_ValorMonto1, p1.parm_ValorMonto2, p1.parm_ValorMonto3, p1.parm_Dato1, p1.parm_Dato2, convert(NVARCHAR(255),p2.parm_Num2) AS parm_Dato3, p2.parm_Dato1 AS parm_Dato4, p1.parm_Num1, p1.parm_Num2, p1.parm_Num3 " +
					"FROM T_PARAMETRO p1 JOIN T_PARAMETRO p2 ON (p1.parm_IdParametroPadre = p2.parm_IdParametro) " +
					"WHERE p1.parm_IdParametroPadre IS NOT NULL ";

			if ((descripcionParametro != null && descripcionParametro.length() != 0) && (descripcionParametroPadre != null && descripcionParametroPadre.length() != 0)) {
				sql = sql + "AND p1.parm_Dato1 LIKE '" + descripcionParametro +"'";
				sql = sql + " AND p2.parm_Dato1 LIKE '" + descripcionParametroPadre +"'";
			} else if ((descripcionParametro != null && descripcionParametro.length() != 0) && (descripcionParametroPadre == null || descripcionParametroPadre.length() == 0)) {
				sql = sql + "AND p1.parm_Dato1 LIKE '" + descripcionParametro +"'";
			} else if ((descripcionParametro == null || descripcionParametro.length() == 0) && (descripcionParametroPadre != null && descripcionParametroPadre.length() != 0)) {
				sql = sql + "AND p2.parm_Dato1 LIKE '" + descripcionParametroPadre +"'";
			}

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Parametro", ParametroImpl.class);
			
			listaParametro =  q.list();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.parametro.obtenerParametrosPorDescripcion.paramDos") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.parametro.obtenerParametrosPorDescripcion", "capa.halcon.auditoria.parametro.obtenerParametrosPorDescripcion.paramDos") , e.toString());
		} finally {
			closeSession(session);
		}
		return listaParametro;
	}
	
	
	/* (non-Javadoc)
	 * @see com.ext.portlet.halcon.service.persistence.ParametroFinder#cambiarParametroEstado(java.lang.Integer, java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Integer cambiarParametroEstado(Integer id, Integer estado) throws BusinessException {
		Integer out = null;
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_CAMBIAR_ESTADO);
			SQLQuery q = session.createSQLQuery(sql);
			//q.addEntity("Parametro", ParametroImpl.class);
	
			QueryPos qPos = QueryPos.getInstance(q);
		
			qPos.add(estado);
			qPos.add(id);
		
			out = q.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.parametro.validarTipo") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.parametro", "capa.halcon.auditoria.parametro.validarTipo") , e.toString());
		}finally {
			closeSession(session);
		}
		return out;
	}
			 
	
	/* (non-Javadoc)
	 * @see com.ext.portlet.halcon.service.persistence.ParametroFinder#obtenerParametroListaPadre()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Parametro> obtenerParametroListaPadre() throws BusinessException {
		List<Parametro> listaParametro = new ArrayList<Parametro>();
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_OBTENER_LISTA_PADRE);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Parametro", ParametroImpl.class);
		
			listaParametro = q.list();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.parametro.obtenerParametroListaPadre") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.parametro.obtenerParametroListaPadre", "capa.halcon.auditoria.parametro.obtenerParametroListaPadre") , e.toString());
		}finally {
			closeSession(session);
		}
		return listaParametro;
	}

	//CASO DE PARAMETROS JSON, MEMORIA
	/* (non-Javadoc)
	 * @see com.ext.portlet.halcon.service.persistence.ParametroFinder#obtenerRangoValor(java.lang.Integer)
	 */
	public List<Parametro> obtenerRangoValor (Integer id) throws BusinessException {
		_log.equals("Entro obtener Finder Impl:"+ id);
		List<Parametro> listaParametro = (List<Parametro>) MultiVMPoolUtil.get("com.ext.portlet.halcon.model.Parametro", "obtenerRangoValor"+id);
		if (listaParametro == null) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_RANGO_VALOR);
			SQLQuery q = session.createSQLQuery(sql);
			//------------------------
			q.addEntity(
			"Parametro", ParametroImpl.class);
			//-------------------------- 
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(id);
			listaParametro = q.list();
				MultiVMPoolUtil.put("com.ext.portlet.halcon.model.Parametro", "obtenerRangoValor"+id, listaParametro);
		} catch (Exception e) {
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.parametro.obtenerRangoValor") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.parametro", "capa.halcon.auditoria.parametro.obtenerRangoValor") , e.toString());
		}finally {
			closeSession(session);
		}
		}
		return listaParametro;
	}
	
	

	/* (non-Javadoc)
	 * @see com.ext.portlet.halcon.service.persistence.ParametroFinder#validarTipo(java.lang.Integer)
	 */
	public Integer validarTipo(Integer idParametro) throws BusinessException {

		Integer valor = null;
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_VALIDAR_TIPO);
			SQLQuery q = session.createSQLQuery(sql);
	
			QueryPos qPos = QueryPos.getInstance(q);
		
			qPos.add(idParametro);
		
			valor =  (Integer) q.uniqueResult();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.parametro.validarTipo") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.parametro", "capa.halcon.auditoria.parametro.validarTipo") , e.toString());
		}finally {
			closeSession(session);
		}
		return valor;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.ext.portlet.halcon.service.persistence.ParametroFinder#obtenerParametrosHijosDos(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Parametro> obtenerParametrosHijosDos(Integer idParametro) throws BusinessException {
		List<Parametro> listaParametro = new ArrayList<Parametro>();
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_OBTENER_HIJOS_DOS);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Parametro", ParametroImpl.class);
	
			QueryPos qPos = QueryPos.getInstance(q);
		
			qPos.add(idParametro);
		
			listaParametro = q.list();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.parametro.obtenerParametrosHijosDos") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.parametro", "capa.halcon.auditoria.parametro.obtenerParametrosHijosDos") , e.toString());
		}finally {
			closeSession(session);
		}
		return listaParametro;
	}

	/* (non-Javadoc)
	 * @see com.ext.portlet.halcon.service.persistence.ParametroFinder#listarPadresJson(java.lang.Integer)
	 */
	public List<Parametro> listarPadresJson(Integer idParametro) throws BusinessException {
			List<Parametro> listaParametro = new ArrayList<Parametro>();
			Session session = null;
			try {
				session = openSession();
				String sql = CustomSQLUtil.get(FINDER_OBTENER_LISTADO_JSON);
				SQLQuery q = session.createSQLQuery(sql);
				q.addEntity("Parametro", ParametroImpl.class);
		
				QueryPos qPos = QueryPos.getInstance(q);
			
				qPos.add(idParametro);
			
				listaParametro = q.list();
				
			} catch (Exception e) {
				_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.parametro.listarParametro") + e.toString());
				throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.parametro", "capa.halcon.auditoria.parametro.listarParametro") , e.toString());
			}finally {
				closeSession(session);
			}
			return listaParametro;
		}
	
	/* (non-Javadoc)
	 * @see com.ext.portlet.halcon.service.persistence.ParametroFinder#listarHijosPadresJson(java.lang.Integer)
	 */
	public List<Parametro> listarHijosPadresJson(Integer tipoLista) throws BusinessException {
		List<Parametro> listaParametro = new ArrayList<Parametro>();
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_OBTENER_LISTADO_JSON_HIJOS);
			_log.info("***///*****:"+sql);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Parametro", ParametroImpl.class);
	
			QueryPos qPos = QueryPos.getInstance(q);
		
			qPos.add(tipoLista);
		
			listaParametro = q.list();
			
		} catch (Exception e) {
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.parametro.obtenerParametrosHijos") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.parametro", "capa.halcon.auditoria.parametro.obtenerParametrosHijos") , e.toString());
		}finally {
			closeSession(session);
		}
		return listaParametro;
	}
	
	@Override
	public int registrarCabeceraDetalle(Parametro parametroCab, Parametro parametroDet) throws BusinessException  {
		_log.info("init method");
		Session session = null;
		Integer result2=0;
		
		try {
			session = openSession();
			
			String sql4 = CustomSQLUtil.get(FINDER_ID_COUNT_SIEBEL);
			SQLQuery q4 = session.createSQLQuery(sql4);
			QueryPos qPos4 = QueryPos.getInstance(q4);
			qPos4.add(parametroCab.getDato3());

			int numeroCount = (Integer) q4.uniqueResult();
			
			if(numeroCount == 0){
				String sql = CustomSQLUtil.get(FINDER_REG_CABECERA);
				SQLQuery q = session.createSQLQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parametroCab.getDato1());
				qPos.add(parametroCab.getDato2());
				qPos.add(parametroCab.getDato3());
				qPos.add(parametroCab.getDato4());
				qPos.add(parametroCab.getNum1());
				qPos.add(parametroCab.getNum2());
				qPos.add(parametroCab.getNum3());
				
				q.executeUpdate();
				
				String sql3 = CustomSQLUtil.get(FINDER_ID_CABECERA);
				SQLQuery q3 = session.createSQLQuery(sql3);
				QueryPos qPos3 = QueryPos.getInstance(q3);
				qPos3.add(parametroCab.getDato3());

				int idRegistroParametroInt=(Integer)q3.uniqueResult();

				//Insertar al hijo PersonaEducacion
				String sql2 = CustomSQLUtil.get(FINDER_REG_DETALLE);
				SQLQuery q2 = session.createSQLQuery(sql2);

				QueryPos qPos2 = QueryPos.getInstance(q2);

				parametroDet.setIdParametroPadre(idRegistroParametroInt);

				qPos2.add(parametroDet.getIdParametroPadre());
				qPos2.add(parametroDet.getValorMonto1());
				qPos2.add(parametroDet.getValorMonto2());
				qPos2.add(parametroDet.getValorMonto3());
				qPos2.add(parametroDet.getDato1());
				qPos2.add(parametroDet.getDato2());
				qPos2.add(parametroDet.getDato3());
				qPos2.add(parametroDet.getDato4());
				qPos2.add(parametroDet.getNum1());
				qPos2.add(parametroDet.getNum2());
				qPos2.add(parametroDet.getNum3());

				result2=q2.executeUpdate();
			} else {
				result2 = 0;
			}
		

		} catch (Exception e) {
			e.printStackTrace();
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.parametro.registrarCabeceraDetalle") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.parametro", "capa.halcon.auditoria.parametro.registrarCabeceraDetalle") , e.toString());
		}finally {
			closeSession(session);
		}

		return result2;
	}
}