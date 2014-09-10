// JavaScript Document

/*redondeos*/
DD_roundies.addRule('.novedades .titulo-nv', '10px 0 10px 0');
DD_roundies.addRule('.novedades', '10px 0 10px 0');
DD_roundies.addRule('.servicios-hi', '10px 0 10px 0');
DD_roundies.addRule('.servicios-hi .lista-ser-hi', '10px 0 10px 0');
DD_roundies.addRule('.porlet-right-hp .feature-hp .sec-feature-img', '0 0 12px 0');
//DD_roundies.addRule('.pie-contactanos .llamada', '15px 0 0 0');
DD_roundies.addRule('.social-interbank', '15px 0 0 0');
DD_roundies.addRule('.social-pie', '0 0 15px 0');
DD_roundies.addRule('.twitter-interbank', '0 0 13px 0');
DD_roundies.addRule('.buscador-box', '5px 0 0 0');
var mySlider = {};

/*Funciones TABs*/

/*

iTabsControl : function que se encarga de crear tab's y botones para avanzar y retroceder dicha function recibe 5 parametros
	@ntab : Clase CSS del titulo de las pestañas.
	@dtab : Clase CSS del elemento que se encarga de envolver el contenido del tab 
	@tnext : Clase CSS del elemento que nos permitira avanzar al siguiente tab
	@tprev : Clase CSS del elemento que nos permitira retroceder al siguiente tab
	@scrollv : Quita el scroll por default que tiene Tab(valor opcional)	
 
*/
function iTabsControl(ntab,dtab,tnext,tprev,scrollv){
	
	if(!scrollv) scrollv = false;
	var tabs = new MGFX.Tabs(ntab,dtab,{
		autoplay: false,
		transitionDuration:300,
		slideInterval:3000,
		hover:true,
		tabScroll:scrollv,
		simpleStop:false
	});
	
	$$(dtab).forEach(function(tab,index){
		var eNext = tab.getElement('.continuar-pr');
		if(eNext){
		eNext.addEvent('click', function(){
			var tNext = index+1;
			$$(ntab)[tNext].fireEvent("click");
			for(i=0;i<=tNext;i++){
				$$(ntab)[i].addClass('active');
			}
			});
		}
	});
	
	$$(dtab).forEach(function(tab,index){
		var ePrev = tab.getElement('.regresar-pr');
		if(ePrev){
		ePrev.addEvent('click', function(){
			var tPrev = index-1;
			$$(ntab)[tPrev].fireEvent("click")
			for(i=0;i<=tPrev;i++){
				$$(ntab)[i].addClass('active');
			}
			});
		}
	});
}

/*
 
 iTabs function para crear tab para los contenidos del portal
 	@ntab : Clase CSS del titulo de las pestañas.
	@dtab : Clase CSS del elemento que se encarga de envolver el contenido del tab 
	@scrollv : Quita el scroll por default que tiene Tab(valor opcional)	
 */
function iTabs(ntab,dtab,scrollv){

	if( $$(ntab).length > 0 && $$(dtab).length > 0 ){
		if(!scrollv) scrollv = false;
			var tabs = new MGFX.Tabs(ntab,dtab,{
				autoplay: false,
				transitionDuration:300,
				slideInterval:3000,
				tabScroll:scrollv,
				hover:true
			});
		}
}

/*Funcion Slider - formnato 1*/
function format(input) {
    var num = input.toString().replace(/\./g, '');
    if (!isNaN(num)) {
        num = num.toString().split('').reverse().join('').replace(/(?=\d*\,?)(\d{3})/g, "$1,");
        num = num.split('').reverse().join('').replace(/^[\,]/, '');
        return num;
    }
}

/*
 
 selector function nos permite crear un slider para poder seleccionar un valor dentro de un rango especifico 
 
 @nombre :  nombre del selector
 @initValue: valor inicial del rango
 @finalValue: valor final del rango 
 @Incre: incremento que habra entre cada paso
 @stepSelx : para selecionar un paso por defecto.
  
*/

function selector(nombre, initValue, finalValue, Incre, stepSelx) {
    //Definicion de variables generales de funcion
    var nombre;
    var initValue;
    var finalValue;
    var Incre;
    var stepSel = stepSelx || 0;

    if (stepSel == 0) { stepSel == initValue; }
    //Creacion de variables              
    var slider = $(nombre);
    var label = slider.getParent().getElement('.valor-sl');
    var vimg = slider.getElement('.sl-img');
    var steps = Math.round((finalValue - initValue) / Incre);
    var input = slider.getParent().getElement('input');
    var knob = slider.getElement('.knob');
    vimg.set('id', nombre + 'Img');
    var timg = nombre + 'Img';
    
    
   delete mySlider; 
   var mySlider = {}; 
   if(Incre == 0){
	   slider.removeEvents();
	   mySlider  = new Slider(slider, slider.getElement('.knob'), {
	        range: [initValue, finalValue+1],
	        initialStep: stepSel,
	        steps: 1,
	        wheel: false,
	        onChange: function (value) {
	            intText = format(value);
	            $(label).set('text', intText);
	            $(input).set('value', value);
	        },
	   		onComplete:function(){
	  
	   		}
	    });
	   mySlider.detach();
   }else{
	   mySlider  = new Slider(slider, slider.getElement('.knob'), {
        range: [initValue, finalValue],
        initialStep: stepSel,
        steps: steps,
        wheel: true,
        onChange: function (value) {
            intText = format(value);
            $(label).set('text', intText);
            $(input).set('value', value);
        },
   		onComplete:function(){
   			
   		}
    });
   }
}


/*

selector2 function nos permite crear un slider para poder seleccionar un valor dentro de un rango especifico 

	@nombre :  nombre del selector
	@initValue: valor inicial del rango
	@finalValue: valor final del rango 
	@Incre: incremento que habra entre cada paso
	@callback: recibe como parametro una function para que se ejecute cuando esta en el paso final
	@valorDefecto : para selecionar un paso por defecto.
 
*/

