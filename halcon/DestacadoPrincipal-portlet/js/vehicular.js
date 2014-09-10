cargarVariables();
_gaq.push(['_trackEvent', 'Simulaciones', 'Paso 1 Simulacion', 'Cr\u00e9dito Vehicular']);
/*Redimensionamos*/
seeParent();

	var RANGO_CUOTA_INICIAL_SIM_VEH_TRA_SOLES = $('RANGO_CUOTA_INICIAL_SIM_VEH_TRA_SOLES').value;
	var RANGO_VALOR_VEHICULO_SIM_VEH_TRA_SOLES = $('RANGO_VALOR_VEHICULO_SIM_VEH_TRA_SOLES').value;
	var RANGO_PLAZO_CREDITO_SIM_VEH_TRA_SOLES = $('RANGO_PLAZO_CREDITO_SIM_VEH_TRA_SOLES').value;
	var RANGO_PLAZO_CREDITO_SIM_VEH_CNU_SOLES = $('RANGO_PLAZO_CREDITO_SIM_VEH_CNU_SOLES').value;
	var RANGO_CUOTA_INICIAL_SIM_VEH_CNU_SOLES = $('RANGO_CUOTA_INICIAL_SIM_VEH_CNU_SOLES').value;
	var RANGO_VALOR_VEHICULO_SIM_VEH_CNU_SOLES = $('RANGO_VALOR_VEHICULO_SIM_VEH_CNU_SOLES').value;	
	var RANGO_PLAZO_CREDITO_SIM_VEH_ESP_SOLES = $('RANGO_PLAZO_CREDITO_SIM_VEH_ESP_SOLES').value;
	var RANGO_CUOTA_INICIAL_SIM_VEH_ESP_SOLES = $('RANGO_CUOTA_INICIAL_SIM_VEH_ESP_SOLES').value;
	var RANGO_VALOR_VEHICULO_SIM_VEH_ESP_SOLES = $('RANGO_VALOR_VEHICULO_SIM_VEH_ESP_SOLES').value;	
	var RANGO_PLAZO_CREDITO_SIM_VEH_CIN_SOLES = $('RANGO_PLAZO_CREDITO_SIM_VEH_CIN_SOLES').value;
	var RANGO_CUOTA_INICIAL_SIM_VEH_CIN_SOLES = $('RANGO_CUOTA_INICIAL_SIM_VEH_CIN_SOLES').value;
	var RANGO_VALOR_VEHICULO_SIM_VEH_CIN_SOLES = $('RANGO_VALOR_VEHICULO_SIM_VEH_CIN_SOLES').value;

	var RANGO_PLAZO_CREDITO_SIM_VEH_TRA_DOLARES = $('RANGO_PLAZO_CREDITO_SIM_VEH_TRA_DOLARES').value;
	var RANGO_CUOTA_INICIAL_SIM_VEH_TRA_DOLARES = $('RANGO_CUOTA_INICIAL_SIM_VEH_TRA_DOLARES').value;
	var RANGO_VALOR_VEHICULO_SIM_VEH_TRA_DOLARES = $('RANGO_VALOR_VEHICULO_SIM_VEH_TRA_DOLARES').value;
	var RANGO_PLAZO_CREDITO_SIM_VEH_CNU_DOLARES = $('RANGO_PLAZO_CREDITO_SIM_VEH_CNU_DOLARES').value;
	var RANGO_CUOTA_INICIAL_SIM_VEH_CNU_DOLARES = $('RANGO_CUOTA_INICIAL_SIM_VEH_CNU_DOLARES').value;
	var RANGO_VALOR_VEHICULO_SIM_VEH_CNU_DOLARES = $('RANGO_VALOR_VEHICULO_SIM_VEH_CNU_DOLARES').value;
	var RANGO_PLAZO_CREDITO_SIM_VEH_ESP_DOLARES = $('RANGO_PLAZO_CREDITO_SIM_VEH_ESP_DOLARES').value;
	var RANGO_CUOTA_INICIAL_SIM_VEH_ESP_DOLARES = $('RANGO_CUOTA_INICIAL_SIM_VEH_ESP_DOLARES').value;
	var RANGO_VALOR_VEHICULO_SIM_VEH_ESP_DOLARES = $('RANGO_VALOR_VEHICULO_SIM_VEH_ESP_DOLARES').value;
	var RANGO_PLAZO_CREDITO_SIM_VEH_CIN_DOLARES = $('RANGO_PLAZO_CREDITO_SIM_VEH_CIN_DOLARES').value;
	var RANGO_CUOTA_INICIAL_SIM_VEH_CIN_DOLARES = $('RANGO_CUOTA_INICIAL_SIM_VEH_CIN_DOLARES').value;
	var RANGO_VALOR_VEHICULO_SIM_VEH_CIN_DOLARES = $('RANGO_VALOR_VEHICULO_SIM_VEH_CIN_DOLARES').value;

