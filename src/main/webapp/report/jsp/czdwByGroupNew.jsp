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
		<style type="text/css">
			.frame_normal_hx {
				margin-top: 5px;
				margin-left: 10px;
				margin-right: 10px;
				margin-bottom: 10px;
				padding-left: 10px;
				padding-right: 10px;
				padding-top: 10px;
				padding-bottom: 10px;
				width: 960px;
			}
			
			.tbl {
				font-size: 12px;
				color: #000;
				table-layout: fixed; /**固定宽度*/
				text-align: center;
				border-collapse: collapse;
				border-top: 1px solid #000;
				border-left: 1px solid #000;
				margin: 5 5 5 5;
			}
		</style>
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

