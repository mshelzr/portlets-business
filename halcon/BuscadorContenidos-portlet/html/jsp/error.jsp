<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<portlet:defineObjects />
    <!--sub-cabecera-->
    <div class="subcabecera-template">
      <div class="sub-titulo">
        <h1>Resultado de b�squeda</h1>
      </div>
      <!-- <p class="texto-sec">En Interbank sabemos que tu tiempo vale m�s que el dinero.</p> --> </div>
 <!--CONT-MEDIO-->
 <div id="content-medio">
   <div class="error-cont">
     <div class="error-dialog"> <img src="/halcon-theme/images/halcon/error-img-00.jpg" border="0" align="middle"  alt="Ups..."/>
       <h2>�Lo sentimos!</h2>
       <p>pero ocurri� un error mientras se procesaba su b�squeda.</p>
       <p class="special">No se preocupe, le pasa al mejor de nosotros.<br/>Intentel� de nuevo.</p>
       <br class="both">
     </div>
     <a href="/" title="Ir al Home" class="error-next" >Ir al Home</a> </div>
 </div>