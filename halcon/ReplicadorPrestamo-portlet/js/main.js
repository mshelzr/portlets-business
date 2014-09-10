var app;
app = {};

app.cargarMoneda = function() {
getdata3(
	"/ReplicadorPrestamo-portlet/js/json/tip_moneda_replicador.json",
	"cmbTipoMonedaHidden", "cmbTipoMoneda",'');
};

app.cargarTipoCuotaHipotecaria = function() {
getdata3(
	"/ReplicadorPrestamo-portlet/js/json/tip_cuota_hipotecario.json",
	"cmbTipoCuotaHidden", "cmbTipoCuota",'');
};

app.tooltip = function(){
		$$(".ayuda-sign").addEvents({
			'click' : function(){
				element = this.getElement('div.tool-open');
				if(element){
					element.setStyle('display','block');
				}
			},
			'mouseleave': function(){
				element = this.getElement('div.tool-open');
				if(element){
					element.setStyle('display','none');
				}
			}
		});
	};
	
	if($('fechaDes')){
		var picker = new SlimPicker($('fechaDes'),{
			onChangeDate:function(){
				var fecha, 
					actual, 
					actualvalue,
					fechaActual,
					contentError;
			
			fechaActual = $('fechaActual').value;
			fecha = $('fechaDes').value.split('/');
			actual = new Date(fecha[1]+"/"+fecha[0]+"/"+fecha[2]).getTime();
			actualvalue = new Date(fechaActual).getTime();	
			contentError = $('fechaDes').getParent("div.campos-oblig").getNext("div.form-error");
				if( parseInt(actual) <= parseInt(actualvalue)){
					$('fechaDes').removeClass('text-error');
					contentError.set('html','');
				}else{
					$('fechaDes').addClass('text-error');
					contentError.set({'html':oMessages.fechaDes.fechamayor,'styles':{'display':'block'}});
				}
		}
	});
	}

	creHipo = {
		'numCredito':{required:true, isnumeric:true, min:1, minlength:1,maxlength:8},
		'valorBien':{required:true, isdecimal:true, min:0,monto:'5000000.00'},
		'montoFinanciar':{required:true, isdecimal:true, min:0, monto:"2500000.00", montofin:{monto:"2500000.00","element":$("valorBien")}},
		'tasaInteres':{required:true, isdecimal:true, decimallength: '50.00', min:0, tea:"50.00"},
		'plazoMeses':{required:true, isnumeric:true, min:12, max:360},
		'periodoGracia':{required:true, isnumeric:true, min:0, max:12},
		'seguroDesg':{required:true, isdecimal:true, decimallength: '0.9999', decimalmax:'0.9999'},
		'porcSeguro':{required:true, isdecimal:true, decimallength: '0.9999', decimalmax:'0.9999'},
		'montoSeguro':{required:true, isdecimal:true, monto:'2000000.00'},
		'fechaDes':{daterep:true,fechamayor:true},
		'diaVencim':{required:true ,isnumeric:true,min:1,max:31},
		'ingresacodigo':{requiredcaptcha:true}
	};

	crePersonal = {
		'numCredito':{required:true, isnumeric:true, min:1, minlength:1,maxlength:8},
		'montoFinanciarp':{required:true ,isdecimal:true, montomin:'3000.00', monto:'900000.00'},
		'tasaInteresp':{required:true ,isdecimal:true, decimallength: '50.00', min:10, tea:"50.00"},
		'plazoMesesp':{required:true ,isnumeric:true, min:6, max:60},
		'periodoGraciap':{required:true ,isnumeric:true, min:0, max:24},
		'seguroDesg':{required:true ,isdecimal:true, decimallength: '0.9999', decimalmax:'0.9999'},
		'fechaDes':{daterep:true,fechamayor:true},
		'diaVencim':{required:true ,isnumeric:true,min:1,max:31},
		'ingresacodigo':{requiredcaptcha:true}
	};

	crePersonalHipo = {
		'numCredito':{required:true, isnumeric:true, min:1, minlength:1, maxlength:8},
		'valorBien':{required:true ,isdecimal:true, min:0, monto:'5000000.00'},
		'montoFinanciar':{required:true ,isdecimal:true, min:0, monto:"2500000.00", montofin:{monto:"2500000.00","element":$("valorBien")}},
		'tasaInteres':{required:true ,isdecimal:true, min:0, decimallength: '50.00', tea:"50.00"},
		'plazoMesesph':{required:true ,isnumeric:true, min:12, max:60},
		'periodoGracia':{required:true ,isnumeric:true, min:0, max:12},
		'seguroDesg':{required:true ,isdecimal:true, decimallength: '0.9999', decimalmax:'0.9999'},
		'porcSeguro':{required:true ,isdecimal:true, decimallength: '0.9999', decimalmax:'0.9999'},
		'montoSeguro':{required:true ,isdecimal:true, monto:'2000000.00'},
		'fechaDes':{daterep:true,fechamayor:true},
		'diaVencim':{required:true ,isnumeric:true,min:1,max:31},
		'ingresacodigo':{requiredcaptcha:true}
	};

	creVehicular = {
		'numCredito':{required:true, isnumeric:true, min:1, minlength:1, maxlength:8},
		'valorBienv':{required:true, isdecimal:true, min:0, monto :'1000000.00'},
		'cuotaBalon':{cuota:'rdbcompra',cuotamin:'rdbcompra',cuotamax:'rdbcompra'},
		'montoFinanciarv':{required:true ,isdecimal:true, montomin:'5000.00', monto:"1000000.00", montofin:{monto:"1000000.00","element":$("valorBienv")}},
		'tasaInteresv':{required:true ,isdecimal:true, min:0, decimallength: '20.00', tea:"20.00"},
		'plazoMesesv':{required:true ,isnumeric:true, min:12, max:60},
		'periodoGraciav':{required:true ,isnumeric:true, min:0, max:2},
		'seguroDesgv':{required:true ,isdecimal:true, decimallength: '0.9999', decimalmaxv:'0.9999'},
		'porcSegurov':{required:true ,isdecimal:true, decimallength: '0.9999', decimalmaxv:'10.0000'},
		'montoSegurov':{required:true ,isdecimal:true, monto:'1000000.00'},
		'fechaDes':{daterep:true,fechamayor:true},
		'diaVencim':{required:true ,isnumeric:true,min:1,max:31},
		'ingresacodigo':{requiredcaptcha:true}
	};

