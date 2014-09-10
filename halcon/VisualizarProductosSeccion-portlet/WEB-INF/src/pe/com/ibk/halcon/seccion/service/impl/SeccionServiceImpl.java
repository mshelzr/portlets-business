package pe.com.ibk.halcon.seccion.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import pe.com.ibk.halcon.seccion.service.SeccionService;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;
import com.liferay.portlet.journal.model.JournalArticle;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class SeccionServiceImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
@Service("SeccionService")
public class SeccionServiceImpl implements SeccionService {
	
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(SeccionServiceImpl.class);


	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.seccion.service.SeccionService#getAssetsByName(long, long, java.lang.String)
	 */
	@Override
	public List<AssetEntry> getAssetsByName(long companyId, long groupId, String nombreCategoria) {
		long categoryId = 0;
		List<AssetEntry> assets = new ArrayList<AssetEntry>();
		/* Obtenemos la categoria desde el nombre */
		try {
			DynamicQuery queryCategoria = DynamicQueryFactoryUtil
					.forClass(AssetCategory.class, PortalClassLoaderUtil.getClassLoader())
					.add(PropertyFactoryUtil.forName("companyId").eq(companyId))
					.add(PropertyFactoryUtil.forName("groupId").eq(groupId))
					.add(PropertyFactoryUtil.forName("name").eq(nombreCategoria));

			AssetCategory codassset = (AssetCategory) AssetCategoryLocalServiceUtil.dynamicQuery(
					queryCategoria).get(0);

			categoryId = codassset.getCategoryId();

			/* Query para buscar las noticias */
			AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
			assetEntryQuery.setClassNameIds(new long[] { PortalUtil
					.getClassNameId(JournalArticle.class.getName()) });
			assetEntryQuery.setExcludeZeroViewCount(false);
			assetEntryQuery.setGroupIds(new long[] { groupId });
			assetEntryQuery.setAnyCategoryIds(new long[] { categoryId });
			assetEntryQuery.setOrderByCol1("title");
			assetEntryQuery.setOrderByType1("ASC");

			assets = AssetEntryLocalServiceUtil.getEntries(assetEntryQuery);
		} catch (Exception e) {
			_log.error("Error al obetener los assets",e);
		}
		return assets;
	}


	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.seccion.service.SeccionService#getParseValue(java.lang.String, com.liferay.portlet.journal.model.JournalArticle, java.lang.String)
	 */
	@Override
	public String getParseValue(String fieldname, JournalArticle article, String languageID) {
		String value = StringPool.BLANK;
		try {
			com.liferay.portal.kernel.xml.Document document = SAXReaderUtil.read(article
					.getContentByLocale(languageID));
			Node node = document.selectSingleNode(String.format("/root/dynamic-element[@name='%s']/dynamic-content", fieldname));
			if (Validator.isNotNull(node)) {
				value = node.getText();
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return value;
	}
	
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.seccion.service.SeccionService#subtract(java.util.List, java.util.List)
	 */
	public <T> List<T> subtract(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<T>();
        Set<T> set2 = new HashSet<T>(list2);
        for (T t1 : list1) {
            if( !set2.contains(t1) ) {
                result.add(t1);
            }
        }
        return result;
    }

}
