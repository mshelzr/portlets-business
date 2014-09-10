var msgErrorOption = null;
var msgErrorDate  = null;

window.addEvent("domready", function(){
	cargarMensajesIteractivos();
	
	/********************** Formulario 1 ************************************/
	if($('hiddenF1')){
		closeloadform();
		redireccionarURL();
		/*Tipo Documento*/
		getdatacombo("/GestionParametros-portlet/js/resources/tipo_documento_solicitud_cuenta_sueldo.json", "tipDoc", "cboDocumento");
		loadOptionGroup();
		validarDocument();
		validarDocumento();
		
		//Generamos seleccion por cada check de productos complementarios
		var productos= $('contentProductosComplementarios').getElements('input[type=checkbox]');
		var codProductoComple = $('checkCodProducto').get('value');
		if(codProductoComple != ""){
			codProductoComple = codProductoComple.split(",");
		}else{
			codProductoComple = null;
		}
		productos.each(function(el){
		    if(isContains(el.get('name'),codProductoComple)){
		    	el.checked = true;
		    }
		});
				
		var obtenerURL=$('obtenerURL').value;
		var pasoAvanza=$('numeroPaso2').value.toInt();
		
		var hfrm = $("hiddenF1").value;
		new moovalid(hfrm,{
			btnValid:'btn1Adelante',
			optional:2,
	        forceOptional:1,
	        optionalValue:$('cboDocumento'),
			onValid:function(){
				loadform();
				var urlEnvio=$('urlPaso1_cs').value;		
				validarDate();
				//Obtenemos el codigo del check que esta seleccionado
				var checkCodProd = '';
				var productos= $('contentProductosComplementarios').getElements('input[type=checkbox]:checked');
	        	for ( var i = 0; i < productos.length; i++) {
	        		checkCodProd += productos[i].name+',';
				}
	        	checkCodProd = checkCodProd.substring(0,checkCodProd.length-1);
	        	
				//ajax
				var jsonRequest = new Request.JSON({
					method : 'post',
					url:urlEnvio ,
					data : {
						tipDoc: $('tipDoc').value,
						ndocumento: $('ndocumento').value,
						apePater: $('apePater').value,
						apeMater: $('apeMater').value,
						priNombre: $('priNombre').value,
						segNombre: $('segNombre').value,
						fecNacimiento: $('fecNacimiento').value,
						tipsexo: $('tipsexo').value,
						razonSocial : $('razonSocial').value,
						checkCodProducto: checkCodProd,
						nombre_producto_url : $('nombre_producto_url').value
					},
					onComplete : function(response) {
						var respuesta=response.resp;	
						if(respuesta>0){
							obtenerURL=obtenerURL+pasoAvanza;
							location.href=obtenerURL;
						}else{
							mostrarMensajes(response.strErrors);
							closeloadform();
						}
					}
				});
				jsonRequest.send();
			}
		});
	}
	/************************************************************************/
	
	/********************** Formulario 2 ************************************/
	if($('hiddenF2')){	
		closeloadform();
		redireccionarURL();
		//Generamos seleccion por cada check de productos complementarios
		var productos= $('contentProductosComplementarios').getElements('input[type=checkbox]');
		var codProductoComple = $('checkCodProducto').get('value');
		if(codProductoComple != ""){
			codProductoComple = codProductoComple.split(",");
		}else{
			codProductoComple = null;
		}
		productos.each(function(el){
		    if(isContains(el.get('name'),codProductoComple)){
		    	el.checked = true;
		    }
		});

		var departamento = $('cbodepartamentoHidden').value;
		loadComboGrupalDepartamento(departamento);
		
		var hfrm = $("hiddenF2").value;
		new moovalid(hfrm,{
			btnValid:'btn2Adelante',
			onValid:function(){
				loadform();	
				var urlEnvio=$('urlPaso2_cs').value;
				//Obtenemos el codigo del check que esta seleccionado
				var checkCodProd = '';
				var productos= $('contentProductosComplementarios').getElements('input[type=checkbox]:checked');
	        	for ( var i = 0; i < productos.length; i++) {
	        		checkCodProd += productos[i].name+',';
				}
	        	checkCodProd = checkCodProd.substring(0,checkCodProd.length-1);
	        	
				/*ajax*/
				var jsonRequest = new Request.JSON({
					method : 'post',
					url:urlEnvio ,
					data : {
						cbodepartamento: $('cbodepartamentoHidden').value,
						cbodepartamentoTexto: $("cbodepartamento").getElement("div").get('html'), 
						celular: $('celular').value,
						telFijo: $('telFijo').value,
						telTrabajo: $('telTrabajo').value,
						anexo: $('anexo').value,
						email: $('email').value,
						confEmail: $('confEmail').value,
						checkCodProducto: checkCodProd,
						nombre_producto_url : $('nombre_producto_url').value
					},
					onComplete : function(response) {				
						envioPorAjax(response);						
					}
				 });
				jsonRequest.send();
			}
		});	
		
		$('btn2Atras').addEvent("click", function(e) {
			if(Browser.ie6 ){
				this.set('href','#');
			}
			var obtenerURL=$('obtenerURL').value;
			var pasoRetrocede=$('numeroPaso1').value.toInt();
			obtenerURL=obtenerURL+pasoRetrocede;
			location.href=obtenerURL;
			loadform();
		});
	}
	
	
	/************************************************************************/
	/********************** Formulario 3 ************************************/
	if($('hiddenF3')){
		closeloadform();
		redireccionarURL();
		//Generamos seleccion por cada check de productos complementarios
		var productos= $('contentProductosComplementarios').getElements('input[type=checkbox]');
		var codProductoComple = $('checkCodProducto').get('value');
		if(codProductoComple != ""){
			codProductoComple = codProductoComple.split(",");
		}else{
			codProductoComple = null;
		}
		productos.each(function(el){
		    if(isContains(el.get('name'),codProductoComple)){
		    	el.checked = true;
		    }
		});
		closeloadform();
		
	 	var obtenerURL=$('obtenerURL').value;
		var pasoAvanza=$('numeroPaso4').value.toInt();
		
		var hfrm = $("hiddenF3").value;		
		new moovalid(hfrm,{
			btnValid:'btn3Adelante',
			onValid:function(){
				loadform();	
				var urlEnvio=$('urlPaso3_cs').value;
				//Obtenemos el codigo del check que esta seleccionado
				var checkCodProd = '';
				var productos= $('contentProductosComplementarios').getElements('input[type=checkbox]:checked');
	        	for ( var i = 0; i < productos.length; i++) {
	        		checkCodProd += productos[i].name+',';
				}
	        	checkCodProd = checkCodProd.substring(0,checkCodProd.length-1);
				/*ajax*/
				var jsonRequest = new Request.JSON({
					method : 'post',
					url:urlEnvio ,
					data: {
						checkCodProducto: checkCodProd,
						nombre_producto_url : $('nombre_producto_url').value
						},
					onComplete : function(response) {	
						var respuesta=response.resp;
						if (respuesta <= 0) {
							mostrarMensajes(response.strErrors);
							closeloadform();
						} else if(respuesta == 1){
							obtenerURL=obtenerURL+pasoAvanza;
							location.href=obtenerURL;
						} else if(respuesta == 2){
							//Mandamos a pagina de error
							limpiarMensajesError();
							location.href=$('urlDireccionarError').value;
						}	
					}
				 });
				jsonRequest.send();
			}
		});	
		
		$('btn3Atras').addEvent("click",function(e){
			if(Browser.ie6 ){
				this.set('href','#');
			}
			var pasoRetrocede=$('numeroPaso2').value.toInt();
			obtenerURL=obtenerURL+pasoRetrocede;
			location.href=obtenerURL;
			loadform();
		});
		
	}
	/************************************************************************/
});


