package com.exp.portlet.halcon.utils;

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.audit.AuditMessage;
import com.liferay.portal.kernel.audit.AuditRouterUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;

public class AuditoriaHalcon {

	private static Log _log = LogFactoryUtil.getLog(AuditoriaHalcon.class);

	public static void auditar(AuditMessage auditMessage) {
		try {
			if (auditMessage != null) {
				_log.info(" AuditoriaHalcon message: " + auditMessage.getMessage());
				AuditRouterUtil.route(auditMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void auditar(String evento, String message, JSONObject infoAdicional, HttpServletRequest resq) {
		try {
			if (resq != null) {
				_log.info(" AuditoriaHalcon evento: " + evento + "  message:" + message + " infoAdicional:" + infoAdicional);
				ThemeDisplay themeDisplay = (ThemeDisplay) resq.getAttribute(WebKeys.THEME_DISPLAY);
				User user = themeDisplay.getUser();
				PortletDisplay porlet = themeDisplay.getPortletDisplay();
				AuditMessage auditMessage = new AuditMessage(evento, user.getCompanyId(), user.getUserId(), user.getFullName(), porlet.getPortletName(), porlet.getId(), message, infoAdicional);
				if (infoAdicional != null) {
					auditMessage.setAdditionalInfo(infoAdicional);
				}
				AuditRouterUtil.route(auditMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void auditar(String evento, String clase, String clasePK, String message, JSONObject infoAdicional, HttpServletRequest resq) {
		try {
			if (resq != null) {
				_log.info(" AuditoriaHalcon evento: " + evento + "  message:" + message + " infoAdicional:" + infoAdicional);
				ThemeDisplay themeDisplay = (ThemeDisplay) resq.getAttribute(WebKeys.THEME_DISPLAY);
				User user = themeDisplay.getUser();
				AuditMessage auditMessage = new AuditMessage(evento, user.getCompanyId(), user.getUserId(), user.getFullName(), clase, clasePK, message, infoAdicional);
				if (infoAdicional != null) {
					auditMessage.setAdditionalInfo(infoAdicional);
				}
				AuditRouterUtil.route(auditMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
