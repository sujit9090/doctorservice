<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Service</title>
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/form.css">

</head>
<body>
	<header>
		<h1>WELCOME TO APPOINTMENT APPLICATION</h1>
	</header>
	<main>
	<% if(request.getParameter("login")!=null){ %>
		<h2 class="red">Login Failed</h2>
	<%} %>	
	<% if(request.getParameter("reg")!=null){ %>
		<h2 class="green">Successfully Registered</h2>
	<%} %>
		<section class="formsection">
			<form action="login" method="post">
				<div class="formdiv">
					<label>Enter Username</label> 
					<input type="text" name="username" class="tb">
				</div>
				<div class="formdiv">
					<label>Enter password</label>
					 <input type="password" name="password" class="tb">
				</div>
				<div class="submitbtn">
					<input type="submit">
				</div>
				<div class=formlink>
					<a href="registration.jsp">Click here for Registration</a>
				</div>
			</form>
		</section>
	</main>


</body>
</html>