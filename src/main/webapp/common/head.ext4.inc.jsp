<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>


<link rel="stylesheet" href="${ctx}/common/jslibs/extjs/ext-4.2.1/resources/css/ext-all.css" type="text/css"/>
<link rel="stylesheet" href="${ctx}/common/css/customer.ext.css" type="text/css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/common/css/ext-ie-patch.css">
<script type="text/javascript" src="${ctx}/common/jslibs/extjs/ext-4.2.1/ext-all.js"></script>
<script type="text/javascript" src="${ctx}/common/jslibs/extjs/ext-4.2.1/locale/ext-lang-zh_CN.js"></script>

<script type="text/javascript" src="${ctx}/common/public/ztesoft/override/CustomExtDataProxyAjax.js"></script>
<script type="text/javascript" src="${ctx}/common/public/ztesoft/override/CustomExtFormFieldBase.js"></script>
<script type="text/javascript" src="${ctx}/common/public/ztesoft/override/CustomExtFormFieldTrigger.js"></script>
<script type="text/javascript" src="${ctx}/common/public/ztesoft/common/WEBConstants.js"></script>
<script type="text/javascript" src="${ctx}/common/public/ztesoft/common/StrConstants.js"></script>
<script type="text/javascript" src="${ctx}/common/public/ztesoft/common/ExtValidator.js"></script>
<script type="text/javascript" src="${ctx}/common/public/ztesoft/common/ExtUtils.js"></script>
<script type="text/javascript" src="${ctx}/common/public/ztesoft/common/Persistent.js"></script>
<script type="text/javascript" src="${ctx}/common/public/ztesoft/common/Extend.js"></script>


<script type="text/javascript" src="${ctx}/common/jslibs/jquery/jquery-1.9.0.js"></script>


<script type="text/javascript">
    
    //Ext文件路径映射
    Ext.Loader.setConfig({
        enabled : true,
        disableCaching : true,
        paths : {
        	// 各项目中，按大模块划分下层目录，再划分MVC，包含model、store、view、action、controller、busiz等
            'component' : webRoot,
            'Ext.ux' : webRoot + 'common/jslibs/extjs/ext-4.2.1/examples/ux',
            
            // 框架提供的组件
            'ZTEsoft' : webRoot + 'common/public/ztesoft'
        }
    });

    // 分页数据结构，前台store中统一使用
    ztesoft_pageReader = {
        // 数据格式为json
        type : 'json',
        // 记录属性
        root : WEBConstants.PAGE_ROOT,
        // 获取数据总数
        totalProperty : WEBConstants.PAGE_TOTAL
    };
    


    
    // 引入xtype
    Ext.require([
            'ZTEsoft.form.EditForm','ZTEsoft.form.field.TextButtonField','ZTEsoft.form.field.ComboBox',
            'ZTEsoft.button.AddButton', 'ZTEsoft.button.EditButton', 'ZTEsoft.button.DelButton',
            'ZTEsoft.form.field.ClearTextField', 
            'ZTEsoft.form.field.TextButtonField', 'ZTEsoft.form.field.DateTimeField'
            ]);
    
</script>

<script type="text/javascript">
    Ext.onReady(function() {
        // 浮动信息提示
        Ext.QuickTips.init(); 
        Ext.BLANK_IMAGE_URL = '${ctx}/common/jslibs/extjs/ext-4.2.1/resources/ext-theme-access/images/tree/s.gif';
        // 表单校验不过时候的提示信息：放在输入框底部红框
        Ext.form.Field.prototype.msgTarget = 'qtip';
    });
//-->
</script>


<script type="text/javascript">
function fullScreen() {
    var el = document.documentElement,
        rfs = el.requestFullScreen || el.webkitRequestFullScreen || el.mozRequestFullScreen || el.msRequestFullScreen,
        wscript;
 
    if(typeof rfs != "undefined" && rfs) {
        rfs.call(el);
        return;
    }
 
    if(typeof window.ActiveXObject != "undefined") {
        wscript = new ActiveXObject("WScript.Shell");
        if(wscript) {
            wscript.SendKeys("{F11}");
        }
    }
}
 
function exitFullScreen() {
    var el = document,
        cfs = el.cancelFullScreen || el.webkitCancelFullScreen || el.mozCancelFullScreen || el.exitFullScreen,
        wscript;
 
    if (typeof cfs != "undefined" && cfs) {
      cfs.call(el);
      return;
    }
 
    if (typeof window.ActiveXObject != "undefined") {
        wscript = new ActiveXObject("WScript.Shell");
        if (wscript != null) {
            wscript.SendKeys("{F11}");
        }
  }
}
</script>