<%--
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
--%>
<style type="text/css">
	.sol-formulario{ padding-top:0 !important;
	padding-left: 0 !important;}
</style>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<portlet:actionURL var="actionURL" name="actionEnviar"/>
<input type="hidden" value="vehicular" id="frmtipo" name="frmtipo" />
<div id="contentfrm">

	<form id="frmdata" action="${actionURL }" method="post">
	
		<!--content-medio-->
		<div id="contenidoIni">
		    <div id="content-medio"  class="replicador-ubicacion">
		      
		      
		      <!--sol-formulario-->
		      <div class="sol-formulario replicador-contenedor">
		      	<input type="hidden" id="tipoReplicador" value="4">
		      <div class=" campos-oblig">
		          <label> 
	
				¿Es compra inteligente?</label>
		        <input type="radio" name="rdbcompra" value="1" class="campRad buy" id="inteligente">
		        <p class="texRad">Sí.</p>
		        <input type="radio" name="rdbcompra" value="0" class="campRad buy" id="inteligente"  checked="checked">
		        <p class="texRad">No.</p>
		                  
		          
		        </div>
		        <div class="campos-oblig">
		          <label>Nro Crédito</label>
		          <input type="text" class="textform wt224 float-left" id="numCredito" name="numCredito" maxLength="8" onpaste="return false;" ondragstart="return false;" ondrop="return false;" ondragover="return false;"/>
		        </div>
		        <div class="form-error"></div>
		        <div class="campos-oblig">
		          <label>Moneda</label>
		          <div id="cmbTipoMoneda" class="dropdown wt190 float-left">
		          </div>
		        </div>
		        <div class="form-error"></div>
		         <div class="campos-oblig">
		          <label>Valor del Bien </label>
		          <input type="text" class="textform wt224 float-left" id="valorBienv" name="valorBienv" maxLength="10" onpaste="return false;" ondragstart="return false;" ondrop="return false;" ondragover="return false;"/>
		        </div>
		        <div class="form-error"></div>
		        
		        <div id="cbalon" class="campos-oblig" style="display: none;">
		          <label>% Cuota Balón</label>
		          <input type="text" class="textform wd124p float-left" value="0" id="cuotaBalon" name="cuotaBalon" maxLength="2" onpaste="return false;" ondragstart="return false;" ondrop="return false;" ondragover="return false;"/>
		          <p class="percentage">%</p>
		          <div class="ayuda-sign">
		            <div class="tool-open" style="display: none;">El valor ingresado debe tener 2 decimales.</div>
		          </div>
		        </div>
		        <div id="errorCuotaBalon" class="form-error"></div>
		        <div class="campos-oblig">
		          <label>Monto a Financiar </label>
		          <input type="text" class="textform wt224 float-left" id="montoFinanciarv" name="montoFinanciarv" maxLength="10" onpaste="return false;" ondragstart="return false;" ondrop="return false;" ondragover="return false;"/>
		        </div>
		        <div class="form-error"></div>
		        <div class="campos-oblig">
		          <label>Tasa de Interés (TEA)</label>
		          <input type="text" class="textform wd124p float-left" id="tasaInteresv" name="tasaInteresv" maxLength="5" onpaste="return false;" ondragstart="return false;" ondrop="return false;" ondragover="return false;"/>
		          <p class="percentage">%</p>
		          <div class="ayuda-sign">
		            <div class="tool-open" style="display: none;">El valor ingresado debe tener 2 decimales.</div>
		          </div>
		        </div>
		        <div class="form-error"></div>
		        <div class="campos-oblig">
		          <label> Tipo de Cuota</label>
		          <div id="cmbTipoCuota" class="dropdown wt190 float-left">
		          </div>
		        </div>
		        <div class="form-error"></div>
		        <div class="campos-oblig">
		          <label> Plazo en Meses</label>
		          <input type="text" class="textform wd124p float-left" id="plazoMesesv" name="plazoMesesv" maxLength="2" onpaste="return false;" ondragstart="return false;" ondrop="return false;" ondragover="return false;"/>
		        </div>
		        <div class="form-error"></div>
		        <div class="campos-oblig">
		          <label> Per&iacute;odo de Gracia</label>
		          <input type="text" class="textform wd124p float-left" id="periodoGraciav" name="periodoGraciav" maxLength="1" onpaste="return false;" ondragstart="return false;" ondrop="return false;" ondragover="return false;"/>
		        </div>
		        <div class="form-error"></div>
		        <div class="wd476p campos-oblig">
		          <label>% Seguro de Desgravamen</label>
		          <input type="text" class="textform wd86p float-left" id="seguroDesgv" name="seguroDesgv" maxLength="6" onpaste="return false;" ondragstart="return false;" ondrop="return false;" ondragover="return false;"/>
		          <div class="ayuda-sign">
		            <div class="tool-open" style="display: none;">El formato del valor del % debe tener 4 decimales.</div>
		          </div>
		          <div class="optchn">
		            <input type="checkbox" class="opCh" id="chkdesvagramen" name="chkdesvagramen">
		            <p class="texCh">Endosado</p>
		          </div>
		        </div>
		        <div class="form-error"></div>
		        <div class="wd476p campos-oblig">
		          <label>% y Monto Seguro del Bien</label>
		          <input type="text" class="textform wd86p float-left" id="porcSegurov" name="porcSegurov" maxLength="7" onpaste="return false;" ondragstart="return false;" ondrop="return false;" ondragover="return false;"/>
		          <div class="ayuda-sign">
		            <div class="tool-open" style="display: none;">El formato del valor del % debe tener 4 decimales.</div>
		          </div>
		          <input type="text" class="textform wd86p float-left" id="montoSegurov" name="montoSegurov" maxLength="10" onpaste="return false;" ondragstart="return false;" ondrop="return false;" ondragover="return false;"/>
		          <div class="optchn">
		            <input type="checkbox" class="opCh" id="chkmonto" name="chkmonto">
		            <p class="texCh">Endosado</p>
		          </div>
		          <br class="both" />
		        </div>
		        <div class="form-error">Debes ingresar el Porcentaje y Monto Seguro del Bien
		          <div class="text-error"></div>
		        </div>
		        <div class="campos-oblig">
		          <label> Fecha de Desembolso</label>
		          <input type="text" class="textform wt129 datepiker float-left nogeneric"  value="dd/mm/aaaa"  id="fechaDes" name="fechaDes"/>
		        </div>
		        <div class="form-error">Debes ingresar la Fecha de Nacimiento
		          <div class="text-error"></div>
		        </div>
		        <div class=" campos-oblig">
		          <label> Día de Vencimiento</label>
		          <input type="text" class="textform wd86p float-left" id="diaVencim" name="diaVencim" maxLength="7" onpaste="return false;" ondragstart="return false;" ondrop="return false;" ondragover="return false;"/>
		        </div>
		        <div class="form-error"></div>
		        <div class=" campos-oblig">
		          <label> 
		
				Envío Físico por Informe de Pago</label>
		        <input type="radio" name="rdbsend2" value="1" class="campRad" id="envioFisico" checked="checked">
		        <p class="texRad">Sí.</p>
		        <input type="radio" name="rdbsend2" value="0" class="campRad" id="envioFisico">
		        <p class="texRad">No.</p>
	
		        </div>
		        
		        <div class="both"></div>
		        <div class="soli-codigo mg10tp"> <img id="imgCaptcha" height="28" width="106" alt="captcha" src='<portlet:resourceURL id="captcha"/>' />
			        <div class="codigo-icons"> <em class="volver" href="javascript:void(0)" onclick="actualizarImagen()"></em> <em class="tool">
			          <div class="tool-open"> Escribe los caracteres de la imagen en el siguiente cuadro. </div>
			          </em> </div>
			        <input type="text" placeholder="Ingresa el Código" id="ingresacodigo" name="ingresacodigo" value="" class="textform wt112">
		      	</div>
		      	<div  id="errorCaptcha" class="form-error mglf15"></div>
		      <div class="cnt">
		      <div id="btnsend" class="bluebtn-cont7 float-left">
		        <div class="bluebtn-izq"> &nbsp;</div>
		        <div class="bluebtn-medio boton"> <a id="enviarDatos" title="Enviar" target="_self" href="javascript:;" class="boton">Enviar</a></div>
		        <div class="bluebtn-der"> &nbsp;</div>
		        <div class="both"> &nbsp;</div>
		      </div>
		      <div id="btnclear" class="bluebtn-cont7 float-left mg5">
		        <div class="bluebtn-izq"> &nbsp;</div>
		        <div class="bluebtn-medio boton"> <a id="limpiarForm" title="Limpiar" target="_self" href="javascript:;" class="boton">Limpiar </a></div>
		        <div class="bluebtn-der"> &nbsp;</div>
		        <div class="both"> &nbsp;</div>
		      </div>
		      </div>
		      
		      </div>
		      <!--sol-publi-->
		      
		    </div>
		    </div>
		    <!--sidebar-->
	    </form>
    </div>
    
<div id="divresultado" class="replicador-ubicacion" ></div>
<input type="hidden" value="${fechaActual}" id="fechaActual" name="fechaAc" />
<input type="hidden" id="credVehicular" value='<portlet:resourceURL id="credVehicular"/>' />
<input type="hidden" id="urlImagenCajaSorpresa" value='<portlet:resourceURL id="captcha"/>'/>
<input type="hidden" id="urlForm" value='<portlet:resourceURL id="actionEnviar" />'  >
<input type="hidden" id="nombreReplicador" value="Vehicular">