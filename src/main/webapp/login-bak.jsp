<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@include file="/common/common.inc.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>登陆页面</title>
        <link rel="stylesheet" href="${ctx}/common/css/common.css" type="text/css" />
        <link rel="stylesheet" href="${ctx}/common/css/login.css" type="text/css" />
        <script type="text/javascript" src="${ctx}/js/login.js"></script>
    </head>


    <body style="background: #def1f5;" >
        <div class="login_head">
            <div class="login_img">
                
            </div>
        </div>
        <form id="loginForm" name="loginForm" method="post" action="${ctx}/login/doLogin.do">
        <div class="login_contact">
            <div class="benner_img">
                <div class="benner_login_box">
                    <div class="benner_text_box">
                        <h3>用户登录</h3>
                        <span id="error_text" class="benner_text_error" style="color: yellow; font-size: 12px;">${error}</span>
                        <div class="benner_text_iptbox">
                            <input id="userCode" name="userCode" type="text" class="benner_text_ipt" />
                            <div class="benner_text_people"></div>
                        </div>
                        <div class="benner_text_iptbox">
                            <input id="password" name="password" type="password" class="benner_text_ipt" />
                            <div class="benner_text_cipher"></div>
                        </div>
                        <div class="benner_text_butbox">
                            <a href="#" class="benner_text_but" id="loginBtn">登录</a>
                        </div>
                        <div class="benner_text_textbox">
                            <p>
                                <a href="#" style="padding-left: 0;">找回密码</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </form>
        <div class="login_foot">
            <p class="login_foot_ban">
                Copyright © 2015-2020  版权所有
            </p>
        </div>
    </body>
</html>