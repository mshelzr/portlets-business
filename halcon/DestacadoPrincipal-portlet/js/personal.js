cargarVariables();
_gaq.push(['_trackEvent', 'Simulaciones', 'Paso 1 Simulacion', 'Pr\u00e9stamo Personal']);
seeParent(); /*Redimensionamos*/
	
	var ranValPerSimPerSoles, ranValPerSimPerDolares;
	var rutaImg = $('urlImagenSliderPersonal').get('value');
	ranValPerSimPerSoles = $("RANGO_VALOR_PERSONAL_SIM_PER_SOLES").value;
	ranValPerSimPerDolares = $("RANGO_VALOR_PERSONAL_SIM_PER_DOLARES").value;

//utiles 

var getSelectorJson = function(data){
	selectorA('plazoCreditoPersonal',data);
};

var reloadCaptcha = function(){
	newImage('captchaPersonal','URLTraerCaptchaPersonal');
	limpiarPlaceHolder('txtcaptchaPersonal');
};
	

var changeValorPersonal = function(){
	var  montoCreditoPersonal,iValorMoneda;
	iValorMoneda = 0;
	valor = this.getElement('input').value.toInt();
	montoCreditoPersonal = $("montoCreditoPersonal");
	if(iValorMoneda !== valor){
		switch (valor) {
		case SOLES:
			setSelector(montoCreditoPersonal,ranValPerSimPerSoles, "S/.&nbsp;",rutaImg);
			break;
		case DOLARES:
			setSelector(montoCreditoPersonal,ranValPerSimPerDolares, "US$&nbsp;",rutaImg);
			break;
		}
		iValorMoneda = valor;
	}
};



//Valida pasos
var validstep = function(element){

	var btnstep1, btnstep2, validElement1, validElement2, bValue, iValue;
		
	btnstep1 = element.step1.btnstep;
	btnstep2 = element.step2.btnstep;
	validElement1 = element.step1.validElement;	
	validElement2 = element.step2.validElement;
	
	var validCaptchaCorrect = function(res){
		if(res.error === "true"){
			closeloadform();
			reloadCaptcha();
			//console.log(res.mensaje);
			limpiarPlaceHolder('txtcaptchaPersonal');
			$("paso2CrePersonal").set({"html":'*Ingrese un c\u00f3digo Captcha correcto.','styles':{'Display':'block'}});
		}else if(res.error = "redirecciona"){
			goURL(res.url);
		} else{
			goURL(res.url);
		}
	};
	
	var checkElemnt = function(rule, input){
		iValue = $(input).value; 
		bValue = false;
		if(rule == 'document' && iValue == 0){
			/*$('paso1CrePersonal').set('html','*Seleccione un tipo de documento.');
			bValue =  false;*/
			$('paso1CrePersonal').set('html','');
			bValue =  true;
		}else if(rule.contains('|')){
			lmnt = rule.split('|');
			iValue = $(lmnt[1]).value.toInt();
			bValue =  true;
			switch(iValue){
				case DNI:
					var documentTest = ($(input).value.test(/^[0-9]{8}$/))?true:false;
					if(!documentTest){
						$('paso1CrePersonal').set('html','*Ingresa un DNI de 8 d\u00edgitos');
						bValue = false;
					}else{
						$('paso1CrePersonal').set('html','');
						bValue = true;
					}
				break;
				case CE:
					var documentTest = ($(input).value.test(/^[a-zA-Z0-9]{4,12}$/i))?true:false;
					if(!documentTest){
						$('paso1CrePersonal').set('html','*Ingresa entre 4 y 12 caracteres');
						bValue = false;
					}else{
						$('paso1CrePersonal').set('html','');
						bValue = true;
					}
				break;
			}
		}else if( rule === 'captcha'){
			bErrorPaso2 = $(input).value.test(/^[a-zA-Z]+$/i);
			if(bErrorPaso2){
				loadform();
				var URLValidarCaptchaPersonal,formCrePersonal;	
					URLValidarCaptchaPersonal = $("URLValidarCaptchaPersonal").value;
					formCrePersonal = $("formCrePersonal");
					valCapcha(URLValidarCaptchaPersonal,formCrePersonal,validCaptchaCorrect);
			}else{
				$("paso2CrePersonal").set({"html":'*Ingrese un c\u00f3digo Captcha correcto.','styles':{'Display':'block'}});
			}
		}
		return bValue;
	};
	
	
	btnstep1.addEvent('click',function(){
		bValue = false;
		Object.each(validElement1,function(rule, input){
			bValue = checkElemnt(rule, input);
			if(!bValue) return false;
		});
		return bValue;
	});
	
	
	btnstep2.addEvent('click',function(){
		bValue = false;
		Object.each(validElement2,function(rule, input){
			bValue = checkElemnt(rule, input);
			if(!bValue) return false;
		});
		return bValue;
	});
};

