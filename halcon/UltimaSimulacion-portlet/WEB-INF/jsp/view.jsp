<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<input type="hidden" value="<portlet:resourceURL id="volverSimular"/>" name="hSim" id="hSim"/>
<div class="DRCV">
     <p>Última simulación realizada por ${requestScope.ultimaSimulacionMoneda } ${requestScope.ultimaSimulacion }  <a  id="vSim" href="#" title="Volver a simular">Volver a simular</a>   </p>
 </div>