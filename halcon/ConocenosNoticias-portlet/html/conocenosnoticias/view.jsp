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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>

<%
ThemeDisplay themeDisplay=(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
String url = themeDisplay.getURLPortal() + "/noticias" ;
%>
<portlet:defineObjects />

<div class="conttab">
      <div class="det-producto-pes wd305px">
        <div class="sec-pestana">
          <ul>
            <li><a href="#"  title="Noticias" class="tab-dp ">Noticias</a></li>
            <li><a href="#" title="Facebook" class="tab-dp" ><em class="fb">&nbsp;</em><span class="fixie6">Facebook</span></a></li>
            <li><a href="#" title="Twitter" class="tab-dp "><em class="tw">&nbsp;</em><span class="fixie6">Twitter</span></a></li>
          </ul>
        </div>
        <div class="sec-det hg600">
          <div class="feature-dp wd263px">
            <div class="notint">
              <h2>Noticias Interbank</h2>
              <div class="raya"></div>
       	
       	<c:forEach var="d" items="${lstNoticias}" >               
              <div class="noticia">
              
              <c:if test="${d.urlImagen!=''}">
                <div class="imagn"> 
                 <img src="${d.urlImagen}" border="0" alt="noticia 1" class="imagnPeque" /> 
                </div>
                <div class="cont1">
                  	<p class="tutilo">${d.titulo}</p>
                  	<p class="fechora"> ${d.fecha}</p>
                  	<p class="contenid">${d.resumen}</p>
                  	<a href="${d.url}" title="Ver más detalles">Ver más detalles</a> </div>
            	    <div class="both"></div>
                  	<div class="raya"></div>
                  </c:if>
                  
            	<c:if test="${d.urlImagen==''}">
                  	<p class="tutilo">${d.titulo}</p>
                  	<p class="fechora"> ${d.fecha}</p>
                  	<p class="contenid">${d.resumen}</p>
                  	<a href="${d.url}" title="Ver más detalles">Ver más detalles</a>
            	    <div class="both"></div>
                  	<div class="raya"></div>
                  </c:if>
                  
              </div>         
		 </c:forEach>   
		        
              <div class="lastvm">
				<a class="" href="<%=url%>">Ver más</a>
			</div>
            </div>
          </div>
          <div class="feature-dp wd263px">
            <div class="notint">
              <h2>Facebook Interbank</h2>
              <iframe src="https://www.facebook.com/plugins/likebox.php?href=http%3A%2F%2Fwww.facebook.com%2FInterbankPeru&width=263&height=510&colorscheme=light&show_faces=true&border_color=%23ffffff&stream=true&header=true" width="263" height="500" frameborder="0"></iframe>
            </div>
          </div>
          <div class="feature-dp wd263px">
            <div class="notint">
              <h2>Twitter Interbank</h2>
              <a class="twitter-timeline" width="263" height="500"  href="http://twitter.com/interbank" data-widget-id="254246472474824706">Tweets por @interbank</a>
              <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src="//platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
            </div>
          </div>
        </div>
        <br class="both"/>
      </div>
    </div>
