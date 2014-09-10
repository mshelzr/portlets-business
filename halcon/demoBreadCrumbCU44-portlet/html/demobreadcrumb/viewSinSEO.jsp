
<%@page import="java.net.URLEncoder"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>

<portlet:defineObjects />

    <div id="fb-root"></div>
    
	<script>(function(d, s, id) {
	  var js, fjs = d.getElementsByTagName(s)[0];
	  if (d.getElementById(id)) return;
	  js = d.createElement(s); js.id = id;
	  js.src = "//connect.facebook.net/es_LA/all.js#xfbml=1";
	  fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));</script>

<!-- Inserta esta etiqueta en la sección "head" o justo antes de la etiqueta "body" de cierre. -->
<script type="text/javascript" src="https://apis.google.com/js/plusone.js">
  {lang: 'es', parsetags: 'explicit'}
</script>

<%
String pageActual = (String)request.getAttribute("title");

String  url = (String)request.getAttribute("urlActual");

String linkHrefF = "https://www.facebook.com/plugins/like.php?href=" +url +"&amp;send=false&amp;layout=standard&amp;width=450&amp;show_faces=true&amp;font&amp;colorscheme=light&amp;action=recommend&amp;height=21";
String linkHrefT = "https://platform.twitter.com/widgets/tweet_button.html?url=" +url +"&amp;count=horizontal&amp;text=" + (URLEncoder.encode(pageActual, "UTF-8").replace("+", "%20"));
%>

  <!--CONTENIDO-->
  <div class="contenido-sol"> 
 <!--sub-cabecera-->
    <div class="subcabecera-template">
      <div class="sub-titulo">
        <h1 id="tituloCabeceraBreadCrumb">${requestScope.title}</h1>
        <div class="social-media float-right">
			
			<!-- Inserta el Botón +1. -->
			<div class="social-media-google float-right">
			  <!-- Inserta esta etiqueta donde quieras que aparezca Botón +1. -->
				<div class="g-plusone" data-size="medium" data-href="<%=url%>"></div>
	        </div>
	        
	         <!--3 facebook  -->
	         <div class="social-media-recomendar float-right">
				<fb:like href="<%=url%>" send="false" width="75" layout="button_count" show_faces="false" font="" action="recommend">
				</fb:like>				
				
	         </div>
          	<!-- 2 twitter -->
          	<div class="social-media-tweet float-right">
				<iframe allowtransparency="true" frameborder="0" style="height: 21px; width: 100px;" scrolling="no" src="<%=linkHrefT %>" ></iframe>
				
          	</div>
          	
          	<!-- 1 Enviar Correo -->
			<input type="hidden" id="enviarCorreoHidden" value='<portlet:resourceURL id="enviarRecomendacion" />'  />		
          	<a class="social-media-correo float-right" href="/demoBreadCrumbCU44-portlet/template/recomendado.html" data-milkbox="milkbox:g1" data-milkbox-size="width:345,height:600" title="Recomendado" ></a>         	
			
			<!-- AddThis Button BEGIN -->
          	<div>
			  <div class="addthis_toolbox addthis_default_style addthis_32x32_style">
					<a class="addthis_button_preferred_3"></a>
			  </div>
          	</div>
          	
          	<div style="display: none;"><a id="linkup" href="/demoBreadCrumbCU44-portlet/template/recomendadok.html" data-milkbox="milkbox:g2" data-milkbox-size="width:340,height:588" title="Recomendado"  ></a></div>
        </div>
        
      </div>
      <div class="subcabecera-template">
      	<c:choose>
			  <c:when test="${contenidoPage ne ''}">
			        <p>${requestScope.contenidoPage}</p>
			  </c:when>
		</c:choose>
		<c:choose>
			<c:when test="${sloganExt ne ''}">
			  		<br/><p style="padding-bottom: 10px">${requestScope.sloganExt}</p>
			  </c:when>
		</c:choose>
		<c:choose>
			<c:when test="${sloganExt ne '' or contenidoPage ne ''}">
			  		<div style="padding-bottom: 10px"></div>
			</c:when>
		</c:choose>
       </div>	
    </div>
    </div>
    
<!-- Inserta esta invocación donde quieras. -->
<script type="text/javascript">

	if(Liferay.Browser.isIe() && (Liferay.Browser.getMajorVersion()==6 || Liferay.Browser.getMajorVersion()==7)){
		
	}else{
		gapi.plusone.go();
	}

</script>
<input type="hidden" name="snippetTitulo" id="snippetTitulo" value="${requestScope.titleSnippet }"/>
