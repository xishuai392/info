<%@page import="com.ztesoft.framework.util.Utils"%>
<%@page import="com.ztesoft.framework.util.JsonUtil"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page   isELIgnored="false"%> 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>  

<%
    String path = request.getContextPath();
    String webRoot = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    String serverName = String.valueOf(request.getServerName());
    String serverPort = String.valueOf(request.getServerPort());
%>
<c:set var="ctx" value="<%=basePath %>" />

<script type="text/javascript">
	//兼容 ie 浏览器
	var console = console || {
	    log : function() {
	        return false;
	    },
	    info:function(){
	    	return false;
	    }
	    ,
	    error:function(){
	    	return false;
	    }
	};
	// 用户session设置
	var userSession = {};
	userSession.userCode = '${sessionUserCode}';
	userSession.userName = '${sessionUserName}';
	userSession.userId = '${sessionuser.userId}';
	
	//console.log(userSession);

	// 项目根路径，用于引用资源等
	webRoot = '${ctx}/';
	ctx = '${ctx}';
	serverName = '${serverName}';
	serverPort = '${serverPort}';
</script>