function selector2(nombre, initValue, finalValue, Incre, callback, valorDefecto) {
    //Definicion de variables generales de funcion
    callback || (callback = false)

    var slider = $(nombre);
    var label = slider.getParent().getElement('.valor-sl');
    var vimg = slider.getElement('.sl-img');
    var steps = Math.round((finalValue - initValue) / Incre);
    var input = slider.getParent().getElement('input');
    var knob = slider.getElement('.knob');
    vimg.set('id', nombre + 'Img');
    var timg = nombre + 'Img';
    if(valorDefecto == '' ){
    	valorDefecto = initValue;
    }
    
   delete mySlider; 
   mySlider = {}; 
   
	   mySlider  = new Slider(slider, slider.getElement('.knob'), {
        range: [initValue, finalValue],
        initialStep: valorDefecto,
        steps: steps,
        wheel: true,
        onChange: function (value) {
            intText = format(value);
            $(label).set('text', intText+'.00');
            $(input).set('value', value);
            if(callback){
            	if(finalValue != value ){
            		callback();
            	} else {
            		$(label).set('text', intText +'.00 a m\u00E1s');
            	}
            }
        },
   		onComplete:function(value){
   			slider.getElement('.knob').set('title','S/. '+ format(value) +'.00');
   		}
    });
   }


/*

selector3 function nos permite crear un slider para poder seleccionar un valor dentro de un rango especifico 

	@nombre :  nombre del selector
	@initValue: valor inicial del rango
	@finalValue: valor final del rango 
	@Incre: incremento que habra entre cada paso
	@stepSelx : para selecionar un paso por defecto.
	@msg : nos mostrara un mensaje cuando llegue al final del rango.

*/

function selector3(nombre, initValue, finalValue, Incre, stepSelx,msg) {
    //Definicion de variables generales de funcion
    
    var stepSel = stepSelx || 0;
    msg || (msg = false);
    iVal = finalValue+10;

    if (stepSel == 0) { stepSel == initValue; }
    //Creacion de variables              
    var slider = $(nombre);
    var label = slider.getParent().getElement('.valor-sl');
    var vimg = slider.getElement('.sl-img');
    var steps = Math.round((finalValue - initValue) / Incre);
    var input = slider.getParent().getElement('input');
    var knob = slider.getElement('.knob');
    vimg.set('id', nombre + 'Img');
    var timg = nombre + 'Img';
    
    
   delete mySlider; 
   mySlider = {}; 
   if(Incre == 0){
	   mySlider  = new Slider(slider, slider.getElement('.knob'), {
	        range: [initValue, finalValue+1],
	        initialStep: stepSel,
	        steps: 1,
	        wheel: false,
	        onChange: function (value) {
	            intText = format(value);
	            $(input).set('value', value);
	            $(label).set('text', intText + '.00');
	            
	            if(msg && value == iVal ){
	            	slider.getParent('.campos-oblig').addClass('w450')
	            	textSymbol = slider.getParent('.content-slider').getElement('.negra');
	            	textSymbol.set('html',msg + textSymbol.get('html'));
	            }else{
	            	if(slider.getParent('.campos-oblig').hasClass('w450'))slider.getParent('.campos-oblig').removeClass('w450');
	            	textSymbol = slider.getParent('.content-slider').getElement('.negra');
	            	text = textSymbol.get('html').replace(msg,'');
	            	textSymbol.set('html',text);
	            	iVal = finalValue;
	            }
	        },
	   		onComplete:function(){
	  
	   		}
	    });
	   mySlider.detach();
   }else{
	   mySlider  = new Slider(slider, slider.getElement('.knob'), {
        range: [initValue, finalValue],
        initialStep: stepSel,
        steps: steps,
        wheel: true,
        onChange: function (value) {
            intText = format(value);
            $(input).set('value', value);
            $(label).set('text', intText + '.00');
            
            if(msg && value == iVal ){
            	slider.getParent('.campos-oblig').addClass('w450');
            	textSymbol = slider.getParent('.content-slider').getElement('.negra');
            	textSymbol.set('html',msg + textSymbol.get('html'));
            }else{
            	if(slider.getParent('.campos-oblig').hasClass('w450'))slider.getParent('.campos-oblig').removeClass('w450');
            	textSymbol = slider.getParent('.content-slider').getElement('.negra');
            	text = textSymbol.get('html').replace(msg,'');
            	textSymbol.set('html',text);
            	iVal = finalValue;
            }
        },
   		onComplete:function(){
   			
   		}
    });
   }
}

/*

selectorA function nos permite crear un slider para poder seleccionar un valor dentro de un rango especifico 

	@nombre :  nombre del selector
	@data : json array para llenar los valores del selector
	@posicionar : para seleccionar un valor por default
*/


function selectorA(nombre,data,posicionar){

	var atotal,slider,content,label, input,vimg,posicionar;
		atotal = data.length;
		slider = $(nombre);
		content = slider.getParent();
		label = content.getElement('.valor-sl');
		input = content.getElement('input'),
		vimg = slider.getElement('.sl-img');
		vimg.set('id',nombre+'Img');

	var sliderArray = new Slider(slider, slider.getElement('.knob'), {
 			 range: [0, atotal],
			 initialStep: 0,
			 steps: atotal,
			 array: true,
			 varray: data,
			 wheel:true,
			 onChange: function(value){
				  intText = format(value);
				  if(intText-1 >= 0){
					  $(label).set('text',data[intText-1]['etiqueta']);
					  $(input).set('value', data[intText-1]['id']);
				  }
				  else{
					 // sliderArray.set(0);
						$(label).set('text',data[0]['etiqueta']);
						$(input).set('value', data[0]['id']);  
				  }
			 }
	});
	if(!posicionar){
		posicionar=0;
		sliderArray.set(posicionar);
	}else{
		posicionar-=1;
		if(posicionar!=0){
			sliderArray.set(posicionar+1);
		}else{
			sliderArray.set(posicionar);
		}
	}
	$(label).set('text',data[posicionar]['etiqueta']);
	$(input).set('value', data[posicionar]['id']);
}


/* Simuladores */


