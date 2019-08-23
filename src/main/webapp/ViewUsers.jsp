<%@ page import="java.sql.*,java.util.*,javax.ws.rs.client.Client,entity.*,
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
	background-color:pink;
}
import java.util.Random;
public class Validate {
   	public static String generatePassword()
   	{
   		int n=9;
   		String x;
		final Random RANDOM = new Random();
	    String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	    String digits="0123456789";
	    String splchar="@!#$%&*?+-";
		StringBuilder returnValue = new StringBuilder(n);
	    for (int i = 0; i < 4; i++) {
	        returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
	    }
	    returnValue.append(digits.charAt(RANDOM.nextInt(digits.length())));
	    returnValue.append(splchar.charAt(RANDOM.nextInt(splchar.length())));
	    returnValue.append(digits.charAt(RANDOM.nextInt(digits.length())));
	    returnValue.append(splchar.charAt(RANDOM.nextInt(splchar.length())));
	    x=returnValue.toString();
		return x;
   	}
   
}
h1 {
	text-align: center;
	color: black
}
</style>
<body>
	<h1>List of Users</h1>
	<br>
	<br>
	<form method="get">
		<table border="1" align="center">
			<thead>
				<tr>

					<th>User_ID</th>
					<th>User_Name</th>
					<th>Role</th>
				</tr>
			</thead>
			
			
			<%
			ArrayList<User_Auth> list = (ArrayList<User_Auth>) request.getAttribute("user_review");
			for(User_Auth user: list){
				%>
			<tr>

				<td><%= user.getId()%></td>
				<td><%=user.getName() %></td>
				<td><%= user.getUser_type()%></td>
			</tr>
			<%
			}
			%>

		</table>
</body>
</html>