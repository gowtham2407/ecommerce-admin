<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Admin</title>
</head>
<body>
	<h1>Admin Login</h1>
	<form action="/home.com/login" method="post">
		<div>
			<label for="email">email:</label><input type="text" id="email"
				name="email" required><br>
		</div>
		<div>
			<label for="password">password:</label><input type="password"
				id="password" name="password" required>
		</div>
		<div>
			<input type="submit" value="Login">
		</div>
	</form>
</body>
</html>