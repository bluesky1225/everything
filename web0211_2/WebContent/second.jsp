<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h2>처음 만들어 본 JSP 파일</h2>
	<p>내용 수정</p>
	
	<%
		// 자바코드 작성
		int a = 10;
		int b = 5;
		int result = a + b;
	%>
	
	<h1>결과 : <%= result %></h1>
</body>
</html>