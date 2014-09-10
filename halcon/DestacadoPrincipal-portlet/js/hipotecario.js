cargarVariables();
_gaq.push(['_trackEvent', 'Simulaciones', 'Paso 1 Simulacion', 'Cr\u00e9dito Hipotecario']);
/*Redimensionamos*/
seeParent();

var rangoValorHipotecarioCreHipoSoles, rangoValorHipotecarioCreHipoDolares,
rangoValorMiviviendaCreHipoSoles, rangoValorTechoPropioCreHipoSoles,
rangoValorGarantiaHipotecariaCreHipoSoles, rangoValorGarantiaHipotecariaCreHipoDolares,
rangoCuotaCreditoHipotecarioCreHipoDoles, rangoCuotaCreditoHipotecarioCreHipoDolares,
rangoCuotaMiviviendaCreHipoSoles, rangoCuotaTechoPropioCreHipoSoles,
rangoCuotaGarantiaHipotecariaCreHipoSoles, rangoCuotaGarantiaHipotecariaCreHipoDolares, 
rangoPlazoHipotecarioRegularCreHipo, rangoPlazoMiviviendaCreHipo, 
rangoPlazoTechoPropioCreHipo, rangoPlazoGarantiaHipotecariaCreHipo;

rangoValorHipotecarioCreHipoSoles = $('RANGO_VALOR_CREDITO_HIPOTECARIO_CRE_HIPO_SOLES').value;
rangoValorHipotecarioCreHipoDolares = $('RANGO_VALOR_CREDITO_HIPOTECARIO_CRE_HIPO_DOLARES').value;
rangoValorMiviviendaCreHipoSoles = $('RANGO_VALOR_MIVIVIENDA_COFIDE_CRE_HIPO_SOLES').value;
rangoValorTechoPropioCreHipoSoles = $('RANGO_VALOR_TECHO_PROPIO_COFIDE_CRE_HIPO_SOLES').value;
rangoValorGarantiaHipotecariaCreHipoSoles = $('RANGO_VALOR_GARANTIA_HIPOTECARIA_CRE_HIPO_SOLES').value;
rangoValorGarantiaHipotecariaCreHipoDolares = $('RANGO_VALOR_GARANTIA_HIPOTECARIA_CRE_HIPO_DOLARES').value;

rangoCuotaCreditoHipotecarioCreHipoDoles = $('RANGO_CUOTA_CREDITO_HIPOTECARIO_CRE_HIPO_SOLES').value;
rangoCuotaCreditoHipotecarioCreHipoDolares = $('RANGO_CUOTA_CREDITO_HIPOTECARIO_CRE_HIPO_DOLARES').value;
rangoCuotaMiviviendaCreHipoSoles = $('RANGO_CUOTA_MIVIVIENDA_COFIDE_CRE_HIPO_SOLES').value;
rangoCuotaTechoPropioCreHipoSoles = $('RANGO_CUOTA_TECHO_PROPIO_COFIDE_CRE_HIPO_SOLES').value;
rangoCuotaGarantiaHipotecariaCreHipoSoles = $('RANGO_CUOTA_GARANTIA_HIPOTECARIA_CRE_HIPO_SOLES').value;
rangoCuotaGarantiaHipotecariaCreHipoDolares = $('RANGO_CUOTA_GARANTIA_HIPOTECARIA_CRE_HIPO_DOLARES').value;

rangoPlazoHipotecarioRegularCreHipo = $('RANGO_PLAZO_HIPOTECARIO_REGULAR_CRE_HIPO').value;
rangoPlazoMiviviendaCreHipo = $('RANGO_PLAZO_MIVIVIENDA_COFIDE_CRE_HIPO').value;
rangoPlazoTechoPropioCreHipo = $('RANGO_PLAZO_TECHO_PROPIO_COFIDE_CRE_HIPO').value;
rangoPlazoGarantiaHipotecariaCreHipo = $('RANGO_PLAZO_GARANTIA_HIPOTECARIA_CRE_HIPO').value;

