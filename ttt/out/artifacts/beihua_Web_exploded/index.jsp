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


		<script type="text/javascript">
function add(names, url) {

	// 添加一个未选中状态的选项卡面板----在方法表中的add里有如下写好的方法
	$('#tabs')
			.tabs(
					'add',
					{
						title : names,
						selected : true,//false 没有直接打开  ture是直接打开了
						closable : true, //让标签后面带X号,可以关闭
						//不能用href，因为href只加载body中的内容
						//content:'text.html' 这样写只把text.html这句话加载到页面上了
						//所以这里要用iframe
						//这里先用text.html感受下
						content : "<iframe frameborder='0' width='100%' height='100%' marginheight='3' marginwidth='2' scrolling='auto' src='"
								+ url + "'></iframe>"

					});
}
</script>
	</head>

	<body class="easyui-layout">
		<div data-options="region:'north',title:'个人资金账户管理系统',split:true"
			style="height: 100px;">
			<br />
			欢迎您，
			<font color="red">张三</font>&nbsp;&nbsp;
			<a href="">退出系统</a>
		</div>
		<div data-options="region:'south',title:'合作伙伴',split:true"
			style="height: 100px;"22>
			<center>
				<a href="gg.html">新浪简介</a> |
				<a href="http://jl.sina.com.cn/">新浪吉林简介 </a>| 网站地图 | 广告服务 | 联系我们 |
				客户服务 | 诚聘英才 | 网站律师 | 通行证注册 | 产品答疑
				<br />
				Copyright ? 1996 - 2019 SINA Corporation, All Rights Reserved
				<br />
				新浪公司版权所有
			</center>
		</div>
		<!-- <div
			data-options="region:'east',iconCls:'icon-reload',title:'东',split:true"
			style="width: 100px;">
			33
		</div> -->
		<div data-options="region:'west',title:'后台管理',split:true"
			style="width: 200px;">

			<!--===========手风琴========================-->
			<div id="aa" class="easyui-accordion"
				style="width: 300px; height: 200px;" data-options="fit:true">
				<div title="个人帐户管理" data-options="iconCls:'icon-save'"
					style="overflow: auto; padding: 10px;">
					<!-- ===树=========-->

					<ul id="tt" class="easyui-tree">

						<li>
							<span><a onclick="add('存款','cun.jsp')">存款</a> </span>
						</li>
						<li>
							<span><a onclick="add('取款','qu.jsp')">取款</a> </span>
						</li>
						<li>
							<span><a onclick="add('转帐','zz.jsp')">转帐</a> </span>
						</li>

						<li>
							<a onclick="add('交易记录','JiluServelt')">交易记录</a>
						</li>
					</ul>

					</ul>


					<!-- ======== -->
				</div>
				<div title="个人信息管理"
					data-options="iconCls:'icon-reload',selected:true"
					style="padding: 10px;">
					<!--=======折叠树DataGrid+Tree(树据表格和树)============-->
					<ul id="tt" class="easyui-tree">

						<li>
							<a onclick="addtab('存款')">修改个人密码</a>
						</li>

					</ul>
				</div>
				<div title="系统管理">
					<!--=======折叠树DataGrid+Tree(树据表格和树)============-->
					<ul id="tt" class="easyui-tree">

						<li>
							<a onclick="add('存款统计图','cuntu.jsp')">个人账户存款信息统计图</a>
						</li>
						<li>
							<a onclick="add('存款次数统计图','cunnumtu.jsp')">个人账户存款次数统计图</a>
						</li>
					</ul>

					<!--=======折叠树============-->
				</div>
			</div>

			<!-- ====================================-->

		</div>
		<div data-options="region:'center',title:''"
			style="padding: 5px; background: #eee;">

			<!-- ====================== -->

			<div id="tabs" class="easyui-tabs" data-options="fit:true">
				<div title="欢迎" style="padding: 20px;">
					<marquee>

						<font color="red">公告:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;互联网+个人资金账户管理系统互联网+个人资金账户管理系统
							互联网+个人资金账户管理系统互联网+个人资金账户管理系统互联网+个人资金账户管理系统<br /> </font>

					</marquee>
					欢迎使用互联网+ 个人资金账户管理系统
					<br />
					<br />
				</div>

			</div>


			<!-- ====================-->



		</div>
	</body>
</html>
