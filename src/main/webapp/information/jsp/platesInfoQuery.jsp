<%@ page language="java" import="java.text.*,java.util.*"
	pageEncoding="UTF-8"%>

<%@include file="/common/common.inc.jsp"%>

<html>
	<head>
		<title>厦门市人口信息查询服务管理系统 </title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/common/css/info.css">
		<style type="text/css">
		.btnQueryCls {
			line-height: 17px;
			font-family:"Microsoft Yahei";
			font-size: 14px;
			font-style: normal;
			/*font-weight: bold;*/
			color: red;
		}
		
		.btnIndexCls{
			background-image: url(../../common/images/Back_light_48px.png)!important; 
		}
		
		</style>
		<script language="javascript" src="<%=request.getContextPath()%>/lodap/LodopFuncs.js"></script>
		<script type="text/javascript">
			!function($) {
				$.fn.rowspan = function(options) {
					var defaults = {};
					var options = $.extend(defaults, options);
					this.each(function() {
	
						var tds = $(this)
								.find("tbody td:nth-child(" + options.td + ")");
						var current_td = tds.eq(0);
						var k = 1;
						tds.each(function(index, element) {
							if ($(this).text() == current_td.text() && index != 0) {
								k++;
								$(this).remove();
								current_td.attr("rowspan", k);
								current_td.css("vertical-align", "middle");
							} else {
								current_td = $(this);
								k = 1;
							}
						});
	
					})
				}
			}(window.jQuery);
		</script>
		<object id="LODOP_OB"
			classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>
			<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
		</object>
		
		<OBJECT classid="clsid:10946843-7507-44FE-ACE8-2B3483D179B7"
			  id="CVR_IDCard" name="CVR_IDCard" width="0" height="0" >
		</OBJECT>

		<script type="text/javascript"
			src="${ctx}/information/app/PlatesInfoQueryApp.js">
		</script>
		
	</head>
	<body style="width: 100%;height: 100%">
		<input id="thirdPartyZzrkUrl" type="hidden" value="${thirdPartyZzrkUrl}">
		<input id="isDebugId" type="hidden" value="${debug}">
	</body>
</html>

