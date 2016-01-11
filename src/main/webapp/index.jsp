<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 所有引入都放到head.inc.jsp里面 -->
<%@ include file="/common/common.inc.jsp" %>
<html>
<head>
    <title>厦门市人口信息查询服务管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<div id="loading-mask"></div>
<div id="loading">
    <img src="images/loading.gif" width="120" height="120" alt="Loading..."/>

    <p id="msg">资源加载中...</p>
</div>

<script type="text/javascript">
    // 用户session设置
    var userSession = {};
    userSession.userId = '${sessionuser.userId}';
    userSession.userName = '${sessionuser.userName}';
    userSession.userCode = '${sessionuser.userCode}';


    Ext.onReady(function() {
        // 浮动信息提示
        Ext.QuickTips.init();
        // 表单校验不过时候的提示信息：放在输入框底部红框
        Ext.form.Field.prototype.msgTarget = 'qtip';

        // 去除除了input和textarea外的所有默认右键菜单
        Ext.getBody().on('contextmenu', function(e, s) {
            if (s.tagName != 'INPUT' && s.tagName != 'TEXTAREA') {
                e.preventDefault();
            }
        });

        Ext.require("ZTEsoft.main.AmIndex", function() {
            Ext.get('loading').remove();
            Ext.get('loading-mask').fadeOut({remove: true});
            Ext.create("ZTEsoft.main.AmIndex");
        });
    });
</script>
</body>
</html>