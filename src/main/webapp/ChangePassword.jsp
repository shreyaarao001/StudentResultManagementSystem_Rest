<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change password</title>
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
		if (document.getElementById("newpassword").value.length == 0) {
			alert("please enter password!!");
			return false;
		}

	}
</script>
<body bgcolor="#a3a3a3">
<form action="LoginServlet1?varname=change" method="POST" onsubmit="return msg()">
<h1>CHANGE PASSWORD</h1>
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
<td>new password:</td>
<td><input type="password" name="newpassword" id="newpassword"></td>
</tr>
<tr>
<td></td>
<td><input  type="submit" value="submit"></td>
 </table>
 </form>
<h3>Password should be of minimum length 8,
password should consists alphabets,numbers and atleast one special character,
The first character of the password should be alphabet
</h3>
</body>
</html>