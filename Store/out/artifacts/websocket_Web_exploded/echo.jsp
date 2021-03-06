<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>first websocket</title>
</head>
<body>
	<button onclick="conn();">conn</button>
	<input type="text" id="msg"/><button onclick="send();">send</button>
	<button onclick="closeWS();">close</button>
	<div id="div">
	</div>
</body>
<script type="text/javascript">
	var ws;//一个ws对象，就是一个通信管道
	var target = "ws://localhost:8080/websocket/echo";
	function conn(){
		if ('WebSocket' in window) {
            ws = new WebSocket(target);
        } else if ('MozWebSocket' in window) {
            ws = new MozWebSocket(target);
        } else {
            alert('WebSocket is not supported by this browser.');
            return;
        }
		if(ws!=null){
			var div = document.getElementById("div");
			div.innerHTML+="websocket连接成功！<br/>";
		}
		//注册事件，异步接收服务端消息
		ws.onmessage = function(event){
			console.info(event);
			var div = document.getElementById("div");
			div.innerHTML+=event.data+"<br/>"; //event.data为服务器返回的数据
		};
	}
	
	function send(){
		var msg = document.getElementById("msg").value;
		ws.send(msg);
		document.getElementById("msg").value = "";
		var div = document.getElementById("div");
		div.innerHTML+="client:"+msg+"<br/>";
	}
	
	function closeWS(){
		ws.close();
		var div = document.getElementById("div");
		div.innerHTML+="websocket连接关闭<br/>";
	}
	
</script>
</html>