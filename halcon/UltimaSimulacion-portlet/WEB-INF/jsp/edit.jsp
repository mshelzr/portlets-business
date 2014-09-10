<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<div id="content-medio" class="roundy wd623" style="float: none;">
	<div class="inform">
		<p>
		Seleccione el tipo de simulador a mostrar.
		</p>
		<form action="<portlet:actionURL name="actionURL" />" name="<portlet:namespace/>fm1" method="post">
		<div class="paraelform">
			
			<div class="campos-oblig"> 
				<label>Tipo de Simulador</label> 
				<select name="tipoSimulador">
				 <option value="">Seleccione el tipo de simulador</option>
				  <c:forEach var="simulador" items="${requestScope.listaSimuladores }">
				  	 <option value="${simulador.codigo }" <c:if test="${requestScope.tipoSimulador==simulador.codigo}">selected="selected"</c:if> >${simulador.nombre }</option>
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