package com.ext.portlet.halcon.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.ProductoComplementario;
import com.ext.portlet.halcon.model.SolicitudProducto;
import com.ext.portlet.halcon.model.TelefonoSolicitudProducto;
import com.ext.portlet.halcon.model.impl.ProductoComplementarioImpl;
import com.ext.portlet.halcon.model.impl.SolicitudProductoImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class SolicitudProductoFinderImpl extends BasePersistenceImpl<SolicitudProducto> implements SolicitudProductoFinder {

	@SuppressWarnings("unused")
	private static final String nameClase = SolicitudProductoFinderImpl.class.getName() ;
	private static Log _log = LogFactoryUtil.getLog(SolicitudProductoFinderImpl.class);
	public static final String FINDER_CLASS_PREFIX = "Solicitud";
	public static final String FINDER_INSERTAR = FINDER_CLASS_PREFIX + ".insertar";
	public static final String FINDER_INSERTAR_PRODUCTO = FINDER_CLASS_PREFIX + ".insertarProducto";
	public static final String FINDER_INSERTAR_TELEFONO = FINDER_CLASS_PREFIX + ".insertarTelefonos";
	public static final String FINDER_SOLICITUDES_POR_PRODUCTO_COUNT = FINDER_CLASS_PREFIX + ".obtenerDetalleSolicitudCount";
	public static final String FINDER_SOLICITUDES_POR_PRODUCTO = FINDER_CLASS_PREFIX + ".obtenerDetalleSolicitud";
	public static final String FINDER_PRODUCTO_DISTINCT = FINDER_CLASS_PREFIX + ".productoDistinct";

	public static final String FINDER_ELIMINAR_SOLICITUD = FINDER_CLASS_PREFIX + ".eliminarSolicitud";
	
	@Override
	public Integer insertarSolicitud(SolicitudProducto solicitud) throws BusinessException {

		Session session = null;
		try {

			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_INSERTAR);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("SolicitudProducto", SolicitudProductoImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

//			qPos.add(solicitud.getIdTipoDocumento());
//			qPos.add(solicitud.getTipoDocumento());
			qPos.add(solicitud.getNumeroDocumento());
			qPos.add(solicitud.getApellidoPaterno());
			qPos.add(solicitud.getApellidoMaterno());
			qPos.add(solicitud.getPrimerNombre());
			qPos.add(solicitud.getSegundoNombre());
			qPos.add(solicitud.getFechaNacimiento());
			qPos.add(solicitud.getSexo());
			qPos.add(solicitud.getRentaMensual());
//			qPos.add(solicitud.getEstadoCivil());
			qPos.add(solicitud.getIdEstadoCivil());
			qPos.add(solicitud.getSituacionLaboral());
			qPos.add(solicitud.getIdSituacionLaboral());
			qPos.add(solicitud.getRUC());
			qPos.add(solicitud.getRazonSocial());
//			qPos.add(solicitud.getCelular());
//			qPos.add(solicitud.getTelefonoCasa());
//			qPos.add(solicitud.getTelefonoTrabajo());
			qPos.add(solicitud.getIdDepartamento());
			qPos.add(solicitud.getIdProvincia());
			qPos.add(solicitud.getIdDistrito());
			qPos.add(solicitud.getNomDepartamento());
			qPos.add(solicitud.getNomProvincia());
			qPos.add(solicitud.getNomDistrito());
//			qPos.add(solicitud.getAnexo());
			qPos.add(solicitud.getCorreoElectronico());
			qPos.add(solicitud.getDireccionEnvio());
			// qPos.add(solicitud.getMonto());
			// qPos.add(solicitud.getMoneda());
			qPos.add(solicitud.getPlacaVehiculo());
			qPos.add(solicitud.getIPCliente());
			qPos.add(solicitud.getHorarioEnvio());
			qPos.add(solicitud.getFechaRegistro());
			qPos.add(solicitud.getUTMSource());
			qPos.add(solicitud.getUTMMedium());
			qPos.add(solicitud.getUTMCampaing());
			qPos.add(solicitud.getUTMContent());
			qPos.add(solicitud.getFechaResultadoPreCalif());
			qPos.add(solicitud.getFechaEnvioLead());
			qPos.add(solicitud.getFechaEnvioEmailing());
			qPos.add(solicitud.getEstadoPreCalificacion());
			qPos.add(solicitud.getEstadoRegLead());
			qPos.add(solicitud.getEstadoEnvCorreo());

			qPos.add(solicitud.getRespPreCalificacion());
			qPos.add(solicitud.getRespRegLead());
			// qPos.add(solicitud.getNomProducto());
			// qPos.add(solicitud.getIdProducto());

			return q.executeUpdate();

		} catch (Exception e) {
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.solicitud.producto.insertarSolicitud") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.Carga.Socio.Remesa", "capa.halcon.auditoria.solicitud.producto.insertarSolicitud") , e.toString());
		} finally {
			closeSession(session);
		}

	}
	
	public Integer insertProductoComplementario( List<ProductoComplementario> lstProductos, Long idSolicitud ) throws BusinessException {
		
		Integer intReturn = 0;
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_INSERTAR_PRODUCTO);
			SQLQuery q = null;

			for (ProductoComplementario producto : lstProductos) {

				q = session.createSQLQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);
				qPos.add(idSolicitud);
				qPos.add(producto.getPrincipalidad());
				qPos.add(producto.getProducto());
				qPos.add(producto.getIdProducto());
				qPos.add(producto.getIdGrupoProducto());
				qPos.add(producto.getEmailSupervisor());
								
				intReturn = q.executeUpdate();				
			}			
			
		} catch (Exception e) {
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.solicitud.producto.insertProductoComplementario") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.solicitud.producto", "capa.halcon.auditoria.solicitud.producto.insertProductoComplementario") , e.toString());
		} finally {
			closeSession(session);
		}
		return intReturn;
	}
	
	public Integer insertarTelefonos( List<TelefonoSolicitudProducto> lstTelefonos, Long idSolicitud ) throws BusinessException {
		
		Integer intReturn = 0;
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_INSERTAR_TELEFONO);
			SQLQuery q = null;

			for (TelefonoSolicitudProducto telefono : lstTelefonos) {

				q = session.createSQLQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);
				qPos.add(idSolicitud);
				qPos.add(telefono.getTipoTelefono());
				qPos.add(idSolicitud);
				qPos.add(telefono.getTipoTelefono());
				qPos.add(telefono.getNumeroTelefono());
				qPos.add(telefono.getAnexo());
				
								
				intReturn = q.executeUpdate();			   
			}			
			
		} catch (Exception e) {
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.solicitud.producto.insertar.telefono") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.solicitud.producto", "capa.halcon.auditoria.solicitud.producto.insertar.telefono") , e.toString());
		} finally {
			closeSession(session);
		}
		return intReturn;
	}

	//throws BusinessException
	public Integer obtenerDetalleSolicitudCount(String producto, Integer respuestaADQ, String fechaInicio, String fechaFinal)  {
		System.out.println("producto:" + producto+" respuestaADQ:" + respuestaADQ+" fechaInicio:" + fechaInicio +" fechaFinal:" + fechaFinal  );
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_SOLICITUDES_POR_PRODUCTO_COUNT);
			SQLQuery q = session.createSQLQuery(sql);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(""+producto);
			qPos.add(""+producto);
			qPos.add(respuestaADQ);
			qPos.add(respuestaADQ);
			qPos.add(fechaInicio+" 00:00:00");
			qPos.add(fechaFinal+" 23:59:59");			
			Integer out = (Integer) q.uniqueResult();
			return out;
		} catch (Exception e) {
			System.out.println("  e : " + e);
			e.printStackTrace();
//			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.solicitud.producto.obtenerdetallesolicitudcount") + e.toString());
//			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.solicitud.producto", "capa.halcon.auditoria.solicitud.producto.obtenerdetallesolicitudcount") , e.toString());
	} finally {
			closeSession(session);
		}
		return 0;
	}
	
	
	@SuppressWarnings({ "unchecked" })
	public List<ProductoComplementario> obtenerLstProductosComplementariosDistinc()  throws BusinessException  {
		
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_PRODUCTO_DISTINCT);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("prcm_IdProducto", Type.STRING);
			q.addScalar("prcm_Producto", Type.STRING);		
			List<Object[]> out = new ArrayList<Object[]>();
			out = q.list();
			List<ProductoComplementario> l = new ArrayList<ProductoComplementario>();
			ProductoComplementario p = null;
			for (Object[] objects : out) {
				p = new ProductoComplementarioImpl();
				p.setIdProducto((String.valueOf(objects[0])));
				p.setProducto((String.valueOf(objects[1])));
				l.add(p);
				p=null;
			}			
			return l;
		} catch (Exception e) {
//			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.solicitud.producto.obtener.producto.complementarios.distinct") + e.toString());
//			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.solicitud.producto", "capa.halcon.auditoria.solicitud.producto.obtener.producto.complementarios.distinct") , e.toString());
	} finally {
			closeSession(session);
		}
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> obtenerDetalleSolicitud(Integer filas , Integer pagina , String producto, Integer respuestaADQ, String fechaInicio, String fechaFinal) throws BusinessException {

		Session session = null;
		
		try {			
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_SOLICITUDES_POR_PRODUCTO);
			SQLQuery q = session.createSQLQuery(sql);
			if (filas > 0 && pagina > 0) {
				
				q.setFirstResult(filas * pagina - filas);
	            q.setMaxResults(filas);
				
			}			
			
			q.addScalar("slpr_IdSolicitudProducto", Type.STRING);
			q.addScalar("slpr_IdTipoDocumentoAdq", Type.STRING);
			q.addScalar("slpr_IdTipoDocumento", Type.STRING);
			
			q.addScalar("slpr_NumeroDocumento", Type.STRING);
			q.addScalar("slpr_ApellidoPaterno", Type.STRING);
			q.addScalar("slpr_ApellidoMaterno", Type.STRING);
			q.addScalar("slpr_PrimerNombre", Type.STRING);
			q.addScalar("slpr_SegundoNombre", Type.STRING);
			q.addScalar("slpr_FechaNacimiento", Type.STRING);
			q.addScalar("slpr_Sexo", Type.STRING);
			q.addScalar("slpr_RentaMensual", Type.STRING);
			q.addScalar("slpr_IdEstadoCivilAdq", Type.STRING);
			q.addScalar("slpr_IdEstadoCivil", Type.STRING);
			q.addScalar("slpr_SituacionLaboral", Type.STRING);
			q.addScalar("slpr_IdSituacionLaboral", Type.STRING);
			q.addScalar("slpr_RUC", Type.STRING);
			q.addScalar("slpr_RazonSocial", Type.STRING);
			q.addScalar("slpr_Celular", Type.STRING);
			q.addScalar("slpr_TelefonoCasa", Type.STRING);
			q.addScalar("slpr_TelefonoTrabajo", Type.STRING);
			q.addScalar("slpr_IdDepartamento", Type.STRING);
			q.addScalar("slpr_IdProvincia", Type.STRING);
			q.addScalar("slpr_IdDistrito", Type.STRING);
			q.addScalar("slpr_Departamento", Type.STRING);
			q.addScalar("slpr_Provincia", Type.STRING);
			q.addScalar("slpr_Distrito", Type.STRING);
			q.addScalar("slpr_Anexo", Type.STRING);
			q.addScalar("slpr_CorreoElectronico", Type.STRING);
			q.addScalar("slpr_DireccionEnvio", Type.STRING);
			q.addScalar("slpr_PlacaVehiculo", Type.STRING);
			q.addScalar("slpr_Session", Type.STRING);			
			q.addScalar("slpr_IPCliente", Type.STRING);
			q.addScalar("slpr_HorarioEnvio", Type.TIME);
			q.addScalar("slpr_FechaRegistro", Type.STRING);
			q.addScalar("slpr_UTMSource", Type.STRING);
			q.addScalar("slpr_UTMMedium", Type.STRING);
			q.addScalar("slpr_UTMCampaing", Type.STRING);
			q.addScalar("slpr_UTMContent", Type.STRING);
			q.addScalar("slpr_FechaResultadoPreCalif", Type.DATE);
			q.addScalar("slpr_FechaEnvioLead", Type.DATE);
			q.addScalar("slpr_FechaEnvioEmailing", Type.DATE);
			q.addScalar("slpr_EstadoPreCalificacion", Type.STRING);
			q.addScalar("slpr_EstadoRegLead", Type.STRING);
			q.addScalar("slpr_EstadoEnvCorreo", Type.STRING);
			q.addScalar("slpr_RespPreCalificacion", Type.STRING);
			q.addScalar("slpr_DescripcionLead", Type.STRING);	
			
			q.addScalar("prcm_IdProductoComplementario", Type.STRING);
			q.addScalar("prcm_IdSolicitudProducto", Type.STRING);
			q.addScalar("prcm_Principalidad", Type.STRING);
			q.addScalar("prcm_Producto", Type.STRING);
			q.addScalar("prcm_IdProducto", Type.STRING);
			q.addScalar("prcm_IdGrupoProducto", Type.STRING);
//			q.addScalar("prcm_Comentario", Type.STRING);
			q.addScalar("slpr_CodigoCampania", Type.STRING);
			q.addScalar("slpr_MontoProspectado", Type.STRING);
			q.addScalar("slpr_CodigoMoneda", Type.STRING);
			q.addScalar("slpr_NombreSupervisor", Type.STRING);
			q.addScalar("prcm_EmailSupervisor", Type.STRING);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(producto);
			qPos.add(producto);
			qPos.add(respuestaADQ);
			qPos.add(respuestaADQ);
			qPos.add(fechaInicio + " 0:00:00");
			qPos.add(fechaFinal + " 23:59:59");	
			List<Object[]> out = new ArrayList<Object[]>();
			out = q.list();
			return out;
		} catch (Exception e) {
			System.out.println("  e : " + e);
			e.printStackTrace();
//			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.Carga.Socio.Remesa.insertSocioRemesa") + e.toString());
//			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.Carga.Socio.Remesa", "capa.halcon.auditoria.Carga.Socio.Remesa.insertSocioRemesa") , e.toString());
			} finally {
			closeSession(session);
		}
		return null;
	}
	
		
	public Integer eliminarSolicitud(Long idProducto) throws BusinessException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_ELIMINAR_SOLICITUD);
			SQLQuery q = session.createSQLQuery(sql);
			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(idProducto);
			qPos.add(idProducto);
			qPos.add(idProducto);
			
			Integer out = (Integer) q.executeUpdate();
			return out;
		} catch (Exception e) {
			System.out.println("  e : " + e);
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.solicitud.producto.obtenerdetallesolicitud") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.solicitud.producto", "capa.halcon.auditoria.solicitud.producto.eliminarsolicitud") , e.toString());
	} finally {
			closeSession(session);
		}
	}
}