var disableOptionOn = function(elements,disable,defaultelement){
	
	for(i = 0, count = elements.length; i < count ; i++   ){
		if(elements[i].get('valor').toInt() === disable){
			elements[i].addClass('disable-op');
			if(elements[i].hasClass('active-op')){
				elements[i].removeClass('active-op');
				elements[defaultelement].addClass('active-op');
				valor = elements[defaultelement].get("valor");
				elements[i].getPrevious('input').set('value', valor);
			}
			
			break;
		}
	}
	
};

var disableOptionOff = function(elements){
	
	for(i = 0, count = elements.length; i < count ; i++   ){
		if(elements[i].hasClass('disable-op')){
			elements[i].removeClass('disable-op');
		}
	}
	
};

var loadRangoHipotecario = function(tipoMoneda,tipoProducto){
	
	var elements,cuotaInicial, valorInmueble,plazohipotecario;

	elements = $('optTipMonedaHipotecario').getElements('span');
	valorInmueble = $("valorInmueble");
	cuotaInicial = $("cuotaInicialVehiculo");
	plazohipotecario = $("plazoCreditohipotecario");
	
		switch (tipoProducto) {
			case 1://Hipotecario tradicional
				disableOptionOff(elements);
				if(tipoMoneda === SOLES){
					setSelector(valorInmueble, rangoValorHipotecarioCreHipoSoles,"S/.");
					setSelector(cuotaInicial, rangoCuotaCreditoHipotecarioCreHipoDoles,"%");
				}else if(tipoMoneda === DOLARES){
					setSelector(valorInmueble, rangoValorHipotecarioCreHipoDolares,"$");
					setSelector(cuotaInicial, rangoCuotaCreditoHipotecarioCreHipoDolares,"%");
				}
				setSelector(plazohipotecario, rangoPlazoHipotecarioRegularCreHipo,'Plazo de Cr\u00e9dito');
				break;
			case 12://Hipotecario mi vivienda
				disableOptionOn(elements,2,0);
				setSelector(valorInmueble, rangoValorMiviviendaCreHipoSoles,"S/.");
				setSelector(cuotaInicial, rangoCuotaMiviviendaCreHipoSoles,"%");
				setSelector(plazohipotecario, rangoPlazoMiviviendaCreHipo,'A\u00f1os');
				break;
			case 5://Hipotecario techo propio
				disableOptionOn(elements,2,0);
				setSelector(valorInmueble, rangoValorTechoPropioCreHipoSoles,"S/.");
				setSelector(cuotaInicial, rangoCuotaTechoPropioCreHipoSoles,"%");
				setSelector(plazohipotecario, rangoPlazoTechoPropioCreHipo,'Plazo de Cr\u00e9dito');
				break;
			case 6://hipotecario garantia hipotecaria
				disableOptionOff(elements);
				if(tipoMoneda === SOLES){
					setSelector(valorInmueble, rangoValorGarantiaHipotecariaCreHipoSoles,"S/.");
					setSelector(cuotaInicial, rangoCuotaGarantiaHipotecariaCreHipoSoles,"%");
				}else if(tipoMoneda === DOLARES){
					setSelector(valorInmueble, rangoValorGarantiaHipotecariaCreHipoDolares,"$");
					setSelector(cuotaInicial, rangoCuotaGarantiaHipotecariaCreHipoDolares,"%");
				}
				setSelector(plazohipotecario, rangoPlazoGarantiaHipotecariaCreHipo,'A\u00f1os');
				break;
		}		
};

