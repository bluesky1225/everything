<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		int result = su1 + su2;
		
		out.println("두 수를 더한 결과 : "+result);
	%>
</body>
</html>