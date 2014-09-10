window.addEvent('domready',function(){
	$('content').addClass('contenido-sol');
	/*Lleno las cabeceras*/
	if($('urlCabeceraVideo')){
		traerCabeceraVideos();
		var idCabeceraActiva=$('idCabeceraActiva').get('value');
		traerDetalleVideo(idCabeceraActiva);
	}
});


function traerCabeceraVideos(){
	
	var urlCabeceraVideo=$('urlCabeceraVideo').get('value');
	var html="";
	var cabeceraVideo=$("cabeceraVideo");
	var snipetVideo=$("snipetVideo").value;
	
	var jsonRequest = new Request.JSON({
		method : 'post',
		url : urlCabeceraVideo,
		noCache : true,
		onComplete : function(response) {
			response.each(function(res) {
				
				
				if(res.isDL>0){
					html+='<li><a onclick="traerDetalleVideo('+res.id+');_gaq.push([\'_trackEvent\', \'Listado de Videos\', \''+res.titulo+'\', \''+snipetVideo+'\']);" href="#" title="'+res.titulo+'" class="tab-dp dlinea" id="cab-'+res.id+'"><span class="dlinea">'+res.titulo.replace(/-/i,"<br />")+'</span> </a></li>';
				}else{
					html+='<li><a onclick="traerDetalleVideo('+res.id+');_gaq.push([\'_trackEvent\', \'Listado de Videos\', \''+res.titulo+'\', \''+snipetVideo+'\']);" href="#" title="'+res.titulo+'" class="tab-dp" id="cab-'+res.id+'">'+res.titulo+'</a></li>';
				}
								
				/*Seteamos la cabecera activa*/
				$('idCabeceraActiva').set('value',res.idCabeceraActiva);
			});
			cabeceraVideo.set("html","");
			cabeceraVideo.set("html",html);
			/*Agregamos el evento  de la cabecera*/
			iTabs('.tab-dp','.feature-dp', true);
		}
	});
	jsonRequest.send();
}

function getSizeTab(){
	var sizeScrollTab = document.getElement('.feature-dp').getScrollSize().y;
	var sizeTab = document.getElement('.feature-dp').getStyle('height').toInt();
	if(sizeScrollTab > sizeTab){
		$$('.scrollbar').setStyles({'z-index':79,'visibility':'visible'});
		$$('.scrollbar').getElement('.knob').setStyle('opacity',1);
		$$('.knob').getElement('.body').setStyle('height',190);
	}
	else{
		$$('.scrollbar').setStyles({'z-index':1,'visibility':'hidden'});
		$$('.scrollbar').getElement('.knob').setStyle('opacity',0);
	}
	}

function traerDetalleVideo(folderId){	

	var urlDetalleVideo=$('urlDetalleVideo').get('value');
	$('detalleVideo').set('html','');

	var jsonRequest = new Request.JSON({
		method : 'post',
		url : urlDetalleVideo,
		data : {folderId:folderId},
		noCache : true,
		onComplete : function(jsonTexto) {
			
			response=jsonTexto.videos;
			
			response.each(function(res,i) {
				var claseBorde="";
				var a = new Element('a',{ "id":"box"+res.id, "href":res.urlPreview,"html":res.titulo,"data-milkbox":"milkbox:g"+(i+1), "data-milkbox-size":"width:720,height:556"});
				
				if(response.length-1==i){claseBorde=" sin-border";}
				
				var li=new Element('li',{"class":"video-v"+claseBorde});
				a.inject(li);	
				
				var ul=$('detalleVideo');
				li.inject(ul);
				
				milkbox.galleries.push(new MilkboxGallery($$("#box"+res.id),{name:"milkbox:g"+res.id,remove_title: false}));
				milkbox.reloadPageGalleries();
				
			
			});
			//Adicionales
			$('videoHTMLHeader').set('html',jsonTexto.videoHTMLHeader);
			$('videoHTMLFooter').set('html',jsonTexto.videoHTMLFooter);	
			getSizeTab();
		}
	});
	jsonRequest.send();
}