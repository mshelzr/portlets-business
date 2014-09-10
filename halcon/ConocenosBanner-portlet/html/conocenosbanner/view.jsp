<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />
<!--contenido -->
  <div id="xgallery" class="f-explora roundy">
    <div class="gallery gallery5 gallery-fade imgslide2">
      <div class="holder imgslide2">
        <ul class="img-tamano">
       <c:forEach var="d" items="${lstBanner}" >    
        
        <li class="img-tamano imgslide2">
           
        <c:if test="${d.urlImagen!=''}">
            <div class="flimg"><img src="${d.urlImagen}" class="imgslide2 red-img" alt="Conocenos"/></div>
            <div class="ftxt">
              <h2>${d.titulo}</h2>
              <p>${d.resumen}</p>
              <a href="${d.enlace}">Ver más detalles</a> </div>
            <div class="both"></div>
        </c:if>
        
        <c:if test="${d.urlImagen==''}">
            <div class="flimg"><img class="imgslide2 red-img" alt="Vacio, no hay imagen para mostrar"/></div>
            <div class="ftxt">
              <h2>${d.titulo}</h2>
              <p>${d.resumen}</p>
              <a href="${d.enlace}">Ver más detalles</a> </div>
            <div class="both"></div>
        </c:if>
          
       </li>
        </c:forEach> 
         </ul>
      </div>
    </div>
  </div>