//funcion que inicia carga de elementos
var initPersonal = function(){
	/*Grupo tipo credito*/
	var tipoCreditoDefault = $('productoDefault').value;
	
	iTabsControl('.tab-personal','.pas-personal','.continuar-pr','.regresar-pr');
	//Paso1
	var reloadCaptchaPersonal = $("reloadCaptchaPersonal");
	var cbo = null;
	
	if($('SIM_SESSION')){
		if($('SIM_SESSION').value !=''){
			var sesionBean=JSON.decode($('SIM_SESSION').value);
			cbo=getdata3("/GestionParametros-portlet/js/resources/tip_doc_sim_personal.json", "docCrePersonalHidden", "docCrePersonal",sesionBean.tipoDoc);
			
			$('documentSimPersonal').value = sesionBean.numDoc;
			setLongitudTexto(DNI,sesionBean.tipoDoc,'documentSimPersonal');
		}
	}
	if(cbo == null){
		cbo = getdata2("/GestionParametros-portlet/js/resources/tip_doc_sim_personal.json", "docCrePersonalHidden", "docCrePersonal");
	}
	
	if (tipoCreditoDefault != '') {
		getdatacombo("/GestionParametros-portlet/js/resources/tip_cre_sim_personal.json","tipoCreditoHidden","tipoCreditoContent",parseInt(tipoCreditoDefault),true);
	} else {
		getdatacombo("/GestionParametros-portlet/js/resources/tip_cre_sim_personal.json","tipoCreditoHidden","tipoCreditoContent");
	}
	
	
	getdatacombo("/GestionParametros-portlet/js/resources/tip_moneda_sim_personal.json","hiddenSimPertMoneda","contentSimPertMoneda");
	
	setSelector("montoCreditoPersonal",ranValPerSimPerSoles);
	cbo.addEvent('xChange',function(item){
		iValor = item.get('valor').toInt();
		if(iValor === DNI || iValor === 0 ){
			$('documentSimPersonal').set({'value':'','maxLength':'8'});
		}else{
			$('documentSimPersonal').set({'value':'','maxLength':'12'});
		}
	});
	$("contentSimPertMoneda").addEvent("click",changeValorPersonal);
	
	//Paso2
	getdatacombo('/GestionParametros-portlet/js/resources/tip_cuota_sim_personal.json',"tipoCuotaHidden","tipoCuotaContent");
	reloadCaptchaPersonal.addEvent("click",reloadCaptcha);
	getdata4('/GestionParametros-portlet/js/resources/plazo_cre_sim_personal.json',getSelectorJson);
	$('returnCaptchaPersonal').addEvent("click",reloadCaptcha);
	
};