var loadRangoVehicular = function(tipoMoneda,tipoProducto){
		
	if(tipoMoneda==SOLES){
		//Soles
		switch (tipoProducto) {
			case 46://Tradicional
				setSelector($("plazoCreditoVehicular"), RANGO_PLAZO_CREDITO_SIM_VEH_TRA_SOLES,'Plazo de Cr\u00e9dito');
				setSelector($("valorInicial"), RANGO_CUOTA_INICIAL_SIM_VEH_TRA_SOLES,"%");
				setSelector($("valorAuto"), RANGO_VALOR_VEHICULO_SIM_VEH_TRA_SOLES,"S/.");
				break;
			case 51://Casi nuevo
				setSelector($("plazoCreditoVehicular"), RANGO_PLAZO_CREDITO_SIM_VEH_CNU_SOLES,'Plazo de Cr\u00e9dito');
				setSelector($("valorInicial"), RANGO_CUOTA_INICIAL_SIM_VEH_CNU_SOLES,"%");
				setSelector($("valorAuto"), RANGO_VALOR_VEHICULO_SIM_VEH_CNU_SOLES,"S/.");
				break;
			case 52://Especial				
				setSelector($("plazoCreditoVehicular"), RANGO_PLAZO_CREDITO_SIM_VEH_ESP_SOLES,'Plazo de Cr\u00e9dito');
				setSelector($("valorInicial"), RANGO_CUOTA_INICIAL_SIM_VEH_ESP_SOLES,"%");
				setSelector($("valorAuto"), RANGO_VALOR_VEHICULO_SIM_VEH_ESP_SOLES,"S/.");
				break;
			case 53://Compra inteligente
				setSelector($("plazoCreditoVehicular"), RANGO_PLAZO_CREDITO_SIM_VEH_CIN_SOLES,'Plazo de Cr\u00e9dito');
				setSelector($("valorInicial"), RANGO_CUOTA_INICIAL_SIM_VEH_CIN_SOLES,"%");
				setSelector($("valorAuto"), RANGO_VALOR_VEHICULO_SIM_VEH_CIN_SOLES,"S/.");
				break;
		}
	}else if(tipoMoneda==DOLARES){
		//Dolares
		switch (tipoProducto) {
			case 46://Tradicional
				setSelector($("plazoCreditoVehicular"), RANGO_PLAZO_CREDITO_SIM_VEH_TRA_DOLARES,'meses');
				setSelector($("valorInicial"), RANGO_CUOTA_INICIAL_SIM_VEH_TRA_DOLARES,"%");
				setSelector($("valorAuto"), RANGO_VALOR_VEHICULO_SIM_VEH_TRA_DOLARES,"$");
				break;
			case 51://Casi nuevo
				setSelector($("plazoCreditoVehicular"), RANGO_PLAZO_CREDITO_SIM_VEH_CNU_DOLARES,'meses');
				setSelector($("valorInicial"), RANGO_CUOTA_INICIAL_SIM_VEH_CNU_DOLARES,"%");
				setSelector($("valorAuto"), RANGO_VALOR_VEHICULO_SIM_VEH_CNU_DOLARES,"$");
				break;
			case 52://Especial
				setSelector($("plazoCreditoVehicular"), RANGO_PLAZO_CREDITO_SIM_VEH_ESP_DOLARES,'meses');
				setSelector($("valorInicial"), RANGO_CUOTA_INICIAL_SIM_VEH_ESP_DOLARES,"%");
				setSelector($("valorAuto"), RANGO_VALOR_VEHICULO_SIM_VEH_ESP_DOLARES,"$");
				break;
			case 53://Compra inteligente
				setSelector($("plazoCreditoVehicular"), RANGO_PLAZO_CREDITO_SIM_VEH_CIN_DOLARES,'meses');
				setSelector($("valorInicial"), RANGO_CUOTA_INICIAL_SIM_VEH_CIN_DOLARES,"%");
				setSelector($("valorAuto"), RANGO_VALOR_VEHICULO_SIM_VEH_CIN_DOLARES,"$");
				break;
		}
	}
};

