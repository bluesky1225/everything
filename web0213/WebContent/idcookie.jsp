<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 저장</title>
</head>
<body>
<%
	Cookie cookie = new Cookie(URLEncoder.encode("id"), URLEncoder.encode(request.getParameter("id"), "utf-8"));
	
	if("checked".equals(request.getParameter("idsave"))) {
		cookie.setMaxAge(10);
		response.addCookie(cookie);
	} else {
		cookie.setMaxAge(0);
	}
	
	response.sendRedirect("loginResult.jsp");
%>
</body>
</html>