<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<% String t = themeDisplay.getPathThemeImages(); 
	String rutaImagenes = t + "/halcon/"; 
	long groupId = themeDisplay.getScopeGroupId(); %>

<c:set var="urlImagen" value="<%=rutaImagenes %>"/>
