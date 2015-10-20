
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.inc.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="description" content="HSIT-UI">
<meta name="keywords" content="HSIT-UI">
<meta name="author" content="design4u,QQ:66383210,Email:caixfm@gmail.com;admin@design4u.cn">
<meta name="Copyright" Content="xx信息技术有限公司 版权所有">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/jquery.royalslider.min.js"></script>
<link href="resources/css/login.css" rel="stylesheet" type="text/css" />
<link href="resources/css/royalslider.css" rel="stylesheet" type="text/css" />
<link href="resources/css/rs-minimal-white.css" rel="stylesheet">

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
            <img src="resources/images/db.png"  alt=""/>
          </h1>
          <!--头部右侧功导航-->
          <div class="h-l-top-nav">
            <a href="#">关于我们</a>
            <a href="#">帮助</a>
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
              <img src="resources/images/img-user-header.jpg"  alt=""/>
            </p>
            <p class="h-l-form-item">
              <input id="userCode" name="userCode" type="text" class="h-l-input-text h-l-icon-user" value="" placeholder="请输入用户名" onKeyDown="keyDownEvent(event)" />
            </p>
            <p class="h-l-form-item">
              <input name="password" type="password" id="pw" class="h-l-input-text h-l-icon-pw" value="" placeholder="请输入密码" onKeyDown="keyDownEvent(event)" />
            </p>
            <p class="h-l-form-item">
              <input name="submit" type="submit" id="submit" class="h-l-input-btn" value="登录"/>
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
              <span class="h-l-user-company">福建省烟草公司</span>
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
          <div class="h-l-errorTxt h-l-hide">
            <span>错误提示：</span>
            </div>
       
        </div>
       
        
        
        <!-- 滚动代码开始-->
        <div class="sliderContainer fullWidth clearfix">
          <div id="full-width-slider" class="royalSlider heroSlider rsMinW">
            <div class="rsContent" style="background:#2a95bb; height:500px;">
              <div style="position:absolute; left:50%; width:2000px; height:500px; top:0; margin-left:-1000px;"><img src="resources/images/banner/3-0.jpg" alt=""/></div>
              <!-- 
              <div class="rsABlock" data-fade-effect="" data-move-offset="100" data-move-effect="left" data-speed="800"><img style="margin-left:-400px;" src="" alt=""/></div>
               -->
            </div>
            <div class="rsContent" style="background:#2a95bb; height:500px;">
              <div style="position:absolute; left:50%; width:2000px; height:500px; top:0; margin-left:-1000px;"><img src="resources/images/banner/1-0.jpg" alt=""/></div>
			  <!-- 
              <div class="rsABlock" data-fade-effect="" data-move-offset="100" data-move-effect="left" data-speed="800"><img style="margin-left:-400px;" src="" alt=""/></div>
               -->
            </div>
            
            
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
        <div class="h-l-wrapper-in">
          <div class="h-l-logo-bt"><!--
            <img src="resources/images/logo-hs.png" alt=""/> -->
          </div>
          <div class="h-l-copyRight">
            <p>Copyright &copy; 2014
              <a href="http://www.baidu.com" title="点击进入xx官网">BAIDU.COM</a>
              |  技术支持：xx信息技术有限公司</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
