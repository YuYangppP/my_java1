<%--
  Created by IntelliJ IDEA.
  User: 52895
  Date: 2020/4/11
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
    <h1 align="center">用户登录</h1>
    <hr>
    <form action="${ctx}/login/login.action" method="post">
        <table align="center" width="50%" border="1" cellpadding="2" cellspacing="5">
            <tr>
                <td align="right">用户名:</td>
                <td>
                    <input type="text" name="username">
                </td>
            </tr>
            <tr>
                <td align="right">用户名:</td>
                <td>
                    <input type="password" name="password">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="checkbox" name="rememberMe" value="1">7天免登陆
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="登陆">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
