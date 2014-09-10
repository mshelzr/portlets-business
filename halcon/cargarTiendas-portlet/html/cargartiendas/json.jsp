<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

<div id="jsonRespuesta">
${gsonString}
</div>

<%
ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
String urlPortal = themeDisplay.getURLPortal();
%>

<script type="text/javascript"  src="<%=urlPortal%>/halcon-theme/js/halcon/mootools.core.js"> </script>
<script type="text/javascript"  src="<%=urlPortal%>/halcon-theme/js/halcon/mootools.more.js"> </script>