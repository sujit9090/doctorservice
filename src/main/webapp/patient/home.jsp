<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Service</title>
<link rel="stylesheet" href="../css/pathome.css">
<link rel="stylesheet" href="../css/table.css">
</head>
<body>
	<%
	ResultSet rs = (ResultSet) request.getAttribute("detail");
	int i = 1;
	%>
	<header>
		<h1>
			Welcome
			<%=request.getAttribute("name")%></h1>
	</header>
	<div class="logout">
	<% String cp = request.getContextPath(); %>
	<a href="<%=cp%>/logout">Logout </a>
		</div>
	<main>
		<div class="btnblock">
			<a href="new.jsp">New Appointment</a>
			<a href="search.jsp">Search Doctor</a>
		</div>
		<section class="tablesec">
			<table>
				<thead>
					<tr>
						<th>Slno</th>
						<th>Doctor name</th>
						<th>Doctor Dept.</th>
						<th>Appointment Date</th>
						<th>Appointment Time</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<%
					while (rs.next()) {
					%>
					<tr>
						<td><%=i++%></td>
						<td><%=rs.getString("name")%></td>
						<td><%=rs.getString("dept")%></td>
						<td><%=rs.getString("ap_date")%></td>
						<td><%=rs.getString("ap_time")%></td>
						<%
						int st = rs.getInt("status");
						String msg = "", classes = "";
						if (st == 0) {
							msg = "Yet to confirmed";
							classes = "pink";
						} else if (st == 1) {
							msg = "Approved";
							classes = "green";
						} else {
							msg = "Cancelled";
							classes = "red";
						}
						%>
						<td class="<%=classes %>"><%=msg %></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</section>
	</main>
</body>
</html>