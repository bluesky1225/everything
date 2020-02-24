<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>${msg}</div>
<form method="post" id="loginform">
<h3>로그인</h3>
<label for="myid">아이디</label>
<input type="text" name="myid" id="myid" required="required"/><br/>
<label for="mypw">비밀번호</label>
<input type="password" name="mypw" id="mypw" required="required"/><br/>
<input type="submit" value="확인"/>
</form>
</body>
</html>