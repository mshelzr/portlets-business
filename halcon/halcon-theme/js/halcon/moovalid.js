var moovalid = new Class({
    Implements: [Options, Events],
    options: {
        dniLength: 8,
        dniValue: 1,
        carneLengthMin: 4,
        carneLengthMax: 12,
        carneValue: 2,
        pasaporteLengthMin:5,
        pasaporteLengthMax:12,
        pasaporteValue: 3,
        telefLenghtMax: 15,
        telefLenghtMin: 6,
        optional:0,
        forceOptional:0,
        optionalValue:0,
        valuePiker:$('fecNacimiento'),
        validoff:false,
        onValid:function(){},
        onComplete:function(){},
		btnValid: ''
    },

    initialize: function (form, options) {
        this.setOptions(options);
        this.form = $(form);
        this.errorinform = false;
        this.activeClick = false;
        this.button = this.options.btnValid;
        this.min = 0;
        this.max = 0;
        this.aRange = new Array();
        this.fields = this.form.getElements('*[class^=valid]');
        this.lineError = 0;
        this.blackList = new Array();
        this.bValue = false;
        this.fields.each(function (el) {
            var klass = el.getProperty('class').split(' ');
            var aFilters = eval(klass[0].match(/^valid(\[.+\])$/)[1]);
            aFilters.each(function (filter) {
                var tag = el.get('tag');
                if (tag == 'div' && filter == 'rdropdown') {
                    this.fields.push(el);
                    this._dropdownClick(el);
                } else if (tag == 'div' && filter == 'datepikerggl') {
                	this.fields.push(el);
                } else if (tag == 'div' && filter == 'roption') {
                    this._option(el);
                } else if (tag == 'div' && filter == 'rtable') {
                    this._table(el);
                } else if (tag == 'div' && filter == 'optText') {
                    this._optClick(el);
                } else if (tag == 'div' && filter == 'optText3') {
                    this._optClick3(el);
                } else if (tag == 'div' && filter == 'optText4') {
                    this._optClick4(el);
				} else if (tag == 'div' && filter == 'optText5') {
					this._optClick5(el);
				} else if (tag == 'div' && filter == 'optText6') {
					this._optClick6(el);
                } else if (tag == 'input' && filter == 'file') {
                    this._fileChange(el);
                } else if (tag == 'input' && filter == 'filext') {
                	 this._fileChangesend(el,false);
                } else if (tag == 'input' && filter == 'check') {
                	this._validCheck(el);
                } else {
                    this._onblur(el, filter);
                }
            } .bind(this));
        } .bind(this));

        if (this.button != '') {
            $(this.button).addEvent('click', this._onSubmit.bind(this));
            this.form.addEvent('submit', function(e){e.stop();});
        } else {
            this.form.addEvent('submit', this._onSubmit.bind(this));
        }
    },

    pikerggl :function(el){
    	
    	
    	fecNacimiento = this.options.valuePiker;
		
    	var dateTest = fecNacimiento.value.test(/^(0[1-9]|[12][0-9]|3[01])[- \/.](0[1-9]|1[012])[- \/.](19|20)\d\d$/);
    	this.msg = "Registra una fecha v&aacute;lida.";
    	
    	if(dateTest){
    		var dateToCheck, fecha, day, month, year;
    		fecha = fecNacimiento.value.split('/');
        	day = fecha[0].toInt();
        	month = fecha[1].toInt() - 1;
        	year = fecha[2].toInt();

        	dateToCheck = new Date(year,month,day );
        	dateTest =  ((dateToCheck.getDate() == day) && (dateToCheck.getMonth() == month) && (dateToCheck.getFullYear() == year));

        	if(dateTest){
        		this.msg = "Debes ser mayor de 18 a\u00F1os.";
        		nowDate = new Date();
        		nowYear = nowDate.getYear();
        		nowMonth = nowDate.getMonth();
        		nowDay = nowDate.getDate();
        		if(nowYear < 1900)nowYear += 1900;
        		age = nowYear - year;
        		if (nowMonth < (month - 1)) age = age - 1;
        		if (((month - 1) == nowMonth) && (nowDay < day)) age = age - 1;
        		dateTest = (age > 17);
        	}

    	}
    	
       if (!dateTest) this._onError(el); else this._onRmError(el);

    },
    
    _option: function (el) {

        var textArea = el.getElement('textarea');
        filter = textArea.get('filter');

        textArea.addEvent('blur', function () {
            var element = el.getElement('input[type=radio]:checked');
            var val = element.get('optvalid');

            if (val == 1) {
                this._validate(textArea, filter);
            } else {
                if (textArea.value.length > 0) this._validate(textArea, filter);
            }
        } .bind(this));

        var btnradio = el.getElements('input[type=radio]');
        btnradio.each(function (radio) {
            radio.addEvent('click', function (e) {
                val = radio.get('optvalid');
                if (val == 0){
                	this._onRmError(textArea);
                	var index = this.fields.indexOf(textArea);
                	this.fields.splice(index, 1);


                }else{
                	this.fields.push(textArea);
                }
            } .bind(this));
        } .bind(this));

    },

    _validCheck :function(el){

		el.addEvent('click',function(){
			if(!el.checked) this._onError(el); else this._onRmError(el);
		}.bind(this));

    },

    _table: function (el) {

        var inputs = el.getElements('div.lin1 input');
        var inputsline2 = el.getElements('div.lin2 input');
        var inputsline3 = el.getElements('div.lin3 input');

            inputs.each(function(input){
                    this._onblur(input, 'alphabetic');
                    this.fields.push(input);
            }.bind(this));

            this._valInputAll(inputsline2);
            this._valInputAll(inputsline3);
    },
    _valInputAll: function (els) {

        els.each(function (el) {
        	this.fields.push(el);
            el.addEvent('blur', function () {
                var bValue = this._valFilterInput(els);
                els.each(function (el) {
                    if (bValue == false) this._validate(el, 'alphabetic'); else this._onRmError(el);
                } .bind(this));
            } .bind(this));
        } .bind(this));
    },

    _valFilterInput: function (els) {
        var count = els.length,
                        errorCount = 0,
                        bValue = true;
        els.each(function (input) {
        	val  = input.value.trim();
        	input.set('value',val);
        	if (input.value.length == 0) ++errorCount;
        });
        if (errorCount != count) bValue = false;
        return bValue;
    },

    _dropdownClick: function (el) {
        el.addEvent('mouseleave', function (elm) {
            var hElement = el.getElement('input');
            if (hElement.value == '0') this._onError(el); else this._onRmError(el);
        } .bind(this));
    },

    _fileChange: function (el) {
        el.addEvent('change', function () {

            if (el.get("filter")) {
                var filter = el.get("filter").split(','),
                            arr = el.value.split('.'),
                            ext = arr[arr.length - 1],
                            bValue = false;
                filter.each(function (fil) { if (fil == ext) bValue = true; });
                if (el.value == '' || !bValue) this._onError(el); else this._onRmError(el);
            }
        } .bind(this));
    },

    _fileChangesend:function(el,active){

    	active || (active= false);
    	//this.fields.push(el);

    	if(!this.fields.contains(el))this.fields.push(el);

    	if(active){
    		iValue = el.value.toInt();
    		if (iValue === 0) this._onError(el); else this._onRmError(el);
    	}

    },

    _optClick: function (el) {

    	var contentError = el.getParent('div').getNext('div.form-error');
        var optSpan = el.getElements('span');
        var text = el.getNext('input[type=text]');
        var hidden = el.getElement('input');

        this.min = this.options.dniLength;
        this.max = this.options.dniLength;
        iValue = hidden.value.toInt();

        if(iValue == 1)
        	text.set('maxLength', '8');
        else if(iValue == 2)
        	text.set('maxLength', '12');

        this.fields.push(text);

        optSpan.each(function (opt) {
            opt.addEvent('click', function () {

                optSpan.removeClass('active-op');
                opt.addClass('active-op');
                var valor =opt.get('valor');
                text.removeProperty('maxlength');
                text.set('value','');
                hidden.set('value',valor);
                if (hidden.value == this.options.dniValue) {
                    text.set('maxLength', this.options.dniLength);
                    this.min = this.options.dniLength;
                    this.max = this.options.dniLength;
                    contentError.set('html','Ingresa un DNI de 8 d\u00EDgitos.');
                } else {
                    this.min = this.options.carneLengthMin;
                    this.max = this.options.carneLengthMax;
                    text.set('maxLength', this.options.carneLengthMax);
                    contentError.set('html','Ingresa entre 4 y 12 caracteres.');
                }
            }.bind(this));
        }.bind(this));

        text.addEvent('blur',function(){
        	var hidden = el.getElement('input');
            if (hidden.value == this.options.dniValue) {
            	this.bValue = this.optType(text, 'numeric');
            	this.min = this.options.dniLength;
            	this.max = this.options.dniLength;
            }else{
            	this.bValue = this.optType(text, 'alphanumeric');
            	this.min = this.options.carneLengthMin;
            	this.max = this.options.carneLengthMax;
            }
            var isRange = ((text.value.length < this.min || text.value.length > this.max) ? false : true);
            if (!this.bValue || !isRange) this._onError(text); else this._onRmError(text);
        }.bind(this));
    },

    _optClick3: function (el) {

        var optSpan = el.getElements('span');
        var text = el.getNext('div').getElement('input[type=text]');
        var hidden = el.getElement('input');

        this.min = this.options.dniLength;
        this.max = this.options.dniLength;
        text.set('maxLength', this.options.dniLength);
        this.fields.push(text);

        optSpan.each(function (opt) {
            opt.addEvent('click', function () {
                optSpan.removeClass('active-op');
                opt.addClass('active-op');
                var valor =opt.get('valor');
                text.removeProperty('maxlength');
                text.set('value','');
                hidden.set('value',valor);
                if (hidden.value == this.options.dniValue){
                    text.set('maxLength', this.options.dniLength);
                    this.min = this.options.dniLength;
                    this.max = this.options.dniLength;
                } else if(hidden.value == this.options.carneValue) {
                    text.set('maxLength', this.options.carneLengthMax);
                    this.min = this.options.carneLengthMin;
                    this.max = this.options.carneLengthMax;

                }else if(hidden.value == this.options.pasaporteValue){
                    text.set('maxLength', this.options.pasaporteLengthMax);
                    this.min = this.options.pasaporteLengthMin;
                    this.max = this.options.pasaporteLengthMax;
                }

            }.bind(this));
        }.bind(this));

        text.addEvent('blur',function(){

        	 var hidden = el.getElement('input');

            if (hidden.value == this.options.dniValue) {
                    this.bValue = this.optType(text, 'numeric');
                }else{
                    this.bValue = this.optType(text, 'alphanumeric');
                }

                var isRange = ((text.value.length < this.min || text.value.length > this.max) ? false : true);
                if (!this.bValue || !isRange) this._onError(text); else this._onRmError(text);

        }.bind(this));

    },
    _optClick4: function(el){

    	var optSpan, text, hidden, msj_name,contentError;

    		contentError = el.getParent('div').getNext('div.form-error');
    		optSpan = el.getElements('span');
    		text = el.getNext('div').getElement('input[type=text]');
    		hidden = el.getElement('input');


          this.min = this.options.dniLength;
          this.max = this.options.dniLength;
          text.set('maxLength', this.options.dniLength);
          msj_name = $('MSJ_' + hidden.value).value;
          contentError.set('html',msj_name);
          this.fields.push(text);
          optSpan.each(function (opt) {
              opt.addEvent('click', function () {
            	  optSpan.removeClass('active-op');
                  opt.addClass('active-op');
                  var valor =opt.get('valor');
                  text.removeProperty('maxlength');
                  text.set('value','');
                  hidden.set('value',valor);
                  msj_name = $('MSJ_' + hidden.value).value;
                  contentError.set('html',msj_name);

                  if (hidden.value == this.options.dniValue){
                      text.set('maxLength', this.options.dniLength);
                      this.min = this.options.dniLength;
                      this.max = this.options.dniLength;
                  } else if(hidden.value == this.options.carneValue) {
                      text.set('maxLength', this.options.carneLengthMax);
                      this.min = this.options.carneLengthMin;
                      this.max = this.options.carneLengthMax;
                  }else if(hidden.value == this.options.pasaporteValue){
                      text.set('maxLength', this.options.pasaporteLengthMax);
                      this.min = this.options.pasaporteLengthMin;
                      this.max = this.options.pasaporteLengthMax;
                  }

              }.bind(this));
          }.bind(this));

          text.addEvent('blur',function(){

         	 var hidden = el.getElement('input');

             if (hidden.value == this.options.dniValue) {
                     this.bValue = this.optType(text, 'numeric');
                 }else{
                     this.bValue = this.optType(text, 'alphanumeric');
                 }

                 var isRange = ((text.value.length < this.min || text.value.length > this.max) ? false : true);
                 if (!this.bValue || !isRange) this._onError(text); else this._onRmError(text);

         }.bind(this));


    },

	_optClick5: function(el){

    	var text, hidden, msj_name,contentError;

    		contentError = el.getParent('div').getNext('div.form-error');
    		text = el.getNext('div').getElement('input[type=text]');
    		hidden = el.getElement('input');

          this.min = this.options.dniLength;
          this.max = this.options.dniLength;
          text.set('maxLength', this.options.dniLength);
          msj_name = $('MSJ_' + hidden.value).value;
          contentError.set('html',msj_name);
          this.fields.push(text);

              el.addEvent('click', function () {
            		hidden = el.getElement('input');
            	  	var opt = el.getElement('span.active-op');
            	  	var valor =opt.get('valor');
            	  	text.removeProperty('maxlength');
            	  	text.set('value','');
            	  	hidden.set('value',valor);
            	  	msj_name = $('MSJ_' + hidden.value).value;
            	  	contentError.set('html',msj_name);

                  if (hidden.value == this.options.dniValue){
                      text.set('maxLength', this.options.dniLength);
                      this.min = this.options.dniLength;
                      this.max = this.options.dniLength;
                  } else if(hidden.value == this.options.carneValue) {
                      text.set('maxLength', this.options.carneLengthMax);
                      this.min = this.options.carneLengthMin;
                      this.max = this.options.carneLengthMax;
                  }else if(hidden.value == this.options.pasaporteValue){
                      text.set('maxLength', this.options.pasaporteLengthMax);
                      this.min = this.options.pasaporteLengthMin;
                      this.max = this.options.pasaporteLengthMax;
                  }

              }.bind(this));


          text.addEvent('blur',function(){

         	 var hidden = el.getElement('input');

             if (hidden.value == this.options.dniValue) {
                     this.bValue = this.optType(text, 'numeric');
                 }else{
                     this.bValue = this.optType(text, 'alphanumeric');
                 }

                 var isRange = ((text.value.length < this.min || text.value.length > this.max) ? false : true);
                 if (!this.bValue || !isRange) this._onError(text); else this._onRmError(text);

         }.bind(this));


    },
    _optClick6: function (el) {

    	var contentError = el.getParent('div.campos-oblig').getNext('div.form-error');
    	var textError = "";
        var text = el.getNext('input[type=text]');
        var hidden;
        this.min = this.options.dniLength;
        this.max = this.options.dniLength;

        this.fields.push(text);

            el.addEvent('click', function () {

            	hidden = el.getElement('input[type=hidden]');
                text.removeProperty('maxlength');
                
				if(!el.getElement('span.disable-op') && !el.getElement('span.disable-op2')){
					text.set('value','');
				}

                if (hidden.value == this.options.dniValue) {

                    text.set('maxLength', this.options.dniLength);
                    this.min = this.options.dniLength;
                    this.max = this.options.dniLength;
                    textError =$('MSJ_DNI').get('value');
                    contentError.set('html',textError);

                } else {

                	textError = $('MSJ_CARNET_EXTRANJERIA').get('value');
                    this.min = this.options.carneLengthMin;
                    this.max = this.options.carneLengthMax;
                    text.set('maxLength', this.options.carneLengthMax);
                    contentError.set('html',textError);
                }
            }.bind(this));


        text.addEvent('blur',function(){
        	var hidden = el.getElement('input');
            if (hidden.value == this.options.dniValue) {
            	this.bValue = this.optType(text, 'numeric');
            	this.min = this.options.dniLength;
            	this.max = this.options.dniLength;
            }else{
            	this.bValue = this.optType(text, 'alphanumeric');
            	this.min = this.options.carneLengthMin;
            	this.max = this.options.carneLengthMax;
            }
            var isRange = ((text.value.length < this.min || text.value.length > this.max) ? false : true);
            if (!this.bValue || !isRange) this._onError(text); else this._onRmError(text);
        }.bind(this));
    },

    _onblur: function (el, filter) {

        $(el).addEvent("blur", function () {
            var placeholder = $(el).get('placeholder');
            var sValue = $(el).value;
            var splaceholder = "";
            var equal = filter.split('');

            if (placeholder == sValue && Browser.ie) {
                $(el).value = "";
                splaceholder = placeholder;
            }

            if (equal[0] == '=') {
                var el2 = filter.split('=');
                this._equal(el, el2[1]);
            } else {
                this._validate(el, filter);
            }

            if (placeholder == splaceholder && Browser.ie) {
                $(el).value = splaceholder;
            }


        } .bind(this));


    },

    _equal: function (el1, el2) {
        if ($(el1).value != $(el2).value || $(el2).value == "") {
            this._onError(el1);
        } else {
            this._onRmError(el1);
        }
    },

    _validate: function (el, filter) {

        if (filter.contains('{')) {
            var range = filter.replace('{', '').replace('}', '').split('-');
            var id = el.get('id');
            var data = { 'id': id, 'min': range[0], 'max': range[1] };
            var bValue = false;
            if(this.aRange.length > 0){
                for(i = 0, len = this.aRange.length ; i < len; i++ ){
                	var item = this.aRange[i];
                	if (id === item.id){
                		bValue = true;
                		break;
                	}
                }
            }
            if(!bValue) this.aRange.push(data);
            filter = 'range';
        }else if(filter.contains('[')){
        	var range = filter.replace('[', '').replace(']', '').split('-');
        	var id = el.get('id');
            var data = { 'id': id, 'min': range[0], 'max': range[1] };
            var bValue = false;

            if(this.aRange.length > 0){
                for(i = 0, len = this.aRange.length ; i < len; i++ ){
                	var item = this.aRange[i];
                	if (id === item.id){
                		bValue = true;
                		break;
                	}
                }
            }
            if(!bValue) this.aRange.push(data);
            //filter = 'range2';
            filter = 'range';
        }

        var val = el.value.trim();
        el.set('value', val);

        switch (filter) {

	        case "required":
	            var reqTest = el.value.test(/[^.*]/);
	            if (!reqTest) this._onError(el); else this._onRmError(el);
	            break;
	        case "alphabetic":
	        	 var alphabeticTest = el.value.test(/^[a-zA-Z \-\'\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da\u00f1\u00d1\u00FC\u00DC]+$/);
	            if (!alphabeticTest) this._onError(el); else this._onRmError(el);
	            break;
	        case "optionalalphabeticGroup":
                var elemt = this.options.optionalValue;
                element = elemt.getElement('input[type=hidden]');

	        	if((el.value.length > 0 &&  this.options.optional == element.value) || (this.options.forceOptional == element.value) ){
	        		var optionalalphabeticTest = el.value.test(/^[a-zA-Z \-\'\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da\u00f1\u00d1\u00FC\u00DC]+$/);
	        		if (!optionalalphabeticTest) this._onError(el); else this._onRmError(el);
	        	}else{
	        		this._onRmError(el);
	        	}
	            break;
            case "optionalalphabeticGroup2":
                var element = this.options.optionalValue;
                if((el.value.length > 0 &&  this.options.optional == element.value) || (this.options.forceOptional == element.value) ){
                    var optionalalphabeticTest = el.value.test(/^[a-zA-Z \-\'\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da\u00f1\u00d1\u00FC\u00DC]+$/);
                    if (!optionalalphabeticTest) this._onError(el); else this._onRmError(el);
                }else{
                    this._onRmError(el);
                }
                break;
	        case "optionalalphaNumericGroup":
	        	var element = this.options.optionalValue;
	        	if((el.value.length > 0 &&  this.options.optional == element.value) || (this.options.forceOptional == element.value) ){
	        		var optionalalphabeticTest = el.value.test(/^[a-zA-Z0-9 \.\_\-\'\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da\u00f1\u00d1\u00FC\u00DC]+$/i);
	        		if (!optionalalphabeticTest) this._onError(el); else this._onRmError(el);
	        	}else{
	        		this._onRmError(el);
	        	}
	            break;
            case "optionalalphaNumericGroup2":

                var elemt = this.options.optionalValue;
                element = elemt.getElement('input[type=hidden]');

                if((el.value.length > 0 &&  this.options.optional == element.value) || (this.options.forceOptional == element.value) ){
                    var optionalalphabeticTest = el.value.test(/^[a-zA-Z0-9 \.\_\-\'\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da\u00f1\u00d1\u00FC\u00DC]+$/i);
                    if (!optionalalphabeticTest) this._onError(el); else this._onRmError(el);
                }else{
                    this._onRmError(el);
                }
                break;
	        case "optionalalphabetic":
	        	if(el.value.length > 0 ){
	        		var optionalalphabeticTest = el.value.test(/^[a-zA-Z \-\'\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da\u00f1\u00d1\u00FC\u00DC]+$/);
	        		if (!optionalalphabeticTest) this._onError(el); else this._onRmError(el);
	        	}else{
	        		this._onRmError(el);
	        	}
	        	break;
	        case "optionalalphaNumeric":
	        	if(el.value.length > 0 ){
	        		var optionalalphabeticTest = el.value.test(/^[a-zA-Z0-9 \.\_\-\'\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da\u00f1\u00d1\u00FC\u00DC]+$/i);
	        		if (!optionalalphabeticTest) this._onError(el); else this._onRmError(el);
	        	}else{
	        		this._onRmError(el);
	        	}
	        	break;
	        case "alphaNumeric":
	            var alphaNumericTest = el.value.test(/^[a-zA-Z0-9 \.\_\-\'\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da\u00f1\u00d1\u00FC\u00DC]+$/i);
	            if (!alphaNumericTest) this._onError(el); else this._onRmError(el);
	            break;
	        case "numeric":
	            var numericTest = el.value.test(/^[0-9]+$/);
	            if (!numericTest) this._onError(el); else this._onRmError(el);
	            break;
	        case "optionalNumeric":
	        	if(el.value.length>0){
	            var numericTest = el.value.test(/^[0-9]+$/);
	            if (!numericTest) this._onError(el); else this._onRmError(el);
	        	}else{
	        		this._onRmError(el);
	        	}break;
            case "codec":
                var codecTest = el.value.test(/^[a-z0-9]{4}\-[a-z0-9]{1}\-[0-9]{3}$/i);
                if (!codecTest) this._onError(el); else this._onRmError(el);
                break;
            case "ruc":
            	var rucTest = el.value.test(/(^1|2)+([0-9]{10})/);
            	if (!rucTest) this._onError(el); else this._onRmError(el);
            	break;
            case "mobil":
            	var mobilTest = el.value.test(/^9+([0-9]{8})/);
            	if (!mobilTest) this._onError(el); else this._onRmError(el);
            	break;
            case "sdate":
            	var dateTest = el.value.test(/^(([0-2]?\d)|(3[0-1]))\/((1[0-2])|(0?\d))\/(\d{4})/);
            	if(dateTest){
            		var dateToCheck, fecha, day, month, year;
            		fecha = el.value.split('/');
                	day = parseInt(fecha[0]);
                	month = parseInt(fecha[1]);
                	year = parseInt(fecha[2]);
                	dateToCheck = new Date(el.value);
                	dateTest =  ((dateToCheck.getDate() === day) && ((dateToCheck.getMonth()+1) === month) && (dateToCheck.getFullYear() === year));
            	}
                if (!dateTest) this._onError(el); else this._onRmError(el);
                break;
            case "birthday":
            	if(this.options.validoff){

	            	var dateTest = el.value.test(/^(0[1-9]|[12][0-9]|3[01])[- \/.](0[1-9]|1[012])[- \/.](19|20)\d\d$/);
	            	this.msg = "Registra una fecha v&aacute;lida.";

	            	if(dateTest){
	            		var dateToCheck, fecha, day, month, year;
	            		fecha = el.value.split('/');
	                	day = fecha[0].toInt();
	                	month = fecha[1].toInt() - 1;
	                	year = fecha[2].toInt();

	                	dateToCheck = new Date(year,month,day );
	                	dateTest =  ((dateToCheck.getDate() == day) && (dateToCheck.getMonth() == month) && (dateToCheck.getFullYear() == year));

	                	if(dateTest){
	                		this.msg = "Debes ser mayor de 18 a\u00F1os.";
	                		nowDate = new Date();
	                		nowYear = nowDate.getYear();
	                		nowMonth = nowDate.getMonth();
	                		nowDay = nowDate.getDate();
	                		if(nowYear < 1900)nowYear += 1900;
	                		age = nowYear - year;
	                		if (nowMonth < (month - 1)) age = age - 1;
	                		if (((month - 1) == nowMonth) && (nowDay < day)) age = age - 1;
	                		dateTest = (age > 17);
	                	}

	            	}
	                if (!dateTest) this._onError(el); else this._onRmError(el);
            	}
                break;
            case "selreq":
                var selTest = el.value.test(/[^oOfFfF]/);
                if (!selTest) this._onError(el); else this._onRmError(el);
                break;
            case "email":
            	var email = el.value.toLowerCase();
                //var emailTest = email.test(/^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,3})*$/);
                var emailTest = email.test(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/);

                if (!emailTest) this._onError(el); else this._onRmError(el);
                break;
            case "url":
                var urlTest = el.value.test(/^(http|https|ftp)\:\/\/[a-z0-9\-\.]+\.[a-z]{2,3}(:[a-z0-9]*)?\/?([a-z0-9\-\._\?\,\'\/\\\+&amp;%\$#\=~])*$/i);
                if (!urlTest) this._onError(el); else this._onRmError(el);
                break;
                isRange = ((el.value.length < this.min || el.value.length > this.max) ? false : true);
                if (!bValue || !isRange) this._onError(el); else this._onRmError(el);
                break;
            case "phone":
                var isRange = ((el.value.length < this.options.telefLenghtMin || el.value.length > this.options.telefLenghtMax) ? false : true);
                el.set('maxlength', this.options.telefLenghtMax);
                bValue = this.optType(el, 'numeric');
                if (!bValue || !isRange) this._onError(el); else this._onRmError(el);
                break;
            case "optionalPhone":
            	if(el.value.length>0){
                var isRange = ((el.value.length < this.options.telefLenghtMin || el.value.length > this.options.telefLenghtMax) ? false : true);
                el.set('maxlength', this.options.telefLenghtMax);
                bValue = this.optType(el, 'numeric');
                if (!bValue || !isRange) this._onError(el); else this._onRmError(el);
            	}else{
	        		this._onRmError(el);
	        	}break;	
	        case "placa":
	            var placaTest = el.value.test(/^[a-zA-Z0-9\-]+$/i);
	            if (!placaTest) this._onError(el); else this._onRmError(el);
	            break;
            case "range":
                var xid = el.get('id');
                this.aRange.each(function (element) {
                    if (element.id == xid) {
                        if (el.value.length < element.min || el.value.length > element.max) this._onError(el); else this._onRmError(el);
                    }
                } .bind(this));
                break;
            case "range2":
                var xid = el.get('id');
                this.aRange.each(function (element) {
                    if (element.id == xid) {
                        if (el.value.length < element.min || el.value.length > element.max){
                        	if(el.value.length < element.min){
                        		el.getParent().getNext("div.form-error").set('html','Por favor ingresa un mensaje.');
                        	}else if(el.value.length > element.max){
                        		el.getParent().getNext("div.form-error").set('html','Solo se permiten 1000 caracteres, por favor modifica tu mensaje.');
                        	}
                        	this._onError(el);
                        }else{
                        	this._onRmError(el);
                        }
                    }
                } .bind(this));
                break;
        }
    },

    _onError: function (el) {

    var bValue = false;

        if(this.blackList.length > 0){
           this.blackList.each(function(element){
                if(element == el) bValue = true;
            }.bind(this));
        }

        if(!bValue) this.blackList.push(el);

        if (!el.hasClass("valid['datepikerggl']")) el.addClass("text-error");



        var content = el.getParent('div.campos-oblig') || el.getParent('div.uploader_de') || el.getParent('div.textcontent') || el.getParent('div.recaptcha') || el.getParent('div.contentCheck');



        if (el.get("tag") == 'div') el.removeClass('bgfa');
        if (el.hasClass("valid['birthday']")) {
        	el.setStyle('background-color','#FCE5F1');
        	var element = content.getNext("div.form-error");
        	element.set({'html':this.msg,'styles':{"display": "block"}});

        	/*SE toco aca*/
        	el.removeClass("text-error");
        	el.addClass("wt129error");
        	el.addClass("text-error");
        	/*se termino*/
        	
        }else if (el.hasClass("valid['datepikerggl']")) {
        	var elements;
        	elements = el.getChildren('.pkggl');
        	elements.addClass('text-error');
        	elements.removeClass('bgfa');
			
			var element = content.getNext("div.form-error");
				element.set({'html':this.msg,'styles':{"display": "block"}});
        	
        }else if(content){
            var element = content.getNext("div.form-error");
            element.setStyle("display", "block");
        } else {
            var element = el;
            if (element) {
                element.getNext("div.form-error").setStyle("display", "block");
                //this.errorinform = false;
                this.lineError += 1;
            }
        }

    },

    _onRmError: function (el) {

        if(this.blackList.length > 0){
           var blackList2 = new Array();

           this.blackList.each(function(element){
                 if(element != el) blackList2.push(element);
            }.bind(this));
           this.blackList = blackList2;
        }

		var content = el.getParent('div.campos-oblig') || el.getParent('div.uploader_de') || el.getParent('div.textcontent') || el.getParent('div.recaptcha') || el.getParent('div.contentCheck');
		
		if (el.hasClass("valid['datepikerggl']")) {
        	var elements;
        	elements = el.getChildren('.pkggl');
        	elements.removeClass('text-error');
        	el.getChildren('div.pkggl').addClass('bgfa');
			
			var element = content.getNext("div.form-error");
				element.set({'html':this.msg,'styles':{"display": "none"}});
				
		}else{
		
        el.removeClass("text-error");
        if (el.hasClass("valid['birthday']")) el.removeClass("wt129error");

        if (content) {
            var element = content.getNext("div.form-error");
            element.setStyle("display", "none");
            //this.errorinform = true;
        } else {
            el.getNext("div.form-error").setStyle("display", "none");
        }
        if (el.get("tag") == 'div') el.addClass('bgfa');

		}

    },

    _onValError:function(){
        if( this.blackList.length === 0){
            return true;
        }
        return false;
    },

    optType: function (el, type) {
        var val = el.value.trim();
        el.set('value', val);
        if (type == 'numeric'){
            return el.value.test(/^[-+]?\d+$/);
        }else{
            return el.value.test(/^[a-zA-Z0-9]*$/);
        }
    },

    _onSubmit: function (e) {

        this.errorinform = false;
        this.options.validoff = true;
        this.fields.each(function (el) {
        	
            if (el.get('type') == 'file') {
                el.fireEvent("change");
            } else if (el.get('type') == 'hidden' && el.hasClass('filext')) {
            	this._fileChangesend(el,true);
            } else if (el.get('type') == 'checkbox') {
            	el.fireEvent('click');
            } else if (el.get('tag') == 'input' || el.get('tag') == 'textarea') {
                el.fireEvent("blur");
            }else if(el.get('tag') == 'div' && el.hasClass('pikerggl')){
            	this.pikerggl(el);
            }else if(el.get('tag') == 'div'){
                el.fireEvent('mouseleave');
            }
        } .bind(this));

        this.options.validoff = false;

        this.errorinform = this._onValError();

        if(this.errorinform){
        	this.fireEvent("onValid");
        }

        this.fireEvent("onComplete");

    }

});