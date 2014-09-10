var moovalid = new Class({
                Implements: [Options, Events],
                options: {
                     dniLength:8,
                     dniValue:1,
                     carneLength:12,
                     carneValue:2,
                     pasaporteLength:15,
                     pasaporteValue:3,
                     telefLenghtMax:9,
                     telefLenghtMin:7,
                     btnValid:''
                },

                initialize: function(form, options) {
                        this.setOptions(options);
                        this.form = $(form);
                        this.errorinform = false;
                        this.activeClick = false;
                        this.button = this.options.btnValid;
                        this.min = 0;
                        this.max = 0;
                        this.aRange = new Array();
                        this.fields = this.form.getElements('*[class^=valid]');
                        this.lineError = 0
                        this.fields.each(function(el){
                            var klass = el.getProperty('class').split(' ');
                            var aFilters = eval(klass[0].match(/^valid(\[.+\])$/)[1]);
                            aFilters.each(function(filter){
                                var tag = el.get('tag');
                                if(tag == 'div' && filter == 'rdropdown' ){
                                    this._dropdownClick(el);
                                }else if (tag == 'div' && filter == 'roption'){
                                    this._option(el);
                                }else if (tag == 'div' && filter == 'rtable'){
                                    this._table(el);
                                }else if (tag == 'input' && filter == 'file'){
                                    this._fileChange(el);
                                }else{
                                    this._onblur(el,filter);
                                }
                            }.bind(this));
                        }.bind(this))

                        if(this.button != ''){
                            $(this.button).addEvent('click',this._onSubmit.bind(this));
                        }else{
                            this.form.addEvent('submit', this._onSubmit.bind(this));
                        }
                },

                _option:function(el){

                    var textArea = el.getElement('textarea');
                    filter = textArea.get('filter');

                        textArea.addEvent('blur',function(){
                            var element = el.getElement('input[type=radio]:checked')
                            var val = element.get('optvalid');

                            if(val == 1){
                                this._validate(textArea,filter);
                            }else {
                              if(textArea.value.length > 0) this._validate(textArea,filter);
                            }
                        }.bind(this));

                    var btnradio = el.getElements('input[type=radio]');
                    btnradio.each(function(radio){
                        radio.addEvent('click',function(e){
                            val = radio.get('optvalid');
                            if(val == 0) this._onRmError(textArea);
                        }.bind(this));
                    }.bind(this));

                },


                _table:function(el){

                        var table = el.getElement("table")
                            ,aTr = table.getElements('tr')
                            ,bValue = true;

                        aTr.each(function(tr,index){
                            var aInput = tr.getElements('input')
                            if(aInput.length > 0){
                                if(bValue){
                                    aInput.each(function(input){
                                        this._onblur(input,'required');
                                        this.fields.push(input);
                                    }.bind(this));
                                    bValue = false;
                                }else{
                                     this._valInputAll(aInput);
                                }
                            }

                        }.bind(this))
                },
                _valInputAll:function(els){


                    els.each(function(el){
                        el.addEvent('blur',function(){
                          var bValue  =  this._valFilterInput(els);
                            els.each(function(el){
                                if(bValue == false) this._validate(el,'required'); else this._onRmError(el);
                            }.bind(this));
                        }.bind(this))
                    }.bind(this))
                },

                _valFilterInput:function(els){
                    var count = els.length,
                        errorCount = 0,
                        bValue = true;
                    els.each(function(input){if(input.value.length == 0) ++errorCount; });
                    if(errorCount != count) bValue = false;
                    return bValue
                },

                _dropdownClick:function(el){
                   el.addEvent('mouseleave',function(elm){
                        var hElement = el.getElement('input[type=hidden]');
                        if(hElement.value == '0') this._onError(el); else this._onRmError(el);
                    }.bind(this));
                },

                _fileChange:function(el){
                    el.addEvent('change',function(){

                    if(el.get("filter")){
                        var filter = el.get("filter").split(','),
                            arr = el.value.split('.'),
                            ext = arr[arr.length-1],
                            bValue = false;
                        filter.each(function(fil){ if( fil == ext) bValue = true });
                        if(el.value == '' || !bValue) this._onError(el); else this._onRmError(el);
                    }
                    }.bind(this));
                },

                _optClick:function(el,type){
                    this.activeClick = true;
                    if(type == 'simple'){
                        var content = el.getPrevious('div'),
                            text = el,
                            optSpan = content.getElements("span");
                    }else{
                        var content =  el.getParent('div.campos-oblig');
                            text = el,
                            optSpan = content.getElements("span");
                    }
                    optSpan.each(function(opt){
                        opt.addEvent('click',function(){
                            text.fireEvent("blur");
                        })
                    });

                },

                _onblur:function(el,filter){

                    $(el).addEvent("blur",function(){
                        var equal =filter.split('');
                        if(equal[0] == '=' ){
                            var el2 = filter.split('=');
                            this._equal(el,el2[1]);
                        }else{
                            this._validate(el,filter);
                        }
                    }.bind(this));
                },

                _equal:function(el1,el2 ){
                    if($(el1).value != $(el2).value) this._onError(el1); else this._onRmError(el1);
                },

                _validate: function(el,filter){

                    if(filter.contains('{')){
                        var range = filter.replace('{','').replace('}','').split('-')
                        var id = el.get('id');
                        var data = {'id':id, 'min':range[0],'max': range[1]}
                        this.aRange.push(data)
                        filter = 'range';
                    }

                    switch(filter){
                        case "required":
                                var reqTest = el.value.test(/[^.*]/);
                                if(!reqTest) this._onError(el); else this._onRmError(el);
                                break;
                        case "alphabetic":
                                var alphabeticTest = el.value.test(/^[a-z ._-]+$/i);
                                if(!alphabeticTest) this._onError(el); else this._onRmError(el);
                        break;
                        case "alphaNumeric":
                                var alphaNumericTest = el.value.test(/^[a-z ._-]+$/i);
                                if(!alphaNumericTest) this._onError(el); else this._onRmError(el);
                        break;
                        case "numeric":
                                var numericTest = el.value.search(/[^0-9\.\,\s\-\_]/);
                                if(!numericTest) this._onError(el); else this._onRmError(el);
                        break;
                        case "codec":
                                var codecTest = el.value.test(/^[a-z0-9]{4}\-[a-z0-9]{1}\-[0-9]{3}$/i);
                                if(!codecTest) this._onError(el); else this._onRmError(el);
                        break;
                        case "sdate":
                                var dateTest = el.value.test(/[0-9]{4}\-[0-9]{2}\-[0-9]{2}$/);
                                if(!dateTest) this._onError(el); else this._onRmError(el);
                        break;
                        case "selreq":
                                var selTest = el.value.test(/[^oOfFfF]/);
                                if(!selTest) this._onError(el); else this._onRmError(el);
                        break;
                        case "email":
                                var emailTest = el.value.test(/^[a-z0-9._%-]+@[a-z0-9.-]+\.[a-z]{2,4}$/i);
                                if(!emailTest) this._onError(el); else this._onRmError(el);
                        break;
                        case "url":
                                var urlTest = el.value.test(/^(http|https|ftp)\:\/\/[a-z0-9\-\.]+\.[a-z]{2,3}(:[a-z0-9]*)?\/?([a-z0-9\-\._\?\,\'\/\\\+&amp;%\$#\=~])*$/i);
                                if(!urlTest) this._onError(el); else this._onRmError(el);
                        break;
                        case "optText":
                                var content = el.getPrevious('div'),
                                    hidden = content.getElement("input['type=hidden']"),
                                    text = content.getNext("input['type=text']"),
                                    bValue = false,
                                    isRange = false;
                                if(!this.activeClick) this._optClick(el,'simple');
                                if(hidden.value == this.options.dniValue){
                                    text.set('maxlength','8');
                                    this.min = this.options.dniLength;
                                    this.max = this.options.dniLength;
                                    bValue = this.optType(el,'numeric')
                                }else{
                                    text.set('maxlength','12');
                                    this.min = this.options.carneLength;
                                    this.max = this.options.carneLength;
                                    bValue = this.optType(el,'alphanumeric')
                                }
                                isRange = ((el.value.length < this.min || el.value.length > this.max)? false : true);
                                if (!bValue || !isRange ) this._onError(el); else this._onRmError(el);
                        break;
                        case "optText3":
                                var content = el.getParent('div.campos-oblig');
                                    hidden = content.getElement("input['type=hidden']"),
                                    text = el,
                                    bValue = false,
                                    isRange = false;
                                if(!this.activeClick) this._optClick(el,'full');
                                if(hidden.value == this.options.dniValue){
                                    text.set('maxlength',this.options.dniLength);
                                    this.min = this.options.dniLength;
                                    this.max = this.options.dniLength;
                                    bValue = this.optType(el,'numeric')
                                }else if (hidden.value == this.options.carneValue){
                                    text.set('maxlength',this.options.carneLength);
                                    this.min = this.options.carneLength;
                                    this.max = this.options.carneLength;
                                    bValue = this.optType(el,'alphanumeric')
                                }else if (hidden.value == this.options.pasaporteValue){
                                    text.set('maxlength',this.options.pasaporteLength);
                                    this.min = this.options.pasaporteLength;
                                    this.max = this.options.pasaporteLength;
                                    bValue = this.optType(el,'alphanumeric')
                                }
                                isRange = ((el.value.length < this.min || el.value.length > this.max)? false : true);
                                if (!bValue || !isRange )this._onError(el); else this._onRmError(el);
                        break;
                        case "phone":
                                var isRange = ((el.value.length < this.options.telefLenghtMin || el.value.length > this.options.telefLenghtMax)? false : true);
                                el.set('maxlength',this.options.telefLenghtMax)
                                bValue = this.optType(el,'numeric')
                                if (!bValue || !isRange )this._onError(el); else this._onRmError(el);
                        break;
                        case "range":

                                var xid = el.get('id');
                                this.aRange.each(function(element){
                                    if(element.id == xid){
                                        if(el.value.length < element.min || el.value.length > element.max) this._onError(el); else this._onRmError(el);
                                    }
                                }.bind(this));


                        break;
                     }
                },

                _onError: function(el){
                    el.addClass("text-error");

                    var content = el.getParent('div.campos-oblig') || el.getParent('div.uploader_de') || el.getParent('div.textcontent');

                    if(el.get("tag") == 'div') el.removeClass('bgfa')
                    if(content){
                        var element = content.getNext("div.form-error");
                        element.setStyle("display","block");
                        this.errorinform = false;
                    }else{
                        var element = el.getParent('div.tabla-denuncia');
                        if(element){
                                element.getNext("div.form-error").setStyle("display","block");
                                this.errorinform = false;
                                 this.lineError +=1
                        }
                    }



                },

                _onRmError: function(el){

                    el.removeClass("text-error");
                    var content = el.getParent('div.campos-oblig') || el.getParent('div.uploader_de') || el.getParent('div.textcontent');


                    if(content){
                        var element = content.getNext("div.form-error");
                        element.setStyle("display","none");
                        this.errorinform = true;
                    }else{
                        var element = el.getParent('div.tabla-denuncia').getNext("div.form-error");
                        if(element ){
                            if(this.lineError > 0) this.lineError -=1;



                            this.lineError
                            if(this.lineError == 0){
                                element.setStyle("display","none");
                                this.errorinform = true;
                            }
                        }
                    }

                    if(el.get("tag") == 'div') el.addClass('bgfa')

                },

                optType : function(el, type){

                    if(type == 'numeric')
                        return el.value.test(/^[-+]?\d+$/);
                    else
                        return el.value.test(/^[a-zA-Z0-9_]/);
                },

                _onSubmit: function(e){



                    this.errorinform = false;
                    this.fields.each(function(el){
                        if(el.get('type') == 'file'){
                            el.fireEvent("change");
                        }else if(el.get('tag') == 'input' || el.get('tag') == 'textarea'){
                            el.fireEvent("blur");
                        }
                    });
                    if(!this.errorinform) return false;

                },
})