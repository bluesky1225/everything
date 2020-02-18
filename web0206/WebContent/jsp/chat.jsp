<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, java.net.URLEncoder" pageEncoding="UTF-8"%>

<%! //String message = null; %>

<%
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
	Cookie cookie = new Cookie("message", URLEncoder.encode(request.getParameter("message"), "UTF-8"));
	cookie.setMaxAge(60*60);
	response.addCookie(cookie);

%>
<% 
	//response.sendRedirect("./chatResult.jsp"); 

// forward로
RequestDispatcher dispatcher = request.getRequestDispatcher("./chatResult.jsp");
dispatcher.forward(request, response);


%>
</body>
</html>

<!--  
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
}
-->