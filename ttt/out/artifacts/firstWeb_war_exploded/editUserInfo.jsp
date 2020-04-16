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
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>

    <script type="text/javascript">
        $(function(){
            //页面加载完毕后去异步获得分类数据
            $.post(
                "${pageContext.request.contextPath}/UserServlet?method=findAllBuMen1",
                function(data){
                    //[{"cid":"xx","cname":"xxx"},{},{}]
                    //拼接多个<option value=""></option>放到select中
                    var content="";
                    for(var i=0;i<data.length;i++){
                        content+="<option value='"+data[i].bid+"'>"+data[i].bname+"</option>";
                    }
                    $("#bid").html(content);
                },
                "json"
            );

        });
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/UserServlet?method=updateUser" method="post">
    <input type="hidden" name="uid" value="${user.uid }">

    <table class="table table-bordered table-striped t" style="margin-top:20px;">
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="name" value="${user.name}"></td>
        </tr>
        <tr>
            <td>电话：</td>
            <td><input type="text" name="tel" value="${user.number}"></td>
        </tr>

        <tr>
            <td class="ta_01">
                所属分类：
            </td>
            <td class="ta_01" bgColor="#ffffff">
                <select id="bid" name="bid">

                </select>
            </td>
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

