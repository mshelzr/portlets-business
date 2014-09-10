window.addEvent('domready',function(){	
	
	$$('.error-cont a').addEvent("click",function(){
		irNext();
	});
	
});

function irNext(){
	location.href="/";
}