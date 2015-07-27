var basePath = webRoot+'portal/';
var bodySize ;
var bodywidth;
define(['app/tabpanel'],function (tab) {
	$(".conBox,.mainBox").css({height:$(document.body).height()-128,width:$(document.body).width()})
	$('.mainFrame,.mainFrame iframe').css({width:$('.mainBox').width(),height:$(document.body).height()-167});
	bodywidth = $(document.body).width();
	tab.renderTo($('.conBox'));
	
	$(window).on('resize',function(){
		bodywidth = $(document.body).width();
		$(".conBox,.mainBox").css({height:$(document.body).height()-128,width:$(document.body).width()})
		$('.platformMngPop').css({left:$('.platformMng').offset().left,top:$('.platformMng').offset().top+38});
		$('.mainFrame,.mainFrame iframe').css({width:$('.mainBox').width(),height:$(document.body).height()-167});
	});
});