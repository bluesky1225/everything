<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.net.*" pageEncoding="UTF-8"%>
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
	String idsave = request.getParameter("idsave");
	
	Cookie cookie = new Cookie(URLEncoder.encode("id", "utf-8"), URLEncoder.encode(request.getParameter("id"), "utf-8"));
	
	if("idsave".equals(request.getParameter("idsave"))) {
		cookie.setMaxAge(10);
		response.addCookie(cookie);
	} else {
		cookie.setMaxAge(0);
	}
	
	response.sendRedirect("loginResult.jsp");
%>
</body>
</html>