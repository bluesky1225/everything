<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	request.setCharacterEncoding("UTF-8");
	
	Cookie[] cookies = request.getCookies();
	
	// 아이디와 체크박스에 출력할 문자열 변수
	String id = "";
	String check = "";
	
	// 쿠키가 1개라도 있다면
	if(cookies != null) {
		// 쿠키를 순회하면서 쿠키의 이름이 id인 것을 찾습니다
		for(Cookie cookie:cookies) {
			// 쿠키의 이름이 id라면 그때 값을 id변수에 저장
			// check에 체크박스 체크 여부 저장
			if(cookie.getName().equals("id")) {
				id = java.net.URLDecoder.decode(cookie.getValue(), "UTF-8");
				System.out.println(id);
				check = "checked='checked'";
				break;
			}
		}
	}
	
	%>
	<form action="./loginProcess.jsp" method="post">
		<label for="id">아이디</label>
		<input type="text" name="id" required="required" value="<%= id %>" /><br/>
		<label for="pw">비밀번호</label>
		<input type="password" name="pw" required="required" /><br/>
		<input type="checkbox" name="idsave" value="idsave" required="required" <%=check %>/>아이디 저장<br/>
		
		<input type="submit" value="전송"/>
	</form>
</body>
</html>