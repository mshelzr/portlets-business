/*carga inicial*/
if($$('.scrollbar')){
document.getElements('.scrollbar').setStyles({'visibility':'hidden', 'opacity':'0', 'heigth':'0px', 'overflow':'hidden'});
}

if($$('.tab-dp')[1]){
	$$('.tab-dp')[1].setStyle('display','none');
	if($$('.scrollbar')){
		document.getElements('.scrollbar').setStyles({'visibility':'hidden', 'opacity':'0', 'heigth':'0px', 'overflow':'hidden'});
	}
}

/*activar comparacion*/
$$('.verdes a').addEvent('click',function(){
	$$('.tab-dp')[1].setStyle('display','block');
	$$('.tab-dp')[1].fireEvent('click');
	$$('.verdes').setStyle('display','none');
	
	if($$('.scrollbar')){
		document.getElements('.scrollbar').setStyles({'visibility':'hidden', 'opacity':'0', 'heigth':'0px', 'overflow':'hidden'});
	}
});

/*Coookies*/
if($('simuladorCookieVehicular')){
	createCookie("LFR_COOKIE_SIMULADORES_SIM-VEH", $('simuladorCookieVehicular').value, 30);
}

if($('simuladorCookieDeposito')){
	createCookie("LFR_COOKIE_SIMULADORES_SIM-PF", $('simuladorCookieDeposito').value, 30);
}

if($('simuladorCookiePersonal')){
	createCookie("LFR_COOKIE_SIMULADORES_SIM-PER", $('simuladorCookiePersonal').value, 30);
}

if($('simuladorCookieHipotecario')){
	createCookie("LFR_COOKIE_SIMULADORES_SIM-HIP", $('simuladorCookieHipotecario').value, 30);
}

if($('simuladorCookieFondos')){
	createCookie("LFR_COOKIE_SIMULADORES_SIM-FONDOS", $('simuladorCookieFondos').value, 30);
}

if($('simuladorCookieFondos')){
	
	var id_periodo_select = $('id_periodo_select').value;
	if(id_periodo_select == null || !id_periodo_select)
	{
		id_periodo_select = 1;
	}
	getdatacombo("/GestionParametros-portlet/js/resources/plazo_sim_fondo_mutuo.json","tipoCredito","nav_per_inv",id_periodo_select);
	$('nav_per_inv').addEvent('click',function(){
		var val;
		val = $('nav_per_inv').getElement('input').value;
		
		loadform();
		var url_periodo = $('cambiar_periodo').value;
		var json = new Request.JSON({
			method : 'post',
			url : url_periodo,
			data:{
				periodo:val
			} ,
			onComplete : function(data) 
			{
				
				if(data.flg == '1')
				{
					window.location = document.URL;
				}
				else
				{				
					/*alert("Ocurrio un error de redireccionamiento.");
					window.location = document.URL;*/
				}			
			}
		});
		json.send();
	});
}

function createCookie(name, value, days) {
	var expires = "";
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
        expires = "; expires=" + date.toGMTString();   
    }
     
    document.cookie = name + "=" + value + expires + "; path=/";
}

/*Para redireccionamientos de Solicitud, ficha y volver a simular*/
if($$('.simulaLink')){
	$$('.simulaLink').addEvent('click',function(e){
		e.stop();
		var url = this.get('href');
		volverSimular(url);
	});
	
}

if($$('#download_pdf_fm')){
	$$('#download_pdf_fm').addEvent('click',function(e){
		e.stop();
		var urlImagenChartFree = '';
		if($('urlImagenChart')){
			urlImagenChartFree = $('urlImagenChart').get('src');
		}
		
		var items = $('headerFondosMutuos').getElements('span.RSFM-text');
		var strText = '';
		bValue = false;
		items.each(function(item){
			if(bValue) strText += '|'; 
			strText += item.get('text');
			bValue = true;
		});		
		var data = $('ListadoFondosMutuos').getElements('li');
		var strText3 = '';
		var bcValue = false;
		data.each(function(cols,index){
		if(index != 0)
			{
			if(bcValue) strText3 += '-';
			row = cols.getElements('div');
			var strText2 = '';
			bValue = false;	
			for(i=0, len = row.length; i < len ; i++){
				if(bValue && i != len -1) strText2 += '|';				
				if(i == 0){					
					strText2 += row[0].getElement('a').get('text');						
				}else if(i != len -1 ){
					strText2 += row[i].get('text');
				}
				bValue = true;
			}			
			strText3 += strText2;
			bcValue = true;
			}	
		});	
		
		url_fm = $('crearPDF').value;
		svg = $$('svg').getParent().get('html');		
		loadform();
		var json = new Request.JSON({
			method : 'post',
			url : url_fm,
			data:{
				diseno:svg,
				otro:'123456',
				title:strText,
				datos:strText3,
				urlImagenChart: urlImagenChartFree,
				optionGroup: $('nav_per_inv').getElement('span.active-op').get('html')
			} ,
			onComplete : function(data) 
			{	
				if (Browser.ie8) {
					var urlFinal = $('forzarDescargaPDF').value;
					var urlActual = urlFinal+'&url='+data.url;
					closeloadform();
					location.href = urlActual;
				} else {
					$('simulador_redirect_blank').set("href",data.url);
					$('simulador_redirect_blank').click();
					closeloadform();
				}
			}
		});
		json.send();
	});
}



function volverSimular(url){
	if($('redireccionSimulador')){
		var urlVSim=$('redireccionSimulador').value;
		var tipSim=$('tipSim').value;
		
		var json = new Request.JSON({
			method : 'post',
			url : urlVSim,
			data:{
				url:url,
				tipSim:tipSim
			} ,
			onComplete : function(data) {
				location.replace(data.url);
			}
		});
		json.send();
		
	}
}

/**
 *  Funcion @CrearGraficoFondosMutuos
 *  Permite crear el grafico de simulacion de Fondos Mutuos
 */
function CrearGraficaFondosMutuos(esquema) 
{
	esquema = eval(esquema);	
    var data = google.visualization.arrayToDataTable(esquema);
    var options = {
		titlePosition:'none',
		colors: ['#ff75b0', '#89e0c0', '#fec27c'],
		gridlinescolor: '#235615',
		legend:{position:'none'},
		hAxis:{	title:"",textStyle: {
						color: '#767676', 
						fontSize:'11', 
						fontName:"'Trebuchet MS', Arial, Helvetica, sans-serif"
					},
				gridlines:{color: '#000000'}
		},
		vAxis:{title:"Rentabilidad   ("+$('tipoMoneda').value+")",textStyle: 
				{
					color: '#767676', 
					fontSize:'11', 
					fontName:"'Trebuchet MS', Arial, Helvetica, sans-serif"
				}
			}
    };
	
    var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
    chart.draw(data, options);
 }

if($('urlNuevaVentana')){
	$('urlNuevaVentana').addEvent('click',function(){
		var referLink = document.createElement('a');
		referLink.href = $('urlNuevaVentana').get('href');
		if(!Browser.chrome) referLink.target = '_blank';
		document.body.appendChild(referLink);
		referLink.click();
	});
}
