<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<!DOCTYPE html>
<html>
<head>
<portlet:defineObjects />
<link href="/halcon-theme/css/lightbox.css" rel="stylesheet"
	type="text/css" />
<!--[if IE 7]><link href="/halcon-theme/css/stylesie7.css" rel="stylesheet" type="text/css" /><![endif]-->
<!--[if IE 6]><link href="/halcon-theme/css/stylesie6.css" rel="stylesheet" type="text/css" /><![endif]-->
<link href="/halcon-theme/css/styles.css" rel="stylesheet"
	type="text/css" />
<!--[if IE 7]><link href="/halcon-theme/css/stylesie7.css" rel="stylesheet" type="text/css" /><![endif]-->
<!--[if IE 6]><link href="/halcon-theme/css/stylesie6.css" rel="stylesheet" type="text/css" /><![endif]-->
<style type="text/css">
#contenedor1{  _height:150px !important;}
#contenedor2{  _height:140px !important;}


#content-lbox H3{ _width:276px}
.resul-soli {
float: left;
width: 307px;
}
.campos-oblig {
	width:276px !important;
}
.wt65 {
	width: 65px;
	margin: 0 0 0 109px;;
}

#content-lbox {
    color: #919195;
    float: left;
    font-size: 12px;
    padding: 26px 68px 0 65px;
    width: 307px !important;
    _width:250px !important;
      *height:190px !important;
    _height:190px !important;
    
}
.resul-aclar-I {
    color: #A7A9AC;
    float: left;
    height: 61px;
    line-height: 18px;
    padding: 15px 11px 0;
    text-align: justify;
    width: 280px !important;
}

.cabecera-lbox {
   
    border-bottom: 1px solid #CCCCCC;
    height: 65px;
    margin: 0 auto;
    width: 440px !important;
}

.content-milkbox {
    margin: 0 auto;
    padding: 27px 20px 0 17px;
    width: 440px !important;
      _width: 400px !important;
_padding: 27px 19px 0 15px;
}
</style>
<script type="text/javascript">/*<![CDATA[*/var _gaq=_gaq||[];_gaq.push(["_setAccount","UA-42149934-1"]);_gaq.push(["_trackPageview"]);(function(){var a=document.createElement("script");a.src=("https:"==document.location.protocol?"https://ssl":"http://www")+".google-analytics.com/ga.js";a.setAttribute("async","true");document.documentElement.firstChild.appendChild(a)})();/*]]>*/</script>
</head>
<body>
	<div class="content-milkbox">
		<div class="cabecera-lbox"></div>
		<div id="content-lbox">
			<div id="contenedor1">
				<h3>Ingresa el monto que deseas invertir</h3>
				<br /> <br />
				<div class="resul-soli">
					<div class="campos-oblig sin-margin">
						<label>Moneda </label>
						<div class="optiongroup float-left"
							id="tipoMonedaSimFondosMutuosContent2"></div>
					</div>
					<div class="campos-oblig">
						<label class="campo-fondo-mutuos-popup">Monto de Inversi&oacute;n</label><input type="text"class="textform wt100 float-left" id="monto_inversion_light" maxLength="11" name="monto_inversion_light">
					</div>
					<div class="form-error" id="msj_error">Monto incorrecto.</div>
					<div class="wt65">
						<div class="bluebtn-cont7">
							<div class="bluebtn-izq">&nbsp;</div>
							<div class="bluebtn-medio boton">
								<a href="javascript:;" title="Enviar" class="boton" id="enviar_form_solicitar" onclick="_gaq.push(['_trackEvent', 'Simulaciones', 'Lightbox - Enviar ', 'Fondos Mutuos']);">Enviar</a>
							</div>
							<div class="bluebtn-der">&nbsp;</div>
							<div class="both"></div>
						</div>
					</div>
				</div>
				<br class="both" />
			</div>

			<div id="contenedor2" class="resul-aclar-I" style="display:none">
				<p>
					<a id="link_fondosmutuos" class="lnktab" href="" onclick="_gaq.push(['_trackEvent', 'Simulaciones', 'Lightbox - Nuestra Tiendas', 'Fondos Mutuos']);"></a>
				</p>

				<p id="mensaje_fondosmutuos">
				
				Ac&eacute;rcate a la Tienda Interbank de tu preferencia con tu DNI y el monto a invertir.
				 Asimismo si tienes alguna duda comun&iacute;cate con nosotros a nuestra Central de Servicio al 
				 Cliente 219-2121 en Lima o en Provincias al 0801-18200 o escr&iacute;benos a interfondos@intercorp.com.pe
				
				</p>
				<div class="both"></div>
			</div>
			
		</div>
		<br class="both" />
	</div>
	<script src="/halcon-theme/js/halcon/mootools.core.js"
		type="text/javascript"></script>
	<script src="/halcon-theme/js/halcon/mootools.more.js"
		type="text/javascript"></script>
	<script src="/halcon-theme/js/halcon/DD_roundies.js"
		type="text/javascript"></script>
	<script src="/halcon-theme/js/halcon/functions.js"
		type="text/javascript"></script>
	<script src="/ResultadoSimulacion-portlet/js/form_fm_lightbox.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		
	if(Browser.ie6){
			$$('.content-milkbox').setStyle('overflow','hidden');
			$('content-lbox').setStyle('overflow','hidden'); 
		}
	</script>
	
		

</body>
</html>