/*

setSelector function nos permite crear un slider para poder seleccionar un valor dentro de un rango especifico 

@ContentSelector : nombre del contenedor del selector
@sjson :  valorer en formato json para poder configurar al selector 
@symbol :  simbolo que tendra texto del slider $ O S/. segun se lo indiquemos.
@urlImagen : (optional) ruta donde se encuentran las imagenes del slider
@step : (optional) paso que se selecionara

*/




	var  setSelector = function(ContentSelector,sjson, symbol, urlImagen,step){
		
		symbol ||( symbol = false);
		urlImagen ||( urlImagen = '/halcon-theme/images/halcon/');
		step || ( step = false);
		
		var ValSimPer, inicio, fin, incremento, elements, span;
		ValSimPer = JSON.decode(sjson);
		inicio = ValSimPer.inicio.toFloat();
		fin = ValSimPer.fin.toFloat();
		incremento = ValSimPer.incremento.toFloat();
		if(symbol){
			
			var elementParent,sClass, sId,brInvertir,contentHtml;
			
			elementParent = ContentSelector.getParent('.content-slider');
	 		brInvertir = elementParent.getChildren('br#brInvertir');
			sClass = ContentSelector.get('class');
			sId = ContentSelector.get('id');
			
			if(brInvertir.length > 0){
				contentHtml = elementParent.get('html');
				elementParent.set('html',contentHtml);
				ContentSelector = elementParent.getElement('#'+sId);
			}else{
				ContentSelector.dispose();
				ContentSelector = new Element('div',{'id':sId, 'class':sClass}).inject(elementParent);
			} 
								
 			elements = '<div class="sl-left"></div> \
				  <img src="'+ urlImagen +'bkg_slider.jpg" class="sl-img" alt="Destacados Interbank" id="" >\
				  <div class="knob" style="left: 79px;"></div>\
				  <div class="sl-right"></div>';

			span = elementParent.getElement("span.negra");
			span.set("html",symbol);
			
			ContentSelector.set("html",elements); 

		}
		
		if(step){
			selector(ContentSelector,inicio,fin,incremento,step);
		}else{
			selector(ContentSelector,inicio,fin,incremento);
		}
		
	};

	
	/*

	setSelector function nos permite crear un slider para poder seleccionar un valor dentro de un rango especifico. 

	@ContentSelector : nombre del contenedor del selector.
	@sjson :  valorer en formato json para poder configurar al selector.
	@symbol :  simbolo que tendra texto del slider $ O S/. segun se lo indiquemos.
	@urlImagen : (optional) ruta donde se encuentran las imagenes del slider.
	@step : (optional) paso que se selecionara.
	@msg : nos mostrara un mensaje cuando llegue al final del rango.
	
	*/
	
	var  setSelector2 = function(ContentSelector,sjson, symbol, urlImagen,step,msg){
		symbol ||( symbol = false);
		urlImagen ||( urlImagen = '/halcon-theme/images/halcon/');
		step || ( step = false);
		
		var ValSimPer, inicio, fin, incremento, elements, span;
		ValSimPer = JSON.decode(sjson);
		inicio = ValSimPer.inicio.toFloat();
		fin = ValSimPer.fin.toFloat();
		incremento = ValSimPer.incremento.toFloat();
		if(symbol){
			elements = '<div class="sl-left"></div> \
				  <img src="'+ urlImagen +'bkg_slider.jpg" class="sl-img" alt="Destacados Interbank" id="" >\
				  <div class="knob" style="left: 79px;"></div>\
				  <div class="sl-right"></div>';
			span = ContentSelector.getParent(".content-slider").getElement("span.negra");

			
			ContentSelector.set("html",elements);
		}

		if(step){
			selector3(ContentSelector,inicio,fin,incremento,step,msg);
		}else{
			selector3(ContentSelector,inicio,fin,incremento,false,msg);
		}
		
	};



 /*  end Simuladores */





/*options*/

$$('.optiongroup span').addEvent('click',function(){
	
	if(!this.getParent().hasClass("valid['optText']")){
		
	this.getParent().getElements('span').removeClass('active-op');
	this.addClass('active-op');
	var valorOp = this.get('valor');
	this.getParent().getElement('input').set('value',valorOp);

	}
	
});

/*menu*/
$$('.menu-deco').addEvent('mouseenter', function(){
	var divDes = this.getElement('div');
	if(divDes){divDes.setStyle('display','block');
	this.getElement('a').setStyle('color','#000');
	this.getElement('a').setStyle('background','#fff');
	}
});

$$('.menu-deco').addEvent('mouseleave', function(){
	var divDes = this.getElement('div');
	if(divDes){divDes.setStyle('display','none');
	this.getElement('a').setStyle('color','#FFF');
	this.getElement('a').setStyle('background','none');
	}
});

$$('.menu-opts').addEvent('mouseenter', function(){
	$$('.float').setStyle('display','block');
});

$$('.under-menu').addEvent('mouseenter',function(){
	var menuItem = this.getPrevious().getElement('.medio-m') || false;	
	if(menuItem) menuItem.setStyle('color','#000');
});

$$('.under-menu').addEvent('mouseleave',function(){
	var nenuItem = this.getPrevious().getElement('.medio-m') || false;	
	if(nenuItem) nenuItem.setStyle('color',null);
});

$$('.float').addEvent('mouseleave', function(){
	this.setStyle('display','none');
});

