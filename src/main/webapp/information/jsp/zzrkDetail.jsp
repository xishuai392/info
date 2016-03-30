<%@ page language="java" import="java.text.*,java.util.*"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<%@include file="/common/common.inc.jsp"%>

<html>
	<head>
		<title>人口信息查询  </title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/common/css/info.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/common/css/data-view.css">
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
		<!-- 打印驱动 -->
		<object id="LODOP_OB"
			classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>
			<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
		</object>
		
		<!-- 华视电子BS控件V4.0 身份证读卡器 -->
		<OBJECT classid="clsid:10946843-7507-44FE-ACE8-2B3483D179B7"
			  id="CVR_IDCard" name="CVR_IDCard" width="0" height="0" >
		</OBJECT>
		
		
		
		<script type="text/javascript"
			src="${ctx}/information/app/ZzrkDetail.js">
		</script>
		
		<script type="text/javascript" src="${ctx}/information/app/common.js">
		</script>
		
		<style>
			* { margin:0; padding:0; }
			img { vertical-align:bottom; border:none; }
			body { background:#f0f0f0; height:800px; font-family:Arial;}
			ul { list-style:none; }
			h1{ font-size:20px; width:680px; margin:3% auto 5px; color:#202020; }
			h6{ width:680px; margin:0 auto 20px; font-size:12px; font-weight:normal; color:#333; }
			h6 a { color:#09c; }
			ul#gallery { width:660px; margin:0 auto 10px; padding-left:20px; border:1px solid #d3d3d3; background:#fff; overflow:hidden; }
			ul#gallery li { width:200px; height:200px; float:left; margin:20px 20px 20px 0; display:inline; }
			ul#gallery li a.smallimage { background:#333; display:block; width:200px; height:200px; }
			#bigimage { position:absolute; display:none; }
			#bigimage img { width:400px; height:400px; padding:5px; background:#fff; border:1px solid #e3e3e3; }
		</style>


	</head>
	<body >
		<input id="thirdPartyZzrkUrl" type="hidden" value="${thirdPartyZzrkUrl}">
		
		<input id="idCardNum" type="hidden" value="${idCardNum}">
		<input id="bcxrxxId" type="hidden" value="${bcxrxxId}">
		<input id="populationType" type="hidden" value="${populationType}">
		<input id="sqrxxId" type="hidden" value="${sqrxxId}">
		<input id="cxbs" type="hidden" value="${cxbs}">
		
		<div style="width: 100%;height: 100%"></div>
		<div id="doccameraOcx" >
		<!-- 捷易拍DoccameraOcx控件_V3.7.1500802 ----
			<div id="preview_doccamera"  >
				<object classid="clsid:454C18E2-8B7D-43C6-8C17-B1825B49D7DE" id="captrue"  width="480" height="360" ></object>
			</div>
		</div>
		-->
	</body>
</html>

