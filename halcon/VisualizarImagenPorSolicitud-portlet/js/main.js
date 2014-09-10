window.addEvent("domready",function(){
	$$('a.boton').set({"html":'Volver a la Solicitud','href':'javascript:void(0)','title':'Volver a la Solicitud'});
	$$('.boton').addEvent('click',function(e){
		e.preventDefault();
		$(parent.document.body).getElement('#mbox-close').fireEvent('click');
	});
});