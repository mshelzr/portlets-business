cargarVariables();
_gaq.push(['_trackEvent', 'Simulaciones', 'Paso 1 Simulacion', 'Fondos Mutuos']);
seeParent();

var RangoPlazoFondosMutuosSoles, RangoPlazoFondosMutuosDolares;

	RangoPlazoFondosMutuosSoles = $('RANGO_PLAZO_FONDOS_MUTUOS_SOLES').value;
	RangoPlazoFondosMutuosDolares =  $('RANGO_PLAZO_FONDOS_MUTUOS_DOLARES').value;

var getSelectorFondos = function(data){	
	selectorA("plazoSliderFondos",data);
};

var reloadCaptchafondos = function()
{
	newImage('imgCaptchaFondosMutuos','URLTraerCaptchaFondosMutuos');
	limpiarPlaceHolder('codCaptchaFondosMutuos');
};

var changeValorFondosMutuos = function(){
	var  plazoCredito; 
	valorSelected = this.getElement('input').value.toInt();
	plazoCredito = $("scfmInvertir");
	if(iValor !== valorSelected){
		switch (valorSelected) {
		case 1:
			setSelector(plazoCredito, RangoPlazoFondosMutuosSoles,"S/.");
			break;
		case 2:
			setSelector(plazoCredito, RangoPlazoFondosMutuosDolares,"$");
			break;
		}
		iValor = valorSelected;
	}
};

var validFondosMutuos = function(){	
	var validCaptchaCorrect = function(res){
		if(res.error === "true"){
			reloadCaptchafondos();
			$("codCaptchaFondosMutuos").set('value','');
			$("validEnvioFondosMutuos").set({"html":res.mensaje,'styles':{'Display':'block'}});
			closeloadform();
		} else{
			goURL(res.url);
		}
	};
	
	var checkElemnt = function(rule, input, msg){
		iValue = $(input).value;
		if(rule == 'required' && !iValue.test(/[^.*]/)){
			msg.set('html','*Seleccione una de las alternativas');
			bValue =  false;
		}else if( rule === 'captcha'){
			bCaptcha = $(input).value.test(/[^.*]/);
			if(bCaptcha)
			{
				loadform();
				var URLvalidarCaptchaFondosMutuos,formCreFondosMutuos;	
				URLvalidarCaptchaFondosMutuos = $("URLvalidarCaptchaFondosMutuos").value;
				formCreFondosMutuos = $("formCreFondosMutuos");
					valCapcha(URLvalidarCaptchaFondosMutuos,formCreFondosMutuos,validCaptchaCorrect);
			}else{
				msg.set("html","*Ingrese un c\u00f3digo Captcha correcto.");
				
			}		
		}else{
			msg.set('html','');
			bValue = true;
		}
		return bValue;
	};
	
	$('continuar2FondosMutuos').addEvent('click', function(){
		return checkElemnt('required', 'fondosSimInvertidoHidden',$('trtxterrorCont2FonMut'));
	});
	
	$('continuar3FondosMutuos').addEvent('click', function(){
		return checkElemnt('required', 'fondosSimConocimientoHidden',$('trtxterrorCont3FonMut'));
	});
	
	$('continuar4FondosMutuos').addEvent('click', function(){
		return checkElemnt('required', 'fondosSimVariacionesHidden',$('trtxterrorCont4FonMut'));
	});
	
	$('validFondosMutuos').addEvent('click', function(){
		return checkElemnt('captcha', 'codCaptchaFondosMutuos',$('validEnvioFondosMutuos'));
	});
	
};

var initFondosMutuos =  function(){
	//Generar tabs
	iTabsControl('.tab-mutuos','.pas-mutuos','.continuar-pr','.regresar-pr');
	//paso1
	upOptionGroupVertical("/GestionParametros-portlet/js/resources/invertido_sim_fondos_mutuos.json", "fondosSimInvertidoHidden", "fondosSimInvertidoContent");
	//paso2
	upOptionGroupVertical("/GestionParametros-portlet/js/resources/conocimiento_sim_fondos_mutuos.json", "fondosSimConocimientoHidden", "fondosSimConocimientoContent");
	//paso3
	upOptionGroupVertical("/GestionParametros-portlet/js/resources/desvalorizara_sim_fondos_mutuos.json", "fondosSimVariacionesHidden", "fondosSimVariacionesContent");
	//paso4
	getdatacombo("/GestionParametros-portlet/js/resources/tip_doc_sim_fondos_mutuos.json","tipoMonedaSimFondosMutuoshidden","tipoMonedaSimFondosMutuosContent");
	getdata4('/GestionParametros-portlet/js/resources/plazo_sim_fondo_mutuo.json',getSelectorFondos);
	setSelector($("scfmInvertir"),RangoPlazoFondosMutuosSoles,"S/.");
	$('tipoMonedaSimFondosMutuosContent').addEvent('click',changeValorFondosMutuos);
	$('fondosCaptchaReload').addEvent('click',reloadCaptchafondos);
	$('returnCaptchaFondos').addEvent('click',reloadCaptchafondos);
};



initFondosMutuos();
validFondosMutuos();

