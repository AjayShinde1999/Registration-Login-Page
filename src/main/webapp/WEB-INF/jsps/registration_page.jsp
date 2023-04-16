<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<style>
form {
	margin: 0 auto;
	width: 40%;
	padding: 10px;
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

input[type=text], input[type=email], input[type=password] {
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

.login-link {
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
	<h1 style="text-align: center;">Registration</h1>
	<form action="saveReg" method="post">
		<label for="firstName">First Name:</label> <input type="text"
			id="firstName" name="firstName" required
			placeholder="Enter first name"><br> <br> <label
			for="lastName">Last Name:</label> <input type="text" id="lastName"
			name="lastName" required placeholder="Enter last name"><br>
		<br> <label for="email">Email:</label> <input type="email"
			id="email" name="email" required placeholder="Enter email address"><br>
		<br> <label for="password">Password:</label> <input
			type="password" id="password" name="password" required
			placeholder="Enter password"><br> <br> <input
			type="submit" value="Register">

		<div class="login-link">
			Already registered? <a href="loginPage">Login here</a>
			${msg }
		</div>
		
	</form>
</body>
</html>