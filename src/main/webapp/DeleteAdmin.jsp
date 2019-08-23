<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Admin</title>
</head>
<script type="text/javascript">
	function msg() {
		if (document.getElementById("id").value.length == 0) {
			alert("please enter id!!");
			return false;
		}
	}
	</script>
<body bgcolor="#a3a3a3">
<form method="post" action="AdministratorServlet1?varname=delete_admin" onsubmit="return msg()">
<center>
<h1>DELETE ADMIN</h1>
<br> <br> <br> 
<table>
<tr>
<td>id:</td>
<td><input type="text" name="id" id="id"></td>
</tr>
    <tr>
<td></td>
<td><input  type="submit" value="submit"></td>
</tr>
 </table>
 </center>
</form>
</body>
</html>