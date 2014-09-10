
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>

<%
ThemeDisplay themeDisplay=(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
String url = themeDisplay.getURLPortal() + "/sala-de-prensa/" ;
String url2 = themeDisplay.getURLPortal() + "/notas-de-prensa/" ;
%>

<portlet:defineObjects />

      <div class="nrela">
        <div>
          <h2>Sala de Prensa</h2>
          <div id="socials" class=" float-right">
            <ul>
			  <li><a href="https://www.facebook.com/InterbankPeru" title="Interbank en Facebook" target="_BLANK" class="soc-fb">Interbank en Facebook</a></li>
              <li><a href="https://twitter.com/interbank" title="Interbank en Twitter"  target="_BLANK" class="soc-twitter">Interbank en Twitter</a></li>
              <li><a href="https://www.youtube.com/user/InterbankDigital"  target="_BLANK" title="Interbank en Youtube" class="soc-youtb">Interbank en Youtube</a></li>
            </ul>
          </div>
          <div class="both"></div>
        </div>
        <div class="slider-rc">
          <div class="contsld">
            <ul>
                
               	<c:forEach var="d" items="${lstEventos}" >                
              <li>
                <div class="contsldev">
                  <a href="${d.url}" title="${d.titulo}">${d.titulo}</a>
                
                  <p class="descrip">${d.resumen}</p>
                  <a href="<%=url2%>" title="Ver más notas de prensa">Ver más notas de prensa</a> </div>
              </li>
                </c:forEach> 
              <li>
                <div class="contsldev no-bd">
                  <p class="descrip">Esta sección está dirigida exclusivamente a los medios de comunicación que deseen información actual de las últimas notas de prensa sobre Interbank.</p>
                  <a href="<%=url%>" title="Contáctanos / Banco de Fotos">Contáctanos / Banco de Fotos</a> </div>
              </li>
            </ul>
          </div>
        </div>
      </div>