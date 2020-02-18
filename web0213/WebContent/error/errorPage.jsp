<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 페이지</title>
<style>
#error {
	color:red;
	background-color:papayawhip;
}
</style>
</head>
<body>
	<div id="error">
	에러 타입 <%= exception.getClass().getName() %><br/>
	에러 메시지 <%= exception.getMessage() %><br/>
	값이 잘못 되었네요. 숫자를 입력해주세요.
	</div>
</body>
</html>