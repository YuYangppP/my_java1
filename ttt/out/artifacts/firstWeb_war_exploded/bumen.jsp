<%--
  Created by IntelliJ IDEA.
  User: 52895
  Date: 2020/2/26
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>部门</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery-easyui-1.4.5/jquery.min.js" charset="utf-8"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.5/jquery.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/browser.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.jqprint-0.3.js" charset="utf-8"></script>
    <script>

        function print()
        {
            $('#s').jqprint();
        }
        function addBuMen() {
            window.location.href = "${pageContext.request.contextPath}/addBuMen.jsp";
        }

        function editBuMen(bid) {
            window.location.href = "${pageContext.request.contextPath}/BuMenServlet?method=updateBuMenUI&bid="+bid;
        }
        function delBuMen(bid){
            var isDel = confirm("您确认要删除吗？");
            if(isDel){
                //要删除
                location.href = "${pageContext.request.contextPath}/BuMenServlet?method=delBuMen&bid="+bid;
            }


        }
    </script>
</head>
<body>
<div class="container" style="margin-top: 10px;position: absolute"id="s">


    <form  action="" method="post">
        <div>
            <input type="button" value="添加" id = "delbtn" class="btn btn-primary" onclick="addBuMen()" style="position: relative;top: 1px;left: 0px;margin-bottom:10px;font-size:12px;width: 60px">
        </div>
        <table class="table table-bordered table-striped">
            <tr>

                <th>序号</th>
                <th>部门名称</th>
                <th>成立时间</th>
                <th>部门负责人</th>
                <th>电话</th>
                <th>操作</th>
                <th><input type="checkbox"  id = "checkAll" value="" class="ck" onclick="selectAll()"></th>

            </tr>
            <c:forEach items="${buMenList}" var="ms">
                <tr>
                    <td>${ms.bid}</td>
                    <td>${ms.bname}</td>
                    <td>${ms.createTime}</td>
                    <td>${ms.leader}</td>
                    <td>${ms.telephone}</td>

                    <td>
                        <a href="javascript:void(0);" onclick="delBuMen('${ms.bid}')">删除</a>
                        <a href="javascript:void(0);" onclick="editBuMen('${ms.bid}')">编辑</a>
                    </td>
                    <th><input type="checkbox" value="${ms.bid}" id="f" name="info"></th>
                </tr>
            </c:forEach>
            <center><input type="button" value="打印" onclick="print()"></center>

        </table>
    </form>
</div>
</body>
</html>
