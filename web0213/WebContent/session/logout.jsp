<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
<%
	// 세션 삭제
	//session.removeAttribute("id");
	//session.removeAttribute("nickname");
	session.invalidate();
	
	// 보통은 로그아웃시 메인페이지로 리다이렉트
	//response.sendRedirect("../index.jsp");
	
%>

<h3>로그아웃 하셨습니다.</h3>
<h4>5초 후에 메인 페이지로 이동합니다.</h4>
<script>
	// 5초후에 ../index.jsp로 이동
	setTimeout(function() {
		location.href="../index.jsp";
	}, 5000)
</script>
</body>
</html>