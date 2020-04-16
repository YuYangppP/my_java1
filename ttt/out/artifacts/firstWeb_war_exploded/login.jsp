<%--
  Created by IntelliJ IDEA.
  User: 52895
  Date: 2020/2/24
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>欢迎登录后台管理系统</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="assets/css/font-awesome.min.css" />
    <link rel="stylesheet" href="assets/css/ace.min.css" />
    <link rel="stylesheet" href="assets/css/ace-skins.min.css" />
    <link rel="stylesheet" href="css/style11.css"/>
    <link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

    <script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="assets/layer/layer.js" type="text/javascript"></script>


</head>

<body class="login-layout">
<div class="logintop">
    <span>欢迎后台管理界面平台</span>
    <ul>
        <li><a href="register.jsp">注册</a></li>
        <li><a href="javascript:void(0);">返回首页</a></li>
        <li><a href="javascript:void(0);">帮助</a></li>
        <li><a href="javascript:void(0);">关于</a></li>
    </ul>
</div>
<div class="loginbody">
    <div class="login-container">
        <div class="center">
            <h1>
                <i class="icon-leaf green"></i>
                <span class="orange">人事管理</span>
                <span class="white">后台管理系统</span>
            </h1>
            <h4 class="white">Background Management System</h4>
        </div>

        <div class="space-6"></div>

        <div class="position-relative">
            <div id="login-box" class="login-box widget-box no-border visible">
                <div class="widget-body">
                    <div class="widget-main">
                        <h4 class="header blue lighter bigger">
                            <i class="icon-coffee green"></i>
                            管理员登陆
                        </h4>

                        <div class="login_icon"><img src="images/login.png" /></div>
                        <div>
                            <span style="color: red;" class="le">${loginError }</span>
                        </div>
                        <form method="post" action="${pageContext.request.contextPath }/LoginServlet?method=login" id="loginForm">
                            <fieldset>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                        <input type="text" class="form-control" placeholder="登录名"  name="username">
                                        <i class="icon-user"></i>
                                    </span>
                                </label>

                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                        <input type="password" class="form-control" placeholder="密码" name="password">
                                        <i class="icon-lock"></i>
                                    </span>
                                </label>

                                <div class="space"></div>

                                <div class="clearfix">
                                    <label class="inline">
                                        <input type="checkbox" class="ace">
                                        <span class="lbl">保存密码</span>
                                    </label>

                                    <button type="button" class="width-35 pull-right btn btn-sm btn-primary" id="login_btn">
                                        <i class="icon-key"></i>
                                        登陆
                                    </button>
                                </div>

                                <div class="space-4"></div>
                            </fieldset>
                        </form>

                        <div class="social-or-login center">
                            <span class="bigger-110">通知</span>
                        </div>

                        <div class="social-login center">
                            本网站系统不再对IE8以下浏览器支持，请见谅。
                        </div>
                    </div><!-- /widget-main -->

                    <div class="toolbar clearfix">



                    </div>
                </div><!-- /widget-body -->
            </div><!-- /login-box -->
        </div><!-- /position-relative -->
    </div>
</div>
<div class="loginbm">版权所有  2016  <a href="">南京思美软件系统有限公司</a> </div><strong></strong>
</body>
</html>
<script>
    //function(){
    //if(${msg}){
    //alert(${msg})
    //}
    //}();

    $('#login_btn').on('click', function(){
        var login = $('input[name="username"]').val();
        var pwd = $('input[name="password"]').val();
        var l = $('span[class="le"]').val();
        if (login == '') {
            layer.alert('请输入您的账号');
        } else if (pwd == '') {
            layer.alert('请输入密码');
        }
        else{
            $("#loginForm").submit();



        }
        /*
                layer.close(index);
        */


    })

</script>