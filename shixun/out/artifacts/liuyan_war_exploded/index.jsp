<%--
  Created by IntelliJ IDEA.
  User: 52895
  Date: 2019/12/3
  Time: 9:09
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
    <form action="${pageContext.request.contextPath }/MessageServlet" method="post">
        <table class="table table-bordered table-striped">
            <tr>
                <td>name</td>
                <td><input type="text" name="nickname"/></td>
            </tr>
            <tr>
                <td>文本</td>
                <td><textarea rows="3"clos="25" name="message"></textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="添加" class="btn btn-primary"/>
                    <input type="reset" value="重置" class="btn btn-primary"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>