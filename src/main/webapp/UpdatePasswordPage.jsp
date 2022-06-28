<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="UpdatePassword" method="post">
		Enter Email:<input type="text" name="email"><br /> 
		Enter Old Password:<input type="password" name="oldPassword"><br /> 
		Enter New Password:<input type="password" name="newPassword1"><br /> 
		Repeat Password:<input type="password" name="newPassword2"> <br /> 
		<input type="submit" value="Sublit">
	</form>
</body>
</html>