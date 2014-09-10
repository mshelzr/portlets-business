<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

<div>
<div class="subcabecera-template">	
	<div class="sub-titulo">
		<h3>Puntos de Atención</h3>
	</div>
	<div class="both"></div>
</div>
	<div class="wrapper-middle">
		<div class="wrapper-tgmaps">
			<div class="wrapper-tab">
				<div class="btn-tab">
					<a class="gmtab active" href="#">
						<div class="tab-text">
							<div class="indicador">
								<img border="0" src="/BuscarTienda-portlet/img/indicador.jpg" width="15">
							</div>
							<div class="tbdesc">Puntos de Atención</div>
							<br class="both">
						</div>
					</a>
				</div>
				<br class="both">
				<div class="wrapper-frm">

				<form id="formTiendas" action="" method="get">


					<div class="trfrm title">
						<h3>
							Selecciona el servicio que <br /> deseas ubicar
						</h3>
					</div>
					<div class="space"></div>
					<div class="trfrm col-small">
						<input type="checkbox" class="chk" name="checkTipoLocal" id="el1" value="${tiendas}"> <label for="el1" class="chk-label">Tiendas</label>
						<br class="both">
						<div class="space-min"></div>
						<input type="checkbox" class="chk" name="checkTipoLocal" id="el2" value="${agentes}"> <label for="el2" class="chk-label">Agentes</label>
						<br class="both">
						<div class="space-min"></div>
					</div>
					<div class="trfrm col-mediun pnone">
						<input type="checkbox" class="chk" name="checkTipoLocal" id="el3" value="${cajerosglobalnet}" /> <label for="el3" class="chk-label">GlobalNet</label>
						<br class="both" />
						<div class="space-min"></div>
						<input type="checkbox" class="chk" name="checkTipoLocal" id="el4" value="${monederosglobalnet}" /> <label for="el4" class="chk-label">GlobalNet
							Monedero</label> <br class="both" />
						<div class="space-min"></div>
						<input type="checkbox" class="chk" name="checkTipoLocal" id="el5" value="${cajerosglobalnetplus}" /> <label for="el5" class="chk-label">GlobalNet
							Cajero Plus</label> <br class="both" />
						<div class="space-min"></div>
					</div>


					<div class="both"></div>

					<div class="line"></div>

					<div class="trfrm">
							<label>Departamento</label>
							<div id="cbodepartamento" class="dropdown2 w256px cbodepartamento ">
								<input type="text" name="cbodepartamentoHidden" id="cbodepartamentoHidden" value=""  class="textdropdown" style="opacity: 0; z-index: -1; position: absolute;">
              					<div>Seleccione</div>	
							</div>
							<div class="both"></div>
					</div>
					<div class="margin10"></div>
					<div class="trfrm">
							<label >Provincia</label>
							<div id="cboprovincia" class="dropdown2 w256px cboprovincia ">
								<input type="text" name="cboprovinciaHidden" id="cboprovinciaHidden" value=""  class="textdropdown" style="opacity: 0; z-index: -1; position: absolute;">
              					<div>Seleccione</div>	
							</div>
						<div class="both"></div>
					</div>
					<div class="margin10"></div>
					<div class="trfrm">
							<label >Distrito</label>
							<div id="cboDistrito" class="dropdown2 w256px cboDistrito ">
								<input type="text" name="cboDistritoHidden" id="cboDistritoHidden" value=""  class="textdropdown" style="opacity: 0; z-index: -1; position: absolute;">
              					<div>Seleccione</div>
							</div>
						<div class="both"></div>
					</div>
					<div class="line"></div>
					<div class="" style="display: none; margin: 20px 0 0 0; padding: 0 30px 0 30px;" id="MENSAJE_SIN_RESULTADOS">  ${MENSAJE_SIN_RESULTADOS} </div>
					
					
				</form>

			</div>
			</div>
			<div class="cont-gmaps"  style="width: 600px">
			<div id="gmap" class="wrapper-gmaps" style="width: 600px"></div>
			</div>
		</div>
		<br class="both">
	</div>
</div>


<portlet:resourceURL id="obtListaSucursales" var="obtListaSucursales" />
<input type="hidden" id="obtLstSucursales" value="<%=obtListaSucursales%>">


