<%@page import="ServletClass.CheckLoginData"%>
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
/* It will not allow to go back and access the page after logout */
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

%>
<% 
/* It will not allow to direct access this(Home) page without login  */
	String name = request.getAttribute("name").toString();
	if(name == null)
		response.sendRedirect("LoginPage.jsp");
%>	
<br>
<h3>In home page </h3><br>
Welcome ${name}
<a href="UpdatePasswordPage.jsp">Update Password</a>
<br>
<form action="Logout" method="post">
	<input type="submit" value="Logout">
</form>
</body>
</html>
