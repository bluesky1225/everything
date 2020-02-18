<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="cookie.jsp">쿠키</a><br/>
	
	<a href="login.jsp">아이디 저장</a><br/>
	
	<a href="./webstorage/login.jsp">웹스토리지를 이용한 아이디 저장</a><br/>
	
	<a href="./javabean/register.jsp">회원가입</a>
	
	<div id="content">
	<%
	 
	Object id = session.getAttribute("id");
	Object nickname = session.getAttribute("nickname");
	
	if("root".equals(id)) {
		out.println("<p>"+nickname+"님 로그인되었습니다.</p>");
		out.println("<p><a href='./session/logout.jsp'>로그아웃</a></p>");
	} else {
		out.println("<a href='./session/login.jsp'>로그인</a><br/>");
	}
	%>
	</div>
	
</body>
</html>