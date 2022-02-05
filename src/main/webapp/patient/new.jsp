<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Service</title>
<link rel="stylesheet" href="../css/new.css">
<link rel="stylesheet" href="../css/form.css">
</head>
<body>
	<header>
		<h2>New Appointment</h2>
	</header>
	<main>
		<section class="formsection">
			<form action="newappointment" method="post">
				<div class="formdiv">
					<label>Enter Doctor Username</label> 
					<input type="text" name="username" class="tb">
				</div>
				<div class="formdiv">
					<label>Enter Appointment Date</label>
					 <input type="date" name="date" class="tb">
				</div>
				<div class="formdiv">
					<label>Enter Appointment Time</label>
					 <input type="time" name="time" class="tb">
				</div>
				<div class="submitbtn">
					<input type="submit">
				</div>
				<div class=formlink>
					<a href="home">Click here for Home</a>
				</div>
			</form>
			</section>
	</main>
</body>
</html>