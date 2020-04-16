<%@ page language="java" import="java.util.*,com.china.ren.vo.Zhanghu"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'jilu.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	
	    table{
	    table-layout:fixed;
	    word-break:break-all
	    }
	
	</style>
		
		<!-- jquery库 -->
<script type="text/javascript" src="js/jquery-easyui-1.4.5/jquery.min.js" charset="utf-8"></script>
           <!--======== 打印=========== -->		
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.5/jquery.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/browser.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.jqprint-0.3.js" charset="utf-8"></script>
           
		<script type="text/javascript">

			$(function()
			 {
			
				$("tr:even").css("background-color", "#B8E9FE");
			});
		</script>
		
		
	<script type="text/javascript">
	
	function print()
	 {
		$('#s').jqprint();
	 }
	
	function a(id1,id2)
	 {
	  
	  $("#"+id1+"").css('display','block');
	  $("#"+id2+"").css('display','none');
	}
	
	
	function baocun(qian,id,sp)
	 {
	 

	  var monery= $('#'+qian+'').val();
	    
	   
	
	 var prjContextPath='<%=request.getContextPath()%>';
	   
	    
	     $.post("UpdateJiLuServelt",{m:monery,ids:id},function (data){
				if(data!= null && data != ""){
				
				
				
				 $("#"+sp+"").html(""+data.msg+"");
				 
				  $("#"+sp+"").css('display','block');
	              $("#"+qian+"").css('display','none');
				}else{
					//用户把用户名密码输入的不正确，所以没法登录
					 
				}
				
			});
	
	 }
	
	</script>
	</head>

	<body>
	<div id="s">
		<center>
			<h2>
				交易记录
			</h2>
		</center>
		<TABLE border="2" width="80%" cellpadding="0" cellspacing="0"
			align="center">
			<TR align="center">
				<TH>
					帐户ID
				</TH>
				<TH>
					用户名
				</TH>
				<TH>
					钱
				</TH>
				<TH>
					操作
				</TH>
			</TR>
			<%
				List<Zhanghu> list = (List<Zhanghu>) request.getAttribute("list");
				
				for (int i = 0; i < list.size(); i++) 
				 {
					Zhanghu zh = list.get(i);
			%>

			<TR align="center">
				<TD>
					<%=zh.getZhanghuid()%>
				</TD>
				<TD>
					<%=zh.getUname()%>
				</TD>
				<TD>
				    
					<input type="text" name="qian"  id="qian<%=i%>" value="<%=zh.getQian()%>" style="display:none" onblur="baocun('qian<%=i%>','<%=zh.getId()%>','span<%=i%>')"/>
					
					<span onclick="a('qian<%=i%>','span<%=i%>')" id="span<%=i%>"><%=zh.getQian()%></span>
				</TD>
				<TD>
					<a href="DeleteJiLuServlet?id=<%=zh.getId()%>">删除</a>&nbsp;&nbsp;&nbsp;
				</TD>
			</TR>

			<%
				}
			%>
		</TABLE><br/>
		<center><input type="button" value="打印" onclick="print()"></center>
    </div>
	</body>
</html>
