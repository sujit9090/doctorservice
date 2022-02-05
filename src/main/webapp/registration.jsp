<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Service</title>
<link rel="stylesheet" href="css/reg.css">
<link rel="stylesheet" href="css/form.css">
<script src="js/reg.js"></script>
</head>
<body>
	<header>
		<h1>WELCOME TO APPOINTMENT APPLICATION</h1>
	</header>
	<main>
		<section class="formsection">
			<form action="registration" method="post">
				<div class="formdiv">
				<div class="formdiv">
					<label>Enter name</label> <input type="text"
						name="name" class="tb">
				</div>
					<label>Enter username</label> <input type="text" name="username"
						class="tb">
				</div>
				<div class="formdiv">
					<label>Enter password</label> <input type="password"
						name="password" class="tb">
				</div>
				<div class="formdiv">
				<label>Select option</label>
				<select name="occuption" class="tb" onclick="abc()" id="sel">
					<option value="1" selected>Patient</option>
					<option value="2">Doctor</option>
				</select>
				</div>
				<div class="formdiv hide" id="dept" >
				<label>Enter Department</label>
				<input type="text" name="dept" class="tb">
				</div>
				<div class="formdiv">
					<label>Enter email</label> <input type="email" name="email"
						class="tb">
				</div>
				<div class="formdiv">
					<label>Enter phone number</label> <input type="number"
						name="phone" class="tb">
				</div>
				<div class="formdiv">
					<label>Enter Address</label> 
					<textarea rows="2" cols="14" name="address" class="tb"></textarea>
				</div>
				<div class="submitbtn">
					<input type="submit">
				</div>
				<div class=formlink>
					<a href="login.jsp">Click here for Login</a>
				</div>
			</form>
		</section>
	</main>
</body>
</html>