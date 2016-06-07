
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.inc.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="description" content="HSIT-UI">
<meta name="keywords" content="HSIT-UI">
<meta name="author" content="">
<meta name="Copyright" Content="xx信息技术有限公司 版权所有">
<script type="text/javascript" src="${ctx}/js/jquery.royalslider.min.js"></script>
<script type="text/javascript" src="${ctx}/js/login.js"></script>
<link href="${ctx}/resources/css/login.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/resources/css/royalslider.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/resources/css/rs-minimal-white.css" rel="stylesheet">

<script type="text/javascript">
 
</script>
</head>
<body>
<div class="h-l-page">
  <div class="h-l-wrapper">
    <div class="h-l-wrapper-con">
      <!--header-->
      <div class="h-l-header">
        <div class="h-l-wrapper-in">
          <!--网站logo-->
          <h1 class="h-l-logo">
            <img src="${ctx}/resources/images/db.png"  alt=""/>
          </h1>
          <!--头部右侧功导航-->
          <div class="h-l-top-nav">
          	<a downloadtype="1" href="#">打印插件下载</a>
          	<a downloadtype="2" href="#">高拍仪插件下载</a>
          	<a downloadtype="3" href="#">二代证读卡器USB驱动下载</a>
          	<a downloadtype="4" href="#">二代证B/S读卡控件下载</a>
          	<a downloadtype="5" href="#">终端打印插件下载</a>
          <!-- 
            <a href="#">关于我们</a>
            <a href="#">帮助</a> -->
          </div>
        </div>
      </div>
      <!--登录主体-->
      <div class="h-l-content">
        <!--登录表单-->
        <div class="h-l-form-area">
          <!--用户首次登录界面-->
          <form id="loginForm" name="loginForm" method="post" action="${ctx}/login/doLogin.do" >
		  <!--
			<input type="hidden" name="linkpage" id="linkpage"  value="http:///portalAction.do?action=loginWithRone"/>				
			<input type="hidden" name="loginFailurePage" id="loginFailurePage"  value="http:///login.jsp"/>				
			<input type="hidden" name="userid" id="userid"/>    -->
            <p class="h-l-user-header">
              <img src="${ctx}/resources/images/img-user-header.jpg"  alt=""/>
            </p>
            <p class="h-l-form-item">
              <input id="userCode" name="userCode" type="text" class="h-l-input-text h-l-icon-user" value="" placeholder="请输入用户名"  />
            </p>
            <p class="h-l-form-item">
              <input id="passWord" name="password" type="password" id="pw" class="h-l-input-text h-l-icon-pw" value="" placeholder="请输入密码"  />
            </p>
            <p class="h-l-form-item">
              <input name="submitBtn" type="button" id="loginBtn" class="h-l-input-btn" value="登录"/>
              <!--
              <a href="#" class="h-l-input-btn h-l-disable" >
              	<span class="h-l-icon-loading"></span>
              正在登录...</a>
               -->
            </p>
			<!--
            <p class="h-l-link">
              <a href="#" onclick="showLoginForm('ca')">证书登录</a>
            </p> -->
          </form>
          <!--用户第二次登录界面
          <form id="loginform1" method="post" action="../../framework/themes-default/login.html" class="h-l-form-loged h-l-hide">
            <p class="h-l-user-header">
              <img src="resources/images/img-user-header-d4u.jpg"  alt=""/>
            </p>
            <div class="h-l-user-info">
              <h2><strong class="h-l-user-name"></strong>
                <span class="h-l-user-id"></span>
              </h2>
              <span class="h-l-user-company">福建省公司</span>
            </div>
            <p class="h-l-form-item">
              <input name="password1" type="password" id="pw1" class="h-l-input-text h-l-icon-pw" value="" placeholder="请输入密码" />
            </p>
            <p class="h-l-form-item">
              <input name="submit" type="submit" id="submit" class="h-l-input-btn" value="登录"/>
            </p>
            <p class="h-l-link">
              <a href="#">用另一用户身份登录</a>
            </p>
          </form>
          -->
          <!--CA登录界面
          <form id="loginformca" method="post" action="../../framework/themes-default/login.html" class="h-l-hide">
            <p class="h-l-user-header">
              <img src="resources/images/img-CA.png"  alt=""/>
            </p>
            <div class="h-l-user-info">
              <h2><strong class="h-l-user-name"></strong>
                <span class="h-l-user-id"></span>
              </h2>
              <span class="h-l-user-company"></span>
            </div>
            <p class="h-l-form-item">
              <input name="submit" type="submit" id="submit" class="h-l-input-btn" value="证书登录"/>
            </p>
            
            <p class="h-l-link">
              <a href="#" onclick="showLoginForm('userPassword')">普通登录</a>
            </p>
          </form>
         -->
         <span id="error_text" class="benner_text_error" style="color: red; font-size: 14px;">${error}</span>
          <div class="h-l-errorTxt h-l-hide">
            <span>错误提示：</span>
            </div>
       
        </div>
       
        
        
        <!-- 滚动代码开始-->
        <div class="sliderContainer fullWidth clearfix">
          <div id="full-width-slider" class="royalSlider heroSlider rsMinW">
            <div class="rsContent" style="background:#2a95bb; height:500px;">
              <div style="position:absolute; left:50%; width:2000px; height:500px; top:0; margin-left:-1000px;"><img src="${ctx}/resources/images/banner/3-0.jpg" alt=""/></div>
              <!-- 
              <div class="rsABlock" data-fade-effect="" data-move-offset="100" data-move-effect="left" data-speed="800"><img style="margin-left:-400px;" src="" alt=""/></div>
               -->
            </div>
            <!-- 
            <div class="rsContent" style="background:#2a95bb; height:500px;">
              <div style="position:absolute; left:50%; width:2000px; height:500px; top:0; margin-left:-1000px;"><img src="${ctx}/resources/images/banner/1-0.jpg" alt=""/></div>
			  
              <div class="rsABlock" data-fade-effect="" data-move-offset="100" data-move-effect="left" data-speed="800"><img style="margin-left:-400px;" src="" alt=""/></div>
               
            </div>-->
            
            
          </div>
        </div>
        <script>
        jQuery(document).ready(function($) {
			$('#full-width-slider').royalSlider({
				arrowsNav: true,
				loop: true,
				loopRewind: true,
				keyboardNavEnabled: true,
				controlsInside: false,
				imageScaleMode: 'none',
				arrowsNavAutoHide: false,
				controlNavigation: 'bullets',
				thumbsFitInViewport: false,
				navigateByClick: true,
				startSlideId: 0,
				autoplay: true,
				transitionType:'move',
				globalCaption: false,
				deeplinking: {
					enabled: true,
					change: false
				},
				autoPlay: { 
					enabled: true,
					delay:3000
				}
			});
        });
        
        </script>
        <!-- 滚动代码结束-->
      </div>
      <!--footer-->
      <div class="h-l-footer">
        <p>厦门市公安局科技通信处&nbsp;&nbsp;&nbsp;&nbsp;联系电话:2262277</p>
      </div>
    </div>
  </div>
</div>
		<script language="javascript" src="<%=request.getContextPath()%>/lodap/LodopFuncs.js"></script>
		<!-- 打印驱动 -->
		<object id="LODOP_OB"
			classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>
			<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
		</object>
		
		<!-- 华视电子BS控件V4.0 身份证读卡器 -->
		<OBJECT classid="clsid:10946843-7507-44FE-ACE8-2B3483D179B7"
			  id="CVR_IDCard" name="CVR_IDCard" width="0" height="0" >
		</OBJECT>
		
		
</body>
</html>