var loadRangosSessionVehicular = function(tipoMoneda,tipoProducto,step){
	
	if(tipoMoneda==SOLES){
		//Soles
		switch (tipoProducto) {
			case 46://Tradicional
				setSelector($("plazoCreditoVehicular"), RANGO_PLAZO_CREDITO_SIM_VEH_TRA_SOLES,'Plazo de Cr\u00e9dito', null,step.plazoCredito );
				setSelector($("valorInicial"), RANGO_CUOTA_INICIAL_SIM_VEH_TRA_SOLES,"%",null,step.cuotaInicial );
				setSelector($("valorAuto"), RANGO_VALOR_VEHICULO_SIM_VEH_TRA_SOLES,"S/.",null,step.valorVehiculo );
				break;
			case 51://Casi nuevo
				setSelector($("plazoCreditoVehicular"), RANGO_PLAZO_CREDITO_SIM_VEH_CNU_SOLES,'Plazo de Cr\u00e9dito',null,step.plazoCredito);
				setSelector($("valorInicial"), RANGO_CUOTA_INICIAL_SIM_VEH_CNU_SOLES,"%",null,step.cuotaInicial );
				setSelector($("valorAuto"), RANGO_VALOR_VEHICULO_SIM_VEH_CNU_SOLES,"S/.",null,step.valorVehiculo);
				break;
			case 52://Especial				
				setSelector($("plazoCreditoVehicular"), RANGO_PLAZO_CREDITO_SIM_VEH_ESP_SOLES,'Plazo de Cr\u00e9dito',null,step.plazoCredito);
				setSelector($("valorInicial"), RANGO_CUOTA_INICIAL_SIM_VEH_ESP_SOLES,"%",null,step.cuotaInicial );
				setSelector($("valorAuto"), RANGO_VALOR_VEHICULO_SIM_VEH_ESP_SOLES,"S/.",null,step.valorVehiculo);
				break;
			case 53://Compra inteligente
				setSelector($("plazoCreditoVehicular"), RANGO_PLAZO_CREDITO_SIM_VEH_CIN_SOLES,'Plazo de Cr\u00e9dito',null,step.plazoCredito);
				setSelector($("valorInicial"), RANGO_CUOTA_INICIAL_SIM_VEH_CIN_SOLES,"%",null,step.cuotaInicial );
				setSelector($("valorAuto"), RANGO_VALOR_VEHICULO_SIM_VEH_CIN_SOLES,"S/.",null,step.valorVehiculo);
				break;
		}
	}else if(tipoMoneda==DOLARES){
		//Dolares
		switch (tipoProducto) {
			case 46://Tradicional
				setSelector($("plazoCreditoVehicular"), RANGO_PLAZO_CREDITO_SIM_VEH_TRA_DOLARES,'Plazo de Cr\u00e9dito',null,step.plazoCredito);
				setSelector($("valorInicial"), RANGO_CUOTA_INICIAL_SIM_VEH_TRA_DOLARES,"%",null,step.cuotaInicial );
				setSelector($("valorAuto"), RANGO_VALOR_VEHICULO_SIM_VEH_TRA_DOLARES,"$",null,step.valorVehiculo);
				break;
			case 51://Casi nuevo
				setSelector($("plazoCreditoVehicular"), RANGO_PLAZO_CREDITO_SIM_VEH_CNU_DOLARES,'Plazo de Cr\u00e9dito',null,step.plazoCredito);
				setSelector($("valorInicial"), RANGO_CUOTA_INICIAL_SIM_VEH_CNU_DOLARES,"%",null,step.cuotaInicial );
				setSelector($("valorAuto"), RANGO_VALOR_VEHICULO_SIM_VEH_CNU_DOLARES,"$",null,step.valorVehiculo);
				break;
			case 52://Especial
				setSelector($("plazoCreditoVehicular"), RANGO_PLAZO_CREDITO_SIM_VEH_ESP_DOLARES,'Plazo de Cr\u00e9dito',null,step.plazoCredito);
				setSelector($("valorInicial"), RANGO_CUOTA_INICIAL_SIM_VEH_ESP_DOLARES,"%",null,step.cuotaInicial );
				setSelector($("valorAuto"), RANGO_VALOR_VEHICULO_SIM_VEH_ESP_DOLARES,"$",null,step.valorVehiculo);
				break;
			case 53://Compra inteligente
				setSelector($("plazoCreditoVehicular"), RANGO_PLAZO_CREDITO_SIM_VEH_CIN_DOLARES,'Plazo de Cr\u00e9dito',null,step.plazoCredito);
				setSelector($("valorInicial"), RANGO_CUOTA_INICIAL_SIM_VEH_CIN_DOLARES,"%",null,step.cuotaInicial );
				setSelector($("valorAuto"), RANGO_VALOR_VEHICULO_SIM_VEH_CIN_DOLARES,"$",null,step.valorVehiculo);
				break;
		}
	}
};