function envioPorAjax(response){
	var surl = $("validarCaptchaSolicitudes").value;
	var obtenerURL = $('obtenerURL').value;
	var pasoAvanza = $('numeroPaso3').value.toInt();
	var dato = $("txtCaptcha").value;
	
	var json = new Request.JSON({
		method : 'post',
		url : surl,
		data : {codigo:dato},
		onComplete : function(data) {
			var respuesta=response.resp;
			
			if(respuesta>0){
				   	if (data.error == 'false') {
				   		$('txtCaptcha').set('value','');
				   		mostrarMensajes(JSON.decode('["txtCaptcha"]'));
				   		actualizarImagen();
				   		closeloadform();
					 }  else {		
						 limpiarMensajesError();
						 limpiarMensaje2('txtCaptcha');
							obtenerURL=obtenerURL+pasoAvanza;
							location.href=obtenerURL;
					 }
			}else{
				actualizarImagen();
				closeloadform();
				$('txtCaptcha').set('value','');
			   	if (data.error == 'false') {
			   		mostrarMensajes(response.strErrors);
			   		mostrarMensajes(JSON.decode('["txtCaptcha"]'),true);
				}else{
					mostrarMensajes(response.strErrors);
				}
			}	
		},
		onFailure:function(error){
		}
	});
	json.send();
} 


function cargarMensajesIteractivos() {
	try {
		msgErrorOption = [ {
			'id' : '1',
			'msg' : $("MSJ_DNI").value
		}, {
			'id' : '2',
			'msg' : $("MSJ_CARNET_EXTRANJERIA").value
		} ];
		
		msgErrorDate = [ {
			'id' : '1',
			'msg' : $("MSJ_FECHA_NACIMIENTO1").value
		}, {
			'id' : '2',
			'msg' : $("MSJ_FECHA_NACIMIENTO2").value
		} ];

	} catch (e) {
	}
}

function validarDocument() {
	$$(".optiongroup span").each(function(item) {
		var span = item;
		if (span.get("class") != null) {
			if (span.get("class") == "active-op") {
				var val = span.get('valor');
				msgErrorOption.each(function(item) {
					if (item.id == val) {
						$('msj_ndocumento').set('html', item.msg);
						return false;
					}
				});
			}
		}
	});
	return true;
}