oMessages = {
		numCredito :{
			required: "Ingrese el N° de Cr\u00E9dito.",
			number: "Ingrese valores numericos",
			min: "Ingrese un n\u00FAmero de cr\u00E9dito v\u00E1lido.",
			minlength: "La longitud minimo es de 8."
		},
		valorBien:{
			required: "Ingrese el Valor del Bien.",
			min:"El  m\u00EDnimo permitido es 5\u0027000,000.00.",
			monto:"El m\u00E1ximo permitido es 5\u0027000,000.00."
		},
		valorBienv:{
			required: "Ingrese el Valor del Bien.",
			min:"El valor m\u00EDnimo permitido es 0.00.",
			monto:"El m\u00E1ximo permitido es 1\u0027000,000.00."
		},
		montoFinanciar:{
			required: "Ingrese el Monto a financiar.",
			min:"El m\u00EDnimo permitido es 2\u0027500,000.00.",
			monto:"El máximo permitido es 2\u0027500,000.00.",
			montofin:"El monto a financiar debe ser menor o igual al valor del bien."
		},
		montoFinanciarp:{
			required: "Ingrese el Monto a financiar.",
			montomin:"El m\u00EDnimo permitido es 3,000.00.",
			monto:"El  máximo permitido es 900,000.00."
		},
		montoFinanciarv:{
			required: "Ingrese el Monto a financiar.",
			montomin:"El m\u00EDnimo permitido es 5,000.00.",
			monto:"El máximo permitido es 1\u0027000,000.00.",
			montofin:"El monto a financiar debe ser menor o igual al valor del bien."
		},
		tasaInteres:{
			required: "Ingrese la Tasa de inter\u00E9s.",
			decimallength: "La tasa de Inter\u00E9s debe tener 2 decimales.",
			min:"El valor m\u00E1ximo es 50.00.",
			tea:"El valor m\u00E1ximo es 50.00."
		},
		tasaInteresp:{
			required: "Ingrese la Tasa de inter\u00E9s.",
			decimallength: "La tasa de Inter\u00E9s debe tener 2 decimales.",
			min:"El valor m\u00E1ximo es 10.00.",
			tea:"El valor m\u00E1ximo es 50.00."
		},
		tasaInteresv:{
			required: "Ingrese la Tasa de inter\u00E9s.",
			decimallength: "La tasa de Inter\u00E9s debe tener 2 decimales.",
			tea:"El valor m\u00E1ximo es 20.00."
		},
		plazoMeses:{
			required: "Ingrese el Plazo en meses.",
			min:"El m\u00EDnimo permitido es 12.",
			max:"El m\u00E1ximo permitido es 360."
		},
		plazoMesesp:{
			required: "Ingrese el Plazo en meses.",
			min:"El m\u00EDnimo permitido es 6.",
			max:"El m\u00E1ximo permitido es 60."
		},
		plazoMesesv:{
			required: "Ingrese el Plazo en meses.",
			min:"El m\u00EDnimo permitido es 12.",
			max:"El m\u00E1ximo permitido es 60."
		},
		plazoMesesph:{
			required: "Ingrese el Plazo en meses.",
			min:"El valor m\u00EDnimo permitido es 12.",
			max:"El valor m\u00E1ximo permitido es 60."
		},
		periodoGracia:{
			required: "Ingrese el Periodo de Gracia.",
			min: "El m\u00EDnimo permitido es 0.",
			max: "El m\u00E1ximo permitido es 12."
		},
		periodoGraciav:{
			required: "Ingrese el Periodo de Gracia.",
			min: "El m\u00EDnimo permitido es 0.",
			max: "El m\u00E1ximo permitido es 2."
		},
		periodoGraciap:{
			required: "Ingrese el Periodo de Gracia.",
			min: "El m\u00EDnimo permitido es 0.",
			max: "El m\u00E1ximo permitido es 24."
		},
		seguroDesg:{
			required: "Ingrese el % Seguro de desgravamen.",
			decimallength: "El % debe tener 4 decimales.",
			decimalmax:"El valor m\u00E1ximo permitido es 0.9999." 
		},
		seguroDesgv:{
			required: "Ingrese el % Seguro de desgravamen.",
			decimallength: "El % debe tener 4 decimales.",
			decimalmaxv:"El valor m\u00E1ximo permitido es 0.9999." 
		},
		porcSeguro:{
			required: "Ingrese el %.",
			decimallength: "El % debe tener 4 decimales.",
			decimalmax:"El m\u00E1ximo permitido para el % es 0.9999."
		},
		porcSegurov:{
			required: "Ingrese el %.",
			decimallength: "El % debe tener 4 decimales.",
			decimalmaxv: "El m\u00E1ximo permitido para % es 10.0000"
		},
		montoSeguro:{
			required:"Ingrese el Monto.",
			min:"El m\u00E1ximo permitido para el monto es 2\u0027000,000.00.",
			monto:"El m\u00E1ximo permitido para el monto es 2\u0027000,000.00."
		},
		montoSegurov:{
			required:"Ingrese el Monto.",
			monto:"El m\u00E1ximo permitido para el monto es 1\u0027000,000.00."
		},
		fechaDes:{
			daterep: "Ingrese la Fecha de desembolso.",
			fechamayor:"La fecha de desembolso no debe ser mayor a la fecha actual."
		},
		diaVencim:{
			required: "Ingrese el D\u00EDa de Vencimiento.",
			min: "El m\u00EDnimo permitido es 1.",
			max: "El m\u00E1ximo permitido es 31."
		},
		cuotaBalon:{
			cuota:"Ingrese el % Cuota Balón.",
			cuotamin:"El m\u00EDnimo permitido es 40.",
			cuotamax:"El m\u00E1ximo permitido es 50."
		},
		ingresacodigo:{
			requiredcaptcha: "C\u00F3digo de validaci\u00F3n incorrecto,int\u00E9ntalo nuevamente."
		}
};