var setOptionVehicular = function(e){
	var tipoMonedaActual=$('hoptTipMonedaVehicular').value.toInt();
	var tipoCreditoActual=$('hoptTipCreditoVehicular').value.toInt();
	loadRangoVehicular(tipoMonedaActual,tipoCreditoActual);
};

var ValidkeyVehicular = function(e){
	var tipoDocSel=$('hcmbTipDocVehicular').value;
	if(tipoDocSel==0){
		/*$('errorVehicularPaso1').set('html','*Seleccione un tipo de documento.');*/
		return false;
	}
	$('errorVehicularPaso1').empty();
	if(tipoDocSel==DNI){
		return numbers(e);
		
	}else if(tipoDocSel==CE){
		return alphanumeric(e);
	}
};

var validSendVehicular = function(e){
	loadform();
	var captcha=$('txtCaptchaVehicular').value;
	if(!validarNombresApellidos(captcha)){
		$('errorVehicularPaso2').set('html','*Ingrese un c\u00f3digo Captcha correcto.');
		e.stop();
		closeloadform();
	}else{
		//Envia el form
		e.stop();
		var urlVehicular=$('URLValidarCaptchaVehicular').value;
		var formCreVehicular=$('formCreVehicular');
		
		valCapcha(urlVehicular,formCreVehicular,function(resp){
			if(resp.error=='true'){
				closeloadform();
				newImage('captchaVehicular','URLTraerCaptchaVehicular');
				limpiarPlaceHolder('txtCaptchaVehicular');
				$('errorVehicularPaso2').set('html','*Ingrese un c\u00f3digo Captcha correcto.');
			}else if(resp.error = "redirecciona"){
				goURL(resp.url);
			} else{
				goURL(resp.url);
			}
		});
	}
};
var btnVehicularContinuar = function(e){
	
	var tipoDocSel=$('hcmbTipDocVehicular').value;
	var numDOC=$('txtNumDocVehicular').value;
	
	/*if(tipoDocSel==0){
		$('errorVehicularPaso1').set('html','*Seleccione un tipo de documento.');
		return false;
	}*/
	
	if(tipoDocSel==DNI){
		if(!validarDNI(numDOC)){
			$('errorVehicularPaso1').set('html','*Ingresa un DNI de 8 d\u00edgitos');
			return false;
		}
		
	}else if(tipoDocSel==CE){
		if(!validarCExtranjeria(numDOC)){
			$('errorVehicularPaso1').set('html','*Ingresa entre 4 y 12 caracteres');
			return false;
		}
	}
	
};

