<%@page import="com.exp.portlet.halcon.utils.SimuladoresUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<portlet:defineObjects />
<script>
_gaq.push(['_trackEvent', 'Simulaciones', 'Simulacion finalizada', 'Dep&oacute;sito a Plazo']);
</script>
<div id="content-medio-template">
	<div class="det-producto-pes ">

		<!--        <div class="verdes">
         	<a href="#" title="Comparar con Crédito Tradicional">Comparar con Crédito Tradicional</a>
         </div>-->

		<div class="sec-pes">
			<ul>
				<li><a title="Deposito a Plazo"
					class="tab-dp tab-dp-sim active" href="#">Depósito a Plazo</a></li>
			</ul>
		</div>
		<div class="sec-det-III">
			<div class="feature-dp feature-dp-sim" style="z-index: 79;">
				<div class="content-dp">
					<!-- Inicio del Contenedor del CVT -->

					<c:forEach items="${requestScope.simulaciones }" var="simulacion">
						<div
							class="cvt-content <c:if test='${requestScope.plazoSimulacion ==  simulacion.plazo}'>cvt-content-II</c:if>">
							<h2>Depósito a Plazo</h2>
							<ul>
								<li class="borderTop"><span class="aumentado">${simulacion.plazo}</span>
									d&iacute;as</li>
								<li><span class="aumentado aumentado-II">${requestScope.simboloMoneda }
										<fmt:formatNumber value="${simulacion.tasaComision}"
											pattern="#,###,##0.00" />
								</span><br> &nbsp;Inter&eacute;s Ganado</li>
								<li><span class="aumentado-III">${requestScope.simboloMoneda }
										<fmt:formatNumber value="${simulacion.montoFinanciar}"
											pattern="#,###,##0.00" />
								</span> <br class="both"> <span>&nbsp;Monto Final</span></li>
								<li><span class="aumentado-III">${simulacion.tasaCostoEfectivo }%</span><br
									class="both"> <span>&nbsp;TREA</span></li>
							</ul>
							<div class="both"></div>
						</div>
					</c:forEach>






					<br class="both">
					<div class="cvt-finales">
						<p class="cvt-links">
							<a class="simulaLink" title="Volver a simular"
								href="${requestScope.urlVolver}" onclick="_gaq.push(['_trackEvent', 'Simulaciones', 'Volver a simular', 'Dep&oacute;sito a Plazo']);">Volver a simular</a> <a
								title="Ver detalle del producto" href="${requestScope.urlFicha}" onclick="_gaq.push(['_trackEvent', 'Simulaciones', 'Ver detalle del producto', 'Dep&oacute;sito a Plazo']);">Ver
								detalle del producto</a>
						</p>
						<p>En Dep&oacute;sitos a Plazo no se cobra comisiones ni otros
							gastos, por lo que la TREA es igual a la TEA (a&ntilde;o 360
							días).</p>


					</div>

				</div>
			</div>
		</div>
	</div>
</div>
<br class="both">

<input type="hidden" name="simuladorCookieDeposito"
	id="simuladorCookieDeposito" value="${requestScope.simuladorCookie}" />
<input type="hidden"
	value="<portlet:resourceURL id="redireccionSimulador"/>"
	name="redireccionSimulador" id="redireccionSimulador" />
<input type="hidden" value="<%=SimuladoresUtil.SIMULADOR_PLAZO_FIJO%>"
	name="tipSim" id="tipSim" />