<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<portlet:defineObjects />

  <div class="servicios-hi">
    <div class="titulo-ser-hi2">
     <c:forEach items="${requestScope.mapa }" var="cabecera" varStatus="i">
        <c:set var="styleCabecera" value=""/>
        <c:if test="${i.last }"><c:set var="styleCabecera" value="no-margin"/></c:if>
    
       <div class="sec-titulo-ser2 ${styleCabecera }"> 
<%--        		<img width="37" height="26" border="0" class="float-left fix-png" src="${cabecera.key.urlImagen}"> --%>
       		<img width="21" height="19" border="0" class="float-left fix-png" src="/halcon-theme/images/halcon/ico-ibk.gif">
        	<h3>${cabecera.key.titulo}</h3>
 	     </div>
		<c:if test="${i.last}"><br class="both"></c:if>
     </c:forEach>
   </div>
     
    <div class="lista-ser-hi2">
        <c:forEach items="${requestScope.mapa }" var="pie" varStatus="i">
            <c:set var="stylePie" value=""/>
	        <c:if test="${i.last }"><c:set var="stylePie" value="big-ser mad"/></c:if>
	        
          <ul class="${stylePie }">
	        <c:forEach items="${pie.value}" var="lista" varStatus="j">
	        	<c:set var="styleLista" value=""/>
	        	<c:if test="${j.index==0 }"><c:set var="styleLista" value="sin-border"/></c:if>
	            <li class="${styleLista }"><a href="${lista.url}" title="${lista.titulo}">${lista.titulo}</a></li>
	        </c:forEach>
	      </ul>
	      
	      <c:if test="${i.last}"><div class="both" ></div></c:if>
	    </c:forEach>
    </div>
    <br class="both">
    
  </div>