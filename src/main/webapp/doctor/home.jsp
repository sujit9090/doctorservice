<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Service</title>
<link rel="stylesheet" href="../css/dochome.css">
<link rel="stylesheet" href="../css/table.css">
<script type="text/javascript">
	window.history.forward()
</script>
</head>
<body>
	<%
	ResultSet rs = (ResultSet) request.getAttribute("detail");
	int i = 1;
	%>
	<header>
		<h1>
			Welcome Dr.
			<%=request.getAttribute("name")%></h1>
	</header>
	<div class="logout">
	<% String cp = request.getContextPath(); %>
	<a href="<%=cp%>/logout">Logout </a>
		</div>
	<main>
		
		<section class="tablesec">
			<table>
				<thead>
					<tr>
						<th>Slno</th>
						<th>Patient Name</th>
						<th>Appointment Date</th>
						<th>Appointment time</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<%
					while (rs.next()) {
					%>
					<tr>
						<td><%=i++%></td>
						<td><%=rs.getString("name")%></td>
						<td><%=rs.getString("ap_date")%></td>
						<td><%=rs.getString("ap_time")%></td>
						<td>
						<%
							String qry1 = "approve?slno=";
							qry1+=rs.getInt("slno")+"&op=1";
							String qry2 = "approve?slno=";
							qry2+=rs.getInt("slno")+"&op=2";
						%>
						<a href="<%=qry1%>">Approved</a> 
						<a href="<%=qry2%>">Cancel</a></td>
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