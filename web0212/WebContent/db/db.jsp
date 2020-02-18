<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.sql.Connection" import="java.sql.DriverManager" import="java.sql.ResultSet" import="java.sql.PreparedStatement" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>DB</title>
</head>
<body>
<%@ page import="java.io.*, java.sql.*" %>
<%
 
try {
	// 드라이버 클래스 로드
	Class.forName("oracle.jdbc.driver.OracleDriver");
	System.out.println("오라클 드라이버 클래스 로드 성공");
	
	// 오라클 접속
	String dburl = application.getInitParameter("dburl");
	String id = application.getInitParameter("id");
	String pw = application.getInitParameter("pw");
	Connection con = DriverManager.getConnection(dburl, id, pw);
	//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@211.183.6.60:1521:xe", "user28", "user28");
	
	System.out.println("접속 성공");
	
	PreparedStatement ps = con.prepareStatement("select * from transactions");
	



ResultSet rs = ps.executeQuery();
List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

while(rs.next()) {
	Map<String, Object> map = new HashMap<String, Object>();
	
	map.put("num", rs.getInt("tCode"));
	map.put("itemcode", rs.getString("pCode"));
	map.put("itemname", rs.getString("pName"));
	map.put("price", rs.getInt("price"));
	map.put("cnt", rs.getInt("amount"));
	map.put("transdate", rs.getDate("tDate"));
	map.put("userid", rs.getString("tId"));
	list.add(map);
}

for(Map<String, Object> tempMap: list) {
	System.out.println(tempMap.get("num"));
%>

<%=tempMap.get("num")  %>
<%= tempMap.get("itemcode") %>
<%= tempMap.get("itemname") %>
<%=  tempMap.get("price")%>
<%=tempMap.get("cnt")  %>
<%= tempMap.get("transdate") %>
<%= tempMap.get("userid")%>

<%
}

ps.close();
//오라클 접속 해제
con.close();
} catch(Exception e) {
	System.out.println(e.getMessage());
	e.printStackTrace();
}

%>


</body>
</html>