app.chk = function(){
	
	var clearError = function(element){
		if(element.hasClass('text-error')){
			element.removeClass('text-error');
			contentError = element.getParent("div.campos-oblig").getNext("div.form-error");
			contentError.set('html','');
		}
	};
	
	$$('.opCh').addEvent('click',function(){
		var thist;
		thist = this;
		if(thist.get('checked')){
			if(thist.get('id') === 'chkdesvagramen'){
				element = $('seguroDesg') || $('seguroDesgv');
				clearError(element);
				element.set({'value':'0.0000','readonly':'readonly',styles:{'background':'#eeeeee'}});
			}else if(thist.get('id') === 'chkmonto'){
				
				montoSeguro=$('montoSeguro') || $('montoSegurov');
				porcSeguro = $('porcSeguro') || $('porcSegurov');
				
				clearError(porcSeguro);
				clearError(montoSeguro);
				
				porcSeguro.set({'value':'0.0000','readonly':'readonly',styles:{'background':'#eeeeee'}});
				montoSeguro.set({'value':'0.00','readonly':'readonly',styles:{'background':'#eeeeee'}});
			}
		}else{
			if(thist.get('id') === 'chkdesvagramen'){
				element = $('seguroDesg') || $('seguroDesgv');
				clearError(element);
				element.set('value','').removeProperties('readonly','style');
			}else if(thist.get('id') === 'chkmonto'){
				montoSeguro=$('montoSeguro') || $('montoSegurov');
				porcSeguro = $('porcSeguro') || $('porcSegurov');
				
				clearError(porcSeguro);
				clearError(montoSeguro);
				
				porcSeguro.set('value','').removeProperties('readonly','style');
				montoSeguro.set('value','').removeProperties('readonly','style');
			}
		}
	});
	
	$$(".buy").addEvent('click',function(){
		var thist,
			error,
			cuotaBalon,
			element;
		
		thist = this;
		element = $("cbalon");
		error = $('errorCuotaBalon');
		cuotaBalon = $('cuotaBalon');
		
		if(thist.value == 1){
			element.setStyle('display','block');
		}else if(thist.value == 0){
			error.set('html','');
			error.removeProperty('style');
			cuotaBalon.removeClass('text-error');
			element.setStyle('display','none');
		}
	});
	
};

