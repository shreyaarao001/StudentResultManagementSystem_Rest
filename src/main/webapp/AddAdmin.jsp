<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Admin</title>
</head>
<script type="text/javascript">
	function msg() {
		if (document.getElementById("id").value.length == 0) {
			alert("please enter id!!");
			return false;
		}
		if (document.getElementById("name").value.length == 0) {
			alert("please enter name!!");
			return false;
		}

	}
</script>
<body style="text-align: center" bgcolor="#a3a3a3">
<form method="post" action="AdministratorServlet1?varname=addadmin" onsubmit="return msg()" >
<center>
<h1>ADD ADMIN</h1>
<br> <br> <br> 
<table>
<tr>
<td>id:</td>
<td><input type="text" name="id" id="id"></td>
</tr>
<tr>
<tr>
<td>name:</td>
<td><input type="text" name="name" id="name"></td>
</tr>
<tr>
<td></td>
<td><input  type="submit" value="submit"></td>
</tr>
</center>
</table>
</form>
</body>
</html>

