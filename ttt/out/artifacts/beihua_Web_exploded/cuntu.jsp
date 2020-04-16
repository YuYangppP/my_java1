<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

		<title>My JSP 'cuntu.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<html>
			<head>
				<base href="<%=basePath%>">

				<title>My JSP 'index.jsp' starting page</title>
				<meta http-equiv="pragma" content="no-cache">
				<meta http-equiv="cache-control" content="no-cache">
				<meta http-equiv="expires" content="0">
				<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
				<meta http-equiv="description" content="This is my page">

				<!-- jquery库 -->
				<script type="text/javascript"
					src="js/jquery-easyui-1.4.5/jquery.min.js" charset="utf-8">
               </script>

				<!-- ====== easyui相关库   顺序别颠倒，是有序的 ========================== -->
				<!--页面的样式-->
				<link id="easyuiTheme" rel="stylesheet"
					href="js/jquery-easyui-1.4.5/themes/default/easyui.css"
					type="text/css"></link>
				<!--图标的样式-->
				<link rel="stylesheet" href="js/jquery-easyui-1.4.5/themes/icon.css"
					type="text/css"></link>
				<!---->
				<script type="text/javascript"
					src="js/jquery-easyui-1.4.5/jquery.easyui.min.js" charset="utf-8">
			</script>
				<!--页面样式要显示中文就把easyui-lang-zh_CN.js引入-->
				<script type="text/javascript"
					src="js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"
					charset="utf-8">
			</script>

				<!-- --画图工具------ -->
				<script type="text/javascript"
					src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.5/jquery.min.js"
					charset="utf-8">
				</script>
				<script type="text/javascript"
					src="${pageContext.request.contextPath}/js/charts/fusioncharts.js"
					charset="utf-8">
				</script>
				<script type="text/javascript"
					src="${pageContext.request.contextPath}/js/charts/fusioncharts.charts.js"
					charset="utf-8">
				</script>
				<!-- -------- -->
				
				 <script type="text/javascript">

 

  $(function(){
	
	  show();
	  
  });
 
 function show(){
	 
	 $.ajax({
			url : "CunKuanTu",
			
			success : function(data) {
			
				FusionCharts.ready(function() {
					var revenueChart = new FusionCharts({
						"type" : "column3d",
						"renderAt" : "chartContainer",//id的值
						"width" : "100%",
						"height" : "700",
						"dataFormat" : "json",
						"dataSource": {
					        "chart": {
					            "caption": "账户存款信息统计图",
					            "subCaption": "个人存款统计",
					            "xAxisName": "姓名",
					            "yAxisName": "钱",
					            "theme": "fint"
					         },
					        "data": data
					      }
					});
					revenueChart.render();
				})
			}
		});
 }
	 
     
</script>
			</head>

			<body>
				
				  <div id="chartContainer"></div>
			</body>
		</html>