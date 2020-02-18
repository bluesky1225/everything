<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포워드</title>
</head>
<body>
	<%
	System.out.println("처리");
	int result = Integer.parseInt(request.getParameter("first")) + Integer.parseInt(request.getParameter("second"));

	// 포워딩을 하는 경우 데이터 저장
	request.setAttribute("result", result);
	RequestDispatcher rd = request.getRequestDispatcher("forwardresult.jsp");
	//RequestDispatcher rd = request.getRequestDispatcher("forwardresult.jsp?result="+result);
	rd.forward(request, response);
	%>
</body>
</html>