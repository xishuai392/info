<%@ page language="java" import="java.text.*,java.util.*"
	pageEncoding="UTF-8"%>

<%@include file="/common/common.inc.jsp"%>

<html>
	<head>
		<title>全局窗口信息查询统计报表  </title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/common/css/info.css">
		<script language="javascript" src="<%=request.getContextPath()%>/lodap/LodopFuncs.js"></script>
		<object id="LODOP_OB"
			classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>
			<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
		</object>
		<script type="text/javascript"
			src="${ctx}/report/app/czdwByGroupNew.js">
		</script>
	</head>
	<body>
	<input id="startDateInitId" type="hidden" value="${startDateInit}">  
	<input id="endDateInitId" type="hidden" value="${endDateInit}">  
	<input id="orgNameInitId" type="hidden" value="${orgName}">  
	<input id="orgCodeInitId" type="hidden" value="${orgCode}">  
	<input id="orgIdInitId" type="hidden" value="${orgId}">  
	
	</body>
</html>

