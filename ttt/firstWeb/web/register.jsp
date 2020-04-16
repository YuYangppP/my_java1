
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- 重置文件 -->
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style_zhuce.css">
    <title>注册</title>
</head>
<body>
<div class="reg_div">
    <p>员工注册</p>
    <form method="post" action="${pageContext.request.contextPath }/RegisterServlet" id="registerForm">
        <ul class="reg_ul">
            <li>
                <span>User：</span>
                <input type="text" name="username" value="" placeholder="4-8位用户名" class="reg_user">
                <span class="user_hint"></span>
            </li>
            <li>
                <span>Password：</span>
                <input type="password" name="password" value="" placeholder="6-16位密码" class="reg_password">
                <span class="password_hint"></span>
            </li>
            <li>
                <span>Confirm：</span>
                <input type="password" name="" value="" placeholder="确认密码" class="reg_confirm">
                <span class="confirm_hint"></span>
            </li>
            <li>
                <span>Email：</span>
                <input type="email" name="email" value="" placeholder="邮箱" class="reg_email">
                <span class="email_hint"></span>
            </li>
            <li>
                <span>Mobile：</span>
                <input type="text" name="mobile" value="" placeholder="手机号" class="reg_mobile">
                <span class="mobile_hint"></span>
            </li>
            <li>
                <button type="submit" name="button" class="red_button" id="red_button">注册</button>
            </li>
        </ul>
    </form>
</div>
<script src="js/jquery.js"></script>
<script src="js/JavaScript_zhuce.js"></script>


</body>
</html>

