<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<div id="content-medio" class="roundy wd623">
	<div class="inform">
		<p>
		Seleccione la carpeta de videos que se mostrará. Recuerde que la carpeta padre es "Videos".
		</p>
		<form action="<portlet:actionURL name="actionURL" />" name="<portlet:namespace/>fm1" method="post">
		<div class="paraelform">
			
			<div class="campos-oblig"> 
				<label>Carpeta de Videos</label> 
				<select name="nombreCarpeta">
				 <option value="">Seleccione una carpeta</option>
				  <c:forEach var="carpeta" items="${requestScope.carpetas }">
				  	 <option value="${carpeta.name }" <c:if test="${requestScope.nombreCarpeta==carpeta.name}">selected="selected"</c:if> >${carpeta.name }</option>
				  </c:forEach>
				</select>
            </div>
	      
		</div>
		<div  class="soli-formato">
			<input type="submit" name="<portlet:namespace/>btnEnviar" value="Guardar"/> 
		</div>
		</form>
		<liferay-ui:success key="successEdit" message="Se actualizo el parámetro correctamente." />
		<liferay-ui:error key="errorEdit" message="No se pudo registrar el parámetro intentelo de nuevo." />
	</div>
</div>