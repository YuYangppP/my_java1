<%--
  Created by IntelliJ IDEA.
  User: 52895
  Date: 2019/12/3
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <script src="js/jquery.min.js"></script>
    <script type="text/javascript">

        function delProduct(id){
            var isDel = confirm("您确认要删除吗？");
            if(isDel){
                //要删除
                location.href = "${pageContext.request.contextPath}/DelMessageServlet?id="+id;
            }
        }


        function selectAll() {
            var allCheck = document.getElementById("checkAll");
            var info = document.getElementsByName("info");
            for (var i = 0;i<info.length;i++){
                info[i].checked=allCheck.checked;
            }

        }
      /* $("#ckeckAll").click(function() {
           var ck = $(this).prop("checked");
           $("input[type='checkbox']").prop("checked",ck);
       })*/

     /* $(function () {

          $("#delbtn").click(function () {
              if (confirm("确定删除吗？")){
                  $("#f").submit();
              }

      });
        });*/


        function delall() {

            alert("确定删除吗？");
            var checkId = [];
            if($("input[name='info']:checked").length > 0){
                $("input[name='info']:checked").each(function (i) {
                    checkId[i] = $(this).val();
                })
                window.location.href= "${pageContext.request.contextPath}/DelSelectServlet?checkId="+checkId;
            }

        }
    </script>
</head>
<body>
    <div class="container" style="margin-top: 10px;position: absolute">


        <form  action="${pageContext.request.contextPath}/DelSelectServlet" method="post">
            <div>
                <input type="button" value="删除选中" id = "delbtn" class="btn btn-primary" onclick="delall()" style="position: relative;top: 1px;left: 1061px;width: 80px">
            </div>
        <table class="table table-bordered table-striped">
            <tr>

                <th>序号</th>
                <th>昵称</th>
                <th>留言</th>
                <th>时间</th>
                <th>ip</th>
                <th>操作</th>
                <th><input type="checkbox"  id = "checkAll" value="" class="ck" onclick="selectAll()"></th>

            </tr>
            <c:forEach items="${message}" var="ms">
            <tr>
                <td>${ms.id}</td>
                <td>${ms.nickname}</td>
                <td>${ms.message}</td>
                <td>${ms.mtime}</td>
                <td>${ms.ip}</td>
                <td>
                    <a href="javascript:void(0);" onclick="delProduct('${ms.id}')">删除</a>
                    <a href="${pageContext.request.contextPath }/UpdateMessageUIServlet?id=${ms.id}">编辑</a>
                </td>
                <th><input type="checkbox" value="${ms.id}" id="f" name="info"></th>
            </tr>
            </c:forEach>

        </table>
    </form>
    </div>
</body>
</html>