var ChangeVehicularTypeDocument = function(item){
	var tipoDocSel=item.get('valor');
	/*if(tipoDocSel==0){
		$('errorVehicularPaso1').set('html','*Seleccione un tipo de documento.');
		return false;
	}*/
	$('errorVehicularPaso1').empty();
	if(tipoDocSel==DNI){	
		$('txtNumDocVehicular').set({'value':'','maxLength':'8'});
	}else if(tipoDocSel==CE){
		$('txtNumDocVehicular').set({'value':'','maxLength':'12'});
	}
};

var reloadedCaptchaVeicular = function(){
	newImage('captchaVehicular','URLTraerCaptchaVehicular');
	limpiarPlaceHolder('txtCaptchaVehicular');
};

var initVehicular = function(){
	/* SimuladorCredito vehicular */
	var cbo = null;
	/*Grupo tipo moneda*/
	getdatacombo("/GestionParametros-portlet/js/resources/tip_moneda_sim_vehicular.json", "hoptTipMonedaVehicular","optTipMonedaVehicular");
	
	if($('SIM_SESSION')){
		if($('SIM_SESSION').value !=''){
			var sesionBean=JSON.decode($('SIM_SESSION').value);
			cbo=getdata3("/GestionParametros-portlet/js/resources/tip_doc_sim_vehicular.json", "hcmbTipDocVehicular", "cmbTipDocVehicular",sesionBean.tipoDoc);
			
			$('txtNumDocVehicular').value = sesionBean.numDoc;
			setLongitudTexto(DNI,sesionBean.tipoDoc,'txtNumDocVehicular');
		}
	}
	
	if(cbo == null){
		cbo = getdata2("/GestionParametros-portlet/js/resources/tip_doc_sim_vehicular.json", "hcmbTipDocVehicular", "cmbTipDocVehicular");
	}
	/*Grupo tipo credito*/
	var tipoCreditoDefault=$('productoDefault').value;
	
	if (tipoCreditoDefault !== '') {
		getdatacombo("/GestionParametros-portlet/js/resources/tip_credito_sim_vehicular.json", "hoptTipCreditoVehicular","optTipCreditoVehicular",parseInt(tipoCreditoDefault),true);
		loadRangoVehicular(1,parseInt(tipoCreditoDefault));
	}else{
		getdatacombo("/GestionParametros-portlet/js/resources/tip_credito_sim_vehicular.json", "hoptTipCreditoVehicular","optTipCreditoVehicular");
		loadRangoVehicular(1,46);
	}
	

	cbo.addEvent('xChange',ChangeVehicularTypeDocument);
	$('btnCreVehicularContinuar').addEvent("click",btnVehicularContinuar);	
	$('txtNumDocVehicular').addEvent("keypress",ValidkeyVehicular);
	$('optTipMonedaVehicular').addEvent("click",setOptionVehicular);
	$('optTipCreditoVehicular').addEvent("click",setOptionVehicular);
	//PASO 2
	getdatacombo("/GestionParametros-portlet/js/resources/tip_seg_desgravamen_sim_vehicular.json", "hoptTipSeguroVehicular","optTipSeguroVehicular");
	/*Grupo tipo cuota*/
	getdatacombo("/GestionParametros-portlet/js/resources/tip_cuota_sim_vehicular.json", "hoptTipCuotaVehicular","optTipCuotaVehicular");
	$('btnCreVehicular').addEvent("click",validSendVehicular);
	$('reloadCaptchaVehicular').addEvent('click',reloadedCaptchaVeicular);
	$('returnCaptchaVehi').addEvent('click',reloadedCaptchaVeicular);
};

