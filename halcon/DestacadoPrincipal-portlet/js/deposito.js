cargarVariables();
_gaq.push(['_trackEvent', 'Simulaciones', 'Paso 1 Simulacion', 'Dep\u00f3sito a Plazo']);
seeParent(true); /*Redimensionamos*/

var rutaImg = $('urlImagenSliderDeposito').get('value');
var Sim_Dep_Pla_Soles, Sim_Dep_Pla_Dolares, Sim_Dep_Pla_Euros, tipoMonedaDepositoContent, iValor;
	
	Sim_Dep_Pla_Soles = $("RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_SOLES").value;
	Sim_Dep_Pla_Dolares = $("RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_DOLARES").value;
	Sim_Dep_Pla_Euros = $("RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_EUROS").value;
	
var getSelector = function(data){	
	selectorA("plazoDeposito",data);
};

var reloadCaptchaDeposito = function(){
	newImage('captchaDeposito','URLTraerCaptchaDeposito');
	limpiarPlaceHolder('codCaptchaDeposito');
};


var changeValorDeposito = function(){
	var  plazoCredito; 
	valorSelected = this.getElement('input').value.toInt();
	plazoCredito = $("plazoCredito");
	if(iValor !== valorSelected){
		switch (valorSelected) {
		case SOLES:
			setSelector(plazoCredito, Sim_Dep_Pla_Soles,"S/.");
			break;
		case DOLARES:
			setSelector(plazoCredito, Sim_Dep_Pla_Dolares,"US$");
			break;
		case EUROS:
			setSelector(plazoCredito,Sim_Dep_Pla_Euros,"&euro;");
			break;
		}
		
		iValor = valorSelected;
	}
};


validstepDeposito = function(element){

	var btnstep1, validElement1, bValue, iValue;
	
	btnstep1 = element.btnstep;
	validElement1 = element.validElement;	
	msg = element.msg;
	
	var validCaptchaCorrect = function(res){
		if(res.error === "true"){
			closeloadform();
			reloadCaptchaDeposito();
			limpiarPlaceHolder('codCaptchaDeposito');
			msg.set({"html":res.mensaje,'styles':{'Display':'block'}});
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
			/*msg.set('html','*Seleccione un tipo de documento.');
			bValue =  false;*/
			msg.set('html','');
			bValue =  true;
		}else if(rule.contains('|')){
			lmnt = rule.split('|');
			iValue = $(lmnt[1]).value.toInt();
			bValue =  true;
			
			switch(iValue){
				case DNI:
					var documentTest = ($(input).value.test(/^[0-9]{8}$/))?true:false;
					if(!documentTest){
						msg.set('html','*Ingresa un DNI de 8 d\u00edgitos');
						bValue = false;
					}else{
						msg.set('html','');
						bValue = true;
					}
				break;
				case CE:
					var documentTest = ($(input).value.test(/^[a-zA-Z0-9]{4,12}$/i))?true:false;
					if(!documentTest){
						msg.set('html','*Ingresa entre 4 y 12 caracteres');
						bValue = false;
					}else{
						msg.set('html','');
						bValue = true;
					}
				break;
			}
		}else if( rule === 'captcha'){
			bErrorPaso2 = $(input).value.test(/^[a-zA-Z0-9]+$/i);
			if(bErrorPaso2){
				loadform();
				var URLValidarCaptchaDeposito,formDepPlazo;	
				URLValidarCaptchaDeposito = $("URLValidarCaptchaDeposito").value;
					formDepPlazo = $("formDepPlazo");
					valCapcha(URLValidarCaptchaDeposito,formDepPlazo,validCaptchaCorrect);
			}else{
				msg.set({"html":'*Ingrese un c\u00f3digo Captcha correcto.','styles':{'Display':'block'}});
			}
		}else{
			bValue = true;
		}
		return bValue;
	};
	
	btnstep1.addEvent('click',function(){
		bValue = false;
		try {
			Object.each(validElement1,function(rule, input){
				bValue = checkElemnt(rule, input);
				if(!bValue){
					throw new Error('break');
				}
			});
		} catch (e) {
			return false;
		}
		return bValue;
	});
		
};

