
if($("hiddenFormulario")){
	var hfrm = $("hiddenFormulario").value;    	
}

window.addEvent("domready", function(e) {
	
	if($('indicadorJS').value==='0'){
	
	if($('mensaje')){
		$('mensaje').oncontextmenu = function(){return false;}
		}

	var valdep = $('cboDepartamentoHidden').value;
	var valpro = $('cboProvinciaHidden').value;
	var valdis = $('cboDistritoHidden').value;
	
		if(valdep == 0){
			cargarDepartamentos();
		}else{
			loadComboGrupal(valdep,valpro,valdis);
		}
		
		cargarTemas();
		linkInicial();
		 
		new moovalid(hfrm,{
				btnValid:'enviar',
				onValid:function(){
					loadform();
					envioPorAjax();
				}
			});

		$$('input[name=msg]').fireEvent('click');
	}
	
	// Marco Risco -
	// Validacion de impresion de formulario de reclamacion
	if (($('indicadorPrint')!=null) && ($('indicadorPrint').value=='0')) {
		$('banner').style.display='none';
		$('footer').style.display='none';
		$$("div.journal-content-article").setStyle('display','none');
		$$("div.cadena-template").setStyle('display','none');
		$$("div.social-media").setStyle('display','none');
	}
});


function loadComboGrupal(valdep,valpro,valdis){

	var cbodepa = getdata3("/GestionParametros-portlet/js/resources/departamento.json", "cboDepartamentoHidden", "cbodepartamento",valdep);
	var cbopro = filtrarJson2('get', "/GestionParametros-portlet/js/resources/provincia.json", "id_departamento", "cboProvinciaHidden", "cboprovincia", valdep,valpro);
				filtrarJson2('get', "/GestionParametros-portlet/js/resources/distrito.json", "id_provincia", "cboDistritoHidden", "cboDistrito", valpro,valdis);
				
	cargarEventoClickDepartamento2(cbodepa);
	cargarEventoClickProvincia(cbopro);
}


function linkInicial(){
	$('linkTarjetaCredito').setStyle('display','block');
	$('linkCuentasDeposito').setStyle('display','none');
	$('linkBancaElectronica').setStyle('display','none');
	$('linkCreditoPersonales').setStyle('display','none');
	$('linkSeguros').setStyle('display','none');
	$('linkFondosMutuos').setStyle('display','none');  
}

function cargarTemas(){
	var cbo = getdata2("/GestionParametros-portlet/js/resources/tema_solicitar_contacto.json", "cboTipoTemaHidden", "cbotema");
	dropdownTema(cbo);
}


function cargarDepartamentos() {
	var cbo = getdata2("/GestionParametros-portlet/js/resources/departamento.json", "cboDepartamentoHidden", "cbodepartamento");
	cargarEventoClickDepartamento(cbo);
}

function cargarEventoClickDepartamento(cbo) {
	cbo.addEvent('xChange', function(item) {
		var valor = item.get('valor');
		
		var cboProvincias = filtrarJson('get', "/GestionParametros-portlet/js/resources/provincia.json", "id_departamento", "cboProvinciaHidden", "cboprovincia", valor);		
		
		cargarEventoClickProvincia(cboProvincias);
		var list =  $(document.body).getElement("div#listcboDistritoHidden.droplist") || false
				
		if(list){
			$("cboDistrito").getElement("div").set("html","Seleccione");
			$("cboDistrito").getElement("input").set("value","0");
			list.set('html','');
		}
	});
}

function cargarEventoClickDepartamento2(cbo) {
	cbo.addEvent('xChange', function(item) {
		var valor = item.get('valor');
		var cboProvincias = filtrarJson('get', "/GestionParametros-portlet/js/resources/provincia.json", "id_departamento", "cboProvinciaHidden", "cboprovincia", valor);
		cargarEventoClickProvincia(cboProvincias);
	});
}



function cargarEventoClickProvincia(cbo) {
	cbo.addEvent('xChange', function(item) {
		var valor = item.get('valor');
		var cboDistritos = filtrarJson('get', "/GestionParametros-portlet/js/resources/distrito.json", "id_provincia", "cboDistritoHidden", "cboDistrito", valor);
		setubigeo(cboDistritos);
	});
}


function setubigeo(cbo){
	cbo.addEvent('xChange', function(item) {
		devolverValores();
	});
}


function newImage(){
	var d = new Date();
  	var milliseconds=d.getTime();
	document.getElementById("imgCaptcha").src="/SolicitarContacto-portlet/servlets/jcaptcha.jpg?RANDOM=" + milliseconds;
}

