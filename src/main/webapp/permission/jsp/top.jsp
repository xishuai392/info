<%@ page language="java" import="java.text.*,java.util.*"
	pageEncoding="UTF-8"%>

<%@include file="/common/common.inc.jsp"%>
<script type="text/javascript">
function showWin(){
	var aa = window.parent.Ext.ComponentQuery.query('#vp')[0];
	aa.showWin();
	/*var win = new top.Ext.Window({
		height:200,
		width:300,
		title:'my profile',
		constrain:true,
		modal:true,
		plain:true
	});
	win.show();*/
}
</script>
<html>
	<head>
		<base href="<%=basePath%>" target="_parent">
		<style>
			#layout {
				width: 300px;
				height: 200px;
				margin: 0 auto;
				background: #ddd;
				word-break: break-all;
			}
			
			#layout a {
				word-break: keep-all;
				white-space: nowrap;
			}
		</style>
	</head>

	<body>
		<Div class="login_contact">
			<div class="main_head">
				<div class="main_logo"></div>
				<div class="main_rightnav">
					<div class="main_esc" style="margin-top:12px;line-height:40px;height:30px;">
						用户名：<U><a style="cursor:pointer" onClick="showWin()">${ sessionScope.sessionThisUserName}</a></U>
						<%-- 用户名：<a id="topUserName">${ sessionScope.sessionThisUserName}</a> --%>
						<a href="${ctx}/login/loginOut.do" class="main_esc_ico"></a><a href="${ctx}/login/loginOut.do">退出</a>
					</div>
					<div class="main_right_nav">
					<!--  
						<a href="#" class="main_right_nav1"></a>
						<a href="#" class="main_right_nav2"></a>
						<a href="#" class="main_right_nav3"></a>
						<a href="#" class="main_right_nav4"></a>
					-->
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</body>
</html>

