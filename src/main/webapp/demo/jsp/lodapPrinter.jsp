<%@ page language="java" import="java.text.*,java.util.*"
	pageEncoding="UTF-8"%>

<%@include file="/common/common.inc.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script language="javascript" src="<%=request.getContextPath()%>/lodap/LodopFuncs.js"></script>

<script language="javascript">
	function getLodop11(oOBJECT, oEMBED) {
		/**************************
		  本函数根据浏览器类型决定采用哪个对象作为控件实例：
		  IE系列、IE内核系列的浏览器采用oOBJECT，
		  其它浏览器(Firefox系列、Chrome系列、Opera系列、Safari系列等)采用oEMBED,
		  对于64位浏览器指向64位的安装程序install_lodop64.exe。
		 **************************/
		var strHtmInstall = "<br><font color='#FF00FF'>打印控件未安装!点击这里<a href='install_lodop32.exe'>执行安装</a>,安装后请刷新页面或重新进入。</font>";
		var strHtmUpdate = "<br><font color='#FF00FF'>打印控件需要升级!点击这里<a href='install_lodop32.exe'>执行升级</a>,升级后请重新进入。</font>";
		var strHtm64_Install = "<br><font color='#FF00FF'>打印控件未安装!点击这里<a href='install_lodop64.exe'>执行安装</a>,安装后请刷新页面或重新进入。</font>";
		var strHtm64_Update = "<br><font color='#FF00FF'>打印控件需要升级!点击这里<a href='install_lodop64.exe'>执行升级</a>,升级后请重新进入。</font>";
		var strHtmFireFox = "<br><br><font color='#FF00FF'>注意：<br>1：如曾安装过Lodop旧版附件npActiveXPLugin,请在【工具】->【附加组件】->【扩展】中先卸它。";
		var LODOP = oEMBED;
		var isIE = (navigator.userAgent.indexOf('MSIE') >= 0)
				|| (navigator.userAgent.indexOf('Trident') >= 0);
		var is64IE = isIE && (navigator.userAgent.indexOf('x64') >= 0);
		try {
			if (isIE)
				LODOP = oOBJECT;
			if ((LODOP == null) || (typeof (LODOP.VERSION) == "undefined")) {
				if (navigator.userAgent.indexOf('Firefox') >= 0) {
					document.documentElement.innerHTML = strHtmFireFox
							+ document.documentElement.innerHTML;
				}
				;
				if (is64IE) {
					document.write(strHtm64_Install);
				} else if (isIE) {
					document.write(strHtmInstall);
				} else {
					document.documentElement.innerHTML = strHtmInstall
							+ document.documentElement.innerHTML;
				}
				;
				return LODOP;
			} else if (LODOP.VERSION < "6.1.5.8") {
				if (is64IE) {
					document.write(strHtm64_Update);
				} else if (isIE) {
					document.write(strHtmUpdate);
				} else {
					document.documentElement.innerHTML = strHtmUpdate
							+ document.documentElement.innerHTML;
				}
				;
				return LODOP;
			}
			//*****如下空白位置适合调用统一功能:********* 

			//*******************************************
			return LODOP;
		} catch (err) {
			document.documentElement.innerHTML = "Error:" + strHtmInstall
					+ document.documentElement.innerHTML;
			return LODOP;
		}
	};
</script>
<object id="LODOP_OB"
	classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>
	<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
</object>



</head>

<script language="javascript" type="text/javascript">
	Ext
			.onReady(function() {
				var win;
				var LODOP;
				if (!win) {
					win = Ext
							.create(
									'Ext.window.Window',
									{
										title : 'LODOP打印控件测试',
										id : 'winId',
										width : 600,
										height : 450,
										closeAction : 'close',
										plain : true,
										autoLoad : {
											url : webRoot
													+ '/information/queryZZRKinfo.do?bcxrxxId=219237837932&populationType=户籍人口&sqrxxId=ef96e0bbae754322bc36d4d8fa5ec7ec',
											scripts : true
										},

										buttons : [ {
											text : "测试",
											handler : CheckIsInstall
										}, {
											text : '打印预览',
											handler : prn1_preview
										}, {
											text : 'Close',
											handler : function() {
												win.close();
											}
										} ]
									});
				}
				win.show(this);

				function prn1_preview() {
					CreateOneFormPage();
					LODOP.PREVIEW();
				}
				;

				function CreateOneFormPage() {
					LODOP = getLodop(document.getElementById('LODOP_OB'),
							document.getElementById('LODOP_EM'));
					LODOP.PRINT_INIT("打印控件功能演示_Lodop功能_表单一");
					LODOP.SET_PRINT_STYLE("FontSize", 18);
					LODOP.SET_PRINT_STYLE("Bold", 1);

					LODOP.ADD_PRINT_HTM(18, 20, 350, 600, document
							.getElementById("winId").innerHTML);
				}
				;

				function CheckIsInstall() {
					try {
						var LODOP = getLodop(document
								.getElementById('LODOP_OB'), document
								.getElementById('LODOP_EM'));
						if ((LODOP != null)
								&& (typeof (LODOP.VERSION) != "undefined"))
							Ext.MessageBox.alert("提示",
									"本机已成功安装过Lodop控件!\n  版本号:" + LODOP.VERSION);
					} catch (err) {
						//alert("Error:本机未安装或需要升级!");
					}
				}
				;

			});
</script>
<body>

</body>
</html>