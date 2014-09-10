package com.ext.portlet.halcon.service.persistence;

import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.CategoriaSubcategoria;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class CategoriaSubcategoriaFinderImpl extends BasePersistenceImpl<CategoriaSubcategoria> implements CategoriaSubcategoriaFinder {
	
	private static final String nameClase = CategoriaSubcategoriaFinderImpl.class.getName() ;
	private static Log _log = LogFactoryUtil.getLog(CategoriaSubcategoriaFinderImpl.class);
	public static final String FINDER_CLASS_PREFIX = "CategoriaSubcategoria";
	public static final String FINDER_INSERTAR = FINDER_CLASS_PREFIX+".insertar";
	
	public int insertar(Integer idCategoriaSubCatPadre,String descripcion) throws BusinessException{
		int retorno=0;
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_INSERTAR);
			SQLQuery q = session.createSQLQuery(sql);
	
			QueryPos qPos = QueryPos.getInstance(q);
		
			qPos.add(idCategoriaSubCatPadre);
			qPos.add(descripcion);
		
			 retorno= q.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			retorno=-1;
//			_log.error("Error al insertar Categoria:"+e.toString());
//			throw new BusinessException(nameClase+" - insertar",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.categoria.subcategoria.insert") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.categoria.subcategoria", "capa.halcon.auditoria.categoria.subcategoria.insert") , e.toString());
		}finally {
			closeSession(session);
		}
		return retorno;
	}

}
