<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<body class="w3-light-grey">
<body background="resources/images/bg.jpg">
<title>Login</title>

</head>
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
</style>
<body>
<br/><br/><br/><br/><br/><br/>
	<form action="perform_login" method="post">
	<table align="center" width="40%">
		<tr bgcolor="black">
			<td colspan="2"><font color="white">Log In Here</font> </td>
		</tr>
		<tr bgcolor="gray">
		<td>Login</td><td><input type="text" name="username"/></td>
		</tr>
		<tr bgcolor="gray">
		<td>Password</td><td><input type="password" name="password"/></td>
		</tr>
		<tr bgcolor="gray">
		<td colspan="2">
		<input type="submit" value="login"/>
		</td>
		</tr>
	</table>
	</form>

</body>
</html>