window.addEvent("domready",function(){
	if($('contentListSimulator')){
		$$('.porlet-right-hp').setStyle('visibility', 'hidden');		
		loadform();
		
		iTabsHome('.tab-hp','.feature-hp',false,$('tiempoSlider').value);

		$("contentListSimulator").addEvent("click",function(e){
			
			if($$(".droplist").length > 0){
				$$(".droplist").setStyles({"display":"none"});
			}
		});
		
	}
	
      	var scriptSimulador = new Array();
		var vehicular = $("tabVehicular") || false;
		var hipoteca = $("tabHipotecario") || false;
		var personal = $("tabPersonal") || false;
		var mutuos = $("tabMutuos") || false;
		var plazo = $("tabPlazo") || false;
		var listSimulator = $("listSimulator") || false;
		
		
		var editProductos = $("tipoSimuladorEdit") || false;
		
		//var script;
		//Cargamnos las variables
		var DNI;
		var CE;
		var SOLES;
		var DOLARES;
		var EUROS;
		var PAGINA_ACTUAL;

		if(listSimulator)
		{
			
			
			$$("#listSimulator li").addEvent("click",function(e){
				switch (e.target.get('id')) {
				case 'crePrestamo':
					newImage('captchaPersonal','URLTraerCaptchaPersonal');
					limpiarPlaceHolder('txtcaptchaPersonal');
					break;
				case 'crePlazoFijo':
					newImage('captchaDeposito','URLTraerCaptchaDeposito');
					limpiarPlaceHolder('codCaptchaDeposito');
					break;
				case 'creVehicular':
					newImage('captchaVehicular','URLTraerCaptchaVehicular');
					limpiarPlaceHolder('txtCaptchaVehicular');
					break;
				case 'creFondosMutuos':
					newImage('imgCaptchaFondosMutuos','URLTraerCaptchaFondosMutuos');
					limpiarPlaceHolder('codCaptchaFondosMutuos');
					break;
				case 'creHipotecario':
					newImage('captchaHipotecario','URLTraerCaptchaHipotecario');
					limpiarPlaceHolder('txtCaptchaHipotecario');
					break;
				}
			});
			
		}

		if(vehicular){
			//script = new Element('script',{'src':'/DestacadoPrincipal-portlet/js/vehicular.js'}).inject($(document.body),'bottom');
			scriptSimulador.push('/DestacadoPrincipal-portlet/js/vehicular.js');
		}
		if(hipoteca){
			//script = new Element('script',{'src':'/DestacadoPrincipal-portlet/js/hipotecario.js'}).inject($(document.body),'bottom');
			scriptSimulador.push('/DestacadoPrincipal-portlet/js/hipotecario.js');
		}
		if(personal){
			//script = new Element('script',{'src':'/DestacadoPrincipal-portlet/js/personal.js'}).inject($(document.body),'bottom');
			scriptSimulador.push('/DestacadoPrincipal-portlet/js/personal.js');
		}
		if(mutuos){
			//script = new Element('script',{'src':'/DestacadoPrincipal-portlet/js/fondos.js'}).inject($(document.body),'bottom');
			scriptSimulador.push('/DestacadoPrincipal-portlet/js/fondos.js');
		}
		if(plazo){
			//script = new Element('script',{'src':'/DestacadoPrincipal-portlet/js/deposito.js'}).inject($(document.body),'bottom');
			scriptSimulador.push('/DestacadoPrincipal-portlet/js/deposito.js');
		}
		

		if(scriptSimulador.length>0){
			
			new Asset.javascripts(scriptSimulador,{
				onComplete: function(){
					closeloadform();
					$$('.porlet-right-hp').setStyle('visibility', 'visible');
				}
			});
		}
		if(editProductos){
			var jsonEdit=$('jsonSimuladorEdit').value;
			
			var productos = JSON.decode(jsonEdit);
			
			$("tipoSimuladorEdit").addEvent('change',function(e){
				
				var htmlCombo='<option value="sin-ficha">Sin Ficha</option>';
				
				var valor = this.get('value');
				
				productos.list.each(function(padre){
					if(padre.codigo==valor){
						
						//Seteo los productos hijos
						padre.productos.list.each(function(hijo){
							
							htmlCombo+='<option value="'+hijo.codigo+'">'+hijo.nombre+'</option>';
						});
					}
				});
				
				$('tipoFichaSimuladorEdit').set('html',htmlCombo);
			});
		}
		
});

function newImage(idElemento,idURLCaptcha){
	var d = new Date();
  	var milliseconds=d.getTime();
  	document.getElementById(idElemento).src=$(idURLCaptcha).value+'&RAMDOM='+ milliseconds;
}

function numbers(e) { // 1
	
	tecla = e.code;
	if (tecla==8||tecla==9) return true; // 3
	patron = /\d/; // Solo acepta números
	te = String.fromCharCode(tecla); // 5
	return patron.test(te); // 6
} 

function alphanumeric(e) { // 1
	tecla = e.code;
	if (tecla==8||tecla==9) return true; // 3
	patron = /\w/; // Alfanumerico
	te = String.fromCharCode(tecla); // 5
	return patron.test(te); // 6
}

function valCapcha(surl,form,callback){
	var form_data = form.toQueryString().parseQueryString();
	
	var json = new Request.JSON({
		method : 'post',
		url : surl,
		data : form_data,
		onComplete : function(data) {
		    callback(data);
		},
		onFailure:function(error){

		}
	});
	json.send();	
}

function seeParent(){
	var parentP = $$(".porlet-right-hp").getParent().get("class");
	if(parentP == "formato-sf-II"){
		$$(".feature-hp").removeClass('alt_med');
		var widthP = $$(".porlet-right-hp").getParent().getStyle('width');
		$$(".porlet-right-hp").setStyles({
			'background': 'none',
			//'overflow': 'hidden',
			'width': widthP
			});
		$$('.feature-hp').setStyle('width',610);
		$$('.sec-feature-img').setStyles({
			'width':200,
			'height':204,
			'margin':'40px 0 0 0'
			});
		$$('.sec-feature-img').getElement('img').setStyles({
			'width':200,
			'height':204
			});
		}
	}

function cargarVariables(){
	DNI=parseInt($('SIM_DNI').value);
	CE=parseInt($('SIM_CE').value);
	SOLES=parseInt($('SIM_SOLES').value);
	DOLARES=parseInt($('SIM_DOLARES').value);
	EUROS=parseInt($('SIM_EUROS').value);
	PAGINA_ACTUAL=$('SIM_PAGINA_ACTUAL').value;
}

function setLongitudTexto(varDNI,tipDoc,componente){
	if(parseInt(tipDoc) === parseInt(varDNI) || parseInt(tipDoc) === 0 ){
		$(componente).set({'maxLength':'8'});
	}else{
		$(componente).set({'maxLength':'12'});
	}
}

function limpiarPlaceHolder(idCampo){
	if(Browser.ie){
		var placeholder=$(idCampo).get('placeholder');
		$(idCampo).value=placeholder;
	}else{
		$(idCampo).value='';
	}
}