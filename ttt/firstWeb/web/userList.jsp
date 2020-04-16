<%--
  Created by IntelliJ IDEA.
  User: 52895
  Date: 2020/2/26
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>列表</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery-easyui-1.4.5/jquery.min.js" charset="utf-8"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.5/jquery.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/browser.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.jqprint-0.3.js" charset="utf-8"></script>

    <script type="text/javascript">

        function print()
        {
            $('#s').jqprint();
        }
        function addUser() {
            window.location.href = "${pageContext.request.contextPath}/addUser.jsp";
        }

        function delUser(uid){
            var isDel = confirm("您确认要删除吗？");
            if(isDel){
                //要删除
                location.href = "${pageContext.request.contextPath}/UserServlet?method=delUserById&uid="+uid;
            }
        }

        function editUser(uid){
                location.href = "${pageContext.request.contextPath}/UserServlet?method=updateUserUI&uid="+uid;

        }

        function selectAll() {
            var allCheck = document.getElementById("checkAll");
            var info = document.getElementsByName("info");
            for (var i = 0;i<info.length;i++){
                info[i].checked=allCheck.checked;
            }

        }


        function delUser() {

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
<div class="container" style="margin-top: 10px;position: absolute" id="s" >


    <form  action="${pageContext.request.contextPath}/UserListServlet" method="post">
        <div>
            <input type="button" value="添加" id = "delbtn" class="btn btn-primary" onclick="addUser()" style="float:left;position: relative;top: 1px;left: 0px;margin-bottom:10px;font-size:12px;width: 60px">
        </div>
        <div>
            <input type="button" value="删除选中" id = "delAllbtn" class="btn btn-primary" onclick="delUser()" style="float:left;position: relative;top: 1px;left: 5px;margin-bottom:10px;font-size:12px;width: 100px">
        </div>
        <table class="table table-bordered table-striped">
            <tr>

                <th>序号</th>
                <th>姓名</th>
                <th>电话号</th>
                <th>部门</th>
                <th>操作</th>

                <th><input type="checkbox"  id = "checkAll" value="" class="ck" onclick="selectAll()"></th>

            </tr>
            <c:forEach items="${pageBean.list}" var="ms">
                <tr>
                    <td>${ms.uid}</td>
                    <td>${ms.name}</td>
                    <td>${ms.number}</td>
                    <c:if test="${ms.bmid==1 }">
                        <td>研发部门</td>
                    </c:if>
                    <c:if test="${ms.bmid=='' }">
                        <td></td>
                    </c:if>
                    <c:if test="${ms.bmid==2 }">
                        <td>销售部门</td>
                    </c:if>
                    <c:if test="${ms.bmid==3 }">
                        <td>财务部门</td>
                    </c:if>
<%--
                    <td>${ms.bmid}</td>
--%>

                    <td>
                        <a href="javascript:void(0);" onclick="delUser('${ms.uid}')">删除</a>
                        <a href="javascript:void(0);" onclick="editUser('${ms.uid}')">编辑</a>
                    </td>
                    <th><input type="checkbox" value="${ms.uid}" id="f" name="info"></th>
                </tr>
            </c:forEach>


        </table>

        <!--分页 -->
        <div style="width: 200px; margin: 0 auto; margin-top: 20px;">
            <ul class="pagination" style="text-align: center; margin-top: 10px;">

                <!-- 上一页 -->
                <c:if test="${pageBean.currentPage==1 }">
                    <li class="disabled">
                        <a href="javascript:void(0);" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${pageBean.currentPage!=1 }">
                    <li>
                        <a href="${pageContext.request.contextPath}/UserListServlet?currentPage=${pageBean.currentPage-1 }" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>


                <!-- 显示每一页 -->
                <c:forEach begin="1" end="${pageBean.totalPage }" var="page">
                    <!-- 判断是否是当前页 -->
                    <c:if test="${page==pageBean.currentPage }">
                        <li class="active"><a href="javascript:void(0);">${page }</a></li>
                    </c:if>
                    <c:if test="${page!=pageBean.currentPage }">
                        <li><a href="${pageContext.request.contextPath}/UserListServlet?currentPage=${page }">${page }</a></li>
                    </c:if>
                </c:forEach>


                <!-- 下一页 -->
                <c:if test="${pageBean.currentPage==pageBean.totalPage }">
                    <li class="disabled">
                        <a href="javascript:void(0);" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${pageBean.currentPage!=pageBean.totalPage }">
                    <li>
                        <a href="${pageContext.request.contextPath}/UserListServlet?currentPage=${pageBean.currentPage+1 }" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>

            </ul>
        </div>
        <!-- 分页结束 -->
    </form>
    <center><input type="button" value="打印" onclick="print()" style="position: absolute; left:1100px;top:256px"></center>

</div>
</body>
</html>
