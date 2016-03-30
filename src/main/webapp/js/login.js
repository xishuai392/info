/**
 * 显示错误提示信息
 */
function showError(msg) {
    $("#error_text").html(msg);
}

/**
 * 登陆方法
 */
function login() {
    var userCode = $('#userCode').val();
    var password = $('#passWord').val();

    if (userCode == undefined || userCode == "" || userCode == null) {
        showError('请填写用户名!');
        $('#userCode').focus();
        return false;
    }

    if (password == undefined || password == "" || password == null) {
        showError('请填写密码!');
        $('#passWord').focus();
        return false;
    }

    $('#loginForm').submit();

}

jQuery(document).keypress(function() {

    function enter() {
        var event = getEvent();
        if (event.keyCode == 13) {
            login();
        }
    }

    function getEvent() {
        // 同时兼容ie和ff的写法
        if (document.all)
            return window.event;
        var func = getEvent.caller;
        while (func != null) {
            var arg0 = func.arguments[0];
            if (arg0) {
                if ((arg0.constructor == Event || arg0.constructor == MouseEvent) || (typeof(arg0) == "object" && arg0.preventDefault && arg0.stopPropagation)) {
                    return arg0;
                }
            }
            func = func.caller;
        }
        return null;
    }

    enter();
});

jQuery(document).ready(function() {
    function onLoad() {
        var userCode = $('#userCode');
        userCode.focus();
    }

    $('#userCode').delay(100, onLoad);

    $('#loginBtn').click(function(e) {
        login();
    });

    // 插件下载
    $('.h-l-top-nav a').click(function(event) {
        // console.log(arguments);
        // console.log(this);
        var downloadtype = $(this).attr("downloadtype");
        console.log(downloadtype);
        if (1 == downloadtype) {
            // 打印插件下载
        	window.open(ctx + '/lodap/install_lodop32.exe');
        	return;
//            try {
//                var LODOP = getLodop();
//            } catch (err) {
//            	
//            }
            //LODOP = getLodop(document.getElementById('LODOP_OB'), document.getElementById('LODOP_EM'));
        }

        if (2 == downloadtype) {
            // 高拍仪插件下载
            window.open(ctx + '/thirdplugins/DoccameraOcx.rar');
            return;
        }
        
        if (3 == downloadtype) {
            // 高拍仪插件下载
            window.open(ctx + '/thirdplugins/IdCardUsbDriverV2.exe');
            return;
        }
        
        if (4 == downloadtype) {
            // 高拍仪插件下载
            window.open(ctx + '/thirdplugins/CVRDLL.exe');
            return;
        }

        if (5 == downloadtype) {
            // 高拍仪插件下载
            window.open(ctx + '/thirdplugins/jpSetup.exe');
            return;
        }
        	
    });

});