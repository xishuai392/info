<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.inc.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统——登陆页面</title>
<link href="${ctx}/common/css/common.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/common/css/style.css" rel="stylesheet"
	type="text/css" />

<style type="text/css">
</style>
</head>


<script type="text/javascript">
	//判断是否是最父级页面
	if (window.top != window.self) {
		window.top.location.href = webRoot + 'login.do';
	};
	function checkUserForm() {
		var userName = Ext.get('username').getValue();
		var userPassword = Ext.get('password').getValue();
		if (userName == "" || userPassword == "") {
			//alert("用户名或密码不能为空");
			ExtUtils.error("用户名或密码不能为空!");
			return false;
		}
		document.loginForm.submit();
	}

	function enter() {
		var event = getEvent();
		if (event.keyCode == 13) {
			return checkUserForm();
		}
		return false;
	}

	function getEvent() {
		//同时兼容ie和ff的写法
		if (document.all)
			return window.event;
		func = getEvent.caller;
		while (func != null) {
			var arg0 = func.arguments[0];
			if (arg0) {
				if ((arg0.constructor == Event || arg0.constructor == MouseEvent)
						|| (typeof (arg0) == "object" && arg0.preventDefault && arg0.stopPropagation)) {
					return arg0;
				}
			}
			func = func.caller;
		}
		return null;
	}

	Ext.onReady(function() {
		//        alert('x');

	});
</script>
<body style="background: #def1f5;" onkeypress="enter()">
	<div class="login_head">
		<div class="login_img">
			<img src="${ctx}/common/images/login/login_07.gif" width="405" height="43" />
		</div>
	</div>
	<form name="loginForm" method="post"
		action="${ctx}/login/loginCheck.do">
		<div class="login_contact">
			<div class="benner_img">
				<div class="benner_login_box">
					<div class="benner_text_box">
						<h3>用户登录</h3>
						<span style="color: yellow; font-size: 12px;">${error}</span>
						<div class="benner_text_iptbox">
							<input id="username" name="userCode" type="text"
								class="benner_text_ipt" />
							<div class="benner_text_people"></div>
						</div>
						<div class="benner_text_iptbox">
							<input id="password" name="password" type="password"
								class="benner_text_ipt" />
							<div class="benner_text_cipher"></div>
						</div>
						<div class="benner_text_butbox">
							<a href="#" class="benner_text_but" onclick="checkUserForm()">登录</a>
						</div>
						<div class="benner_text_textbox">
							<p>
								<a href="#" style="padding-left: 0;">找回密码</a>
								<%--<a href="#">注册用户</a>--%>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	<div class="login_foot">
		<p class="login_foot_nav">
			<a href="#">关于我们</a>| <a href="#">联系我们</a>| <a href="#">服务条款</a>| <a
				href="#">隐私保护</a>| <a href="#">建议反馈</a>| <a href="#">版权声明</a>
		</p>
		<p class="login_foot_ban">Copyrighr © 2004-2012 中兴软创科技股份有限公司 版权所有
		</p>
	</div>
</body>
</html>
