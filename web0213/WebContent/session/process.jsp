<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");

if("root".equals(id) && "1234".equals(pw)) {
	session.setAttribute("id", id);
	session.setAttribute("nickname", "관리자");
	//session.setMaxInactiveInterval(10);
	
	response.sendRedirect("../index.jsp"); // 메인페이지
} else {
	session.setAttribute("message", "없는 아이디이거나 잘못된 비밀번호입니다.");
	response.sendRedirect("login.jsp");
}
%>

</body>
</html>