app.valid = function(){
	var key;
	key = $("frmtipo").value;
	switch(key){
		case 'hipotecario':
			elements = creHipo;
			break;
		case 'personal':
			elements = crePersonal;
			break;
		case 'personalhipotecario':
			elements = crePersonalHipo;
			break;
		case 'vehicular':
			elements = creVehicular;
			break;
	}

	var validator;
	validator = new mooValidator($('frmdata'),{
		'valid':elements,
		'messages':oMessages,
		'btnajax':$('enviarDatos'),
		errorPlacement: function(element, error, elementError) {
			var elementId,
				content,
				contentError;
			elementId = element.get("id");
			content = element.getParent('div.campos-oblig') || element.getParent('div.soli-codigo');
			contentError = content.getNext("div.form-error");
			contentError.set({'html':error,'data-element':elementId,'styles':{"display":"block"}});
			if(element.hasClass('datepiker')){
				element.setStyle('background-color','#fce5f1');
			}

		}
, 
		onValid: function(){
			app.replicar();
		}
	});

	validator.addMethod("decimalmax", function(value, element,params) {
		var number,
			decimal,
			bDecimal;
			number = value.split('.');
			decimal = params.split('.');
			bDecimal = validator.methods.decimal.call(validator, value, element);
			return (bDecimal) && (params == value || (decimal[0] == number[0] && decimal[1].length == number[1].length));
     });
	
	validator.addMethod("decimallength", function(value, element,params) {
		var number,
			decimal,
			bDecimal;
			number = value.split('.');
			decimal = params.split('.');
			bDecimal = validator.methods.decimal.call(validator, value, element);
			return (bDecimal) && decimal[1].length == number[1].length;
     });
	
	validator.addMethod("decimalmaxv", function(value, element,params) {
		var decimal,
			bDecimal;
			decimal = params.split('.');
			number = value.split('.');		
			bDecimal = validator.methods.decimal.call(validator, value, element);
			return (bDecimal) &&  (parseFloat(value) <= parseFloat(params)) && (decimal[1].length <= 4);
     });
	
	validator.addMethod("decimalvlength", function(value, element,params) {
		var decimal,
			bDecimal;
			decimal = params.split('.');	
			bDecimal = validator.methods.decimal.call(validator, value, element);
			return (bDecimal)  && (decimal[1].length <= 4);
     });
	 	
	 validator.addMethod("tea", function(value, element,params) {
		var bDecimal;
		bDecimal = validator.methods.decimal.call(validator, value, element);
		return bDecimal && (parseFloat(value)  <= parseFloat(params));
     });
	 
	 validator.addMethod("monto", function(value, element,params) {
		var bNumber,
			bDecimal;
		bDecimal = validator.methods.decimal.call(validator, value, element);
		bNumber = validator.methods.digits.call(validator, value, element);
		if(bNumber ){
			return (parseInt(value) <= parseInt(params) || value=="0");
		}else if(bDecimal){
			return parseFloat(value) <= parseFloat(params);
		}
   		return false;
     });
	 
	 validator.addMethod("montomin", function(value, element,params) {
			var bNumber,
				bDecimal;
			bDecimal = validator.methods.decimal.call(validator, value, element);
			bNumber = validator.methods.digits.call(validator, value, element);
			if(bNumber){
				return (parseInt(value) >= parseInt(params));
			}else if(bDecimal){
				return parseFloat(value) >= parseFloat(params);
			}
	   		return false;
	 });
	 
	validator.addMethod("montofin", function(value, element,params) {		
		var bDecimal,
			bNumber,
			monto,
			lmnt,
			valorInt,
			valorFloat;

		bDecimal = validator.methods.decimal.call(validator, value, element);
		bNumber = validator.methods.digits.call(validator, value, element);
		monto = params.monto;
		lmnt = params.element;
		valorInt = parseInt(value);
		valorFloat = parseFloat(value);
		
		if(bNumber){				
			return (valorInt <= parseInt(monto) || value=="0") && (valorInt <= parseFloat(lmnt.value));
		}else if(bDecimal){
			return (valorFloat <= parseInt(monto)) && (valorFloat <= parseFloat(lmnt.value));
		}
		return false;
    });
	
	validator.addMethod("daterep", function(value, element,params) {
		if(value !== 'dd/mm/aaaa'){
			return validator.methods.dateISO.call(validator, value, element);
		}
		return false;
	});
	
	validator.addMethod("cuota", function(value, element,params) {
		var val;
		val = $$('input[name='+ params +']:checked').get('value');
		if(val == 0){
			element.set('value','');
			return true;
		}else{
			return (/[^.*]/.test(value));
		}
	});

	validator.addMethod("cuotamin", function(value, element,params) {
		var val;
		val = $$('input[name='+ params +']:checked').get('value');
		if(val == 0){
			element.set('value','');
			return true;
		}else{
			if( value < 40 ){
				return false;
			}else{
				return true;
			}
		}
	});

	validator.addMethod("cuotamax", function(value, element,params) {
		var val;
		val = $$('input[name='+ params +']:checked').get('value');
			if(val == 0){
				element.set('value','');
				return true;
			}else{
				if( value > 50 ){
					return false;
				}else{
					return true;
				}
			}
	});
	
	validator.addMethod("requiredcaptcha", function(value, element,params) {
		var vplaceholder;
		vplaceholder = element.get('placeholder');
		return validator.methods.required.call(validator, value, element) &&  value !== vplaceholder;
     });


	validator.addMethod("fechamayor", function(value, element,params) {
		var fecha, 
		actual, 
		actualvalue, 
		fechaActual;
	
		fechaActual = $('fechaActual').value;
		fecha = value.split('/');	
		actual = new Date(fecha[1]+"/"+fecha[0]+"/"+fecha[2]).getTime();
		actualvalue = new Date(fechaActual).getTime();
	
		return (actual <= actualvalue);
		
     });
};


app.clear = function(){	
	$('btnclear').addEvent('click',function(){
		var frm,
			elements,
			content,
			contentError,
			cbalon;
		
		frm = $('frmdata');
		cbalon = $('cbalon');
		elements = frm.getElements('input.textform');
		elements.each(function(element){
			var elementId = element.get('id');
			if( elementId === 'seguroDesg' || elementId === 'porcSeguro' || elementId === 'montoSeguro'){
				element.set('value','').removeProperties('readonly','style');
			}
			element.removeClass('text-error');
			content = element.getParent('div.campos-oblig') || element.getParent('div.soli-codigo'); 
			contentError = content.getNext("div.form-error");
			contentError.set({'html':'','styles':{'display':'none'}});
			
		});
		frm.reset();
		app.cargarMoneda();
		app.cargarTipoCuotaHipotecaria();
		if(cbalon)cbalon.setStyle('display','none');
	});
};