function validarDocumento() {
	$("cboDocumento").addEvent("blur", function() {
		var val = this.get('valor');
		msgErrorOption.each(function(item) {
			if (item.id == val) {
				$('msj_ndocumento').set('html', item.msg);
			}
		});
	});  
	$("cboDocumento").addEvent("click", function() {
		var val = this.get('valor');
		msgErrorOption.each(function(item) {
			if (item.id == val) {
				$('msj_ndocumento').set('html', item.msg);
			}
		});
	});
}

function actualizarImagen(){
	var d = new Date();
  	var milliseconds=d.getTime();
  	document.getElementById("imgCaptcha").src= $("urlImagen").value + '&RANDOM=' + milliseconds;
}


function devolverValores(){
	//console.log("Texto --> " + $("tipsexo").getElement("span").get('html'));
}

function validarDate() {
	var fecNacimiento = $('fecNacimiento').get('value');
	
	if (fecNacimiento=='dd/mm/aaaa') {
		$('msj_fecNacimiento').set('html', msgErrorDate[0].msg);		
	}else{
		var diaNacimiento = fecNacimiento.split("/",1);
		var mesNacimiento = fecNacimiento.substring(3,5);
		var anhoNacimiento = fecNacimiento.substring(6,10);
		
		var fechaActual = new Date();
	    diaActual = fechaActual.getDate();
	    mesActual = fechaActual.getMonth() +1;
	    annoActual = fechaActual.getFullYear();
	    
	    var edad=annoActual-anhoNacimiento;
	    
	    if (mesActual < mesNacimiento){
	    	edad--;
	    } else if (mesActual == mesNacimiento){
	    	if (diaActual < diaNacimiento)
	    	edad--;
	    }
	    
    	if(edad<18 || edad >100){
			$('msj_fecNacimiento').set('html', msgErrorDate[1].msg);	
    		isValido= false;
    	}
	}
}

function loadComboGrupalDepartamento(departamento){
	 getdata3("/GestionParametros-portlet/js/resources/departamento.json", "cbodepartamentoHidden", "cbodepartamento",departamento);
}


function cargarEventoClickDepartamento() {
	getdata2("/GestionParametros-portlet/js/resources/provincia.json", "cbodepartamentoHidden", "cbodepartamento");
}




function mostrarMensajes(lstErrores,clear) {
	clear || (clear = false);
	if(!clear){
		limpiarMensajesError();
	}
	var prefijo = "msj_";
	lstErrores.each(function(item) {
		mensajeError(prefijo , item);
	});
}

function mensajeError(pre,idx) {
	var msj = $(pre+idx);
	var texto = $(idx);
	if (msj != null) {
		msj.setStyle("display", "block");
		texto.addClass("text-error");	
		texto.removeClass("bgfa");	
	}
}

function mensajeError2(idx) {
	var msj = $(idx);
	if (msj != null) {
		msj.setStyle("display", "block");
	}
}

function limpiarMensajesError() {
	var form_error = $$(".form-error");
	form_error.each(function(item) {
		limpiarMensaje(item.id);
	});
	
	var form_error2 = $$(".campos-oblig");
	form_error2.each(function(item) {
		limpiarMensaje2(item.id);
	});
}

function limpiarMensaje(id) {
	var msj = $(id);
	if (msj != null) {
		msj.setStyle("display", "none");
	}
}

function limpiarMensaje2(id) {
	var msj = $(id);
	if (msj != null) {
		 msj.removeClass(".text-error");
	}
}

//Metodo que se encarga de verificar si es uno de los productos complementarios de la sesion
function isContains(codigo,arregloSesion){
	if(arregloSesion != null){
		for(var i = 0;i < arregloSesion.length;i++){
		    if(codigo == arregloSesion[i]){
		    	return true;
		    }
		}
	}
	return false;
}

function loadOptionGroup(){
	var tipDoc=$('tipDoc1').get('value');
	if(tipDoc=='1'){
		getdatacombo("/GestionParametros-portlet/js/resources/tipo_documento_solicitud_cuenta_sueldo.json", "tipDoc", "cboDocumento",false,false,false );	
	}else{
		getdatacombo("/GestionParametros-portlet/js/resources/tipo_documento_solicitud_cuenta_sueldo.json", "tipDoc", "cboDocumento",tipDoc,false,false);
	}
}

function redireccionarURL(){
	var paso=$('paso').value.toInt();
	var obtenerURL=$('obtenerURL').value;
	var pasoAvanza=$('numeroPaso1').value.toInt();
	
	if(paso>4){
		obtenerURL=obtenerURL+pasoAvanza;
		//alert(obtenerURL);
		location.href=obtenerURL;
	}else{
		var estado1=$('estadoPaso1Sueldo').value;
		var estado2=$('estadoPaso2Sueldo').value;
		
		if(estado1=='false' && estado2=='false' && paso!=1){
			loadform();
			obtenerURL=obtenerURL+pasoAvanza;
			location.href=obtenerURL;
		}
		
		if(estado1=='true' && estado2=='false' && paso>2){
			loadform();
			obtenerURL=obtenerURL+2;
			location.href=obtenerURL;			
		}
	}
}