<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style>
form {
	margin: 0 auto;
	width: 30%;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 10px;
	background-color: #f2f2f2;
}

label {
	display: inline-block;
	width: 30%;
	text-align: right;
	margin-right: 10px;
}

input[type=email], input[type=password] {
	width: 60%;
	padding: 5px;
	border: 1px solid #ccc;
	border-radius: 5px;
	margin-bottom: 10px;
	font-size: 16px;
}

input[type=submit] {
	background-color: #00BFFF;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
}

input[type=submit]:hover {
	background-color: gray;
}

.register-link {
	text-align: center;
	margin-top: 10px;
}

input[type=submit] {
	display: block;
	margin: 0 auto;
}

input[type=submit] {
	width: 50%;
	display: block;
	margin: 0 auto;
}
</style>
</head>
<body>
	<h1 style="text-align: center;">Login Form</h1>
	<form action="verifyLogin" method="post">
		<label for="email">Email:</label> <input type="email" id="email"
			name="email" placeholder="Email" required><br> <br>
		<label for="password">Password:</label> <input type="password"
			id="password" name="password" placeholder="Password" required><br>
		<br> <input type="submit" value="Login">
		<div class="register-link">
			Not registered? <a href="viewPage">Register/Sign up here</a> ${error }
		</div>
	</form>
</body>
</html>