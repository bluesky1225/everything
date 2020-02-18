<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 생성</title>
</head>
<body>
<%@ page import="java.net.*" %>
	<%
		Cookie cookie = new Cookie("message", URLEncoder.encode("한국", "UTF-8"));
		cookie.setMaxAge(10);
		response.addCookie(cookie);
		response.sendRedirect("cookieResult.jsp");
		
	%>

</body>
</html>