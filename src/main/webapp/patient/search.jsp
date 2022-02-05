<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/search.css">
<link rel="stylesheet" href="../css/form.css">
<link rel="stylesheet" href="../css/table.css">
</head>
<body>
	<header>
		<h1>Search Doctor</h1>
	</header>
	<main>
		<section class="formsec formsection">
			<form action="searchdoctor" method="get">
				<div class="formdiv">
					<label>Enter Doctor Department</label> <input type="text"
						name="dept" class="tb">
				</div>
				<div class="submitbtn">
					<input type="submit">
				</div>
				<div class=formlink>
					<a href="home">Click here for Home</a>
				</div>
			</form>
		</section>
		<%
		if(request.getAttribute("detail")!=null){ 
		ResultSet rs = (ResultSet)request.getAttribute("detail");
		int i=1;
		%>
		<section class="tabsec tablesec">
			<table>
				<thead>
					<tr>
						<th>Slno</th>
						<th>Doctor Name</th>
						<th>Doctor Username</th>
					</tr>
				</thead>
				<tbody>
					<%
					if(rs!=null)
					{
					%>
					<%while(rs.next()){ %>
					<tr>
						<td><%=i++ %></td>
						<td><%=rs.getString("name") %></td>
						<td><%=rs.getString("username") %></td>
					</tr>
					<%}} if(rs==null || i==1){ %>
					<tr>
						<td colspan="3">No Record Found</td>
					</tr>
					<%} %>
				</tbody>
			</table>
		</section>
		<%} %>
	</main>
</body>
</html>