/* start form */
	if($$("input").hasClass('textform')){
		$$(".textform").each(function(element){
			if(!element.hasClass("datepiker")){
				if(Browser.ie){
					var placeholder = element.get("placeholder");
					element.set("value",placeholder);
					element.addEvents({
						focus: function(){
							if(placeholder == this.value){
								this.set("value","");
							}
						},
						blur :function(){
							if(this.value.length == 0){
								this.set("value",placeholder);
							}
						}
					});
				}
			}
		});
	}

	if($$("input").hasClass('datepiker')){
		
			$$('input.datepiker').each( function(el){
				
				if(el.hasClass("valid['birthday']")){
					
					var picker = new SlimPicker(el,{
						onChangeDate:function(){
							msg = "Registra una fecha v&aacute;lida.";
					    	var dateTest = el.value.test(/^(0[1-9]|[12][0-9]|3[01])[- \/.](0[1-9]|1[012])[- \/.](19|20)\d\d$/);
					    	if(dateTest){
					    		var dateToCheck, fecha, day, month, year;
					    		fecha = el.value.split('/');
					        	day = fecha[0].toInt();
					        	month = fecha[1].toInt() - 1;
					        	year = fecha[2].toInt();
					        	
					        	dateToCheck = new Date(year,month,day );
					        	dateTest =  ((dateToCheck.getDate() == day) && ((dateToCheck.getMonth()) == month) && (dateToCheck.getFullYear() == year));
					        	
					        	if(dateTest){
					        		msg = "Debes ser mayor de 18 a\u00F1os.";
					        		nowDate = new Date();
					        		nowYear = nowDate.getYear();
					        		nowMonth = nowDate.getMonth();
					        		nowDay = nowDate.getDate();
					        		if(nowYear < 1900)nowYear += 1900;
					        		age = nowYear - year;
					        		if (nowMonth < (month - 1)) age = age - 1;
					        		if (((month - 1) == nowMonth) && (nowDay < day)) age = age - 1;
					        		dateTest = (age > 17 );
					        	}
					    	}
					    	
					    	if(!dateTest){
					    		$('msj_fecNacimiento').set({'html':msg,styles:{'display':'block'}});
					    		el.addClass("wt129error");
					    		el.addClass('text-error');
					    	}else{
					    		$('msj_fecNacimiento').set({styles:{'display':'none'}});
					    		el.removeClass('text-error');
					    		el.removeClass("wt129error");
					    	}
					    	
						}
					});
				}else if(!el.hasClass('nogeneric')){
					var picker = new SlimPicker(el);
				}
				 
			
			});
		
			
		
		
	}


	if($$("input").hasClass('datepikerSmall')){
		$$('input.datepikerSmall').each( function(el){ var picker = new SlimPicker(el,{calendarType:'calendarSmall'}); });
	}

/* end form */

/*tooltips optiongroup*/
$$('.optiongroup span').addEvent('mouseenter', function(){
	var opTitle = this.get('tool');
	if(opTitle){
		var opAncho = (50 - (this.getStyle('width').toInt() / 2)).toInt();
		if(opAncho < 0){
			opAncho = opAncho * -1;
		}
		var opContent = this.get('text');
		var divTooltip = new Element('div',{'class':'tool',styles:{'display':'block','margin':'-45px 0px 0px -'+opAncho+'px !important'},'html':'<div class="sup-tool"></div><div class="medio-tool">'+opTitle+'</div><div class="inf-tool"></div>'});
		divTooltip.inject(this);
	}
});

$$('.optiongroup span').addEvent('mouseleave', function(){
	var opTitle = this.get('tool');
	if(opTitle){
		this.getElement('.tool').dispose();
		//this.getElement('.tool').setStyle('display','none');
	}
});

/*help simuladores*/
$$('.help-pr').addEvent('mouseenter', function(){
	this.getElement('.tool-hel-pr').setStyle('display','block');
});

$$('.help-pr').addEvent('mouseleave', function(){
	this.getElement('.tool-hel-pr').setStyle('display','none');
});
	
$$('.reload-pr').addEvent('mouseenter', function(){
	this.getElement('.tool-hel-pr').setStyle('display','block');
});

$$('.reload-pr').addEvent('mouseleave', function(){
	this.getElement('.tool-hel-pr').setStyle('display','none');
});	

/*help solicitudes*/
$$('.tool').addEvent('click', function(){
	this.getElement('.tool-open').setStyle('display','block');
});

$$('.tool').addEvent('mouseleave', function(){
	this.getElement('.tool-open').setStyle('display','none');
});



/*
carrusel function nos permite crear carrusel de imagnes o elementos   
 
@previous:  nombre de la Clase CSS del boton previus  
@next: nombre de la Clase CSS del boton next
@sthis: elemento precionado this 
  
*/
function carrusel(previous, next,sthis, parent ){

	var elemnet = sthis;
	var elParent = elemnet.getParent().getPrevious();
	var contentUl = elParent.getElement('ul');
	var allLi = elParent.getElements('li');
	var li = elParent.getElement('li');
	var  cantEl = allLi.length;
	var left = li.getSize().x;
	var c = 0;

	allLi.each(function(el,i){
	
		if(elemnet.hasClass(next)){
				if(i == 0){
	
					var liFirstChild =  elParent.getElement('li:first-child');
					var li = liFirstChild.clone().cloneEvents(liFirstChild);
					li.inject(contentUl);
					li.setStyles({'left':left * cantEl,'opacity':0});
					li.setStyle('opacity',1);
					el.tween('left',left);
					liFirstChild.dispose();
				}else{
					var left1 = left * c;
					el.tween('left',left1);
					c = c + 1;
				}
		}else{
			
				if(i == 0){
					var liLastChild =  elParent.getElement('li:last-child');
					var li = liLastChild.clone().cloneEvents(liLastChild);
					li.inject(contentUl,'top');
					li.setStyles({'left':left * -1});
					liLastChild.dispose();
					el.tween('left',left);
					li.tween('left',0);
					c = c + 1;
				}else{
					c = c + 1;
					var left1 = left * c;
					el.tween('left',left1);
				}
			}
	});	
}

/* File  */
if(!Browser.ie6){
	$$('.upload-hide').addEvent("change",function(){
		var src = this.value;
		this.getParent().getElement("div.text-upload").set("html",src);
	});	
}

/*
@MaxLengthText function nos permite limitar la cantidad caracteres dentro de input
@element: elemento al cual se le aplicara la function 
@len: cantidad de caracteres que se permitiran ingresar
*/

function MaxLengthText(element, len) {
    if (element.value.length > len) {
        txt = element.value.substring(0, len);
        element.set("value", txt);
    }
}



//if(Browser.firefox){
//	$$('.btnupload').addEvent("click",function(){
//		var file = this.getParent().getElement('input.hidden');
//		file.click();
//	})
//}

/* Simuladores */
/* 
 
 sizebodystep2 function que nos permite dar el tamaño de un elemento contenedor del perfilador 
 no necesita ningun parametro adicional.
 
 * */