var loadRangoHipotecarioSession = function(tipoMoneda,tipoProducto,step){
	
	var elements,cuotaInicial, valorInmueble,plazohipotecario;

	elements = $('optTipMonedaHipotecario').getElements('span');
	valorInmueble = $("valorInmueble");
	cuotaInicial = $("cuotaInicialVehiculo");
	plazohipotecario = $("plazoCreditohipotecario");
	
		switch (tipoProducto) {
			case 1://Hipotecario tradicional
				disableOptionOff(elements);
				if(tipoMoneda === SOLES){
					setSelector(valorInmueble, rangoValorHipotecarioCreHipoSoles,"S/.",null,step.valorInmueble);
					setSelector(cuotaInicial, rangoCuotaCreditoHipotecarioCreHipoDoles,"%",null,step.cuotaInicial );
				}else if(tipoMoneda === DOLARES){
					setSelector(valorInmueble, rangoValorHipotecarioCreHipoDolares,"$",null,step.valorInmueble);
					setSelector(cuotaInicial, rangoCuotaCreditoHipotecarioCreHipoDolares,"%",null,step.cuotaInicial );
				}
				setSelector(plazohipotecario, rangoPlazoHipotecarioRegularCreHipo,'Plazo de Cr\u00e9dito',null,step.plazoCredito);
				break;
			case 12://Hipotecario mi vivienda
				disableOptionOn(elements,2,0);
				setSelector(valorInmueble, rangoValorMiviviendaCreHipoSoles,"S/.",null,step.valorInmueble);
				setSelector(cuotaInicial, rangoCuotaMiviviendaCreHipoSoles,"%",null,step.cuotaInicial );
				setSelector(plazohipotecario, rangoPlazoMiviviendaCreHipo,'Plazo de Cr\u00e9dito',null,step.plazoCredito);
				break;
			case 5://Hipotecario techo propio
				disableOptionOn(elements,2,0);
				setSelector(valorInmueble, rangoValorTechoPropioCreHipoSoles,"S/.",null,step.valorInmueble);
				setSelector(cuotaInicial, rangoCuotaTechoPropioCreHipoSoles,"%",null,step.cuotaInicial );
				setSelector(plazohipotecario, rangoPlazoTechoPropioCreHipo,'Plazo de Cr\u00e9dito',null,step.plazoCredito);
				break;
			case 6://hipotecario garantia hipotecaria
				disableOptionOff(elements);
				if(tipoMoneda === SOLES){
					setSelector(valorInmueble, rangoValorGarantiaHipotecariaCreHipoSoles,"S/.",null,step.valorInmueble);
					setSelector(cuotaInicial, rangoCuotaGarantiaHipotecariaCreHipoSoles,"%",null,step.cuotaInicial );
				}else if(tipoMoneda === DOLARES){
					setSelector(valorInmueble, rangoValorGarantiaHipotecariaCreHipoDolares,"$",null,step.valorInmueble);
					setSelector(cuotaInicial, rangoCuotaGarantiaHipotecariaCreHipoDolares,"%",null,step.cuotaInicial );
				}
				setSelector(plazohipotecario, rangoPlazoGarantiaHipotecariaCreHipo,'Plazo de Cr\u00e9dito',null,step.plazoCredito);
				break;
		}		
};

var setOptionHipotecario = function(e){
	var tipoMonedaActual=$('hoptTipMonedaHipotecario').value.toInt();
	var tipoCreditoActual=$('hoptTipCreditoHipotecario').value.toInt();
	loadRangoHipotecario(tipoMonedaActual,tipoCreditoActual);
};

var ValidkeyHipotecario = function(e){
	var tipoDocSel=$('hcmbTipDocHipotecario').value;
	if(tipoDocSel==0){
		/*$('errorHipotecarioPaso1').set('html','*Seleccione un tipo de documento.');*/
		return false;
	}
	$('errorHipotecarioPaso1').empty();
	if(tipoDocSel==DNI){
		return numbers(e);
		
	}else if(tipoDocSel==CE){
		return alphanumeric(e);
	}
};


var validSendHipotecario = function(e){
	loadform();
	var captcha=$('txtCaptchaHipotecario').value;
	if(!validarNombresApellidos(captcha)){
		$('sendCreHipotecarioError').set('html','*Ingrese un c\u00f3digo Captcha correcto.');
		e.stop();
		closeloadform();
	}else{
		//Envia el form
		e.stop();
		var urlHipotecario=$('URLvalidarCaptchaHipotecario').value;
		var formCreHipotecario=$('formCreHipotecario');
		
		valCapcha(urlHipotecario,formCreHipotecario,function(resp){
			if(resp.error=='true'){
				closeloadform();
				newImage('captchaHipotecario','URLTraerCaptchaHipotecario');
				limpiarPlaceHolder('txtCaptchaHipotecario');
				$('sendCreHipotecarioError').set('html','*Ingrese un c\u00f3digo Captcha correcto.');
			}else if(resp.error = "redirecciona"){
				goURL(resp.url);
			} else{
				goURL(resp.url);
			}
		});
	}
};

