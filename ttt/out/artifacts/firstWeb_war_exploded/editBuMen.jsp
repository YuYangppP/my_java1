<%--
  Created by IntelliJ IDEA.
  User: 52895
  Date: 2020/2/28
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>修改员工</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        .t tr td:first-child{
            text-align: right;
            font-size: 14px;
        }
        .t tr td:last-child{
            padding-left: 20px;
        }
        .t tr input{
            font-size: 14px;
        }
    </style>
</head>
<body>
<form action="/BuMenServlet?method=updateBuMen" method="post">
    <input type="hidden" name="bid" value="${buMen.bid }">

    <table class="table table-bordered table-striped t" style="margin-top:20px;">
        <tr>
            <td>部门名称：</td>
            <td><input type="text" name="bname" value="${buMen.bname}"></td>
        </tr>
        <tr>
            <td>本部门负责人：</td>
            <td><input type="text" name="leader" value="${buMen.leader}"></td>
        </tr>
        <tr>
            <td>电话：</td>
            <td><input type="text" name="tel" value="${buMen.telephone}"></td>
        </tr>

        <tr>
            <td colspan="2" class="last">
                <input type="submit" value="保存" class="btn btn-primary"/>
            </td>
        </tr>
    </table>

</form>
</body>
</html>

