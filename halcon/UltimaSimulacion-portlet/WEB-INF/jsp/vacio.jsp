<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<%
ThemeDisplay themeDisplay=(ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
%>

<%if(!themeDisplay.isSignedIn()) {%>
<style>
#p_p_id_ultimasimulacion_WAR_UltimaSimulacionportlet_{
	display: none;
}
</style>
<%}%>
 