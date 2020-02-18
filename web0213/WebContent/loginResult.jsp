<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.net.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과</title>
</head>
<body>
	<%
		/*
		Cookie[] cookies = request.getCookies();
	
		if(cookies!=null && cookies.length > 0) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("id")) {
					out.println(URLDecoder.decode(cookie.getName()));
					out.println(URLDecoder.decode(cookie.getValue()+"님 로그인되었습니다."));
				}
			}
		}
		*/
		
		
	%>
	<a href="login.jsp">로그인</a>
</body>
</html>