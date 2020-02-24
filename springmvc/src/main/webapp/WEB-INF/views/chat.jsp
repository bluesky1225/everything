<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅</title>
<style>
#chatbox {	
	width:250px;
	height:400px;
	background:orange;
}
#chatArea{
	width:240px;
	height:240px;
	overflow-y:auto;
	
	/*border:1px solid black;*/
}
#chatmessage{
	border-radius:5px;
}
#btn, #enter, #exit {
	border-radius:5px;
	background:red;
	color:white;
}
#back{margin-left:10px;}
</style>
</head>
<body>
<div align="center">
<div id="chatbox">
<div align="left" id="back"><a href="./">Back</a></div>
<h3>채팅 창</h3>
<div>
<label>이름</label>
<input type="text" id="nickname" size="5"/>
<input type="button" value="입장" id="enter"/>
<input type="button" value="나가기" id="exit"/>
</div>
<div>
</div>
<div id="chatArea">
<textarea cols="30" rows="15" id="chatmessages" readonly="readonly" id="chatmessagearea">
</textarea>
</div>
<div>
<input type="text" id="chatmessage"/>

<input type="button" value="전송" id="btn"/>
</div>

</div>
</div>
<script>
	// 웹소켓 변수
	var ws;
	
	// 변수에 이름을 기재하고 함수를 대입하면 
	// 이 함수를 만들고 난 후 뒤에서 사용 가능해집니다.
	// function 이름(매개변수) {}로 만들면 순성 상관없이 아무곳에서나 호출 가능
	
	// 문자열을 출력하는 함수
	var appendMessage = function(msg) {
		//document.getElementById("chatmessages").value = msg + "<br/>" 
		//+ document.getElementById("chatmessages").value;
		document.getElementById("chatmessages").value = document.getElementById("chatmessages").value + msg + '\n' ;
	}
	
	// 이벤트 처리 함수
	var onOpen = function() {
		appendMessage("연결 되었습니다.");
	}
	var onClose = function() {
		appendMessage("연결이 해제되었습니다.");
		ws.close();
	}
	var onMessage = function(e) {
		var data = e.data;
		var chatmessages = document.getElementById("chatmessages");
		chatmessages.value = chatmessages.value + data + "\r\n";
	}
	
	var send = function() {
		var nickname = document.getElementById("nickname").value;
		var msg = document.getElementById("chatmessage").value;
		ws.send(nickname + " : " + msg);
		document.getElementById("chatmessage").value = "";
	}
	
	// 웹소켓 연결 함수
	var connect = function() {
		// http://localhost:9000/chat-ws 자기 컴퓨터에서만 접속
		//ws = new WebSocket("ws://211.183.6.60:9000/chat-ws");
		ws = new WebSocket("ws://localhost:9000/db/chat-ws");
		// 이벤트 핸들러 연결
		ws.addEventListener("open", onOpen);
		ws.addEventListener("message", onMessage);
		ws.addEventListener("close", onClose);
	};
	
	var disconnect = function() {
		ws.close();
	}
	
	// message 입력란에서 키보드 이벤트가 발생하면
	document.getElementById("chatmessage").addEventListener("keypress", function(e){
		// enter 키를 누르면 send() 호출
		event = e || window.event;
		
		var keycode = (event.keyCode?event.keyCode:event.which);
		
		if(keycode == 13) { // 13 = enter의 keycode			
			send();
		}		
	});
	
	var btn = document.getElementById("btn");	
	var enter = document.getElementById("enter");
	var exit = document.getElementById("exit");
	
	btn.addEventListener("click", function(e) {
		send();
	});
	
	enter.addEventListener("click", function(e) {
		connect();
	});
	
	exit.addEventListener("click", function(e) {
		disconnect();
	});
</script>
</body>
</html>