/*Se inicializa si manejamos una session*/
var initVehicularSession = function(item){
	
	var simulador = JSON.decode(item);
	/*Cargamos numero de documento*/
	$('txtNumDocVehicular').value=simulador.numeroDocumento;
	setLongitudTexto(DNI,simulador.tipoDocumento,'txtNumDocVehicular');
	
	/* SimuladorCredito vehicular */
	var cbo = getdata3("/GestionParametros-portlet/js/resources/tip_doc_sim_vehicular.json", "hcmbTipDocVehicular", "cmbTipDocVehicular",simulador.tipoDocumento);
	/*Grupo tipo moneda*/
	getdatacombo("/GestionParametros-portlet/js/resources/tip_moneda_sim_vehicular.json", "hoptTipMonedaVehicular","optTipMonedaVehicular",parseInt(simulador.tipoMoneda));
	/*Grupo tipo credito*/
	

	
	if($('productoDefault') && $('productoDefault').value != ""){
		getdatacombo("/GestionParametros-portlet/js/resources/tip_credito_sim_vehicular.json", "hoptTipCreditoVehicular","optTipCreditoVehicular",parseInt(simulador.tipoCredito),true);
	}else{
		getdatacombo("/GestionParametros-portlet/js/resources/tip_credito_sim_vehicular.json", "hoptTipCreditoVehicular","optTipCreditoVehicular",parseInt(simulador.tipoCredito),false);
	}
	
	var step = {
		plazoCredito: simulador.plazoCredito,
		cuotaInicial: simulador.cuotaInicial,
		valorVehiculo: simulador.valorBien 
	};
	
	loadRangosSessionVehicular(parseInt(simulador.tipoMoneda),parseInt(simulador.tipoCredito),step);
	
	cbo.addEvent('xChange',ChangeVehicularTypeDocument);
	$('btnCreVehicularContinuar').addEvent("click",btnVehicularContinuar);	
	$('txtNumDocVehicular').addEvent("keypress",ValidkeyVehicular);
	$('optTipMonedaVehicular').addEvent("click",setOptionVehicular);
	//$('optTipCreditoVehicular').addEvent("click",setOptionVehicular);
	//PASO 2
	getdatacombo("/GestionParametros-portlet/js/resources/tip_seg_desgravamen_sim_vehicular.json", "hoptTipSeguroVehicular","optTipSeguroVehicular",parseInt(simulador.seguroDesgravamen));
	/*Grupo tipo cuota*/
	getdatacombo("/GestionParametros-portlet/js/resources/tip_cuota_sim_vehicular.json", "hoptTipCuotaVehicular","optTipCuotaVehicular",parseInt(simulador.tipoCuota));
	$('btnCreVehicular').addEvent("click",validSendVehicular);
	$('reloadCaptchaVehicular').addEvent('click',reloadedCaptchaVeicular);
	$('returnCaptchaVehi').addEvent('click',reloadedCaptchaVeicular);
	
};

iTabsControl('.tab-vehicular','.pas-vehicular','.continuar-pr','.regresar-pr');

var simuladorJSONVehicular = $('simuladorBean').value;

if (simuladorJSONVehicular !== '') {
	initVehicularSession(simuladorJSONVehicular);
} else {
	initVehicular();
}


