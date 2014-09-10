var mooValidator = new Class({
    Implements: [Options, Events],
    options: {
    	messages:{
    		required: "Este campo es obligatorio.",
    		remote: "Por favor, rellena este campo.",
    		email: "Por favor, escribe una dirección de correo válida",
    		url: "Por favor, escribe una URL válida.",
    		date: "Por favor, escribe una fecha válida.",
    		dateISO: "Por favor, escribe una fecha (ISO) válida.",
    		number: "Por favor, escribe un número entero válido.",
    		digits: "Por favor, escribe sólo dígitos.",
    		creditcard: "Por favor, escribe un número de tarjeta válido.",
    		equalTo: "Por favor, escribe el mismo valor de nuevo.",
    		accept: "Por favor, escribe un valor con una extensión aceptada.",
    		maxlength: "Por favor, no escribas más de {0} caracteres.",
    		minlength: "Por favor, no escribas menos de {0} caracteres.",
    		rangelength: "Por favor, escribe un valor entre {0} y {1} caracteres.",
    		range: "Por favor, escribe un valor entre {0} y {1}.",
    		max: "Por favor, escribe un valor menor o igual a {0}.",
    		min: "Por favor, escribe un valor mayor o igual a {0}."
    	},
		valid:{},
		errorClass:'text-error',
		elementErrorClass:'text-error',
		errorElement:"div",
		containerElement:"div",
		btnajax:'',
		evaluateOnSubmit:true,
		errorPlacement:false,
        onValid:function(){},
        onComplete:function(){}
    },

    initialize: function (form, options) {
		if(form){

			this.setOptions(options);
			var elements = this.options.valid;
			this.form = form;
			this.bValue = false;
			this.ElementText = [];
			this.ElementbValue = [];
			this.messages = {};
			Object.each(elements,function(value,key){
				this.addElements(key,value);
			},this);
			
			if(this.options.btnajax === ''){
				this.form.addEvent('submit', this.onSubmit.bind(this));
			}else{
				this.btn = this.options.btnajax;
				this.btn.addEvent('click', this.onSubmit.bind(this));
				this.form.addEvent('submit', function(e){e.stop();});
			}
			

		}
    },

	addElements:function(elementId,value){
		var element, type;

		element = $(elementId);
		type = element.get("type") || element.get("tag") ;
		this.setErrorText(elementId); 
		
		switch(type){
			case "text":

				this.ElementText.push(element);

				if (value["isnumeric"] === true || value["isdecimal"] === true ) {
					element.addEvent("keypress",function(e){
						key = e.code
						if(value["isdecimal"] === true){
							return(key <= 13 || (key >= 48 && key <= 57) || key == 46)
						}else{
							return (key <= 13 || (key >= 48 && key <= 57));
						}
					});
				}

				element.addEvent("blur",function(){
					for (var key in value){
						if (key === "isnumeric" || key === "isdecimal" ) continue;
						bValue = this.eventBlur(key,element, element.value, value[key])
							if(!bValue){
								element.addClass(this.options.elementErrorClass);
								message = this.getErrorText(elementId,key);
								this.addError(message,element);
								this.ElementbValue[elementId + key] = false;
								break;
							}else{
								element.removeClass(this.options.elementErrorClass);
								this.ElementbValue[elementId + key] = true;
							}
					}
					if(bValue) this.removeError(elementId);
				}.bind(this));
				break;
			case "select":
			break;
		}

	},

	eventBlur : function(key, element,value, param){
		return this.methods[key].call(this,value,element,param);
	},

	getErrorText:function(elementId,key){
		message = this.messages[elementId][key] || "mensaje no definido";
		return message;
	},
	
	setErrorText:function(elementId){
		var messages;
		messages = this.options.messages;
		this.messages[elementId] = messages[elementId];
	},
	
	
	addMethod:function( name, method, message ){
		this.methods[name] = method;
		if(message !== undefined)this.messages[name] =  message;
	},
	
	removeError:function(elementId){
		containerError = this.findErrorElement(elementId);
		if(containerError) containerError.setStyle("display","none");
	},

	addError:function(error, element){
		var options, container, containerError, elementId;

			options = this.options;
			container = element.getParent(options.containerElement);
			elementId = element.get("id");
			containerError = (!options.errorPlacement) ?container.getElement(options.errorElement +'.' + options.errorClass) || false : this.findErrorElement(elementId);

			if(options.errorPlacement){
				elementError = (!containerError)?this.addErrorElement(elementId):containerError;
				elementError.setStyle("display","block");
				options.errorPlacement.call(this,element, error, elementError);
				return;
			}

			if(!containerError){
				containerError = this.addErrorElement(elementId);
				containerError.set('html',error).inject(container);
			}else{
				containerError.set('html',error);
				containerError.setStyle("display","block");
			}
	},

	addErrorElement:function(elementId){
		var options, message;
			options = this.options;
			message = new Element(options.errorElement,{'class':options.errorClass,'data-element':elementId});
			return message;
	},

	findErrorElement:function(elementId){
		var options;
		options = this.options;
		return this.form.getElement(options.errorElement+"[data-element="+elementId+"]") || false;
	},
	
	methods: {
		required: function( value, element, param ) {
			return value.trim().length > 0;
		},

		email: function( value, element ) {
			return this.regexp.email.test(value);
		},

		url: function( value, element ) {
			return this.regexp.url.test(value);
		},

		date: function( value, element ) {
			return !/Invalid|NaN/.test(new Date(value).toString());
		},

		dateISO: function( value, element ) {
			return this.regexp.date.test(value);
		},

		
		digit: function( value, element ) {
			return this.regexp.digit.test(value);
		},
		
		nodigit: function( value, element ) {
			return this.regexp.nodigit.test(value);
		},
		
		number: function( value, element ) {
			return this.regexp.number.test(value);
		},
		
		decimal:function( value, element ) {
			var decimal, istest;
			decimal = (value.match(/^\d+(?:\.\d+)?$/));
			istest = value.indexOf('.');
			return (decimal && istest > 0);
		},

		digits: function( value, element ) {
			return  /^[0-9]+$/.test(value);
		},
		
		minlength:function(value, element,param){
			var length = value.length;
			return  length >= param;
		},
		
		maxlength:function(value, element,param){
			var length = value.length;
			return  length <= param;
		},

		min: function( value, element, param ) {
			return  value >= param;
		},

		max: function( value, element, param ) {
			return value <= param;
		}
	},

	/**/

	regexp : {
		required : /[^.*]/,
		alphabetic : /^[a-zA-Z \-\'\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da\u00f1\u00d1\u00FC\u00DC]+$/,
		alphanum : /^[a-zA-Z0-9 \.\_\-\'\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da\u00f1\u00d1\u00FC\u00DC]+$/i,
		digit : /^[-+]?[0-9]+$/,
		nodigit : /^[^0-9]+$/,
		number : /^-?(?:\d+|\d{1,3}(?:,\d{3})+)?(?:\.\d+)?$/,//^[-+]?\d*\.?\d+$/,
		decimal : /^\d+(?:\.\d+)?$/,
		email : /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/,
		image : /.(jpg|jpeg|png|gif|bmp)$/i,
		mobil: /^9+([0-9]{8})/,
		ruc: /(^1|2)+([0-9]{10})/,
		date : /^(([0-2]?\d)|(3[0-1]))\/((1[0-2])|(0?\d))\/(\d{4})/, //^\d{4}[\/\-]\d{1,2}[\/\-]\d{1,2}$/
		url : /^(http|https|ftp)\:\/\/[a-z0-9\-\.]+\.[a-z]{2,3}(:[a-z0-9]*)?\/?([a-z0-9\-\._\?\,\'\/\\\+&amp;%\$#\=~])*$/i
	},

	onSubmit:function(event){

		var bValue;

		for(i = 0 , len = this.ElementText.length; i < len ; i++){
			this.ElementText[i].fireEvent("blur");

		}

		bValue = Object.every(this.ElementbValue, function(value, key){
    		return value;
		});

		if(bValue) this.fireEvent("onValid");

		return bValue;

	}




});