app.replicar = function(){
			var montoFinanciar ='0';
			var periodoGracia = '0';
			var plazoMeses = '0';
			var valorBien = '0';
			var seguroDesg = '0';
			var cuotaBalon = 0;
			var tasaInteres = 0;
			
			var grupoReplicador = $('tipoReplicador').value;
			var numCredito = $('numCredito').value;
			var moneda = $('cmbTipoMonedaHidden').value;
			var cmbTipoCuotaHidden = $('cmbTipoCuotaHidden').value;
			var fechaDes = $('fechaDes').value;
			var diaVencim = $('diaVencim').value;
			var ingresacodigo = $('ingresacodigo').value;
			var surl = $('urlForm');
			
			if(grupoReplicador == '3'){
				montoFinanciar = $('montoFinanciarp').value;
				periodoGracia = $('periodoGraciap').value;
				tasaInteres = $('tasaInteresp').value;
			} else if(grupoReplicador == '4'){
				montoFinanciar = $('montoFinanciarv').value;
				periodoGracia = $('periodoGraciav').value;
				tasaInteres = $('tasaInteresv').value;
			} else {
				montoFinanciar = $('montoFinanciar').value;
				periodoGracia = $('periodoGracia').value;
				tasaInteres = $('tasaInteres').value;
			}
			
			if(grupoReplicador == '2'){
				plazoMeses = $('plazoMesesph').get("value");
			} else if(grupoReplicador == '4'){
				plazoMeses = $('plazoMesesv').get("value");
			} else if(grupoReplicador == '3'){
				plazoMeses = $('plazoMesesp').get("value");
			} else {
				plazoMeses = $('plazoMeses').get("value");
			}
			var inteligente = 0;
			var envioFisico = 0;
			if(grupoReplicador == '4'){
				valorBien = $('valorBienv').get("value");
				seguroDesg = $('seguroDesgv').value;
				inteligente = $$('input[name=rdbcompra]:checked').get('value');
				envioFisico = $$('input[name=rdbsend2]:checked').get('value');
				envioFisico = envioFisico[0];
			} else if(grupoReplicador == '1' || grupoReplicador == '2'){
				valorBien = $('valorBien').get("value");
				seguroDesg = $('seguroDesg').value;
			} else {
				seguroDesg = $('seguroDesg').value;
				envioFisico = $$('input[name=rdbsend]:checked').get('value');
				envioFisico = envioFisico[0];
			}
			
			var porcSeguro = 0;
			if(porcSeguro!=null){
				if(grupoReplicador == '4'){
					porcSeguro = $('porcSegurov');
					porcSeguro = porcSeguro.get("value");
				} else if(grupoReplicador == '1' || grupoReplicador == '2') {
					porcSeguro = $('porcSeguro');
					porcSeguro = porcSeguro.get("value");
				}
				
			} else {
				porcSeguro = 0;
			}
			var montoSeguro = $('montoSeguro');

			if(montoSeguro!=null){
				montoSeguro = montoSeguro.get("value");
			} else {
				montoSeguro = 0;
			}
			
			cuotaBalon = $('cuotaBalon');
			if(cuotaBalon!=null){
				cuotaBalon = cuotaBalon.get("value");
			} else {
				cuotaBalon = 0;
			}

			loadform();
			
			var json = new Request.JSON({
				method : 'post',
				url : surl.get("value"),
				data : {
					tipoReplicador:grupoReplicador,
					numCredito:numCredito,
					moneda:moneda, 
					valorBien:valorBien,
					montoFinanciar:montoFinanciar,
					tasaInteres:tasaInteres,
					cmbTipoCuotaHidden:cmbTipoCuotaHidden,
					plazoMeses:plazoMeses,
					periodoGracia:periodoGracia,
					seguroDesg:seguroDesg,
					porcSeguro:porcSeguro,
					montoSeguro:montoSeguro,
					fechaDes:fechaDes,
					diaVencim:diaVencim,
					ingresacodigo:ingresacodigo,
					envioInforme: envioFisico,
					inteligente: inteligente,
					cuotaBalon: cuotaBalon
					},
				onComplete : function(data) {
					closeloadform();
					actualizarImagen();
					if(data.result=='error'){
						if(data.strErrors == 'datosIncorrectos'){
							datosIncorrectos(data.urlNuevaSim);
						} else if(data.strErrors == 'ingresaCaptcha'){
							$('errorCaptcha').set({'html': 'Código de validación incorrecto,inténtalo nuevamente.','styles':{ 'display': 'block'}});
							$('ingresacodigo').addClass('text-error');
						} else {
							mostrarMensajeErrorWs();
						}
						
					} else {
						mostrarCronograma(data, numCredito, diaVencim, fechaDes, grupoReplicador, envioFisico, inteligente, cuotaBalon);
					}
				},
				onFailure:function(error){
					
				}
			});
			json.send();	

};


