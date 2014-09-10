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

<%@page import="pe.com.ibk.halcon.contenidoweb.model.BuscadorBean"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<portlet:defineObjects />


<%-- <% --%>
<!-- // 	List<BuscadorBean> resultados=(List<BuscadorBean>)renderRequest.getAttribute("resultado"); -->
<%-- %> --%>

<div class="error-cont">
        <div class="error-dialog"> <img src="/PaginaError404-portlet/img/error-img-00.jpg" border="0" align="middle"  alt="Ups..."/>
        <c:choose>
        	<c:when test="${requestScope.resultado==null}">
        	 <h2>¡Lo sentimos!</h2>
	          <p>pero la página que busca no ha sido encontrada.</p>
	          <p class="special">No se preocupe, le pasa al mejor de nosotros.</p>
	          <br class="both">
        	</c:when>
        	<c:otherwise>
        		<div class="float-left">
		            <h2>¡Lo sentimos!</h2>
		            <p>pero la página que buscas no ha sido encontrada.</p>
		            <p class="mg13">No te preocupes, le pasa al mejor de nosotros.</p>
		            <p class="mg16">Tal vez te interese:</p>
		            <ul class="bluelist">
				       <c:forEach items="${requestScope.resultado}" var="resultado">
		          		<li>
		            		 <a href="${resultado.url}" >${resultado.titulo}</a>
				        </li>
				       </c:forEach>
		            </ul>
          		</div>
          		<br class="both">
        	</c:otherwise>
        </c:choose>
         
            
        </div>
        <div class="cntr">
<a href="javascript:history.back(1)" title="Página anterior" class="ant" ><em></em>Página anterior</a> 
<a href="/" title="Ir al Home" class="home" ><em></em>Ir al Home</a> </div>
<br class="both">

</div>
