<%--
  Created by IntelliJ IDEA.
  User: 52895
  Date: 2020/2/24
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>11</title>

    <script type="text/javascript" src="js/jquery-easyui-1.4.5/jquery.min.js" charset="utf-8"></script>
    <!-- ====== easyui相关库   顺序别颠倒，是有序的 ========================== -->
    <!--页面的样式-->
    <link id="easyuiTheme" rel="stylesheet" href="js/jquery-easyui-1.4.5/themes/default/easyui.css" type="text/css"/>
    <!--图标的样式-->
    <link rel="stylesheet" href="js/jquery-easyui-1.4.5/themes/icon.css" type="text/css"/>
    <!---->
    <script type="text/javascript" src="js/jquery-easyui-1.4.5/jquery.easyui.min.js" charset="utf-8"></script>
    <!--页面样式要显示中文就把easyui-lang-zh_CN.js引入-->
    <script type="text/javascript" src="js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
    <script>
      function addtab(names,url) {
        // 添加一个未选中状态的选项卡面板----在方法表中的add里有如下写好的方法
        $('#tabs').tabs('add', {
          title: names,
          selected: true, //false 没有直接打开  ture是直接打开了
          closable: true, //让标签后面带X号,可以关闭
          //不能用href，因为href只加载body中的内容
          //content:'text.html' 这样写只把text.html这句话加载到页面上了
          //所以这里要用iframe
          //这里先用text.html感受下
          content: "<iframe frameborder='0' width='100%' height='100%' marginheight='3' marginwidth='2' scrolling='auto' src= '"+url+"'></iframe>"

        });
      }
    </script>
  </head>


  <body class="easyui-layout">
  <div data-options="region:'north',title:'欢迎',split:true" style="height: 100px;"><br/> 欢迎你，
    <font color="red">${user.name }</font>&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/LoginServlet?method=logout">退出系统</a>
  </div>
  <div data-options="region:'south',title:'合作伙伴',split:true" style="height: 100px;" 22>
    <center><a href="gg.html">新浪简介</a> | <a href="http://jl.sina.com.cn/">新浪吉林简介 </a>| 网站地图 | 广告服务 | 联系我们 | 客户服务 | 诚聘英才 | 网站律师 | 通行证注册 | 产品答疑
      <br/>Copyright ? 1996 - 2019 SINA Corporation, All Rights Reserved
      <br/>新浪公司版权所有</center>
  </div>
  <div data-options="region:'south',title:'footer',split:true" style="height:100px;"></div>
  <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>
  <div data-options="region:'west',title:'后台管理',split:true" style="width:200px;">


    <div id="aa" class="easyui-accordion" style="width:300px;height:200px;" data-options="fit:true">





      <div title="员工管理" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
        <ul id="tt" class="easyui-tree">
          <li>
            <span><a onclick="addtab('员工信息管理','UserListServlet')">员工信息</a></span>

          </li>

        </ul>
      </div>


      <div title="部门管理" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
        <ul id="tt" class="easyui-tree">
          <li>
            <span><a onclick="addtab('部门信息管理','BuMenListServlet')">部门信息</a></span>

          </li>

        </ul>
      </div>
      <div title="统计图" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
        <ul id="tt" class="easyui-tree">
          <li>
            <span><a onclick="addtab('折线图','tu.jsp')">折线图</a></span>
zhu
          </li>
          <li>
            <span><a onclick="addtab('柱形图','tt.jsp')">柱形图</a></span>

          </li>

        </ul>
      </div>

    </div>
  </div>
  <div data-options="region:'center',title:'content'" style="padding:5px;background:#eee;">
    <div id="tabs" class="easyui-tabs" data-options="fit:true">
      <div title="Tab1" style="padding:20px;">
        tab1
      </div>

    </div>
  </div>
  </body>
</html>
