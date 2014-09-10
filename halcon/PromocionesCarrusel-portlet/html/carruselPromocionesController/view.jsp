<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:defineObjects />

<!--     contenido -->
<div class="f-conoce roundy">
	<div class="gallery gallery5 gallery-fade imgslide3">
		<div class="holder imgslide3">
			<ul class="img-tamano">
				<c:forEach var="p" items="${lstPromociones}" varStatus="i">
					<c:choose>
						<c:when test="${i.index == 0}">
							<li class="img-tamano imgslide3" style="opacity: 1; z-index: 11;">
						</c:when>
						<c:otherwise>
							<li class="img-tamano imgslide3" style="opacity: 0; z-index: 10;">
						</c:otherwise>
					</c:choose>
								<c:if test="${p.urlImagen!=''}">
									<a href="${p.urlDetalle}">
									    <img src="${p.urlImagen}" class="imgslide3 borde-redondo4" alt="${p.titulo}" />
									</a>
									<c:if test="${p.urlImagenPequenia!=''}">
										<div class="bannerPromo">
											<a href="${p.linkImagenPequenia}">
											  <img src="${p.urlImagenPequenia}" />
											</a>
										</div>
									</c:if>
								</c:if>
							</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>
