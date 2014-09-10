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
ThemeDisplay themeDisplay2=(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

String url = themeDisplay2.getURLPortal() + themeDisplay2.getURLCurrent();
url = URLEncoder.encode(url, "UTF-8");

String linkHrefF = "//www.facebook.com/plugins/like.php?href=" +url +"&amp;send=false&amp;layout=button_count&amp;width=117&amp;show_faces=false&amp;font&amp;colorscheme=light&amp;action=like&amp;height=21";

%>

<%-- <iframe src=<%=linkHrefF%> scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:117px; height:21px;" allowTransparency="true"></iframe> --%>
<!-- <iframe src="//www.facebook.com/plugins/like.php?href=http%3A%2F%2Fwww.facebook.com%2FInterbankPeru&amp;send=false&amp;layout=button_count&amp;width=117&amp;show_faces=false&amp;font&amp;colorscheme=light&amp;action=like&amp;height=21" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:117px; height:21px;" allowTransparency="true"></iframe> -->
<!-- IdContenidoWeb1		22937 -->
<!-- IdContenidoWeb2		22962 -->
<!-- IdContenidoWeb3		22108 -->
<!-- IdContenidoWeb4		22144 -->


<div class="content-general" id="ultimo">

	 <liferay-ui:journal-article articleId="${requestScope.codContenidoWeb1}" groupId="<%= themeDisplay.getScopeGroupId() %>" />

	 <liferay-ui:journal-article articleId="${requestScope.codContenidoWeb2}" groupId="<%= themeDisplay.getScopeGroupId() %>" />

	 <liferay-ui:journal-article articleId="${requestScope.codContenidoWeb3}" groupId="<%= themeDisplay.getScopeGroupId() %>" />

	 <liferay-ui:journal-article articleId="${requestScope.codContenidoWeb4}" groupId="<%= themeDisplay.getScopeGroupId() %>" />

	<div class="both"></div>
</div>