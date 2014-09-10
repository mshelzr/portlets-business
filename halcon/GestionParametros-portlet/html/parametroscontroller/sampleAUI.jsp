<%--
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>

<portlet:defineObjects />

<link href="<c:url value="/css/ui-lightness/jquery-ui-1.9.1.custom.css"></c:url>" rel="stylesheet">
<link href="<c:url value="/css/ui-lightness/jquery-ui-1.9.1.custom.min.css"></c:url>" rel="stylesheet">
<link href="<c:url value="/css/ui-lightness/ui.jqgrid.css"></c:url>" rel="stylesheet">

<portlet:actionURL var="actionURL" name="actionListarParametro" />
<portlet:actionURL var="actionURLEditarParametro" name="actionEditarParametro" >
	<portlet:param name="page" value="listarParametro"/>
</portlet:actionURL>
<portlet:actionURL var="actionURLActivarParametro" name="actionActivarParametro" >
	<portlet:param name="page" value="listarParametro"/>
</portlet:actionURL>
<portlet:actionURL var="actionURLDesactivarParametro" name="actionDesactivarParametro" >
	<portlet:param name="page" value="listarParametro"/>
</portlet:actionURL>
<portlet:actionURL var="actionURLLimpiarListaParametro" name="actionLimpiarListaParametro" />
<portlet:actionURL var="actionURLNuevoParametro" name="actionNuevoParametro" >
	<portlet:param name="page" value="listarParametro"/>
</portlet:actionURL>


<%
List<String> lista = new ArrayList();
lista.add(0, "PRIMERO");
lista.add(1, "SEGUNDO");
lista.add(2, "TERCERO");

PortletURL portletURL = renderResponse.createActionURL();
    portletURL.setParameter("action", "search");
    portletURL.setParameter("entity", "hospital");
    portletURL.setParameter("search", "1"); 
%>

<liferay-ui:search-container iteratorURL="<%= portletURL %>" delta="1" emptyResultsMessage="No Hospitals Found.">
	<liferay-ui:search-container-results total="5" results="<%= lista %>" />
	<liferay-ui:search-container-row modelVar="numeros" className="java.lang.String" >
		 <liferay-ui:search-container-column-text name="HOSPITAL">
		 	Columna 1
		 </liferay-ui:search-container-column-text>
		 <liferay-ui:search-container-column-text name="DOCTORS">
		 	Columna 2
		 </liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
</liferay-ui:search-container>