app.init = function(){
	app.cargarTipoCuotaHipotecaria();
	app.cargarMoneda();
	app.valid();
	app.tooltip();
	app.chk();
	app.clear();
};

window.addEvent("domready",app.init);


function actualizarImagen(){
	var d = new Date();
	var milliseconds=d.getTime();
	$('imgCaptcha').src= $("urlImagenCajaSorpresa").value+'&RAMDOM='+ milliseconds;
};

function mostrarMensajeErrorWs(){
	$('contentfrm').setStyle('display','none');
	var htmlContenido ='<div class="sol-formulario paso4 sol-formulario paso4 replicador-contenedor replicador-resError"><div class="resul-titulo con-decoration sin-padding"> <em class="error"></em><h3>TENEMOS UN INCONVENIENTE</h3>' 
		+ 'Por favor, int\u00E9ntalo nuevamente en unos momentos.<br>Gracias. </div><div class="both"></div></div>';
	$('divresultado').set('html', htmlContenido);
}

function datosIncorrectos(nuevaSim){
	$('contentfrm').setStyle('display','none');
	var htmlContenido ='<div class="sol-formulario paso4 sol-formulario paso4 replicador-contenedor replicador-resError"><div class="resul-titulo con-decoration sin-padding"> <em class="error"></em>'
		+ '<h3>Los datos ingresados no son v\u00E1lidos</h3><div class="next-sol con-decoration"> <a title="Vuelva a Intentar" href="'+ nuevaSim +'">Vuelva a Intentar</a></div><br>'
		+ 'Gracias. </div><div class="both"></div></div>';
	$('divresultado').set('html', htmlContenido);
}