/**  Cuando se selecciona el radio de tipo de mensaje */  
$$('input[name=msg]').addEvent('click', function(){
	$$('.droplist').setStyle('display','none');
	var tipoMensaje=$$('input[name=msg]:checked')[0].value ;	
	
	switch (tipoMensaje) {
	case 'Consulta':
		$('tema').setStyle('display','block');
		$('info').setStyle('display','block');	
		break;
	case 'Pedido':
		$('tema').setStyle('display','block');
		$('info').setStyle('display','block');	
		break;
	case 'Reclamo':
	case 'Queja':
		$('tema').setStyle('display','block');
		$('info').setStyle('display','none');
		break;
	case 'Sugerencia':
		$('tema').setStyle('display','none');
		$('info').setStyle('display','none');
		break;
	default:
		break;
	}
});

function dropdownTema(cbo){
	cbo.addEvent('xChange',function(item){
		
		var tipo_tema = item.get('valor').toInt(); 
		//console.log(tipo_tema);
		switch (tipo_tema) {
		case 1:
			ocultarLinks();
			$('info').setStyle('display','block');
			$('linkTarjetaCredito').setStyle('display','block');
			break;
		case 2:
			ocultarLinks();
			$('info').setStyle('display','block');
			$('linkCuentasDeposito').setStyle('display','block');
			break;
		case 3:
			ocultarLinks();
			$('info').setStyle('display','block');
			$('linkBancaElectronica').setStyle('display','block');
			break;
		case 4:
			ocultarLinks();
			$('info').setStyle('display','block');
			$('linkCreditoPersonales').setStyle('display','block');
			break;
		case 5:
			ocultarLinks();
			$('info').setStyle('display','block');
			$('linkSeguros').setStyle('display','block');
			break;
		case 6:
			ocultarLinks();
			$('info').setStyle('display','block');
			$('linkFondosMutuos').setStyle('display','block');
			break;
		case 7:
			ocultarLinks();
			$('info').setStyle('display','none');
			break;
		}			
	});	
}
	

function ocultarLinks(){
	$('linkTarjetaCredito').setStyle('display','none');
	$('linkCuentasDeposito').setStyle('display','none');
	$('linkBancaElectronica').setStyle('display','none');
	$('linkCreditoPersonales').setStyle('display','none');
	$('linkSeguros').setStyle('display','none');
	$('linkFondosMutuos').setStyle('display','none'); 
}

function devolverValores(){
	var depa = $("cbodepartamento").getElement("div").get('html');   
	var prov = $("cboprovincia").getElement("div").get('html');
	var dist = $("cboDistrito").getElement("div").get('html');

	//obtengo valor
	//console.log("Valor departamento --> " + $("cbodepartamento").getElement("input").value);
	//obtengo texto
	
	
	//alert("Texto departamento --> " + $("cbodepartamento").getElement("div").get('html'));
	//alert("Texto provincia --> " + $("cboprovincia").getElement("div").get('html'));
	//alert("Texto distrito --> " + $("cboDistrito").getElement("div").get('html'));
	
	$('ubigeo').value = depa+  "%" +prov +  "%" + dist;
}


function imposeMaxLength(Object, MaxLen){
		
  if(Object.value.length >  MaxLen){
	 txt = Object.value.substring(0,MaxLen);
	 //$('caracteres').set('text',MaxLen);
	 Object.set('value',txt);
  }
}


function validar(e) {
	  tecla = (document.all) ? e.keyCode : e.which;
	  return  !(tecla==86 && e.ctrlKey);
	}


function cuenta(){
	var textLength = $('mensaje').value.length
	$('caracteres').set('text',textLength);
}


function actualizarImagen(){
	var d = new Date();
  	var milliseconds=d.getTime();
  	
	document.getElementById("imgCaptcha").src= $("urlImagen").value+'&RAMDOM='+ milliseconds;
}


function envioPorAjax(){
	
	var surl = $("validarCaptcha").value;
	var dato = $("txtCaptcha").value;
	devolverValores();
	var json = new Request.JSON({
		method : 'post',
		url : surl,
		data : {codigo:dato},
		onComplete : function(data) {
		   	if (data.error == 'false') {
		   		actualizarImagen();
		   		//$("resultado").set("html",$("resultado").get('html')+" incorrecto");
		   		closeloadform();
		   		$('txtCaptcha').set('value','');
		   		$('txtCaptcha').addClass("text-error");	
		   		$('MSJ_CAPTCHA').setStyle("display", "block");
			} else {
				actualizarImagen();
				//$("resultado").set('html',$("resultado").get('html')+" correcto");
				$(hfrm).submit();
			}
		},
		onFailure:function(error){

		}
	});
	json.send();	
} 