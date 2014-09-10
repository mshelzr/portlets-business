<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />
<portlet:renderURL var="renderURL">
	<portlet:param name="action" value="verDescuento" />
</portlet:renderURL>

<input type="hidden" id="rURL" value="<%=renderURL%>" />


<div>
	<div class="subcabecera-template">
		<div class="cadena-template">
			<div class="sub-titulo">
				<h3>Descuentos de Programa Sueldo</h3>
			</div>
			<div class="both"></div>
		</div>
	</div>
	<div class="wrapper-middle">
		<div class="wrapper-tgmaps">
			<div class="wrapper-tab">
				<div class="btn-tab">
          <a href="#" class="gmtab active">
						<div class="tab-text">
							<div class="indicador">
<!-- 								<img border="0" src="/BuscarDescuento-portlet/img/percent.jpg" width="24"> -->
							</div>
							<div class="tbdesc">Descuentos de Programa Sueldo</div>
							<br class="both">
						</div>
					</a>
				</div>
				<br class="both">

				<div class="wrapper-frm" id="tab2">
				<form id="formDescuentos" action="" method="get">					
					<input type="hidden" id="urlDescuentos" value="<portlet:resourceURL id="popupDescuentos"/>"/>
					<div class="trfrm title">
						<h3>
							Selecciona el local que deseas <br> ubicar
						</h3>
					</div>
					<div class="space"></div>
					<div class="trfrm ">
						<label for="">Distrito</label>
						<div id="cboDistritosDescuento" class="dropdown2 w256px cboDistritosDescuento">
							<div>Seleccione</div>
						</div>
					</div>
					<div class="margin10"></div>
					<div class="trfrm">
						<label for="">Categor&iacute;a</label>
						<div id="cboCategoria" class="dropdown2 w256px cboCategoria ">
							<div>Seleccione</div>
						</div>
						<br class="both" />
					</div>
					<div class="margin10"></div>
					<div class="trfrm">
						<label for="">Buscador</label> 
						<input type="text" class="textform wt215" value="" name="buscar" id="money" placeholder="Buscar en este sitio"> <input
							type="button" name="busqueda-btn" class="btnform"> <br class="both" />
					</div>
					<div class="" style="display: none; margin: 20px 0 0 0; padding: 0 30px 0 30px;" id="MENSAJE_SIN_RESULTADOS">  ${MENSAJE_SIN_RESULTADOS} </div>
					
				</form>
			</div>
			</div>
			<div class="cont-gmaps" style="width: 600px">
			<div id="gmap" class="wrapper-gmaps" style="width: 600px"></div>
		
			</div>
		</div>
		<br class="both">
	</div>
</div>

<portlet:resourceURL id="obtListaSucursalesDescuentos" var="obtListaSucursalesDescu" />

<input type="hidden" id="obtListaSucursalesDescuentos" value="<%=obtListaSucursalesDescu%>">


