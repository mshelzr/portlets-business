<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ page import="javax.portlet.RenderRequest"%>
<%@ page import="javax.portlet.PortletSession"%>


<liferay-theme:defineObjects />
<%
	String ruta = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
	
	System.out.println(ruta);

%>
<portlet:defineObjects />
<form action="" method="post" name="fmVPS" id="fmVPS">
 <div class="sidebar">
   <div id="perfil" class="insurance">
     <div id="paso1" class="profile position">
       <div class="content">
         <div class="head"> <span>Configuración de destacados secundarios.</span> </div>
         <div class="body seguros">
           <div class="content-head"></div>
         <div class="content-body">
             
             <div class="title"> 
             	<h2>ID de Identificador Contenido Web 1: </h2>
				<input type="text" name="<portlet:namespace/>idcw1" id="idcw1" value="${requestScope.codContenidoWeb1}"/> <liferay-ui:icon-help message="Ingrese el id de identificador de contenido Web asociado." />
								<span class="portlet-configuration" id="aui_3_4_0_1_1082">
									<a
									onclick="Liferay.Portlet.openConfiguration('#p_p_id_56_INSTANCE_uTutl7U9jhl4_', '56_INSTANCE_uTutl7U9jhl4', 'http://localhost:8080/web/guest/personas?p_p_id=86&amp;p_p_lifecycle=0&amp;p_p_state=pop_up&amp;p_p_col_id=column-4&amp;p_p_col_count=2&amp;_86_struts_action=%2Fportlet_configuration%2Fedit_configuration&amp;_86_redirect=%2Fweb%2Fguest%2Fpersonas%3Fp_p_id%3Ddestacadosecundario_WAR_DestacadoSecundarioportlet%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dedit%26p_p_col_id%3Dcolumn-4%26p_p_col_pos%3D1&amp;_86_returnToFullPageURL=%2Fweb%2Fguest%2Fpersonas%3Fp_p_id%3Ddestacadosecundario_WAR_DestacadoSecundarioportlet%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dedit%26p_p_col_id%3Dcolumn-4%26p_p_col_pos%3D1&amp;_86_portletResource=56_INSTANCE_uTutl7U9jhl4&amp;_86_resourcePrimKey=10183_LAYOUT_56_INSTANCE_uTutl7U9jhl4&amp;_86_ ', '_56_INSTANCE_uTutl7U9jhl4_'); return false;"
									id="_56_INSTANCE_uTutl7U9jhl4_rpwo"
									href="http://localhost:8080/web/guest/personas?p_p_id=86&amp;p_p_lifecycle=0&amp;p_p_state=pop_up&amp;p_p_col_id=column-4&amp;p_p_col_count=2&amp;_86_struts_action=%2Fportlet_configuration%2Fedit_configuration&amp;_86_redirect=%2Fweb%2Fguest%2Fpersonas%3Fp_p_id%3Ddestacadosecundario_WAR_DestacadoSecundarioportlet%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dedit%26p_p_col_id%3Dcolumn-4%26p_p_col_pos%3D1&amp;_86_returnToFullPageURL=%2Fweb%2Fguest%2Fpersonas%3Fp_p_id%3Ddestacadosecundario_WAR_DestacadoSecundarioportlet%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dedit%26p_p_col_id%3Dcolumn-4%26p_p_col_pos%3D1&amp;_86_portletResource=56_INSTANCE_uTutl7U9jhl4&amp;_86_resourcePrimKey=10183_LAYOUT_56_INSTANCE_uTutl7U9jhl4&amp;_86_"
									class="taglib-icon"> <img title="Seleccionar contenido web"
										alt="Seleccionar contenido web"
										src="http://localhost:8080/halcon-theme/images/common/configuration.png"
										class="icon" id="aui_3_4_0_1_1081">
								</a>
								</span>
				</div>
				<liferay-ui:journal-content-search> </liferay-ui:journal-content-search>
             <div class="title"> 
             	<h2>ID de Identificador Contenido Web 2: </h2>
				<input type="text"  name="<portlet:namespace/>idcw2" id="idcw2" value="${requestScope.codContenidoWeb2}"/> <liferay-ui:icon-help message="Ingrese el id de identificador de contenido Web asociado." />
             </div>

             <div class="title"> 
             	<h2>ID de Identificador Contenido Web 3: </h2>
				<input type="text"  name="<portlet:namespace/>idcw3" id="idcw3" value="${requestScope.codContenidoWeb3}"/> <liferay-ui:icon-help message="Ingrese el id de identificador de contenido Web asociado." />
             </div>

             <div class="title"> 
             	<h2>ID de Identificador Contenido Web 4: </h2>
				<input type="text"  name="<portlet:namespace/>idcw4" id="idcw4" value="${requestScope.codContenidoWeb4}"/> <liferay-ui:icon-help message="Ingrese el id de identificador de contenido Web asociado." />
             </div>


            <div class="title"> 
           </div>
        </div>
           <div class="footer"> 
	           <input type="button" name="optRegistrar" id="optRegistrar" value="Guardar" url="<portlet:actionURL name="actionRegistrar" />"> 
           </div>
                      
         </div>
       </div>
     </div>
   </div>
<liferay-ui:success key="successEditRegistra" message="Se guardo correctamente." />
<liferay-ui:error key="errorEditRegistra" message="No se pudo guardar, por favor intentelo nuevamente." />
 </div>
</form>
	<div class="both"></div>    