var btnHipotecarioContinuar = function(e){
	
	var tipoDocSel=$('hcmbTipDocHipotecario').value;
	var numDOC=$('txtNumDocHipotecario').value;
	
	/*if(tipoDocSel==0){
		$('errorHipotecarioPaso1').set('html','*Seleccione un tipo de documento.');
		return false;
	}*/
	
	if(tipoDocSel==DNI){
		if(!validarDNI(numDOC)){
			$('errorHipotecarioPaso1').set('html','*Ingresa un DNI de 8 d\u00edgitos');
			return false;
		}
		
	}else if(tipoDocSel==CE){
		if(!validarCExtranjeria(numDOC)){
			$('errorHipotecarioPaso1').set('html','*Ingresa entre 4 y 12 caracteres');
			return false;
		}
	}
	
};

var ChangeHipotecarioTypeDocument = function(item){
	var tipoDocSel=item.get('valor');
	/*if(tipoDocSel==0){
		$('errorHipotecarioPaso1').set('html','*Seleccione un tipo de documento.');
		return false;
	}*/
	$('errorHipotecarioPaso1').empty();
	
	if(tipoDocSel==DNI){	
		$('txtNumDocHipotecario').set({'value':'','maxLength':'8'});
	}else if(tipoDocSel==CE){
		$('txtNumDocHipotecario').set({'value':'','maxLength':'12'});
	}
};

var reloadCaptchaHipo = function(){
	newImage('captchaHipotecario','URLTraerCaptchaHipotecario');
	limpiarPlaceHolder('txtCaptchaHipotecario');
};

var initHipotecario = function (){
	iTabsControl('.tab-hipoteca','.pas-hipoteca','.continuar-pr','.regresar-pr');
	//paso-1
	/*Tipo documento*/
	var cboHipotecarioDocument = null;
	
	if($('SIM_SESSION')){
		if($('SIM_SESSION').value !=''){
			var sesionBean=JSON.decode($('SIM_SESSION').value);
			cboHipotecarioDocument=getdata3("/GestionParametros-portlet/js/resources/tip_doc_sim_credito_hipotecario.json", "hcmbTipDocHipotecario", "cmbTipDocHipotecario",sesionBean.tipoDoc);
			
			$('txtNumDocHipotecario').value = sesionBean.numDoc;
			setLongitudTexto(DNI,sesionBean.tipoDoc,'txtNumDocHipotecario');
		}
	}
	
	if(cboHipotecarioDocument == null){
		cboHipotecarioDocument = getdata2("/GestionParametros-portlet/js/resources/tip_doc_sim_credito_hipotecario.json", "hcmbTipDocHipotecario", "cmbTipDocHipotecario");
	}
	
	/*Tipo Moneda*/
	getdatacombo("/GestionParametros-portlet/js/resources/tip_moneda_sim_credito_hipotecario.json","hoptTipMonedaHipotecario","optTipMonedaHipotecario");
	
	/*Valor cuando viene por URL*/
	var tipoCreditoDefault=$('productoDefaultHipotecario').value;
	
	if (tipoCreditoDefault !== '') {
		getdatacombo("/GestionParametros-portlet/js/resources/tip_credito_sim_credito_hipotecario.json","hoptTipCreditoHipotecario","optTipCreditoHipotecario",parseInt(tipoCreditoDefault),true);
		loadRangoHipotecario(1,parseInt(tipoCreditoDefault));
		/*Seteamos para Perfiladores*/
		var valorDefault=$('idVSHip').value;
		var step = {
				plazoCredito: false,
				cuotaInicial: false,
				valorInmueble: valorDefault 
			};
			
		loadRangoHipotecarioSession(1,parseInt(tipoCreditoDefault),step);
		
	}else{
		getdatacombo("/GestionParametros-portlet/js/resources/tip_credito_sim_credito_hipotecario.json","hoptTipCreditoHipotecario","optTipCreditoHipotecario");
		loadRangoHipotecario(1,1);
	}
	
	cboHipotecarioDocument.addEvent('xChange',ChangeHipotecarioTypeDocument);
	$('btnCreHipotecarioContinuar').addEvent("click",btnHipotecarioContinuar);	
	$('txtNumDocHipotecario').addEvent("keypress",ValidkeyHipotecario);
	$('optTipMonedaHipotecario').addEvent("click",setOptionHipotecario);
	$('optTipCreditoHipotecario').addEvent("click",setOptionHipotecario);
	
	//PASO 2
	/*Tipo Seguro*/
	getdatacombo("/GestionParametros-portlet/js/resources/tip_seg_desgravamen_credito_hipotecario.json", "hoptTipSeguroHipotecario","optTipSeguroHipotecario");
	/*Grupo tipo cuota*/
	getdatacombo("/GestionParametros-portlet/js/resources/tip_cuota_sim_credito_hipotecario.json", "hoptTipCuotaHipotecario","optTipCuotaHipotecario");
	$('btnCreHipotecario').addEvent("click",validSendHipotecario);
	$('reloadcaptchaHipotecario').addEvent('click',reloadCaptchaHipo);	
	$('returnCaptchaHipo').addEvent('click',reloadCaptchaHipo);
};


