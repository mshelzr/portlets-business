<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<portlet:defineObjects />

<div class="sidebar">
      <div class="roundy tarjetas-credito-ann sepbottom">
        <h2><em class="icons ico-tar chek-icon"></em>${requestScope.nombrePadre}</h2>
        <div class="lista roundy">
           
           <c:set var="estiloPrimero" value=""/>
           <c:if test="${fn:length(requestScope.hermanos) == 0}"><c:set var="estiloPrimero" value="nobd"/></c:if>

            <c:forEach items="${requestScope.hermanos }" var="hermanos" varStatus="i">
                <c:set var="estiloFinal" value=""/>
                <c:if test="${i.last || fn:length(requestScope.hermanos) == 1}"><c:set var="estiloFinal" value="nobd"/></c:if>
            	 <a href="${hermanos.url }" title="${hermanos.nombre }" class="${estiloFinal}">${hermanos.nombre }</a>
            </c:forEach>
            
  
        </div>
        
      </div>
</div>
<br class="both">