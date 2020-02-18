<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
    request.setCharacterEncoding("UTF-8");

	String [] messages =null; 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
<link rel="stylesheet" href="./../resources/css/index.css" />

</head>
<body>
<script>
	//var setCookie = function(name, value, exp) {
	//	var date = new Date();
	//	date.setTime(date.getTime() + exp*24*60*60*1000);
	//	document.cookie = name + '=' + value + ';expires=' + date.toUTCString() + ';path=/';
	//};
	//var getCookie = function(name) {
	//	var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
	//	return value? value[2] : null;
	//};
	function chat(e) {
		var div = document.getElementById("chat_window");
		div.style.top="100px";
		div.style.left="100px";
	}
	/*
	function chat_send(e) {
		var cookie = document.cookie;
		
		if(cookie.length > 0) {
			var cnt = cookie.length;
			setCookie("message"+cnt, form.message.value, 1);
		} else {
			setCookie("message0", form.message.value, 1);
		}	
		
		var messages = "";
		var chat_input = document.getElementById("message");
		
		for(var i=0; i<cookie.length; i++) {
			messages = messages + getCookie("message"+i) + "\n";	
		}
		
		chat_input.value=messages;
	}
	*/
	function chat_close(e) {
		var div = document.getElementById("chat_window");
		div.style.top="-500px";
		div.style.left="20px";
		var chat_input = document.getElementById("message");
		chat_input.value="";
	}
</script>
	<div class="menu">메뉴1</div>
	<div class="menu">메뉴2</div>
	<div class="menu">메뉴3</div>
	<div class="menu">메뉴4</div>
	<div class="menu">메뉴5</div>
	
	<br/>
	<div id="background">
		<table id="products" align="left">
		<tr>
		<td>
		<div class="product">New Product</div>
		</td>
		<td>
		<div class="product"></div>
		</td>
		</tr>
		<tr>
		<td>
		<div class="product">Product1</div>
		<!-- <div class="product_title">Product1</div>
		<div class="product_content"></div> -->
		</td>
		<td>
		<div class="product">Product2</div>
		</td>
		</tr>
		<tr>
		<td>
		<div class="product">Product3</div>
		</td>
		<td>
		<div class="product">Product4</div>
		</td>
		</tr>
		<tr>
		<td>
		<div class="product">Product5</div>
		</td>
		<td>
		<div class="product">Product6</div>
		</td>
		</tr>
		</table>
		<div id="video">
		<table>
		<tr>
		<td>
		<a href="https://www.youtube.com/watch?v=GovPXDGdNCE" target="video_content"><div class="tabs">딥러닝</div></a>
		</td>
		<td>
		<a href="https://www.youtube.com/watch?v=eIrMbAQSU34" target="video_content"><div class="tabs">자바</div></a>
		</td>
		<td>
		<a href="https://www.youtube.com/watch?v=Bacf3wTY2EQ" target="video_content"><div class="tabs">C언어</div></a>
		</td>
		</tr>
		</table>
		<iframe name="video_content" width="600" height="600" src="">
		</iframe>
		</div>
	</div>
	
	<div id="qa">
		<div id="qa_title">
			리셉션 데스크
		</div>
		<div id="qa_content">		 
			<div class="qa_buttons">회사소개</div>
			<div class="qa_buttons">제품소개</div>
			<a href="application.html"><div class="qa_buttons">문의하기</div></a>
			<a href="#" onclick="chat(event)"><div class="qa_buttons">실시간 상담</div></a>
		</div>
	</div>
	<form name="form" action="./chat.jsp" method="post" target="hidden_frame2">
	<div id="chat_window">
		<a href="#" onclick="chat_close(event)"><div id="chat_title">close</div></a>
		<div id="chat">
			<iframe name="hidden_frame2" id="hif2" width="400" height="300" src="">
			</iframe>
		</div>
		<div id="chat_input">
		&nbsp;			
			<input type="text" id="message" name="message" size="40" />
			<input type="submit" onclick="chat_send(event)" value="전송"/>			
		</div>
	</div>
	</form>
	
	<!-- 삭제 -->
	<div id="hidden">
		<iframe name="hidden_frame" id="hif" width="100" height="100" src="">
		</iframe>
	</div>
</body>
</html>