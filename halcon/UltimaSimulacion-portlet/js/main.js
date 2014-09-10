window.addEvent("domready",function(){

		if($('vSim')){
			$("vSim").addEvent("click",function(e){
				volverSimular();
			});
		}
	
	function volverSimular(){
		if($('hSim')){
			var urlVSim=$('hSim').value;
			var json = new Request.JSON({
				method : 'post',
				url : urlVSim,
				onComplete : function(data) {
					location.replace(data.url);
				}
			});
			json.send();
			
		}
	}
});

