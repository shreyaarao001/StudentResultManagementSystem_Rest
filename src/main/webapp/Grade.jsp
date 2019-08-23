<%@ page
	import="java.sql.*,java.util.*,javax.ws.rs.client.Client,entity.*,
 javax.ws.rs.client.ClientBuilder,
 javax.ws.rs.client.Entity,
 javax.ws.rs.client.Invocation,
 javax.ws.rs.client.WebTarget,
 javax.ws.rs.core.MediaType,
 javax.ws.rs.core.Response,entity.*,org.glassfish.jersey.client.ClientConfig"
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Users</title>
</head>
<style>
body {
	border-style: solid;
	border-width: medium;
	
}

h1 {
	text-align: center;
	color: black
}
</style>
<body bgcolor="#a3a3a3">
	<h1>List of Users</h1>
	<br>
	<br>
	<form method="post">
		<table border="1" align="center">
			<thead>
				<tr>

					<th>User_ID</th>
					<th>Maths</th>
					<th>Physics</th>
					<th>Chemistry</th>
					<th>Total</th>
					<th>Grade</th>
				</tr>
			</thead>


			<%
				ArrayList<Student_Info> list = (ArrayList<Student_Info>)request.getAttribute("view_grade");
				for (Student_Info student_info : list) {
			%>
			<tr>

				<td><%=student_info.getId()%></td>
				<td><%=student_info.getMaths()%></td>
				<td><%=student_info.getPhysics()%></td>
				<td><%=student_info.getChemistry()%></td>
				<td><%=student_info.getTotal()%></td>
				<td><%=student_info.getGrade()%></td>
			</tr>
			<%
				}
			%>

		</table>
</body>
</html>