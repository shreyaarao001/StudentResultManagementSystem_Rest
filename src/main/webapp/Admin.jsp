<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN</title>
<style type="text/css">
#an{
align:center;
}
body{
color:white;
text-align:center;
background-size:cover;
}

</style>
</head>
<body bgcolor="#a3a3a3">


<br> <br> <br>
<table>
<h1>WELCOME</h1>
<h3 id="an"><a href="AdministratorServlet1?varname=add"  style="color:red">Add Admin</a></h3>
<h3 id="an"><a href="AdministratorServlet1?varname=student" style="color:red">Add student</a></h3>
<h3 id="an"><a href="AdministratorServlet1?varname=view_user" style="color:red">View all users</a></h3>
<h3 id="an"><a href="ViewGrade.jsp" style="color:red">View Grades</a></h3>
<h3 id="an"><a href="AdministratorServlet1?varname=deleteadmin" style="color:red">Delete Admin</a></h3>
<h3 id="an"><a href="AdministratorServlet1?varname=deleteuser" style="color:red">Delete User</a></h3>
</table>

</body>
</html>