<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理平台登录</title>
<%@ page language="java" import="java.text.*,java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx }/portal/resource/theme/blue/css/login.css">
<script type="text/javascript">
if(window.top!=window){
    window.top.location.href=ctx+'/portal/login.jsp';
}
</script>
<script src="${ctx}/common/jslibs/jquery/jquery-1.9.0.js"></script>
<script src="${ctx}/common/jslibs/jquery/jquery.cookie.js"></script>
<script src="${ctx}/common/jslibs/jquery/jquery.json-2.2.js"></script>
<script src="${ctx}/common/jslibs/jquery/md5.js"></script>
<script data-main="${ctx}/portal/loginApp" src="${ctx}/common/jslibs/amd/require.js"></script>
<!--[if lt IE 9]>
<script src="${ctx}/portal/loginApp/css3-mediaqueries.js"></script>
<![endif]-->
<!--[if IE 6]>
<script src="${ctx}/portal/loginApp/DD_belatedPNG.js"></script>
<script>DD_belatedPNG.fix('img,.logo,#login,#help')</script>
<style>.cbox li img,.cbox li.icon_7 img,.cbox li.icon_10 img,.cbox li.icon_14 img{width:auto;height:auto}</style>
<![endif]-->
</head>
<body>
    <img src="${ctx}/portal/resource/theme/blue/images/bg.jpg" width="100%" height="100%" style="position:absolute;z-index:1;left:0;top:0" />
    <div class="main">
        <div class="logo"></div>
        <div class="login"><a id="login" href="javascript:void(0)">登录</a><a id="help" href="javascript:void(0)">帮助</a></div>
        <ul class="cbox">
        	<!--  
            <li class="icon_1"><img src="${ctx}/portal/resource/theme/blue/images/icon/xttj.png" /><p>系统体检</p></li>
            <li class="icon_2"><img src="${ctx}/portal/resource/theme/blue/images/icon/zhjk.png" /><p>综合监控</p></li>
            <li class="icon_3"><img src="${ctx}/portal/resource/theme/blue/images/icon/dcc.png" /><p>DCC</p></li>
            <li class="icon_4"><img src="${ctx}/portal/resource/theme/blue/images/icon/ztp.png" /><p>ZTP</p></li>
            <li class="icon_5"><img src="${ctx}/portal/resource/theme/blue/images/icon/petri.png" /><p>Petri</p></li>
            <li class="icon_6"><img src="${ctx}/portal/resource/theme/blue/images/icon/qxt.png" /><p>企信通</p></li>
            <li class="icon_7"><img src="${ctx}/portal/resource/theme/blue/images/icon/sgw.png" /><p>SGW</p></li>
            <li class="icon_8"><img src="${ctx}/portal/resource/theme/blue/images/icon/tyrz.png" /><p>统一日志</p></li>
            <li class="icon_9"><img src="${ctx}/portal/resource/theme/blue/images/icon/zfyy.png" /><p>资费预演</p></li>
            <li class="icon_10"><img src="${ctx}/portal/resource/theme/blue/images/icon/sjmh.png" /><p>手机门户</p></li>
            <li class="icon_11"><img src="${ctx}/portal/resource/theme/blue/images/icon/itdx.png" /><p>IT短信</p></li>
            <li class="icon_12"><img src="${ctx}/portal/resource/theme/blue/images/icon/qdf.png" /><p>清道夫</p></li>
            <li class="icon_13"><img src="${ctx}/portal/resource/theme/blue/images/icon/jcws.png" /><p>稽核卫士</p></li>
            <li class="icon_14"><img src="${ctx}/portal/resource/theme/blue/images/icon/ygj.png" /><p>云管家</p></li>
            -->
        </ul>
    </div>
    <div class="copyright">中兴软创科技股份有限公司版权所有 &reg; .</div>
    
    <div class="mask" style="display:none">
        <div class="alert">
            <a class="close" href="javascript:void(0);">关闭</a>
            <ul>
                <li class="user"><input type="text" name="username" placeholder="请输入用户名" autocomplete="off"/></li>
                <li class="psw"><input type="password" name="password" placeholder="登录密码"/></li>
                <li class="code"><input type="text" name="code" placeholder="验证码"/><img class="randCodeImage" src="${ctx}/base/randCodeImage.do?"'+new Date().getTime()+'/></li>
            </ul>
            <div class="error"></div>
            <a class="loginBtn" href="javascript:void(0);">登　录</a>
        </div>
    </div>
    
</body>
</html>