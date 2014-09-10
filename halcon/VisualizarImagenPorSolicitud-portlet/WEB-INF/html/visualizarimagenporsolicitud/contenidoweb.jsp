<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<portlet:defineObjects />
<c:if test="${mostrarContenido}">

	<link href="/halcon-theme/css/lightbox.css" rel="stylesheet"
		type="text/css" />
	<link href="/halcon-theme/css/styles.css" rel="stylesheet"
		type="text/css" />
	<!--[if IE 7]><link href="/halcon-theme/css/stylesie7.css" rel="stylesheet" type="text/css" /><![endif]-->
	<!--[if IE 6]><link href="/halcon-theme/css/stylesie6.css" rel="stylesheet" type="text/css" /><![endif]-->
	<style type="text/css">
.wd625px {
	width: 625px !important;
}

body.portal-popup {
	padding: 0 !important;
}
</style>
	<script type="text/javascript"
		src="/halcon-theme/js/halcon/mootools.core.js"></script>
 	<script type="text/javascript"
 		src="/halcon-theme/js/halcon/mootools.more.js"></script> 
	<script type="text/javascript" src="/halcon-theme/js/halcon/rotater.js"></script>
	<script type="text/javascript" src="/halcon-theme/js/halcon/tabs.js"></script>
	<script type="text/javascript"
		src="/halcon-theme/js/halcon/scrollable.js"></script>
	<script type="text/javascript"
		src="/halcon-theme/js/halcon/DD_roundies.js"></script>
	<script type="text/javascript"
		src="/halcon-theme/js/halcon/functions.js"></script>
	<script type="text/javascript">
		window.addEvent("domready", function() {
			iTabs('.tab-dp', '.feature-dp', true);
		});
	</script>


	<div class="content-milkbox wd625px">
		<div class="cabecera-lbox wd625px"></div>
		<div class="det-producto-pes separacion wd625px">
			<div class="sec-pes">
				<ul>
					<c:forEach items="${listaContenidoWeb}" var="c">
						<c:choose>
							<c:when test="${c.saltoLinea}">
								<li><a href="javascript:void(0)" title="${c.titulo}"
									class="tab-dp dlinea active"><span class="dlinea">${c.tituloHTML}</span></a></li>
							</c:when>
							<c:otherwise>
								<li><a href="javascript:void(0)" title="${c.titulo}"
									class="tab-dp">${c.titulo}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>
			</div>

			<div class="sec-det">
				<c:forEach items="${listaContenidoWeb}" var="c">
					${c.contenido}
				</c:forEach>
			</div>
		</div>
		<div class="clear"></div>
		<br class="clear" />
	</div>
</c:if>