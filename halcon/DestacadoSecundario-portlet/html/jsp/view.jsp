<%@page import="java.net.URLEncoder"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />

<%
ThemeDisplay themeDisplay=(ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
%>

<div class="content-general" id="ultimo">
  
	<liferay-ui:journal-article articleId="${requestScope.codContenidoWeb1}" groupId="<%= themeDisplay.getScopeGroupId() %>" />
    
    
	<liferay-ui:journal-article articleId="${requestScope.codContenidoWeb2}" groupId="<%= themeDisplay.getScopeGroupId() %>" />
    
    
    <liferay-ui:journal-article articleId="${requestScope.codContenidoWeb3}" groupId="<%= themeDisplay.getScopeGroupId() %>" />
    
    
    <liferay-ui:journal-article articleId="${requestScope.codContenidoWeb4}" groupId="<%= themeDisplay.getScopeGroupId() %>" />
    
        
    <div class="both"></div>
</div>