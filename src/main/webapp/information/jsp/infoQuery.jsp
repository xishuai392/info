<%@ page language="java" import="java.text.*,java.util.*"
	pageEncoding="UTF-8"%>

<%@include file="/common/common.inc.jsp"%>

<html>
	<head>
		<title>人口信息查询  </title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/common/css/info.css">
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
		<script type="text/javascript"
			src="${ctx}/information/app/InfoQueryApp.js">
		</script>
	</head>
	<body>
	</body>
</html>

