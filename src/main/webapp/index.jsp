<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>

</head>
<script type="text/javascript">
	function msg() {
		if (document.getElementById("id").value.length == 0) {
			alert("please enter id!!");
			return false;
		}
		if (document.getElementById("password").value.length == 0) {
			alert("please enter password!!");
			return false;
		}

	}
</script>
<body  bgcolor="#a3a3a3">
<form action="LoginServlet1?varname=login" method="POST" onsubmit="return msg()" >
<center>
<h1>STUDENT RESULT MANAGEMENT SYSTEM</h1>
<br> <br> <br> 
<table>
<tr>
<td>id:</td>
<td><input type="text" name="id" id="id"></td>
</tr>
<tr>
<tr>
<td>password:</td>
<td><input type="password" name="password" id="password"></td>
</tr>
<tr>
<td></td>
<td><input  type="submit" value="submit"></td>
</tr>
 </table>
 
 </form>
 <a href="ChangePassword.jsp">Change Password</a>
 </center>
 
 
</body>
</html>






