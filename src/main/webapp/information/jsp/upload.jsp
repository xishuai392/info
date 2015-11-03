<%@ page language="java" import="java.text.*,java.util.*"
	pageEncoding="UTF-8"%>

<%@include file="/common/common.inc.jsp"%>

<html>
<head>
<title>人口信息查询</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/common/css/info.css">

<script language="VBScript">
Function inputtext(txt)
    Set WshShell = CreateObject("WScript.Shell")
    WshShell.SendKeys(txt)
    Set WshShell = Nothing
End Function
</script>

<script language="javascript">
function upLoad(){
    document.getElementById("jiaxueq").focus();
    inputtext("C:\\JPG.jpg");
}
</script>

</head>
<body style="width: 100%; height: 100%">
	<form action="${ctx}/scan/upload.do?sqrxxId=2aa4ee52fecf481c8d64e527cd1487f0" method="post" enctype="multipart/form-data">
		<input type="file" name="upload"  id="jiaxueq" value="c://JPG.jpg"/> 
		<input type="submit" value="Submit" />
		<input type="button" value="提交" onclick="upLoad()" />
	</form>
</body>
</html>

