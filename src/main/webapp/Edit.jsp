<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
In Edit PAge
<%
String id = request.getParameter("id").toString();
System.out.println("In Edit page ==> id-->"+id);

String driver = "com.mysql.cj.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/javademo";
String userid = "root";
String password = "root@123";

try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<% 
try{
connection = DriverManager.getConnection(connectionUrl, userid, password);
statement=connection.createStatement();
String sql ="select * from cruddata where id="+id;
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>

<form method="post" action="UpdateUser">
<input type="hidden" name="id" value="<%=resultSet.getString("id") %>">

<br>
Update Email:<br>
<input type="text" name="email" value="<%=resultSet.getString("email") %>">
<br>
Update Name:<br>
<input type="text" name="name" value="<%=resultSet.getString("name") %>">
<br>
Update Address:<br>
<input type="text" name="address" value="<%=resultSet.getString("address") %>">
<br><br>
<input type="submit" value="submit">
</form>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>