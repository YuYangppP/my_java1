<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>chat</title>
</head>
<body>
	<div id="container" style=" border:1px solid black; width:400px;height:400px;float:left;">
		<div id="content" style="height:350px;"></div>
		<div style="border-top:1px solid black;width:400px;height:50px;">
			<input id="msg" /><button onclick="sendMsg();">send</button>
		</div>
	</div>
	<div id="userList" style="border:1px solid black;width:150px;height:400px;float:left;"></div>
</body>
<script src="jquery-3.3.1.js"></script>
<script type="text/javascript">
	//从session域中获取值
	var username = "${sessionScope.username}";
	var ws;
	var target = "ws://localhost:8080/websocket/chat"+"?"+username;//将该值传递到后台
	window.onload = function(){
		if ('WebSocket' in window) {
            ws = new WebSocket(target);
        } else if ('MozWebSocket' in window) {
            ws = new MozWebSocket(target);
        } else {
            alert('WebSocket is not supported by this browser.');
            return;
        }
		
		ws.onmessage = function(event){
			//转为JSON字符串 
			eval("var message = "+event.data+";");
			
			//消息列表，直接追加消息 
			$("#content").append(message.msg);
			
			//用户列表，有用户进入或退出时刷新列表 
			if(undefined!=message.userList){
				//遍历前，先清空 
				$("#userList").html("");
				$(message.userList).each(function(){
					var own = "";
					if(username==this){
						own = "(我)"
					}
					$("#userList").append("<input type='checkbox' checked='checked' value='"+this+"' />"+this+own+"<br/>");
				});
			}
		}
	}
	
	function sendMsg(){
		
		var checked="";
		$.each($('input:checkbox:checked'),function(){
			checked+=$(this).val()+"#P#";
		});
		
		if(""==checked){
			alert("请选中要接收消息的人");
			return;
		}
		
		var msg = $("#msg").val();
		
		//拼接格式消息 
		ws.send(checked+"#S#"+msg);
		$("#msg").val("");
	}
	
</script>
</html>