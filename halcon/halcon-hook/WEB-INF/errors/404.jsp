<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="com.liferay.portal.kernel.search.Hits"%>
<%@page import="com.liferay.portal.kernel.search.Document"%>
<%@page import="com.liferay.portal.kernel.search.SearchEngineUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.liferay.portal.kernel.search.Sort"%>
<%@page import="com.liferay.portal.kernel.search.BooleanClauseOccur"%>
<%@page import="com.liferay.portal.model.GroupConstants"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>

<%-- <%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %> --%>
<!-- <liferay-theme:defineObjects /> -->

<!-- <body> -->
<!-- <script type="text/javascript"> -->
<!-- // window.location="http://www.cristalab.com"; -->
<!-- </script> -->
<!-- </body> -->

<%
	String palabraClave = StringUtil.extractLast(PortalUtil.getCurrentURL(request), "/");
	ThemeDisplay themeDisplay=(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	String url = PortalUtil.getPortalURL(request) + "/error404?key=" + palabraClave;
	response.sendRedirect(url);
	
%>