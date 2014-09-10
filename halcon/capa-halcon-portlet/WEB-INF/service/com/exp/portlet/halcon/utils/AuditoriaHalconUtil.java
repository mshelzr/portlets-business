package com.exp.portlet.halcon.utils;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.audit.AuditException;
import com.liferay.portal.kernel.audit.AuditMessage;
import com.liferay.portal.kernel.audit.AuditRequestThreadLocal;
import com.liferay.portal.kernel.audit.AuditRouterUtil;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class AuditoriaHalconUtil {
	
	public static String portletNameGlobal;
	public static String portletIdGlobal;

	public static void auditar(String message) throws JSONException {
		registrarAuditaria(new AuditMessage(message));
	}

	public static void auditar(String eventType, long companyId, long userId, String userName) {

		registrarAuditaria(new AuditMessage(eventType, companyId, userId, userName));
	}

	public static void auditar(String eventType, long companyId, long userId, String userName,
			String className, String classPK) {

		registrarAuditaria(new AuditMessage(eventType, companyId, userId, userName, className,
				classPK));
	}

	public static void auditar(String eventType, long companyId, long userId, String userName,
			String className, String classPK, String message) {

		registrarAuditaria(new AuditMessage(eventType, companyId, userId, userName, className,
				classPK, message));
	}

	public static void auditar(String eventType, long companyId, long userId, String userName,
			String className, String classPK, String message, Date timestamp,
			JSONObject additionalInfo) {

		registrarAuditaria(new AuditMessage(eventType, companyId, userId, userName, className,
				classPK, message, timestamp, additionalInfo));
	}

	public static void auditar(String eventType, long companyId, long userId, String userName,
			String className, String classPK, String message, JSONObject additionalInfo) {

		registrarAuditaria(new AuditMessage(eventType, companyId, userId, userName, className,
				classPK, message, additionalInfo));
	}

	public static void auditar(String eventType, String className, long classPK,
			JSONObject attributes) {
		long companyId = CompanyThreadLocal.getCompanyId();
		long userId = 0;
		JSONObject additionalInfo = JSONFactoryUtil.createJSONObject();
		
		if (portletNameGlobal != null) {
			additionalInfo.put("portletName", portletNameGlobal);
		}
		if (portletIdGlobal != null) {
			additionalInfo.put("portletId", portletIdGlobal);
		}	
		
		if (PrincipalThreadLocal.getName() != null) {
			userId = GetterUtil.getLong(PrincipalThreadLocal.getName());
		}

		AuditRequestThreadLocal auditRequestThreadLocal = AuditRequestThreadLocal
				.getAuditThreadLocal();
		long realUserId = auditRequestThreadLocal.getRealUserId();
		String realUserName = PortalUtil.getUserName(realUserId, StringPool.BLANK);
				
		
		if ((realUserId > 0) && (userId != realUserId)) {
			additionalInfo.put("doAsUserId", String.valueOf(userId));
			additionalInfo.put("doAsUserName", PortalUtil.getUserName(userId, StringPool.BLANK));
		}
		if (attributes != null) {
			additionalInfo.put("attributes", attributes);
		}

		registrarAuditaria(new AuditMessage(eventType, companyId, realUserId, realUserName,
				className, String.valueOf(classPK), null, additionalInfo));
	}
	
	public static void auditar(String eventType, String className, long classPK,
			JSONObject attributes, HttpServletRequest resq) {
		
		long companyId = CompanyThreadLocal.getCompanyId();
		long userId = 0;
		JSONObject additionalInfo = JSONFactoryUtil.createJSONObject();
		
		if (resq != null) {
			ThemeDisplay themeDisplay = (ThemeDisplay) resq.getAttribute(WebKeys.THEME_DISPLAY);
			PortletDisplay porlet = themeDisplay.getPortletDisplay();
			String portletName = porlet.getPortletName(); 
			String portletId = porlet.getId();
			
			portletNameGlobal = portletName;
			portletIdGlobal = portletId;
			
			additionalInfo.put("portletName", portletName);
			additionalInfo.put("portletId", portletId);
		}		

		if (PrincipalThreadLocal.getName() != null) {
			userId = GetterUtil.getLong(PrincipalThreadLocal.getName());
		}

		AuditRequestThreadLocal auditRequestThreadLocal = AuditRequestThreadLocal
				.getAuditThreadLocal();
		long realUserId = auditRequestThreadLocal.getRealUserId();
		String realUserName = PortalUtil.getUserName(realUserId, StringPool.BLANK);
		
		
		if ((realUserId > 0) && (userId != realUserId)) {
			additionalInfo.put("doAsUserId", String.valueOf(userId));
			additionalInfo.put("doAsUserName", PortalUtil.getUserName(userId, StringPool.BLANK));
		}
		if (attributes != null) {
			additionalInfo.put("attributes", attributes);
		}

		registrarAuditaria(new AuditMessage(eventType, companyId, realUserId, realUserName,
				className, String.valueOf(classPK), null, additionalInfo));
	}
	
	public static void registrarAuditaria(AuditMessage msg) {
		try {
			AuditRouterUtil.route(msg);
		} catch (AuditException e) {
			e.printStackTrace();
		}
	}

}
