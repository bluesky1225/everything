<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터</title>
</head>
<body>
<%@ page import="java.io.*, java.sql.*" %>
	<%
		// 오늘 날짜를 문자열로 생성
		long d = System.currentTimeMillis();
		// java.sql.Date는 날짜만 저장하고 toString을 호출하면 날짜만 문자열로 리턴합니다
		Date today = new Date(d);
		String filename = today.toString();
		
		// 파일에 기록할 수 있는 객체를 생성 (파일이 존재시 뒤에 이어붙이기 a)
		PrintWriter pw = new PrintWriter(new FileOutputStream("C:\\Users\\admin\\Desktop\\"+filename + ".log", true));
		
		// 접속한 ip 주소가져오기
		String ipAddress = request.getRemoteAddr();
		
		// 요청한 url 가져오기 - 전체 경로 요청
		String requestURI = request.getRequestURI();
		
		//루트경로
		String contextPath = request.getContextPath();
		
		// 전체요청경로에서 루트 경로 제외하기
		String url = requestURI.substring(contextPath.length()+1);
		
		// 파일에 기록
		pw.println(ipAddress + "-" + url + "\n");
		pw.flush();
		pw.close();
	%>
<%
	String title = request.getParameter("title");
	String content = request.getParameter("content");
%>
<h1>
파람인풋
</h1>
<h3>
제목 : <%= title %>
</h3>
<h3>
내용 : <%= content %>
</h3>

<p/>
<h3>GET방식</h3>
<form action="./get.jsp" method="get">
	이름:<input type="text" name="name"/><br/>
	취미:<input type="checkbox" name="hobby" value="game"/>게임<br/>
	<input type="checkbox" name="hobby" value="reading"/>독서<br/>
	<input type="checkbox" name="hobby" value="billiard"/>당구<br/>
	나이:<select name="age">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
	</select><br/>
	<input type="submit" value="전송"/><br/>
	</form>
	<br/>
<h3>POST 방식</h3>
	<form action="./post.jsp" method="post">
	비밀번호:<input type="password" name="pw"/><br/>
	남길 말:<textarea name="message" rows="5" cols="20"></textarea><br/>
	<input type="submit" value="전송"/><br/>
	</form>
</body>
</html>