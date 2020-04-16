<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zhuce.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>

  </head>
  
  <body>
  <form  action="ZhuceServlet"  method="post">
        用户名：<input type="text" name="uname"><br/>
        密&nbsp;&nbsp;&nbsp;码：<input type="password" name="pwd"><br/>
       确认密码：<input type="password" name="repwd"><br/>
       年&nbsp;&nbsp;&nbsp;龄：<input type="text" name="age"><br/>
       生&nbsp;&nbsp;&nbsp;日：<input type="text" name="bir" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" ><br/>
       毕业时间：<input type="text" name="biye" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" ><br/>
   <input type="submit" value="注册">
   
  </form>
  </body>
</html>
