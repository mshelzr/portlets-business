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

<portlet:defineObjects />
<div class="sidebar">
<div class="sepbottom benner"> 
<c:if test="${not empty requestScope.codigoPromocion}">		
		<c:choose>
			<c:when test="${requestScope.extension == 'IMAGEN' }">
				<a href="${requestScope.urlPagina}${requestScope.urlString}" title="${requestScope.altImagen }">
					<img src="${requestScope.archivo}" width="305" alt="${requestScope.altImagen }" height="250"/>
				</a>
			</c:when>
			<c:otherwise>
				<a href="${requestScope.urlPagina}${requestScope.urlString}" title="${requestScope.descripcion }" style="position:relative; display:block">
				<div style="width:305px; height:250px; position:absolute; z-index:70; cursor:pointer; top:0; left:0; background:url(/halcon-theme/images/halcon/trans.gif)"></div>
					<object width="305" height="250">
					<param name="movie" value="${requestScope.archivo}"></param>
					<param name="allowFullScreen" value="true"></param>
					<param name="allowscriptaccess" value="always"></param>
					<param name="wmode" value="transparent" ></param>
					<embed src="${requestScope.archivo}" type="application/x-shockwave-flash" width="305" height="250" allowscriptaccess="always" allowfullscreen="true" wmode="transparent" style="z-index:1;position:relative;">
					</embed>
					</object>
				</a>
			</c:otherwise>
		</c:choose>
</c:if>
</div>
</div>
<div class="both"></div>