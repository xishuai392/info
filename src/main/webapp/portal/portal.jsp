<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理平台主界面</title>
<%@ page language="java" import="java.text.*,java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
	<link rel="stylesheet" type="text/css" href="${ctx }/portal/resource/theme/blue/css/portal.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/common/css/smartMenu.css">
	<script src="${ctx}/common/jslibs/jquery/jquery-1.9.0.js"></script>
	<script src="${ctx}/common/jslibs/jquery/jquery.cookie.js"></script>
	<script src="${ctx}/common/jslibs/jquery/jquery.json-2.2.js"></script>
	<script src="${ctx}/common/jslibs/jquery/jquery.dragsort-0.5.1.min.js"></script>
	<script src="${ctx}/common/jslibs/jquery/jquery-smartMenu.js"></script>
	<script src="${ctx}/common/jslibs/jquery/md5.js"></script>
	<script data-main="${ctx}/portal/app" src="${ctx}/common/jslibs/amd/require.js"></script>
	<script type="text/javascript">
		if(window.top!=window){
			window.top.location.href=ctx+'/portal/portal.jsp';
		}
		$.ajaxSetup({
		    contentType:"application/x-www-form-urlencoded;charset=utf-8",
		    complete:function(XMLHttpRequest,textStatus){
		          //通过XMLHttpRequest取得响应头，sessionstatus           
		          var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus"); 
		          if(sessionstatus=="timeout"){
		          	window.top.location.href=ctx+'/main/login.jsp';
		               //window.location.replace(PlanEap.getActionURI("login"));
		       }
		    }
		});
	</script>
	
</head>
<body>
<div class="header">
	<div class="logo"></div>
    <div class="menuSeting"><div>导航个性化订制</div></div>
    <div class="tabpannel">
    	<div class="toleft" style="display:none"></div>
        <div class="tabsbox">
       	  <ul class="tabs"></ul>
        </div>
        <div class="toright" style="display:none"></div>
    </div>
</div>

<div class="conBox">
	<div class="mainBox">
    	<div class="subTabs">
            <div class="sysMenus">
            	<div class="li sysManager"></div>
                <div class="li logout">用户注销</div>
                <div class="li pswChg">修改密码</div>
                <div class="li platformMng">平台管理<div class="arrow"></div></div>
            </div>
        </div>
        <div class="mainFrame"></div>
	</div>
    <div class="leftMenuClose" style="display:none"></div>
</div>

<div class="copyright">中兴软创科技股份有限公司版权所有 &reg; .</div>

<div class="platformMngPop" style="display:none"></div>


<div class="menuSetWindow" style="display:none">
    <div class="closeMenuSet"></div>
	<div class="winTit">拖拽以下图标进行导航个性化订制</div>
    <div class="winCon">
    	<ul class="iconBox showIconBox"></ul>
        <ul class="iconBox willShowIconBox"></ul>
        <a href="javascript:void(0)" class="menuSetOkBtn">确 定</a>
    </div>
</div>
<input name="MenuSortOrder" type="hidden" />

</body>
</html>