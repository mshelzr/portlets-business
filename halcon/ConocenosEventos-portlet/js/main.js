window.addEvent("domready",function(){

	$$('.sldexe').each(function(content){
		var pseudocodigo = '#' + content.get('id') + ' li';
		$$(pseudocodigo).each(function(el,i){
			var size = el.measure(function(){ return this.getSize().x; });
			var left = size * i;
			el.setStyle('left',left);
		});
	});

})