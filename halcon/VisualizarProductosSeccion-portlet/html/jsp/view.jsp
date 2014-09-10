<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<portlet:defineObjects />
<%
ThemeDisplay themeDisplay=(ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
String nombrePagina=themeDisplay.getLayout().getName(themeDisplay.getLocale());
%>

 <div class="TC-content separado">
 
   <h2 class="titulo">${requestScope.titulo }</h2>
   <p>${requestScope.slogan }</p>
   
   <!-- Conenidos generales de Tajetas Credito -->
   <div class="TC-detail">
     <div class="TC-detail-cont">
     
     <!-- Lista de detalles -->
	  <c:forEach items="${requestScope.hermanos }" var="hermanos" >
		<c:choose>
			<c:when test="${hermanos.idContenidoSeccion != 0 }">
				<div class="TC-detail-prods perfilador-hp">
			  		<div class="TC-detail-noticia">
						<liferay-ui:journal-article articleId="${hermanos.idContenidoSeccion}" groupId="<%= themeDisplay.getScopeGroupId() %>" />
					</div>					
				</div>
			</c:when>
			<c:otherwise>
				   <div class="TC-detail-prods perfilador-hp"> <!-- Bloque de textos -->
		              <div class="TC-detail-noticia">
							NO POSEE RESUMEN DEL PRODUCTO EN SECCIÓN PARA EL PRODUCTO "${hermanos.nombre}".
		              </div>
		            </div>
			</c:otherwise>
		</c:choose>
	  </c:forEach>	

     <!-- Lista de detalles Adicionales-->
	  <c:forEach items="${requestScope.adicionales}" var="adicionales" >
		<c:choose>
			<c:when test="${adicionales.idContenidoSeccion != 0 }">
				<div class="TC-detail-prods perfilador-hp">
			  		<div class="TC-detail-noticia">
						<liferay-ui:journal-article articleId="${adicionales.idContenidoSeccion}" groupId="<%= themeDisplay.getScopeGroupId() %>" />
					</div>					
				</div>
			</c:when>
			<c:otherwise>
				   <div class="TC-detail-prods perfilador-hp"> <!-- Bloque de textos -->
		              <div class="TC-detail-noticia">
							NO POSEE RESUMEN DEL PRODUCTO EN SECCIÓN PARA EL PRODUCTO "${adicionales.nombre}".
		              </div>
		            </div>
			</c:otherwise>
		</c:choose>
	  </c:forEach>
     </div>

     <!-- Elemeto List Products Tarjetas Credito -->
     <div class="TC-pestana">
          <c:forEach items="${requestScope.hermanos }" var="hermanos" varStatus="i">
             <c:set var="estiloPrimero" value=""/>
             <c:set var="estiloIMG" value=""/>
             <c:if test="${i.index==0 }"><c:set var="estiloPrimero" value="this"/></c:if>
             <c:if test="${hermanos.idImagen>0}"><c:set var="estiloIMG" value="conimg"/></c:if>
             
                  <div class="elemento ${estiloPrimero}"> <a href="#" title="${hermanos.nombre}" class="credit-tab-hp ${estiloIMG}" onClick="_gaq.push(['_trackEvent', 'Sección de Producto', '${hermanos.nombre}', '<%=nombrePagina%>']);">
		            <span class="C-center"> 
		            	<c:if test="${hermanos.idImagen>0}">
		            		<img width="27" border="0" height="29" class="fix-png" src="${hermanos.urlImagen}">
		            		<br/>
		            	</c:if>
		            	
		            	
		            	<c:choose>
		            		<c:when test="${fn:length(hermanos.nombre) > 60}">
		            			${fn:substring(hermanos.nombre, 0, 60)}
		            		</c:when>
		            		<c:otherwise>
		            			${hermanos.nombre}
		            		</c:otherwise>
		            	</c:choose>
		            </span>
		            </a> 
		          </div>
          </c:forEach>
       <!-- Elemeto List Products Tarjetas Credito Adicionales -->
       <c:if test="${not empty requestScope.adicionales }">
       		  <div class="elemento">
		         <div class="interes"> <span class="bttn-pos">Tambi&eacute;n podria <br />
		           interesarte</span> </div>
		       </div>
		       
		       <c:forEach items="${requestScope.adicionales }" var="adicionales" varStatus="i">
		       		<c:set var="estiloPrimero" value=""/>
		       		<c:set var="estiloIMG" value=""/>
             		<c:if test="${i.index==0 }"><c:set var="estiloPrimero" value="this"/></c:if>
             		 <c:if test="${adicionales.idImagen>0}"><c:set var="estiloIMG" value="conimg"/></c:if>
		       
		             <div class="elemento ${estiloPrimero}"> <a href="#" title="${adicionales.nombre}" class="credit-tab-hp ${estiloIMG}" onClick="_gaq.push(['_trackEvent', 'Sección de Producto', 'Relacionados-${adicionales.nombre}', '<%=nombrePagina%>']);">
			           <span class="C-center">
				           <c:if test="${adicionales.idImagen>0}">
			            		<img width="27" border="0" height="29" class="fix-png" src="${adicionales.urlImagen}">
			            		<br/>
			            	</c:if>
			           		<c:choose>
			            		<c:when test="${fn:length(adicionales.nombre) > 60}">
			            			${fn:substring(adicionales.nombre, 0, 60)}
			            		</c:when>
			            		<c:otherwise>
			            			${adicionales.nombre}
			            		</c:otherwise>
		            	</c:choose>
			           </span>
			           </a> 
			         </div>
		       </c:forEach>
       </c:if>

     </div>
   </div>
   <br class="both" />
   
 </div>