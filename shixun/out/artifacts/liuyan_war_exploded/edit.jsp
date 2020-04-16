<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 52895
  Date: 2019/12/4
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div id="container">
    <pre><h3>NotePad</h3></pre>
    <form action="${pageContext.request.contextPath }/UpdateMessageServlet" method="post">
        <input type="hidden" name="id" value="${mes.id }">
        <table class="table table-bordered table-striped">
            <tr>
                <td>昵称</td>
                <td><input type="text" name="nickname" value="${mes.nickname}"/></td>
            </tr>
            <tr>
                <td>留言</td>
                <td><textarea rows="3"clos="25" name="message">${mes.message}</textarea></td>
            </tr>
            <%  String mtime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());%>
            <tr>
                <td>时间</td>
                <td><input type="text" name="mtime" value="<%=mtime%>"/></td>
            </tr>
            <tr>
                <td>ip</td>
                <td><input type="text" name="ip" value="${mes.ip}"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="修改" class="btn btn-primary"/>
                    <input type="reset" value="返回" class="btn btn-primary"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
