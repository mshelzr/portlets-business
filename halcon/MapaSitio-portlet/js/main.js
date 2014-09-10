$$('.ico-mapsite').addEvent("click",function(e){
	e.stop(); 
	var h = this.getParent();
	var activated = h.hasClass("activated");
	var content = h.getNext("div");
	if(content != null){
		var height = content.getScrollSize().y;
		if(activated){
			content.setStyle('height',height);
			content.tween("height",0);
			h.removeClass("activated");
		}else{
			h.addClass("activated");
			var myFx = new Fx.Tween(content, {property: 'height'});
			myFx.start(height).chain(function(){ content.setStyle('height','auto');});
		}
	}
});