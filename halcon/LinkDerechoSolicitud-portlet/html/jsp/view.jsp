<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<portlet:defineObjects />
<c:set  var="mensaje2" value="${requestScope.mensaje2}"/>

 <!--sidebar-->
    <div class="sidebar"> 
      <!--tu-solicitud-->
      <div class="tu-solicitud">
        <h4>Más información del producto</h4>
      </div>
      <!--soli-desarrollo-->
      <div class="soli-desarrollo">
        <div class="soli-formato sin-border">
          <p>Tipo</p>
          <a href="${requestScope.url1}" title="${requestScope.mensaje1}"><p class="respuesta">${requestScope.mensaje1}</p></a>
        </div>
        
        <c:if test="${fn:length(mensaje2)>0}">
         <div class="soli-formato">
          <a href="${requestScope.url1}" title="${requestScope.mensaje2}"><p class="respuesta">${requestScope.mensaje2}</p></a>
        </div>
        </c:if>
        
        <div class="hgt10" ></div>
      </div>
    </div>
 <div class="both"></div>
   <div class="hgt10" ></div>
 
