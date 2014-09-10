<%@ include file="/html/jsp/commons/init.jsp"%>	
<%@ include file="/html/jsp/commons/variables.jsp"%>
  <!--porlets-->
  <div class="content-porlet">
    <div id="contentListSimulator" class="porlet-left-hp">
      <ul id="listSimulator">
      	<c:forEach var="d" items="${lstDestacados}">
      		<c:choose>
      			<c:when test="${d.idTab eq 'SIM-PF' }">
      				 <li><a href="#" id="crePlazoFijo" title="Simulador Dep&oacute;sito a Plazo" class="tab-hp">Simulador Dep&oacute;sito a Plazo</a></li>	
      			</c:when>
      			<c:when test="${d.idTab eq 'SIM-VEH' }">
      				<li><a href="#" id="creVehicular" title="Simulador Cr&eacute;dito Vehicular" class="tab-hp">Simulador Cr&eacute;dito Vehicular</a></li>		
      			</c:when>
   				<c:when test="${d.idTab eq 'SIM-HIP' }">
   					<li><a href="#" id="creHipotecario" title="Simulador Cr&eacute;dito Hipotecario" class="tab-hp">Simulador Cr&eacute;dito Hipotecario</a></li>		
   				</c:when>
   				<c:when test="${d.idTab eq 'SIM-PER' }">
   					<li><a href="#" id="crePrestamo" title="Simulador Pr&eacute;stamo Personal" class="tab-hp">Simulador Pr&eacute;stamo Personal</a></li>		
   				</c:when>
   				<c:when test="${d.idTab eq 'SIM-FONDOS' }">
   					<li><a href="#" id="creFondosMutuos" title="Simulador Fondos Mutuos" class="tab-hp">Simulador Fondos Mutuos</a></li>	
   				</c:when>
   				<c:otherwise>
   					<li><a href="#" title="${d.titleTag}" class="tab-hp">${d.titleTag}</a></li>
   				</c:otherwise>
   			</c:choose>
   		</c:forEach>
      </ul>
    </div>
    
   
    <div class="porlet-right-hp new_bg">

		<c:forEach var="d" items="${lstDestacados}">
      		<c:choose>
      			<c:when test="${d.idSimulador eq 'SIM-PF' }">
      				 <%@ include file="/html/jsp/destacados/depositoPlazo.jsp"%>
      			</c:when>
      			<c:when test="${d.idSimulador eq 'SIM-VEH' }">
      				 <%@ include file="/html/jsp/destacados/vehicular.jsp"%>	
      			</c:when>
      			<c:when test="${d.idSimulador eq 'SIM-HIP' }">
      				 <%@ include file="/html/jsp/destacados/hipotecario.jsp"%>	
      			</c:when>
      			<c:when test="${d.idSimulador eq 'SIM-PER' }">
      				 <%@ include file="/html/jsp/destacados/personal.jsp"%>	
      			</c:when>
      			<c:when test="${d.idSimulador eq 'SIM-FONDOS' }">
      				 <%@ include file="/html/jsp/destacados/fondosMutuos.jsp"%>	
      			</c:when>
      			<c:otherwise>
      				<div class="feature-hp alt_med">
      					<liferay-ui:journal-article articleId="${d.idContenidoWeb}" groupId="<%=groupId %>" />
      				</div>
      			</c:otherwise>
      		</c:choose>
      	</c:forEach>

    </div>
    <br class="both" />
  </div>
  <input type="hidden" id="tiempoSlider" name="tiempoSlider" value="${requestScope.tiempoSlider }"/>