function sizebodystep2() {
	var step1 = $("paso1");
	var step2 = $("paso2");
	var sizeElement = {
		dHeight1 : step1.getStyle("height").toInt(),
		dHeight2 : step2.getStyle("height").toInt(),
		dHeightStep2  : step2.getElement(".body").getStyle("height").toInt()
	};
	var theight1 = sizeElement.dHeightStep2 - (sizeElement.dHeight2 - sizeElement.dHeight1);
	step2.getElement('.body').setStyle("height",theight1 + 'px');
}

/* 

sizebodystep3 function que nos permite dar el tamaño de un elemento contenedor del perfilador 
no necesita ningun parametro adicional.

*/

function sizebodystep3() {
	var step1 = $("paso1");
	var step2 = $("paso2");
	var step3 = $("paso3");
	var sizeElement = {
		dHeight1 : step1.getStyle("height").toInt(),
		dHeight2 : step2.getStyle("height").toInt(),
		dHeight3 : step3.getStyle("height").toInt(),
		dHeightStep2  : step2.getElement(".body").getStyle("height").toInt(),
		dHeightStep3  : step3.getElement(".body").getStyle("height").toInt()
	};

	var theight1 = sizeElement.dHeightStep2 - (sizeElement.dHeight2 - sizeElement.dHeight1);
	var theight3 = sizeElement.dHeightStep3 - (sizeElement.dHeight3 - sizeElement.dHeight1);
	step2.getElement('.body').setStyle("height",theight1 + 'px');
	step3.getElement('.body').setStyle("height",theight3 + 'px');
}

$$(".item em").each(function(el){
	var span = el.getNext("span");
	var box = span.getStyle("padding-top").toInt() + span.getStyle("padding-bottom").toInt() + span.getStyle("height").toInt();
	if( box > 32){
	  el.setStyle("height",box+"px");
	  el.getChildren("img").setStyle("margin-top","10px");
	}

	el.getParent().addEvent("click",function(){
	   $$(".item .text").setStyle('background','#ffffff');
	   var val = el.get('val');
	   var opt = $('opt');
	   opt.set('value',val);
	   el.getNext().setStyle('background','#ccf0de');
	});
});

function ordenar(data){
	data.sort(function (obj1, obj2) {
		return obj1.orden < obj2.orden ? -1 :
		(obj1.orden > obj2.orden ? 1 : 0);
	});
}

/* 

upOptionGroup function que nos permite crear un elemento option con mejor apariencia visual que el tradiconal option de HTML
@data : json en formato array  
@sNameHidden :  nombre del elemento (input.hidden)que contendra el valor. 
@contentOption : nombre del contenedor del option. 
@step : selecionar un option por default.
@offOption : nos permite apagar los options no seleccionados.

*/

function upOptionGroup(data ,sNameHidden, contentOption,step,offOption,offtooltip,offclick){

	step || (step = false);
	offOption || (offOption = false);
	offtooltip || (offtooltip = false);
	offclick || (offclick = false);
	//ordenar(data);
	var	bValue = false,
		nameText = sNameHidden+'Text',
		hidden = '<input type="hidden" id="'+ sNameHidden +'" name="'+ sNameHidden +'" class="hiddenID" value="">',
		hiddenText = '<input type="hidden" id="'+ nameText +'" name="'+ nameText +'" class="hiddenText" value="">',
		inputText = hidden+hiddenText;
	
	
	$(contentOption).set('html',inputText);
	//$(contentOption).set('html',hiddenText);
	data.each(function(row){

		if(bValue)
			var spr =  new Element( 'div',{'class':'separador-op'}).inject($(contentOption));
		
		if(!offtooltip){
			if(row.etiqueta.contains('<br>') || row.etiqueta.contains('<br />') ){
				var opt =  new Element( 'span',{'valor':row.id, 'tool':row.tool, 'data-text':row.etiqueta, 'class':'dos-lineas-op', 'html':row.etiqueta}).inject($(contentOption));
				//var displayOpt = new Element('div',{'class':'both'}).inject($(contentOption));
			}else{
				var opt =  new Element( 'span',{'valor':row.id, 'tool':row.tool, 'data-text':row.etiqueta, 'html':row.etiqueta}).inject($(contentOption));
				//var displayOpt = new Element('div',{'class':'both'}).inject($(contentOption));
			}
		}
		
		if (step) {
			if(row.id == step){
				opt.addClass('active-op');
				 if(offclick) opt.addClass('disable-op2');
				 
				$(sNameHidden).value = row.id;
				$(nameText).value = row.etiqueta;
				 
				
			}else if(offOption){
				opt.addClass('disable-op');
			}
		}else{
			if(row.defecto == 1){
				opt.addClass('active-op');
				$(sNameHidden).value = row.id;
				$(nameText).value = row.etiqueta;
			}
		}
		
		

		bValue = true;

		opt.addEvents({
			'click':function(){
				if(!this.hasClass('disable-op') && !this.hasClass('disable-op2')){
					this.getParent().getElements('span').removeClass('active-op');
					this.addClass('active-op');
					var valorOp = this.get('valor');
					var valorOpText = this.get('data-text');
					
					this.getParent().getElement('input.hiddenID').set('value',valorOp);
					this.getParent().getElement('input.hiddenText').set('value',valorOpText);
				}
			},
			'mouseenter': function(){
				if(!this.hasClass('disable-op')){
					var opTitle = this.get('tool');
					if(opTitle){
						
						var opAncho = (50 - (this.getStyle('width').toInt() / 2)).toInt();
						if(opAncho < 0){
							opAncho = opAncho * -1;
						}
						
						var opContent = this.get('text');
						var divTooltip = new Element('div',{'class':'tool',styles:{'display':'block','margin':'-60px 0px 0px -'+opAncho+'px','top':'0','left':'0','position':'absolute','z-index':'90'},'html':'<div class="sup-tool"></div><div class="medio-tool">'+opTitle+'</div><div class="inf-tool"></div>'});
						divTooltip.inject(this);
						var sizeHeight = divTooltip.getStyle('height').toInt();
						if (Browser.ie6){
							if(sizeHeight < 35){
							divTooltip.setStyle('margin','-40px 0px 0px -'+(opAncho)+'px');
							}
						}else{
							if(sizeHeight < 26){
								divTooltip.setStyle('margin','-40px 0px 0px -'+(opAncho)+'px');
								}
						}
						var textOpt = this.get('html');
						this.set('html','');
						this.set('html',textOpt);
						this.setStyle('text-align','center');
					}
				}
			},
			'mouseleave' : function(){
				if(!this.hasClass('disable-op')){
					var opTitle = this.get('tool');
					if(opTitle){
						this.getElements('.tool').dispose();
						//this.getElement('.tool').setStyle('display','none');
					}
				}
			}
		})
	});
}


