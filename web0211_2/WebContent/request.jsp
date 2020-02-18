<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리퀘스트 JSP</title>
</head>
<body>
	<h3>접속한 클라이언트의 IP : <%= request.getRemoteAddr() %></h3>
	<h3>컨텍스트 경로: <%= request.getContextPath() %></h3>
	<h3>전체요청 경로 : <%= request.getRequestURI() %></h3>
	
<%
	String requestURI = request.getRequestURI();
	String contextPath = request.getContextPath();
	
	String command = requestURI.substring(contextPath.length()+1, requestURI.length());
	
%>

<h3>전체 요청경로에서 contextPath를 제외한 부분 : <%= command %></h3>


</body>
</html>