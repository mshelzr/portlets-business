<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<liferay-theme:defineObjects />

<!-- IdContenidoWeb1		22937 -->
<!-- IdContenidoWeb2		22962 -->
<!-- IdContenidoWeb3		22108 -->
<!-- IdContenidoWeb4		22144 -->

<portlet:defineObjects />
<form action="" method="post" name="fmVPS" id="fmVPS">
 <div class="sidebar">
   <div id="perfil" class="insurance">
     <div id="paso1" class="profile position">
       <div class="content">
         <div class="head"> <span>Configuración de destacados por nivel.</span> </div>
         <div class="body seguros">
           <div class="content-head"></div>
         <div class="content-body">
           
             <div class="title"> 
             	<h2>Ingrese ID de Identificador Contenido Web 1: </h2>
				<input type="text" name="<portlet:namespace/>idcw1" id="idcw1" value="${requestScope.codContenidoWeb1}"/> <liferay-ui:icon-help message="Ingrese el id de identificador de contenido Web asociado." />
             </div>
             
             <div class="title"> 
             	<h2>Ingrese ID de Identificador Contenido Web 2: </h2>
				<input type="text" name="<portlet:namespace/>idcw2" id="idcw2" value="${requestScope.codContenidoWeb2}"/> <liferay-ui:icon-help message="Ingrese el id de identificador de contenido Web asociado." />
             </div>
             
             <div class="title"> 
             	<h2>Ingrese ID de Identificador Contenido Web 3: </h2>
				<input type="text"  name="<portlet:namespace/>idcw3" id="idcw3" value="${requestScope.codContenidoWeb3}"/> <liferay-ui:icon-help message="Ingrese el id de identificador de contenido Web asociado." />
             </div>

             <div class="title"> 
             	<h2>Ingrese ID de Identificador Contenido Web 4: </h2>
				<input type="text"  name="<portlet:namespace/>idcw4" id="idcw4" value="${requestScope.codContenidoWeb4}"/> <liferay-ui:icon-help message="Ingrese el id de identificador de contenido Web asociado." />
             </div>

            <div class="title"> 
           </div>
        
        </div>
           <div class="footer"> 
	           <input type="button" name="optRegistrarDN" id="optRegistrarDN" value="Guardar" url="<portlet:actionURL name="actionRegistrar" />"> 
           </div>
                      
         </div>
       </div>
     </div>
   </div>
<liferay-ui:success key="successEditRegistra" message="Se guardo correctamente." />
<liferay-ui:error key="errorEditRegistra" message="No se pudo guardar, por favor intentelo nuevamente." />
 </div>
 	<div class="both"></div>
</form>
