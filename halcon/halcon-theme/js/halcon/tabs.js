/*
---
script: tabs.js
description: MGFX.Tabs, extension of base class that adds tabs to control the rotater.
authors: Sean McArthur (http://seanmonstar.com)
license: MIT-style license
requires:
 core/1.3.0: [Event, Element.Event, Fx.CSS]
 more/1.3.0.1: [Fx.Elements]
provides: [MGFX.Tabs]
...
*/

//MGFX.Tabs. Copyright (c) 2008-2011 Sean McArthur <http://seanmonstar.com/>, MIT Style License.

if(!window.MGFX) MGFX = {};

MGFX.Tabs = new Class({

	Extends: MGFX.Rotater,

	options: {
		autoplay: false,
		onShowSlide: function(slideIndex) {
			this.tabs.removeClass('active');
			this.tabs[slideIndex].addClass('active');
		},
		simpleStop:true,
		tabScroll:false
	},

	initialize: function(tabs, slides, options){
		this.setOptions(options);
		this.tabs = $$(tabs);
		this.createTabs();
		if(this.options.hash && window.location.hash) {
			this.getHashIndex(options);
		}
		return this.parent(slides,options);
	},

	createTabs: function () {
		var that = this;

		this.tabs.forEach(function(tab,index){
			//need index, thats why theres the forEach
			tab.addEvent('click', function(event){
				if(event != undefined){
					if(that.options.simpleStop) event.preventDefault();	
				}
				
				
				that.showSlide(index);
				that.stop(true);
				var scrollbar = $(document.body).getElements("div.scrollbar");
				//if(that.options.tabScroll){
					scrollbar.each(function(scroll,i){
						//alert(scrollbar[i]);
						if(index == i){
							scrollbar[i].setStyles({'z-index':'79','visibility':'visible'});
							//scrollbar[i].setStyle('z-index','79');
						}else{
							scrollbar[i].setStyles({'z-index':'1','visibility':'hidden'});
							//scrollbar[i].setStyle('z-index','1');
						}
					});
				//}
			});
		});
	}.protect(),

	getHashIndex: function(options) {
		var hash = window.location.hash.substring(1);
		this.tabs.forEach(function(el, index) {
			if(el.get('id') == hash) {
				options.startIndex = index;
			}
		});
	}.protect()

});

if(!window.Tabs) var Tabs = MGFX.Tabs;