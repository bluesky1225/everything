<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키를 읽어서 출력해보자</title>
</head>
<body>
<%@ page import="java.net.*" %>
<%
	// request.setCharacterEncoding("UTF-8");
	Cookie[] cookies = request.getCookies();
%>
<%
	if(cookies != null && cookies.length > 0) {
		for(int i=0; i<cookies.length; i++) {
%>
			<%= cookies[i].getName() %><br/>
		
<%
			if(cookies[i].getName().equals("message")) {
%>
				<%= URLDecoder.decode(cookies[i].getValue(), "UTF-8") %>
<%
			}
		}
	}

%>
</body>
</html>