initDeposito =  function(){
	var cboDepositoPlazos = null;
	
	if($('SIM_SESSION')){
		if($('SIM_SESSION').value !=''){
			var sesionBean=JSON.decode($('SIM_SESSION').value);
			//cboDepositoPlazos=getdata3("/GestionParametros-portlet/js/resources/tip_doc_sim_deposito_plazo.json","docCreDepositoPlazoHidden", "docCreDepositoPlazoContent",sesionBean.tipoDoc);
			cboDepositoPlazos=getdata3("/GestionParametros-portlet/js/resources/tip_doc_sim_deposito_plazo.json","docCreDepositoPlazoHidden", "docCreDepositoPlazoContent",sesionBean.tipoDoc);
			
			$('documentSimDeposito').value = sesionBean.numDoc;
			setLongitudTexto(DNI,sesionBean.tipoDoc,'documentSimDeposito');
		}
	}
	
	if(cboDepositoPlazos == null){
		//cboDepositoPlazos = getdata2("/GestionParametros-portlet/js/resources/tip_doc_sim_deposito_plazo.json","docCreDepositoPlazoHidden", "docCreDepositoPlazoContent");
		cboDepositoPlazos = getdata2("/GestionParametros-portlet/js/resources/tip_doc_sim_deposito_plazo.json","docCreDepositoPlazoHidden", "docCreDepositoPlazoContent");
		
	}
	
	getdatacombo("/GestionParametros-portlet/js/resources/tip_moneda_sim_deposito_plazo.json","tipoMonedaDepositoHidden","tipoMonedaDepositoContent");
	getdata4('/GestionParametros-portlet/js/resources/plazo_cre_sim_deposito_plazo.json',getSelector);
	setSelector($("plazoCredito"),Sim_Dep_Pla_Soles,"S/.");
	$('tipoMonedaDepositoContent').addEvent('click', changeValorDeposito);
	$('reloadCaptchaDeposito').addEvent('click',reloadCaptchaDeposito);
	cboDepositoPlazos.addEvent("xChange",function(item){
		iValor = item.get('valor').toInt();
		if(iValor === DNI || iValor === 0 ){
			$('documentSimDeposito').set({'value':'','maxLength':'8'});
		}else{
			$('documentSimDeposito').set({'value':'','maxLength':'12'});
		}
		$('errorDeposito').empty();
	});

};

//Aqui comprobamos si hay data en session
function initDepositoSession(simuladorJSON){
		var simulador = JSON.decode(simuladorJSON);
		var plazoCredito = $("plazoCredito");
		
		var getSelector2 = function(data){	
			selectorA("plazoDeposito",data,simulador.plazoCredito);
		};
		
		
		//Aqui es numero de documento
		$('documentSimDeposito').value = simulador.numeroDocumento;
		
		//Aqui es Inversion
		var tipoMoneda = parseInt(simulador.tipoMoneda);
		var valorBien = simulador.valorBien;
		switch (tipoMoneda) {
		case SOLES:
			setSelector(plazoCredito, Sim_Dep_Pla_Soles,"S/.",null,valorBien);
			break;
		case DOLARES:
			setSelector(plazoCredito, Sim_Dep_Pla_Dolares,"$",null,valorBien);
			break;
		case EUROS:
			setSelector(plazoCredito,Sim_Dep_Pla_Euros,"&euro;",null,valorBien);
			break;
		}
		
		//Aqui es el combo de documento
		var tipoDocumento = simulador.tipoDocumento;
		setLongitudTexto(DNI,tipoDocumento,'documentSimDeposito');
		
		//var cboDepositoPlazos = getdata3("/GestionParametros-portlet/js/resources/tip_doc_sim_deposito_plazo.json","docCreDepositoPlazoHidden", "docCreDepositoPlazoContent",tipoDocumento);
		var cboDepositoPlazos = getdata3("/GestionParametros-portlet/js/resources/tip_doc_sim_deposito_plazo.json","docCreDepositoPlazoHidden", "docCreDepositoPlazoContent",tipoDocumento);
		cboDepositoPlazos.addEvent("xChange",function(item){
			iValor = item.get('valor').toInt();
			if(iValor === DNI || iValor === 0 ){
				$('documentSimDeposito').set({'value':'','maxLength':'8'});
			}else{
				$('documentSimDeposito').set({'value':'','maxLength':'12'});
			}
			$('errorDeposito').empty();
		});
		
		//Aqui es el combo de monedas 
		getdatacombo("/GestionParametros-portlet/js/resources/tip_moneda_sim_deposito_plazo.json","tipoMonedaDepositoHidden","tipoMonedaDepositoContent",tipoMoneda);
		
		//Aqui carga el plazo de inversion
		getdata4('/GestionParametros-portlet/js/resources/plazo_cre_sim_deposito_plazo.json',getSelector2);
		
		//Eventos
		$('tipoMonedaDepositoContent').addEvent('click', changeValorDeposito);
		$('reloadCaptchaDeposito').addEvent('click',reloadCaptchaDeposito);
}




var elementDeposito = {
			'btnstep': $('btnDepPlazo'), 
			'msg':$('errorDeposito'),
			'validElement':{
				'docCreDepositoPlazoHidden' :'document',
				'documentSimDeposito':'numeric|docCreDepositoPlazoHidden',
				'codCaptchaDeposito' :'captcha'
			}
};


$('documentSimDeposito').addEvent("keypress",function(e){
	var tipoDocSel=$('docCreDepositoPlazoHidden').value;
	if(tipoDocSel==0){
		/*$('errorDeposito').set('html','*Seleccione un tipo de documento.');*/
		return false;
	}
	$('errorDeposito').empty();
	if(tipoDocSel==DNI){
		return numbers(e);
	}else if(tipoDocSel==CE){
		return alphanumeric(e);
	}
});


var simuladorJSON = $('simuladorBean').value;
if (simuladorJSON !== '') {
	initDepositoSession(simuladorJSON);
} else {
	initDeposito();
}
validstepDeposito(elementDeposito);
