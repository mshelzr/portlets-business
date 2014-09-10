var limite = null;
var fileValidate = false;
var objfilet = {};
var btnSubmit = null;
var msgErrorOption = null;
window.addEvent("domready", function() {
	try {
		if($("limite")!=null){
			limite = $("limite").value;
			btnSubmit = $("btnSubmit");
			cargarButons();
			msgErrorOption = [ {
				'id' : '1',
				'msg' : "Debes adjuntar un archivo correcto."
			}, {
				'id' : '2',
				'msg' : "El formato no es el correcto."
			}, {
				'id' : '3',
				'msg' : "El tamaño no es el correcto."
			}, {
				'id' : '4',
				'msg' : "El archivo seleccionado no tiene errores."
			}, {
				'id' : '5',
				'msg' : "La estructura del archivo contiene errores."
			}, {
				'id' : '6',
				'msg' : "Registro exitoso."
			}];
		}	
	} catch (e) {
		
	}				
});

function obtenerRespuesta(){
	var resp = null;
	var obtenerRespuesta = $("obtenerRespuesta").value;
	var jsonRequest = new Request.JSON({
		method : 'get',
		url : obtenerRespuesta,
		noCache : true,
		async : false,
		onComplete : function(response) {
			var response = eval("(" + response + ")");
			resp = response;
		}	
	});
	jsonRequest.send();	
		
	return resp;
}

function cargarButons() {
	var archivo_masivo = $("archivo_masivo");
	var btnGrabar = $("btnGrabar");
	var formSociosRemesa = $("formSociosRemesa");
	var msj = $("msj");
	btnGrabar.addEvent('click', function(e) {	
		msj.set("class","");	
		msj.set("html", "");
		formSociosRemesa.removeEvents("submit");
		formSociosRemesa.addEvent("submit", function(event) {
			validarDocumentoIdentidad(event, formSociosRemesa, formSociosRemesa.get("action"), /^(xls|xlsx|txt)$/, limite, "upload_target2", "archivo_masivo", function(resp) {
				if(resp.i == undefined){				
					rspIframe = obtenerRespuesta();						
				}else{
					rspIframe = resp;
				}
				btnGrabar.set('disabled','');
				btnSubmit.disabled = false;				
				var verListaErrores=$("verListaErrores").value;
				if (rspIframe.rep != undefined) {
					var str = "";
					if(rspIframe.error!=undefined && rspIframe.error>=0){
						str = msgErrorOption[rspIframe.error].msg ;
					}	
					if(rspIframe.rep){
											
						var strErre = "";	
						
						if(rspIframe.lstErrores!=undefined && rspIframe.lstErrores.length>0){
							strErre = " Detalle : <a href='"+verListaErrores+"&urlPreview="+escape(rspIframe.urlPreview)+"' > Detalle de errores en el archivo. </a> ";
						
							msj.set("class","portlet-msg-error");			
							msj.set("html", str + " <br> "+strErre );				
						
						}else{
							msj.set("class","portlet-msg-info");			
							msj.set("html", rspIframe.mensaje  + "  " + str + " <br> "+strErre );	
						}											
					}else{
						var strErre = "";						
						if(rspIframe.lstErrores!=undefined && rspIframe.lstErrores.length>0){
							strErre = " Detalle : <a href='"+verListaErrores+"&urlPreview="+escape(rspIframe.urlPreview)+"' > Detalle de errores en el archivo. </a> ";
						}
						msj.set("class","portlet-msg-error");
						msj.set("html", str + " <br> "+strErre );		
					}					
				}				
			});
		});
		btnSubmit.click();
		btnGrabar.disabled = true;
		btnSubmit.disabled = true;		
	});
}

/**
 * el validador de archivos cliente
 */
function validarDocumentoIdentidad(e, form, url, extFile, limiteFile, frame, input, callback) {
	// loadform();
	var input = $(input);
	if (input.value != "") {
		var ext = getExt(input.value)[0];
		if ((ext && extFile.test(ext))) {
			if (Browser.ie) {
				form.action = url;
				iframe = iframeCreate(form, frame, callback);
			} else {
				var size = input.files[0].size;
				if (size <= limiteFile) {
					iframe = iframeCreate(form, frame, callback);
					form.action = url;
				} else {
					e.stop();
					callback({
						"i" : 0,
						"error" : 2,
						"rep" : false
					});
				}
			}
		} else {
			e.stop();
			callback({
				"i" : 0,
				"error" : 1,
				"rep" : false
			});
		}
	} else {
		e.stop();
		callback({
			"i" : 0,
			"error" : 0,
			"rep" : false
		});
	}

}

/**
 * Crea un iframe y elimina al terminar el load, donde se ejecuta el evento de
 * callback para obtener el resutlado dentro de la etiqueta div jsonRespuesta
 * asi obteniendo la respuesta del servidor
 * 
 * @param form
 * @param identificador
 * @param callback
 * @returns {Element}
 */
function iframeCreate(form, identificador, callback) {
	

	var msj = $("msj");
	msj.set("html", "Cargando <img alt=''  src='/cargaMasiva-portlet/img/loading_indicator.gif'>  ");
	
	var i = new Element('iframe', {
		'id' : identificador,
		"name" : identificador,
		"width" : "0",
		"height" : "0",
		"border" : "0",
		styles : {
			"width" : "0",
			"height" : "0",
			"border" : "none"
		}
	});
	i.inject(form);// se inyecta al formulario
	form.target = i.get("id");// se le otorga el target de formulario creado
	i.addEvent('load', function() {
		var ret = frames[identificador].document.getElementById("jsonRespuesta").innerHTML;// aca
		// se
		// obtiene
		// el
		// contedio
		// del
		// div
		// console.log("ret:"+ret);
		var data = eval("(" + ret + ")");
		msj.set("html", "");
		 i.dispose();// se destruye el iframe
		callback(data);// se ejecuta el callback
	});
	return i;
}

/**
 * Se obtiene la extencion del archivo ingresado
 * 
 * @param file
 * @returns
 */
function getExt(file) {
	return (/[.]/.exec(file)) ? /[^.]+$/.exec(file.toLowerCase()) : '';
}
