var theme = 'blue';
var basePath = webRoot+'portal/resource/theme/'+theme+'/';
define(['login'],function (login) {
	$('.login a,.cbox li').click(function(){login.show();login.isShow=true;});
        function show(){
            if(!login.isShow){
                login.show();
                login.isShow = true;
            }
        }
        show();    
        $(document.body).keydown(function(e){
            show();
            if(e.keyCode==13){
                login.submit();
            }
        });
});