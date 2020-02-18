<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forwarding과 Redirect</title>
</head>
<body>	
	<h3>결과 페이지로 포워딩</h3>
	<form action="forward.jsp">
		수1:<input type="text" size="10" name="first"/><br/>
		수2:<input type="text" size="10" name="second"/><br/>
		<input type="submit" value="더하기" />
	</form>
	
	<h3>결과 페이지로 리다이렉트</h3>
	<form action="redirect.jsp">
		수1:<input type="text" size="10" name="first"/><br/>
		수2:<input type="text" size="10" name="second"/><br/>
		<input type="submit" value="더하기" />
	</form>
</body>
</html>