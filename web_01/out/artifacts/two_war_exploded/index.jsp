<%--
  Created by IntelliJ IDEA.
  User: 52895
  Date: 2020/2/24
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/jquery-easyui-1.4.5/jquery.min.js" charset="utf-8"></script>

    <!-- ====== easyui相关库   顺序别颠倒，是有序的 ========================== -->
    <!--页面的样式-->
    <link id="easyuiTheme" rel="stylesheet" href="js/jquery-easyui-1.4.5/themes/default/easyui.css" type="text/css"></link>
    <!--图标的样式-->
    <link rel="stylesheet" href="js/jquery-easyui-1.4.5/themes/icon.css" type="text/css"></link>
    <!---->
    <script type="text/javascript" src="js/jquery-easyui-1.4.5/jquery.easyui.min.js" charset="utf-8"></script>
    <!--页面样式要显示中文就把easyui-lang-zh_CN.js引入-->
    <script type="text/javascript" src="js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
    <script>
      function addtab(names) {
        // 添加一个未选中状态的选项卡面板----在方法表中的add里有如下写好的方法
        $('#tabs').tabs('add', {
          title: names,
          selected: true, //false 没有直接打开  ture是直接打开了
          closable: true, //让标签后面带X号,可以关闭
          //不能用href，因为href只加载body中的内容
          //content:'text.html' 这样写只把text.html这句话加载到页面上了
          //所以这里要用iframe
          //这里先用text.html感受下
          content: "<iframe frameborder='0' width='100%' height='100%' marginheight='3' marginwidth='2' scrolling='auto' src='test.html'></iframe>"

        });
      }
    </script>
  </head>
  <body class="easyui-layout">
  <div data-options="region:'north',title:'header',split:true" style="height:100px;"></div>
  <div data-options="region:'south',title:'footer',split:true" style="height:100px;"></div>
  <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>
  <div data-options="region:'west',title:'nav',split:true" style="width:100px;">
    <div id="aa" class="easyui-accordion" style="width:300px;height:200px;" data-options="fit:true">
      <div title="区" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
        <ul id="tt" class="easyui-tree">
          <li>
            <span>Folder</span>
            <ul>
              <li>
                <span>File 11</span>
              </li>
              <li>
                <span>File 22</span>
              </li>
              <li>
                <span>Sub Folder 1</span>
                <ul>
                  <li>
                    <span><a onclick="addtab('学生')">学员信息</a></span>
                  </li>
                  <li>
                    <span>File 3</span>
                  </li>

                </ul>
              </li>

            </ul>
          </li>

        </ul>
      </div>
      <div title="街道" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">
        content2
      </div>
      <div title="社区">
        content3
      </div>
    </div>
  </div>
  <div data-options="region:'center',title:'content'" style="padding:5px;background:#eee;">
    <div id="tabs" class="easyui-tabs" data-options="fit:true">
      <div title="Tab1" style="padding:20px;">
        tab1
      </div>
      <div title="Tab2" data-options="closable:true" style="overflow:auto;padding:20px;display:none;">
        tab2
      </div>
      <div title="Tab3" data-options="iconCls:'icon-reload',closable:true" style="padding:20px;display:none;">
        tab3
      </div>
    </div>
  </div>
  </body>
</html>