var initHipotecarioSession = function (item){
	var simulador = JSON.decode(item);
	/*Cargamos numero de documento*/
	$('txtNumDocHipotecario').value=simulador.numeroDocumento;
	setLongitudTexto(DNI,simulador.tipoDocumento,'txtNumDocHipotecario');
	iTabsControl('.tab-hipoteca','.pas-hipoteca','.continuar-pr','.regresar-pr');
	//paso-1
	/*Tipo documento*/
	var cboHipotecarioDocument = getdata3("/GestionParametros-portlet/js/resources/tip_doc_sim_credito_hipotecario.json", "hcmbTipDocHipotecario", "cmbTipDocHipotecario",simulador.tipoDocumento);
	
	/*Tipo Moneda*/
	getdatacombo("/GestionParametros-portlet/js/resources/tip_moneda_sim_credito_hipotecario.json","hoptTipMonedaHipotecario","optTipMonedaHipotecario",parseInt(simulador.tipoMoneda));
	/*Grupo tipo credito*/
	if($('productoDefaultHipotecario') && $('productoDefaultHipotecario').value != ""){
		getdatacombo("/GestionParametros-portlet/js/resources/tip_credito_sim_credito_hipotecario.json","hoptTipCreditoHipotecario","optTipCreditoHipotecario",parseInt(simulador.tipoCredito),true);
	}else{
		getdatacombo("/GestionParametros-portlet/js/resources/tip_credito_sim_credito_hipotecario.json","hoptTipCreditoHipotecario","optTipCreditoHipotecario",parseInt(simulador.tipoCredito),false);
	}
	
	

	var step = {
			plazoCredito: simulador.plazoCredito,
			cuotaInicial: simulador.cuotaInicial,
			valorInmueble: simulador.valorBien 
		};
		
	loadRangoHipotecarioSession(parseInt(simulador.tipoMoneda),parseInt(simulador.tipoCredito),step);
		
	cboHipotecarioDocument.addEvent('xChange',ChangeHipotecarioTypeDocument);
	$('btnCreHipotecarioContinuar').addEvent("click",btnHipotecarioContinuar);	
	$('txtNumDocHipotecario').addEvent("keypress",ValidkeyHipotecario);
	$('optTipMonedaHipotecario').addEvent("click",setOptionHipotecario);
	$('optTipCreditoHipotecario').addEvent("click",setOptionHipotecario);
	
	//PASO 2
	/*Tipo Seguro*/
	getdatacombo("/GestionParametros-portlet/js/resources/tip_seg_desgravamen_credito_hipotecario.json", "hoptTipSeguroHipotecario","optTipSeguroHipotecario",parseInt(simulador.seguroDesgravamen));
	/*Grupo tipo cuota*/
	getdatacombo("/GestionParametros-portlet/js/resources/tip_cuota_sim_credito_hipotecario.json", "hoptTipCuotaHipotecario","optTipCuotaHipotecario",parseInt(simulador.tipoCuota));
	$('btnCreHipotecario').addEvent("click",validSendHipotecario);
	$('reloadcaptchaHipotecario').addEvent('click',reloadCaptchaHipo);
	$('returnCaptchaHipo').addEvent('click',reloadCaptchaHipo);
};

var simuladorJSONHipotecario = $('simuladorBean').value;

if (simuladorJSONHipotecario !== '') {
	initHipotecarioSession(simuladorJSONHipotecario);
} else {
	initHipotecario();
}