function mostrarCronograma(data, ncredito, diaVenc, fechaDesembolso, grupoReplicador, envioFisico, inteligente, cuotaBalon){
	
	$('contentfrm').setStyle('display','none');
	var credito = data.credito;
	var cuotas = data.cuotas;
	var cabecera = data.cabecera;

	var htmlCabecera ='<div class="DSP-cont"><div id="content-lbox-I"><h3>Replicador Cronograma de Pagos Inicial - ';
	
	if(grupoReplicador == '1'){
		htmlCabecera+='Cr\u00E9dito Hipotecario';
	} else if(grupoReplicador == '2'){
		htmlCabecera+='Pr\u00E9stamo Personal con Garant\u00EDa Hipotecaria';
	} else if(grupoReplicador == '3'){
		htmlCabecera+='Pr\u00E9stamo Personal ';
	} else {
		htmlCabecera+='Cr\u00E9dito Vehicular ';
	}
	
	htmlCabecera+= '</h3></div><div class="ca-descarga-txt"> <span id="descargarRepPDF2" class="ca-descarga">'
		+ '<a  href="'+ data.urlPDF +'"><span class="ca-descarga-icon" style="_width:40px !important;"></span></a><span><a href="'+data.urlPDF+'">Descargar<br>' 
		+ ' en PDF</a></span></span> </div><div class="both"></div></div> ';
	htmlCabecera += '<div class="DSP-cont-I"><div class="dsp-txt">';
	if(grupoReplicador == '4'){
		htmlCabecera += '<div style="border-bottom:1px solid #cccccc"> <span class="dsp-txt-det no-bd">\u00BFEs compra inteligente?</span> <span class="dsp-txt-det-II no-bd">';
			if(inteligente=='1'){
				htmlCabecera += 'S\u00ED ';
			} else {
				htmlCabecera += 'No ';
			}
		htmlCabecera += '</span><div class="both"></div></div>';
	}
  	htmlCabecera += '<div style="border-bottom:1px solid #cccccc">'
		+ '<span class="dsp-txt-det no-bd">N\u00B0 de Cr\u00E9dito</span> <span class="dsp-txt-det-II no-bd"> '+ ncredito +' </span>'
		+ '<div class="both"></div></div><div style="border-bottom:1px solid #cccccc">' 
		+'<span class="dsp-txt-det no-bd">Moneda  </span> <span class="dsp-txt-det-II no-bd"> ' + credito.moneda + '</span>'
		+ '<div class="both"></div></div>';
		if(grupoReplicador != '3'){
			htmlCabecera +='<div style="border-bottom:1px solid #cccccc">'
			+ '<span class="dsp-txt-det no-bd">Valor del Bien</span> <span class="dsp-txt-det-II no-bd">' + formato_numero(credito.montoValorBien, 2) + '</span>'
			+ '<div class="both"></div></div>';
		}
		if(grupoReplicador == '4' && inteligente == '1'){
			htmlCabecera +='<div style="border-bottom:1px solid #cccccc">'
			+ '<span class="dsp-txt-det no-bd">Tasa cuota Bal\u00F3n </span> <span class="dsp-txt-det-II no-bd">' + cuotaBalon + '%</span>'
			+ '<div class="both"></div></div>';
		}
		
		htmlCabecera += '<div style="border-bottom:1px solid #cccccc">'
		+ '<span class="dsp-txt-det no-bd">Monto a Financiar </span> <span class="dsp-txt-det-II no-bd">' + formato_numero(credito.montoFinanciar, 2) + '</span>'
		+ '<div class="both"></div></div><div style="border-bottom:1px solid #cccccc">'
		+ '<span class="dsp-txt-det no-bd">Tasa de Inter\u00E9s (TEA) </span> <span class="dsp-txt-det-II no-bd">' + formato_numero(credito.tasaInteres, 2) + '% </span>'
		+ '<div class="both"></div></div><div style="border-bottom:1px solid #cccccc">'
		+ '<span class="dsp-txt-det no-bd"> TCEA  (Tasa de Costo Efectivo Anual)</span> <span class="dsp-txt-det-II no-bd">' + formato_numero(credito.tasaCostoEfectivo, 2) + '% anual</span>'
		+ '<div class="both"></div></div><div style="border-bottom:1px solid #cccccc">'
		+ '<span class="dsp-txt-det no-bd">Tipo de Cuota </span> <span class="dsp-txt-det-II no-bd">' + credito.tipoCuota + ' </span>'
		+ '<div class="both"></div></div><div style="border-bottom:1px solid #cccccc">'
		+ '<span class="dsp-txt-det no-bd">Plazo en Meses</span> <span class="dsp-txt-det-II no-bd"> ' + credito.plazo + ' meses</span>'
		+ '<div class="both"></div></div><div style="border-bottom:1px solid #cccccc">'
		+ '<span class="dsp-txt-det no-bd">Per\u00EDodo de gracia </span> <span class="dsp-txt-det-II no-bd"> ' + credito.plazoGracia + ' meses</span>'
		+ '<div class="both"></div></div><div style="border-bottom:1px solid #cccccc">'
		+ '<span class="dsp-txt-det no-bd">Tasa de Seguro de Desgravamen </span> <span class="dsp-txt-det-II no-bd"> ' + parseFloat(credito.tasaSeguroDesgravamen).toFixed(4) + '% </span>'
		+ '<div class="both"></div></div>';
		if(grupoReplicador != '3'){
			htmlCabecera += '<div style="border-bottom:1px solid #cccccc">'
				+ '<span class="dsp-txt-det no-bd cntsinln">Tasa y Monto Seguro del Bien</span> <span class="dsp-txt-det-II no-bd"> ' + parseFloat(credito.tasaSeguroBien).toFixed(4) + '%  / S/.' + formato_numero(credito.montoValorBien, 2) + '</span>'
				+ '<div class="both"></div></div>';
		}
		
		htmlCabecera += '<div style="border-bottom:1px solid #cccccc">'
		+ '<span class="dsp-txt-det no-bd">Fecha de Desembolso </span> <span class="dsp-txt-det-II no-bd"> ' + fechaDesembolso + ' </span>'
		+ '<div class="both"></div></div><div style="border-bottom:1px solid #cccccc">'
		+ '<span class="dsp-txt-det no-bd">D\u00EDa de Vencimiento</span> <span class="dsp-txt-det-II no-bd">' + diaVenc + ' </span>'
		+ '<div class="both"></div></div>';
		
		if(grupoReplicador == '3' || grupoReplicador == '4'){
			htmlCabecera += '<div style="border-bottom:1px solid #cccccc"> <span class="dsp-txt-det no-bd">Env\u00EDo F\u00EDsico por Informe de Pago</span> <span class="dsp-txt-det-II no-bd">';
					if(envioFisico=='1'){
						htmlCabecera += 'S\u00ED ';
					} else {
						htmlCabecera += 'No ';
					}
			htmlCabecera += '</span><div class="both"></div></div>';
		}
		htmlCabecera += '<div><input type="hidden" id="exportarPDF"></div>';
		htmlCabecera += '</div><div class="both"></div></div>';

	var htmlCronograma = ' <div class="CH-CRO"><div class="CH-CRO-tablas">'
		+ '<div class="CH-cabeceras"> <span class="cuota">Nro Cuota</span> <span class="vencimiento">F. Vencimiento</span> <span class="s-inicial">Saldo inicial</span> <span class=" amortizacion">Amortizaci\u00F3n</span> <span class="interes">Inter\u00E9s</span> <span class="s-desgra">Seguro<br>'
		+ 'Desgravamen</span> <span class="s-bien">Seguro Bien</span> <span class="comision">Comisi\u00F3n</span> <span class="m-cuota">Monto de Cuota</span> </div>';
		
	
	//var miles=new RegExp("(-?[0-9]+)([0-9]{3})");
//    while(miles.test(numero)) {
//        numero=numero.replace(miles, "$1" + separador_miles + "$2");
//    }
	
		var variab = 0;
		cuotas.each(function(v) {
			variab += 1;
			if(variab%2 == 1){
				htmlCronograma += '<div class="CH-simple"><span class="cuota">' + v.nroCuota + '</span><span class="vencimiento">' + v.fechaVencimiento + '</span>'
							+ '<span class="s-inicial">' + formato_numero(v.saldoDeuda, 2) + '</span><span class="amortizacion">' + formato_numero(v.amortizacion, 2) + '</span>'
							+ '<span class="interes">' + formato_numero(v.interes, 2) + '</span><span class="s-desgra">' + formato_numero(v.seguroDesgravamen, 2) + '</span>'
							+ '<span class="s-bien">' + formato_numero(v.seguroBien, 2) + '</span><span class="comision">' + formato_numero(v.comision, 2) + '</span>'
							+ '<span class="m-cuota">' + formato_numero(v.cuota, 2) + '</span><div class="both"></div></div>';
			} else {
				htmlCronograma += '<div class="CH-destacados"><span class="cuota">'+ v.nroCuota +'</span><span class="vencimiento">' + v.fechaVencimiento+ '</span>'
							+'<span class="s-inicial">' + formato_numero(v.saldoDeuda, 2) + '</span><span class="amortizacion">' + formato_numero(v.amortizacion, 2) + '</span>'
							+ '<span class="interes">' + formato_numero(v.interes, 2) + '</span><span class="s-desgra">' + formato_numero(v.seguroDesgravamen, 2) + '</span>'
							+ '<span class="s-bien">' + formato_numero(v.seguroBien, 2) + '</span><span class="comision">' + formato_numero(v.comision, 2) + '</span>'
							+ '<span class="m-cuota">' + formato_numero(v.cuota, 2) + '</span><div class="both"></div></div>';
			}
		});
//		
		htmlCronograma += '<div class="both"></div><div class="r-totales ver2"><table width="690" cellspacing="0" cellpadding="0" border="0" style="font-size:12px; color:#3e3e3f;">'
		+ '<tbody><tr><td width="241">Totales</td><td width="86" style="font-weight:bold">'+ formato_numero(cabecera.amortizacion, 2) +'</td><td width="83" style="font-weight:bold">'+ formato_numero(cabecera.interes, 2) +' </td>'
		+ '<td width="86" style="font-weight:bold">'+ formato_numero(cabecera.seguroDesgravamen, 2) +'</td><td width="63" style="font-weight:bold">'+ formato_numero(cabecera.seguroBien, 2) +'</td><td width="61" style="font-weight:bold">'+ formato_numero(cabecera.comision, 2) +'</td>'
		+ '<td width="70" style="font-weight:bold">'+ formato_numero(cabecera.cuota, 2) +'</td></tr></tbody></table></div><div class="both"></div>'
		+ '<p>Los datos emitidos son referenciales y han sido generados  en base a la informaci\u00F3n proporcionada por el cliente; est\u00E1n sujetos  a las condiciones otorgadas al momento del desembolso del cr\u00E9dito, incluyendo la fecha del desembolso. No se incluyen los gastos pagados  al contado  directamente por el  cliente. El monto de las cuotas no incluye ITF.   </p>'
		+ '<div class="next-sol con-decoration"> <a title="Nueva Simulaci\u00F3n" href="'+ data.urlNuevaSim +'">Nueva Simulaci\u00F3n</a>&nbsp;&nbsp;&nbsp;</div>'
		+ '<div class="listadob"><ul>'
		+ '<li style="background: url(/halcon-theme/images/halcon/dot.jpg\") no-repeat scroll left 4px transparent">Los datos emitidos por este simulador son referenciales,'
		+ 'est\u00E1n sujetos a evaluaci\u00F3n y a la fecha real de desembolso del cr\u00E9dito.</li>'
		+ '<li style="background: url(/halcon-theme/images/halcon/dot.jpg\") no-repeat scroll left 4px transparent">No se incluyen los gastos pagados al contado directamente'
		+ 'por el cliente.</li>'
		+ '<li style="background: url(/halcon-theme/images/halcon/dot.jpg\") no-repeat scroll left 4px transparent">El monto de las cuotas no incluye ITF.</li>'
		+ '<li style="background: url(/halcon-theme/images/halcon/dot.jpg\") no-repeat scroll left 4px transparent">El monto de la cuota incluye: el seguro de desgravamen de'
		+ 'Interbank.</li>'
		+ '<li style="background: url(/halcon-theme/images/halcon/dot.jpg\") no-repeat scroll left 4px transparent">El cliente tiene la opci\u00F3n de endosar su p\u00F3liza de'
		+ 'seguros a favor de Interbank.</li>'
		+ '<li style="background: url(/halcon-theme/images/halcon/dot.jpg\") no-repeat scroll left 4px transparent">Para mayor informaci\u00F3n puede acercarse a nuestra red de'
		+ 'Tiendas Interbank a nivel nacional.</li></ul></div></div></div>';
		var htmlFinal = htmlCabecera + htmlCronograma;
	$('divresultado').set('html', htmlFinal);
	
	
////	descargarPDF();
}

function separadosMiles(numeroV){
//	numeroV=parseFloat(numeroV);
	var miles=new RegExp("(-?[0-9]+)([0-9]{3})");
	while(miles.test(numeroV)) {
		numeroV=numeroV.replace(miles, "$1" + ',' + "$2");
	}
}

function formato_numero(numero, decimales){ // v2007-08-06
	var separador_decimal = '.';
    numero=parseFloat(numero);
    if(isNaN(numero)){
        return "";
    }

    if(decimales!==undefined){
        // Redondeamos
        numero=numero.toFixed(decimales);
    }

    // Convertimos el punto en separador_decimal
    numero=numero.toString().replace(".", separador_decimal!==undefined ? separador_decimal : ",");
    var separador_miles = ',';
//    if(separador_miles){
        // A�adimos los separadores de miles
        var miles=new RegExp("(-?[0-9]+)([0-9]{3})");
        while(miles.test(numero)) {
            numero=numero.replace(miles, "$1" + separador_miles + "$2");
        }
//    }

    return numero;
}