/* 

upOptionGroup2 function que nos permite crear un elemento option con mejor apariencia visual en formato vertical que el tradiconal option de HTML
@data : json en formato array 
@sNameHidden :  nombre del elemento (input.hidden)que contendra el valor. 
@contentOption : nombre del contenedor del option. 

*/

function upOptionGroup2(data ,sNameHidden, contentOption){

	//ordenar(data);
	var bullets, hidden,option,text;
	
	bValue = false;
	bullets = new Array ('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
		
	hidden = '<input type="hidden" class="hiddenID" id="'+ sNameHidden +'" name="'+ sNameHidden +'" value="">';
	text = '<input type="hidden" class="hiddenText" id="'+ 'text'+sNameHidden +'" name="'+'text'+ sNameHidden +'" value="">';
	
	$(contentOption).set('html',hidden+text);
	
	data.each(function(row, i){
			var div =  new Element( 'div',{'class':'simulador-opts'}).inject($(contentOption));	
			if(row.etiqueta.contains('<br>') || row.etiqueta.contains('<br />') ){
				option =  '<a href="#"> \
					<span class="simulador-opts-first-det">' + bullets[i] +  '</span> \
					<span class="simulador-opts-sec-det dos-lineas-op margintop2" valor="'+ row.id +'" >' + row.etiqueta + '</span>  \
				</a>';
			}else{
				option =  '<a href="#"> \
					<span class="simulador-opts-first-det">' + bullets[i] +  '</span> \
					<span class="simulador-opts-sec-det" valor="'+ row.id +'" >' + row.etiqueta + '</span>  \
				</a>';
				
			}
			div.set('html',option);	
			div.addEvent('click', function(){
				var iValue;
				$(contentOption).getElements('div.simulador-opts').removeClass('active');
				div.addClass('active');
				iValue = div.getElement('.simulador-opts-sec-det').get('valor');
				iText = div.getElement('.simulador-opts-sec-det').get('html');
				$(contentOption).getElement('input.hiddenID').set('value', iValue);
				$(contentOption).getElement('input.hiddenText').set('value', iText);
			});
	});
}


/* 

getdata function que nos permite cargar dropdown 
@surl : hara un request a url de donde obtendra json en formato array
@sNameHidden :  nombre del elemento (input.hidden)que contendra el valor. 
@contentOption : nombre del contenedor del option. 

esta function invoca dropdownA pasando los mismos valores para que invoque al plugin moodropdown

*/

function getdata(surl, inputHidden, content){
	var json = new Request.JSON({
		method : 'post',
		url : surl,
		 async: false,
		 noCache : true,
		//data : param,
		onComplete : function(data) {
		    dropdownA(data,inputHidden,content);
		}
	});
	json.send();	
}

function dropdownA(data,sNameHidden,contentDropdown){
	var dropdown = new moodropdown($(contentDropdown),{'data':data,'nameHiden': sNameHidden});
}

/*

getdata2 function que nos permite cargar dropdown 
@surl : hara un request a url de donde obtendra json en formato array
@sNameHidden :  nombre del elemento (input.hidden)que contendra el valor. 
@contentOption : nombre del contenedor del option. 

esta function invoca dropdownA2 pasando los mismos valores para que 
invoque al plugin moodropdown el cual devolvera objecto creado por moodropdown

*/

 

function getdata2(surl, inputHidden, content){
	var cbo = null;
	var json = new Request.JSON({
		method : 'post',
		url : surl,
		 async: false,
		 noCache : true,
		//data : param,
		onComplete : function(data) {
			cbo = dropdownA2(data,inputHidden,content);
		}
	});
	json.send();
	return cbo;
}

/*

getdata3 function que nos permite cargar dropdown 
@surl : hara un request a url de donde obtendra json en formato array
@sNameHidden :  nombre del elemento (input.hidden)que contendra el valor. 
@contentOption : nombre del contenedor del option. 
@selectedValue: 
esta function invoca dropdownA2 pasando los mismos valores para que 
invoque al plugin moodropdown el cual devolvera objecto creado por moodropdown

*/



function getdata3(surl, inputHidden, content,selectedValue){
	var cbo = null;
	var json = new Request.JSON({
		method : 'post',
		url : surl,
		 async: false,
		 noCache : true,
		//data : param,
		onComplete : function(data) {
			cbo = dropdownB2(data,inputHidden,content,selectedValue);
		}
	});
	json.send();
	return cbo;
}

function getdata4(surl, callback){
	var json;
	json = new Request.JSON({
		method : 'post',
		url : surl,
		 async: false,
		 noCache : true,
		onComplete : function(data) {
			callback(data);
		}
	}).send();
}


function getdata5(surl, inputHidden, content,selectedValue){
	var cbo = null;
	var json = new Request.JSON({
		method : 'post',
		url : surl,
		 async: false,
		 noCache : true,
		//data : param,
		onComplete : function(data) {
			var item = data['0'];
			data.splice(0,1);
			data = data.sort(dynamicSort("etiqueta"));
			data.splice(0,0,item);
			cbo = dropdownA2(data,inputHidden,content);
		}
	});
	json.send();
	return cbo;
}


function dropdownA2(data,sNameHidden,contentDropdown){
	$(contentDropdown).set("html","");	
	//capitalizarFrase(data,"etiqueta");
	var dropdown = new moodropdown($(contentDropdown),{'data':data,'nameHiden': sNameHidden});
	return dropdown;
}

function dropdownB2(data,sNameHidden,contentDropdown,selectedValue){
	$(contentDropdown).set("html","");	
	//capitalizarFrase(data,"etiqueta");
	var dropdown = new moodropdown($(contentDropdown),{'data':data,'nameHiden': sNameHidden, 'selectedValue':selectedValue});
	return dropdown;
}


function capitalizarFrase(data,campo){	
	for(var i=0 ; i<data.length ; i++){
		var s = data[i];
		var c = s[campo];
		c = c.split(" ");
		var strtotal=capitalizarPalabra(c);
		s[campo] = strtotal.trim();  
	}	
}

function capitalizarPalabra(c){
	 var strtotal="";
	  for(var j = 0 ; j < c.length ; j++){
	    var str = c[j].toLowerCase().trim();
	    
	    if(str=='dni'){
	    	str = str.toUpperCase();
	    }
	    
	    if(str.length>1){
	      str  = str.substring(0,1).toUpperCase() + str.substring(1);
	    }
	    strtotal += str + " ";    
	  }
	  return strtotal;
}

function filtrarJson(method,url,atributo,inputHidden,combo,filtro){
	var cb = null;
	var jsonRequestp = new Request.JSON({
		method : method,
		url : url,
		data : {},
		async: false,
		noCache : true,
		onComplete : function(response) {
			var listTemp = [];
			response.each(function(item) {
				if (item[atributo] == undefined || item[atributo] == 0) {
					listTemp.push(item);
				}
				if (item[atributo] == filtro){
					listTemp.push(item);
				}				
			});
			cb = dropdownA2(listTemp, inputHidden , combo );
			
		}
	});
	jsonRequestp.send();
	return cb;
}

function filtrarJson2(method,url,atributo,inputHidden,combo,filtro,selectedValue){
	var cb = null;
	var jsonRequestp = new Request.JSON({
		method : method,
		url : url,
		data : {},
		async: false,
		noCache : true,
		onComplete : function(response) {
			var listTemp = [];
			response.each(function(item) {
				if (item[atributo] == undefined || item[atributo] == 0) {
					listTemp.push(item);
				}
				if (item[atributo] == filtro){
					listTemp.push(item);
				}				
			});
			cb = dropdownB2(listTemp, inputHidden , combo,selectedValue );
			
		}
	});
	jsonRequestp.send();
	return cb;
}

function filtrarJson3(method,url,atributo,inputHidden,combo,filtro){
	var cb = null;
	var jsonRequestp = new Request.JSON({
		method : method,
		url : url,
		data : {},
		async: false,
		noCache : true,
		onComplete : function(response) {
			var listTemp = [];
			response.each(function(item) {
				if (item[atributo] == undefined || item[atributo] == 0) {
					listTemp.push(item);
				}
				if (item[atributo] == filtro){
					listTemp.push(item);
				}				
			});
			
			var item = listTemp['0'];
			listTemp.splice(0,1);
			listTemp = listTemp.sort(dynamicSort("etiqueta"));
			listTemp.splice(0,0,item);
			
			cb = dropdownA2(listTemp, inputHidden , combo );
			
		}
	});
	jsonRequestp.send();
	return cb;
}

/************************/
/******JS ADICIONALES***/
/**********************/

function carruselImagenes(sclass){
	var element, elementsLi;

	for(i = 0, len = $$(sclass).length; i < len; i++ ){
		element = $$(sclass)[i];
		elementsLi = element.getElement('ul').getChildren('li');
		if( elementsLi.length > 1  ){
			var xgallery = $$(sclass).getElement('li').toString() || false;
			if( xgallery ){
				var gallery5 = new fadeGallery($$(sclass), {
					speed: 800,
					paging: true,
					autoplay: true,
					duration: 4000
				});
				}
		}else{
			continue
		}
	}
}

carruselImagenes('.gallery5');

iTabs('.tab-dp1','.staff-dp');
/**Para los contenidos web*/
iTabs('.tab-dp','.feature-dp', true);


var Chain = function() {

        var _listeners = {},
                _resultOfPreviousFunc = null,
                _self = this,
                _api = {},
                _funcs = [],
                _errors = [];

        var on = function(type, listener) {
                if(!_listeners[type]) _listeners[type] = [];
                _listeners[type].push(listener);
                return _api;
        }
        var off = function(type, listener) {
                if(_listeners[type]) {
                        var arr = [];
                        for(var i=0; f=_listeners[type][i]; i++) {
                                if(f !== listener) {
                                        arr.push(f);
                                }
                        }
                        _listeners[type] = arr;
                }
                return _api;
        }
        var dispatch = function(type, param) {
                if(_listeners[type]) {
                        for(var i=0; f=_listeners[type][i]; i++) {
                                f(param, _api);
                        }
                }
        }
        var run = function() {
                if(arguments.length > 0) {
                        _funcs = [];
                        for(var i=0; f=arguments[i]; i++) _funcs.push(f);
                        var element = _funcs.shift();
                        if(typeof element === 'function') {
                                element(_resultOfPreviousFunc, _api);
                        } else if(typeof element === 'object' && element.length > 0) {
                                var f = element.shift();
                                f.apply(f, element.concat([_api.next]));
                        }
                        
                } else {
                        dispatch("done", _resultOfPreviousFunc);
                }
                return _api;
        }
        var next = function(res) {
                _resultOfPreviousFunc = res;
                run.apply(_self, _funcs);
        }
        var error = function(err) {
                if(typeof err != 'undefined') {
                        _errors.push(err);
                        return _api;
                } else {
                        return _errors;
                }                
        }
        var process = function() {
                if(arguments.length > 0) {
                        // on method
                        if(arguments.length === 2 && typeof arguments[0] === 'string' && typeof arguments[1] === 'function') {
                                on.apply(self, arguments);
                        // run method
                        } else {
                                run.apply(self, arguments);
                        }
                }
                return process;
        }

        _api = {
                on: on,
                off: off,
                next: next,
                error: error
        }
        
        return process;

};

$$(".antes , .despues").addEvent("click",function(e){
	e.preventDefault();

	var validate = ($('bCarrusel') == undefined) ? new Element('input', {'type': 'hidden','id': 'bCarrusel','value': '1'}).inject($(document.body)) : $('bCarrusel')
    var bValue = validate.value;
	
	if(bValue == '1'){
		var elParent = this.getParent().getPrevious();
		var contentUl = elParent.getElement('ul').getChildren('li').length;
		$('bCarrusel').set('value','0');
		var thist = this;
		Chain()(
			function(res, chain) {
				carrusel('antes','despues',thist);
				chain.next();
			},
			function(res, chain) {
				$('bCarrusel').set('value','1');
				chain.next();
			}
		);	
	}
	
});






/**Evento del buscador*/
$$('.buscador-btn').addEvent("click",function(){
	var keyword = $('search').get('value');
	location.href="/buscador?keywords="+encodeURI(keyword);
});

if($('search')){
	$('search').addEvent("keydown",function(e){
		if(e.key == 'enter'){
			var keyword = $('search').get('value');
			location.href="/buscador?keywords="+encodeURI(keyword);
		}
	});
}



/**Evento del itab trabajaconNosotros*/
$$('.sldexe').each(function(content){
	var pseudocodigo = '#' + content.get('id') + ' li';
	$$(pseudocodigo).each(function(el,i){
		var size = el.measure(function(){ return this.getSize().x; });
		var left = size * i;
		el.setStyle('left',left);
	});
});

$$(".bgsldeje ul li").addEvents({
	'mouseover':function(){
		var el = this;
		el.getElement('.acolor').setStyle('z-index','21');
		el.getElement('.ttcom').setStyle('display', 'block');
	},
	'mouseout':function(){
		var el = this;
		el.getElement('.acolor').setStyle('z-index','10')
		el.getElement('.ttcom').setStyle('display', 'none');
	}
});

/****************************/

function loadform(){
var heightTotal = window.getScrollSize().y+1000;
		$$(".procesandobg").setStyle('height',heightTotal);
		$$(".procesandobg").setStyle('display','block');
		$$(".procesando").setStyle('display','block');
}

function closeloadform(){
		$$(".procesandobg").setStyle('display','none');
		$$(".procesando").setStyle('display','none');
}


function getdatacombo(surl, inputHidden, content,step,offOption,offtooltip,offclick){
	var json = new Request.JSON({
		method : 'post',
		url : surl,
		 async: false,
		//data : param,
		onComplete : function(data) {
			$(content).set("html","");
			upOptionGroup(data ,inputHidden, content,step,offOption,offtooltip,offclick);
		}
	});
	json.send();
}


function upOptionGroupVertical(surl, inputHidden, content){
		var json = new Request.JSON({
			method : 'post',
			url : surl,
			 async: false,
			//data : param,
			onComplete : function(data) {
				$(content).set("html","");
				upOptionGroup2(data ,inputHidden, content);
			}
		});
		json.send();
}

Asset.javascripts = function(sources, options) {
    // load an array of js dependencies and fire events as it walks through
    options = Object.merge({
        onComplete: Function.from,
        onProgress: Function.from
    }, options);
    var counter = 0, todo = sources.length;

    var loadNext = function() {
        if (sources[0])
            source = sources[0];

        Asset.javascript(source, {
            onload: function() {
                counter++;
                options.onProgress.call(this, counter, source);
                sources.erase(source);

                if (counter == todo)
                    options.onComplete.call(this, counter);
                else
                    loadNext();
            }
        });
    };

    loadNext();
};

$$('.textform').addEvent('paste',function(){
	/*return false;*/
});

function replaceYoutubeViewIE6(idContenedor,ancho,alto){
	if($(idContenedor)){	
	var idVideo = $(idContenedor).get('data-video');  
	if (Browser.ie6){
		$(idContenedor).set('html','<img src="http://img.youtube.com/vi/'+idVideo+'/0.jpg" width="'+ancho+'" height="'+alto+'">');
		}
	}
}


function iTabsHome(ntab,dtab,scrollv,tiempo){
	tiempo || (tiempo = 5000);
    if( $$(ntab).length > 0 && $$(dtab).length > 0 ){
                   if(!scrollv) scrollv = false;
                                   var tabs = new MGFX.Tabs(ntab,dtab,{
                                                   autoplay: true,
                                                   transitionDuration:100,
                                                   slideInterval:tiempo,
                                                   tabScroll:scrollv,
                                                   hover:true
                                   });
                   }
}

function goURL(url){
	var referLink = document.createElement('a');
	referLink.href = url;
	document.body.appendChild(referLink);
	if(!Browser.safari){
		referLink.click();
	}else{
		simulatedClick(referLink);
	}
}		



function simulatedClick(target, options) {

            var event = target.ownerDocument.createEvent('MouseEvents'),
                options = options || {};

            //Set your default options to the right of ||
            var opts = {
                type: options.type                  || 'click',
                canBubble:options.canBubble             || true,
                cancelable:options.cancelable           || true,
                view:options.view                       || target.ownerDocument.defaultView, 
                detail:options.detail                   || 1,
                screenX:options.screenX                 || 0, //The coordinates within the entire page
                screenY:options.screenY                 || 0,
                clientX:options.clientX                 || 0, //The coordinates within the viewport
                clientY:options.clientY                 || 0,
                ctrlKey:options.ctrlKey                 || false,
                altKey:options.altKey                   || false,
                shiftKey:options.shiftKey               || false,
                metaKey:options.metaKey                 || false, //I *think* 'meta' is 'Cmd/Apple' on Mac, and 'Windows key' on Win. Not sure, though!
                button:options.button                   || 0, //0 = left, 1 = middle, 2 = right
                relatedTarget:options.relatedTarget     || null
            };

            //Pass in the options
            event.initMouseEvent(
                opts.type,
                opts.canBubble,
                opts.cancelable,
                opts.view, 
                opts.detail,
                opts.screenX,
                opts.screenY,
                opts.clientX,
                opts.clientY,
                opts.ctrlKey,
                opts.altKey,
                opts.shiftKey,
                opts.metaKey,
                opts.button,
                opts.relatedTarget
            );

            //Fire the event
            target.dispatchEvent(event);
}

function dynamicSort(property) {
    var sortOrder = 1;
    if(property[0] === "-") {
        sortOrder = -1;
        property = property.substr(1);
    }
    return function (a,b) {
        var result = (a[property] < b[property]) ? -1 : (a[property] > b[property]) ? 1 : 0;
        return result * sortOrder;
    }
}