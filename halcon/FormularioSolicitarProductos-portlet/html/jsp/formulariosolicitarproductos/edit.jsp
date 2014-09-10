<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<liferay-theme:defineObjects />





<form action="" method="post" name="fmVPS" id="fmVPS">
  <div class="cont_p">
	<div class="headT">
        <p>Configuración de formularios de solicitud.</p> 
	</div>
	
	<div class="cuerpoT">
             	<p>Tipo de Formulario: </p> 
              <select style="width: 250px;" name="<portlet:namespace/>formato" id="formato">
               		<option value="0"  <c:if test="${requestScope.formato==0}">selected="selected"</c:if> >Seleccione un Producto</option>
               		<option value="1"  <c:if test="${requestScope.formato==1}">selected="selected"</c:if> >Credito Hipotecario</option>
               		<option value="2"  <c:if test="${requestScope.formato==2}">selected="selected"</c:if> >Credito Vehicular</option>
               		<option value="3"  <c:if test="${requestScope.formato==3}">selected="selected"</c:if> >Cuenta Sueldo</option>
               		<option value="4"  <c:if test="${requestScope.formato==4}">selected="selected"</c:if> >Fondos Mutuos</option>
               		<option value="5"  <c:if test="${requestScope.formato==5}">selected="selected"</c:if> >Préstamo Personal</option>
               		<option value="6"  <c:if test="${requestScope.formato==6}">selected="selected"</c:if> >Producto Pre-Aprobado</option>
               		<option value="7"  <c:if test="${requestScope.formato==7}">selected="selected"</c:if> >Seguro SOAT</option>
               		<option value="8"  <c:if test="${requestScope.formato==8}">selected="selected"</c:if> >Tarjeta de Crédito</option>
               </select>
				<div class="both"></div>
             	<p>Producto Complementario 1: </p>
				<input type="text" name="<portlet:namespace/>idcw1" id="idcw1" value="${requestScope.codContenidoWeb1}" class="no-float"/> <liferay-ui:icon-help message="Ingrese el id de identificador de contenido Web asociado a este producto complementario." />
             
             	<p>Producto Complementario 2: </p>
				<input type="text"  name="<portlet:namespace/>idcw2" id="idcw2" value="${requestScope.codContenidoWeb2}" class="no-float"/> <liferay-ui:icon-help message="Ingrese el id de identificador de contenido Web asociado a este producto complementario." />
         
             	<p>Producto Complementario 3: </p>
				<input type="text"  name="<portlet:namespace/>idcw3" id="idcw3" value="${requestScope.codContenidoWeb3}" class="no-float"/> <liferay-ui:icon-help message="Ingrese el id de identificador de contenido Web asociado a este producto complementario." />

             	<p>Producto Complementario 4: </p>
				<input type="text"  name="<portlet:namespace/>idcw4" id="idcw4" value="${requestScope.codContenidoWeb4}" class="no-float"/> <liferay-ui:icon-help message="Ingrese el id de identificador de contenido Web asociado a este producto complementario." />

             	<p>Producto Complementario 5: </p>
				<input type="text"  name="<portlet:namespace/>idcw5" id="idcw5" value="${requestScope.codContenidoWeb5}" class="no-float"/> <liferay-ui:icon-help message="Ingrese el id de identificador de contenido Web asociado a este producto complementario." />
				<div class="both"></div>
				<div class="espaciado25"></div>
				
           <div class="bluebtn-cont width-sol sin-margin">
	           <input type="button" class="boton-form33" name="optRegistrar" id="optRegistrar" value="Guardar" url="<portlet:actionURL name="actionRegistrar" />"> 
           </div>
           <div class="both"></div>
	 </div>
    <liferay-ui:success key="successEditRegistra" message="Se guardo correctamente." />
    <liferay-ui:error key="errorEditRegistra" message="No se pudo guardar, por favor intentelo nuevamente." />
  </div>
</form>
<input type="hidden" id="obtenerFormato" name="obtenerFormato" value="${requestScope.formato}"/>
<input type="hidden" id="obtenerContenidos" name="obtenerContenidos" value="<portlet:resourceURL id="obtenerContenidos" />"/>