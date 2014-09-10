<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<portlet:defineObjects />
    <!--sub-cabecera-->
    <div class="subcabecera-template">
      <div class="sub-titulo">
        <h1>Resultado de búsqueda</h1>
      </div>
      <!-- <p class="texto-sec">En Interbank sabemos que tu tiempo vale más que el dinero.</p> --> </div>
 <!--CONT-MEDIO-->
 <div id="content-medio">
   <div class="error-cont">
     <div class="error-dialog"> <img src="/halcon-theme/images/halcon/error-img-00.jpg" border="0" align="middle"  alt="Ups..."/>
       <h2>¡Lo sentimos!</h2>
       <p>pero no se han encontrado resultados para su búsqueda.</p>
       <p class="special">No hay coincidencias para "${requestScope.keywords}"</p>
       <br class="both">
     </div>
     
     <div class="cntr"> 
     <a class="home" title="Ir al Home" href="/"><em></em>Ir al Home</a>
     </div>
     <br class="both">
  </div>
 </div>