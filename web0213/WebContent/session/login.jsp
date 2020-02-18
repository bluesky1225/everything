<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 테스트</title>
<style>
#disp{
	color:red;
}

</style>
</head>
<body>
<%
	// 세션에서 message 키의 값을 가져옵니다.
	Object message = session.getAttribute("message");
	
	// 값이 있다면 div를 만들어서 출력하고 삭제
	if(message!=null) {
		out.println("<div id='disp'>" + message + "</div>");
		session.removeAttribute("message");
	}
%>

	<form action="./process.jsp" method="post">
		<label for="id">아이디</label>
		<input type="text" name="id" required="required"  /><br/>
		
		<label for="pw">비밀번호</label>
		<input type="password" name="pw" required="required" /><br/>
		
		<input type="submit" value="로그인"/>
	</form>
</body>
</html>