function initPersonalSession(simuladorJSON){
	iTabsControl('.tab-personal','.pas-personal','.continuar-pr','.regresar-pr');
	var simulador = JSON.decode(simuladorJSON);
	var montoCreditoPersonal = $("montoCreditoPersonal");
	
	var getSelector2 = function(data){	
		selectorA("plazoCreditoPersonal",data,simulador.plazoCredito);
	};
	
	//Aqui es numero de documento
	$('documentSimPersonal').value = simulador.numeroDocumento;
	setLongitudTexto(DNI,simulador.tipoDocumento,'documentSimPersonal');
	//Aqui es monto de credito
	var tipoMoneda = parseInt(simulador.tipoMoneda);
	var montoPrestamo = simulador.montoPrestamo;
	switch (tipoMoneda) {
	case SOLES:
		setSelector(montoCreditoPersonal,ranValPerSimPerSoles, "S/.&nbsp;",rutaImg,montoPrestamo);
		break;
	case DOLARES:
		setSelector(montoCreditoPersonal,ranValPerSimPerDolares, "US$&nbsp;",rutaImg,montoPrestamo);
		break;
	}
	
	//Aqui es el combo de documento
	var tipoDocumento = simulador.tipoDocumento;
	var cboPersonal = getdata3("/GestionParametros-portlet/js/resources/tip_doc_sim_personal.json", "docCrePersonalHidden", "docCrePersonal",tipoDocumento);
	cboPersonal.addEvent("xChange",function(item){
		iValor = item.get('valor').toInt();
		if(iValor === DNI || iValor === 0 ){
			$('documentSimPersonal').set({'value':'','maxLength':'8'});
		}else{
			$('documentSimPersonal').set({'value':'','maxLength':'12'});
		}
		$('paso1CrePersonal').empty();
	});
	
	//Aqui es cambio de monedas
	getdatacombo("/GestionParametros-portlet/js/resources/tip_moneda_sim_personal.json","hiddenSimPertMoneda","contentSimPertMoneda",tipoMoneda);
	
	//Aqui es cambio de tipo de credito
	
	
	if($('productoDefault') && $('productoDefault').value != ""){
		getdatacombo("/GestionParametros-portlet/js/resources/tip_cre_sim_personal.json","tipoCreditoHidden","tipoCreditoContent",simulador.tipoCredito,true);
	}else{
		getdatacombo("/GestionParametros-portlet/js/resources/tip_cre_sim_personal.json","tipoCreditoHidden","tipoCreditoContent",simulador.tipoCredito,false);
	}
	
	
	//Aqui es cambio de tipo de cuota
	getdatacombo('/GestionParametros-portlet/js/resources/tip_cuota_sim_personal.json',"tipoCuotaHidden","tipoCuotaContent",simulador.tipoCuota);
	
	//Aqui es plazo credito
	getdata4('/GestionParametros-portlet/js/resources/plazo_cre_sim_personal.json',getSelector2);
	
	//Eventos
	$("contentSimPertMoneda").addEvent("click",changeValorPersonal);
	$("reloadCaptchaPersonal").addEvent("click",reloadCaptcha);
	$('returnCaptchaPersonal').addEvent("click",reloadCaptcha);
}




var elementPersonal = {
			'step1':{
				'btnstep': $('SimuladorPersonalPaso2'), 
				'validElement':{
					'docCrePersonalHidden' :'document',
					'documentSimPersonal':'numeric|docCrePersonalHidden'
				}
			},
			'step2':{
				'btnstep': $('btnCrePersonal'), 
				'validElement':{
					'txtcaptchaPersonal' :'captcha'
				}
			}
};


$('documentSimPersonal').addEvent("keypress",function(e){
	var tipoDocSel=$('docCrePersonalHidden').value;
	if(tipoDocSel==0){
		/*$('paso1CrePersonal').set('html','*Seleccione un tipo de documento.');*/
		return false;
	}
	$('paso1CrePersonal').empty();
	if(tipoDocSel==DNI){
		return numbers(e);
	}else if(tipoDocSel==CE){
		return alphanumeric(e);
	}
});



var simuladorJSONPersonal = $('simuladorBean').value;
if (simuladorJSONPersonal !== '') {
	initPersonalSession(simuladorJSONPersonal);
} else {
	initPersonal();
}
validstep(elementPersonal);