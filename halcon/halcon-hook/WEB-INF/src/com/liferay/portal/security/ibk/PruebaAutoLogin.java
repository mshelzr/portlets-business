package com.liferay.portal.security.ibk;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AutoLogin;
import com.liferay.portal.security.auth.AutoLoginException;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

public class PruebaAutoLogin implements AutoLogin {

	@Override
	public String[] login(HttpServletRequest request, HttpServletResponse response)
			throws AutoLoginException {
		
		String[] credentials = null;
		try {
			long companyId = PortalUtil.getCompanyId(request);
			
			User user = UserLocalServiceUtil.fetchUserByEmailAddress(companyId, "test@liferay.com");
			
			System.out.println("Hola");
			if (user != null && !user.getLoginIP().equals(request.getLocalAddr())) {
				System.out.println("Hola2");
				credentials = new String[3];

				credentials[0] = String.valueOf(user.getUserId());
				credentials[1] = user.getPassword();
				credentials[2] = Boolean.FALSE.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return credentials;
	}
	
	

}
