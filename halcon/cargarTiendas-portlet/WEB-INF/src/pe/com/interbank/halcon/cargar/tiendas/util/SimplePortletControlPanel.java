package pe.com.interbank.halcon.cargar.tiendas.util;

import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.BaseControlPanelEntry;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class SimplePortletControlPanel.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 31-ene-2013
 * @version Halcon 1.0
 */
public class SimplePortletControlPanel extends BaseControlPanelEntry {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.liferay.portlet.ControlPanelEntry#isVisible(com.liferay.portal.security.permission.
	 * PermissionChecker, com.liferay.portal.model.Portlet)
	 */
	
	public boolean isVisible(PermissionChecker arg0, Portlet arg1) throws Exception {
		// TODO Auto-generated method stub
		// boolean
		// isRedactor=UserLocalServiceUtil.hasRoleUser(RoleLocalServiceUtil.getRole(arg1.getCompanyId(),
		// "Redactor").getRoleId(),arg0.getUserId());
		// if(isRedactor){
		// return true;
		// }else{
		// return false;
		// }
		return true;

	}

}
